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

public class CustomAspectsFragment extends Fragment implements View.OnClickListener {
    private View view;
    private TextView tv_aspect_next,tv_aspect_back;
    private Button btn_cancel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_custom_aspects, container, false);
        tv_aspect_next = (TextView) view.findViewById(R.id.tv_aspect_next);
        tv_aspect_next.setOnClickListener(this);
        tv_aspect_back = (TextView) view.findViewById(R.id.tv_aspect_back);
        tv_aspect_back.setOnClickListener(this);
        btn_cancel=(Button) view.findViewById(R.id.btn_cancel);
        btn_cancel.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        ViewPager vp = (ViewPager) getActivity().findViewById(R.id.vp_custom_theme);
        switch (v.getId()) {
            case R.id.tv_aspect_next:
                vp.setCurrentItem(3);
                break;
            case R.id.tv_aspect_back:
                vp.setCurrentItem(2);
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
