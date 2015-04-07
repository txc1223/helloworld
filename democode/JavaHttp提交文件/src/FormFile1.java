
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.InputStreamEntity;


public class FormFile1 {
	/* 上传文件的数据 */
	private byte[] data;
	/* 文件名称 */
	private String filname;
	/* 表单字段名称 */
	private String formname;
	/* 内容类型 */
	private String contentType = "application/octet-stream"; // 需要查阅相关的资料

	public FormFile1(String filname, byte[] data, String formname, String contentType) {
		this.data = data;
		this.filname = filname;
		this.formname = formname;
		if (contentType != null)
			this.contentType = contentType;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	public String getFilname() {
		return filname;
	}

	public void setFilname(String filname) {
		this.filname = filname;
	}

	public String getFormname() {
		return formname;
	}

	public void setFormname(String formname) {
		this.formname = formname;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	/**
	 * 直接通过HTTP协议提交数据到服务器,实现表单提交功能
	 * 
	 * @param actionUrl
	 *            上传路径
	 * @param params
	 *            请求参数 key为参数名,value为参数值
	 * @param file
	 *            上传文件
	 */
	public static String post(String actionUrl, Map<String, String> params, FormFile1[] files) {
		try {

			String BOUNDARY = "----7d4a6d158c9"; // 数据分隔线
			String MULTIPART_FORM_DATA = "multipart/form-data";

			URL url = new URL(actionUrl);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoInput(true);// 允许输入
			conn.setDoOutput(true);// 允许输出
			conn.setUseCaches(false);// 不使用Cache
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Connection", "Keep-Alive");
			conn.setRequestProperty("Charset", "UTF-8");
			conn.setRequestProperty("Content-Type", MULTIPART_FORM_DATA + "; boundary=" + BOUNDARY);

			StringBuilder sb = new StringBuilder();

			// 上传的表单参数部分，格式请参考文章
			for (Map.Entry<String, String> entry : params.entrySet()) {// 构建表单字段内容
				sb.append("–");
				sb.append(BOUNDARY);
				sb.append("\r\n");
				sb.append("Content-Disposition: form-data; name=\"" + entry.getKey() + "\"\r\n\r\n");
				sb.append(entry.getValue());
				sb.append("\r\n");
			}
			DataOutputStream outStream = new DataOutputStream(conn.getOutputStream());
			outStream.write(sb.toString().getBytes());// 发送表单字段数据

			// 上传的文件部分，格式请参考文章
			for (FormFile1 file : files) {
				StringBuilder split = new StringBuilder();
				split.append("–");
				split.append(BOUNDARY);
				split.append("\r\n");
				split.append("Content-Disposition: form-data;name=\"" + file.getFormname() + "\";filename=\"" + file.getFilname() + "\"\r\n");
				split.append("Content-Type: " + file.getContentType() + "\r\n\r\n");
				outStream.write(split.toString().getBytes());
				outStream.write(file.getData(), 0, file.getData().length);
				outStream.write("\r\n".getBytes());
			}
			byte[] end_data = ("–" + BOUNDARY + "–\r\n").getBytes();// 数据结束标志
			outStream.write(end_data);
			outStream.flush();
			int cah = conn.getResponseCode();
			if (cah != 200)
				throw new RuntimeException("请求url失败");
			InputStream is = conn.getInputStream();
			int ch;
			StringBuilder b = new StringBuilder();
			while ((ch = is.read()) != -1) {
				b.append((char) ch);
			}
			outStream.close();
			conn.disconnect();
			return b.toString();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static String post(String path, Map<String, String> params, FormFile1 file) throws Exception {
		return post(path, params, new FormFile1[] { file });
	}

	public static synchronized String post(String actionUrl, Map<String, String> params, FormFile1[] files, HttpClient httpClient) {
		try {

			String BOUNDARY = "----7d4a6d158c9"; // 数据分隔线
			String MULTIPART_FORM_DATA = "multipart/form-data";

			HttpPost httpPost = new HttpPost(actionUrl);
			httpPost.setHeader("Accept-Language", "zh-CN");
			httpPost.setHeader("Accept", "application/json, application/xml, text/html, text/*, image/*, */*");
			// entity.setContentType("text/xml");
			// httpPost.setEntity(entity);
			httpPost.setHeader("Connection", "Keep-Alive");
			httpPost.setHeader("Charset", "UTF-8");
			httpPost.setHeader("Content-Type", MULTIPART_FORM_DATA + "; boundary=" + BOUNDARY);

//			URL url = new URL(actionUrl);
			// HttpURLConnection conn = (HttpURLConnection)
			// url.openConnection();

			StringBuilder sb = new StringBuilder();

			// 上传的表单参数部分，格式请参考文章
			for (Map.Entry<String, String> entry : params.entrySet()) {// 构建表单字段内容
//				sb.append("-");
				sb.append(BOUNDARY);
				sb.append("\r\n");
				sb.append("Content-Disposition: form-data; name=\"" + entry.getKey() + "\"\r\n\r\n");
				sb.append(entry.getValue());
				sb.append("\r\n");
			}

			ByteArrayOutputStream outStream = new ByteArrayOutputStream();

			outStream.write(sb.toString().getBytes());// 发送表单字段数据

			// 上传的文件部分，格式请参考文章
			for (FormFile1 file : files) {
				StringBuilder split = new StringBuilder();
//				split.append("–");
				split.append(BOUNDARY);
				split.append("\r\n");
				split.append("Content-Disposition: form-data;name=\"" + file.getFormname() + "\";filename=\"" + file.getFilname() + "\"\r\n");
				split.append("Content-Type: " + file.getContentType() + "\r\n\r\n");
				outStream.write(split.toString().getBytes());
				outStream.write(file.getData(), 0, file.getData().length);
				outStream.write("\r\n".getBytes());
			}
			byte[] end_data = ("" + BOUNDARY + "\r\n").getBytes();// 数据结束标志
			outStream.write(end_data);
			outStream.flush();

			ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(outStream.toByteArray());

			InputStreamEntity ie = new InputStreamEntity(byteArrayInputStream, outStream.size());
			httpPost.setEntity(ie);

			HttpResponse httpResponse = httpClient.execute(httpPost);
			int status = httpResponse.getStatusLine().getStatusCode();

			if (status != 200)
				throw new RuntimeException("请求url失败");
			// InputStream is = conn.getInputStream();
			// int ch;
			// StringBuilder b = new StringBuilder();
			// while ((ch = is.read()) != -1) {
			// b.append((char) ch);
			// }
			outStream.close();
			byteArrayInputStream.close();
			// conn.disconnect();
			return "";
		} catch (Exception e) {
			
			throw new RuntimeException(e);
		} finally {
			
		}
	}


}
