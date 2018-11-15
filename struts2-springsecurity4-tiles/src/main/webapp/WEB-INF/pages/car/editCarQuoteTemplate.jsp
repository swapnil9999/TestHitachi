<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib uri="/struts-tags" prefix="s"%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.11.1/jquery.validate.min.js"></script>

<html>
<head>

<script type="text/javascript">

</script>
</head>
<body>

<s:form action="editCarQuoteSubmit"  name="editCarQuoteSubmitForm" method="post">
	<table>
		<tr>
			<td colspan="2">
				<s:textfield name="quoteNo" id="quoteNo" label="Quote No"></s:textfield>
            	<s:textfield name="carMake" id="carMake" label="Car make"></s:textfield>
				<s:textfield name="carModel" id="carModel" label="Car model"></s:textfield>
				<s:textfield name="yrsOfManufacture" id="yrsOfManufacture" label="Year of manufacture"></s:textfield>
				<s:textfield name="doors" id="doors" label="Doors"></s:textfield>
				<s:textfield name="fuelType" id="fuelType" label="Fuel type"></s:textfield>
				<s:textfield name="transmission" id="transmission" label="Transmission"></s:textfield>
				<s:textfield name="trim" id="trim" label="Trim"></s:textfield>
				<s:textfield name="quote" id="quote" label="Quote"></s:textfield>
				<s:hidden  value="%{id}" name="id" />
				<s:hidden  value="%{username}" name="createdBy" />
				
			<input type="hidden" name="${_csrf.parameterName}"  value="${_csrf.token}" />
		</td>
		</tr>
		<tr>
		<td align="Center">
		<s:submit></s:submit>
		
		</td>
		
		</tr>
		
	</table>
</s:form>
</body>
</html>

