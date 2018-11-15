<%@include file="/WEB-INF/pages/includedTags.jsp"%>
<html>
<head>
<title>Login</title>
<style type="text/css">
.loginForm {
	text-align: center;
}

.loginTable {
	margin-top: 100px;
	text-align: center;
	background-color:#c1baa4;
	height: 200px;
	padding: 15px;
	border-radius: 4px;
}

.loginTable input {
	margin-bottom: 15px;
}
</style>

<script type="text/javascript">
        	
        function validateLogin(){
        	
        	/*  $.ajax({
        	       type: 'POST',
        	       url:'search.action?searchText='+ $("#searchValue").val()+'&environment='+$("#environmentSelect").val(),
        	       dataType: 'json',
        	       success: function(data){
        	             console.log(stringify(data));
        	        }}); */
        	
        	
        	var name=document.loginForm.username.value;  
        	var password=document.loginForm.password.value;    
        	
        	if (name==null || name==""){ 
        		alert("Username can't be blank");
        		return false;
        	}else if(password==null || password==""){
        		alert("Password can't be blank");
        		return false;
			}
        	
        	return true;
        	
        }
        	</script>

</head>
<body>


	<div class="loginForm">

		<table class="loginTable" border="0" cellpadding="0" cellspacing="0"
			align="center">
			<tr>
				<td><h2>Login</h2></td>
			</tr>

			<tr>
				<td><c:url var="loginUrl" value="/login" />
					<form action="${loginUrl}" method="post" name="loginForm"
						onsubmit="return validateLogin()">
						<input type="text" name="username" placeholder="Username" /><br />
						<input type="password" name="password" placeholder="Password" /><br />
						<input type="hidden" name="${_csrf.parameterName}"
							value="${_csrf.token}" />
						<button type="submit">Submit</button>
					</form></td>
			</tr>
		</table>
	</div>
</body>
</html>