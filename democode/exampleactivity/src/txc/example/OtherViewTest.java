package txc.example;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AnalogClock;
import android.widget.Button;
import android.widget.DigitalClock;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.Toast;

public class OtherViewTest extends Activity {
	private ProgressBar pb;
	private AnalogClock ac;
	private DigitalClock dc;
	private RatingBar rb;
	private SeekBar sb;
	private Button button1;
	private Button button2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.othercomponent);
		pb = (ProgressBar) findViewById(R.id.ProgressBar1);
		ac = (AnalogClock) findViewById(R.id.AnalogClock1);
		dc = (DigitalClock) findViewById(R.id.DigitalClock1);
		rb = (RatingBar) findViewById(R.id.RatingBar1);
		sb = (SeekBar) findViewById(R.id.SeekBar1);
		button1 = (Button) findViewById(R.id.button1);
		button2 = (Button) findViewById(R.id.button2);
		button1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				int pbprogress = pb.getProgress();
				int rbProgress = rb.getProgress();
				int sbProgress = sb.getProgress();
				String str = "ProgressBar:" + pbprogress + "\n";
				str += "rbProgress:" + rbProgress + "\n";
				str += "sbProgress:" + sbProgress;
				Toast.makeText(getApplicationContext(), str, 1).show();
			}
		});
		button2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				pb.setProgress(30);
				pb.setSecondaryProgress(50);
				rb.setProgress(10);
				sb.setProgress(80);
			}
		});
		sb.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			
			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {
				pb.setProgress(progress);
				OtherViewTest.this.setTitle("当前进度值："+progress);
				rb.setProgress(progress/10);
			}
		});
	}
}
