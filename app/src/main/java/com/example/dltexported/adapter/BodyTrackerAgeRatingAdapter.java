package com.example.dltexported.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dltexported.R;

import java.util.List;

/**
 * Created by bhumit on 13/2/17.
 */
public class BodyTrackerAgeRatingAdapter extends BaseExpandableListAdapter {
    private Context mContext;
    private List<String> parentList;
    private LayoutInflater layoutInflater = null;

    public BodyTrackerAgeRatingAdapter(Context mContext, List<String> parentList) {
        this.mContext = mContext;
        this.parentList = parentList;
        this.layoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        ;
    }

    @Override
    public int getGroupCount() {
        return parentList.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return 1;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return parentList.get(groupPosition);
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
        convertView = layoutInflater.inflate(R.layout.phisiological_age_parent_layout, null);
        TextView tv_age_heading = (TextView) convertView.findViewById(R.id.tv_age_heading);
        ImageView iv_plus_minus = (ImageView) convertView.findViewById(R.id.iv_plus_minus);

        tv_age_heading.setText(parentList.get(groupPosition).toString());

        if (isExpanded) {
            iv_plus_minus.setImageResource(R.drawable.ic_remove_black_24dp);
        } else {
            iv_plus_minus.setImageResource(R.drawable.ic_add_black_24dp);
        }
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        convertView = layoutInflater.inflate(R.layout.phisiological_age_child_layout, null);
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }
}
