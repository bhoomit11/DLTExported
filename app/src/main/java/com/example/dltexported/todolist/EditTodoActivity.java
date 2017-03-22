package com.example.dltexported.todolist;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.dltexported.R;
import com.imanoweb.calendarview.CustomCalendarView;

import java.util.Calendar;
import java.util.Locale;

import jp.wasabeef.richeditor.RichEditor;

public class EditTodoActivity extends AppCompatActivity implements View.OnClickListener {
    private Context mContext;
    private RichEditor mEditor;
    private ImageView iv_close_activity;
    private LinearLayout ll_calender_view;
    private CustomCalendarView customCalendarView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_todo);

        init();

    }

    private void init() {
        mContext = EditTodoActivity.this;
        mEditor = (RichEditor) findViewById(R.id.editor_journal);
        mEditor.setEditorHeight(200);
        mEditor.setEditorFontSize(14);
        mEditor.setEditorFontColor(Color.BLACK);
        mEditor.setPadding(8, 8, 8, 8);

        iv_close_activity = (ImageView) findViewById(R.id.iv_close_activity);
        iv_close_activity.setOnClickListener(this);
        ll_calender_view = (LinearLayout) findViewById(R.id.ll_calender_view);
        ll_calender_view.setOnClickListener(this);

        customCalendarView = (CustomCalendarView) findViewById(R.id.calendar_view_sleep_tracker);
        Calendar currentCalendar = Calendar.getInstance(Locale.getDefault());
        customCalendarView.setFirstDayOfWeek(Calendar.MONDAY);
        customCalendarView.refreshCalendar(currentCalendar);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_close_activity:
                EditTodoActivity.this.finish();
                break;
            case R.id.ll_calender_view:
                if (customCalendarView.getVisibility() == View.GONE) {
                    customCalendarView.setVisibility(View.VISIBLE);
                } else {
                    customCalendarView.setVisibility(View.GONE);
                }
                break;
            default:
                break;
        }
    }
}
