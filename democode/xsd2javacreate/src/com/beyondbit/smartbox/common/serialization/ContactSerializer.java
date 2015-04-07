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
import com.beyondbit.smartbox.common.Contact;

public class ContactSerializer {

	public static void AppendChildElement(Document doc, Contact obj, Element parentElement) {
		Element ContactCodeElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:ContactCode");
		ContactCodeElement.setTextContent(obj.getContactCode() + "");
		parentElement.appendChild(ContactCodeElement);

		Element GenderElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:Gender");
		GenderElement.setTextContent(obj.getGender() + "");
		parentElement.appendChild(GenderElement);

		Element SignatureElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:Signature");
		SignatureElement.setTextContent(obj.getSignature() + "");
		parentElement.appendChild(SignatureElement);

		Element IconCodeElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:IconCode");
		IconCodeElement.setTextContent(obj.getIconCode() + "");
		parentElement.appendChild(IconCodeElement);

		Element ContactGroupCodeElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:ContactGroupCode");
		ContactGroupCodeElement.setTextContent(obj.getContactGroupCode() + "");
		parentElement.appendChild(ContactGroupCodeElement);

		Element CategoryCodeElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:CategoryCode");
		CategoryCodeElement.setTextContent(obj.getCategoryCode() + "");
		parentElement.appendChild(CategoryCodeElement);

		Element CategoryTypeElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:CategoryType");
		CategoryTypeElement.setTextContent(obj.getCategoryType() + "");
		parentElement.appendChild(CategoryTypeElement);

		Element ContactUidElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:ContactUid");
		ContactUidElement.setTextContent(obj.getContactUid() + "");
		parentElement.appendChild(ContactUidElement);

		Element ContactTypeElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:ContactType");
		ContactTypeElement.setTextContent(obj.getContactType() + "");
		parentElement.appendChild(ContactTypeElement);

		Element SurNameElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:SurName");
		SurNameElement.setTextContent(obj.getSurName() + "");
		parentElement.appendChild(SurNameElement);

		Element GivenNameElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:GivenName");
		GivenNameElement.setTextContent(obj.getGivenName() + "");
		parentElement.appendChild(GivenNameElement);

		Element FileAsMappingElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:FileAsMapping");
		FileAsMappingElement.setTextContent(obj.getFileAsMapping() + "");
		parentElement.appendChild(FileAsMappingElement);

		Element FullNameElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:FullName");
		FullNameElement.setTextContent(obj.getFullName() + "");
		parentElement.appendChild(FullNameElement);

		Element JobTiteElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:JobTite");
		JobTiteElement.setTextContent(obj.getJobTite() + "");
		parentElement.appendChild(JobTiteElement);

		Element CompanyNameElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:CompanyName");
		CompanyNameElement.setTextContent(obj.getCompanyName() + "");
		parentElement.appendChild(CompanyNameElement);

		Element DepartmentElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:Department");
		DepartmentElement.setTextContent(obj.getDepartment() + "");
		parentElement.appendChild(DepartmentElement);

		Element OfficeElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:Office");
		OfficeElement.setTextContent(obj.getOffice() + "");
		parentElement.appendChild(OfficeElement);

		Element ExtPhoneElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:ExtPhone");
		ExtPhoneElement.setTextContent(obj.getExtPhone() + "");
		parentElement.appendChild(ExtPhoneElement);

		Element BusinessPhoneElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:BusinessPhone");
		BusinessPhoneElement.setTextContent(obj.getBusinessPhone() + "");
		parentElement.appendChild(BusinessPhoneElement);

		Element MobilePhoneElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:MobilePhone");
		MobilePhoneElement.setTextContent(obj.getMobilePhone() + "");
		parentElement.appendChild(MobilePhoneElement);

		Element BusinessFaxElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:BusinessFax");
		BusinessFaxElement.setTextContent(obj.getBusinessFax() + "");
		parentElement.appendChild(BusinessFaxElement);

		Element HomePhoneElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:HomePhone");
		HomePhoneElement.setTextContent(obj.getHomePhone() + "");
		parentElement.appendChild(HomePhoneElement);

		Element Email1AddressElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:Email1Address");
		Email1AddressElement.setTextContent(obj.getEmail1Address() + "");
		parentElement.appendChild(Email1AddressElement);

		Element Email1DisplayAsElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:Email1DisplayAs");
		Email1DisplayAsElement.setTextContent(obj.getEmail1DisplayAs() + "");
		parentElement.appendChild(Email1DisplayAsElement);

		Element Email2AddressElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:Email2Address");
		Email2AddressElement.setTextContent(obj.getEmail2Address() + "");
		parentElement.appendChild(Email2AddressElement);

		Element Email2DisplayAsElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:Email2DisplayAs");
		Email2DisplayAsElement.setTextContent(obj.getEmail2DisplayAs() + "");
		parentElement.appendChild(Email2DisplayAsElement);

		Element Email3AddressElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:Email3Address");
		Email3AddressElement.setTextContent(obj.getEmail3Address() + "");
		parentElement.appendChild(Email3AddressElement);

		Element Email3DisplayAsElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:Email3DisplayAs");
		Email3DisplayAsElement.setTextContent(obj.getEmail3DisplayAs() + "");
		parentElement.appendChild(Email3DisplayAsElement);

		Element ImAccountElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:ImAccount");
		ImAccountElement.setTextContent(obj.getImAccount() + "");
		parentElement.appendChild(ImAccountElement);

		Element ImAccount2Element = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:ImAccount2");
		ImAccount2Element.setTextContent(obj.getImAccount2() + "");
		parentElement.appendChild(ImAccount2Element);

		Element AddressElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:Address");
		AddressElement.setTextContent(obj.getAddress() + "");
		parentElement.appendChild(AddressElement);

		Element PostCodeElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:PostCode");
		PostCodeElement.setTextContent(obj.getPostCode() + "");
		parentElement.appendChild(PostCodeElement);

		Element NickNameElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:NickName");
		NickNameElement.setTextContent(obj.getNickName() + "");
		parentElement.appendChild(NickNameElement);

		Element RemarkElement = doc.createElementNS("http://www.beyondbit.com/smartbox/common","com:Remark");
		RemarkElement.setTextContent(obj.getRemark() + "");
		parentElement.appendChild(RemarkElement);

	}

}