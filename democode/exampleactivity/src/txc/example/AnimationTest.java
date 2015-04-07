package txc.example;

import android.app.Activity;
import android.graphics.Interpolator;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.BounceInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;

public class AnimationTest extends Activity {
	private ImageView img;
	private Button btn01;
	private Button btn02;
	private Button btn03;
	private Button btn04;
	private Button btn05;
	private Button btn06;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.animationtest);
		img = (ImageView) findViewById(R.id.anim_img);
		img.setImageResource(R.drawable.ic_launcher);
		btn01 = (Button) findViewById(R.id.anim_btn01);
		btn02 = (Button) findViewById(R.id.anim_btn02);
		btn03 = (Button) findViewById(R.id.anim_btn03);
		btn04 = (Button) findViewById(R.id.anim_btn04);
		btn05 = (Button) findViewById(R.id.anim_btn05);
		btn06 = (Button) findViewById(R.id.anim_btn06);
		btn01.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// 用布局文件定义动画
				// Animation
				// anim=AnimationUtils.loadAnimation(AnimationTest.this,
				// R.anim.alphaanim);
				// img.startAnimation(anim);
				// 用代码定义动画
				Animation anim2 = new AlphaAnimation(0.1f, 1.0f);
				anim2.setDuration(5000);
				img.startAnimation(anim2);
			}
		});
		btn02.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// 用布局文件定义动画
//				Animation anim = AnimationUtils.loadAnimation(
//						AnimationTest.this, R.anim.scaleanimation);
//				img.startAnimation(anim);
				// 用代码定义动画
				 Animation anim2=new ScaleAnimation(1.1f,0.0f,1.1f,0.1f);
				 anim2.setDuration(5000);
				 anim2.setRepeatCount(2);
				 img.startAnimation(anim2);
			}
		});
		btn03.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// 用布局文件定义动画
//				Animation anim = AnimationUtils.loadAnimation(AnimationTest.this, R.anim.translateanimation);
//				img.startAnimation(anim);
				// 用代码定义动画
				 Animation anim2=new TranslateAnimation(0,300,0,0);
				 anim2.setDuration(10000);
				 //弹跳
				 anim2.setInterpolator(new BounceInterpolator());
				 anim2.setRepeatCount(2);
				 img.startAnimation(anim2);
			}
		});
		btn04.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// 用布局文件定义动画
//				Animation anim = AnimationUtils.loadAnimation(AnimationTest.this, R.anim.rotateanimation);
//				img.startAnimation(anim);
				// 用代码定义动画
				 Animation anim2=new RotateAnimation(0,500,100,100);
				 anim2.setDuration(10000);
				 //弹跳
				 anim2.setInterpolator(new BounceInterpolator());
				 anim2.setRepeatCount(2);
				 img.startAnimation(anim2);
			}
		});
		btn05.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// 用布局文件定义动画
				Animation anim = AnimationUtils.loadAnimation(AnimationTest.this, R.anim.groupanimation);
				img.startAnimation(anim);
				// 用代码定义动画
//				 Animation anim2=new RotateAnimation(0,500,100,100);
//				 anim2.setDuration(10000);
//				 //弹跳
//				 anim2.setInterpolator(new BounceInterpolator());
//				 anim2.setRepeatCount(2);
//				 img.startAnimation(anim2);
			}
		});
		btn06.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// 用布局文件定义动画
				Animation anim = AnimationUtils.loadAnimation(AnimationTest.this, R.anim.groupanimation2);
				img.startAnimation(anim);
				// 用代码定义动画
//				 Animation anim2=new RotateAnimation(0,500,100,100);
//				 anim2.setDuration(10000);
//				 //弹跳
//				 anim2.setInterpolator(new BounceInterpolator());
//				 anim2.setRepeatCount(2);
//				 img.startAnimation(anim2);
			}
		});
	}
}
