<%@page import="com.liferay.portal.kernel.util.ListUtil" %>
<%@page import="edu.uoc.eventreg.service.AttendeeLocalServiceUtil" %>
<%@ page import="edu.uoc.eventreg.portlet.search.AttendeeDisplayTerms" %>
<%@ include file="init.jsp" %>
<% 
	long companyId = (Long) request.getAttribute("companyId");
	long groupId = (Long) request.getAttribute("groupId");
	Locale locale = request.getLocale();
	
	String currentURL = PortalUtil.getCurrentURL(request);
	String name = ParamUtil.getString(request, "name");
	String surname = ParamUtil.getString(request, "surname");
	String email = ParamUtil.getString(request, "email");
	int status = ParamUtil.getInteger(request, "status");
%>

<liferay-portlet:renderURL varImpl="iteratorURL">
	<portlet:param name="name" value="<%= name %>" />
	<portlet:param name="surname" value="<%= surname %>" />
	<portlet:param name="email" value="<%= email %>" />
	<portlet:param name="status" value="<%= String.valueOf(status) %>" />
</liferay-portlet:renderURL>

<liferay-ui:search-container 
	emptyResultsMessage="there-are-no-registrations" 
	displayTerms="<%= new AttendeeDisplayTerms(renderRequest) %>" 
	iteratorURL="<%= iteratorURL %>">

	<aui:nav-bar>
		<aui:nav collapsible="<%= false %>" cssClass="nav-display-style-buttons pull-right" id="displayStyleButtons">
			<aui:nav-item>
				<span class="pull-left display-style-buttons-container" id="<portlet:namespace />displayStyleButtonsContainer">
					
				</span>
			</aui:nav-item>
		</aui:nav>
	
		<aui:nav id="toolbarContainer">
			<liferay-portlet:renderURL var="viewEventsURL" />
			<aui:nav-item href="<%= viewEventsURL %>" iconCssClass="icon-th-list" label="view-events" />
		</aui:nav>
		
		<aui:nav-bar-search cssClass="pull-right">
			<liferay-ui:search-form servletContext="<%= this.getServletContext()%>"
				 page="/html/management/attendee_search.jsp" />
		</aui:nav-bar-search>
	</aui:nav-bar>

	<liferay-ui:search-container-results>
		<%
		AttendeeDisplayTerms displayTerms = (AttendeeDisplayTerms) searchContainer.getDisplayTerms();
		if (displayTerms.isAdvancedSearch()) {
			total = AttendeeLocalServiceUtil.searchAttendeeCount(companyId, groupId, name, surname, email, status, displayTerms.isAndOperator());
			results = AttendeeLocalServiceUtil.searchAttendees(companyId, groupId, name, surname, email, status, displayTerms.isAndOperator(), searchContainer.getStart(), searchContainer.getEnd());
		} else {
			String searchkeywords = displayTerms.getKeywords().trim();
			
			if (searchkeywords.isEmpty()) {
				results = AttendeeLocalServiceUtil.findGroupAttendees(companyId, groupId);
				total = results.size();
				results = ListUtil.subList(results, searchContainer.getStart(), searchContainer.getEnd());
			} else {
				total = AttendeeLocalServiceUtil.searchAttendeeCount(companyId, groupId, searchkeywords, searchkeywords, searchkeywords, 0, false);
				results = AttendeeLocalServiceUtil.searchAttendees(companyId, groupId, searchkeywords, searchkeywords, searchkeywords, 0, false, searchContainer.getStart(), searchContainer.getEnd());
			}
		}
		
		searchContainer.setTotal(total);
		searchContainer.setResults(results);
		
		%>
	</liferay-ui:search-container-results>
		
		<liferay-ui:search-container-row
			className="edu.uoc.eventreg.model.Attendee"
			modelVar="user"
		>
					
			<liferay-ui:search-container-column-text
				name="name"
				value="<%= user.getName() %>"
			/>
			
			<liferay-ui:search-container-column-date
				name="registration-date"
				value="<%= user.getRegisterDate() %>"
			/>
			
			<liferay-ui:search-container-column-text
				name="status"
				value="<%= WorkflowConstants.getStatusLabel(user.getStatus()) %>"
			/>
						
			<!-- <liferay-ui:search-container-column-jsp 
				path="/html/management/event_action.jsp" 
			/> -->
			
		</liferay-ui:search-container-row>

	<liferay-ui:search-iterator paginate="<%= true %>" />

</liferay-ui:search-container>
