<%@ include file="/html/cacheportlet/init.jsp" %>
<portlet:actionURL name="removeKey" var="removeKeyURL">
	<portlet:param name="key" value="${SEARCH_CONTAINER_RESULT_ROW.object.key}" />
</portlet:actionURL>
<liferay-ui:icon-menu>
	<liferay-ui:icon image="delete" url="${removeKeyURL}" />
</liferay-ui:icon-menu>
