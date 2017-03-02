package com.fanyafeng.brokenlineview.view;
import java.util.List;

import android.graphics.RectF;

/**
 * 把数据转化为各种坐标的类
 *
 */
public class LineChartPositionManager implements LineChartPositionInterface
{
    private LineChartView view;
    private List<CoordinateValue> data;
    private float normalMin, normalMax;

    /** 以坐标轴为边界,整个坐标轴矩形,所在边界的左上右下.单位:view宽高的百分比 */
    private float axisLeft = 0.15f, axisTop = 0.05f, axisRight = 0.1f,
            axisBottom = 0.1f;

    /**View底部,在坐标系y轴中,对应的实数*/
    private double realNumAtViewBottom;

    /**View顶部,在坐标系y轴中,对应的实数*/
    private double realNumAtViewTop;

    public LineChartPositionManager(LineChartView view)
    {
        this.view = view;
    }

    public void setData(List<CoordinateValue> data, float normalMin,
                        float normalMax)
    {
        this.data = data;
        this.normalMax = normalMax;
        this.normalMin = normalMin;

        double max = normalMax;// 所有数据最大值
        double min = normalMin;// 所有数据最小值
        for (CoordinateValue item : data)
        {
            min = Math.min(min,item.checkResult);
            max = Math.max(max,item.checkResult);
        }


//        float paddingTop = 0.1f;
//        float paddingBottom = 0.1f;
//        float paddingTopAndBottom = paddingTop + paddingBottom;// "坐标轴内部",上下留白的空间,是(max
//        // -
//        // min)的百分之多少
//
//        FloatPoint[] yAxis = getAxisYLine();
//        // 每100%(1.0)View高度,对应的实数是多少
//        double scale = (max - min) * (1 + paddingTopAndBottom)
//                / (yAxis[1].y - yAxis[0].y);
//
//        double axisBottomY = min - (max - min) * paddingBottom;// 坐标轴底部对应实数,即y轴圆点y值
//        realNumAtViewBottom = axisBottomY - axisBottom * scale;
//        realNumAtViewTop = max + (max - min) * paddingTop + axisTop * scale;
        FloatPoint[] yAxis=getAxisYLine();
        double bottomRealNum=min-min*0.5f;
        double topRealNum=max+min*0.5f;
        double scale=(topRealNum-bottomRealNum)/(yAxis[1].y-yAxis[0].y);
        realNumAtViewBottom=bottomRealNum-axisBottom*scale;
        realNumAtViewTop=topRealNum+axisTop*scale;

        if(view != null)
        {
            view.invalidate();
        }
    }

    /** 实际数据转化为View内坐标百分比 */
    private float converRealNumToFloat(double realNum)
    {
        float res = (float)((realNum - realNumAtViewBottom)/(realNumAtViewTop - realNumAtViewBottom));

        return res;
    }

    /** 取x轴刻度间距 */
    private float getXAxisDistance()
    {
        FloatPoint[] ps = getAxisXLine();
        float totalLength = ps[1].x - ps[0].x;
        float markDistance = totalLength / (data.size() + 0.6f);
        return markDistance;
    }

    @Override
    public FloatPoint[] getPoint()
    {
        FloatPoint[] ps = getAxisXLine();
        float distance = getXAxisDistance();
        FloatPoint[] res = new FloatPoint[data.size()];
        for (int i = 0; i < data.size(); i++)
        {
            res[i] = new FloatPoint(ps[0].x + (i + 1) * distance,
                    converRealNumToFloat(data.get(i).checkResult),
                    data.get(i).checkResult + "");
        }
        return res;
    }

    @Override
    public FloatPoint[] getAxisXLine()
    {
        FloatPoint p0 = new FloatPoint(axisLeft,axisBottom,"");
        FloatPoint p1 = new FloatPoint(1 - axisRight,axisBottom,"");
        return new FloatPoint[]
                {p0,p1};
    }

    @Override
    public FloatPoint[] getAxisYLine()
    {
        FloatPoint p0 = new FloatPoint(axisLeft,axisBottom,"");
        FloatPoint p1 = new FloatPoint(axisLeft,1 - axisTop,"");
        return new FloatPoint[]
                {p0,p1};
    }

    @Override
    public String[] getXAxisTickMarkText()
    {
        String[] res = new String[data.size()];
        for (int i = 0; i < data.size(); i++)
        {
            res[i] = data.get(i).regDate;
        }
        return res;
    }

    @Override
    public float[] getXAxisTickMarkPosition()
    {
        FloatPoint[] ps = getAxisXLine();
        float markDistance = getXAxisDistance();
        float[] res = new float[getXAxisTickMarkText().length];
        for (int i = 0; i < res.length; i++)
        {
            res[i] = ps[0].x + markDistance * (i + 1);
        }
        return res;
    }

    @Override
    public RectF getNormalRect()
    {
        float left = getAxisYLine()[0].x;
        float right = getAxisXLine()[1].x;
        RectF rect = new RectF(left,converRealNumToFloat(normalMax),right,
                converRealNumToFloat(normalMin));
        return rect;
    }

    @Override
    public String getNormalMin()
    {
        return normalMin + "";
    }

    @Override
    public String getNormalMax()
    {
        return normalMax + "";
    }

}
