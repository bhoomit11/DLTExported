package com.example.dltexported.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.SwitchCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.dltexported.R;

import java.util.List;

/**
 * Created by Bhoomit on 1/29/2017.
 */
public class TrackDayViewAdapter extends BaseAdapter {
        private Context mContext;
        List<String> actionList;
        private LayoutInflater layoutInflater = null;

        public TrackDayViewAdapter(Context mContext, List<String> actionList) {
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
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView = layoutInflater.inflate(R.layout.subcategory_track_actions, null);
            final LinearLayout ll_actionlist_bg = (LinearLayout) convertView.findViewById(R.id.ll_actionlist_bg);
            SwitchCompat sc_action_toggle = (SwitchCompat) convertView.findViewById(R.id.sc_action_toggle);
            TextView tv_action_name = (TextView) convertView.findViewById(R.id.tv_action_name);

            tv_action_name.setText(actionList.get(position).toString());

            sc_action_toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        ll_actionlist_bg.setBackgroundResource(R.color.orange);
                    } else {
                        ll_actionlist_bg.setBackgroundResource(R.color.grey_back);
                    }
                }
            });

            return convertView;
        }
}
