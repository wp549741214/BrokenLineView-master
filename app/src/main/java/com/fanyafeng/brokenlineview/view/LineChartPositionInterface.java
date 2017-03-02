package com.fanyafeng.brokenlineview.view;

import android.graphics.RectF;

public interface LineChartPositionInterface
{
    /**
     * 获取序号为index的点,在View内的坐标
     * @param index 点的序号
     * @return 坐标轴内坐标(相对于整个View来说,按百分比计算)
     */
    public abstract FloatPoint[] getPoint();

    /**
     * 获取X坐标轴的起点和终点.
     * @return FloatPoint[],数组,长度为2,[0]代表x轴起点;[1]代表x轴终点
     */
    public abstract FloatPoint[] getAxisXLine();

    /**
     * 获取y坐标轴的起点和终点.
     * @return FloatPoint[],数组,长度为2,[0]代表y轴起点;[1]代表y轴终点
     */
    public abstract FloatPoint[] getAxisYLine();

    /**获取x轴所有刻度文本,例如{"2月11日","2月12日","2月13日"}*/
    public abstract String[] getXAxisTickMarkText();


    /**获取x轴所有刻度在View内的横向百分比坐标*/
    public abstract float[] getXAxisTickMarkPosition();

    /**获取"正常范围"的矩形*/
    public abstract RectF getNormalRect();

    /**获取"正常范围"的下限*/
    public abstract String getNormalMin();

    /**获取"正常范围"的上限*/
    public abstract String getNormalMax();

    /**
     * 百分比坐标封装类.(相对于整个View来说)
     */
    public static class FloatPoint
    {
        public float x = 0.0f;
        /**点的y坐标,如果y<0,则表示这个点不存在*/
        public float y = 0.0f;

        /**小圆点上显示的文字,一般是原始数据文字*/
        public String pointText = "";

        public FloatPoint()
        {

        }

        public FloatPoint(float x,float y,String str)
        {
            this.x = x;
            this.y = y;
            pointText = str;
        }
    }
}
