package com.txc.gridview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class DataAdapter extends BaseAdapter {
	Context mContext;
	int i = 20;

	public DataAdapter(Context context) {
		mContext = context;
	}

	public void addItem() {
		i++;
		notifyDataSetChanged();
	}

	@Override
	public int getCount() {
		return i;
	}

	@Override
	public Object getItem(int position) {
		return position;
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if (convertView == null) {
			convertView = View.inflate(mContext, R.layout.grid_item, null);
		}
		return convertView;
	}
}