package com.example.dltexported.Journal;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;

import com.example.dltexported.R;
import com.example.dltexported.attributes.Utility;
import com.imanoweb.calendarview.CustomCalendarView;

import java.util.Calendar;
import java.util.Locale;

import jp.wasabeef.richeditor.RichEditor;

public class JournalActivity extends Activity implements View.OnClickListener {

    Context mContext;
    private RichEditor mEditor;
    private ImageView img_calendar_view;
    private CustomCalendarView customCalendarView;
    private ImageView img_menu, img_help;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_journal);

        init();
    }

    public void init() {
        mContext = JournalActivity.this;
        mEditor = (RichEditor) findViewById(R.id.editor_journal);
        mEditor.setEditorHeight(200);
        mEditor.setEditorFontSize(14);
        mEditor.setEditorFontColor(Color.BLACK);
        mEditor.setPadding(8, 8, 8, 8);
        img_calendar_view = (ImageView) findViewById(R.id.img_calendar_view);
        img_calendar_view.setOnClickListener(this);

        img_menu = (ImageView) findViewById(R.id.img_menu);
        img_menu.setOnClickListener(this);
        img_help = (ImageView) findViewById(R.id.img_help);
        img_help.setOnClickListener(this);

        customCalendarView = (CustomCalendarView) findViewById(R.id.calendar_view_sleep_tracker);
        Calendar currentCalendar = Calendar.getInstance(Locale.getDefault());
        customCalendarView.setFirstDayOfWeek(Calendar.MONDAY);
        customCalendarView.refreshCalendar(currentCalendar);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.img_calendar_view:
                if (customCalendarView.getVisibility() == View.GONE) {
                    customCalendarView.setVisibility(View.VISIBLE);
                } else {
                    customCalendarView.setVisibility(View.GONE);
                }
                break;
            case R.id.img_menu:
                Utility.customMenu(JournalActivity.this);
                break;
            case R.id.img_help:
                Utility.customHelp(JournalActivity.this);
                break;
            default:
                break;
        }
    }
}
