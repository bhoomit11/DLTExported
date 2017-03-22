package com.example.dltexported.bodytracker;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.dltexported.R;
import com.example.dltexported.adapter.BodyTrackerAgeRatingAdapter;
import com.example.dltexported.adapter.SpinnerAdapter;
import com.example.dltexported.attributes.NonScrollExpandableListView;
import com.example.dltexported.attributes.Utility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class BodyTrackerActivity extends AppCompatActivity implements View.OnClickListener {

    Spinner sp_body_tracker;
    LinearLayout ll_physioogical_data, ll_body_measurement, ll_additionalRate, ll_productivity, ll_calender,
            ll_ratings;
    private RelativeLayout rl_show_data_list, rl_male_list, rl_female_list;

    private ImageView img_menu, img_help, iv_main_updownarrow, iv_male_updownarrow, iv_female_updownarrow;
    private SpinnerAdapter spinnerAdapter;
    private Context mContext;
    private TextView tv_vo2_help;
    private boolean flag_help = false;
    private static String sp_text = "";

    private NonScrollExpandableListView elv_male_rating, elv_female_rating;
    private BodyTrackerAgeRatingAdapter bodyTrackerAgeRatingAdapter;

    private List<String> ageList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_body_tracker);

        initUi();

        sp_body_tracker.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 0:
                        ll_body_measurement.setVisibility(View.VISIBLE);
                        ll_physioogical_data.setVisibility(View.GONE);
                        ll_additionalRate.setVisibility(View.GONE);
                        ll_productivity.setVisibility(View.GONE);
                        ll_calender.setVisibility(View.GONE);
                        sp_text = "0";
                        break;
                    case 1:
                        ll_body_measurement.setVisibility(View.GONE);
                        ll_physioogical_data.setVisibility(View.VISIBLE);
                        ll_additionalRate.setVisibility(View.GONE);
                        ll_productivity.setVisibility(View.GONE);
                        ll_calender.setVisibility(View.GONE);
                        sp_text = "1";
                        break;
                    case 2:
                        ll_body_measurement.setVisibility(View.GONE);
                        ll_physioogical_data.setVisibility(View.GONE);
                        ll_additionalRate.setVisibility(View.VISIBLE);
                        ll_productivity.setVisibility(View.GONE);
                        ll_calender.setVisibility(View.GONE);
                        sp_text = "2";
                        break;
                    case 3:
                        ll_body_measurement.setVisibility(View.GONE);
                        ll_physioogical_data.setVisibility(View.GONE);
                        ll_additionalRate.setVisibility(View.GONE);
                        ll_productivity.setVisibility(View.VISIBLE);
                        ll_calender.setVisibility(View.GONE);
                        sp_text = "3";
                        break;
                    case 4:
                        ll_body_measurement.setVisibility(View.GONE);
                        ll_physioogical_data.setVisibility(View.GONE);
                        ll_additionalRate.setVisibility(View.GONE);
                        ll_productivity.setVisibility(View.GONE);
                        ll_calender.setVisibility(View.VISIBLE);
                        sp_text = "4";
                        break;
                    default:
                        ll_body_measurement.setVisibility(View.GONE);
                        ll_physioogical_data.setVisibility(View.GONE);
                        ll_additionalRate.setVisibility(View.GONE);
                        ll_productivity.setVisibility(View.GONE);
                        ll_calender.setVisibility(View.GONE);
                        sp_text = "5";
                        break;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void initUi() {
        mContext = BodyTrackerActivity.this;
        sp_body_tracker = (Spinner) findViewById(R.id.sp_body_tracker);
        ll_physioogical_data = (LinearLayout) findViewById(R.id.ll_physioogical_data);
        ll_body_measurement = (LinearLayout) findViewById(R.id.ll_body_measurement);
        ll_additionalRate = (LinearLayout) findViewById(R.id.ll_additional_rate);
        ll_productivity = (LinearLayout) findViewById(R.id.ll_productivity);
        ll_calender = (LinearLayout) findViewById(R.id.ll_calender);
        ll_ratings = (LinearLayout) findViewById(R.id.ll_ratings);

        rl_show_data_list = (RelativeLayout) findViewById(R.id.rl_show_data_list);
        rl_male_list = (RelativeLayout) findViewById(R.id.rl_male_list);
        rl_female_list = (RelativeLayout) findViewById(R.id.rl_female_list);

        rl_show_data_list.setOnClickListener(this);
        rl_male_list.setOnClickListener(this);
        rl_female_list.setOnClickListener(this);

        iv_main_updownarrow = (ImageView) findViewById(R.id.iv_main_updownarrow);
        iv_male_updownarrow = (ImageView) findViewById(R.id.iv_male_updownarrow);
        iv_female_updownarrow = (ImageView) findViewById(R.id.iv_female_updownarrow);

        img_menu = (ImageView) findViewById(R.id.img_menu);
        img_menu.setOnClickListener(this);
        img_help = (ImageView) findViewById(R.id.img_help);
        img_help.setOnClickListener(this);

        List<String> arrayList1 = new ArrayList<>();
        arrayList1 = Arrays.asList(getResources().getStringArray(R.array.body_tracker_spinner));

        spinnerAdapter = new SpinnerAdapter(mContext, arrayList1);
        sp_body_tracker.setAdapter(spinnerAdapter);
        tv_vo2_help = (TextView) findViewById(R.id.tv_vo2_help);

        elv_male_rating = (NonScrollExpandableListView) findViewById(R.id.elv_male_rating);
        elv_female_rating = (NonScrollExpandableListView) findViewById(R.id.elv_female_rating);

        List<String> arrayList = new ArrayList<>();
        arrayList = Arrays.asList(getResources().getStringArray(R.array.body_tracker_spinner));

        ageList = Arrays.asList(getResources().getStringArray(R.array.body_age_list));

        spinnerAdapter = new SpinnerAdapter(mContext, arrayList);
        sp_body_tracker.setAdapter(spinnerAdapter);

        bodyTrackerAgeRatingAdapter = new BodyTrackerAgeRatingAdapter(mContext, ageList);
        elv_male_rating.setAdapter(bodyTrackerAgeRatingAdapter);
        elv_female_rating.setAdapter(bodyTrackerAgeRatingAdapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.img_menu:
                Utility.customMenu(BodyTrackerActivity.this);
                break;
            case R.id.img_help:
                if (sp_text.equalsIgnoreCase("1")) {
                    if (!flag_help) {
                        tv_vo2_help.setVisibility(View.VISIBLE);
                        flag_help = true;
                    } else {
                        tv_vo2_help.setVisibility(View.GONE);
                        flag_help = false;
                    }
                } else {
                    Utility.customHelp(BodyTrackerActivity.this);
                }
                break;
            case R.id.rl_show_data_list:
                if (ll_ratings.getVisibility() == View.GONE) {
                    ll_ratings.setVisibility(View.VISIBLE);
                    iv_main_updownarrow.setImageResource(R.drawable.whitearrow_up);
                } else {
                    ll_ratings.setVisibility(View.GONE);
                    iv_main_updownarrow.setImageResource(R.drawable.whitearrow_down);
                }
                break;
            case R.id.rl_male_list:
                if (elv_male_rating.getVisibility() == View.GONE) {
                    elv_male_rating.setVisibility(View.VISIBLE);
                    iv_male_updownarrow.setImageResource(R.drawable.whitearrow_up);
                } else {
                    elv_male_rating.setVisibility(View.GONE);
                    iv_male_updownarrow.setImageResource(R.drawable.whitearrow_down);
                }
                break;
            case R.id.rl_female_list:
                if (elv_female_rating.getVisibility() == View.GONE) {
                    elv_female_rating.setVisibility(View.VISIBLE);
                    iv_female_updownarrow.setImageResource(R.drawable.whitearrow_up);
                } else {
                    elv_female_rating.setVisibility(View.GONE);
                    iv_female_updownarrow.setImageResource(R.drawable.whitearrow_down);
                }
                break;
        }
    }
}
