<%@ include file="/html/cacheportlet/init.jsp" %>

<portlet:actionURL name="updateCache" var="updateCacheURL"/>
<portlet:actionURL name="flushCache" var="flushCacheURL"/>

<aui:form action="${updateCacheURL}" method="post" name="fm">
	<aui:row>
	<aui:column first="true" columnWidth="50">
	<aui:input name="key" type="text" required="true"/>
	</aui:column>

	<aui:column columnWidth="50">
	<aui:input name="value" type="text" required="true" />
	</aui:column>
		
	</aui:row>
	<aui:row>
	<aui:column columnWidth="100">
	<aui:button type="submit" value="add-to-cache"/>
	<aui:button onClick="${flushCacheURL}" value="flush-cache"/>
	</aui:column>
	</aui:row>
</aui:form>
<aui:row>
<aui:column columnWidth="100">
<liferay-ui:search-container
		emptyResultsMessage="cache-is-empty">
	<liferay-ui:search-container-results
		results="${cacheItems}"
		total="${fn:length(cacheItems)}" />

	<liferay-ui:search-container-row className="com.sohlman.liferay.cachepoc.model.CacheItem" modelVar="cacheItem" keyProperty="key">
		<liferay-ui:search-container-column-text name="key"/>
		<liferay-ui:search-container-column-text name="value"/>
		<liferay-ui:search-container-column-jsp name="actions"
			align="right"
			path="/html/cacheportlet/actions.jsp"
		/>
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator />
</liferay-ui:search-container>
</aui:column>
</aui:row>