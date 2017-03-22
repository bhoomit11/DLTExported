package com.example.dltexported.SleepTracker;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.dltexported.R;
import com.example.dltexported.attributes.Constant;
import com.example.dltexported.attributes.Utility;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.imanoweb.calendarview.CustomCalendarView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

public class SleepTrackerActivity extends Activity implements View.OnClickListener {

    Context mContext;
    private LinearLayout ll_today;
    private CustomCalendarView customCalendarView;
    private ImageView img_calendar;
    private static boolean flag = false;
    private ImageView img_menu, img_help;
    protected BarChart mStackedBarChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_sleep_tracker);

        init();
    }

    public void init() {
        mContext = SleepTrackerActivity.this;
        ll_today = (LinearLayout) findViewById(R.id.ll_today_sleep_tracker);
        customCalendarView = (CustomCalendarView) findViewById(R.id.calendar_view_sleep_tracker);
        Calendar currentCalendar = Calendar.getInstance(Locale.getDefault());
        customCalendarView.setFirstDayOfWeek(Calendar.MONDAY);
        customCalendarView.refreshCalendar(currentCalendar);
        img_calendar = (ImageView) findViewById(R.id.img_calendar_view_sleep_tracker);
        img_calendar.setOnClickListener(this);
        img_menu = (ImageView) findViewById(R.id.img_menu);
        img_menu.setOnClickListener(this);
        img_help = (ImageView) findViewById(R.id.img_help);
        img_help.setOnClickListener(this);
        initSleepChart();
    }

    private void initSleepChart() {
        mStackedBarChart = (BarChart) findViewById(R.id.chart_sleep1);

        // if more than 60 entries are displayed in the chart, no values will be
        // drawn
        mStackedBarChart.setDrawBarShadow(false);
        mStackedBarChart.setDrawValueAboveBar(true);
        mStackedBarChart.setMaxVisibleValueCount(40);
        mStackedBarChart.setTouchEnabled(false);

        // scaling can now only be done on x- and y-axis separately
        mStackedBarChart.setPinchZoom(false);

        mStackedBarChart.setDrawGridBackground(false);
        mStackedBarChart.setDrawBarShadow(false);

        mStackedBarChart.setDrawValueAboveBar(false);
        mStackedBarChart.setHighlightFullBarEnabled(false);

        mStackedBarChart.setBackgroundColor(getResources().getColor(android.R.color.white));
//        mBarChart.getXAxis().setDrawGridLines(false);
//        mBarChart.getAxisLeft().setDrawGridLines(true);

        Description d = mStackedBarChart.getDescription();
        d.setEnabled(false);

        XAxis xAxis = mStackedBarChart.getXAxis();
//        xAxis.setEnabled(false);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setDrawGridLines(false);
        xAxis.setGranularity(1f); // only intervals of 1 day
        xAxis.setLabelCount(7);


        YAxis leftAxis = mStackedBarChart.getAxisLeft();
//        leftAxis.setEnabled(false);
        leftAxis.setLabelCount(2, false);
        leftAxis.setPosition(YAxis.YAxisLabelPosition.OUTSIDE_CHART);
        leftAxis.setSpaceTop(15f);
        leftAxis.setAxisMinValue(0f); // this replaces setStartAtZero(true)

        YAxis rightAxis = mStackedBarChart.getAxisRight();
        rightAxis.setEnabled(false);


        XAxis xLabels = mStackedBarChart.getXAxis();
        xLabels.setEnabled(false);
        xLabels.setPosition(XAxis.XAxisPosition.TOP);

        // mStackedBarChart.setDrawXLabels(false);
        // mStackedBarChart.setDrawYLabels(false);

        Legend l = mStackedBarChart.getLegend();
        l.setEnabled(false);

        setSleepTrackerData(12, 50);
        // mStackedBarChart.setDrawLegend(false);
        mStackedBarChart.animateY(2500);

    }

    public void setSleepTrackerData(int count, int range) {
        ArrayList<BarEntry> yVals1 = new ArrayList<BarEntry>();

        for (int i = 0; i < count + 1; i++) {
            float mult = (range + 1);
            float val1 = (float) (Math.random() * mult) + mult / 3;
            float val2 = (float) (Math.random() * mult) + mult / 3;

            yVals1.add(new BarEntry(i, new float[]{val1, val2}));
        }

        BarDataSet set1;

        if (mStackedBarChart.getData() != null &&
                mStackedBarChart.getData().getDataSetCount() > 0) {
            set1 = (BarDataSet) mStackedBarChart.getData().getDataSetByIndex(0);
            set1.setValues(yVals1);
            set1.setDrawValues(false);
            mStackedBarChart.getData().notifyDataChanged();
            mStackedBarChart.notifyDataSetChanged();
        } else {
            set1 = new BarDataSet(yVals1, "Your Sleep This Week");
            set1.setColors(Constant.getStackedColors());
            set1.setStackLabels(new String[]{"Naps", "Sleeps"});
            set1.setDrawValues(false);

            ArrayList<IBarDataSet> dataSets = new ArrayList<IBarDataSet>();
            dataSets.add(set1);

            BarData data = new BarData(dataSets);
            data.setValueTextColor(Color.WHITE);

            mStackedBarChart.setData(data);
        }

        mStackedBarChart.setFitBars(true);
        mStackedBarChart.invalidate();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.img_calendar_view_sleep_tracker:
                if (!flag) {
                    ll_today.setVisibility(View.GONE);
                    customCalendarView.setVisibility(View.VISIBLE);
                    flag = true;
                } else {
                    ll_today.setVisibility(View.VISIBLE);
                    customCalendarView.setVisibility(View.GONE);
                    flag = false;
                }
                break;
            case R.id.img_menu:
                Utility.customMenu(SleepTrackerActivity.this);
                break;
            case R.id.img_help:
                Utility.customHelp(SleepTrackerActivity.this);
                break;
            default:
                break;
        }
    }
}
