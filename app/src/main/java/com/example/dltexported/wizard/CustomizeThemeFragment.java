package com.example.dltexported.wizard;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.dltexported.HomeActivity;
import com.example.dltexported.R;
import com.example.dltexported.attributes.ColorPickerDialog;
import com.example.dltexported.attributes.Utility;

public class CustomizeThemeFragment extends Fragment implements View.OnClickListener {
    private View view;
    private TextView tv_themeNext, tv_theme_back;
    private LinearLayout ll_excellent_color, ll_good_color, ll_fair_color, ll_poor_color;
    private RelativeLayout rl_excellent_color, rl_good_color, rl_fair_color, rl_poor_color;
    private String colorFlag;
    private Button btn_cancel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_customize_theme, container, false);

        tv_themeNext = (TextView) view.findViewById(R.id.tv_theme_next);
        tv_themeNext.setOnClickListener(this);
        tv_theme_back = (TextView) view.findViewById(R.id.tv_theme_back);
        tv_theme_back.setOnClickListener(this);

        ll_excellent_color = (LinearLayout) view.findViewById(R.id.ll_excellent_color);
        ll_good_color = (LinearLayout) view.findViewById(R.id.ll_good_color);
        ll_fair_color = (LinearLayout) view.findViewById(R.id.ll_fair_color);
        ll_poor_color = (LinearLayout) view.findViewById(R.id.ll_poor_color);

        rl_excellent_color = (RelativeLayout) view.findViewById(R.id.rl_excellent_color);
        rl_good_color = (RelativeLayout) view.findViewById(R.id.rl_good_color);
        rl_fair_color = (RelativeLayout) view.findViewById(R.id.rl_fair_color);
        rl_poor_color = (RelativeLayout) view.findViewById(R.id.rl_poor_color);

        btn_cancel=(Button) view.findViewById(R.id.btn_cancel);
        btn_cancel.setOnClickListener(this);
        ll_excellent_color.setOnClickListener(this);
        ll_good_color.setOnClickListener(this);
        ll_fair_color.setOnClickListener(this);
        ll_poor_color.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        ViewPager vp = (ViewPager) getActivity().findViewById(R.id.vp_custom_theme);
        switch (v.getId()) {
            case R.id.tv_theme_next:
                vp.setCurrentItem(1);
                break;
            case R.id.tv_theme_back:
                vp.setCurrentItem(0);
                break;
            case R.id.btn_cancel:
                startActivity(new Intent(getActivity(), HomeActivity.class));
                getActivity().finish();
                break;
            case R.id.ll_excellent_color:
                colorFlag = "excellent";
                showColorPickerDialogDemo();
                break;
            case R.id.ll_good_color:
                colorFlag = "good";
                showColorPickerDialogDemo();
                break;
            case R.id.ll_fair_color:
                colorFlag = "fair";
                showColorPickerDialogDemo();
                break;
            case R.id.ll_poor_color:
                colorFlag = "poor";
                showColorPickerDialogDemo();
                break;
            default:
                break;
        }
    }

    private void showColorPickerDialogDemo() {

        int initialColor = Color.WHITE;

        ColorPickerDialog colorPickerDialog = new ColorPickerDialog(getActivity(), initialColor, new ColorPickerDialog.OnColorSelectedListener() {

            @Override
            public void onColorSelected(int color) {
                if (colorFlag.equalsIgnoreCase("excellent")) {
                    ll_excellent_color.setBackgroundColor(color);
                    rl_excellent_color.setBackgroundColor(color);
                } else if (colorFlag.equalsIgnoreCase("good")) {
                    ll_good_color.setBackgroundColor(color);
                    rl_good_color.setBackgroundColor(color);
                } else if (colorFlag.equalsIgnoreCase("fair")) {
                    ll_fair_color.setBackgroundColor(color);
                    rl_fair_color.setBackgroundColor(color);
                } else if (colorFlag.equalsIgnoreCase("poor")) {
                    ll_poor_color.setBackgroundColor(color);
                    rl_poor_color.setBackgroundColor(color);
                }
            }

        });
        colorPickerDialog.show();

    }
}
