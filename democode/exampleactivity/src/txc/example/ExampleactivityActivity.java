package txc.example;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class ExampleactivityActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
//        Intent intent=getIntent();
//		String title=intent.getStringExtra("title");
//		this.setTitle(title);
    }
}