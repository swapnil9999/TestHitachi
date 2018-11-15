<%@include file="/WEB-INF/pages/includedTags.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib uri="/struts-tags" prefix="s"%>

<html>
<head></head>
<body>
<form action="editCarQuoteAction" method="post">
<table>

<%-- 	<s:textfield name="quoteNo" id="quoteNo" label="Quote No" required="required"> </s:textfield>
 --%>	<s:select label="Quote No." headerKey="-1" headerValue="Select Quote No." list="quoteNo" name="quoteNo" value="defaulQuoteNo" required="required" />	
	
	<input type="hidden" name="${_csrf.parameterName}"  value="${_csrf.token}" />
	<s:submit></s:submit>


</table>
</form>
</body>
</html>