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
import android.widget.TextView;

import com.example.dltexported.HomeActivity;
import com.example.dltexported.R;

/**
 * Created by Bhoomit on 1/12/2017.
 */
public class CustomCreateCategoryFragment extends Fragment implements View.OnClickListener {
    private View view;
    private TextView btn_next, btn_back;
    private Button btn_cancel;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_custom_categories, container, false);
        btn_next = (TextView) view.findViewById(R.id.tv_next);
        btn_next.setOnClickListener(this);
        btn_back = (TextView) view.findViewById(R.id.tv_back);
        btn_back.setOnClickListener(this);
        btn_cancel=(Button) view.findViewById(R.id.btn_cancel);
        btn_cancel.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        ViewPager vp = (ViewPager) getActivity().findViewById(R.id.vp_custom_theme);
        switch (v.getId()) {
            case R.id.tv_next:
                vp.setCurrentItem(2);
                break;
            case R.id.tv_back:
                vp.setCurrentItem(1);
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
