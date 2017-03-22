package com.example.dltexported.wizard;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.dltexported.R;


/**
 * Created by Bhoomit on 12/28/2016.
 */
public class WizardTempleteFragment extends Fragment {
    private View view;
    private RadioGroup mRadioGroup;
    private TextView tv_next;
    private boolean customTempleteFlag = false;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = getActivity().getLayoutInflater().inflate(R.layout.fragment_wizard_templete, null);
        mRadioGroup = (RadioGroup) view.findViewById(R.id.rg_templete_select);
        tv_next = (TextView) view.findViewById(R.id.tv_wiz_templete_next);

        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb_custom:
                        customTempleteFlag = true;
                        break;
                    default:
                        customTempleteFlag = false;
                        break;
                }
            }
        });

        tv_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (customTempleteFlag) {
                    Intent intent = new Intent(getActivity(), CustomTempleteActivity.class);
                    getActivity().startActivity(intent);
                }else {
                    ViewPager vp=(ViewPager) getActivity().findViewById(R.id.vp_wizard);
                    vp.setCurrentItem(2);
                }
            }
        });
        return view;
    }
}
