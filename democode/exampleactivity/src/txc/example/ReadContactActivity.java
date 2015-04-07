package txc.example;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import android.app.Activity;
import android.content.ContentProviderOperation;
import android.content.ContentProviderOperation.Builder;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.OperationApplicationException;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import android.provider.CallLog;
import android.provider.ContactsContract;
import android.provider.ContactsContract.CommonDataKinds.Email;
import android.provider.ContactsContract.CommonDataKinds.Im;
import android.provider.ContactsContract.CommonDataKinds.Nickname;
import android.provider.ContactsContract.CommonDataKinds.Note;
import android.provider.ContactsContract.CommonDataKinds.Organization;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.provider.ContactsContract.CommonDataKinds.StructuredName;
import android.provider.ContactsContract.CommonDataKinds.StructuredPostal;
import android.provider.ContactsContract.CommonDataKinds.Website;
import android.provider.ContactsContract.Data;
import android.provider.ContactsContract.RawContacts;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class ReadContactActivity extends Activity {
	private TextView tv;
	private Button btn1, btn2, btn3;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.readcontact);
		tv = (TextView) findViewById(R.id.read_contact_tv);
		btn1 = (Button) findViewById(R.id.search_contact_btn);
		btn2 = (Button) findViewById(R.id.search_calllog_btn);
		btn3 = (Button) findViewById(R.id.search_sms_btn);

		btn1.setOnClickListener(listener);
		btn2.setOnClickListener(listener);
		btn3.setOnClickListener(listener);
		String str = readContact();

	}

	OnClickListener listener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()) {
			case R.id.search_contact_btn:
				tv.setText(readContact());
				break;
			case R.id.search_calllog_btn:
				tv.setText(readCalllog());
				break;
			case R.id.search_sms_btn:
				tv.setText(readSMS());
				break;
			}
		}
	};

	private String readContact() {
		String[] columns = { "_id", "display_name", "has_phone_number" };
		// �绰�ֶλ�Ҫ���� lookup������
		String[] phone_cols = { "contact_id", "data1", ContactsContract.CommonDataKinds.Phone.NUMBER };
		System.out.println(ContactsContract.CommonDataKinds.Phone.NUMBER.equals("data1"));
		StringBuffer sb = new StringBuffer();
		ContentResolver cr = this.getContentResolver();
		// ��������ϵ�˵�ͨ�������� ��ϵ�˵�URI 1��ѯ�ֻ���ϵ���б�2���е���������null��ʾ������
		// 3where���� 4where���� 5������� 6����ʽ��
		Cursor cursor = cr.query(ContactsContract.Contacts.CONTENT_URI, columns, null, null, null);
		// cr.insert(url, values)
		// cr.update(uri, values, where, selectionArgs)
		// cr.delete(url, where, selectionArgs)
		// Cursor
		// cursor.requery();���²�ѯ
//		Cursor phones1 = cr.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, null);
		// �Ȳ����ֶ��ٲ�ֵ
//		for (int i = 0; i < phones1.getColumnCount(); i++) {
//			Log.i("output", phones1.getColumnName(i) + ":");
//			sb.append(phones1.getColumnName(i) + ",");
//		}
//		System.out.println(sb.toString());
		 if (cursor.moveToFirst()) {
		 do {
		 int _id = cursor.getInt(0);
		 _getContactByContactId(cr, _id+"");
		 String name = cursor.getString(1);
		 // �е绰�ͷ���1
		 String has_phone = cursor.getString(2);
		 sb.append(_id + ":" + name + ":" + has_phone + ":");
		 //����е绰�Ų�绰
		 if(has_phone.trim().equals("1")){
		 //��ѯ�绰��
		 Cursor phones = cr.query(
		 ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
		 phone_cols, "contact_id=" + _id, null, null);
		 if (phones.moveToFirst()) {
		 do {
		 String number = phones.getString(1);
		 sb.append(number + ",");
		 } while (phones.moveToNext());
		 }
		 sb.append("\n");
		 }
		 } while (cursor.moveToNext());
		
		 }
		return sb.toString();
	}

	// ��ȡ�ֻ���ͨ����¼
	private String readCalllog() {
		StringBuffer sb = new StringBuffer();
		// �绰���룬 ������ͨ������1�ѽӵ绰2�Ѳ��绰3δ�ӵ绰 ��ͨ�����ڣ�ͨ��ʱ��
		String[] cols = { CallLog.Calls.NUMBER, CallLog.Calls.CACHED_NAME, CallLog.Calls.TYPE, CallLog.Calls.DATE, CallLog.Calls.DURATION };
		ContentResolver cr = getContentResolver();
		Cursor cursor = cr.query(CallLog.Calls.CONTENT_URI, cols, null, null, null);
		if (cursor.moveToFirst()) {
			do {
				sb.append(cursor.getString(0) + ",");
				sb.append(cursor.getString(1) + ",");
				sb.append(cursor.getString(2) + ",");
				long times = Long.parseLong(cursor.getString(3));
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
				Date date = new Date(times);
				sb.append(sdf.format(date) + ",");
				sb.append(cursor.getString(4) + "\n");
			} while (cursor.moveToNext());
		}
		return sb.toString();
	}

	// ��ȡ�ֻ��еĶ���Ϣ
	private String readSMS() {
		StringBuffer sb = new StringBuffer();
		ContentResolver cr = getContentResolver();
		String[] clos = { "address", "body", "type", "date" };
		// content://sms/inbox ������
		// content://sms/ ���ж���Ϣ
		// content://sms/sent �ѷ���
		// content://sms/draft �ݸ�
		// content://sms/outbox ������
		Cursor cursor = cr.query(Uri.parse("content://sms/"), clos, null, null, null);
		if (cursor.moveToFirst()) {
			do {
				sb.append(cursor.getString(0) + ",");
				sb.append(cursor.getString(1) + ",");
				sb.append(cursor.getString(2) + ",");
				long times = Long.parseLong(cursor.getString(3));
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
				Date date = new Date(times);
				sb.append(sdf.format(date) + "\n");

			} while (cursor.moveToNext());
		}
		// for(int i=0;i<cursor.getColumnCount();i++){
		// sb.append(cursor.getColumnName(i)+",");
		// }
		return sb.toString();
	}
	
	
	//���鶼����data* ��ɵ�  һ�� data1��ʾ�����ֵ����13712345678  data2��ʾ���� �����ֻ�������ͥ�������ͣ�data3��ʾ�Զ�������
	//Ҳ�г���data3�� ���ַ�е�data4����ֵ� data7������е�
	// phone
	private static final String[] PROJECTION_PHONENUMBER_CONTACT = { Phone.NUMBER, Phone.TYPE, Phone.LABEL };
	/* DISPLAY_NAMEΨһ�� */
	private static final String[] PROJECTION_DISPLAYNAME_CONTACT = { StructuredName.DISPLAY_NAME };
	// Email
	private static final String[] PROJECTION_EAMIL_CONTACT = { Email.DATA1, Email.TYPE, Email.LABEL };
	// IM
	private static final String[] PROJECTION_IM_CONTACT = new String[] { Im.DATA, Im.TYPE, Im.LABEL, Im.PROTOCOL };
	// address
	private static final String[] PROJECTION_ADDRESS_CONTACT = new String[] { StructuredPostal.STREET, StructuredPostal.CITY, StructuredPostal.REGION, StructuredPostal.POSTCODE,
			StructuredPostal.COUNTRY, StructuredPostal.TYPE, StructuredPostal.LABEL, StructuredPostal.POBOX, StructuredPostal.NEIGHBORHOOD, };
	// Organization
	private static final String[] PROJECTION_ORGANIZATION_CONTACT = new String[] { Organization.COMPANY, Organization.TYPE, Organization.LABEL, Organization.TITLE };
	// note
	private static final String[] PROJECTION_NOTES_CONTACT = new String[] { Note.NOTE };
	// nickname
	private static final String[] PROJECTION_NICKNAMES_CONTACT = new String[] { Nickname.NAME, Nickname.TYPE, Nickname.LABEL };
	// website
	private static final String[] PROJECTION_WEBSITES_CONTACT = new String[] { Website.URL, Website.TYPE, Website.LABEL };

	/**
	 * ���ܣ�����contactId��ѯ��ϵ����ϸ
	 * 
	 * ��android.provider.ContactsContract.Data�����ѯ
	 * */
	public static void _getContactByContactId(ContentResolver cr, String contactId) {
		Cursor c = null;

		c = cr.query(Data.CONTENT_URI, null, Data.CONTACT_ID + "=?", new String[] { contactId }, null);

		String mimeType = null;
		String[] contentValue = null;

		ArrayList<String[]> displayNameList = new ArrayList<String[]>();// ����ʾ��
		ArrayList<String[]> phoneList = new ArrayList<String[]>();// ��绰���룬�ɶ��
		ArrayList<String[]> emailList = new ArrayList<String[]>();// ��Email���ɶ��
		ArrayList<String[]> imList = new ArrayList<String[]>();// ��im���ɶ��
		ArrayList<String[]> postalList = new ArrayList<String[]>();// ��postal��ַ���ɶ��
		ArrayList<String[]> organizationList = new ArrayList<String[]>();// ��organization��֯���ɶ��
		ArrayList<String[]> noteList = new ArrayList<String[]>();// ��note��ע
		ArrayList<String[]> nicknameList = new ArrayList<String[]>();// ��Nickname�ǳ�
		ArrayList<String[]> websiteList = new ArrayList<String[]>();// ��Website��վ

		while (c.moveToNext()) {
			// ����mimeType������Ϣ
			mimeType = c.getString(c.getColumnIndex(Data.MIMETYPE));
			if (StructuredName.CONTENT_ITEM_TYPE.equals(mimeType)) {
				contentValue = MyUtils.getStringInContactCursor(c, PROJECTION_DISPLAYNAME_CONTACT);
				displayNameList.add(contentValue);
			} else if (Phone.CONTENT_ITEM_TYPE.equals(mimeType)) {
				// ÿ��contentValue��һ��PROJECTION_PHONENUMBER_CONTACT����
				contentValue = MyUtils.getStringInContactCursor(c, PROJECTION_PHONENUMBER_CONTACT);
				phoneList.add(contentValue);
			} else if (Email.CONTENT_ITEM_TYPE.equals(mimeType)) {
				contentValue = MyUtils.getStringInContactCursor(c, PROJECTION_EAMIL_CONTACT);
				emailList.add(contentValue);
			} else if (Im.CONTENT_ITEM_TYPE.equals(mimeType)) {
				contentValue = MyUtils.getStringInContactCursor(c, PROJECTION_IM_CONTACT);
				imList.add(contentValue);
			} else if (StructuredPostal.CONTENT_ITEM_TYPE.equals(mimeType)) {
				contentValue = MyUtils.getStringInContactCursor(c, PROJECTION_ADDRESS_CONTACT);
				postalList.add(contentValue);
			} else if (Organization.CONTENT_ITEM_TYPE.equals(mimeType)) {
				contentValue = MyUtils.getStringInContactCursor(c, PROJECTION_ORGANIZATION_CONTACT);
				organizationList.add(contentValue);
			} else if (Note.CONTENT_ITEM_TYPE.equals(mimeType)) {
				contentValue = MyUtils.getStringInContactCursor(c, PROJECTION_NOTES_CONTACT);
				noteList.add(contentValue);
			} else if (Nickname.CONTENT_ITEM_TYPE.equals(mimeType)) {
				contentValue = MyUtils.getStringInContactCursor(c, PROJECTION_NICKNAMES_CONTACT);
				nicknameList.add(contentValue);
			} else if (Website.CONTENT_ITEM_TYPE.equals(mimeType)) {
				contentValue = MyUtils.getStringInContactCursor(c, PROJECTION_WEBSITES_CONTACT);
				websiteList.add(contentValue);
			}
		}
		c.close();

		// log
		MyUtils.logContactsDetails("displayName", PROJECTION_DISPLAYNAME_CONTACT, displayNameList);
		MyUtils.logContactsDetails("phoneNumber", PROJECTION_PHONENUMBER_CONTACT, phoneList);
		MyUtils.logContactsDetails("Email", PROJECTION_EAMIL_CONTACT, emailList);
		MyUtils.logContactsDetails("IM", PROJECTION_IM_CONTACT, imList);
		MyUtils.logContactsDetails("Address", PROJECTION_ADDRESS_CONTACT, postalList);
		MyUtils.logContactsDetails("Organization", PROJECTION_ORGANIZATION_CONTACT, organizationList);
		MyUtils.logContactsDetails("Note", PROJECTION_NOTES_CONTACT, noteList);
		MyUtils.logContactsDetails("NickName", PROJECTION_NICKNAMES_CONTACT, nicknameList);
		MyUtils.logContactsDetails("WebSit", PROJECTION_WEBSITES_CONTACT, websiteList);
	}

	public static class MyUtils {
		public static String[] getStringInContactCursor(Cursor c, String[] projection) {
			String[] contentValue = new String[projection.length];
			for (int i = 0; i < contentValue.length; i++) {
				String value = c.getString(c.getColumnIndex(projection[i]));
				if (value == null) {
					contentValue[i] = "";
				} else {
					contentValue[i] = value;
					System.out.println(projection[i]+"===projection[i]---  "+"value="+value);
				}
			}
			return contentValue;
		}

		public static void logContactsDetails(String title, String[] projection, ArrayList<String[]> data) {
			Log.e("xulitest", "--------" + title + "--------");

			for (int i = 0; i < data.size(); i++) {
				for (int j = 0; j < data.get(i).length; j++) {
					Log.e("xulitest", projection[j] + "=" + data.get(i)[j]);
				}
			}
		}
	}
	/**
	 * �½���ϵ�˵Ľӿ�
	 * 
	 * @param String
	 *            accountName��accountType Ϊ�˺����˺����ͣ�һ��ΪNULL
	 * @throws RemoteException
	 * @throws OperationApplicationException
	 */

	public static String _insertContact(ContentResolver cr, String accountName,
			String accountType, String displayName, ArrayList<String[]> phone,
			ArrayList<String[]> email, ArrayList<String[]> im,
			ArrayList<String[]> address, ArrayList<String[]> organization,
			ArrayList<String[]> notes, ArrayList<String[]> nickname,
			ArrayList<String[]> website) throws RemoteException,
			OperationApplicationException {

		ArrayList<ContentProviderOperation> ops = new ArrayList<ContentProviderOperation>();

		String rawId = "";
		long rawContactId = insertRawContact(cr, accountName, accountType);
		rawId = Long.toString(rawContactId);

		if (displayName != null) {
			insertContactDisplayname(ops, StructuredName.CONTENT_ITEM_TYPE,
					rawId, displayName);
		}
		if (phone != null) {
			for (int j = 0; j < phone.size(); j++) {
				String[] item = phone.get(j);
				insertItemToContact(ops, Phone.CONTENT_ITEM_TYPE, rawId,
						PROJECTION_PHONENUMBER_CONTACT, item);
			}
		}
		if (email != null) {
			for (int j = 0; j < email.size(); j++) {
				String[] item = email.get(j);
				insertItemToContact(ops, Email.CONTENT_ITEM_TYPE, rawId,
						PROJECTION_EAMIL_CONTACT, item);
			}
		}
		if (im != null) {
			for (int j = 0; j < im.size(); j++) {
				String[] item = im.get(j);
				insertItemToContact(ops, Im.CONTENT_ITEM_TYPE, rawId,
						PROJECTION_IM_CONTACT, item);
			}
		}
		if (address != null) {
			for (int j = 0; j < address.size(); j++) {
				String[] item = address.get(j);
				insertItemToContact(ops, StructuredPostal.CONTENT_ITEM_TYPE,
						rawId, PROJECTION_ADDRESS_CONTACT, item);
			}
		}
		if (organization != null) {
			for (int j = 0; j < organization.size(); j++) {
				String[] item = organization.get(j);
				insertItemToContact(ops, Organization.CONTENT_ITEM_TYPE, rawId,
						PROJECTION_ORGANIZATION_CONTACT, item);
			}
		}
		if (notes != null) {
			for (int j = 0; j < notes.size(); j++) {
				String[] item = notes.get(j);
				insertItemToContact(ops, Note.CONTENT_ITEM_TYPE, rawId,
						PROJECTION_NOTES_CONTACT, item);
			}
		}
		if (nickname != null) {
			for (int j = 0; j < nickname.size(); j++) {
				String[] item = nickname.get(j);
				insertItemToContact(ops, Nickname.CONTENT_ITEM_TYPE, rawId,
						PROJECTION_NICKNAMES_CONTACT, item);
			}
		}
		if (website != null) {
			for (int j = 0; j < website.size(); j++) {
				String[] item = website.get(j);
				insertItemToContact(ops, Website.CONTENT_ITEM_TYPE, rawId,
						PROJECTION_WEBSITES_CONTACT, item);
			}
		}
		cr.applyBatch(ContactsContract.AUTHORITY, ops);
		return rawId;
	}

	/*
	 * ͨ����ROWCONTACT��������ݣ����rawId
	 * 
	 * @param cr
	 * 
	 * @param accountName һ��ΪNULL
	 * 
	 * @param accountType һ��ΪNULL
	 * 
	 * @return
	 */

	private static long insertRawContact(ContentResolver cr,
			String accountName, String accountType) {

		ContentValues values = new ContentValues();
		values.put(RawContacts.ACCOUNT_NAME, accountName);
		values.put(RawContacts.ACCOUNT_TYPE, accountType);
		// values.put(Contacts.DISPLAY_NAME, displayName);
		Uri rawContactUri = cr.insert(RawContacts.CONTENT_URI, values);
		long rawContactId = ContentUris.parseId(rawContactUri);
		return rawContactId;
	}

	private static void insertContactDisplayname(
			ArrayList<ContentProviderOperation> ops, String mimeType,
			String rawContactId, String displayName) throws RemoteException,
			OperationApplicationException {

		ops.add(ContentProviderOperation.newInsert(Data.CONTENT_URI).withValue(
				Data.MIMETYPE, mimeType).withValue(Data.RAW_CONTACT_ID,
				rawContactId).withValue(StructuredName.DISPLAY_NAME,
				displayName).build());

	}

	private static void insertItemToContact(
			ArrayList<ContentProviderOperation> ops, String mimeType,
			String rawContactId, String[] PROJECTION_CONTACT, String[] item)
			throws RemoteException, OperationApplicationException {
		// ContentValues values = new ContentValues();
		// values.put(Data.RAW_CONTACT_ID, rawContactId);
		// values.put(Data.MIMETYPE, mimeType);
		// for (int i = 0; i < PROJECTION_CONTACT.length; i++) {
		// values.put(PROJECTION_CONTACT[i], item[i]);
		// }
		// Uri dataUri = cr.insert(Data.CONTENT_URI, values);

		Builder builder = ContentProviderOperation.newInsert(Data.CONTENT_URI);
		builder.withYieldAllowed(true);
		builder.withValue(Data.RAW_CONTACT_ID, rawContactId);
		builder.withValue(Data.MIMETYPE, mimeType);
		for (int i = 0; i < PROJECTION_CONTACT.length; i++) {
			builder.withValue(PROJECTION_CONTACT[i], item[i]);
		}
		ops.add(builder.build());
	}
	
	
	
	
	private void updateContact(Context context,String oldname, String name, String phone, String email,String website, String organization, String note) {
		
		Cursor cursor = getContentResolver().query(Data.CONTENT_URI,new String[] { Data.RAW_CONTACT_ID },
		
		ContactsContract.Contacts.DISPLAY_NAME + "=?",new String[] { oldname }, null);
		cursor.moveToFirst();
		String id = cursor.getString(cursor.getColumnIndex(Data.RAW_CONTACT_ID));
		cursor.close();
		ArrayList<ContentProviderOperation> ops = new ArrayList<ContentProviderOperation>();
		

		ops.add(ContentProviderOperation.newUpdate(ContactsContract.Data.CONTENT_URI)
		.withSelection(
		
		Data.RAW_CONTACT_ID + "=?" + " AND "+ ContactsContract.Data.MIMETYPE + " = ?" +
		" AND " + Phone.TYPE + "=?",new String[] { String.valueOf(id),Phone.CONTENT_ITEM_TYPE,
		String.valueOf(Phone.TYPE_HOME) }).withValue(Phone.NUMBER, phone).build());
		
		// ����email
		ops.add(ContentProviderOperation.newUpdate(ContactsContract.Data.CONTENT_URI)
		.withSelection(Data.RAW_CONTACT_ID + "=?" + " AND "+ ContactsContract.Data.MIMETYPE + " = ?" +" AND " + Email.TYPE + "=?",new String[] { String.valueOf(id),Email.CONTENT_ITEM_TYPE,
		String.valueOf(Email.TYPE_HOME) }).withValue(Email.DATA, email).build());
		
		// ��������
		ops.add(ContentProviderOperation.newUpdate(ContactsContract.Data.CONTENT_URI)
		.withSelection(Data.RAW_CONTACT_ID + "=?" + " AND "+ ContactsContract.Data.MIMETYPE + " = ?",new String[] { String.valueOf(id),StructuredName.CONTENT_ITEM_TYPE }).withValue(StructuredName.DISPLAY_NAME, name).build());
		
		// ������վ
		ops.add(ContentProviderOperation.newUpdate(ContactsContract.Data.CONTENT_URI)
		.withSelection(Data.RAW_CONTACT_ID + "=?" + " AND "+ ContactsContract.Data.MIMETYPE + " = ?",new String[] { String.valueOf(id),Website.CONTENT_ITEM_TYPE }).withValue(Website.URL, website).build());
		
		// ���¹�˾
		ops.add(ContentProviderOperation.newUpdate(ContactsContract.Data.CONTENT_URI)
		.withSelection(Data.RAW_CONTACT_ID + "=?" + " AND "+ ContactsContract.Data.MIMETYPE + " = ?",new String[] { String.valueOf(id),Organization.CONTENT_ITEM_TYPE })
		.withValue(Organization.COMPANY, organization).build());
		
		// ����note
		ops.add(ContentProviderOperation.newUpdate(ContactsContract.Data.CONTENT_URI)
		.withSelection(Data.RAW_CONTACT_ID + "=?" + " AND "+ ContactsContract.Data.MIMETYPE + " = ?",new String[] { String.valueOf(id),Note.CONTENT_ITEM_TYPE }).withValue(Note.NOTE, note).build());
		
		try{
		getContentResolver().applyBatch(ContactsContract.AUTHORITY, ops);
		} catch (Exception e) {
		}
		}

}
