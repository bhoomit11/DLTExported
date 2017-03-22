package com.example.dltexported.adapter;

import android.content.Context;
import android.support.v7.widget.SwitchCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.BaseExpandableListAdapter;
import android.widget.CompoundButton;
import android.widget.ExpandableListAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.dltexported.R;

import java.util.List;

/**
 * Created by Bhoomit on 1/29/2017.
 */
//public class TrackWeekViewAdapter extends BaseAdapter {
//    private Context mContext;
//    List<String> actionList;
//    private LayoutInflater layoutInflater = null;
//
//    public TrackWeekViewAdapter(Context mContext, List<String> actionList) {
//        this.mContext = mContext;
//        this.actionList = actionList;
//        layoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//    }
//
//    @Override
//    public int getCount() {
//        return actionList.size();
//    }
//
//    @Override
//    public Object getItem(int position) {
//        return actionList.get(position);
//    }
//
//    @Override
//    public long getItemId(int position) {
//        return position;
//    }
//
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        convertView = layoutInflater.inflate(R.layout.subcategory_track_actions2, null);
//        final LinearLayout ll_actionlist_bg = (LinearLayout) convertView.findViewById(R.id.ll_actionlist_bg);
//        TextView tv_action_name = (TextView) convertView.findViewById(R.id.tv_action_name);
//
//        tv_action_name.setText(actionList.get(position).toString());
//        return convertView;
//    }
//}


public class TrackWeekViewAdapter extends BaseExpandableListAdapter {
    private Context mContext;
    List<String> actionList;
    private LayoutInflater layoutInflater = null;

    public TrackWeekViewAdapter(Context mContext, List<String> actionList) {
        this.mContext = mContext;
        this.actionList = actionList;
        layoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getGroupCount() {
        return actionList.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return 1;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return actionList.get(groupPosition);
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
        convertView = layoutInflater.inflate(R.layout.subcategory_track_actions2, null);
        final LinearLayout ll_actionlist_bg = (LinearLayout) convertView.findViewById(R.id.ll_actionlist_bg);
        TextView tv_action_name = (TextView) convertView.findViewById(R.id.tv_action_name);

        tv_action_name.setText(actionList.get(groupPosition).toString());
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        convertView = layoutInflater.inflate(R.layout.day_details_view, null);

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }
}