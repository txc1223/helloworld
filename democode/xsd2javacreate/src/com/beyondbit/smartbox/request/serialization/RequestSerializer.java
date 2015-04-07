package com.beyondbit.smartbox.request.serialization;

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
import com.beyondbit.smartbox.request.Request;
import com.beyondbit.smartbox.request.AddCalendarRequest;
import com.beyondbit.smartbox.request.ClCheckPermissionRequest;
import com.beyondbit.smartbox.request.DeleteCalendarRequest;
import com.beyondbit.smartbox.request.FindDeptCalendarsRequest;
import com.beyondbit.smartbox.request.FindPersonnelCalendarsRequest;
import com.beyondbit.smartbox.request.GetCalendarUserShareListRequest;
import com.beyondbit.smartbox.request.GetCustomCalendarGroupListRequest;
import com.beyondbit.smartbox.request.GetCustomCalendarGroupUserListRequest;
import com.beyondbit.smartbox.request.GetDeptCalendarRequest;
import com.beyondbit.smartbox.request.GetPersonnelCalendarRequest;
import com.beyondbit.smartbox.request.GetUserDeptAndUnitRequest;
import com.beyondbit.smartbox.request.QueryCalendarsRequest;
import com.beyondbit.smartbox.request.QueryCalendarsByOrgCodesRequest;
import com.beyondbit.smartbox.request.QueryCalendarsByUserUIdsRequest;
import com.beyondbit.smartbox.request.QuerySubOrgsRequest;
import com.beyondbit.smartbox.request.QuerySubUsersRequest;
import com.beyondbit.smartbox.request.UpdateCalendarRequest;
import com.beyondbit.smartbox.request.GetCallBoardRequest;
import com.beyondbit.smartbox.request.QueryCallBoardRequest;
import com.beyondbit.smartbox.request.ViewCallBoardRequest;
import com.beyondbit.smartbox.request.IncreaseAppUsageCountRequest;
import com.beyondbit.smartbox.request.GetGlobalConfigRequest;
import com.beyondbit.smartbox.request.GetUpdateInfoRequest;
import com.beyondbit.smartbox.request.AddFriendGroupRequest;
import com.beyondbit.smartbox.request.AddFriendsRequest;
import com.beyondbit.smartbox.request.FriendInviteRequest;
import com.beyondbit.smartbox.request.GetAllFriendsRequest;
import com.beyondbit.smartbox.request.GetContactRequest;
import com.beyondbit.smartbox.request.GetContactCategorysRequest;
import com.beyondbit.smartbox.request.GetContactGroupsByCategoryRequest;
import com.beyondbit.smartbox.request.GetContactGroupsByParentGroupRequest;
import com.beyondbit.smartbox.request.GetContactsRequest;
import com.beyondbit.smartbox.request.GetContactsByContactCodesRequest;
import com.beyondbit.smartbox.request.GetFriendByGroupRequest;
import com.beyondbit.smartbox.request.GetFriendByUidRequest;
import com.beyondbit.smartbox.request.GetFriendGroupsRequest;
import com.beyondbit.smartbox.request.GetIMCacheRequest;
import com.beyondbit.smartbox.request.SendIMCacheRequest;
import com.beyondbit.smartbox.request.ModFriendRequest;
import com.beyondbit.smartbox.request.ModFriendGroupRequest;
import com.beyondbit.smartbox.request.MoveFriendsToGroupRequest;
import com.beyondbit.smartbox.request.FinishOfflineFileRequest;
import com.beyondbit.smartbox.request.GetOfflineFileRequest;
import com.beyondbit.smartbox.request.SendOfflineFileRequest;
import com.beyondbit.smartbox.request.QueryContactRequest;
import com.beyondbit.smartbox.request.RemoveFriendGroupRequest;
import com.beyondbit.smartbox.request.RemoveFriendsRequest;
import com.beyondbit.smartbox.request.GetUserSignatureRequest;
import com.beyondbit.smartbox.request.GetUserStatusRequest;
import com.beyondbit.smartbox.ptservice.GetDetailRequest;
import com.beyondbit.smartbox.ptservice.QuerySplitPageRequest;
import com.beyondbit.smartbox.ptservice.SubmitOpinionRequest;
import com.beyondbit.smartbox.ptservice.SubmitRequest;
import com.beyondbit.smartbox.ptservice.ValidateModuleRequest;
import com.beyondbit.smartbox.request.SignInRequest;
import com.beyondbit.smartbox.request.SignOutRequest;
import com.beyondbit.smartbox.request.DelNoticeRequest;
import com.beyondbit.smartbox.request.PublishNoticeRequest;
import com.beyondbit.smartbox.request.QueryNoticeRecieversRequest;
import com.beyondbit.smartbox.request.QueryNoticesRequest;
import com.beyondbit.smartbox.request.UpdateNoticeRequest;
import com.beyondbit.smartbox.request.ViewNoticeRequest;
import com.beyondbit.smartbox.ptservice.AcceptMonthReportRequest;
import com.beyondbit.smartbox.ptservice.AcceptTaskRequest;
import com.beyondbit.smartbox.ptservice.AcceptTaskTargetRequest;
import com.beyondbit.smartbox.ptservice.AddProjectRemarkRequest;
import com.beyondbit.smartbox.ptservice.AuditTaskTargetRequest;
import com.beyondbit.smartbox.ptservice.DeleteProjectRemarkRequest;
import com.beyondbit.smartbox.ptservice.GetProjectMonthReportRequest;
import com.beyondbit.smartbox.ptservice.GetProjectRequest;
import com.beyondbit.smartbox.ptservice.GetTaskRequest;
import com.beyondbit.smartbox.ptservice.GetTaskTargetRequest;
import com.beyondbit.smartbox.ptservice.ProcessMonthReportRequest;
import com.beyondbit.smartbox.ptservice.ProcessMonthReportRetrialRequest;
import com.beyondbit.smartbox.ptservice.ProcessMonthReportTrialRequest;
import com.beyondbit.smartbox.ptservice.ProcessTaskTargetRequest;
import com.beyondbit.smartbox.ptservice.ProcessTaskTargetRetrialRequest;
import com.beyondbit.smartbox.ptservice.ProcessTaskTargetTrialRequest;
import com.beyondbit.smartbox.ptservice.QueryAssistUnitsRequest;
import com.beyondbit.smartbox.ptservice.QueryProjectListRequest;
import com.beyondbit.smartbox.ptservice.QueryProjectMonthReportListRequest;
import com.beyondbit.smartbox.ptservice.QueryProjectPictureRequest;
import com.beyondbit.smartbox.ptservice.QueryProjectRemarkListRequest;
import com.beyondbit.smartbox.ptservice.QueryProjectTaskListRequest;
import com.beyondbit.smartbox.ptservice.QuerySubmitMonthReportRequest;
import com.beyondbit.smartbox.ptservice.QuerySubmitTaskTargetRequest;
import com.beyondbit.smartbox.ptservice.QueryTaskTargetRequest;
import com.beyondbit.smartbox.ptservice.QueryUnAcceptMonthReportRequest;
import com.beyondbit.smartbox.ptservice.QueryUnAcceptTaskRequest;
import com.beyondbit.smartbox.ptservice.QueryUnAcceptTaskTargetRequest;
import com.beyondbit.smartbox.ptservice.QueryUnAuditTaskTargetRequest;
import com.beyondbit.smartbox.request.GetMagazineRequest;
import com.beyondbit.smartbox.request.QueryMagazineAreaRequest;
import com.beyondbit.smartbox.request.QueryMagazineKindRequest;
import com.beyondbit.smartbox.request.QueryMagazineMetaDirRequest;
import com.beyondbit.smartbox.request.QueryMagazineRequest;
import com.beyondbit.smartbox.request.ViewMagazineRequest;
import com.beyondbit.smartbox.request.ChangePwdRequest;
import com.beyondbit.smartbox.request.ChangeSignatureRequest;
import com.beyondbit.smartbox.request.ChangeUserInfoRequest;
import com.beyondbit.smartbox.request.GetUserInfoRequest;
import com.beyondbit.smartbox.request.GetDefaultIconCodesRequest;
import com.beyondbit.smartbox.request.GetIconRequest;
import com.beyondbit.smartbox.request.GetUsingIconRequest;
import com.beyondbit.smartbox.request.SetIconRequest;
import com.beyondbit.smartbox.request.GetPersonalSysConfigRequest;
import com.beyondbit.smartbox.request.RemovePersonalSysConfigRequest;
import com.beyondbit.smartbox.request.SetPersonalSysConfigRequest;
import com.beyondbit.smartbox.request.SetSelfStatusRequest;
import com.beyondbit.smartbox.request.CheckPermissionRequest;
import com.beyondbit.smartbox.request.GetAppInfosRequest;
import com.beyondbit.smartbox.request.GetMapUserRequest;
import com.beyondbit.smartbox.request.GetTokenRequest;
import com.beyondbit.smartbox.request.GetTokenUrlRequest;
import com.beyondbit.smartbox.request.QueryAllSMSParametersV2Request;
import com.beyondbit.smartbox.request.QueryReceiveSMSIDV2Request;
import com.beyondbit.smartbox.request.QueryReceiveSMSV2Request;
import com.beyondbit.smartbox.request.QuerySendSMSIDV2Request;
import com.beyondbit.smartbox.request.QuerySendSMSStatusDetailV2Request;
import com.beyondbit.smartbox.request.QuerySendSMSV2Request;
import com.beyondbit.smartbox.request.QuerySignerInfoV2Request;
import com.beyondbit.smartbox.request.RemoveSendSMSV2Request;
import com.beyondbit.smartbox.request.SendSMSV2Request;
import com.beyondbit.smartbox.ptservice.AddWorkPlanRequest;
import com.beyondbit.smartbox.ptservice.DeleteWorkPlanRequest;
import com.beyondbit.smartbox.ptservice.GetWorkPlanRequest;
import com.beyondbit.smartbox.ptservice.QueryUserRolesRequest;
import com.beyondbit.smartbox.ptservice.QueryWorkPlanTableRequest;
import com.beyondbit.smartbox.ptservice.QueryWorkPlanTypeRequest;
import com.beyondbit.smartbox.ptservice.SubmitWorkPlanRequest;
import com.beyondbit.smartbox.ptservice.UpdateWorkPlanRequest;
import com.beyondbit.smartbox.request.serialization.AddCalendarRequestSerializer;
import com.beyondbit.smartbox.request.serialization.ClCheckPermissionRequestSerializer;
import com.beyondbit.smartbox.request.serialization.DeleteCalendarRequestSerializer;
import com.beyondbit.smartbox.request.serialization.FindDeptCalendarsRequestSerializer;
import com.beyondbit.smartbox.request.serialization.FindPersonnelCalendarsRequestSerializer;
import com.beyondbit.smartbox.request.serialization.GetCalendarUserShareListRequestSerializer;
import com.beyondbit.smartbox.request.serialization.GetCustomCalendarGroupListRequestSerializer;
import com.beyondbit.smartbox.request.serialization.GetCustomCalendarGroupUserListRequestSerializer;
import com.beyondbit.smartbox.request.serialization.GetDeptCalendarRequestSerializer;
import com.beyondbit.smartbox.request.serialization.GetPersonnelCalendarRequestSerializer;
import com.beyondbit.smartbox.request.serialization.GetUserDeptAndUnitRequestSerializer;
import com.beyondbit.smartbox.request.serialization.QueryCalendarsRequestSerializer;
import com.beyondbit.smartbox.request.serialization.QueryCalendarsByOrgCodesRequestSerializer;
import com.beyondbit.smartbox.request.serialization.QueryCalendarsByUserUIdsRequestSerializer;
import com.beyondbit.smartbox.request.serialization.QuerySubOrgsRequestSerializer;
import com.beyondbit.smartbox.request.serialization.QuerySubUsersRequestSerializer;
import com.beyondbit.smartbox.request.serialization.UpdateCalendarRequestSerializer;
import com.beyondbit.smartbox.request.serialization.GetCallBoardRequestSerializer;
import com.beyondbit.smartbox.request.serialization.QueryCallBoardRequestSerializer;
import com.beyondbit.smartbox.request.serialization.ViewCallBoardRequestSerializer;
import com.beyondbit.smartbox.request.serialization.IncreaseAppUsageCountRequestSerializer;
import com.beyondbit.smartbox.request.serialization.GetGlobalConfigRequestSerializer;
import com.beyondbit.smartbox.request.serialization.GetUpdateInfoRequestSerializer;
import com.beyondbit.smartbox.request.serialization.AddFriendGroupRequestSerializer;
import com.beyondbit.smartbox.request.serialization.AddFriendsRequestSerializer;
import com.beyondbit.smartbox.request.serialization.FriendInviteRequestSerializer;
import com.beyondbit.smartbox.request.serialization.GetAllFriendsRequestSerializer;
import com.beyondbit.smartbox.request.serialization.GetContactRequestSerializer;
import com.beyondbit.smartbox.request.serialization.GetContactCategorysRequestSerializer;
import com.beyondbit.smartbox.request.serialization.GetContactGroupsByCategoryRequestSerializer;
import com.beyondbit.smartbox.request.serialization.GetContactGroupsByParentGroupRequestSerializer;
import com.beyondbit.smartbox.request.serialization.GetContactsRequestSerializer;
import com.beyondbit.smartbox.request.serialization.GetContactsByContactCodesRequestSerializer;
import com.beyondbit.smartbox.request.serialization.GetFriendByGroupRequestSerializer;
import com.beyondbit.smartbox.request.serialization.GetFriendByUidRequestSerializer;
import com.beyondbit.smartbox.request.serialization.GetFriendGroupsRequestSerializer;
import com.beyondbit.smartbox.request.serialization.GetIMCacheRequestSerializer;
import com.beyondbit.smartbox.request.serialization.SendIMCacheRequestSerializer;
import com.beyondbit.smartbox.request.serialization.ModFriendRequestSerializer;
import com.beyondbit.smartbox.request.serialization.ModFriendGroupRequestSerializer;
import com.beyondbit.smartbox.request.serialization.MoveFriendsToGroupRequestSerializer;
import com.beyondbit.smartbox.request.serialization.FinishOfflineFileRequestSerializer;
import com.beyondbit.smartbox.request.serialization.GetOfflineFileRequestSerializer;
import com.beyondbit.smartbox.request.serialization.SendOfflineFileRequestSerializer;
import com.beyondbit.smartbox.request.serialization.QueryContactRequestSerializer;
import com.beyondbit.smartbox.request.serialization.RemoveFriendGroupRequestSerializer;
import com.beyondbit.smartbox.request.serialization.RemoveFriendsRequestSerializer;
import com.beyondbit.smartbox.request.serialization.GetUserSignatureRequestSerializer;
import com.beyondbit.smartbox.request.serialization.GetUserStatusRequestSerializer;
import com.beyondbit.smartbox.ptservice.serialization.GetDetailRequestSerializer;
import com.beyondbit.smartbox.ptservice.serialization.QuerySplitPageRequestSerializer;
import com.beyondbit.smartbox.ptservice.serialization.SubmitOpinionRequestSerializer;
import com.beyondbit.smartbox.ptservice.serialization.SubmitRequestSerializer;
import com.beyondbit.smartbox.ptservice.serialization.ValidateModuleRequestSerializer;
import com.beyondbit.smartbox.request.serialization.SignInRequestSerializer;
import com.beyondbit.smartbox.request.serialization.SignOutRequestSerializer;
import com.beyondbit.smartbox.request.serialization.DelNoticeRequestSerializer;
import com.beyondbit.smartbox.request.serialization.PublishNoticeRequestSerializer;
import com.beyondbit.smartbox.request.serialization.QueryNoticeRecieversRequestSerializer;
import com.beyondbit.smartbox.request.serialization.QueryNoticesRequestSerializer;
import com.beyondbit.smartbox.request.serialization.UpdateNoticeRequestSerializer;
import com.beyondbit.smartbox.request.serialization.ViewNoticeRequestSerializer;
import com.beyondbit.smartbox.ptservice.serialization.AcceptMonthReportRequestSerializer;
import com.beyondbit.smartbox.ptservice.serialization.AcceptTaskRequestSerializer;
import com.beyondbit.smartbox.ptservice.serialization.AcceptTaskTargetRequestSerializer;
import com.beyondbit.smartbox.ptservice.serialization.AddProjectRemarkRequestSerializer;
import com.beyondbit.smartbox.ptservice.serialization.AuditTaskTargetRequestSerializer;
import com.beyondbit.smartbox.ptservice.serialization.DeleteProjectRemarkRequestSerializer;
import com.beyondbit.smartbox.ptservice.serialization.GetProjectMonthReportRequestSerializer;
import com.beyondbit.smartbox.ptservice.serialization.GetProjectRequestSerializer;
import com.beyondbit.smartbox.ptservice.serialization.GetTaskRequestSerializer;
import com.beyondbit.smartbox.ptservice.serialization.GetTaskTargetRequestSerializer;
import com.beyondbit.smartbox.ptservice.serialization.ProcessMonthReportRequestSerializer;
import com.beyondbit.smartbox.ptservice.serialization.ProcessMonthReportRetrialRequestSerializer;
import com.beyondbit.smartbox.ptservice.serialization.ProcessMonthReportTrialRequestSerializer;
import com.beyondbit.smartbox.ptservice.serialization.ProcessTaskTargetRequestSerializer;
import com.beyondbit.smartbox.ptservice.serialization.ProcessTaskTargetRetrialRequestSerializer;
import com.beyondbit.smartbox.ptservice.serialization.ProcessTaskTargetTrialRequestSerializer;
import com.beyondbit.smartbox.ptservice.serialization.QueryAssistUnitsRequestSerializer;
import com.beyondbit.smartbox.ptservice.serialization.QueryProjectListRequestSerializer;
import com.beyondbit.smartbox.ptservice.serialization.QueryProjectMonthReportListRequestSerializer;
import com.beyondbit.smartbox.ptservice.serialization.QueryProjectPictureRequestSerializer;
import com.beyondbit.smartbox.ptservice.serialization.QueryProjectRemarkListRequestSerializer;
import com.beyondbit.smartbox.ptservice.serialization.QueryProjectTaskListRequestSerializer;
import com.beyondbit.smartbox.ptservice.serialization.QuerySubmitMonthReportRequestSerializer;
import com.beyondbit.smartbox.ptservice.serialization.QuerySubmitTaskTargetRequestSerializer;
import com.beyondbit.smartbox.ptservice.serialization.QueryTaskTargetRequestSerializer;
import com.beyondbit.smartbox.ptservice.serialization.QueryUnAcceptMonthReportRequestSerializer;
import com.beyondbit.smartbox.ptservice.serialization.QueryUnAcceptTaskRequestSerializer;
import com.beyondbit.smartbox.ptservice.serialization.QueryUnAcceptTaskTargetRequestSerializer;
import com.beyondbit.smartbox.ptservice.serialization.QueryUnAuditTaskTargetRequestSerializer;
import com.beyondbit.smartbox.request.serialization.GetMagazineRequestSerializer;
import com.beyondbit.smartbox.request.serialization.QueryMagazineAreaRequestSerializer;
import com.beyondbit.smartbox.request.serialization.QueryMagazineKindRequestSerializer;
import com.beyondbit.smartbox.request.serialization.QueryMagazineMetaDirRequestSerializer;
import com.beyondbit.smartbox.request.serialization.QueryMagazineRequestSerializer;
import com.beyondbit.smartbox.request.serialization.ViewMagazineRequestSerializer;
import com.beyondbit.smartbox.request.serialization.ChangePwdRequestSerializer;
import com.beyondbit.smartbox.request.serialization.ChangeSignatureRequestSerializer;
import com.beyondbit.smartbox.request.serialization.ChangeUserInfoRequestSerializer;
import com.beyondbit.smartbox.request.serialization.GetUserInfoRequestSerializer;
import com.beyondbit.smartbox.request.serialization.GetDefaultIconCodesRequestSerializer;
import com.beyondbit.smartbox.request.serialization.GetIconRequestSerializer;
import com.beyondbit.smartbox.request.serialization.GetUsingIconRequestSerializer;
import com.beyondbit.smartbox.request.serialization.SetIconRequestSerializer;
import com.beyondbit.smartbox.request.serialization.GetPersonalSysConfigRequestSerializer;
import com.beyondbit.smartbox.request.serialization.RemovePersonalSysConfigRequestSerializer;
import com.beyondbit.smartbox.request.serialization.SetPersonalSysConfigRequestSerializer;
import com.beyondbit.smartbox.request.serialization.SetSelfStatusRequestSerializer;
import com.beyondbit.smartbox.request.serialization.CheckPermissionRequestSerializer;
import com.beyondbit.smartbox.request.serialization.GetAppInfosRequestSerializer;
import com.beyondbit.smartbox.request.serialization.GetMapUserRequestSerializer;
import com.beyondbit.smartbox.request.serialization.GetTokenRequestSerializer;
import com.beyondbit.smartbox.request.serialization.GetTokenUrlRequestSerializer;
import com.beyondbit.smartbox.request.serialization.QueryAllSMSParametersV2RequestSerializer;
import com.beyondbit.smartbox.request.serialization.QueryReceiveSMSIDV2RequestSerializer;
import com.beyondbit.smartbox.request.serialization.QueryReceiveSMSV2RequestSerializer;
import com.beyondbit.smartbox.request.serialization.QuerySendSMSIDV2RequestSerializer;
import com.beyondbit.smartbox.request.serialization.QuerySendSMSStatusDetailV2RequestSerializer;
import com.beyondbit.smartbox.request.serialization.QuerySendSMSV2RequestSerializer;
import com.beyondbit.smartbox.request.serialization.QuerySignerInfoV2RequestSerializer;
import com.beyondbit.smartbox.request.serialization.RemoveSendSMSV2RequestSerializer;
import com.beyondbit.smartbox.request.serialization.SendSMSV2RequestSerializer;
import com.beyondbit.smartbox.ptservice.serialization.AddWorkPlanRequestSerializer;
import com.beyondbit.smartbox.ptservice.serialization.DeleteWorkPlanRequestSerializer;
import com.beyondbit.smartbox.ptservice.serialization.GetWorkPlanRequestSerializer;
import com.beyondbit.smartbox.ptservice.serialization.QueryUserRolesRequestSerializer;
import com.beyondbit.smartbox.ptservice.serialization.QueryWorkPlanTableRequestSerializer;
import com.beyondbit.smartbox.ptservice.serialization.QueryWorkPlanTypeRequestSerializer;
import com.beyondbit.smartbox.ptservice.serialization.SubmitWorkPlanRequestSerializer;
import com.beyondbit.smartbox.ptservice.serialization.UpdateWorkPlanRequestSerializer;

public class RequestSerializer {

	public static Request dserialize(String obj) {
		return null;
	}
	public static String serialize(Request obj) {
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

	public static void AppendRootElement(Document doc, Request obj) {
		Element rootElement = doc.createElementNS("http://www.beyondbit.com/smartbox/request","req:Request");
		rootElement.setAttributeNS("http://www.w3.org/2001/XMLSchema-instance","xsi:type","req:"+obj.getClass().getSimpleName());
		
		AppendChildElement(doc, obj, rootElement);

		doc.appendChild(rootElement);
	}

	public static void AppendChildElement(Document doc, Request obj, Element parentElement) {
		Class<? extends Request> cls = obj.getClass();

		if (cls.equals(AddCalendarRequest.class)) {
			AddCalendarRequestSerializer.AppendChildElement(doc, (AddCalendarRequest) obj, parentElement);
		}		 else if (cls.equals(ClCheckPermissionRequest.class)) {
			ClCheckPermissionRequestSerializer.AppendChildElement(doc, (ClCheckPermissionRequest) obj, parentElement);
		}		 else if (cls.equals(DeleteCalendarRequest.class)) {
			DeleteCalendarRequestSerializer.AppendChildElement(doc, (DeleteCalendarRequest) obj, parentElement);
		}		 else if (cls.equals(FindDeptCalendarsRequest.class)) {
			FindDeptCalendarsRequestSerializer.AppendChildElement(doc, (FindDeptCalendarsRequest) obj, parentElement);
		}		 else if (cls.equals(FindPersonnelCalendarsRequest.class)) {
			FindPersonnelCalendarsRequestSerializer.AppendChildElement(doc, (FindPersonnelCalendarsRequest) obj, parentElement);
		}		 else if (cls.equals(GetCalendarUserShareListRequest.class)) {
			GetCalendarUserShareListRequestSerializer.AppendChildElement(doc, (GetCalendarUserShareListRequest) obj, parentElement);
		}		 else if (cls.equals(GetCustomCalendarGroupListRequest.class)) {
			GetCustomCalendarGroupListRequestSerializer.AppendChildElement(doc, (GetCustomCalendarGroupListRequest) obj, parentElement);
		}		 else if (cls.equals(GetCustomCalendarGroupUserListRequest.class)) {
			GetCustomCalendarGroupUserListRequestSerializer.AppendChildElement(doc, (GetCustomCalendarGroupUserListRequest) obj, parentElement);
		}		 else if (cls.equals(GetDeptCalendarRequest.class)) {
			GetDeptCalendarRequestSerializer.AppendChildElement(doc, (GetDeptCalendarRequest) obj, parentElement);
		}		 else if (cls.equals(GetPersonnelCalendarRequest.class)) {
			GetPersonnelCalendarRequestSerializer.AppendChildElement(doc, (GetPersonnelCalendarRequest) obj, parentElement);
		}		 else if (cls.equals(GetUserDeptAndUnitRequest.class)) {
			GetUserDeptAndUnitRequestSerializer.AppendChildElement(doc, (GetUserDeptAndUnitRequest) obj, parentElement);
		}		 else if (cls.equals(QueryCalendarsRequest.class)) {
			QueryCalendarsRequestSerializer.AppendChildElement(doc, (QueryCalendarsRequest) obj, parentElement);
		}		 else if (cls.equals(QueryCalendarsByOrgCodesRequest.class)) {
			QueryCalendarsByOrgCodesRequestSerializer.AppendChildElement(doc, (QueryCalendarsByOrgCodesRequest) obj, parentElement);
		}		 else if (cls.equals(QueryCalendarsByUserUIdsRequest.class)) {
			QueryCalendarsByUserUIdsRequestSerializer.AppendChildElement(doc, (QueryCalendarsByUserUIdsRequest) obj, parentElement);
		}		 else if (cls.equals(QuerySubOrgsRequest.class)) {
			QuerySubOrgsRequestSerializer.AppendChildElement(doc, (QuerySubOrgsRequest) obj, parentElement);
		}		 else if (cls.equals(QuerySubUsersRequest.class)) {
			QuerySubUsersRequestSerializer.AppendChildElement(doc, (QuerySubUsersRequest) obj, parentElement);
		}		 else if (cls.equals(UpdateCalendarRequest.class)) {
			UpdateCalendarRequestSerializer.AppendChildElement(doc, (UpdateCalendarRequest) obj, parentElement);
		}		 else if (cls.equals(GetCallBoardRequest.class)) {
			GetCallBoardRequestSerializer.AppendChildElement(doc, (GetCallBoardRequest) obj, parentElement);
		}		 else if (cls.equals(QueryCallBoardRequest.class)) {
			QueryCallBoardRequestSerializer.AppendChildElement(doc, (QueryCallBoardRequest) obj, parentElement);
		}		 else if (cls.equals(ViewCallBoardRequest.class)) {
			ViewCallBoardRequestSerializer.AppendChildElement(doc, (ViewCallBoardRequest) obj, parentElement);
		}		 else if (cls.equals(IncreaseAppUsageCountRequest.class)) {
			IncreaseAppUsageCountRequestSerializer.AppendChildElement(doc, (IncreaseAppUsageCountRequest) obj, parentElement);
		}		 else if (cls.equals(GetGlobalConfigRequest.class)) {
			GetGlobalConfigRequestSerializer.AppendChildElement(doc, (GetGlobalConfigRequest) obj, parentElement);
		}		 else if (cls.equals(GetUpdateInfoRequest.class)) {
			GetUpdateInfoRequestSerializer.AppendChildElement(doc, (GetUpdateInfoRequest) obj, parentElement);
		}		 else if (cls.equals(AddFriendGroupRequest.class)) {
			AddFriendGroupRequestSerializer.AppendChildElement(doc, (AddFriendGroupRequest) obj, parentElement);
		}		 else if (cls.equals(AddFriendsRequest.class)) {
			AddFriendsRequestSerializer.AppendChildElement(doc, (AddFriendsRequest) obj, parentElement);
		}		 else if (cls.equals(FriendInviteRequest.class)) {
			FriendInviteRequestSerializer.AppendChildElement(doc, (FriendInviteRequest) obj, parentElement);
		}		 else if (cls.equals(GetAllFriendsRequest.class)) {
			GetAllFriendsRequestSerializer.AppendChildElement(doc, (GetAllFriendsRequest) obj, parentElement);
		}		 else if (cls.equals(GetContactRequest.class)) {
			GetContactRequestSerializer.AppendChildElement(doc, (GetContactRequest) obj, parentElement);
		}		 else if (cls.equals(GetContactCategorysRequest.class)) {
			GetContactCategorysRequestSerializer.AppendChildElement(doc, (GetContactCategorysRequest) obj, parentElement);
		}		 else if (cls.equals(GetContactGroupsByCategoryRequest.class)) {
			GetContactGroupsByCategoryRequestSerializer.AppendChildElement(doc, (GetContactGroupsByCategoryRequest) obj, parentElement);
		}		 else if (cls.equals(GetContactGroupsByParentGroupRequest.class)) {
			GetContactGroupsByParentGroupRequestSerializer.AppendChildElement(doc, (GetContactGroupsByParentGroupRequest) obj, parentElement);
		}		 else if (cls.equals(GetContactsRequest.class)) {
			GetContactsRequestSerializer.AppendChildElement(doc, (GetContactsRequest) obj, parentElement);
		}		 else if (cls.equals(GetContactsByContactCodesRequest.class)) {
			GetContactsByContactCodesRequestSerializer.AppendChildElement(doc, (GetContactsByContactCodesRequest) obj, parentElement);
		}		 else if (cls.equals(GetFriendByGroupRequest.class)) {
			GetFriendByGroupRequestSerializer.AppendChildElement(doc, (GetFriendByGroupRequest) obj, parentElement);
		}		 else if (cls.equals(GetFriendByUidRequest.class)) {
			GetFriendByUidRequestSerializer.AppendChildElement(doc, (GetFriendByUidRequest) obj, parentElement);
		}		 else if (cls.equals(GetFriendGroupsRequest.class)) {
			GetFriendGroupsRequestSerializer.AppendChildElement(doc, (GetFriendGroupsRequest) obj, parentElement);
		}		 else if (cls.equals(GetIMCacheRequest.class)) {
			GetIMCacheRequestSerializer.AppendChildElement(doc, (GetIMCacheRequest) obj, parentElement);
		}		 else if (cls.equals(SendIMCacheRequest.class)) {
			SendIMCacheRequestSerializer.AppendChildElement(doc, (SendIMCacheRequest) obj, parentElement);
		}		 else if (cls.equals(ModFriendRequest.class)) {
			ModFriendRequestSerializer.AppendChildElement(doc, (ModFriendRequest) obj, parentElement);
		}		 else if (cls.equals(ModFriendGroupRequest.class)) {
			ModFriendGroupRequestSerializer.AppendChildElement(doc, (ModFriendGroupRequest) obj, parentElement);
		}		 else if (cls.equals(MoveFriendsToGroupRequest.class)) {
			MoveFriendsToGroupRequestSerializer.AppendChildElement(doc, (MoveFriendsToGroupRequest) obj, parentElement);
		}		 else if (cls.equals(FinishOfflineFileRequest.class)) {
			FinishOfflineFileRequestSerializer.AppendChildElement(doc, (FinishOfflineFileRequest) obj, parentElement);
		}		 else if (cls.equals(GetOfflineFileRequest.class)) {
			GetOfflineFileRequestSerializer.AppendChildElement(doc, (GetOfflineFileRequest) obj, parentElement);
		}		 else if (cls.equals(SendOfflineFileRequest.class)) {
			SendOfflineFileRequestSerializer.AppendChildElement(doc, (SendOfflineFileRequest) obj, parentElement);
		}		 else if (cls.equals(QueryContactRequest.class)) {
			QueryContactRequestSerializer.AppendChildElement(doc, (QueryContactRequest) obj, parentElement);
		}		 else if (cls.equals(RemoveFriendGroupRequest.class)) {
			RemoveFriendGroupRequestSerializer.AppendChildElement(doc, (RemoveFriendGroupRequest) obj, parentElement);
		}		 else if (cls.equals(RemoveFriendsRequest.class)) {
			RemoveFriendsRequestSerializer.AppendChildElement(doc, (RemoveFriendsRequest) obj, parentElement);
		}		 else if (cls.equals(GetUserSignatureRequest.class)) {
			GetUserSignatureRequestSerializer.AppendChildElement(doc, (GetUserSignatureRequest) obj, parentElement);
		}		 else if (cls.equals(GetUserStatusRequest.class)) {
			GetUserStatusRequestSerializer.AppendChildElement(doc, (GetUserStatusRequest) obj, parentElement);
		}		 else if (cls.equals(GetDetailRequest.class)) {
			GetDetailRequestSerializer.AppendChildElement(doc, (GetDetailRequest) obj, parentElement);
		}		 else if (cls.equals(QuerySplitPageRequest.class)) {
			QuerySplitPageRequestSerializer.AppendChildElement(doc, (QuerySplitPageRequest) obj, parentElement);
		}		 else if (cls.equals(SubmitOpinionRequest.class)) {
			SubmitOpinionRequestSerializer.AppendChildElement(doc, (SubmitOpinionRequest) obj, parentElement);
		}		 else if (cls.equals(SubmitRequest.class)) {
			SubmitRequestSerializer.AppendChildElement(doc, (SubmitRequest) obj, parentElement);
		}		 else if (cls.equals(ValidateModuleRequest.class)) {
			ValidateModuleRequestSerializer.AppendChildElement(doc, (ValidateModuleRequest) obj, parentElement);
		}		 else if (cls.equals(SignInRequest.class)) {
			SignInRequestSerializer.AppendChildElement(doc, (SignInRequest) obj, parentElement);
		}		 else if (cls.equals(SignOutRequest.class)) {
			SignOutRequestSerializer.AppendChildElement(doc, (SignOutRequest) obj, parentElement);
		}		 else if (cls.equals(DelNoticeRequest.class)) {
			DelNoticeRequestSerializer.AppendChildElement(doc, (DelNoticeRequest) obj, parentElement);
		}		 else if (cls.equals(PublishNoticeRequest.class)) {
			PublishNoticeRequestSerializer.AppendChildElement(doc, (PublishNoticeRequest) obj, parentElement);
		}		 else if (cls.equals(QueryNoticeRecieversRequest.class)) {
			QueryNoticeRecieversRequestSerializer.AppendChildElement(doc, (QueryNoticeRecieversRequest) obj, parentElement);
		}		 else if (cls.equals(QueryNoticesRequest.class)) {
			QueryNoticesRequestSerializer.AppendChildElement(doc, (QueryNoticesRequest) obj, parentElement);
		}		 else if (cls.equals(UpdateNoticeRequest.class)) {
			UpdateNoticeRequestSerializer.AppendChildElement(doc, (UpdateNoticeRequest) obj, parentElement);
		}		 else if (cls.equals(ViewNoticeRequest.class)) {
			ViewNoticeRequestSerializer.AppendChildElement(doc, (ViewNoticeRequest) obj, parentElement);
		}		 else if (cls.equals(AcceptMonthReportRequest.class)) {
			AcceptMonthReportRequestSerializer.AppendChildElement(doc, (AcceptMonthReportRequest) obj, parentElement);
		}		 else if (cls.equals(AcceptTaskRequest.class)) {
			AcceptTaskRequestSerializer.AppendChildElement(doc, (AcceptTaskRequest) obj, parentElement);
		}		 else if (cls.equals(AcceptTaskTargetRequest.class)) {
			AcceptTaskTargetRequestSerializer.AppendChildElement(doc, (AcceptTaskTargetRequest) obj, parentElement);
		}		 else if (cls.equals(AddProjectRemarkRequest.class)) {
			AddProjectRemarkRequestSerializer.AppendChildElement(doc, (AddProjectRemarkRequest) obj, parentElement);
		}		 else if (cls.equals(AuditTaskTargetRequest.class)) {
			AuditTaskTargetRequestSerializer.AppendChildElement(doc, (AuditTaskTargetRequest) obj, parentElement);
		}		 else if (cls.equals(DeleteProjectRemarkRequest.class)) {
			DeleteProjectRemarkRequestSerializer.AppendChildElement(doc, (DeleteProjectRemarkRequest) obj, parentElement);
		}		 else if (cls.equals(GetProjectMonthReportRequest.class)) {
			GetProjectMonthReportRequestSerializer.AppendChildElement(doc, (GetProjectMonthReportRequest) obj, parentElement);
		}		 else if (cls.equals(GetProjectRequest.class)) {
			GetProjectRequestSerializer.AppendChildElement(doc, (GetProjectRequest) obj, parentElement);
		}		 else if (cls.equals(GetTaskRequest.class)) {
			GetTaskRequestSerializer.AppendChildElement(doc, (GetTaskRequest) obj, parentElement);
		}		 else if (cls.equals(GetTaskTargetRequest.class)) {
			GetTaskTargetRequestSerializer.AppendChildElement(doc, (GetTaskTargetRequest) obj, parentElement);
		}		 else if (cls.equals(ProcessMonthReportRequest.class)) {
			ProcessMonthReportRequestSerializer.AppendChildElement(doc, (ProcessMonthReportRequest) obj, parentElement);
		}		 else if (cls.equals(ProcessMonthReportRetrialRequest.class)) {
			ProcessMonthReportRetrialRequestSerializer.AppendChildElement(doc, (ProcessMonthReportRetrialRequest) obj, parentElement);
		}		 else if (cls.equals(ProcessMonthReportTrialRequest.class)) {
			ProcessMonthReportTrialRequestSerializer.AppendChildElement(doc, (ProcessMonthReportTrialRequest) obj, parentElement);
		}		 else if (cls.equals(ProcessTaskTargetRequest.class)) {
			ProcessTaskTargetRequestSerializer.AppendChildElement(doc, (ProcessTaskTargetRequest) obj, parentElement);
		}		 else if (cls.equals(ProcessTaskTargetRetrialRequest.class)) {
			ProcessTaskTargetRetrialRequestSerializer.AppendChildElement(doc, (ProcessTaskTargetRetrialRequest) obj, parentElement);
		}		 else if (cls.equals(ProcessTaskTargetTrialRequest.class)) {
			ProcessTaskTargetTrialRequestSerializer.AppendChildElement(doc, (ProcessTaskTargetTrialRequest) obj, parentElement);
		}		 else if (cls.equals(QueryAssistUnitsRequest.class)) {
			QueryAssistUnitsRequestSerializer.AppendChildElement(doc, (QueryAssistUnitsRequest) obj, parentElement);
		}		 else if (cls.equals(QueryProjectListRequest.class)) {
			QueryProjectListRequestSerializer.AppendChildElement(doc, (QueryProjectListRequest) obj, parentElement);
		}		 else if (cls.equals(QueryProjectMonthReportListRequest.class)) {
			QueryProjectMonthReportListRequestSerializer.AppendChildElement(doc, (QueryProjectMonthReportListRequest) obj, parentElement);
		}		 else if (cls.equals(QueryProjectPictureRequest.class)) {
			QueryProjectPictureRequestSerializer.AppendChildElement(doc, (QueryProjectPictureRequest) obj, parentElement);
		}		 else if (cls.equals(QueryProjectRemarkListRequest.class)) {
			QueryProjectRemarkListRequestSerializer.AppendChildElement(doc, (QueryProjectRemarkListRequest) obj, parentElement);
		}		 else if (cls.equals(QueryProjectTaskListRequest.class)) {
			QueryProjectTaskListRequestSerializer.AppendChildElement(doc, (QueryProjectTaskListRequest) obj, parentElement);
		}		 else if (cls.equals(QuerySubmitMonthReportRequest.class)) {
			QuerySubmitMonthReportRequestSerializer.AppendChildElement(doc, (QuerySubmitMonthReportRequest) obj, parentElement);
		}		 else if (cls.equals(QuerySubmitTaskTargetRequest.class)) {
			QuerySubmitTaskTargetRequestSerializer.AppendChildElement(doc, (QuerySubmitTaskTargetRequest) obj, parentElement);
		}		 else if (cls.equals(QueryTaskTargetRequest.class)) {
			QueryTaskTargetRequestSerializer.AppendChildElement(doc, (QueryTaskTargetRequest) obj, parentElement);
		}		 else if (cls.equals(QueryUnAcceptMonthReportRequest.class)) {
			QueryUnAcceptMonthReportRequestSerializer.AppendChildElement(doc, (QueryUnAcceptMonthReportRequest) obj, parentElement);
		}		 else if (cls.equals(QueryUnAcceptTaskRequest.class)) {
			QueryUnAcceptTaskRequestSerializer.AppendChildElement(doc, (QueryUnAcceptTaskRequest) obj, parentElement);
		}		 else if (cls.equals(QueryUnAcceptTaskTargetRequest.class)) {
			QueryUnAcceptTaskTargetRequestSerializer.AppendChildElement(doc, (QueryUnAcceptTaskTargetRequest) obj, parentElement);
		}		 else if (cls.equals(QueryUnAuditTaskTargetRequest.class)) {
			QueryUnAuditTaskTargetRequestSerializer.AppendChildElement(doc, (QueryUnAuditTaskTargetRequest) obj, parentElement);
		}		 else if (cls.equals(GetMagazineRequest.class)) {
			GetMagazineRequestSerializer.AppendChildElement(doc, (GetMagazineRequest) obj, parentElement);
		}		 else if (cls.equals(QueryMagazineAreaRequest.class)) {
			QueryMagazineAreaRequestSerializer.AppendChildElement(doc, (QueryMagazineAreaRequest) obj, parentElement);
		}		 else if (cls.equals(QueryMagazineKindRequest.class)) {
			QueryMagazineKindRequestSerializer.AppendChildElement(doc, (QueryMagazineKindRequest) obj, parentElement);
		}		 else if (cls.equals(QueryMagazineMetaDirRequest.class)) {
			QueryMagazineMetaDirRequestSerializer.AppendChildElement(doc, (QueryMagazineMetaDirRequest) obj, parentElement);
		}		 else if (cls.equals(QueryMagazineRequest.class)) {
			QueryMagazineRequestSerializer.AppendChildElement(doc, (QueryMagazineRequest) obj, parentElement);
		}		 else if (cls.equals(ViewMagazineRequest.class)) {
			ViewMagazineRequestSerializer.AppendChildElement(doc, (ViewMagazineRequest) obj, parentElement);
		}		 else if (cls.equals(ChangePwdRequest.class)) {
			ChangePwdRequestSerializer.AppendChildElement(doc, (ChangePwdRequest) obj, parentElement);
		}		 else if (cls.equals(ChangeSignatureRequest.class)) {
			ChangeSignatureRequestSerializer.AppendChildElement(doc, (ChangeSignatureRequest) obj, parentElement);
		}		 else if (cls.equals(ChangeUserInfoRequest.class)) {
			ChangeUserInfoRequestSerializer.AppendChildElement(doc, (ChangeUserInfoRequest) obj, parentElement);
		}		 else if (cls.equals(GetUserInfoRequest.class)) {
			GetUserInfoRequestSerializer.AppendChildElement(doc, (GetUserInfoRequest) obj, parentElement);
		}		 else if (cls.equals(GetDefaultIconCodesRequest.class)) {
			GetDefaultIconCodesRequestSerializer.AppendChildElement(doc, (GetDefaultIconCodesRequest) obj, parentElement);
		}		 else if (cls.equals(GetIconRequest.class)) {
			GetIconRequestSerializer.AppendChildElement(doc, (GetIconRequest) obj, parentElement);
		}		 else if (cls.equals(GetUsingIconRequest.class)) {
			GetUsingIconRequestSerializer.AppendChildElement(doc, (GetUsingIconRequest) obj, parentElement);
		}		 else if (cls.equals(SetIconRequest.class)) {
			SetIconRequestSerializer.AppendChildElement(doc, (SetIconRequest) obj, parentElement);
		}		 else if (cls.equals(GetPersonalSysConfigRequest.class)) {
			GetPersonalSysConfigRequestSerializer.AppendChildElement(doc, (GetPersonalSysConfigRequest) obj, parentElement);
		}		 else if (cls.equals(RemovePersonalSysConfigRequest.class)) {
			RemovePersonalSysConfigRequestSerializer.AppendChildElement(doc, (RemovePersonalSysConfigRequest) obj, parentElement);
		}		 else if (cls.equals(SetPersonalSysConfigRequest.class)) {
			SetPersonalSysConfigRequestSerializer.AppendChildElement(doc, (SetPersonalSysConfigRequest) obj, parentElement);
		}		 else if (cls.equals(SetSelfStatusRequest.class)) {
			SetSelfStatusRequestSerializer.AppendChildElement(doc, (SetSelfStatusRequest) obj, parentElement);
		}		 else if (cls.equals(CheckPermissionRequest.class)) {
			CheckPermissionRequestSerializer.AppendChildElement(doc, (CheckPermissionRequest) obj, parentElement);
		}		 else if (cls.equals(GetAppInfosRequest.class)) {
			GetAppInfosRequestSerializer.AppendChildElement(doc, (GetAppInfosRequest) obj, parentElement);
		}		 else if (cls.equals(GetMapUserRequest.class)) {
			GetMapUserRequestSerializer.AppendChildElement(doc, (GetMapUserRequest) obj, parentElement);
		}		 else if (cls.equals(GetTokenRequest.class)) {
			GetTokenRequestSerializer.AppendChildElement(doc, (GetTokenRequest) obj, parentElement);
		}		 else if (cls.equals(GetTokenUrlRequest.class)) {
			GetTokenUrlRequestSerializer.AppendChildElement(doc, (GetTokenUrlRequest) obj, parentElement);
		}		 else if (cls.equals(QueryAllSMSParametersV2Request.class)) {
			QueryAllSMSParametersV2RequestSerializer.AppendChildElement(doc, (QueryAllSMSParametersV2Request) obj, parentElement);
		}		 else if (cls.equals(QueryReceiveSMSIDV2Request.class)) {
			QueryReceiveSMSIDV2RequestSerializer.AppendChildElement(doc, (QueryReceiveSMSIDV2Request) obj, parentElement);
		}		 else if (cls.equals(QueryReceiveSMSV2Request.class)) {
			QueryReceiveSMSV2RequestSerializer.AppendChildElement(doc, (QueryReceiveSMSV2Request) obj, parentElement);
		}		 else if (cls.equals(QuerySendSMSIDV2Request.class)) {
			QuerySendSMSIDV2RequestSerializer.AppendChildElement(doc, (QuerySendSMSIDV2Request) obj, parentElement);
		}		 else if (cls.equals(QuerySendSMSStatusDetailV2Request.class)) {
			QuerySendSMSStatusDetailV2RequestSerializer.AppendChildElement(doc, (QuerySendSMSStatusDetailV2Request) obj, parentElement);
		}		 else if (cls.equals(QuerySendSMSV2Request.class)) {
			QuerySendSMSV2RequestSerializer.AppendChildElement(doc, (QuerySendSMSV2Request) obj, parentElement);
		}		 else if (cls.equals(QuerySignerInfoV2Request.class)) {
			QuerySignerInfoV2RequestSerializer.AppendChildElement(doc, (QuerySignerInfoV2Request) obj, parentElement);
		}		 else if (cls.equals(RemoveSendSMSV2Request.class)) {
			RemoveSendSMSV2RequestSerializer.AppendChildElement(doc, (RemoveSendSMSV2Request) obj, parentElement);
		}		 else if (cls.equals(SendSMSV2Request.class)) {
			SendSMSV2RequestSerializer.AppendChildElement(doc, (SendSMSV2Request) obj, parentElement);
		}		 else if (cls.equals(AddWorkPlanRequest.class)) {
			AddWorkPlanRequestSerializer.AppendChildElement(doc, (AddWorkPlanRequest) obj, parentElement);
		}		 else if (cls.equals(DeleteWorkPlanRequest.class)) {
			DeleteWorkPlanRequestSerializer.AppendChildElement(doc, (DeleteWorkPlanRequest) obj, parentElement);
		}		 else if (cls.equals(GetWorkPlanRequest.class)) {
			GetWorkPlanRequestSerializer.AppendChildElement(doc, (GetWorkPlanRequest) obj, parentElement);
		}		 else if (cls.equals(QueryUserRolesRequest.class)) {
			QueryUserRolesRequestSerializer.AppendChildElement(doc, (QueryUserRolesRequest) obj, parentElement);
		}		 else if (cls.equals(QueryWorkPlanTableRequest.class)) {
			QueryWorkPlanTableRequestSerializer.AppendChildElement(doc, (QueryWorkPlanTableRequest) obj, parentElement);
		}		 else if (cls.equals(QueryWorkPlanTypeRequest.class)) {
			QueryWorkPlanTypeRequestSerializer.AppendChildElement(doc, (QueryWorkPlanTypeRequest) obj, parentElement);
		}		 else if (cls.equals(SubmitWorkPlanRequest.class)) {
			SubmitWorkPlanRequestSerializer.AppendChildElement(doc, (SubmitWorkPlanRequest) obj, parentElement);
		}		 else if (cls.equals(UpdateWorkPlanRequest.class)) {
			UpdateWorkPlanRequestSerializer.AppendChildElement(doc, (UpdateWorkPlanRequest) obj, parentElement);
		}
	}

}