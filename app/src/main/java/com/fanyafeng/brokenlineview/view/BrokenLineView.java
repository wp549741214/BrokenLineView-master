package com.fanyafeng.brokenlineview.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.fanyafeng.brokenlineview.R;
import com.fanyafeng.brokenlineview.model.HealthData;
import com.fanyafeng.brokenlineview.model.Weight;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

/**
 * Author： wangpeng,fanyafeng
 * Data： 17/2/4 下午2:54
 * Email: peng.wangjt@ikang.com
 */
public class BrokenLineView extends View {

    private float lineWidth = 4;

    private static float startX = 0;
    private static float endX = 0;
    private static float startY = 0;
    private static float endY = 0;
    private static float height = 0;
    private static float width = 0;
    private static float pWidth = 0;
    private static float indexWidth = 100;

    private Paint XPaint;
    private Paint YPaint;
    private Paint pointPaint;
    private Paint circlePaint;
    private Paint bigCirclePaint;
    private Paint shadowPaint;
    private Paint Y_LinePaint;
    private Paint arrowPaint;//箭头
    private Paint dashedPaint;//虚线
    //数据结构对象 解析成点的集合放进来
    private List<BrokenLinePointBean> points = new ArrayList<>();
    private List<String> XindexString = new ArrayList<>();
    private List<String> YindexString = new ArrayList<>();
    private BrokenLinePointBean PointY1 = new BrokenLinePointBean(0, -1);
    private BrokenLinePointBean PointY2 = new BrokenLinePointBean(0, -1);


    //新增   画笔 超出红色范围画红圈
//    private Paint newPaint;
//    //获取图片资源
    private Context mContext;
//    private Resources resources;
//    private Bitmap bmp_arrowUp,bmp_arrowDown,bmp_normal,bmp_exception,bmp_time_axis;

    //布尔值判断 是否连线
    private boolean isLigature = true;
    //设置x轴y轴的颜色 阴影部分颜色  以及对应y轴颜色
    private String XPanintColor;
    private String YPanintColor;
    private String shadowColor;

    public String getShadowColor() {
        return shadowColor;
    }

    public void setShadowColor(String shadowColor) {
        this.shadowColor = shadowColor;
    }

    public boolean isLigature() {
        return isLigature;
    }

    public void setLigature(boolean ligature) {
        isLigature = ligature;
    }

    public String getYPanintColor() {
        return YPanintColor;
    }

    public void setYPanintColor(String YPanintColor) {
        this.YPanintColor = YPanintColor;
    }

    public String getXPanintColor() {
        return XPanintColor;
    }

    public void setXPanintColor(String XPanintColor) {
        this.XPanintColor = XPanintColor;
    }

    public void setPointList(List<BrokenLinePointBean> points) {
        this.points = points;
        invalidate();
    }

    public void setShadowPaints(BrokenLinePointBean pointY1, BrokenLinePointBean pointY2) {
        this.PointY1 = pointY1;
        this.PointY2 = pointY2;
        invalidate();
    }

    public void setXIndex(List<String> XindexString) {
        this.XindexString = XindexString;
//        invalidate();
    }

    public void setYIndex(List<String> YindexString) {
        this.YindexString = YindexString;
//        invalidate();
    }

    public BrokenLineView(Context context) {
        this(context, null, 0);
//        initView();
    }

    public BrokenLineView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
//        initView();
    }

    public BrokenLineView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
//        resources=mContext.getResources();
        initView();
    }

    private void initView() {
        XPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        XPaint.setAntiAlias(true);
        XPaint.setColor(Color.parseColor(TextUtils.isEmpty(XPanintColor) ? "#c7c7c7" : XPanintColor));
        XPaint.setStrokeWidth(lineWidth / 2);

        YPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        YPaint.setAntiAlias(true);
        YPaint.setColor(Color.parseColor(TextUtils.isEmpty(XPanintColor) ? "#c7c7c7" : XPanintColor));
        YPaint.setStrokeWidth(lineWidth / 2);

        Y_LinePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        Y_LinePaint.setAntiAlias(true);
        Y_LinePaint.setColor(Color.parseColor("#03a34e"));
        Y_LinePaint.setStrokeWidth(lineWidth / 2);

        pointPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        pointPaint.setAntiAlias(true);
        pointPaint.setColor(Color.DKGRAY);
        pointPaint.setStrokeWidth(2);

        circlePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        circlePaint.setAntiAlias(true);
        circlePaint.setColor(Color.WHITE);
        circlePaint.setStyle(Paint.Style.FILL);
        circlePaint.setStrokeWidth(1);

        bigCirclePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        bigCirclePaint.setAntiAlias(true);
        bigCirclePaint.setColor(Color.GREEN);
        bigCirclePaint.setStyle(Paint.Style.FILL);
        bigCirclePaint.setStrokeWidth(1);

        shadowPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        shadowPaint.setAntiAlias(true);
        shadowPaint.setColor(Color.GREEN);
        shadowPaint.setStyle(Paint.Style.FILL);
        shadowPaint.setStrokeWidth(1);

        dashedPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        dashedPaint.setAntiAlias(true);
        dashedPaint.setStyle(Paint.Style.STROKE);
        dashedPaint.setColor(Color.DKGRAY);
        dashedPaint.setStrokeWidth(1);

        arrowPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        arrowPaint.setAntiAlias(true);
        arrowPaint.setColor(Color.RED);
        arrowPaint.setStyle(Paint.Style.FILL);
        arrowPaint.setStrokeWidth(4);

//        newPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
//        newPaint.setAntiAlias(true);
//        newPaint.setColor(Color.RED);
//        newPaint.setStyle(Paint.Style.FILL);
//        newPaint.setStrokeWidth(4);

//        bmp_arrowDown=new BitmapDrawable(resources.openRawResource(+R.mipmap.a)).getBitmap();
//        bmp_arrowUp=new BitmapDrawable(resources.openRawResource(+R.mipmap.b)).getBitmap();
//        bmp_time_axis=new BitmapDrawable(resources.openRawResource(+R.mipmap.c)).getBitmap();
//        bmp_ex ception=new BitmapDrawable(resources.openRawResource(+R.mipmap.d)).getBitmap();
//        bmp_normal=new BitmapDrawable(resources.openRawResource(+R.mipmap.e)).getBitmap();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if (startX == 0) {
            startX = getLeft();
        }
        if (endX == 0) {
            endX = getRight();
        }
        if (startY == 0) {
            startY = getTop();
        }
        if (endY == 0) {
            endY = getBottom();
        }
        if (width == 0) {//宽
            width = getWidth();
            pWidth = width - indexWidth;
        }
        if (height == 0) {//高
            //总高度，传入值时不能传入point，应传入百分比，y轴传入百分比，因此需要自定义bean
            height = getHeight() - indexWidth;
        }
        //画图颜色设置
        XPaint.setColor(Color.parseColor(TextUtils.isEmpty(XPanintColor) ? "#c7c7c7" : XPanintColor));
        YPaint.setColor(Color.parseColor(TextUtils.isEmpty(XPanintColor) ? "#c7c7c7" : XPanintColor));
        shadowPaint.setColor(Color.parseColor(TextUtils.isEmpty(XPanintColor) ? "#def3e8" : shadowColor));


        if (PointY1.y > -1 && PointY2.y > -1) {

            canvas.drawLine(indexWidth, PointY1.y * height, indexWidth, PointY2.y * height, Y_LinePaint);
            canvas.drawRect(indexWidth, PointY1.y * height, width, PointY2.y * height, shadowPaint);

            //y轴坐标1
            Paint paintY1 = new Paint(Paint.ANTI_ALIAS_FLAG);
            paintY1.setTextSize(24);
            paintY1.setAntiAlias(true);
//            Rect rectY1 = new Rect((int) indexWidth - 10, (int) (PointY1.y * height - 10), (int) indexWidth, (int) (PointY1.y * height + 10));//折线为圈，需要减去半径
            Rect rectY1 = new Rect((int) 0, (int) (PointY1.y * height - 10), (int) indexWidth - 10, (int) (PointY1.y * height + 10));//折线为圈，需要减去半径
            paintY1.setColor(Color.WHITE);
            canvas.drawRect(rectY1, paintY1);
            Paint.FontMetricsInt fontMetricsIntY1 = paintY1.getFontMetricsInt();
            int baseLineY1 = (rectY1.bottom + rectY1.top - fontMetricsIntY1.bottom - fontMetricsIntY1.top) / 2;
            paintY1.setTextAlign(Paint.Align.CENTER);
            paintY1.setColor(Color.BLACK);
            canvas.drawText(TextUtils.isEmpty(PointY1.getyValue()) ? "y1" : PointY1.getyValue(), rectY1.centerX(), baseLineY1, paintY1);

            //y轴坐标2
            Paint paintY2 = new Paint(Paint.ANTI_ALIAS_FLAG);
            paintY2.setTextSize(24);
            paintY2.setAntiAlias(true);
//            Rect rectY2 = new Rect((int) indexWidth - 10, (int) (PointY2.y * height - 10), (int) indexWidth, (int) (PointY2.y * height + 10));//折线为圈，需要减去半径
            Rect rectY2 = new Rect((int) 0, (int) (PointY2.y * height - 10), (int) indexWidth - 10, (int) (PointY2.y * height + 10));//折线为圈，需要减去半径
            paintY2.setColor(Color.WHITE);
            canvas.drawRect(rectY2, paintY2);
            Paint.FontMetricsInt fontMetricsIntY2 = paintY2.getFontMetricsInt();
            int baseLineY2 = (rectY2.bottom + rectY2.top - fontMetricsIntY2.bottom - fontMetricsIntY2.top) / 2;
            paintY2.setTextAlign(Paint.Align.CENTER);
            paintY2.setColor(Color.BLACK);
            canvas.drawText(TextUtils.isEmpty(PointY2.getyValue()) ? "y2" : PointY2.getyValue(), rectY2.centerX(), baseLineY2, paintY2);
        }

        int size = points.size();
        if (size != 0) {
            //size+1份，每份长度
            float eachLength = pWidth / (size + 1);

            for (int i = 0; i < size; i++) {
                float pointX1 = indexWidth + eachLength * (i + 1);
                float pointY1 = points.get(i).y * height;
                Log.d(TAG, "onDraw() called with: canvas = " + points.get(i).getY() + "----" + points.get(i).getyValue());
                if (i != size - 1) {

                    if (isLigature) {//是否需要连线

                        if (PointY1 != null && PointY2 != null) {
                            if (points.get(i + 1).getY() <= PointY1.getY() || points.get(i + 1).getY() >= PointY2.getY()) {
                                bigCirclePaint.setColor(Color.RED);
                            } else {
                                bigCirclePaint.setColor(Color.GREEN);
                            }
                        }
                        float pointX2 = indexWidth + eachLength * (i + 2);
                        float pointY2 = points.get(i + 1).y * height;
                        canvas.drawLine(pointX1, pointY1, pointX2, pointY2, pointPaint);

                        canvas.drawCircle(pointX2, pointY2, 15, bigCirclePaint);
//                        canvas.drawCircle(pointX2, pointY2, 12, bigCirclePaint);
                        canvas.drawCircle(pointX2, pointY2, 5, circlePaint);
                    }
                }

                if (PointY1 != null && PointY2 != null) {
                    if (points.get(i).getY() <= PointY1.getY() || points.get(i).getY() >= PointY2.getY()) {
                        bigCirclePaint.setColor(Color.RED);
                    } else {
                        bigCirclePaint.setColor(Color.GREEN);
                    }
                }

                if (!"0.0".equals(points.get(i).getyValue())) {

                    canvas.drawCircle(pointX1, pointY1, 12, bigCirclePaint);
//                canvas.drawCircle(pointX1, pointY1, 12, bigCirclePaint);
                    canvas.drawCircle(pointX1, pointY1, 4, circlePaint);


                    //虚线绘制
                    Path path = new Path();
                    path.moveTo(pointX1, pointY1);
                    path.lineTo(pointX1, height);
                    PathEffect effects = new DashPathEffect(new float[]{5, 5, 5, 5}, 1);
                    dashedPaint.setPathEffect(effects);
                    canvas.drawPath(path, dashedPaint);

                    //折点标字
                    Paint paintBroken = new Paint(Paint.ANTI_ALIAS_FLAG);
                    paintBroken.setAntiAlias(true);
                    paintBroken.setTextSize(30);
//                    Rect rectBroken = new Rect((int) pointX1 - 50, (int) pointY1 - 50, (int) pointX1 + 50, (int) pointY1 - 10);//折线为圈，需要减去半径
                    Rect rectBroken = null;
                    if (pointY1 < 50) {
                        rectBroken=new Rect((int) pointX1 - 50, (int) pointY1 + 10, (int) pointX1 + 50, (int) pointY1 + 50);//折线为圈，需要减去半径
                    } else {
                        rectBroken=new Rect((int) pointX1 - 50, (int) pointY1 - 50, (int) pointX1 + 50, (int) pointY1 - 10);//折线为圈，需要减去半径
                    }
                    paintBroken.setColor(Color.TRANSPARENT);
                    canvas.drawRect(rectBroken, paintBroken);
                    Paint.FontMetricsInt fontMetricsIntBroken = paintBroken.getFontMetricsInt();
                    int baseLineBroken = (rectBroken.bottom + rectBroken.top - fontMetricsIntBroken.bottom - fontMetricsIntBroken.top) / 2;
                    paintBroken.setTextAlign(Paint.Align.CENTER);
                    paintBroken.setColor(Color.BLACK);
                    canvas.drawText(TextUtils.isEmpty(points.get(i).getyValue()) ? String.valueOf(points.get(i).y) : points.get(i).getyValue(), rectBroken.centerX(), baseLineBroken, paintBroken);

                    //折点箭头
                    if (PointY1 != null && PointY2 != null && PointY1.y > -1 && PointY2.y > -1) {
                        Log.e(TAG, "onDraw: " + points.get(i).getY() + "---" + points.get(i).getyValue());
                        if (points.get(i).getY() < PointY1.getY()) {
                            //防止最上边的 箭头在图外，做判断处理 如果距离小于50 则画在下面
                            if (pointY1 < 50) {
                                canvas.drawLine(pointX1 + 40, pointY1 + 15, pointX1 + 40, pointY1 + 40, arrowPaint);
                                canvas.drawLine(pointX1 + 30, pointY1 + 30, pointX1 + 40, pointY1 + 40, arrowPaint);
                                canvas.drawLine(pointX1 + 50, pointY1 + 30, pointX1 + 40, pointY1 + 40, arrowPaint);

                            } else {
                                canvas.drawLine(pointX1 + 40, pointY1 - 15, pointX1 + 40, pointY1 - 40, arrowPaint);
                                canvas.drawLine(pointX1 + 30, pointY1 - 30, pointX1 + 40, pointY1 - 40, arrowPaint);
                                canvas.drawLine(pointX1 + 50, pointY1 - 30, pointX1 + 40, pointY1 - 40, arrowPaint);
                            }
                        } else if (points.get(i).getY() > PointY2.getY()) {
                            canvas.drawLine(pointX1 + 40, pointY1 - 40, pointX1 + 40, pointY1 - 15, arrowPaint);
                            canvas.drawLine(pointX1 + 30, pointY1 - 25, pointX1 + 40, pointY1 - 15, arrowPaint);
                            canvas.drawLine(pointX1 + 50, pointY1 - 25, pointX1 + 40, pointY1 - 15, arrowPaint);
                        }
                    }


//                            //y刻度
//                    Paint paintBrokenY = new Paint(Paint.ANTI_ALIAS_FLAG);
//                    paintBrokenY.setTextSize(24);
//                    paintBrokenY.setAntiAlias(true);
//                    Rect rectBrokenY = new Rect(0, (int) pointY1 - 10, (int) indexWidth, (int) pointY1 + 10);//折线为圈，需要减去半径
//                    paintBrokenY.setColor(Color.WHITE);
//                    canvas.drawRect(rectBrokenY, paintBrokenY);
//                    Paint.FontMetricsInt fontMetricsIntBrokenY = paintBrokenY.getFontMetricsInt();
//                    int baseLineBrokenY = (rectBrokenY.bottom + rectBrokenY.top - fontMetricsIntBrokenY.bottom - fontMetricsIntBrokenY.top) / 2;
//                    paintBrokenY.setTextAlign(Paint.Align.CENTER);
//                    paintBrokenY.setColor(Color.BLACK);
////                canvas.drawText(YindexString.size() > 0 ? YindexString.get(i) : String.valueOf(i + 1), rectBrokenY.centerX(), baseLineBrokenY, paintBrokenY);
//                    canvas.drawText(TextUtils.isEmpty(points.get(i).getyValue()) ? String.valueOf(points.get(i).y) : points.get(i).getyValue(), rectBrokenY.centerX(), baseLineBrokenY, paintBrokenY);
                }
                //x刻度
                Paint paintBrokenX = new Paint(Paint.ANTI_ALIAS_FLAG);
                paintBrokenX.setAntiAlias(true);
                paintBrokenX.setTextSize(30);
                Rect rectBrokenX = new Rect((int) pointX1 - 50, (int) height, (int) pointX1 + 50, (int) (height + indexWidth));//折线为圈，需要减去半径
                paintBrokenX.setColor(Color.TRANSPARENT);
                canvas.drawRect(rectBrokenX, paintBrokenX);
                Paint.FontMetricsInt fontMetricsIntBrokenX = paintBrokenX.getFontMetricsInt();
                int baseLineBrokenX = (rectBrokenX.bottom + rectBrokenX.top - fontMetricsIntBrokenX.bottom - fontMetricsIntBrokenX.top) / 2;
                paintBrokenX.setTextAlign(Paint.Align.CENTER);
                paintBrokenX.setColor(Color.BLACK);
                canvas.drawText(TextUtils.isEmpty(points.get(i).getxValue()) ? String.valueOf(i + 1) : points.get(i).getxValue(), rectBrokenX.centerX(), baseLineBrokenX, paintBrokenX);


            }
        }


        //x轴 轴应该最后画
        canvas.drawLine(indexWidth, height, width, height, XPaint);
        //x轴箭头
        canvas.drawLine(indexWidth, 0, indexWidth + 12, 24, XPaint);
        canvas.drawLine(indexWidth, 0, indexWidth - 12, 24, XPaint);
        //y轴
        canvas.drawLine(indexWidth, 0, indexWidth, height, YPaint);
        //y轴箭头
        canvas.drawLine(width - 24, height - 12, width, height, YPaint);
        canvas.drawLine(width - 24, height + 12, width, height, YPaint);
        if (PointY1.y > -1 && PointY2.y > -1) {

            canvas.drawLine(indexWidth, PointY1.y * height, indexWidth, PointY2.y * height, Y_LinePaint);
        }

//        Paint paintBrokenO = new Paint(Paint.ANTI_ALIAS_FLAG);
//        paintBrokenO.setTextSize(30);
//        paintBrokenO.setAntiAlias(true);
//        Rect rectBrokenO = new Rect(30, (int) height, (int) indexWidth, (int) (height + 70));//折线为圈，需要减去半径
//        paintBrokenO.setColor(Color.WHITE);
//        canvas.drawRect(rectBrokenO, paintBrokenO);
//        Paint.FontMetricsInt fontMetricsIntBrokenO = paintBrokenO.getFontMetricsInt();
//        int baseLineBrokenO = (rectBrokenO.bottom + rectBrokenO.top - fontMetricsIntBrokenO.bottom - fontMetricsIntBrokenO.top) / 2;
//        paintBrokenO.setTextAlign(Paint.Align.CENTER);
//        paintBrokenO.setColor(Color.BLACK);
//        canvas.drawText("原点", rectBrokenO.centerX(), baseLineBrokenO, paintBrokenO);

        //原点
//        canvas.drawCircle(indexWidth, height, 12, bigCirclePaint);
    }

}
