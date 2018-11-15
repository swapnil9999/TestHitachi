
    <%@include file="/WEB-INF/pages/includedTags.jsp"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Your Qoute has been Saved Successfully. </h2>
			 <input type="hidden" name="${_csrf.parameterName}"  value="${_csrf.token}" />

</body>
</html>