package com.example.helloworld.util;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ViewFlipper;

import com.example.helloworld.R;



/**
 * UtilViewFillperAnimaction.java<br/>
 * Date:2011-10-12 <br/>
 * Author:XiaQiulei <br/>
 * Version:v1.0 <br/>
 * Title:ViewFillper切换动画
 */
public class UtilViewFillper {

	/**
	 * 改变ViewFillper的显示界面，只能是水平动画，如果是向右的话，则执行向右的动画，否则执行向左的动画
	 * 
	 * @param context 上下文
	 * @param vf ViewFillper 对象
	 * @param idx 要显示的视图的下标
	 */
	public static void changeViewByHorizontalnAnim(Context context, ViewFlipper vf, int idx) {

		int currentIdx = vf.getDisplayedChild();
		if (idx == currentIdx) {
			return;
		}
		Animation leftIn = AnimationUtils.loadAnimation(context, R.anim.left_in);
		Animation leftOut = AnimationUtils.loadAnimation(context, R.anim.left_out);
		Animation rightIn = AnimationUtils.loadAnimation(context, R.anim.right_in);
		Animation rightOut = AnimationUtils.loadAnimation(context, R.anim.right_out);
		Animation in = null;
		Animation out = null;
		if (idx > currentIdx) {
			in = leftIn;
			out = leftOut;
		} else if (idx < currentIdx) {
			in = rightIn;
			out = rightOut;
		} else {
			return;
		}
		vf.setInAnimation(in);
		vf.setOutAnimation(out);
		vf.setDisplayedChild(idx);
	}
	/**
	 * 改变ViewFillper的显示界面，只能是竖直的动画，如果是向上的话，则执行向上的动画，否则执行向下的动画
	 * 
	 * @param context 上下文
	 * @param vf ViewFillper 对象
	 * @param idx 要显示的视图的下标
	 */
	public static void changeViewByVerticalAnim(Context context, ViewFlipper vf, int idx) {

		int currentIdx = vf.getDisplayedChild();
		if (idx == currentIdx) {
			return;
		}
		Animation upIn = AnimationUtils.loadAnimation(context, R.anim.up_in);
		Animation upOut = AnimationUtils.loadAnimation(context, R.anim.up_out);
		Animation downIn = AnimationUtils.loadAnimation(context, R.anim.down_in);
		Animation downOut = AnimationUtils.loadAnimation(context, R.anim.down_out);
		Animation in = null;
		Animation out = null;
		if (idx > currentIdx) {
			in = upIn;
			out = upOut;
		} else if (idx < currentIdx) {
			in = downIn;
			out = downOut;
		} else {
			return;
		}
		vf.setInAnimation(in);
		vf.setOutAnimation(out);
		vf.setDisplayedChild(idx);
	}
	/**
	 * 改变ViewFillper的显示界面，只能是水平动画，如果是向右的话，则执行向右的3D动画，否则执行向左的3D动画
	 * 
	 * @param context 上下文
	 * @param vf ViewFillper 对象
	 * @param idx 要显示的视图的下标
	 */
	public static void changeViewByHorizontaln3DAnim(Context context, ViewFlipper vf, int idx) {
		int currentIdx = vf.getDisplayedChild();
		if (idx == currentIdx) {
			return;
		}
		Animation in = null;
		Animation out = null;
		final int xCenter = vf.getWidth() / 2;
		final int TIME = 1000;
		if (idx < currentIdx) {
			// 向后
			out = new Rotate3d(0, -90, 0.0f, 0.0f, xCenter, 0);
			in = new Rotate3d(90, 0, 0.0f, 0.0f, xCenter, 0);
		} else if (idx > currentIdx) {
			// 向前
			in = new Rotate3d(-90, 0, 0.0f, 0.0f, xCenter, 0);
			out = new Rotate3d(0, 90, 0.0f, 0.0f, xCenter, 0);
		} else {
			return;
		}
		// in.setFillAfter(true);
		in.setDuration(TIME);
		// out.setFillAfter(true);
		out.setDuration(TIME);
		vf.setInAnimation(in);
		vf.setOutAnimation(out);
		vf.setDisplayedChild(idx);
	}

	/**
	 * 添加一个新的子View，改变ViewFillper的显示界面，可以是水平、竖直方向的，如果是向右的话，则执行向右的动画，否则执行向左的动画
	 * 
	 * @param context 上下文
	 * @param vf ViewFillper对象
	 * @param newView 新加的子View
	 * @param vsd 方向
	 */
	public static void changeAddNewViewByAnim(Context context, ViewFlipper vf, View newView, VfScrollDirection vsd) {
		Animation leftIn = AnimationUtils.loadAnimation(context, R.anim.left_in);
		Animation leftOut = AnimationUtils.loadAnimation(context, R.anim.left_out);
		Animation rightIn = AnimationUtils.loadAnimation(context, R.anim.right_in);
		Animation rightOut = AnimationUtils.loadAnimation(context, R.anim.right_out);
		Animation upOut = AnimationUtils.loadAnimation(context, R.anim.up_out);
		Animation upIn = AnimationUtils.loadAnimation(context, R.anim.up_in);
		Animation downOut = AnimationUtils.loadAnimation(context, R.anim.down_out);
		Animation downIn = AnimationUtils.loadAnimation(context, R.anim.down_in);

		Animation in = null;
		Animation out = null;
		if (vsd == VfScrollDirection.Left2Right) {
			in = leftIn;
			out = leftOut;
		} else if (vsd == VfScrollDirection.Right2Left) {
			in = rightIn;
			out = rightOut;
		} else if (vsd == VfScrollDirection.Up2Down) {
			in = downIn;
			out = downOut;
		} else if (vsd == VfScrollDirection.Down2Up) {
			in = upIn;
			out = upOut;
		}
		vf.addView(newView);
		vf.setInAnimation(in);
		vf.setOutAnimation(out);
		vf.showNext();
		vf.removeViewAt(0);
	}

	/**
	 * 添加一个新的子View，改变ViewFillper的显示界面，只能是水平动画，如果是向右的话，则执行向右的3D动画，否则执行向左的3D动画
	 * 
	 * @param context 上下文
	 * @param vf ViewFillper对象
	 * @param newView 新加的子View
	 * @param vsd 方向
	 */
	public static void changeAddNewViewByHorizontaln3DAnim(Context context, ViewFlipper vf, View newView, VfScrollDirection vsd) {
		Animation in = null;
		Animation out = null;
		final int xCenter = vf.getWidth() / 2;
		final int TIME = 1000;
		if (vsd == VfScrollDirection.Left2Right) {
			// 向后
			out = new Rotate3d(0, -90, 0.0f, 0.0f, xCenter, 0);
			in = new Rotate3d(90, 0, 0.0f, 0.0f, xCenter, 0);
		} else if (vsd == VfScrollDirection.Right2Left) {
			// 向前
			in = new Rotate3d(-90, 0, 0.0f, 0.0f, xCenter, 0);
			out = new Rotate3d(0, 90, 0.0f, 0.0f, xCenter, 0);
		} else {
			return;
		}
		// in.setFillAfter(true);
		in.setDuration(TIME);
		// out.setFillAfter(true);
		out.setDuration(TIME);

		vf.addView(newView);
		vf.setInAnimation(in);
		vf.setOutAnimation(out);
		vf.showNext();
		vf.removeViewAt(0);
	}

	/**
	 * ViewFillper，切换的方向
	 */
	public static enum VfScrollDirection {
		Right2Left, Left2Right, Up2Down, Down2Up
	}
}