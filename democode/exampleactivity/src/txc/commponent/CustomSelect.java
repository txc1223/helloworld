package txc.commponent;

import txc.example.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;


/**
 * CustomSelect.java <br/>
 * Date:2011-9-21 <br/>
 * Author:XiaQiulei <br/>
 * Version:v1.0 <br/>
 * Title:自定义下拉框 <br/>
 * Java代码�?
 * 
 * <pre>
 * CustomSelect select = (CustomSelect) findViewById(R.id.select);
 * select.setAdapter(new SelectAdapter(this)); // 自定义一个�?配器
 * select.setOnIitemClickListener(new OnItemClickListener() {
 * 	public void onItemClick(AdapterView&lt;?&gt; parent, View view, int position, long id) {
 * 
 * 		// 以下代码必写
 * 		select.setText(list.get(position)); // 把所选的位置赋�?定义的上�?
 * 		select.setSelectPosition(position); // 更改�?��选择的位�?
 * 		select.pwDismiss();// 隐藏界面
 * 	}
 * });
 * </pre>
 * 
 * Xml代码:
 * 
 * <pre>
 *  &lt;LinearLayout
 * 	xmlns:android="http://schemas.android.com/apk/res/android"
 * 
 * 	xmlns:custom="http://schemas.android.com/apk/res/xxxxxxxxxxx"
 *  	&lt;-- xxxxxxx 是Android项目建立情况下的包路�?--&gt;
 *  
 *  	android:orientation="vertical"
 * 	android:layout_width="fill_parent"
 *  	android:layout_height="fill_parent"&gt;
 * &lt;com.beyondbit.test.CustomSelect
 * 	android:id="@+id/select"
 * 	android:layout_width="wrap_content"
 * 	android:layout_height="wrap_content"
 * 	android:background="@drawable/button_bg"
 * 	android:textColor="#000"
 * 	android:text="text"
 * 	android:drawableRight="@drawable/down"
 * 	android:drawableLeft="@drawable/user_free"
 * 	android:paddingLeft="5dp"
 * 	android:paddingTop="5dp"
 * 	android:paddingRight="5dp"
 * 	android:paddingBottom="5dp"
 * 	android:drawablePadding="5dp"
 * 	
 * 		&lt;-- 下拉框的背景 --&gt;
 * 	custom:pw_bg="@drawable/pw_bg"&gt;
 * 
 * &lt;/com.beyondbit.test.CustomSelect&gt;
 * &lt;/LinearLayout&gt;
 * 
 * <pre>
 */
public class CustomSelect extends TextView {

	private Context context;
	// 下拉菜单的背�?
	private Drawable pw_bg;

	private PopupWindow pw;

	private ListAdapter ba;

	private OnItemClickListener onIitemClickListener;

	// 选中的后的位�?
	private int selectPosition = -1;

	private int customSelectwidth = -1;

	public CustomSelect(Context c) {
		super(c);
		context = c;
		setListener();
	}

	public CustomSelect(Context c, AttributeSet attrs) {
		super(c, attrs);
		context = c;
		TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.CustomSelect);
		pw_bg = array.getDrawable(R.styleable.CustomSelect_pw_bg);
		setListener();
		array.recycle();
	}

	public CustomSelect(Context c, AttributeSet attrs, int defStyle) {
		super(c, attrs, defStyle);
		context = c;
		setListener();
		TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.CustomSelect);
		pw_bg = array.getDrawable(R.styleable.CustomSelect_pw_bg);
		array.recycle();
	}

	private void setListener() {
		this.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				showPopupWindow(CustomSelect.this);
			}
		});
	}

	public void setAdapter(ListAdapter la) {
		ba = la;
	}

	public int getCustomSelectwidth() {
		return customSelectwidth;
	}

	public void setCustomSelectwidth(int customSelectwidth) {
		this.customSelectwidth = customSelectwidth;
	}

	public void showPopupWindow(View parent) {
		if (customSelectwidth != -1) {
			pw = new PopupWindow(this, customSelectwidth, LayoutParams.WRAP_CONTENT, true);
		} else {
			pw = new PopupWindow(this, this.getWidth(), LayoutParams.WRAP_CONTENT, true);
		}
		ListView lv = new ListView(context);
		lv.setCacheColorHint(Color.argb(0, 0, 0, 0));
		lv.setAdapter(ba);
		if (onIitemClickListener != null) {
			lv.setOnItemClickListener(onIitemClickListener);
		}
		pw.setContentView(lv);
		pw.setBackgroundDrawable(pw_bg);
		pw.showAsDropDown(parent);
	}

	public void setOnIitemClickListener(OnItemClickListener onIitemClickListener) {
		this.onIitemClickListener = onIitemClickListener;
	}

	public void pwDismiss() {
		pw.dismiss();
	}

	public int getSelectPosition() {
		return selectPosition;
	}

	public void setSelectPosition(int selectPosition) {
		this.selectPosition = selectPosition;
	}
}