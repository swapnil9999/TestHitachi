<%@include file="/WEB-INF/pages/includedTags.jsp" %>
<html>
<head>
<style type="text/css">
.menu {
	text-align: center;
	background-color:#c1baa4;
	
/* 	background-color: #dac584;
 */	min-height: 300px;
}

.menu a {
	font-weight: bold;

display:block;
	color: black;
	text-decoration: none;
	padding: 5px;
}

.menu a:hover {
 	background-color: #71afa8;
 }


</style>
</head>
<body>
	
<div class="menu" >


<sec:authorize access="hasAnyRole('ROLE_USER')">
<a href="createCarQuote">Create Car Quotation</a>
</sec:authorize>


<sec:authorize access="hasAnyRole('ROLE_ADMIN','ROLE_USER')">
<a href="editCarQuote">Edit Car Quotation</a>
</sec:authorize>

<%-- <sec:authorize access="hasRole('ROLE_ADMIN')">
<a href="searchCarQuote">Search Car Quotation</a>
</sec:authorize> --%>

<sec:authorize access="hasAnyRole('ROLE_ADMIN','ROLE_USER')">
<a href="https://www.hitachicapitalcontrol.co.uk/cc/bs/login.action">Customer Login</a>
</sec:authorize>


<sec:authorize access="hasAnyRole('ROLE_ADMIN','ROLE_USER')">
<a href="https://www.hitachicapitalvehiclesolutions.co.uk/from-the-experts">Blog</a>
</sec:authorize>

<sec:authorize access="hasAnyRole('ROLE_ADMIN','ROLE_USER')">
<a href="https://www.hitachicapitalvehiclesolutions.co.uk/contact-us">Contact Us</a>
</sec:authorize>

<c:url var="logoutUrl" value="/j_spring_security_logout" />
<form action="${logoutUrl}" id="logout" method="post">
    <input type="hidden" name="${_csrf.parameterName}"
           value="${_csrf.token}" />
</form>
<a href="#" onclick="document.getElementById('logout').submit();">Logout</a>

</div>
</body>
</html>