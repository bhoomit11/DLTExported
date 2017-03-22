package com.example.dltexported.wizard;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import com.example.dltexported.R;
import com.example.dltexported.attributes.Utility;


public class WizardActivity extends FragmentActivity implements View.OnClickListener {
    private Context mContext;
    private ViewPager mViewPager;
    private ImageView img_menu, img_help;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wizard);

        initUi();
    }

    private void initUi() {
        mContext = WizardActivity.this;

        img_menu = (ImageView) findViewById(R.id.img_menu);
        img_menu.setOnClickListener(this);
        img_help = (ImageView) findViewById(R.id.img_help);
        img_help.setOnClickListener(this);

        mViewPager = (ViewPager) findViewById(R.id.vp_wizard);
        vpWizardAdapter adapterViewPager = new vpWizardAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(adapterViewPager);

        mViewPager.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });
    }

    class vpWizardAdapter extends FragmentPagerAdapter {
        public vpWizardAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new WizardFragmentMain();
                case 1:
                    return new WizardTempleteFragment();
                case 2:
                    return new WizardFinishFragment();
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return 3;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.img_menu:
                Utility.customMenu(WizardActivity.this);
                break;
            case R.id.img_help:
                Utility.customHelp(WizardActivity.this);
                break;
        }
    }
}
