package com.example.dltexported.category;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SwitchCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.BaseAdapter;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.eralp.circleprogressview.CircleProgressView;
import com.example.dltexported.R;
import com.example.dltexported.adapter.TrackDayViewAdapter;
import com.example.dltexported.adapter.TrackWeekViewAdapter;
import com.example.dltexported.attributes.ExpandableHeightListview;
import com.example.dltexported.attributes.NonScrollExpandableListView;
import com.example.dltexported.attributes.Utility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubCategoryActivity extends AppCompatActivity implements View.OnClickListener {
    private Context mContext;
    private LinearLayout ll_trackManageMenu;
    private ImageView img_menu, img_help;
    private ImageView iv_subMenu;
    private RelativeLayout rl_trackManage;
    private CircleProgressView cpv_physical, cp_physical_track, cp_all_action;
    private Button btn_edit, btn_weekday_view;
    private LinearLayout ll_editDetails, ll_track_actions, ll_tack_manage_main, ll_manage_actions,
            ll_manage_list, ll_edit_action, ll_subcategory_add;
    private ExpandableHeightListview lv_dayWeekList, lv_manage_list;
    private NonScrollExpandableListView lv_subcategory;
    private NonScrollExpandableListView lv_weekList;
    private TrackDayViewAdapter trackDayViewAdapter;
    private TrackWeekViewAdapter trackWeekViewAdapter;
    private ManageActionAdapter manageActionAdapter;
    private SubcategoryAdapter subcategoryAdapter;
    private TextView tv_track_action, tv_manageActions;
    private EditText et_editAction;
    List<String> actionList, subCategoryList;
    Button btn_save_action, btn_subcategory_save;
    ImageView iv_cancel_manage, iv_subcategory_add;
    private SwitchCompat switchAll;
    private TextView tvDayWeek, tvDayWeekDate;
    private Button btnAllAction, btnListCategory, btnListSingle;
    private EditText et_subcategory_name;
    private LinearLayout ll_simple_cp_view, ll_all_action_cp_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_category);

        initUi();
    }

    private void initUi() {
        mContext = SubCategoryActivity.this;
        img_menu = (ImageView) findViewById(R.id.img_menu);
        img_menu.setOnClickListener(this);
        img_help = (ImageView) findViewById(R.id.img_help);
        img_help.setOnClickListener(this);
        ll_trackManageMenu = (LinearLayout) findViewById(R.id.ll_track_manage_menu);
        rl_trackManage = (RelativeLayout) findViewById(R.id.rl_track_manage);
        iv_subMenu = (ImageView) findViewById(R.id.iv_sub_menu);

        ll_editDetails = (LinearLayout) findViewById(R.id.ll_edit_details);
        ll_track_actions = (LinearLayout) findViewById(R.id.ll_track_actions);
        ll_tack_manage_main = (LinearLayout) findViewById(R.id.ll_tack_manage_main);
        ll_manage_actions = (LinearLayout) findViewById(R.id.ll_manage_actions);
        ll_manage_list = (LinearLayout) findViewById(R.id.ll_manage_list);
        ll_edit_action = (LinearLayout) findViewById(R.id.ll_edit_action);
        ll_subcategory_add = (LinearLayout) findViewById(R.id.ll_subcategory_add);
        ll_simple_cp_view = (LinearLayout) findViewById(R.id.ll_simple_cp_view);
        ll_all_action_cp_view = (LinearLayout) findViewById(R.id.ll_all_action_cp_view);

        iv_subcategory_add = (ImageView) findViewById(R.id.iv_subcategory_add);
        iv_subcategory_add.setOnClickListener(this);
        btn_subcategory_save = (Button) findViewById(R.id.btn_subcategory_save);
        et_subcategory_name = (EditText) findViewById(R.id.et_subcategory_name);
        btn_subcategory_save.setOnClickListener(this);
        tv_track_action = (TextView) findViewById(R.id.tv_track_action);
        tv_track_action.setOnClickListener(this);
        tv_manageActions = (TextView) findViewById(R.id.tv_manageActions);
        tv_manageActions.setOnClickListener(this);
        btn_edit = (Button) findViewById(R.id.btn_edit_details);
        btn_edit.setOnClickListener(this);
        iv_cancel_manage = (ImageView) findViewById(R.id.iv_cancel_manage);
        iv_cancel_manage.setOnClickListener(this);
        btn_weekday_view = (Button) findViewById(R.id.btn_week_day_view);
        btn_weekday_view.setOnClickListener(this);
        btnAllAction = (Button) findViewById(R.id.btn_view_all_action);
        btnAllAction.setOnClickListener(this);
        btnListCategory = (Button) findViewById(R.id.btn_list_category);
        btnListCategory.setOnClickListener(this);
        btnListSingle = (Button) findViewById(R.id.btn_list_single_category);
        btnListSingle.setOnClickListener(this);

        lv_dayWeekList = (ExpandableHeightListview) findViewById(R.id.lv_day_week_view);
        lv_manage_list = (ExpandableHeightListview) findViewById(R.id.lv_manage_list);
        lv_subcategory = (NonScrollExpandableListView) findViewById(R.id.lv_subcategory);
        lv_weekList = (NonScrollExpandableListView) findViewById(R.id.lv_week_view);

        switchAll = (SwitchCompat) findViewById(R.id.switch_all);
        et_editAction = (EditText) findViewById(R.id.et_edit_manage_action);
        tvDayWeek = (TextView) findViewById(R.id.tv_day_week);
        tvDayWeekDate = (TextView) findViewById(R.id.tv_day_week_date);

        actionList = Arrays.asList(getResources().getStringArray(R.array.track_action_list));
        subCategoryList = new ArrayList<>();

        trackDayViewAdapter = new TrackDayViewAdapter(mContext, actionList);
        trackWeekViewAdapter = new TrackWeekViewAdapter(mContext, actionList);
        manageActionAdapter = new ManageActionAdapter(mContext, actionList);
        subcategoryAdapter = new SubcategoryAdapter(mContext, subCategoryList);

        lv_dayWeekList.setAdapter(trackDayViewAdapter);
        lv_dayWeekList.setExpanded(true);
        lv_manage_list.setAdapter(manageActionAdapter);
        lv_manage_list.setExpanded(true);
        lv_subcategory.setAdapter(subcategoryAdapter);

        btn_save_action = (Button) findViewById(R.id.btn_save_action);
        btn_save_action.setOnClickListener(this);

        cpv_physical = (CircleProgressView) findViewById(R.id.circular_progress_physical);
        cpv_physical.setInterpolator(new AccelerateDecelerateInterpolator());
        cpv_physical.setStartAngle(180);
        cpv_physical.setTextEnabled(false);
        cpv_physical.setProgressWithAnimation(50, 1000);

        cp_physical_track = (CircleProgressView) findViewById(R.id.cp_physical_track);
        cp_all_action = (CircleProgressView) findViewById(R.id.cp_all_action);

        rl_trackManage.setOnClickListener(this);

        lv_subcategory.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {
                View v = lv_subcategory.getChildAt(groupPosition);
                RelativeLayout rl_subcategory_row = (RelativeLayout) v.findViewById(R.id.rl_subcategory_row);
                rl_subcategory_row.setVisibility(View.GONE);
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rl_track_manage:
                if (ll_trackManageMenu.getVisibility() == View.GONE) {
                    ll_trackManageMenu.setVisibility(View.VISIBLE);
                    iv_subMenu.setImageResource(R.drawable.bluearrow_up);
                } else {
                    ll_trackManageMenu.setVisibility(View.GONE);
                    iv_subMenu.setImageResource(R.drawable.bluearrow_down);
                }
                break;
            case R.id.btn_edit_details:
                if (ll_editDetails.getVisibility() == View.GONE) {
                    ll_editDetails.setVisibility(View.VISIBLE);
                } else {
                    ll_editDetails.setVisibility(View.GONE);
                }
                break;
            case R.id.btn_week_day_view:
                if (btn_weekday_view.getText().toString().contains("Week")) {
                    lv_weekList.setAdapter(trackWeekViewAdapter);
                    lv_weekList.setVisibility(View.VISIBLE);
                    lv_dayWeekList.setVisibility(View.GONE);
                    switchAll.setVisibility(View.GONE);
                    tvDayWeek.setText("Classic DLT Week View");
                    tvDayWeekDate.setText("Week Commencing 4/7/2017");
                    btn_weekday_view.setText("Switch To Day View");
                } else if (btn_weekday_view.getText().toString().contains("Day")) {
                    lv_dayWeekList.setAdapter(trackDayViewAdapter);
                    lv_dayWeekList.setVisibility(View.VISIBLE);
                    lv_weekList.setVisibility(View.GONE);
                    switchAll.setVisibility(View.VISIBLE);
                    tvDayWeek.setText("DLT Day View: 7/7/17");
                    tvDayWeekDate.setText("Complete all actions for 7/7/17");
                    btn_weekday_view.setText("Switch To Week View");
                }
                break;
            case R.id.btn_view_all_action:
                if (btnListCategory.getVisibility() == View.GONE || btnListSingle.getVisibility() == View.GONE) {
                    btnListCategory.setVisibility(View.VISIBLE);
                    btnListSingle.setVisibility(View.VISIBLE);
                    btnAllAction.setVisibility(View.GONE);

                    ll_simple_cp_view.setVisibility(View.GONE);
                    ll_all_action_cp_view.setVisibility(View.VISIBLE);

                    actionList = Arrays.asList(getResources().getStringArray(R.array.track_all_action_list));
                    trackDayViewAdapter = new TrackDayViewAdapter(mContext, actionList);
                    trackWeekViewAdapter = new TrackWeekViewAdapter(mContext, actionList);
                    lv_weekList.setAdapter(trackWeekViewAdapter);
                    lv_dayWeekList.setAdapter(trackDayViewAdapter);

                    cp_all_action.setInterpolator(new AccelerateDecelerateInterpolator());
                    cp_all_action.setStartAngle(180);
                    cp_all_action.setTextEnabled(false);
                    cp_all_action.setProgressWithAnimation(50, 1000);
                } else {
                    btnListCategory.setVisibility(View.GONE);
                    btnListSingle.setVisibility(View.GONE);
                    btnAllAction.setVisibility(View.VISIBLE);

                    ll_simple_cp_view.setVisibility(View.VISIBLE);
                    ll_all_action_cp_view.setVisibility(View.GONE);
                }
                break;
            case R.id.btn_list_category:
                if (btnListCategory.getVisibility() == View.VISIBLE || btnListSingle.getVisibility() == View.VISIBLE) {
                    btnListCategory.setVisibility(View.GONE);
                    btnListSingle.setVisibility(View.GONE);
                    btnAllAction.setVisibility(View.VISIBLE);

                    ll_simple_cp_view.setVisibility(View.VISIBLE);
                    ll_all_action_cp_view.setVisibility(View.GONE);

                    cp_physical_track.setInterpolator(new AccelerateDecelerateInterpolator());
                    cp_physical_track.setStartAngle(180);
                    cp_physical_track.setTextEnabled(false);
                    cp_physical_track.setProgressWithAnimation(50, 1000);

                    actionList = Arrays.asList(getResources().getStringArray(R.array.track_action_list));
                    trackDayViewAdapter = new TrackDayViewAdapter(mContext, actionList);
                    trackWeekViewAdapter = new TrackWeekViewAdapter(mContext, actionList);
                    lv_weekList.setAdapter(trackWeekViewAdapter);
                    lv_dayWeekList.setAdapter(trackDayViewAdapter);

                }
                break;
            case R.id.tv_track_action:
                if (ll_track_actions.getVisibility() == View.GONE) {
                    ll_track_actions.setVisibility(View.VISIBLE);
                    ll_tack_manage_main.setVisibility(View.GONE);
                    ll_trackManageMenu.setVisibility(View.GONE);
                    ll_manage_actions.setVisibility(View.GONE);
                    iv_subMenu.setImageResource(R.drawable.bluearrow_down);
                    ll_manage_list.setVisibility(View.GONE);
                    ll_edit_action.setVisibility(View.GONE);

                    cp_physical_track.setInterpolator(new AccelerateDecelerateInterpolator());
                    cp_physical_track.setStartAngle(180);
                    cp_physical_track.setTextEnabled(false);
                    cp_physical_track.setProgressWithAnimation(50, 1000);
                }
                break;
            case R.id.tv_manageActions:
                if (ll_manage_actions.getVisibility() == View.GONE) {
                    ll_track_actions.setVisibility(View.GONE);
                    ll_tack_manage_main.setVisibility(View.GONE);
                    ll_trackManageMenu.setVisibility(View.GONE);
                    ll_manage_actions.setVisibility(View.VISIBLE);
                    ll_manage_list.setVisibility(View.VISIBLE);
                    ll_edit_action.setVisibility(View.GONE);
                    iv_subMenu.setImageResource(R.drawable.bluearrow_down);
                }
                break;
            case R.id.btn_save_action:
                ll_manage_list.setVisibility(View.VISIBLE);
                ll_edit_action.setVisibility(View.GONE);
                break;
            case R.id.iv_cancel_manage:
                ll_manage_list.setVisibility(View.VISIBLE);
                ll_edit_action.setVisibility(View.GONE);
                break;
            case R.id.iv_subcategory_add:
                if (ll_subcategory_add.getVisibility() == View.GONE) {
                    ll_subcategory_add.setVisibility(View.VISIBLE);
//                    iv_subcategory_add.setImageResource(R.drawable.minus);
                } else {
                    ll_subcategory_add.setVisibility(View.GONE);
                }
                break;
            case R.id.btn_subcategory_save:
                if (!et_subcategory_name.getText().toString().equalsIgnoreCase("")) {
                    subCategoryList.add(et_subcategory_name.getText().toString());
                    subcategoryAdapter.notifyDataSetChanged();
                    ll_subcategory_add.setVisibility(View.GONE);
                } else {
                    Snackbar.make(getWindow().getDecorView().getRootView(), "Enter Subcategory Name", Snackbar.LENGTH_LONG).show();
                }
                break;
            case R.id.img_menu:
                Utility.customMenu(SubCategoryActivity.this);
                break;
            case R.id.img_help:
                Utility.customHelp(SubCategoryActivity.this);
                break;
            default:
                break;
        }
    }

    public class ManageActionAdapter extends BaseAdapter {
        private Context mContext;
        List<String> actionList;
        private LayoutInflater layoutInflater = null;

        public ManageActionAdapter(Context mContext, List<String> actionList) {
            this.mContext = mContext;
            this.actionList = actionList;
            layoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getCount() {
            return actionList.size();
        }

        @Override
        public Object getItem(int position) {
            return actionList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            convertView = layoutInflater.inflate(R.layout.category_manage_list, null);
            TextView tv_manage_action = (TextView) convertView.findViewById(R.id.tv_manage_action);
            LinearLayout ll_edit_manage_action = (LinearLayout) convertView.findViewById(R.id.ll_edit_manage_action);

            tv_manage_action.setText(actionList.get(position).toString());

            ll_edit_manage_action.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ll_manage_list.setVisibility(View.GONE);
                    ll_edit_action.setVisibility(View.VISIBLE);

                    et_editAction.setText(actionList.get(position).toString());
                }
            });
            return convertView;
        }
    }

//    public class SubcategoryAdapter extends BaseAdapter {
//        private Context mContext;
//        List<String> subCategoryList;
//        private LayoutInflater layoutInflater = null;
//
//        public SubcategoryAdapter(Context mContext, List<String> subCategoryList) {
//            this.mContext = mContext;
//            this.subCategoryList = subCategoryList;
//            layoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        }
//
//        @Override
//        public int getCount() {
//            return subCategoryList.size();
//        }
//
//        @Override
//        public Object getItem(int position) {
//            return subCategoryList.get(position);
//        }
//
//        @Override
//        public long getItemId(int position) {
//            return position;
//        }
//
//        @Override
//        public View getView(int position, View convertView, ViewGroup parent) {
//            convertView = layoutInflater.inflate(R.layout.subcategory_list, null);
//            TextView tv_subcategory = (TextView) convertView.findViewById(R.id.tv_subcategory);
//            TextView tv_subcategory_name = (TextView) convertView.findViewById(R.id.tv_subcategory_name);
//            final RelativeLayout rl_subcategory_row = (RelativeLayout) convertView.findViewById(R.id.rl_subcategory_row);
//            final LinearLayout ll_subcategory_detail = (LinearLayout) convertView.findViewById(R.id.ll_subcategory_detail);
//            final ImageView iv_hide_details = (ImageView) convertView.findViewById(R.id.iv_hide_details);
//
//            tv_subcategory.setText(subCategoryList.get(position));
//            tv_subcategory_name.setText(subCategoryList.get(position));
//
//            return convertView;
//        }
//    }

    public class SubcategoryAdapter extends BaseExpandableListAdapter {
        private Context mContext;
        List<String> subCategoryList;
        private LayoutInflater layoutInflater = null;

        RelativeLayout rl_subcategory_row;

        public SubcategoryAdapter(Context mContext, List<String> subCategoryList) {
            this.mContext = mContext;
            this.subCategoryList = subCategoryList;
            layoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getGroupCount() {
            return subCategoryList.size();
        }

        @Override
        public int getChildrenCount(int groupPosition) {
            return 1;
        }

        @Override
        public Object getGroup(int groupPosition) {
            return subCategoryList.get(groupPosition);
        }

        @Override
        public Object getChild(int groupPosition, int childPosition) {
            return null;
        }

        @Override
        public long getGroupId(int groupPosition) {
            return groupPosition;
        }

        @Override
        public long getChildId(int groupPosition, int childPosition) {
            return childPosition;
        }

        @Override
        public boolean hasStableIds() {
            return false;
        }

        @Override
        public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
            convertView = layoutInflater.inflate(R.layout.subcategory_list, null);
            TextView tv_subcategory = (TextView) convertView.findViewById(R.id.tv_subcategory);
            rl_subcategory_row = (RelativeLayout) convertView.findViewById(R.id.rl_subcategory_row);

            tv_subcategory.setText(subCategoryList.get(groupPosition));
            return convertView;
        }

        @Override
        public View getChildView(final int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
            convertView = layoutInflater.inflate(R.layout.subcategory_list_child, null);

            final LinearLayout ll_subcategory_detail = (LinearLayout) convertView.findViewById(R.id.ll_subcategory_detail);
            final ImageView iv_hide_details = (ImageView) convertView.findViewById(R.id.iv_hide_details);
            TextView tv_subcategory_name = (TextView) convertView.findViewById(R.id.tv_subcategory_name);

            tv_subcategory_name.setText(subCategoryList.get(groupPosition));

            iv_hide_details.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    lv_subcategory.collapseGroup(groupPosition);
                    rl_subcategory_row.setVisibility(View.VISIBLE);
                }
            });
            return convertView;
        }

        @Override
        public boolean isChildSelectable(int groupPosition, int childPosition) {
            return false;
        }
    }
}
