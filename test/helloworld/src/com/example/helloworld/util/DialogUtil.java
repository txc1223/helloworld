package com.example.helloworld.util;

import java.util.ArrayList;
import java.util.HashSet;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.widget.TextView;

public class DialogUtil {
	
	public static void showChooseDialog(final String[] items,View view,boolean isSingle,Context context){
		final TextView viewO;
		final HashSet<Integer> list = new HashSet<Integer>();
		if (view instanceof TextView) {
			viewO = (TextView)view;
		}else{
			return;
		}
		AlertDialog.Builder builder = new AlertDialog.Builder(context);
		builder.setTitle("请选择");
		if (isSingle) {
			builder.setSingleChoiceItems(items, 0, new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					viewO.setText(items[which]);
					dialog.dismiss();
				}
			});
		}else{
			builder.setMultiChoiceItems(items, null, new DialogInterface.OnMultiChoiceClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which, boolean isChecked) {
					if (isChecked) {
						list.add(which);
					}else{
						list.remove(which);
					}
				}
			}).setPositiveButton("确定", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					String s = "";
//					for (int i = 0; i < list.size(); i++) {
//						if (i == list.size() - 1) {
//							s += (i+1)+":"+items[list.get(i)];
//						}else{
//							s += (i+1)+":"+items[list.get(i)]+"\n";
//						}
//						
//					}
					for(int i:list){
						s+=items[i]+" ";
					}
					viewO.setText(s);
					dialog.dismiss();
				}
			}).setNegativeButton("取消", null);
		}
	
		builder.create().show();
	}
}
