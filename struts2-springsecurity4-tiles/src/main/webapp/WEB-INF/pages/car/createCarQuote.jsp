<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib uri="/struts-tags" prefix="s"%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.11.1/jquery.validate.min.js"></script>

<html>
<head>

<script type="text/javascript">

function validateCreateQuoteForm(){
	
	alert(document.createCarQuoteForm.carMake.value);
	  
	
}

$(document).ready(function(){
	 var $regexname= /^[0-9]+$/;
  /*   $("#quoteNo").blur(function(){
    	
    	 if (!$(this).val().match($regexname)) {
             // there is a mismatch, hence show the error message
               alert('Please enter numeric values');
               $(this).val('');
            }
          else{
               // else, do not display message
              }    		 
    	
    }); */
    
    $("#quote").blur(function(){
    	
   	 if (!$(this).val().match($regexname)) {
            // there is a mismatch, hence show the error message
              alert('Please enter numeric values');
              $(this).val('');
           }
         else{
              // else, do not display message
             }    		 
   	
   });
});

</script>
</head>
<body>

<s:form action="createCarQuoteSubmit"  name="createCarQuoteForm"  method="post">

<h2>Welcome ${username}</h2>
	<table>
		<tr>
			<td colspan="2">
<%-- 				<s:textfield name="quoteNo" id="quoteNo" label="Quote No." required="required"></s:textfield>
 --%>            <%-- <s:textfield name="carMake" id="carMake" label="Car Make." required="required"></s:textfield>
				<s:textfield name="carModel" id="carModel" label="Car Model." required="required" ></s:textfield>
				<s:textfield name="yrsOfManufacture" id="yrsOfManufacture" label="Year of manufacture." required="required"></s:textfield> --%>
				
			<s:select label="Car Make." headerKey="" headerValue="Select Car Make" list="carMake" name="carMake" value="defaulCarMake" required="true" />	
			<s:select label="Car Model." headerKey="" headerValue="Select Car Model" list="carModel" name="carModel" value="defaulCarModel" required="true" />	
			<s:select label="Year of manufacture." headerKey="" headerValue="Select Year of manufacture" list="yrsOfManufacture" name="yrsOfManufacture" value="defaulYrOfManufacture" required="true" />	
			<s:select label="No of Doors." headerKey="" headerValue="Select Doors" list="doors" name="doors" value="defaulDoors" required="true" />	
			<s:select label="Fuel Type." headerKey="" headerValue="Select Fuel Type" list="fuelType" name="fuelType" value="defaulFuelType" required="true" />	
				
			<s:select label="Transmission." headerKey="" headerValue="Select Transmission" list="transmission" name="transmission" value="defaulTransMission" required="true" />	
			<s:select label="Trim." headerKey="" headerValue="Select Trim" list="trim" name="trim" value="defaulTrim" required="true"/>	
			<s:hidden  value="%{id}" name="id" />
			<s:hidden  value="%{username}" name="createdBy" />
			
			
			
			
							
			<%-- <s:textfield name="transmission" id="transmission" label="Transmission." required="required"></s:textfield>
			<s:textfield name="trim" id="trim" label="Trim." required="required"></s:textfield> --%>
<%-- 			<s:textfield name="quote" id="quote" label="Quote." required="required"></s:textfield>
 --%>				
				
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

