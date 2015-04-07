package com.beyondbit.smartbox.response.serialization;

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
import com.beyondbit.smartbox.response.Response;
import com.beyondbit.smartbox.response.AddCalendarResponse;
import com.beyondbit.smartbox.response.ClCheckPermissionResponse;
import com.beyondbit.smartbox.response.DeleteCalendarResponse;
import com.beyondbit.smartbox.response.FindDeptCalendarsResponse;
import com.beyondbit.smartbox.response.FindPersonnelCalendarsResponse;
import com.beyondbit.smartbox.response.GetCalendarUserShareListResponse;
import com.beyondbit.smartbox.response.GetCustomCalendarGroupListResponse;
import com.beyondbit.smartbox.response.GetCustomCalendarGroupUserListResponse;
import com.beyondbit.smartbox.response.GetDeptCalendarResponse;
import com.beyondbit.smartbox.response.GetPersonnelCalendarResponse;
import com.beyondbit.smartbox.response.GetUserDeptAndUnitResponse;
import com.beyondbit.smartbox.response.QueryCalendarsResponse;
import com.beyondbit.smartbox.response.QueryCalendarsByOrgCodesResponse;
import com.beyondbit.smartbox.response.QueryCalendarsByUserUIdsResponse;
import com.beyondbit.smartbox.response.QuerySubOrgsResponse;
import com.beyondbit.smartbox.response.QuerySubUsersResponse;
import com.beyondbit.smartbox.response.UpdateCalendarResponse;
import com.beyondbit.smartbox.response.GetCallBoardResponse;
import com.beyondbit.smartbox.response.QueryCallBoardResponse;
import com.beyondbit.smartbox.response.GetGlobalConfigResponse;
import com.beyondbit.smartbox.response.GetUpdateInfoResponse;
import com.beyondbit.smartbox.response.AddFriendGroupResponse;
import com.beyondbit.smartbox.response.FriendInviteResponse;
import com.beyondbit.smartbox.response.FriendOnlineEventResponse;
import com.beyondbit.smartbox.response.GetAllFriendsResponse;
import com.beyondbit.smartbox.response.GetContactResponse;
import com.beyondbit.smartbox.response.GetContactCategorysResponse;
import com.beyondbit.smartbox.response.GetContactGroupsByCategoryResponse;
import com.beyondbit.smartbox.response.GetContactGroupsByParentGroupResponse;
import com.beyondbit.smartbox.response.GetContactsResponse;
import com.beyondbit.smartbox.response.GetContactsByContactCodesResponse;
import com.beyondbit.smartbox.response.GetFriendByGroupResponse;
import com.beyondbit.smartbox.response.GetFriendByUidResponse;
import com.beyondbit.smartbox.response.GetFriendGroupsResponse;
import com.beyondbit.smartbox.response.GetIMCacheResponse;
import com.beyondbit.smartbox.response.GetOfflineFileResponse;
import com.beyondbit.smartbox.response.NewOfflineFileEventResponse;
import com.beyondbit.smartbox.response.SendOfflineFileResponse;
import com.beyondbit.smartbox.response.QueryContactResponse;
import com.beyondbit.smartbox.response.GetUserSignatureResponse;
import com.beyondbit.smartbox.response.GetUserStatusResponse;
import com.beyondbit.smartbox.response.FailureResponse;
import com.beyondbit.smartbox.ptservice.GetDetailResponse;
import com.beyondbit.smartbox.ptservice.QuerySplitPageResponse;
import com.beyondbit.smartbox.ptservice.ValidateModuleResponse;
import com.beyondbit.smartbox.response.DisconnectEventResponse;
import com.beyondbit.smartbox.response.SignInProgressResponse;
import com.beyondbit.smartbox.response.SignInResponse;
import com.beyondbit.smartbox.response.NewNoticeResponse;
import com.beyondbit.smartbox.response.QueryNoticeRecieversResponse;
import com.beyondbit.smartbox.response.QueryNoticesResponse;
import com.beyondbit.smartbox.ptservice.GetProjectMonthReportResponse;
import com.beyondbit.smartbox.ptservice.GetProjectResponse;
import com.beyondbit.smartbox.ptservice.GetTaskResponse;
import com.beyondbit.smartbox.ptservice.GetTaskTargetResponse;
import com.beyondbit.smartbox.ptservice.QueryAssistUnitsResponse;
import com.beyondbit.smartbox.ptservice.QueryProjectListResponse;
import com.beyondbit.smartbox.ptservice.QueryProjectMonthReportListResponse;
import com.beyondbit.smartbox.ptservice.QueryProjectPictureResponse;
import com.beyondbit.smartbox.ptservice.QueryProjectRemarkListResponse;
import com.beyondbit.smartbox.ptservice.QueryProjectTaskListResponse;
import com.beyondbit.smartbox.ptservice.QuerySubmitMonthReportResponse;
import com.beyondbit.smartbox.ptservice.QuerySubmitTaskTargetResponse;
import com.beyondbit.smartbox.ptservice.QueryTaskTargetResponse;
import com.beyondbit.smartbox.ptservice.QueryUnAcceptMonthReportResponse;
import com.beyondbit.smartbox.ptservice.QueryUnAcceptTaskResponse;
import com.beyondbit.smartbox.ptservice.QueryUnAcceptTaskTargetResponse;
import com.beyondbit.smartbox.ptservice.QueryUnAuditTaskTargetResponse;
import com.beyondbit.smartbox.response.GetMagazineResponse;
import com.beyondbit.smartbox.response.QueryMagazineAreaResponse;
import com.beyondbit.smartbox.response.QueryMagazineKindResponse;
import com.beyondbit.smartbox.response.QueryMagazineMetaDirResponse;
import com.beyondbit.smartbox.response.QueryMagazineResponse;
import com.beyondbit.smartbox.response.GetUserInfoResponse;
import com.beyondbit.smartbox.response.GetDefaultIconCodesResponse;
import com.beyondbit.smartbox.response.GetIconResponse;
import com.beyondbit.smartbox.response.GetUsingIconResponse;
import com.beyondbit.smartbox.response.SetIconResponse;
import com.beyondbit.smartbox.response.GetPersonalSysConfigResponse;
import com.beyondbit.smartbox.response.CheckPermissionResponse;
import com.beyondbit.smartbox.response.GetAppInfosResponse;
import com.beyondbit.smartbox.response.GetMapUserResponse;
import com.beyondbit.smartbox.response.GetTokenResponse;
import com.beyondbit.smartbox.response.GetTokenUrlResponse;
import com.beyondbit.smartbox.response.QueryAllSMSParametersV2Response;
import com.beyondbit.smartbox.response.QueryReceiveSMSIDV2Response;
import com.beyondbit.smartbox.response.QueryReceiveSMSV2Response;
import com.beyondbit.smartbox.response.QuerySendSMSIDV2Response;
import com.beyondbit.smartbox.response.QuerySendSMSStatusDetailV2Response;
import com.beyondbit.smartbox.response.QuerySendSMSV2Response;
import com.beyondbit.smartbox.response.QuerySignerInfoV2Response;
import com.beyondbit.smartbox.response.ReceiveSMSRemindEventV2Response;
import com.beyondbit.smartbox.response.RemoveReceiveSMSRemindEventV2Response;
import com.beyondbit.smartbox.response.RemoveReceiveSMSV2Request;
import com.beyondbit.smartbox.response.RemoveSendSMSRemindEventV2Response;
import com.beyondbit.smartbox.response.SendSMSRemindEventV2Response;
import com.beyondbit.smartbox.response.SendSMSStatusDetailRemindEventV2Response;
import com.beyondbit.smartbox.response.SuccessResponse;
import com.beyondbit.smartbox.ptservice.GetWorkPlanResponse;
import com.beyondbit.smartbox.ptservice.QueryUserRolesResponse;
import com.beyondbit.smartbox.ptservice.QueryWorkPlanTableResponse;
import com.beyondbit.smartbox.ptservice.QueryWorkPlanTypeResponse;
import com.beyondbit.smartbox.response.serialization.AddCalendarResponseSerializer;
import com.beyondbit.smartbox.response.serialization.ClCheckPermissionResponseSerializer;
import com.beyondbit.smartbox.response.serialization.DeleteCalendarResponseSerializer;
import com.beyondbit.smartbox.response.serialization.FindDeptCalendarsResponseSerializer;
import com.beyondbit.smartbox.response.serialization.FindPersonnelCalendarsResponseSerializer;
import com.beyondbit.smartbox.response.serialization.GetCalendarUserShareListResponseSerializer;
import com.beyondbit.smartbox.response.serialization.GetCustomCalendarGroupListResponseSerializer;
import com.beyondbit.smartbox.response.serialization.GetCustomCalendarGroupUserListResponseSerializer;
import com.beyondbit.smartbox.response.serialization.GetDeptCalendarResponseSerializer;
import com.beyondbit.smartbox.response.serialization.GetPersonnelCalendarResponseSerializer;
import com.beyondbit.smartbox.response.serialization.GetUserDeptAndUnitResponseSerializer;
import com.beyondbit.smartbox.response.serialization.QueryCalendarsResponseSerializer;
import com.beyondbit.smartbox.response.serialization.QueryCalendarsByOrgCodesResponseSerializer;
import com.beyondbit.smartbox.response.serialization.QueryCalendarsByUserUIdsResponseSerializer;
import com.beyondbit.smartbox.response.serialization.QuerySubOrgsResponseSerializer;
import com.beyondbit.smartbox.response.serialization.QuerySubUsersResponseSerializer;
import com.beyondbit.smartbox.response.serialization.UpdateCalendarResponseSerializer;
import com.beyondbit.smartbox.response.serialization.GetCallBoardResponseSerializer;
import com.beyondbit.smartbox.response.serialization.QueryCallBoardResponseSerializer;
import com.beyondbit.smartbox.response.serialization.GetGlobalConfigResponseSerializer;
import com.beyondbit.smartbox.response.serialization.GetUpdateInfoResponseSerializer;
import com.beyondbit.smartbox.response.serialization.AddFriendGroupResponseSerializer;
import com.beyondbit.smartbox.response.serialization.FriendInviteResponseSerializer;
import com.beyondbit.smartbox.response.serialization.FriendOnlineEventResponseSerializer;
import com.beyondbit.smartbox.response.serialization.GetAllFriendsResponseSerializer;
import com.beyondbit.smartbox.response.serialization.GetContactResponseSerializer;
import com.beyondbit.smartbox.response.serialization.GetContactCategorysResponseSerializer;
import com.beyondbit.smartbox.response.serialization.GetContactGroupsByCategoryResponseSerializer;
import com.beyondbit.smartbox.response.serialization.GetContactGroupsByParentGroupResponseSerializer;
import com.beyondbit.smartbox.response.serialization.GetContactsResponseSerializer;
import com.beyondbit.smartbox.response.serialization.GetContactsByContactCodesResponseSerializer;
import com.beyondbit.smartbox.response.serialization.GetFriendByGroupResponseSerializer;
import com.beyondbit.smartbox.response.serialization.GetFriendByUidResponseSerializer;
import com.beyondbit.smartbox.response.serialization.GetFriendGroupsResponseSerializer;
import com.beyondbit.smartbox.response.serialization.GetIMCacheResponseSerializer;
import com.beyondbit.smartbox.response.serialization.GetOfflineFileResponseSerializer;
import com.beyondbit.smartbox.response.serialization.NewOfflineFileEventResponseSerializer;
import com.beyondbit.smartbox.response.serialization.SendOfflineFileResponseSerializer;
import com.beyondbit.smartbox.response.serialization.QueryContactResponseSerializer;
import com.beyondbit.smartbox.response.serialization.GetUserSignatureResponseSerializer;
import com.beyondbit.smartbox.response.serialization.GetUserStatusResponseSerializer;
import com.beyondbit.smartbox.response.serialization.FailureResponseSerializer;
import com.beyondbit.smartbox.ptservice.serialization.GetDetailResponseSerializer;
import com.beyondbit.smartbox.ptservice.serialization.QuerySplitPageResponseSerializer;
import com.beyondbit.smartbox.ptservice.serialization.ValidateModuleResponseSerializer;
import com.beyondbit.smartbox.response.serialization.DisconnectEventResponseSerializer;
import com.beyondbit.smartbox.response.serialization.SignInProgressResponseSerializer;
import com.beyondbit.smartbox.response.serialization.SignInResponseSerializer;
import com.beyondbit.smartbox.response.serialization.NewNoticeResponseSerializer;
import com.beyondbit.smartbox.response.serialization.QueryNoticeRecieversResponseSerializer;
import com.beyondbit.smartbox.response.serialization.QueryNoticesResponseSerializer;
import com.beyondbit.smartbox.ptservice.serialization.GetProjectMonthReportResponseSerializer;
import com.beyondbit.smartbox.ptservice.serialization.GetProjectResponseSerializer;
import com.beyondbit.smartbox.ptservice.serialization.GetTaskResponseSerializer;
import com.beyondbit.smartbox.ptservice.serialization.GetTaskTargetResponseSerializer;
import com.beyondbit.smartbox.ptservice.serialization.QueryAssistUnitsResponseSerializer;
import com.beyondbit.smartbox.ptservice.serialization.QueryProjectListResponseSerializer;
import com.beyondbit.smartbox.ptservice.serialization.QueryProjectMonthReportListResponseSerializer;
import com.beyondbit.smartbox.ptservice.serialization.QueryProjectPictureResponseSerializer;
import com.beyondbit.smartbox.ptservice.serialization.QueryProjectRemarkListResponseSerializer;
import com.beyondbit.smartbox.ptservice.serialization.QueryProjectTaskListResponseSerializer;
import com.beyondbit.smartbox.ptservice.serialization.QuerySubmitMonthReportResponseSerializer;
import com.beyondbit.smartbox.ptservice.serialization.QuerySubmitTaskTargetResponseSerializer;
import com.beyondbit.smartbox.ptservice.serialization.QueryTaskTargetResponseSerializer;
import com.beyondbit.smartbox.ptservice.serialization.QueryUnAcceptMonthReportResponseSerializer;
import com.beyondbit.smartbox.ptservice.serialization.QueryUnAcceptTaskResponseSerializer;
import com.beyondbit.smartbox.ptservice.serialization.QueryUnAcceptTaskTargetResponseSerializer;
import com.beyondbit.smartbox.ptservice.serialization.QueryUnAuditTaskTargetResponseSerializer;
import com.beyondbit.smartbox.response.serialization.GetMagazineResponseSerializer;
import com.beyondbit.smartbox.response.serialization.QueryMagazineAreaResponseSerializer;
import com.beyondbit.smartbox.response.serialization.QueryMagazineKindResponseSerializer;
import com.beyondbit.smartbox.response.serialization.QueryMagazineMetaDirResponseSerializer;
import com.beyondbit.smartbox.response.serialization.QueryMagazineResponseSerializer;
import com.beyondbit.smartbox.response.serialization.GetUserInfoResponseSerializer;
import com.beyondbit.smartbox.response.serialization.GetDefaultIconCodesResponseSerializer;
import com.beyondbit.smartbox.response.serialization.GetIconResponseSerializer;
import com.beyondbit.smartbox.response.serialization.GetUsingIconResponseSerializer;
import com.beyondbit.smartbox.response.serialization.SetIconResponseSerializer;
import com.beyondbit.smartbox.response.serialization.GetPersonalSysConfigResponseSerializer;
import com.beyondbit.smartbox.response.serialization.CheckPermissionResponseSerializer;
import com.beyondbit.smartbox.response.serialization.GetAppInfosResponseSerializer;
import com.beyondbit.smartbox.response.serialization.GetMapUserResponseSerializer;
import com.beyondbit.smartbox.response.serialization.GetTokenResponseSerializer;
import com.beyondbit.smartbox.response.serialization.GetTokenUrlResponseSerializer;
import com.beyondbit.smartbox.response.serialization.QueryAllSMSParametersV2ResponseSerializer;
import com.beyondbit.smartbox.response.serialization.QueryReceiveSMSIDV2ResponseSerializer;
import com.beyondbit.smartbox.response.serialization.QueryReceiveSMSV2ResponseSerializer;
import com.beyondbit.smartbox.response.serialization.QuerySendSMSIDV2ResponseSerializer;
import com.beyondbit.smartbox.response.serialization.QuerySendSMSStatusDetailV2ResponseSerializer;
import com.beyondbit.smartbox.response.serialization.QuerySendSMSV2ResponseSerializer;
import com.beyondbit.smartbox.response.serialization.QuerySignerInfoV2ResponseSerializer;
import com.beyondbit.smartbox.response.serialization.ReceiveSMSRemindEventV2ResponseSerializer;
import com.beyondbit.smartbox.response.serialization.RemoveReceiveSMSRemindEventV2ResponseSerializer;
import com.beyondbit.smartbox.response.serialization.RemoveReceiveSMSV2RequestSerializer;
import com.beyondbit.smartbox.response.serialization.RemoveSendSMSRemindEventV2ResponseSerializer;
import com.beyondbit.smartbox.response.serialization.SendSMSRemindEventV2ResponseSerializer;
import com.beyondbit.smartbox.response.serialization.SendSMSStatusDetailRemindEventV2ResponseSerializer;
import com.beyondbit.smartbox.response.serialization.SuccessResponseSerializer;
import com.beyondbit.smartbox.ptservice.serialization.GetWorkPlanResponseSerializer;
import com.beyondbit.smartbox.ptservice.serialization.QueryUserRolesResponseSerializer;
import com.beyondbit.smartbox.ptservice.serialization.QueryWorkPlanTableResponseSerializer;
import com.beyondbit.smartbox.ptservice.serialization.QueryWorkPlanTypeResponseSerializer;

public class ResponseSerializer {

	public static String serialize(Response obj) {
		DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = null;
		try {
			builder = builderFactory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}

		Document doc = builder.newDocument();

		AppendRootElement(doc, obj);

		ByteArrayOutputStream baos = new ByteArrayOutputStream();

		DOMImplementationLS ls = null;
		try {
			ls = (DOMImplementationLS) DOMImplementationRegistry.newInstance().getDOMImplementation("LS");
		} catch (Exception e) {
			e.printStackTrace();
		}

		LSSerializer ser = ls.createLSSerializer();
		LSOutput out = ls.createLSOutput();
		out.setByteStream(baos);
		ser.write(doc, out);

		try {
			return new String(baos.toByteArray(), "UTF-8");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public static void AppendRootElement(Document doc, Response obj) {
		Element rootElement = doc.createElementNS("http://www.beyondbit.com/smartbox/response","res:Response");
		rootElement.setAttributeNS("http://www.w3.org/2001/XMLSchema-instance","xsi:type","res:"+obj.getClass().getSimpleName());

		AppendChildElement(doc, obj, rootElement);

		doc.appendChild(rootElement);
	}

	public static void AppendChildElement(Document doc, Response obj, Element parentElement) {
		Class<? extends Response> cls = obj.getClass();

		if (cls.equals(AddCalendarResponse.class)) {
			AddCalendarResponseSerializer.AppendChildElement(doc, (AddCalendarResponse) obj, parentElement);
		}		 else if (cls.equals(ClCheckPermissionResponse.class)) {
			ClCheckPermissionResponseSerializer.AppendChildElement(doc, (ClCheckPermissionResponse) obj, parentElement);
		}		 else if (cls.equals(DeleteCalendarResponse.class)) {
			DeleteCalendarResponseSerializer.AppendChildElement(doc, (DeleteCalendarResponse) obj, parentElement);
		}		 else if (cls.equals(FindDeptCalendarsResponse.class)) {
			FindDeptCalendarsResponseSerializer.AppendChildElement(doc, (FindDeptCalendarsResponse) obj, parentElement);
		}		 else if (cls.equals(FindPersonnelCalendarsResponse.class)) {
			FindPersonnelCalendarsResponseSerializer.AppendChildElement(doc, (FindPersonnelCalendarsResponse) obj, parentElement);
		}		 else if (cls.equals(GetCalendarUserShareListResponse.class)) {
			GetCalendarUserShareListResponseSerializer.AppendChildElement(doc, (GetCalendarUserShareListResponse) obj, parentElement);
		}		 else if (cls.equals(GetCustomCalendarGroupListResponse.class)) {
			GetCustomCalendarGroupListResponseSerializer.AppendChildElement(doc, (GetCustomCalendarGroupListResponse) obj, parentElement);
		}		 else if (cls.equals(GetCustomCalendarGroupUserListResponse.class)) {
			GetCustomCalendarGroupUserListResponseSerializer.AppendChildElement(doc, (GetCustomCalendarGroupUserListResponse) obj, parentElement);
		}		 else if (cls.equals(GetDeptCalendarResponse.class)) {
			GetDeptCalendarResponseSerializer.AppendChildElement(doc, (GetDeptCalendarResponse) obj, parentElement);
		}		 else if (cls.equals(GetPersonnelCalendarResponse.class)) {
			GetPersonnelCalendarResponseSerializer.AppendChildElement(doc, (GetPersonnelCalendarResponse) obj, parentElement);
		}		 else if (cls.equals(GetUserDeptAndUnitResponse.class)) {
			GetUserDeptAndUnitResponseSerializer.AppendChildElement(doc, (GetUserDeptAndUnitResponse) obj, parentElement);
		}		 else if (cls.equals(QueryCalendarsResponse.class)) {
			QueryCalendarsResponseSerializer.AppendChildElement(doc, (QueryCalendarsResponse) obj, parentElement);
		}		 else if (cls.equals(QueryCalendarsByOrgCodesResponse.class)) {
			QueryCalendarsByOrgCodesResponseSerializer.AppendChildElement(doc, (QueryCalendarsByOrgCodesResponse) obj, parentElement);
		}		 else if (cls.equals(QueryCalendarsByUserUIdsResponse.class)) {
			QueryCalendarsByUserUIdsResponseSerializer.AppendChildElement(doc, (QueryCalendarsByUserUIdsResponse) obj, parentElement);
		}		 else if (cls.equals(QuerySubOrgsResponse.class)) {
			QuerySubOrgsResponseSerializer.AppendChildElement(doc, (QuerySubOrgsResponse) obj, parentElement);
		}		 else if (cls.equals(QuerySubUsersResponse.class)) {
			QuerySubUsersResponseSerializer.AppendChildElement(doc, (QuerySubUsersResponse) obj, parentElement);
		}		 else if (cls.equals(UpdateCalendarResponse.class)) {
			UpdateCalendarResponseSerializer.AppendChildElement(doc, (UpdateCalendarResponse) obj, parentElement);
		}		 else if (cls.equals(GetCallBoardResponse.class)) {
			GetCallBoardResponseSerializer.AppendChildElement(doc, (GetCallBoardResponse) obj, parentElement);
		}		 else if (cls.equals(QueryCallBoardResponse.class)) {
			QueryCallBoardResponseSerializer.AppendChildElement(doc, (QueryCallBoardResponse) obj, parentElement);
		}		 else if (cls.equals(GetGlobalConfigResponse.class)) {
			GetGlobalConfigResponseSerializer.AppendChildElement(doc, (GetGlobalConfigResponse) obj, parentElement);
		}		 else if (cls.equals(GetUpdateInfoResponse.class)) {
			GetUpdateInfoResponseSerializer.AppendChildElement(doc, (GetUpdateInfoResponse) obj, parentElement);
		}		 else if (cls.equals(AddFriendGroupResponse.class)) {
			AddFriendGroupResponseSerializer.AppendChildElement(doc, (AddFriendGroupResponse) obj, parentElement);
		}		 else if (cls.equals(FriendInviteResponse.class)) {
			FriendInviteResponseSerializer.AppendChildElement(doc, (FriendInviteResponse) obj, parentElement);
		}		 else if (cls.equals(FriendOnlineEventResponse.class)) {
			FriendOnlineEventResponseSerializer.AppendChildElement(doc, (FriendOnlineEventResponse) obj, parentElement);
		}		 else if (cls.equals(GetAllFriendsResponse.class)) {
			GetAllFriendsResponseSerializer.AppendChildElement(doc, (GetAllFriendsResponse) obj, parentElement);
		}		 else if (cls.equals(GetContactResponse.class)) {
			GetContactResponseSerializer.AppendChildElement(doc, (GetContactResponse) obj, parentElement);
		}		 else if (cls.equals(GetContactCategorysResponse.class)) {
			GetContactCategorysResponseSerializer.AppendChildElement(doc, (GetContactCategorysResponse) obj, parentElement);
		}		 else if (cls.equals(GetContactGroupsByCategoryResponse.class)) {
			GetContactGroupsByCategoryResponseSerializer.AppendChildElement(doc, (GetContactGroupsByCategoryResponse) obj, parentElement);
		}		 else if (cls.equals(GetContactGroupsByParentGroupResponse.class)) {
			GetContactGroupsByParentGroupResponseSerializer.AppendChildElement(doc, (GetContactGroupsByParentGroupResponse) obj, parentElement);
		}		 else if (cls.equals(GetContactsResponse.class)) {
			GetContactsResponseSerializer.AppendChildElement(doc, (GetContactsResponse) obj, parentElement);
		}		 else if (cls.equals(GetContactsByContactCodesResponse.class)) {
			GetContactsByContactCodesResponseSerializer.AppendChildElement(doc, (GetContactsByContactCodesResponse) obj, parentElement);
		}		 else if (cls.equals(GetFriendByGroupResponse.class)) {
			GetFriendByGroupResponseSerializer.AppendChildElement(doc, (GetFriendByGroupResponse) obj, parentElement);
		}		 else if (cls.equals(GetFriendByUidResponse.class)) {
			GetFriendByUidResponseSerializer.AppendChildElement(doc, (GetFriendByUidResponse) obj, parentElement);
		}		 else if (cls.equals(GetFriendGroupsResponse.class)) {
			GetFriendGroupsResponseSerializer.AppendChildElement(doc, (GetFriendGroupsResponse) obj, parentElement);
		}		 else if (cls.equals(GetIMCacheResponse.class)) {
			GetIMCacheResponseSerializer.AppendChildElement(doc, (GetIMCacheResponse) obj, parentElement);
		}		 else if (cls.equals(GetOfflineFileResponse.class)) {
			GetOfflineFileResponseSerializer.AppendChildElement(doc, (GetOfflineFileResponse) obj, parentElement);
		}		 else if (cls.equals(NewOfflineFileEventResponse.class)) {
			NewOfflineFileEventResponseSerializer.AppendChildElement(doc, (NewOfflineFileEventResponse) obj, parentElement);
		}		 else if (cls.equals(SendOfflineFileResponse.class)) {
			SendOfflineFileResponseSerializer.AppendChildElement(doc, (SendOfflineFileResponse) obj, parentElement);
		}		 else if (cls.equals(QueryContactResponse.class)) {
			QueryContactResponseSerializer.AppendChildElement(doc, (QueryContactResponse) obj, parentElement);
		}		 else if (cls.equals(GetUserSignatureResponse.class)) {
			GetUserSignatureResponseSerializer.AppendChildElement(doc, (GetUserSignatureResponse) obj, parentElement);
		}		 else if (cls.equals(GetUserStatusResponse.class)) {
			GetUserStatusResponseSerializer.AppendChildElement(doc, (GetUserStatusResponse) obj, parentElement);
		}		 else if (cls.equals(FailureResponse.class)) {
			FailureResponseSerializer.AppendChildElement(doc, (FailureResponse) obj, parentElement);
		}		 else if (cls.equals(GetDetailResponse.class)) {
			GetDetailResponseSerializer.AppendChildElement(doc, (GetDetailResponse) obj, parentElement);
		}		 else if (cls.equals(QuerySplitPageResponse.class)) {
			QuerySplitPageResponseSerializer.AppendChildElement(doc, (QuerySplitPageResponse) obj, parentElement);
		}		 else if (cls.equals(ValidateModuleResponse.class)) {
			ValidateModuleResponseSerializer.AppendChildElement(doc, (ValidateModuleResponse) obj, parentElement);
		}		 else if (cls.equals(DisconnectEventResponse.class)) {
			DisconnectEventResponseSerializer.AppendChildElement(doc, (DisconnectEventResponse) obj, parentElement);
		}		 else if (cls.equals(SignInProgressResponse.class)) {
			SignInProgressResponseSerializer.AppendChildElement(doc, (SignInProgressResponse) obj, parentElement);
		}		 else if (cls.equals(SignInResponse.class)) {
			SignInResponseSerializer.AppendChildElement(doc, (SignInResponse) obj, parentElement);
		}		 else if (cls.equals(NewNoticeResponse.class)) {
			NewNoticeResponseSerializer.AppendChildElement(doc, (NewNoticeResponse) obj, parentElement);
		}		 else if (cls.equals(QueryNoticeRecieversResponse.class)) {
			QueryNoticeRecieversResponseSerializer.AppendChildElement(doc, (QueryNoticeRecieversResponse) obj, parentElement);
		}		 else if (cls.equals(QueryNoticesResponse.class)) {
			QueryNoticesResponseSerializer.AppendChildElement(doc, (QueryNoticesResponse) obj, parentElement);
		}		 else if (cls.equals(GetProjectMonthReportResponse.class)) {
			GetProjectMonthReportResponseSerializer.AppendChildElement(doc, (GetProjectMonthReportResponse) obj, parentElement);
		}		 else if (cls.equals(GetProjectResponse.class)) {
			GetProjectResponseSerializer.AppendChildElement(doc, (GetProjectResponse) obj, parentElement);
		}		 else if (cls.equals(GetTaskResponse.class)) {
			GetTaskResponseSerializer.AppendChildElement(doc, (GetTaskResponse) obj, parentElement);
		}		 else if (cls.equals(GetTaskTargetResponse.class)) {
			GetTaskTargetResponseSerializer.AppendChildElement(doc, (GetTaskTargetResponse) obj, parentElement);
		}		 else if (cls.equals(QueryAssistUnitsResponse.class)) {
			QueryAssistUnitsResponseSerializer.AppendChildElement(doc, (QueryAssistUnitsResponse) obj, parentElement);
		}		 else if (cls.equals(QueryProjectListResponse.class)) {
			QueryProjectListResponseSerializer.AppendChildElement(doc, (QueryProjectListResponse) obj, parentElement);
		}		 else if (cls.equals(QueryProjectMonthReportListResponse.class)) {
			QueryProjectMonthReportListResponseSerializer.AppendChildElement(doc, (QueryProjectMonthReportListResponse) obj, parentElement);
		}		 else if (cls.equals(QueryProjectPictureResponse.class)) {
			QueryProjectPictureResponseSerializer.AppendChildElement(doc, (QueryProjectPictureResponse) obj, parentElement);
		}		 else if (cls.equals(QueryProjectRemarkListResponse.class)) {
			QueryProjectRemarkListResponseSerializer.AppendChildElement(doc, (QueryProjectRemarkListResponse) obj, parentElement);
		}		 else if (cls.equals(QueryProjectTaskListResponse.class)) {
			QueryProjectTaskListResponseSerializer.AppendChildElement(doc, (QueryProjectTaskListResponse) obj, parentElement);
		}		 else if (cls.equals(QuerySubmitMonthReportResponse.class)) {
			QuerySubmitMonthReportResponseSerializer.AppendChildElement(doc, (QuerySubmitMonthReportResponse) obj, parentElement);
		}		 else if (cls.equals(QuerySubmitTaskTargetResponse.class)) {
			QuerySubmitTaskTargetResponseSerializer.AppendChildElement(doc, (QuerySubmitTaskTargetResponse) obj, parentElement);
		}		 else if (cls.equals(QueryTaskTargetResponse.class)) {
			QueryTaskTargetResponseSerializer.AppendChildElement(doc, (QueryTaskTargetResponse) obj, parentElement);
		}		 else if (cls.equals(QueryUnAcceptMonthReportResponse.class)) {
			QueryUnAcceptMonthReportResponseSerializer.AppendChildElement(doc, (QueryUnAcceptMonthReportResponse) obj, parentElement);
		}		 else if (cls.equals(QueryUnAcceptTaskResponse.class)) {
			QueryUnAcceptTaskResponseSerializer.AppendChildElement(doc, (QueryUnAcceptTaskResponse) obj, parentElement);
		}		 else if (cls.equals(QueryUnAcceptTaskTargetResponse.class)) {
			QueryUnAcceptTaskTargetResponseSerializer.AppendChildElement(doc, (QueryUnAcceptTaskTargetResponse) obj, parentElement);
		}		 else if (cls.equals(QueryUnAuditTaskTargetResponse.class)) {
			QueryUnAuditTaskTargetResponseSerializer.AppendChildElement(doc, (QueryUnAuditTaskTargetResponse) obj, parentElement);
		}		 else if (cls.equals(GetMagazineResponse.class)) {
			GetMagazineResponseSerializer.AppendChildElement(doc, (GetMagazineResponse) obj, parentElement);
		}		 else if (cls.equals(QueryMagazineAreaResponse.class)) {
			QueryMagazineAreaResponseSerializer.AppendChildElement(doc, (QueryMagazineAreaResponse) obj, parentElement);
		}		 else if (cls.equals(QueryMagazineKindResponse.class)) {
			QueryMagazineKindResponseSerializer.AppendChildElement(doc, (QueryMagazineKindResponse) obj, parentElement);
		}		 else if (cls.equals(QueryMagazineMetaDirResponse.class)) {
			QueryMagazineMetaDirResponseSerializer.AppendChildElement(doc, (QueryMagazineMetaDirResponse) obj, parentElement);
		}		 else if (cls.equals(QueryMagazineResponse.class)) {
			QueryMagazineResponseSerializer.AppendChildElement(doc, (QueryMagazineResponse) obj, parentElement);
		}		 else if (cls.equals(GetUserInfoResponse.class)) {
			GetUserInfoResponseSerializer.AppendChildElement(doc, (GetUserInfoResponse) obj, parentElement);
		}		 else if (cls.equals(GetDefaultIconCodesResponse.class)) {
			GetDefaultIconCodesResponseSerializer.AppendChildElement(doc, (GetDefaultIconCodesResponse) obj, parentElement);
		}		 else if (cls.equals(GetIconResponse.class)) {
			GetIconResponseSerializer.AppendChildElement(doc, (GetIconResponse) obj, parentElement);
		}		 else if (cls.equals(GetUsingIconResponse.class)) {
			GetUsingIconResponseSerializer.AppendChildElement(doc, (GetUsingIconResponse) obj, parentElement);
		}		 else if (cls.equals(SetIconResponse.class)) {
			SetIconResponseSerializer.AppendChildElement(doc, (SetIconResponse) obj, parentElement);
		}		 else if (cls.equals(GetPersonalSysConfigResponse.class)) {
			GetPersonalSysConfigResponseSerializer.AppendChildElement(doc, (GetPersonalSysConfigResponse) obj, parentElement);
		}		 else if (cls.equals(CheckPermissionResponse.class)) {
			CheckPermissionResponseSerializer.AppendChildElement(doc, (CheckPermissionResponse) obj, parentElement);
		}		 else if (cls.equals(GetAppInfosResponse.class)) {
			GetAppInfosResponseSerializer.AppendChildElement(doc, (GetAppInfosResponse) obj, parentElement);
		}		 else if (cls.equals(GetMapUserResponse.class)) {
			GetMapUserResponseSerializer.AppendChildElement(doc, (GetMapUserResponse) obj, parentElement);
		}		 else if (cls.equals(GetTokenResponse.class)) {
			GetTokenResponseSerializer.AppendChildElement(doc, (GetTokenResponse) obj, parentElement);
		}		 else if (cls.equals(GetTokenUrlResponse.class)) {
			GetTokenUrlResponseSerializer.AppendChildElement(doc, (GetTokenUrlResponse) obj, parentElement);
		}		 else if (cls.equals(QueryAllSMSParametersV2Response.class)) {
			QueryAllSMSParametersV2ResponseSerializer.AppendChildElement(doc, (QueryAllSMSParametersV2Response) obj, parentElement);
		}		 else if (cls.equals(QueryReceiveSMSIDV2Response.class)) {
			QueryReceiveSMSIDV2ResponseSerializer.AppendChildElement(doc, (QueryReceiveSMSIDV2Response) obj, parentElement);
		}		 else if (cls.equals(QueryReceiveSMSV2Response.class)) {
			QueryReceiveSMSV2ResponseSerializer.AppendChildElement(doc, (QueryReceiveSMSV2Response) obj, parentElement);
		}		 else if (cls.equals(QuerySendSMSIDV2Response.class)) {
			QuerySendSMSIDV2ResponseSerializer.AppendChildElement(doc, (QuerySendSMSIDV2Response) obj, parentElement);
		}		 else if (cls.equals(QuerySendSMSStatusDetailV2Response.class)) {
			QuerySendSMSStatusDetailV2ResponseSerializer.AppendChildElement(doc, (QuerySendSMSStatusDetailV2Response) obj, parentElement);
		}		 else if (cls.equals(QuerySendSMSV2Response.class)) {
			QuerySendSMSV2ResponseSerializer.AppendChildElement(doc, (QuerySendSMSV2Response) obj, parentElement);
		}		 else if (cls.equals(QuerySignerInfoV2Response.class)) {
			QuerySignerInfoV2ResponseSerializer.AppendChildElement(doc, (QuerySignerInfoV2Response) obj, parentElement);
		}		 else if (cls.equals(ReceiveSMSRemindEventV2Response.class)) {
			ReceiveSMSRemindEventV2ResponseSerializer.AppendChildElement(doc, (ReceiveSMSRemindEventV2Response) obj, parentElement);
		}		 else if (cls.equals(RemoveReceiveSMSRemindEventV2Response.class)) {
			RemoveReceiveSMSRemindEventV2ResponseSerializer.AppendChildElement(doc, (RemoveReceiveSMSRemindEventV2Response) obj, parentElement);
		}		 else if (cls.equals(RemoveReceiveSMSV2Request.class)) {
			RemoveReceiveSMSV2RequestSerializer.AppendChildElement(doc, (RemoveReceiveSMSV2Request) obj, parentElement);
		}		 else if (cls.equals(RemoveSendSMSRemindEventV2Response.class)) {
			RemoveSendSMSRemindEventV2ResponseSerializer.AppendChildElement(doc, (RemoveSendSMSRemindEventV2Response) obj, parentElement);
		}		 else if (cls.equals(SendSMSRemindEventV2Response.class)) {
			SendSMSRemindEventV2ResponseSerializer.AppendChildElement(doc, (SendSMSRemindEventV2Response) obj, parentElement);
		}		 else if (cls.equals(SendSMSStatusDetailRemindEventV2Response.class)) {
			SendSMSStatusDetailRemindEventV2ResponseSerializer.AppendChildElement(doc, (SendSMSStatusDetailRemindEventV2Response) obj, parentElement);
		}		 else if (cls.equals(SuccessResponse.class)) {
			SuccessResponseSerializer.AppendChildElement(doc, (SuccessResponse) obj, parentElement);
		}		 else if (cls.equals(GetWorkPlanResponse.class)) {
			GetWorkPlanResponseSerializer.AppendChildElement(doc, (GetWorkPlanResponse) obj, parentElement);
		}		 else if (cls.equals(QueryUserRolesResponse.class)) {
			QueryUserRolesResponseSerializer.AppendChildElement(doc, (QueryUserRolesResponse) obj, parentElement);
		}		 else if (cls.equals(QueryWorkPlanTableResponse.class)) {
			QueryWorkPlanTableResponseSerializer.AppendChildElement(doc, (QueryWorkPlanTableResponse) obj, parentElement);
		}		 else if (cls.equals(QueryWorkPlanTypeResponse.class)) {
			QueryWorkPlanTypeResponseSerializer.AppendChildElement(doc, (QueryWorkPlanTypeResponse) obj, parentElement);
		}
	}

}