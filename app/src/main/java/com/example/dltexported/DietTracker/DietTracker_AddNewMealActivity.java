package com.example.dltexported.DietTracker;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;

import com.example.dltexported.R;

import jp.wasabeef.richeditor.RichEditor;

public class DietTracker_AddNewMealActivity extends Activity implements View.OnClickListener {

    Context mContext;
    private RichEditor mEditor;
    private ImageButton ib_bold, ib_italic, ib_underline, ib_strike, ib_super, ib_sub;
    private static Boolean bold = false, italic = false, underline = false, strike = false,
            super_text = false, sub_text = false;
    private Spinner sp_food_class;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_diet_tracker_add_new_meal);

        init();
    }

    public void init() {
        mContext = DietTracker_AddNewMealActivity.this;
        mEditor = (RichEditor) findViewById(R.id.editor);
        mEditor.setEditorHeight(200);
        mEditor.setEditorFontSize(14);
        mEditor.setEditorFontColor(Color.BLACK);
        mEditor.setPadding(8, 8, 8, 8);

        ib_bold = (ImageButton) findViewById(R.id.ib_bold);
        ib_bold.setOnClickListener(this);
        ib_italic = (ImageButton) findViewById(R.id.ib_italic);
        ib_italic.setOnClickListener(this);
        ib_underline = (ImageButton) findViewById(R.id.ib_underline);
        ib_underline.setOnClickListener(this);
        ib_strike = (ImageButton) findViewById(R.id.ib_strikethrough);
        ib_strike.setOnClickListener(this);
        ib_super = (ImageButton) findViewById(R.id.ib_superscript);
        ib_super.setOnClickListener(this);
        ib_sub = (ImageButton) findViewById(R.id.ib_subscript);
        ib_sub.setOnClickListener(this);

        sp_food_class = (Spinner) findViewById(R.id.sp_food_class);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this,
                R.array.spinner_circle, R.layout.spinner_item);
        sp_food_class.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ib_bold:
                mEditor.setBold();
                if (!bold) {
                    bold = true;
                    ib_bold.setBackgroundColor(getResources().getColor(R.color.tab_bg));
                    ib_italic.setBackgroundColor(getResources().getColor(R.color.white));
                    ib_underline.setBackgroundColor(getResources().getColor(R.color.white));
                    ib_strike.setBackgroundColor(getResources().getColor(R.color.white));
                    ib_super.setBackgroundColor(getResources().getColor(R.color.white));
                    ib_sub.setBackgroundColor(getResources().getColor(R.color.white));
                } else {
                    bold = false;
                    ib_bold.setBackgroundColor(getResources().getColor(R.color.white));
                    ib_italic.setBackgroundColor(getResources().getColor(R.color.white));
                    ib_underline.setBackgroundColor(getResources().getColor(R.color.white));
                    ib_strike.setBackgroundColor(getResources().getColor(R.color.white));
                    ib_super.setBackgroundColor(getResources().getColor(R.color.white));
                    ib_sub.setBackgroundColor(getResources().getColor(R.color.white));
                }
                break;
            case R.id.ib_italic:
                mEditor.setItalic();
                if (!italic) {
                    italic = true;
                    ib_bold.setBackgroundColor(getResources().getColor(R.color.white));
                    ib_italic.setBackgroundColor(getResources().getColor(R.color.tab_bg));
                    ib_underline.setBackgroundColor(getResources().getColor(R.color.white));
                    ib_strike.setBackgroundColor(getResources().getColor(R.color.white));
                    ib_super.setBackgroundColor(getResources().getColor(R.color.white));
                    ib_sub.setBackgroundColor(getResources().getColor(R.color.white));
                } else {
                    italic = false;
                    ib_bold.setBackgroundColor(getResources().getColor(R.color.white));
                    ib_italic.setBackgroundColor(getResources().getColor(R.color.white));
                    ib_underline.setBackgroundColor(getResources().getColor(R.color.white));
                    ib_strike.setBackgroundColor(getResources().getColor(R.color.white));
                    ib_super.setBackgroundColor(getResources().getColor(R.color.white));
                    ib_sub.setBackgroundColor(getResources().getColor(R.color.white));
                }
                break;
            case R.id.ib_underline:
                mEditor.setUnderline();
                if (!underline) {
                    underline = true;
                    ib_bold.setBackgroundColor(getResources().getColor(R.color.white));
                    ib_italic.setBackgroundColor(getResources().getColor(R.color.white));
                    ib_underline.setBackgroundColor(getResources().getColor(R.color.tab_bg));
                    ib_strike.setBackgroundColor(getResources().getColor(R.color.white));
                    ib_super.setBackgroundColor(getResources().getColor(R.color.white));
                    ib_sub.setBackgroundColor(getResources().getColor(R.color.white));
                } else {
                    underline = false;
                    ib_bold.setBackgroundColor(getResources().getColor(R.color.white));
                    ib_italic.setBackgroundColor(getResources().getColor(R.color.white));
                    ib_underline.setBackgroundColor(getResources().getColor(R.color.white));
                    ib_strike.setBackgroundColor(getResources().getColor(R.color.white));
                    ib_super.setBackgroundColor(getResources().getColor(R.color.white));
                    ib_sub.setBackgroundColor(getResources().getColor(R.color.white));
                }
                break;
            case R.id.ib_strikethrough:
                mEditor.setStrikeThrough();
                if (!strike) {
                    strike = true;
                    ib_bold.setBackgroundColor(getResources().getColor(R.color.white));
                    ib_italic.setBackgroundColor(getResources().getColor(R.color.white));
                    ib_underline.setBackgroundColor(getResources().getColor(R.color.white));
                    ib_strike.setBackgroundColor(getResources().getColor(R.color.tab_bg));
                    ib_super.setBackgroundColor(getResources().getColor(R.color.white));
                    ib_sub.setBackgroundColor(getResources().getColor(R.color.white));
                } else {
                    strike = false;
                    ib_bold.setBackgroundColor(getResources().getColor(R.color.white));
                    ib_italic.setBackgroundColor(getResources().getColor(R.color.white));
                    ib_underline.setBackgroundColor(getResources().getColor(R.color.white));
                    ib_strike.setBackgroundColor(getResources().getColor(R.color.white));
                    ib_super.setBackgroundColor(getResources().getColor(R.color.white));
                    ib_sub.setBackgroundColor(getResources().getColor(R.color.white));
                }
                break;
            case R.id.ib_superscript:
                mEditor.setSuperscript();
                if (!super_text) {
                    super_text = true;
                    ib_bold.setBackgroundColor(getResources().getColor(R.color.white));
                    ib_italic.setBackgroundColor(getResources().getColor(R.color.white));
                    ib_underline.setBackgroundColor(getResources().getColor(R.color.white));
                    ib_strike.setBackgroundColor(getResources().getColor(R.color.white));
                    ib_super.setBackgroundColor(getResources().getColor(R.color.tab_bg));
                    ib_sub.setBackgroundColor(getResources().getColor(R.color.white));
                } else {
                    super_text = false;
                    ib_bold.setBackgroundColor(getResources().getColor(R.color.white));
                    ib_italic.setBackgroundColor(getResources().getColor(R.color.white));
                    ib_underline.setBackgroundColor(getResources().getColor(R.color.white));
                    ib_strike.setBackgroundColor(getResources().getColor(R.color.white));
                    ib_super.setBackgroundColor(getResources().getColor(R.color.white));
                    ib_sub.setBackgroundColor(getResources().getColor(R.color.white));
                }
                break;
            case R.id.ib_subscript:
                mEditor.setSubscript();
                if (!sub_text) {
                    sub_text = true;
                    ib_bold.setBackgroundColor(getResources().getColor(R.color.white));
                    ib_italic.setBackgroundColor(getResources().getColor(R.color.white));
                    ib_underline.setBackgroundColor(getResources().getColor(R.color.white));
                    ib_strike.setBackgroundColor(getResources().getColor(R.color.white));
                    ib_super.setBackgroundColor(getResources().getColor(R.color.white));
                    ib_sub.setBackgroundColor(getResources().getColor(R.color.tab_bg));
                } else {
                    sub_text = false;
                    ib_bold.setBackgroundColor(getResources().getColor(R.color.white));
                    ib_italic.setBackgroundColor(getResources().getColor(R.color.white));
                    ib_underline.setBackgroundColor(getResources().getColor(R.color.white));
                    ib_strike.setBackgroundColor(getResources().getColor(R.color.white));
                    ib_super.setBackgroundColor(getResources().getColor(R.color.white));
                    ib_sub.setBackgroundColor(getResources().getColor(R.color.white));
                }
                break;
        }
    }
}
