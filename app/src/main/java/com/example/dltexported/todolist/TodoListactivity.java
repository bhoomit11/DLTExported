package com.example.dltexported.todolist;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.example.dltexported.R;
import com.example.dltexported.attributes.ColorPickerDialog;
import com.example.dltexported.attributes.Utility;


public class TodoListactivity extends AppCompatActivity implements View.OnClickListener {
    private Context mContext;
    private LinearLayout llMasterList, llQuicklist, llTaskActivity, llItemApp, ll_context_menu, ll_context_menu_main;
    private RelativeLayout rlMasterList, rlQuickList, rlTaskActivity, rlItemApp, rl_context_menu;
    private ImageView ivMasterList, ivQuickList, ivTaskActivity, ivItemApp, iv_context_updownarrow;
    private LinearLayout llTextColour, llBackColour;
    private ImageView img_menu, img_help, iv_contextMenu, iv_editicon_relation;
    private ImageView img_text_color, img_bg_color;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo_listactivity);

        initUi();
    }

    private void initUi() {
        mContext = TodoListactivity.this;

        llMasterList = (LinearLayout) findViewById(R.id.ll_master_list);
        llQuicklist = (LinearLayout) findViewById(R.id.ll_quickList);
        llTaskActivity = (LinearLayout) findViewById(R.id.ll_task_actiity);
        llItemApp = (LinearLayout) findViewById(R.id.ll_item_app);
        ll_context_menu = (LinearLayout) findViewById(R.id.ll_context_menu);
        ll_context_menu_main = (LinearLayout) findViewById(R.id.ll_context_menu_main);

        rlMasterList = (RelativeLayout) findViewById(R.id.rl_master_list);
        rlQuickList = (RelativeLayout) findViewById(R.id.rl_quickList);
        rlTaskActivity = (RelativeLayout) findViewById(R.id.rl_task_actiity);
        rlItemApp = (RelativeLayout) findViewById(R.id.rl_item_app);
        rl_context_menu = (RelativeLayout) findViewById(R.id.rl_context_menu);

        rlMasterList.setOnClickListener(this);
        rlQuickList.setOnClickListener(this);
        rlTaskActivity.setOnClickListener(this);
        rlItemApp.setOnClickListener(this);
        rl_context_menu.setOnClickListener(this);

        ivMasterList = (ImageView) findViewById(R.id.iv_updownarrow);
        ivQuickList = (ImageView) findViewById(R.id.iv_quicklist_updownarrow);
        ivTaskActivity = (ImageView) findViewById(R.id.iv_task_activity_updownarrow);
        ivItemApp = (ImageView) findViewById(R.id.iv_item_app_updownarrow);
        iv_context_updownarrow = (ImageView) findViewById(R.id.iv_context_updownarrow);
        iv_editicon_relation = (ImageView) findViewById(R.id.iv_editicon_relation);
        iv_editicon_relation.setOnClickListener(this);


        iv_contextMenu = (ImageView) findViewById(R.id.iv_todo_context_menu);
        iv_contextMenu.setOnClickListener(this);
        img_menu = (ImageView) findViewById(R.id.img_menu);
        img_menu.setOnClickListener(this);
        img_help = (ImageView) findViewById(R.id.img_help);
        img_help.setOnClickListener(this);

        img_text_color = (ImageView) findViewById(R.id.img_text_color);
        img_text_color.setOnClickListener(this);
        img_bg_color = (ImageView) findViewById(R.id.img_bg_color);
        img_bg_color.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.img_text_color:
                Utility.writeSharedPreferences(mContext, "color", "text");
                showColorPickerDialogDemo();
                break;
            case R.id.img_bg_color:
                Utility.writeSharedPreferences(mContext, "color", "bg");
                showColorPickerDialogDemo();
                break;
            case R.id.iv_todo_context_menu:
                if (ll_context_menu_main.getVisibility() == View.GONE) {
                    ll_context_menu_main.setVisibility(View.VISIBLE);
                } else {
                    ll_context_menu_main.setVisibility(View.GONE);
                }
                break;
            case R.id.rl_context_menu:
                if (ll_context_menu.getVisibility() == View.GONE) {
                    ll_context_menu.setVisibility(View.VISIBLE);
                    iv_context_updownarrow.setImageResource(R.drawable.whitearrow_up);
                } else {
                    ll_context_menu.setVisibility(View.GONE);
                    iv_context_updownarrow.setImageResource(R.drawable.whitearrow_down);
                }
                break;
            case R.id.rl_master_list:
                if (llMasterList.getVisibility() == View.GONE) {
                    llMasterList.setVisibility(View.VISIBLE);
                    ivMasterList.setImageResource(R.drawable.whitearrow_up);
                } else {
                    llMasterList.setVisibility(View.GONE);
                    ivMasterList.setImageResource(R.drawable.whitearrow_down);
                }
                break;
            case R.id.rl_quickList:
                if (llQuicklist.getVisibility() == View.GONE) {
                    llQuicklist.setVisibility(View.VISIBLE);
                    ivQuickList.setImageResource(R.drawable.whitearrow_up);
                } else {
                    llQuicklist.setVisibility(View.GONE);
                    ivQuickList.setImageResource(R.drawable.whitearrow_down);
                }
                break;
            case R.id.rl_task_actiity:
                if (llTaskActivity.getVisibility() == View.GONE) {
                    llTaskActivity.setVisibility(View.VISIBLE);
                    ivTaskActivity.setImageResource(R.drawable.whitearrow_up);
                } else {
                    llTaskActivity.setVisibility(View.GONE);
                    ivTaskActivity.setImageResource(R.drawable.whitearrow_down);
                }
                break;
            case R.id.rl_item_app:
                if (llItemApp.getVisibility() == View.GONE) {
                    llItemApp.setVisibility(View.VISIBLE);
                    ivItemApp.setImageResource(R.drawable.whitearrow_up);
                } else {
                    llItemApp.setVisibility(View.GONE);
                    ivItemApp.setImageResource(R.drawable.whitearrow_down);
                }
                break;
            case R.id.iv_editicon_relation:
                startActivity(new Intent(TodoListactivity.this, EditTodoActivity.class));
                break;
            case R.id.img_menu:
                Utility.customMenu(TodoListactivity.this);
                break;
            case R.id.img_help:
                Utility.customHelp(TodoListactivity.this);
                break;
        }
    }

    private void showColorPickerDialogDemo() {

        int initialColor = Color.WHITE;

        ColorPickerDialog colorPickerDialog = new ColorPickerDialog(this, initialColor, new ColorPickerDialog.OnColorSelectedListener() {

            @Override
            public void onColorSelected(int color) {
                if (Utility.getAppPrefString(mContext, "color").equalsIgnoreCase("text"))
                    img_text_color.setBackgroundColor(color);
                else
                    img_bg_color.setBackgroundColor(color);
            }

        });
        colorPickerDialog.show();

    }
}
