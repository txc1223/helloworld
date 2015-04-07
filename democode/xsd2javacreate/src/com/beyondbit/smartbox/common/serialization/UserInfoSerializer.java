package com.beyondbit.smartbox.common.serialization;

import java.io.ByteArrayOutputStream; 
import java.text.SimpleDateFormat; 
import javax.xml.parsers.DocumentBuilder; 
import javax.xml.parsers.DocumentBuilderFactory; 
import javax.xml.parsers.ParserConfigurationException; 
import org.w3c.dom.Document; 
import org.w3c.dom.Element; 
import org.w3c.dom.bootstrap.DOMImplementationRegistry; 
import org.w3c.dom.ls.DOMImplementationLS; 
import org.w3c.dom.ls.LSOutput; 
import org.w3c.dom.ls.LSSerializer; 
import com.beyondbit.smartbox.common.UserInfo;

public class UserInfoSerializer {

	public static void AppendChildElement(Document doc, UserInfo obj, Element parentElement) {
		Element UserUidElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:UserUid");
		UserUidElement.setTextContent(obj.getUserUid() + "");
		parentElement.appendChild(UserUidElement);

		Element SignatureElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:Signature");
		SignatureElement.setTextContent(obj.getSignature() + "");
		parentElement.appendChild(SignatureElement);

		Element IconCodeElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:IconCode");
		IconCodeElement.setTextContent(obj.getIconCode() + "");
		parentElement.appendChild(IconCodeElement);

		Element UserNameElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:UserName");
		UserNameElement.setTextContent(obj.getUserName() + "");
		parentElement.appendChild(UserNameElement);

		Element GenderElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:Gender");
		GenderElement.setTextContent(obj.getGender() + "");
		parentElement.appendChild(GenderElement);

		Element OrgCodeElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:OrgCode");
		OrgCodeElement.setTextContent(obj.getOrgCode() + "");
		parentElement.appendChild(OrgCodeElement);

		Element OrgNameElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:OrgName");
		OrgNameElement.setTextContent(obj.getOrgName() + "");
		parentElement.appendChild(OrgNameElement);

		Element UnitCodeElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:UnitCode");
		UnitCodeElement.setTextContent(obj.getUnitCode() + "");
		parentElement.appendChild(UnitCodeElement);

		Element UnitNameElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:UnitName");
		UnitNameElement.setTextContent(obj.getUnitName() + "");
		parentElement.appendChild(UnitNameElement);

		Element UserFullNameElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:UserFullName");
		UserFullNameElement.setTextContent(obj.getUserFullName() + "");
		parentElement.appendChild(UserFullNameElement);

		Element UserCardTypeElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:UserCardType");
		UserCardTypeElement.setTextContent(obj.getUserCardType() + "");
		parentElement.appendChild(UserCardTypeElement);

		Element UserCardElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:UserCard");
		UserCardElement.setTextContent(obj.getUserCard() + "");
		parentElement.appendChild(UserCardElement);

		Element UserNickElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:UserNick");
		UserNickElement.setTextContent(obj.getUserNick() + "");
		parentElement.appendChild(UserNickElement);

		Element UserMobilePhoneElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:UserMobilePhone");
		UserMobilePhoneElement.setTextContent(obj.getUserMobilePhone() + "");
		parentElement.appendChild(UserMobilePhoneElement);

		Element UserHomeAddressElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:UserHomeAddress");
		UserHomeAddressElement.setTextContent(obj.getUserHomeAddress() + "");
		parentElement.appendChild(UserHomeAddressElement);

		Element UserHomePhoneElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:UserHomePhone");
		UserHomePhoneElement.setTextContent(obj.getUserHomePhone() + "");
		parentElement.appendChild(UserHomePhoneElement);

		Element UserHomePostElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:UserHomePost");
		UserHomePostElement.setTextContent(obj.getUserHomePost() + "");
		parentElement.appendChild(UserHomePostElement);

		Element UserSecurityLevelElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:UserSecurityLevel");
		UserSecurityLevelElement.setTextContent(obj.getUserSecurityLevel() + "");
		parentElement.appendChild(UserSecurityLevelElement);

		Element UserDutyLevelElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:UserDutyLevel");
		UserDutyLevelElement.setTextContent(obj.getUserDutyLevel() + "");
		parentElement.appendChild(UserDutyLevelElement);

		Element UserDutyElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:UserDuty");
		UserDutyElement.setTextContent(obj.getUserDuty() + "");
		parentElement.appendChild(UserDutyElement);

		Element UserEmailElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:UserEmail");
		UserEmailElement.setTextContent(obj.getUserEmail() + "");
		parentElement.appendChild(UserEmailElement);

		Element UserOfficePhoneElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:UserOfficePhone");
		UserOfficePhoneElement.setTextContent(obj.getUserOfficePhone() + "");
		parentElement.appendChild(UserOfficePhoneElement);

		Element UserFaxElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:UserFax");
		UserFaxElement.setTextContent(obj.getUserFax() + "");
		parentElement.appendChild(UserFaxElement);

		Element UserExtPhoneElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:UserExtPhone");
		UserExtPhoneElement.setTextContent(obj.getUserExtPhone() + "");
		parentElement.appendChild(UserExtPhoneElement);

		Element UserOfficeRoomElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:UserOfficeRoom");
		UserOfficeRoomElement.setTextContent(obj.getUserOfficeRoom() + "");
		parentElement.appendChild(UserOfficeRoomElement);

		Element OfficeInfoUserDescElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:OfficeInfoUserDesc");
		OfficeInfoUserDescElement.setTextContent(obj.getOfficeInfoUserDesc() + "");
		parentElement.appendChild(OfficeInfoUserDescElement);

	}

}