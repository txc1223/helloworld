package txc.example;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class FramAnimationTest extends Activity {
	private ImageView img;
	private Button btn1;
	private Button btn2;
	private AnimationDrawable draw;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.frame_anim);
		btn1 = (Button) findViewById(R.id.frame_anim_btn1);
		img = (ImageView) findViewById(R.id.frame_anim_img);
		btn2 = (Button) findViewById(R.id.frame_anim_btn2);
		draw=new AnimationDrawable();
		//得到有规律的资源id值
//		for (int i = 0; i < 4; i++) {
//			int resId=getResources().getIdentifier("earth_0"+i, "drawable", "txc.example");
//		}
		draw.addFrame(getResources().getDrawable(android.R.drawable.alert_dark_frame), 100);
		draw.addFrame(getResources().getDrawable(android.R.drawable.alert_light_frame), 100);
		draw.addFrame(getResources().getDrawable(android.R.drawable.title_bar_tall), 100);
		draw.addFrame(getResources().getDrawable(android.R.drawable.title_bar), 100);
		draw.setOneShot(false);
		//只显示第一帧动画
		System.out.println(draw);
		img.setImageDrawable(draw);
		btn1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				//启动动画
				draw.start();
			}
		});
		btn2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				draw.stop();
			}
		});
	}
}
