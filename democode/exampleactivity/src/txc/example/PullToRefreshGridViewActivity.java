package txc.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import txc.commponent.PullToRefreshGridView;
import txc.commponent.PullToRefreshGridView.OnRefreshListener;
import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.SimpleAdapter;

public class PullToRefreshGridViewActivity extends Activity {

    private SimpleAdapter citySimpleAdapter;
    public static LinearLayout head;
    String[] areaName = new String[] { "�Ͼ�", "����", "����", "��ͨ", "����", "����",
           "����", "̩��", "�γ�", "��", "����", "���Ƹ�", "��Ǩ" };
    // ���13������

    private List<HashMap<String, String>> cityList = new ArrayList<HashMap<String, String>>();
    public void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.grid_main);
       //����ģ��  ���г�ʼ��
       for (int i = 0; i < areaName.length * 1; i++) {
           HashMap<String, String> hashMap = new HashMap<String, String>();
           hashMap.put("id", String.valueOf(i));
           hashMap.put("name", areaName[i % 13].toString());
           cityList.add(hashMap);
       }
       final PullToRefreshGridView gridView = (PullToRefreshGridView) findViewById(R.id.order_form_grid);
       head = (LinearLayout) findViewById(R.id.head);
       LayoutParams p = new LayoutParams(LayoutParams.FILL_PARENT,LayoutParams.WRAP_CONTENT, Gravity.CENTER);
       //��ȡPullToRefreshGridView�����head����
       head.addView(gridView.getView(), p);

       citySimpleAdapter = new SimpleAdapter(this, cityList,

              R.layout.weather_textview, new String[] { "name" },

              new int[] { R.id.txtRepDlgCity });

       gridView.setAdapter(citySimpleAdapter);

       gridView.setonRefreshListener(new OnRefreshListener() {

           public void onRefresh() {

              new AsyncTask<Void, Void, Void>() {

                  protected Void doInBackground(Void... params) {

                     try {

                         Thread.sleep(1000);

                     } catch (Exception e) {

                         e.printStackTrace();

                     }

                     HashMap<String, String> hashMap = new HashMap<String, String>();

                     hashMap.put("id",String.valueOf(cityList.size()));

                     hashMap.put("name","ˢ����������");

                     cityList.add(0,hashMap);

                     return null;

                  }

 

                  @Override

                  protected void onPostExecute(Void result) {

                     citySimpleAdapter.notifyDataSetChanged();

                     gridView.onRefreshComplete();

                  }

              }.execute();

           }

       });

    }

}

