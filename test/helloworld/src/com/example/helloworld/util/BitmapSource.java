package com.example.helloworld.util;

import android.graphics.Bitmap;
import android.graphics.Matrix;

public class BitmapSource {
	public static Bitmap zoomByArea(Bitmap source, int width, int height) {
		int sourceWidth = source.getWidth();
		int sourceHeight = source.getHeight();

		float scale = Math.min((float) width / sourceWidth, (float) height
				/ sourceHeight);

		Matrix matrix = new Matrix();
		matrix.postScale(scale, scale);
		return Bitmap.createBitmap(source, 0, 0, sourceWidth, sourceHeight,
				matrix, true);
	}

	public static Bitmap zoomByArea(Bitmap source, int edge) {
		return zoomByArea(source, edge, edge);
	}
}

