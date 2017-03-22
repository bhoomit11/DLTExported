package com.example.dltexported.DietTracker;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.dltexported.R;
import com.example.dltexported.attributes.Utility;

public class DietTrackerActivity extends Activity implements View.OnClickListener {

    Context mContext;
    private ImageView img_menu, img_help;
    private Button btn_overview, btn_diet;
    private LinearLayout ll_overview, ll_diet;
    private Button btn_my_food, btn_my_meal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_diet_tracker);

        init();

    }

    public void init() {
        mContext = DietTrackerActivity.this;
        img_menu = (ImageView) findViewById(R.id.img_menu);
        img_menu.setOnClickListener(this);
        img_help = (ImageView) findViewById(R.id.img_help);
        img_help.setOnClickListener(this);

        btn_diet = (Button) findViewById(R.id.btn_diet);
        btn_diet.setOnClickListener(this);
        btn_overview = (Button) findViewById(R.id.btn_overview);
        btn_overview.setOnClickListener(this);

        btn_my_food = (Button) findViewById(R.id.btn_my_food);
        btn_my_food.setOnClickListener(this);
        btn_my_meal = (Button) findViewById(R.id.btn_my_meal);
        btn_my_meal.setOnClickListener(this);

        ll_diet = (LinearLayout) findViewById(R.id.ll_diet);
        ll_overview = (LinearLayout) findViewById(R.id.ll_overview);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_my_food:
                Intent intent = new Intent(DietTrackerActivity.this, DietTracker_MyMealActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_my_meal:
                Intent intent1 = new Intent(DietTrackerActivity.this, DietTracker_MyMealActivity.class);
                startActivity(intent1);
                break;
            case R.id.btn_diet:
                btn_overview.setBackgroundColor(getResources().getColor(R.color.tab_bg));
                btn_diet.setBackgroundColor(getResources().getColor(R.color.white));
                btn_overview.setTextColor(getResources().getColor(R.color.tab_border));
                btn_diet.setTextColor(getResources().getColor(R.color.diet_font_color));
                ll_diet.setVisibility(View.VISIBLE);
                ll_overview.setVisibility(View.GONE);
                break;
            case R.id.btn_overview:
                btn_overview.setBackgroundColor(getResources().getColor(R.color.white));
                btn_diet.setBackgroundColor(getResources().getColor(R.color.tab_bg));
                btn_overview.setTextColor(getResources().getColor(R.color.diet_font_color));
                btn_diet.setTextColor(getResources().getColor(R.color.tab_border));
                ll_diet.setVisibility(View.GONE);
                ll_overview.setVisibility(View.VISIBLE);
                break;
            case R.id.img_menu:
                Utility.customMenu(DietTrackerActivity.this);
                break;
            case R.id.img_help:
                Utility.customHelp(DietTrackerActivity.this);
                break;
            default:
                break;
        }
    }
}
