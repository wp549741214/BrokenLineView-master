package com.fanyafeng.brokenlineview.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import com.fanyafeng.brokenlineview.view.LineChartPositionInterface;


public class LineChartView extends View {
    private LineChartPositionInterface lineChartInterface = null;

    /**
     * x轴颜色
     */
    private int colorXAxis = 0xff343434;

    /**
     * y轴 颜色
     */
    private int colorYAxis = 0xff343434;

    /**
     * x轴线条粗细(单位像素)
     */
    private int strokeWidthXAxis = 1;

    /**
     * y轴线条粗细(单位像素)
     */
    private int strokeWidthYAxis = 1;

    /**
     * x轴刻度文字颜色
     */
    private int XAxisTickMarkTextColor = 0xff343434;

    /**
     * 折线颜色
     */
    private int chartLineColor = 0xff343434;

    /**
     * 折线线条粗细
     */
    private int chartLineStrokeWidth = 1;

//    public LineChartView(Context context, AttributeSet attrs, int defStyleAttr,
//                         int defStyleRes)
//    {
//        super(context,attrs,defStyleAttr,defStyleRes);
//    }

    public LineChartView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        // TODO Auto-generated constructor stu
    }

    public LineChartView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public LineChartView(Context context) {
        super(context);
    }

    /**
     * 设置坐标轴点定义接口
     */
    public void setLineChartPositionInterface(
            LineChartPositionInterface lineChartInterface) {
        this.lineChartInterface = lineChartInterface;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawAxis(canvas);
        drawNormalRect(canvas);
        drawXAxisTickMarks(canvas);
        drawDotsAndLines(canvas);
    }

    /**
     * 画坐标轴
     */
    private void drawAxis(Canvas canvas) {
        int dip5 = dip2px(5f);
        Paint axisPaint = new Paint();
        axisPaint.setStrokeWidth(strokeWidthXAxis);
        axisPaint.setColor(colorXAxis);
        LineChartPositionInterface.FloatPoint[] xAxisLinePoints = lineChartInterface.getAxisXLine();
        int xAxisX0 = convertXPercent(xAxisLinePoints[0].x);// x轴起始点x坐标
        int xAxisY0 = convertYPercent(xAxisLinePoints[0].y);// x轴起始点y坐标
        int xAxisX1 = convertXPercent(xAxisLinePoints[1].x);// x轴终点x坐标
        int xAxisY1 = convertYPercent(xAxisLinePoints[1].y);// x轴终点y坐标
        // 画x坐标轴直线
        canvas.drawLine(xAxisX0, xAxisY0, xAxisX1, xAxisY1, axisPaint);
        // 画x坐标轴箭头
        canvas.drawLine(xAxisX1, xAxisY1, xAxisX1 - dip5, xAxisY1 - dip5, axisPaint);
        // 画x坐标轴箭头
        canvas.drawLine(xAxisX1, xAxisY1, xAxisX1 - dip5, xAxisY1 + dip5, axisPaint);

        axisPaint.setStrokeWidth(strokeWidthYAxis);
        axisPaint.setColor(colorYAxis);
        LineChartPositionInterface.FloatPoint[] yAxisLinePoints = lineChartInterface.getAxisYLine();
        int yAxisX0 = convertXPercent(yAxisLinePoints[0].x);// y轴起始点x坐标
        int yAxisY0 = convertYPercent(yAxisLinePoints[0].y);// y轴起始点y坐标
        int yAxisX1 = convertXPercent(yAxisLinePoints[1].x);// y轴终点x坐标
        int yAxisY1 = convertYPercent(yAxisLinePoints[1].y);// y轴终点y坐标
        // 画y坐标轴直线
        canvas.drawLine(yAxisX0, yAxisY0, yAxisX1, yAxisY1, axisPaint);
        // 画y坐标轴箭头
        canvas.drawLine(yAxisX1, yAxisY1, yAxisX1 - dip5, yAxisY1 + dip5, axisPaint);
        // 画y坐标轴箭头
        canvas.drawLine(yAxisX1, yAxisY1, yAxisX1 + dip5, yAxisY1 + dip5, axisPaint);

        axisPaint = null;
    }

    private void drawNormalRect(Canvas canvas) {
        RectF rect = lineChartInterface.getNormalRect();

        int left = convertXPercent(rect.left);
        int top = convertYPercent(rect.top);
        int right = convertXPercent(rect.right);
        int bottom = convertYPercent(rect.bottom);

        Paint paint = new Paint();
        paint.setStyle(Style.STROKE);
        paint.setStrokeWidth(dip2px(2f));
        paint.setColor(0xff03a34e);
        canvas.drawLine(left, bottom, left, top, paint);

        paint.reset();
        paint.setStyle(Style.FILL);
        paint.setColor(0x5000ff00);

        canvas.drawRect(left, top, right, bottom, paint);

        paint.setStyle(Style.STROKE);
        paint.setTextAlign(Align.CENTER);
        paint.setTextSize(24);
        paint.setColor(0xff343434);
        canvas.drawText(lineChartInterface.getNormalMax(), left / 2,
                top - paint.getFontMetrics().top / 2, paint);
        canvas.drawText(lineChartInterface.getNormalMin(), left / 2,
                bottom - paint.getFontMetrics().top / 2, paint);

        paint = null;
    }

    /**
     * 画x轴刻度及刻度文字
     */
    private void drawXAxisTickMarks(Canvas canvas) {
        float[] marks = lineChartInterface.getXAxisTickMarkPosition();
        String[] markTexts = lineChartInterface.getXAxisTickMarkText();
        float axisYPosY = lineChartInterface.getAxisYLine()[0].y;
        float dotRadius = 5f;// x轴刻度小圆点的半径
        Paint tickMarkPaint = new Paint();

        for (int i = 0; i < marks.length; i++) {
            float mark = marks[i];
            String markText = markTexts[i];

            tickMarkPaint.setColor(colorXAxis);// 画刻度小圆点
            tickMarkPaint.setStyle(Style.FILL);
            canvas.drawCircle(convertXPercent(mark), convertYPercent(axisYPosY),
                    dotRadius, tickMarkPaint);

            tickMarkPaint.setColor(XAxisTickMarkTextColor);// 画刻刻度文字
            tickMarkPaint.setStyle(Style.STROKE);
            tickMarkPaint.setTextAlign(Align.CENTER);
            tickMarkPaint.setTextSize(24f);
            canvas.drawText(markText, convertXPercent(mark),
                    convertYPercent(axisYPosY) + (getHeight() - convertYPercent(axisYPosY)) / 2
                            - tickMarkPaint.getFontMetrics().top / 2,
                    tickMarkPaint);
        }
        tickMarkPaint = null;
    }

    /**
     * 画数据点以及点之间的连线
     */
    private void drawDotsAndLines(Canvas canvas) {
        int axisXPos = convertYPercent(lineChartInterface.getAxisXLine()[0].y);
        LineChartPositionInterface.FloatPoint[] points = lineChartInterface.getPoint();
        RectF normal = lineChartInterface.getNormalRect();
        Paint dotPaint = new Paint();
        Paint smallDot=new Paint();
        Paint bigDot=new Paint();
        smallDot.setFlags(Paint.ANTI_ALIAS_FLAG);
        smallDot.setStrokeWidth(chartLineStrokeWidth);
        smallDot.setStyle(Style.FILL);
        smallDot.setColor(Color.WHITE);
        bigDot.setFlags(Paint.ANTI_ALIAS_FLAG);
        bigDot.setStrokeWidth(chartLineStrokeWidth);
        bigDot.setStrokeWidth(dip2px(1f));
        bigDot.setStyle(Style.FILL);
        dotPaint.setStyle(Style.STROKE);
        int dotRadius = dip2px(10f);

        DashPathEffect pathEffect = new DashPathEffect(new float[]
                {dip2px(2f), dip2px(2f)}, 1);
        for (int j = 0; j < points.length; j++) {// 循环画折线
            dotPaint.reset();
            LineChartPositionInterface.FloatPoint point = points[j];
            if (j - 1 >= 0 && points[j - 1].y >= 0) {// 如果这个点紧邻的前一位有点,则话线和前一个点相连
                dotPaint.setColor(chartLineColor);
                dotPaint.setStyle(Style.STROKE);
                dotPaint.setStrokeWidth(chartLineStrokeWidth);

                canvas.drawLine(convertXPercent(points[j - 1].x),
                        convertYPercent(points[j - 1].y),
                        convertXPercent(point.x), convertYPercent(point.y),
                        dotPaint);
            }

            dotPaint.reset();
            dotPaint.setStyle(Paint.Style.STROKE);
            dotPaint.setStrokeWidth(1);
            dotPaint.setColor(0xff343434);
            dotPaint.setAntiAlias(true);
            dotPaint.setPathEffect(pathEffect);
            Path path = new Path();
            path.moveTo(convertXPercent(point.x), convertYPercent(point.y));
            path.lineTo(convertXPercent(point.x), axisXPos);
            canvas.drawPath(path, dotPaint);
        }

        dotPaint.reset();
        for (int i = 0; i < points.length; i++) {// 循环画小圆圈
            LineChartPositionInterface.FloatPoint point = points[i];
            if (point.y > 0&&Double.parseDouble(point.pointText)>0) {
                dotPaint.setStyle(Style.FILL);
                if (point.y > normal.top) {
                    dotPaint.setColor(0xffff0000);
//                    canvas.drawCircle(convertXPercent(point.x),
//                            convertYPercent(point.y), dotRadius, dotPaint);
                    bigDot.setColor(Color.RED);
                    canvas.drawCircle(convertXPercent(point.x),
                            convertYPercent(point.y), dip2px(5f), bigDot);
                    canvas.drawCircle(convertXPercent(point.x),
                            convertYPercent(point.y), dip2px(3f), smallDot);

                    dotPaint.setStyle(Style.STROKE);
                    dotPaint.setTextSize(24);
                    dotPaint.setColor(0xff343434);
                    dotPaint.setTextAlign(Align.CENTER);
                    canvas.drawText(
                            point.pointText,
                            convertXPercent(point.x),
                            convertYPercent(point.y)
                                    - dotPaint.getFontMetrics().descent
                                    - dotRadius, dotPaint);

                    dotPaint.setColor(0xffff0000);
                    canvas.drawText(
                            "↑",
                            convertXPercent(point.x)
                                    + dotPaint.measureText(point.pointText) / 2
                                    + dip2px(2f), convertYPercent(point.y)
                                    - dotPaint.getFontMetrics().descent
                                    - dotRadius, dotPaint);

                } else if (point.y < normal.bottom) {
                    dotPaint.setColor(0xffff0000);
//                    canvas.drawCircle(convertXPercent(point.x),
//                            convertYPercent(point.y), dotRadius, dotPaint);
                    bigDot.setColor(Color.RED);
                    canvas.drawCircle(convertXPercent(point.x),
                            convertYPercent(point.y), dip2px(5f), bigDot);
                    canvas.drawCircle(convertXPercent(point.x),
                            convertYPercent(point.y), dip2px(3f), smallDot);

                    dotPaint.setStyle(Style.STROKE);
                    dotPaint.setTextSize(24);
                    dotPaint.setColor(0xff343434);
                    dotPaint.setTextAlign(Align.CENTER);
                    canvas.drawText(
                            point.pointText,
                            convertXPercent(point.x),
                            convertYPercent(point.y)
                                    - dotPaint.getFontMetrics().descent
                                    - dotRadius, dotPaint);

                    dotPaint.setColor(0xffff0000);
                    canvas.drawText(
                            "↓",
                            convertXPercent(point.x)
                                    + dotPaint.measureText(point.pointText) / 2
                                    + dip2px(2f), convertYPercent(point.y)
                                    - dotPaint.getFontMetrics().descent
                                    - dotRadius, dotPaint);
                } else {
                    dotPaint.setColor(0xff00ff00);
//                    canvas.drawCircle(convertXPercent(point.x),
//                            convertYPercent(point.y), dotRadius, dotPaint);
                    bigDot.setColor(Color.GREEN);
                    canvas.drawCircle(convertXPercent(point.x),
                            convertYPercent(point.y), dip2px(5f), bigDot);
                    canvas.drawCircle(convertXPercent(point.x),
                            convertYPercent(point.y), dip2px(3f), smallDot);

                    dotPaint.setStyle(Style.STROKE);
                    dotPaint.setTextSize(24);
                    dotPaint.setColor(0xff343434);
                    dotPaint.setTextAlign(Align.CENTER);
                    canvas.drawText(
                            point.pointText,
                            convertXPercent(point.x),
                            convertYPercent(point.y)
                                    - dotPaint.getFontMetrics().descent
                                    - dotRadius, dotPaint);
                }
            }
        }

        dotPaint = null;
        bigDot=null;
        smallDot=null;
    }

    /**
     * 把y轴百分比坐标,转化为y轴像素坐标
     */
    private int convertYPercent(float y) {
        int h = getHeight();
        return (int) (h - h * y + 0.5f);
    }

    /**
     * 把x轴百分比坐标,转化为x轴像素坐标
     */
    private int convertXPercent(float x) {
        int w = getWidth();
        return (int) (w * x + 0.5f);
    }

    private int dip2px(float dipValue) {
        final float scale = getResources().getDisplayMetrics().density;
        return (int) (dipValue * scale + 0.5f);
    }

}
