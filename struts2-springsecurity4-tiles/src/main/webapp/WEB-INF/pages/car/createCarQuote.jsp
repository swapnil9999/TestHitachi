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

<s:form action="createCarQuoteSubmit"  name="createCarQuoteForm"  method="post">

<h2>Welcome ${username}</h2>
	<table>
		<tr>
			<td colspan="2">
			<s:select label="Car Make." headerKey="" headerValue="Select Car Make" list="carMake" name="carMake" value="defaulCarMake" required="true" />	
			<s:select label="Car Model." headerKey="" headerValue="Select Car Model" list="carModel" name="carModel" value="defaulCarModel" required="true" />	
			<s:select label="Year of manufacture." headerKey="" headerValue="Select Year of manufacture" list="yrsOfManufacture" name="yrsOfManufacture" value="defaulYrOfManufacture" required="true" />	
			<s:select label="No of Doors." headerKey="" headerValue="Select Doors" list="doors" name="doors" value="defaulDoors" required="true" />	
			<s:select label="Fuel Type." headerKey="" headerValue="Select Fuel Type" list="fuelType" name="fuelType" value="defaulFuelType" required="true" />	
			<s:select label="Transmission." headerKey="" headerValue="Select Transmission" list="transmission" name="transmission" value="defaulTransMission" required="true" />	
			<s:select label="Trim." headerKey="" headerValue="Select Trim" list="trim" name="trim" value="defaulTrim" required="true"/>	
			<s:hidden  value="%{id}" name="id" />
			<s:hidden  value="%{username}" name="createdBy" />
			<input type="hidden" name="${_csrf.parameterName}"  value="${_csrf.token}" />
		</td>
		</tr>
		<tr align="Center">
		<td >
		<s:submit></s:submit>
		
		</td>
		
		</tr>
		
	</table>
</s:form>
</body>
</html>

