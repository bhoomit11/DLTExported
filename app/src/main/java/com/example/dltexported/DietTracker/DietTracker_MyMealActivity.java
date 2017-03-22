package com.example.dltexported.DietTracker;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;

import com.example.dltexported.R;

public class DietTracker_MyMealActivity extends Activity implements View.OnClickListener {

    Context mContext;
    private LinearLayout ll_add_new_meal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_diet_tracker_my_meal);

        init();

    }

    public void init() {
        mContext = DietTracker_MyMealActivity.this;
        ll_add_new_meal = (LinearLayout) findViewById(R.id.ll_add_new_meal);
        ll_add_new_meal.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ll_add_new_meal:
                Intent intent = new Intent(DietTracker_MyMealActivity.this, DietTracker_AddNewMealActivity.class);
                startActivity(intent);
                break;
        }
    }
}
