package com.example.dltexported.wizard;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.dltexported.R;


/**
 * Created by Bhoomit on 12/27/2016.
 */
public class WizardFragmentMain extends Fragment {
    private View view;
    private Button btn_start;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = getActivity().getLayoutInflater().inflate(R.layout.fragment_wizard_main, null);

        btn_start = (Button) view.findViewById(R.id.btn_start);

        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ViewPager vp=(ViewPager) getActivity().findViewById(R.id.vp_wizard);
                vp.setCurrentItem(1);
            }
        });
        return view;
    }
}
