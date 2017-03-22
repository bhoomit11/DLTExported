package com.example.dltexported.settings;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;

import com.example.dltexported.R;
import com.example.dltexported.adapter.SpinnerAdapter;
import com.example.dltexported.attributes.Constant;
import com.example.dltexported.attributes.Utility;
import com.example.dltexported.volley.VolleyCacheRequestClass;
import com.example.dltexported.volley.VolleyResponseInterface;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class SettingsActivity extends AppCompatActivity implements View.OnClickListener, VolleyResponseInterface {
    private Spinner spSettings;
    private LinearLayout llUserSetting, llCustomisation, llDateTime, llExercise, llDataset;
    private SpinnerAdapter spinnerAdapter;
    private Context mContext;
    private ImageView img_menu, img_help;
    private EditText etFirstName, etLastName, etDob, etEmail, etPassword, etExerciseHour, etDateFormat, etTimeFormat;
    private Spinner spGender, spExerciseStat;

    private ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        initUi();

        spSettings.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 0:
                        llUserSetting.setVisibility(View.VISIBLE);
                        llCustomisation.setVisibility(View.GONE);
                        llDateTime.setVisibility(View.GONE);
                        llExercise.setVisibility(View.GONE);
                        llDataset.setVisibility(View.GONE);
                        break;
                    case 1:
                        llUserSetting.setVisibility(View.GONE);
                        llCustomisation.setVisibility(View.VISIBLE);
                        llDateTime.setVisibility(View.GONE);
                        llExercise.setVisibility(View.GONE);
                        llDataset.setVisibility(View.GONE);
                        break;
                    case 2:
                        llUserSetting.setVisibility(View.GONE);
                        llCustomisation.setVisibility(View.GONE);
                        llDateTime.setVisibility(View.VISIBLE);
                        llExercise.setVisibility(View.GONE);
                        llDataset.setVisibility(View.GONE);
                        break;
                    case 3:
                        llUserSetting.setVisibility(View.GONE);
                        llCustomisation.setVisibility(View.GONE);
                        llDateTime.setVisibility(View.GONE);
                        llExercise.setVisibility(View.VISIBLE);
                        llDataset.setVisibility(View.GONE);
                        break;
                    case 4:
                        llUserSetting.setVisibility(View.GONE);
                        llCustomisation.setVisibility(View.GONE);
                        llDateTime.setVisibility(View.GONE);
                        llExercise.setVisibility(View.GONE);
                        llDataset.setVisibility(View.VISIBLE);
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        getSettingsData();
    }

    private void initUi() {
        spSettings = (Spinner) findViewById(R.id.sp_setting_customisation);
        mContext = SettingsActivity.this;
        img_menu = (ImageView) findViewById(R.id.img_menu);
        img_menu.setOnClickListener(this);
        img_help = (ImageView) findViewById(R.id.img_help);
        img_help.setOnClickListener(this);
        llUserSetting = (LinearLayout) findViewById(R.id.ll_user_setting);
        llCustomisation = (LinearLayout) findViewById(R.id.ll_customization);
        llDateTime = (LinearLayout) findViewById(R.id.ll_time_date_setting);
        llExercise = (LinearLayout) findViewById(R.id.ll_exercise_setting);
        llDataset = (LinearLayout) findViewById(R.id.ll_dataset_setting);

        etFirstName = (EditText) findViewById(R.id.et_settings_first_name);
        etLastName = (EditText) findViewById(R.id.et_settings_last_name);
        etDob = (EditText) findViewById(R.id.et_settings_dob);
        etEmail = (EditText) findViewById(R.id.et_settings_email);
        etPassword = (EditText) findViewById(R.id.et_settings_password);

        etDateFormat = (EditText) findViewById(R.id.et_date_format);
        etTimeFormat = (EditText) findViewById(R.id.et_time_format);

        etExerciseHour = (EditText) findViewById(R.id.et_exercise_hour);
        spExerciseStat = (Spinner) findViewById(R.id.sp_exercise_status);

        List<String> arrayList = new ArrayList<>();
        arrayList = Arrays.asList(getResources().getStringArray(R.array.setting_array));

        spinnerAdapter = new SpinnerAdapter(mContext, arrayList);
        spSettings.setAdapter(spinnerAdapter);

        mProgressDialog = new ProgressDialog(mContext);
        mProgressDialog.setMessage("Processing...");
        mProgressDialog.setCancelable(false);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.img_menu:
                Utility.customMenu(SettingsActivity.this);
                break;
            case R.id.img_help:
                Utility.customHelp(SettingsActivity.this);
                break;
            default:
                break;
        }
    }

    private void getSettingsData() {
        if (Utility.isNetworkAvaliable(mContext)) {
            mProgressDialog.show();
            VolleyCacheRequestClass.getInstance().volleyGetJsonAPI(mContext, Constant.GET_SETTINGS,
                    Constant.URL_GET_SETTINGS);
        } else {
            Utility.snackBarShow(getWindow().getDecorView().getRootView(), "No Internet Connection");
        }
    }

    @Override
    public void vResponse(int reqCode, String response) {
        JSONObject object;
        try {
            JSONObject jObject = new JSONObject(response);
            if (reqCode == Constant.GET_SETTINGS) {
                JSONArray settingArray = new JSONArray(jObject.getString("Settings"));
                object = settingArray.getJSONObject(0);

                etFirstName.setText(object.getString("firstname"));
                etLastName.setText(object.getString("lastname"));
                etDob.setText(object.getString("dob"));
                etEmail.setText(object.getString("email"));
                etDateFormat.setText(object.getString("dateSetting"));
                etTimeFormat.setText(object.getString("timeOffset"));
                etExerciseHour.setText(object.getString("exerciseHoursSetting"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
        }
    }

    @Override
    public void vErrorMsg(int reqCode, String error) {
        if (mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
        }
    }
}
