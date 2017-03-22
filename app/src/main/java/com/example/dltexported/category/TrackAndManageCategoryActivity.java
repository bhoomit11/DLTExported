package com.example.dltexported.category;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.eralp.circleprogressview.CircleProgressView;
import com.example.dltexported.R;
import com.example.dltexported.attributes.Utility;

public class TrackAndManageCategoryActivity extends Activity implements View.OnClickListener {
    Context mContext;
    private ImageView img_menu, img_help;
    LinearLayout ll_physical_mastery;
    private CircleProgressView cpv_relation, cpv_life,
            cpv_physical, cpv_personal, cpv_financial, cpv_emotional;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_track_and_manage_category);

        init();

    }

    public void init() {
        mContext = TrackAndManageCategoryActivity.this;

        img_menu = (ImageView) findViewById(R.id.img_menu);
        img_menu.setOnClickListener(this);
        img_help = (ImageView) findViewById(R.id.img_help);
        img_help.setOnClickListener(this);

        ll_physical_mastery = (LinearLayout) findViewById(R.id.ll_physical_mastery);
        ll_physical_mastery.setOnClickListener(this);

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

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ll_physical_mastery:
                Intent intent = new Intent(mContext, SubCategoryActivity.class);
                startActivity(intent);
                break;
            case R.id.img_menu:
                Utility.customMenu(TrackAndManageCategoryActivity.this);
                break;
            case R.id.img_help:
                Utility.customHelp(TrackAndManageCategoryActivity.this);
                break;
            default:
                break;
        }
    }
}
