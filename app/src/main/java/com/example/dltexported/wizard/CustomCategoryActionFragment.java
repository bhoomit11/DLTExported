package com.example.dltexported.wizard;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.dltexported.HomeActivity;
import com.example.dltexported.R;

public class CustomCategoryActionFragment extends Fragment implements View.OnClickListener {
    private View view;
    private TextView tv_action_next;
    private Button btn_cancel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_custom_category_action, container, false);
        tv_action_next = (TextView) view.findViewById(R.id.tv_action_next);
        tv_action_next.setOnClickListener(this);
        btn_cancel = (Button) view.findViewById(R.id.btn_cancel);
        btn_cancel.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        ViewPager vp = (ViewPager) getActivity().findViewById(R.id.vp_custom_theme);
        switch (v.getId()) {
            case R.id.tv_action_next:
                vp.setCurrentItem(4);
                break;
            case R.id.tv_action_back:
                vp.setCurrentItem(3);
                break;
            case R.id.btn_cancel:
                startActivity(new Intent(getActivity(), HomeActivity.class));
                getActivity().finish();
                break;
            default:
                break;
        }
    }
}
