package com.example.helloworld.util;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.view.animation.Animation;
import android.view.animation.Transformation;

/**
 * Rotate3d.java<br/>
 * Date:2011-10-10 <br/>
 * Author:XiaQiulei <br/>
 * Version:v1.0 <br/>
 * Title:3d动画
 * @see com.beyondbit.smartbox.util.UtilViewFillper#changeViewByHorizontaln3DAnim 
 * @see com.beyondbit.smartbox.util.UtilViewFillper#changeAddNewViewByHorizontaln3DAnim
 */
public class Rotate3d extends Animation {
	private float mFromDegree;
	private float mToDegree;
	private float mCenterX;
	private float mCenterY;
	float mLeft;
	float mTop;
	private Camera mCamera;
	// 默认情况是76
	private final int deg_76 = 65;

	public Rotate3d(float fromDegree, float toDegree, float left, float top, float centerX, float centerY) {
		this.mFromDegree = fromDegree;
		this.mToDegree = toDegree;
		this.mLeft = left;
		this.mTop = top;
		this.mCenterX = centerX;
		this.mCenterY = centerY;

	}

	public void initialize(int width, int height, int parentWidth, int parentHeight) {
		super.initialize(width, height, parentWidth, parentHeight);
		mCamera = new Camera();
	}

	protected void applyTransformation(float interpolatedTime, Transformation t) {
		final float FromDegree = mFromDegree;
		float degrees = FromDegree + (mToDegree - mFromDegree) * interpolatedTime;
		final float centerX = mCenterX;
		final float centerY = mCenterY;
		final Matrix matrix = t.getMatrix();

		if (degrees <= -deg_76) {
			degrees = -90.0f;
			mCamera.save();
			mCamera.rotateY(degrees);
			mCamera.getMatrix(matrix);
			mCamera.restore();
		} else if (degrees >= deg_76) {
			degrees = 90.0f;
			mCamera.save();
			mCamera.rotateY(degrees);
			mCamera.getMatrix(matrix);
			mCamera.restore();
		} else {
			mCamera.save();
			mCamera.translate(0, 0, centerX);
			mCamera.rotateY(degrees);
			mCamera.translate(0, 0, -centerX);
			mCamera.getMatrix(matrix);
			mCamera.restore();
		}

		matrix.preTranslate(-centerX, -centerY);
		matrix.postTranslate(centerX, centerY);
	}
}