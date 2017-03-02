package com.fanyafeng.brokenlineview.view;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import com.fanyafeng.brokenlineview.R;

public class LineChartActivity extends Activity
{
    private LineChartView lineChartView;
    private LineChartPositionManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        lineChartView = (LineChartView) findViewById(R.id.line);
        lineChartView.setBackgroundColor(0xffffffff);

        List<CoordinateValue> data = new ArrayList<CoordinateValue>();
        CoordinateValue d1 = new CoordinateValue(90.0f,"2月1日");
        CoordinateValue d2 = new CoordinateValue(60.0f,"2月1日");
        CoordinateValue d3 = new CoordinateValue(70.0f,"2月1日");
        CoordinateValue d4 = new CoordinateValue(50.0f,"2月1日");
        CoordinateValue d5 = new CoordinateValue(50.0f,"2月1日");
        data.add(d1);
        data.add(d2);
        data.add(d3);
        data.add(d4);
        data.add(d5);

        manager = new LineChartPositionManager(lineChartView);
        manager.setData(data,50,80);
        lineChartView.setLineChartPositionInterface(manager);
        lineChartView.setLayoutParams(new RelativeLayout.LayoutParams(
                LayoutParams.MATCH_PARENT,dip2px(100f)));

    }

    private int dip2px(float dipValue)
    {
        final float scale = getResources().getDisplayMetrics().density;
        return (int)(dipValue * scale + 0.5f);
    }
}
