<%@ include file="init.jsp" %>
<%
	Event event = (Event) request.getAttribute("event");
%>
<liferay-portlet:actionURL name="saveEvent" var="formActionURL" />

<h2>
	<c:choose>
		<c:when test="<%= event != null %>">
			<liferay-ui:message key="edit-event" />
		</c:when>
		<c:otherwise>
			<liferay-ui:message key="add-event" />
		</c:otherwise>
	</c:choose>
</h2>

<aui:form action="<%= formActionURL %>" method="post">

	<c:if test="<%= event != null %>">
		<aui:input type="hidden" name="id" value="<%= event.getId() %>" />
	</c:if>
	
	<aui:field-wrapper label="title" required="true">
		<liferay-ui:input-localized 
			name="title" 
			xml="<%= (event != null)? event.getTitle() : StringPool.BLANK %>" 
		/>
	</aui:field-wrapper>
	
	<aui:field-wrapper label="location" required="true">
		<liferay-ui:input-localized 
			name="location" 
			xml="<%= (event != null)? event.getLocation() : StringPool.BLANK %>" 
		/>
	</aui:field-wrapper>
	
	<aui:field-wrapper label="address">
		<liferay-ui:input-localized 
			name="address" 
			xml="<%= (event != null)? event.getAddress() : StringPool.BLANK %>" 
		/>
	</aui:field-wrapper>
	
	<aui:input 
		name="coord-x" 
		type="text" 
		value="<%= (event != null)? event.getCoordX() : StringPool.BLANK %>"
	/>
	
	<aui:input 
		name="coord-y" 
		type="text" 
		value="<%= (event != null)? event.getCoordY() : StringPool.BLANK %>"
	/>
	
	<aui:field-wrapper label="description" required="true">
		<liferay-ui:input-localized 
			name="description" 
			xml="<%= (event != null)? event.getDescription() : StringPool.BLANK %>" 
			type="editor" 
		/>
	</aui:field-wrapper>
	
	<aui:input 
		name="requires-approval" 
		type="checkbox" 
		value="<%= (event != null)? event.getRequiresApproval() : false %>"
	/>
	
	<c:if test="<%= event == null || event.getStatus() == WorkflowConstants.STATUS_DRAFT %>">
		<aui:button type="submit" name="save" value="save-draft" ></aui:button>
	</c:if>
	<aui:button type="submit" name="save" value="publish"></aui:button>

</aui:form>