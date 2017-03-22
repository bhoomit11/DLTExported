package com.example.dltexported.wizard;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.dltexported.HomeActivity;
import com.example.dltexported.R;


/**
 * Created by Bhoomit on 12/29/2016.
 */
public class WizardFinishFragment extends Fragment implements View.OnClickListener {
    private View view;
    private Button btn_finish;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = getActivity().getLayoutInflater().inflate(R.layout.fragment_wizard_finish, null);

        btn_finish = (Button) view.findViewById(R.id.btn_finish);

        btn_finish.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_finish:
                startActivity(new Intent(getActivity(), HomeActivity.class));
                getActivity().finish();
                break;
            default:
                break;
        }
    }
}
