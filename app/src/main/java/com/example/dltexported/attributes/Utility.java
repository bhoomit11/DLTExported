package com.example.dltexported.attributes;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.StrictMode;
import android.support.design.widget.Snackbar;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.dltexported.DietTracker.DietTrackerActivity;
import com.example.dltexported.HomeActivity;
import com.example.dltexported.SleepTracker.SleepTrackerActivity;
import com.example.dltexported.bodytracker.BodyTrackerActivity;
import com.example.dltexported.category.TrackAndManageCategoryActivity;
import com.example.dltexported.Journal.JournalActivity;
import com.example.dltexported.R;
import com.example.dltexported.settings.SettingsActivity;
import com.example.dltexported.todolist.TodoListactivity;
import com.example.dltexported.wizard.WizardActivity;

/**
 * Created by Vivek on 26-Dec-16.
 */
public class Utility {

    private Context context;

    public Utility(Context context) {
        this.context = context;
    }

    public static void toast(String toastMessage, Context context) {
        Toast.makeText(context, toastMessage, Toast.LENGTH_SHORT).show();
    }

    public static void StrictModePolicy(Context context) {

        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                    .permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
    }

    public static void writeSharedPreferences(Context mContext, String key,
                                              String value) {
        // We need an Editor object to make preference changes.
        // All objects are from android.context.Context
        SharedPreferences settings = mContext.getSharedPreferences(
                Constant.PREFS_NAME, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString(key, value);
        // Commit the edits!
        editor.commit();
    }

    public static String getAppPrefString(Context mContext, String key) {
        try {
            SharedPreferences settings = mContext.getSharedPreferences(
                    Constant.PREFS_NAME, 0);
            String value = settings.getString(key, "");
            return value;
        } catch (Exception ex) {
            ex.printStackTrace();
            return "";
        }
    }

    public static boolean isNetworkAvaliable(Context ctx) {
        ConnectivityManager connectivityManager = (ConnectivityManager) ctx
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        if ((connectivityManager
                .getNetworkInfo(ConnectivityManager.TYPE_MOBILE) != null && connectivityManager
                .getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED)
                || (connectivityManager
                .getNetworkInfo(ConnectivityManager.TYPE_WIFI) != null && connectivityManager
                .getNetworkInfo(ConnectivityManager.TYPE_WIFI)
                .getState() == NetworkInfo.State.CONNECTED)) {
            return true;
        } else {
            return false;
        }
    }

    public static void snackBarShow(View container, String msg) {
        Snackbar.make(container, msg, Snackbar.LENGTH_LONG).show();
    }

    public static void writeSharedPreferencesInt(Context mContext, String key,
                                                 int value) {
        // We need an Editor object to make preference changes.
        // All objects are from android.context.Context
        SharedPreferences settings = mContext.getSharedPreferences(
                Constant.PREFS_NAME, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putInt(key, value);
        // Commit the edits!
        editor.commit();
    }

    public static void customHelp(final Activity context) {
        final Dialog dialog = new Dialog(context, R.style.DialogSlideAnim);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setBackgroundDrawable(
                new ColorDrawable(Color.TRANSPARENT));
        dialog.setContentView(R.layout.custom_help);

        ImageView img_close = (ImageView) dialog.findViewById(R.id.img_help_close);
        img_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        Window window = dialog.getWindow();
        WindowManager.LayoutParams wlp = window.getAttributes();

        wlp.gravity = Gravity.RIGHT | Gravity.TOP;
        wlp.width = ActionBar.LayoutParams.MATCH_PARENT;
        window.addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        window.setAttributes(wlp);

        if (!dialog.isShowing()) {
            dialog.show();
        } else {
            dialog.dismiss();
        }

    }

    public static void customMenu(final Activity context) {
        final Dialog dialog = new Dialog(context, R.style.DialogSlideAnim1);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setBackgroundDrawable(
                new ColorDrawable(Color.TRANSPARENT));
        dialog.setContentView(R.layout.custom_menu);

        ImageView img_close = (ImageView) dialog.findViewById(R.id.img_menu_close);
        img_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        LinearLayout ll_home = (LinearLayout) dialog.findViewById(R.id.ll_home);

        ll_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
//                if (!context.isTaskRoot()) {
//                    context.finish();
//                }
                Intent intent = new Intent(context, HomeActivity.class);
                context.startActivity(intent);
            }
        });

        LinearLayout ll_diet = (LinearLayout) dialog.findViewById(R.id.ll_diet_tracker);
        ll_diet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                Intent intent = new Intent(context, DietTrackerActivity.class);
                context.startActivity(intent);
            }
        });

        LinearLayout ll_body = (LinearLayout) dialog.findViewById(R.id.ll_body_tracker);
        ll_body.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                Intent intent = new Intent(context, BodyTrackerActivity.class);
                context.startActivity(intent);
            }
        });

        LinearLayout ll_sleep = (LinearLayout) dialog.findViewById(R.id.ll_sleep_tracker);
        ll_sleep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                Intent intent = new Intent(context, SleepTrackerActivity.class);
                context.startActivity(intent);
            }
        });

        LinearLayout ll_track_mange = (LinearLayout) dialog.findViewById(R.id.ll_track_mange);
        ll_track_mange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                Intent intent = new Intent(context, TrackAndManageCategoryActivity.class);
                context.startActivity(intent);
            }
        });

        LinearLayout ll_todo_list = (LinearLayout) dialog.findViewById(R.id.ll_todo_list);
        ll_todo_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                Intent intent = new Intent(context, TodoListactivity.class);
                context.startActivity(intent);
            }
        });

        LinearLayout ll_setting = (LinearLayout) dialog.findViewById(R.id.ll_setting);
        ll_setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                Intent intent = new Intent(context, SettingsActivity.class);
                context.startActivity(intent);
            }
        });

        LinearLayout ll_Journal = (LinearLayout) dialog.findViewById(R.id.ll_journal);
        ll_Journal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                Intent intent = new Intent(context, JournalActivity.class);
                context.startActivity(intent);
            }
        });

        LinearLayout ll_wizard = (LinearLayout) dialog.findViewById(R.id.ll_wizard);
        ll_wizard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                Intent intent = new Intent(context, WizardActivity.class);
                context.startActivity(intent);
            }
        });


        Window window = dialog.getWindow();
        WindowManager.LayoutParams wlp = window.getAttributes();

        wlp.gravity = Gravity.LEFT | Gravity.TOP;
        wlp.width = ActionBar.LayoutParams.MATCH_PARENT;
        window.addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        window.setAttributes(wlp);

        if (!dialog.isShowing()) {
            dialog.show();
        } else {
            dialog.dismiss();
        }

    }
}
