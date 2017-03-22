package com.example.dltexported;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.RectF;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.eralp.circleprogressview.CircleProgressView;
import com.example.dltexported.SleepTracker.SleepTrackerActivity;
import com.example.dltexported.attributes.Constant;
import com.example.dltexported.attributes.Utility;
import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.charts.RadarChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.data.RadarData;
import com.github.mikephil.charting.data.RadarDataSet;
import com.github.mikephil.charting.data.RadarEntry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.interfaces.datasets.IRadarDataSet;

import java.util.ArrayList;

public class HomeActivity extends Activity implements View.OnClickListener {

    Context mContext;
    private CircleProgressView cpv_relation, cpv_life,
            cpv_physical, cpv_personal, cpv_financial, cpv_emotional, cpv_bad, cpv_neutral, cpv_good;
    private ImageView img_menu, img_help;
    protected BarChart mCategoryProgChart;
    protected BarChart mStackedBarChart;
    private LinearLayout ll_add_top_cat, ll_sleep_tracker;
    private LineChart mChart;
    private RadarChart mRadarChart;

    protected RectF mOnValueSelectedRectF = new RectF();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_home);

        init();
        Utility.writeSharedPreferences(mContext, Constant.Authorization, Constant.JWT_TOKEN);
    }

    public void init() {
        mContext = HomeActivity.this;

        initCategoryProgressBarChart();
        initLineChart();
        initSleepChart();
        initRadarChart();
//        initSleepChart();

        cpv_relation = (CircleProgressView) findViewById(R.id.circular_progress_relation);
        cpv_relation.setInterpolator(new AccelerateDecelerateInterpolator());
        cpv_relation.setStartAngle(180);
        cpv_relation.setTextEnabled(false);
        cpv_relation.setProgressWithAnimation(25, 1000);

        cpv_life = (CircleProgressView) findViewById(R.id.circular_progress_life_mg);
        cpv_life.setInterpolator(new AccelerateDecelerateInterpolator());
        cpv_life.setStartAngle(180);
        cpv_life.setTextEnabled(false);
        cpv_life.setProgressWithAnimation(25, 1000);

        cpv_physical = (CircleProgressView) findViewById(R.id.circular_progress_physical);
        cpv_physical.setInterpolator(new AccelerateDecelerateInterpolator());
        cpv_physical.setStartAngle(180);
        cpv_physical.setTextEnabled(false);
        cpv_physical.setProgressWithAnimation(50, 1000);

        cpv_personal = (CircleProgressView) findViewById(R.id.circular_progress_personal);
        cpv_personal.setInterpolator(new AccelerateDecelerateInterpolator());
        cpv_personal.setStartAngle(180);
        cpv_personal.setTextEnabled(false);
        cpv_personal.setProgressWithAnimation(50, 1000);

        cpv_financial = (CircleProgressView) findViewById(R.id.circular_progress_financial);
        cpv_financial.setInterpolator(new AccelerateDecelerateInterpolator());
        cpv_financial.setStartAngle(180);
        cpv_financial.setTextEnabled(false);
        cpv_financial.setProgressWithAnimation(75, 1000);

        cpv_emotional = (CircleProgressView) findViewById(R.id.circular_progress_emotional);
        cpv_emotional.setInterpolator(new AccelerateDecelerateInterpolator());
        cpv_emotional.setStartAngle(180);
        cpv_emotional.setTextEnabled(false);
        cpv_emotional.setProgressWithAnimation(75, 1000);

        cpv_bad = (CircleProgressView) findViewById(R.id.circular_progress_bad);
        cpv_bad.setInterpolator(new AccelerateDecelerateInterpolator());
        cpv_bad.setStartAngle(180);
        cpv_bad.setTextEnabled(false);
        cpv_bad.setProgressWithAnimation(100, 1000);

        cpv_neutral = (CircleProgressView) findViewById(R.id.circular_progress_neutral);
        cpv_neutral.setInterpolator(new AccelerateDecelerateInterpolator());
        cpv_neutral.setStartAngle(180);
        cpv_neutral.setTextEnabled(false);
        cpv_neutral.setProgressWithAnimation(100, 1000);

        cpv_good = (CircleProgressView) findViewById(R.id.circular_progress_good);
        cpv_good.setInterpolator(new AccelerateDecelerateInterpolator());
        cpv_good.setStartAngle(180);
        cpv_good.setTextEnabled(false);
        cpv_good.setProgressWithAnimation(100, 1000);

        img_menu = (ImageView) findViewById(R.id.img_menu);
        img_menu.setOnClickListener(this);
        img_help = (ImageView) findViewById(R.id.img_help);
        img_help.setOnClickListener(this);

        ll_sleep_tracker = (LinearLayout) findViewById(R.id.ll_sleep_tracker);
        ll_sleep_tracker.setOnClickListener(this);


    }

    private void initRadarChart() {
        mRadarChart = (RadarChart) findViewById(R.id.radarchart);
        mRadarChart.setWebLineWidth(0f);
        mRadarChart.setWebColor(Color.BLACK);
        mRadarChart.setWebLineWidthInner(0f);
        mRadarChart.setWebColorInner(Color.BLACK);
        mRadarChart.setWebAlpha(200);
        mRadarChart.setTouchEnabled(false);

        setRadarData();

        mRadarChart.animateXY(
                1400, 1400,
                Easing.EasingOption.EaseInOutQuad,
                Easing.EasingOption.EaseInOutQuad);

        Description d = mRadarChart.getDescription();
        d.setEnabled(false);

        XAxis xAxis = mRadarChart.getXAxis();
        xAxis.setTextSize(9f);
        xAxis.setYOffset(0f);
        xAxis.setXOffset(3f);
        xAxis.setTextColor(Color.BLACK);
        xAxis.setDrawGridLines(false);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM_INSIDE);
        xAxis.setValueFormatter(new IAxisValueFormatter() {
            private String[] mActivities = new String[]{"RelationShip Mastery",
                    "Physical Mastery",
                    "Financial Mastery",
                    "Life Management",
                    "Personal Development",
                    "Emotional Mastery"};

            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                return mActivities[(int) value % mActivities.length];
            }
        });

        YAxis yAxis = mRadarChart.getYAxis();
        yAxis.setLabelCount(5, false);
        yAxis.setTextSize(12f);
        yAxis.setAxisMinValue(0f);
        yAxis.setAxisMaxValue(80f);
        yAxis.setDrawLabels(false);

        Legend l = mRadarChart.getLegend();
        l.setEnabled(false);
        l.setPosition(Legend.LegendPosition.BELOW_CHART_CENTER);
        l.setXEntrySpace(3f);
        l.setYEntrySpace(3f);
        l.setTextColor(Color.WHITE);
    }

    private void initSleepChart() {
        mStackedBarChart = (BarChart) findViewById(R.id.chart_sleep);

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

    public void initLineChart() {
        mChart = (LineChart) findViewById(R.id.chart1);
        mChart.setDrawGridBackground(false);

        // no description text
        Description d = mChart.getDescription();
        d.setText("");

        // enable touch gestures
        mChart.setTouchEnabled(false);

        // enable scaling and dragging
        mChart.setDragEnabled(false);
        mChart.setScaleEnabled(true);

        mChart.setDrawGridBackground(false);
        // mChart.setScaleXEnabled(true);
        // mChart.setScaleYEnabled(true);

        // if disabled, scaling can be done on x- and y-axis separately
        mChart.setPinchZoom(false);

        // set an alternative background color
        // mChart.setBackgroundColor(Color.GRAY);

        // create a custom MarkerView (extend MarkerView) and specify the layout
        // to use for it
//        MyMarkerView mv = new MyMarkerView(this, R.layout.custom_marker_view);
//
        // set the marker to the chart
//        mChart.setMarkerView(mv);


        XAxis xAxis = mChart.getXAxis();
        xAxis.removeAllLimitLines(); // reset all limit lines to avoid overlapping lines
        xAxis.setDrawGridLines(false);
        xAxis.setDrawAxisLine(false);
        xAxis.setDrawLabels(false);

        YAxis leftAxis = mChart.getAxisLeft();
        leftAxis.removeAllLimitLines(); // reset all limit lines to avoid overlapping lines
        leftAxis.setAxisMaxValue(150f);
        leftAxis.setDrawGridLines(false);
        leftAxis.setAxisMinValue(0f);
        leftAxis.setDrawZeroLine(true);
        leftAxis.setDrawTopYLabelEntry(false);

        // limit lines are drawn behind data (and not on top)
//        leftAxis.setDrawLimitLinesBehindData(true);

        mChart.getAxisRight().setEnabled(false);

        // add data
        setData(10, 100);


        mChart.animateY(2000);
        //mChart.invalidate();

        Legend l = mChart.getLegend();
        l.setEnabled(false);

        // // dont forget to refresh the drawing
        // mChart.invalidate();
    }

    public void setRadarData() {

        float mult = 80;
        float min = 20;
        int cnt = 6;

        ArrayList<RadarEntry> entries1 = new ArrayList<RadarEntry>();

        // NOTE: The order of the entries when being added to the entries array determines their position around the center of
        // the chart.
        for (int i = 0; i < cnt; i++) {
            float val1 = (float) (Math.random() * mult) + min;
            entries1.add(new RadarEntry(val1));
        }

        RadarDataSet set1 = new RadarDataSet(entries1, "Action Graph");
        set1.setColor(Color.rgb(103, 110, 129));
        set1.setDrawFilled(true);
        set1.setFillAlpha(180);
        set1.setLineWidth(2f);
        set1.setDrawHighlightCircleEnabled(true);
        set1.setHighlightCircleStrokeWidth(3f);
        set1.setDrawHighlightIndicators(false);


        ArrayList<IRadarDataSet> sets = new ArrayList<IRadarDataSet>();
        sets.add(set1);

        RadarData data = new RadarData(sets);
        data.setValueTextSize(8f);
        data.setDrawValues(false);
        data.setValueTextColor(Color.BLACK);

        mRadarChart.setData(data);
        mRadarChart.invalidate();
    }

    private void setData(int count, float range) {

        ArrayList<Entry> values = new ArrayList<Entry>();

        for (int i = 0; i < count; i++) {

            float val = (float) (Math.random() * range) + 3;
            values.add(new Entry(i, val));
        }

        LineDataSet set1;

        if (mChart.getData() != null &&
                mChart.getData().getDataSetCount() > 0) {
            set1 = (LineDataSet) mChart.getData().getDataSetByIndex(0);
            set1.setValues(values);
            mChart.getData().notifyDataChanged();
            mChart.notifyDataSetChanged();
        } else {
            // create a dataset and give it a type
            set1 = new LineDataSet(values, "");

            // set the line to be drawn like this "- - - - - -"
//            set1.enableDashedLine(10f, 5f, 0f);
//            set1.enableDashedHighlightLine(10f, 5f, 0f);
            set1.setColor(Color.parseColor("#0D4775"));
            set1.setCircleColor(Color.parseColor("#0D4775"));
            set1.setLineWidth(1f);
            set1.setCircleRadius(3f);
            set1.setDrawCircleHole(false);
            set1.setValueTextSize(9f);
            set1.setDrawValues(false);
//            set1.setDrawFilled(true);

//            if (Utils.getSDKInt() >= 18) {
//                // fill drawable only supported on api level 18 and above
//                Drawable drawable = ContextCompat.getDrawable(this, R.drawable.fade_red);
//                set1.setFillDrawable(drawable);
//            } else {
            set1.setFillColor(Color.TRANSPARENT);
//            }

            ArrayList<ILineDataSet> dataSets = new ArrayList<ILineDataSet>();
            dataSets.add(set1); // add the datasets

            // create a data object with the datasets
            LineData data = new LineData(dataSets);

            // set data
            mChart.setData(data);
        }
    }

    private void initCategoryProgressBarChart() {
        mCategoryProgChart = (BarChart) findViewById(R.id.chart_category_progress);

        mCategoryProgChart.setDrawBarShadow(false);
        mCategoryProgChart.setDrawValueAboveBar(true);

        // if more than 60 entries are displayed in the chart, no values will be
        // drawn
        mCategoryProgChart.setMaxVisibleValueCount(60);

        // scaling can now only be done on x- and y-axis separately
        mCategoryProgChart.setPinchZoom(false);
        mCategoryProgChart.setDoubleTapToZoomEnabled(false);
        mCategoryProgChart.setDoubleTapToZoomEnabled(false);
        mCategoryProgChart.setDrawGridBackground(false);
        mCategoryProgChart.setBackgroundColor(getResources().getColor(android.R.color.white));

        Description desc = mCategoryProgChart.getDescription();
        desc.setEnabled(false);

        XAxis xAxis = mCategoryProgChart.getXAxis();
        xAxis.setEnabled(false);

        YAxis leftAxis = mCategoryProgChart.getAxisLeft();
//        leftAxis.setEnabled(false);
        leftAxis.setLabelCount(2, false);
        leftAxis.setPosition(YAxis.YAxisLabelPosition.OUTSIDE_CHART);
        leftAxis.setSpaceTop(15f);
        leftAxis.setAxisMinValue(0f);

        YAxis rightAxis = mCategoryProgChart.getAxisRight();
        rightAxis.setEnabled(false);


        Legend l = mCategoryProgChart.getLegend();
        l.setPosition(Legend.LegendPosition.BELOW_CHART_LEFT);
        l.setForm(Legend.LegendForm.SQUARE);
        l.setFormSize(9f);
        l.setTextSize(11f);
        l.setXEntrySpace(4f);
        l.setEnabled(false);

        setCategoryBarData(5, 50);

        if (mCategoryProgChart.getData() != null) {
            mCategoryProgChart.getData().setHighlightEnabled(!mCategoryProgChart.getData().isHighlightEnabled());
            mCategoryProgChart.invalidate();
        }

        mCategoryProgChart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
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

    private void setCategoryBarData(int count, float range) {

        float start = 0f;

        mCategoryProgChart.getXAxis().setAxisMinValue(start);
        mCategoryProgChart.getXAxis().setAxisMaxValue(start + count + 2);

        ArrayList<BarEntry> yVals1 = new ArrayList<BarEntry>();

        for (int i = (int) start; i < start + count + 1; i++) {
            float mult = (range + 1);
            float val = (float) (Math.random() * mult);
            yVals1.add(new BarEntry(i + 1f, val));
        }

        BarDataSet set1;

        if (mCategoryProgChart.getData() != null && mCategoryProgChart.getData().getDataSetCount() > 0) {
            set1 = (BarDataSet) mCategoryProgChart.getData().getDataSetByIndex(0);
            set1.setValues(yVals1);
            mCategoryProgChart.getData().notifyDataChanged();
            mCategoryProgChart.notifyDataSetChanged();
        } else {
            set1 = new BarDataSet(yVals1, "");
            set1.setColors(Constant.HOME_COLORS);

            ArrayList<IBarDataSet> dataSets = new ArrayList<IBarDataSet>();
            dataSets.add(set1);

            BarData data = new BarData(dataSets);
            data.setValueTextSize(10f);
            data.setBarWidth(0.9f);

            mCategoryProgChart.setData(data);
            mCategoryProgChart.animateY(1000);
        }
    }

    protected float getRandom(float range, float startsfrom) {
        return (float) (Math.random() * range) + startsfrom;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.img_menu:
                Utility.customMenu(HomeActivity.this);
                break;
            case R.id.img_help:
                Utility.customHelp(HomeActivity.this);
                break;
            case R.id.ll_sleep_tracker:
                Intent intent = new Intent(HomeActivity.this, SleepTrackerActivity.class);
                startActivity(intent);
            default:
                break;
        }
    }

    /*@Override
    public void onValueSelected(Entry e, Highlight h) {
        if (e == null)
            return;

        RectF bounds = mOnValueSelectedRectF;
        mCategoryProgChart.getBarBounds((BarEntry) e, bounds);
        MPPointF position = mCategoryProgChart.getPosition(e, YAxis.AxisDependency.LEFT);

        Log.i("bounds", bounds.toString());
        Log.i("position", position.toString());

        Log.i("x-index",
                "low: " + mCategoryProgChart.getLowestVisibleX() + ", high: "
                        + mCategoryProgChart.getHighestVisibleX());

        MPPointF.recycleInstance(position);
    }

    @Override
    public void onNothingSelected() {

    }*/

    @Override
    public void onBackPressed() {
        finishAffinity();
        System.exit(0);
    }
}
