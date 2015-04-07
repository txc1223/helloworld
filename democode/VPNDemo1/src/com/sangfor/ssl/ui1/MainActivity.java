package com.sangfor.ssl.ui1;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.UnknownHostException;

import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.HTTP;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.sangforauthdemo1.R;
import com.sangfor.ssl.IVpnDelegate;
import com.sangfor.ssl.SFException;
import com.sangfor.ssl.SangforAuth;
import com.sangfor.ssl.common.VpnCommon;

public class MainActivity extends Activity implements View.OnClickListener, IVpnDelegate {
	private static final String TAG = "xulitest";

	// 请在这里定义具体参数
	private static final String VPN_IP = "219.233.226.71";
	private static final String USER = "support";
	private static final String PASSWD = "10604";
	private static final String HTTP_RES = "http://10.220.250.145:7070/files/com.beyondbit.smartbox.officialdoc_v4_20140718153342.apk";

	// View
	private RememberEditText edt_ip = null;
	private RememberEditText edt_user = null;
	private RememberEditText edt_passwd = null;
	private RememberEditText edt_certName = null;
	private RememberEditText edt_certPasswd = null;
	private RememberEditText edt_sms = null;
	private RememberEditText edt_url = null;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initView();
		SangforAuth sfAuth = SangforAuth.getInstance();
		try {
			sfAuth.init(this, this, SangforAuth.AUTH_MODULE_EASYAPP);
		} catch (SFException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void onDestroy() {
		// SangforAuth.getInstance().vpnQuit();
		super.onDestroy();
	}

	private void initView() {
		edt_ip = RememberEditText.bind(this, R.id.edt_ip, "IP");
		edt_user = RememberEditText.bind(this, R.id.edt_user, "USER");
		edt_passwd = RememberEditText.bind(this, R.id.edt_passwd, "PASSWD");
		edt_certName = RememberEditText.bind(this, R.id.edt_certName, "CERTNAME");
		edt_certPasswd = RememberEditText.bind(this, R.id.edt_certPasswd, "CERTPASSWD");
		edt_sms = RememberEditText.bind(this, R.id.edt_sms, "SMS");
		edt_url = RememberEditText.bind(this, R.id.edt_url, "URL");

		edt_ip.setText(VPN_IP);
		edt_user.setText(USER);
		edt_passwd.setText(PASSWD);
		edt_url.setText(HTTP_RES);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_login:
			initSslVpn();
			break;
		case R.id.btn_logout:
			SangforAuth.getInstance().vpnLogout();
			break;
		case R.id.btn_cancel:
			SangforAuth.getInstance().vpnCancelLogin();
			break;
		case R.id.btn_sms:
			doVpnLogin(IVpnDelegate.AUTH_TYPE_SMS);
			break;
		case R.id.btn_reget_sms:
			doVpnLogin(IVpnDelegate.AUTH_TYPE_SMS1);
			break;
		case R.id.btn_test_http:
			// luanchWebBrowser(edt_url.getText().toString());
//			new TestThread().start();
			try {
				download(getDownloadFile("donwload.apk"));
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		default:
			Log.w(TAG, "onClick no process");
		}
	}

	/**
	 * 开始初始化VPN，该初始化为异步接口，后续动作通过回调函数通知结果
	 * 
	 * @return 成功返回true，失败返回false，一般情况下返回true
	 */
	private boolean initSslVpn() {
		SangforAuth sfAuth = SangforAuth.getInstance();

		InetAddress iAddr = null;
		try {
			String ip = edt_ip.getText().toString();
			iAddr = InetAddress.getByName(ip);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		if (iAddr == null || iAddr.getHostAddress() == null) {
			Log.d(TAG, "vpn host error");
			return false;
		}
		long host = VpnCommon.ipToLong(iAddr.getHostAddress());
		int port = 443;

		if (sfAuth.vpnInit(host, port) == false) {
			Log.d(TAG, "vpn init fail, errno is " + sfAuth.vpnGeterr());
			return false;
		}

		return true;
	}

	/**
	 * 处理认证，通过传入认证类型（需要的话可以改变该接口传入一个hashmap的参数用户传入认证参数）.
	 * 也可以一次性把认证参数设入，这样就如果认证参数全满足的话就可以一次性认证通过，可见下面屏蔽代码
	 * 
	 * @param authType
	 *            认证类型
	 * @throws SFException
	 */
	private void doVpnLogin(int authType) {
		Log.d(TAG, "doVpnLogin authType " + authType);

		boolean ret = false;
		SangforAuth sfAuth = SangforAuth.getInstance();

		switch (authType) {
		case IVpnDelegate.AUTH_TYPE_CERTIFICATE:
			String certPasswd = edt_certPasswd.getText().toString();
			String certName = edt_certName.getText().toString();
			sfAuth.setLoginParam(IVpnDelegate.CERT_PASSWORD, certPasswd);
			sfAuth.setLoginParam(IVpnDelegate.CERT_P12_FILE_NAME, certName);
			ret = sfAuth.vpnLogin(IVpnDelegate.AUTH_TYPE_CERTIFICATE);
			break;
		case IVpnDelegate.AUTH_TYPE_PASSWORD:
			String user = edt_user.getText().toString();
			String passwd = edt_passwd.getText().toString();
			sfAuth.setLoginParam(IVpnDelegate.PASSWORD_AUTH_USERNAME, user);
			sfAuth.setLoginParam(IVpnDelegate.PASSWORD_AUTH_PASSWORD, passwd);
			ret = sfAuth.vpnLogin(IVpnDelegate.AUTH_TYPE_PASSWORD);
			break;
		case IVpnDelegate.AUTH_TYPE_SMS:
			String smsCode = edt_sms.getText().toString();
			sfAuth.setLoginParam(IVpnDelegate.SMS_AUTH_CODE, smsCode);
			ret = sfAuth.vpnLogin(IVpnDelegate.AUTH_TYPE_SMS);
			break;
		case IVpnDelegate.AUTH_TYPE_SMS1:
			ret = sfAuth.vpnLogin(IVpnDelegate.AUTH_TYPE_SMS1);
			break;
		default:
			Log.w(TAG, "default authType " + authType);
			break;
		}

		if (ret == true) {
			Log.i(TAG, "success to call login method");
		} else {
			Log.i(TAG, "fail to call login method");
		}

	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		switch (requestCode) {
		case IVpnDelegate.REQUEST_L3VPNSERVICE:
			if (resultCode == RESULT_OK) {
				SangforAuth.getInstance().vpnL3vpnStart();
			}
		}
		super.onActivityResult(requestCode, resultCode, data);
	}

	private void displayToast(final String str) {
		runOnUiThread(new Runnable() {
			
			@Override
			public void run() {
				Toast.makeText(MainActivity.this, str, Toast.LENGTH_LONG).show();
			}
		});
		
	}

	@Override
	public void vpnCallback(int vpnResult, int authType) {
		SangforAuth sfAuth = SangforAuth.getInstance();

		switch (vpnResult) {
		case IVpnDelegate.RESULT_VPN_INIT_FAIL:
			/**
			 * 初始化vpn失败
			 */
			Log.i(TAG, "RESULT_VPN_INIT_FAIL, 初始化失败  error is " + sfAuth.vpnGeterr());
			displayToast("RESULT_VPN_INIT_FAIL, 初始化失败  error is " + sfAuth.vpnGeterr());
			break;

		case IVpnDelegate.RESULT_VPN_INIT_SUCCESS:
			/**
			 * 初始化vpn成功，接下来就需要开始认证工作了
			 */
			Log.i(TAG, "RESULT_VPN_INIT_SUCCESS, 初始化vpn成功 current vpn status is " + sfAuth.vpnQueryStatus());
			displayToast("RESULT_VPN_INIT_SUCCESS,初始化vpn成功 current vpn status is " + sfAuth.vpnQueryStatus());

			doVpnLogin(IVpnDelegate.AUTH_TYPE_PASSWORD);
			break;

		case IVpnDelegate.RESULT_VPN_AUTH_FAIL:
			/**
			 * 认证失败，有可能是传入参数有误，具体信息可通过sfAuth.vpnGeterr()获取
			 */
			Log.i(TAG, "RESULT_VPN_AUTH_FAIL,认证失败 error is " + sfAuth.vpnGeterr());
			displayToast("RESULT_VPN_AUTH_FAIL,认证失败 error is " + sfAuth.vpnGeterr());
			break;

		case IVpnDelegate.RESULT_VPN_AUTH_SUCCESS:
			/**
			 * 认证成功，认证成功有两种情况，一种是认证通过，可以使用sslvpn功能了，另一种是前一个认证（如：用户名密码认证）通过，
			 * 但需要继续认证（如：需要继续证书认证）
			 */
			if (authType == IVpnDelegate.AUTH_TYPE_NONE) {
				Log.i(TAG, "认证成功welcom to sangfor sslvpn!");
				displayToast("认证成功welcom to sangfor sslvpn!");

				// 若为L3vpn流程，认证成功后开启自动开启l3vpn服务
				if (SangforAuth.getInstance().getModuleUsed() == SangforAuth.AUTH_MODULE_EASYAPP) {
					// EasyApp流程，认证流程结束，可访问资源。
					doResourceRequest();
				}

			} else {
				Log.i(TAG, "auth success,需要继续认证 and need next auth, next auth type is " + authType);
				displayToast("auth success,需要继续认证 and need next auth, next auth type is " + authType);

				if (authType == IVpnDelegate.AUTH_TYPE_SMS) {
					// 输入短信验证码
					Toast.makeText(this, "you need send sms code.", Toast.LENGTH_LONG).show();
				} else {
					doVpnLogin(authType);
				}
			}
			break;
		case IVpnDelegate.RESULT_VPN_AUTH_CANCEL:
			Log.i(TAG, "RESULT_VPN_AUTH_CANCEL");
			displayToast("RESULT_VPN_AUTH_CANCEL");
			break;
		case IVpnDelegate.RESULT_VPN_AUTH_LOGOUT:
			/**
			 * 主动注销（自己主动调用logout接口）或者被动注销（通过控制台把用户踢掉）均会调用该接口
			 */
			Log.i(TAG, "RESULT_VPN_AUTH_LOGOUT 主动注销");
			displayToast("RESULT_VPN_AUTH_LOGOUT 主动注销");
			break;
		case IVpnDelegate.RESULT_VPN_L3VPN_FAIL:
			/**
			 * L3vpn启动失败，有可能是没有l3vpn资源，具体信息可通过sfAuth.vpnGeterr()获取
			 */
			Log.i(TAG, "RESULT_VPN_L3VPN_FAIL, L3vpn启动失败error is " + sfAuth.vpnGeterr());
			displayToast("RESULT_VPN_L3VPN_FAIL,L3vpn启动失败 error is " + sfAuth.vpnGeterr());
			break;
		case IVpnDelegate.RESULT_VPN_L3VPN_SUCCESS:
			/**
			 * L3vpn启动成功
			 */
			Log.i(TAG, "L3vpn启动成功RESULT_VPN_L3VPN_SUCCESS");
			displayToast("L3vpn启动成功RESULT_VPN_L3VPN_SUCCESS");
			// L3vpn流程，认证流程结束，可访问资源。
			doResourceRequest();
			break;
		case IVpnDelegate.VPN_STATUS_ONLINE:
			/**
			 * 与设备连接建立
			 */
			Log.i(TAG, "online与设备连接建立");
			displayToast("online与设备连接建立");
			break;
		case IVpnDelegate.VPN_STATUS_OFFLINE:
			/**
			 * 与设备连接断开
			 */
			Log.i(TAG, "offline与设备连接断开");
			displayToast("offline与设备连接断开");
			break;
		default:
			/**
			 * 其它情况，不会发生，如果到该分支说明代码逻辑有误
			 */
			Log.i(TAG, "default result代码逻辑有误, vpn result is " + vpnResult);
			displayToast("default result代码逻辑有误, vpn result is " + vpnResult);
			break;
		}

	}

	private void doResourceRequest() {
		// TODO Auto-generated method stub
		// 认证结束，可访问资源。
	}

	/** 测试资源，打开浏览器 */
	private void luanchWebBrowser(String url) {
		try {
			Uri uri = Uri.parse(url);
			Intent intent = new Intent(Intent.ACTION_VIEW, uri);

			startActivity(intent);
		} catch (Exception e) {
			e.printStackTrace();
			displayToast("Luanch Web Browser is error. " + url);
		}
	}

	/** 测试HTTP资源 */
	private class TestThread extends Thread {
		@Override
		public void run() {
			HttpParams params = new BasicHttpParams();
			HttpProtocolParams.setVersion(params, HttpVersion.HTTP_1_1);
			HttpProtocolParams.setContentCharset(params, HTTP.UTF_8);
			HttpConnectionParams.setConnectionTimeout(params, 3000);

			HttpPost post = new HttpPost(edt_url.getText().toString());
			DefaultHttpClient client = new DefaultHttpClient(params);
			try {
				StringBuffer sb = new StringBuffer();
				HttpResponse response = client.execute(post);
				InputStream is = response.getEntity().getContent();
				int b = 0;
				// 顺序读取文件text里的内容并赋值给整型变量b,直到文件结束为止。
				while ((b = is.read()) != -1) {
					sb.append((char) b);
				}
				System.out.print(sb.toString());
			} catch (ClientProtocolException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void reloginCallback(int arg0, int arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void vpnRndCodeCallback(byte[] arg0) {
		// TODO Auto-generated method stub

	}

	public void download(final File savedir) {
		new Thread(new Runnable() {
			public void run() {
				try {
					ApkDownloadManager loader = new ApkDownloadManager(MainActivity.this, HTTP_RES, savedir);
					loader.download();
				} catch (Exception e) {
					Log.i(TAG, "", e);
				}
			}
		}).start();

	}
	/**
	 * 获取 下载文件的位置，在有sdcard的情况，放在/sdcard/Smartbox/update/smartbox.apk
	 * 
	 * @param name
	 * @return
	 * @throws Exception
	 */
	private File getDownloadFile(String name) throws Exception {
		// 判断是否有sdcard
		if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())) {
			File path = new File(Environment.getExternalStorageDirectory().getPath() + "/textdown/");
			if (!path.exists()) {
				path.mkdirs();
			}
			return new File(path, name);
		} else {
			throw new Exception("无sdcard?");
		}
	}

}
