<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<script src="http://code.jquery.com/jquery-latest.js"></script>
<title>LAVATELASMANOS</title>

</head>
<body class="CUERPO">

<%
	HttpSession sesion = (HttpSession) request.getSession();
	String usuSession = String.valueOf(sesion.getAttribute("beneficiario"));
	String fullname = String.valueOf(sesion.getAttribute("fullname"));
	System.out.println("Beneficiario: " + usuSession);

	if (usuSession.equals(null) || usuSession.equals("null")) {
		response.sendRedirect("index.jsp");
	}
	%>
	
	
	<div class="PartSuperior">

	</div>
	<br>
	<br>
	<div class="Happy">
	</div>
	<br>
	
	<p class="mensaje">
		<strong> <%=fullname%>, eres beneficiario
			<br> de $300.00
		</strong>
	</p>
	
	<br>
	<form action="ControllerBeneficiario" method="post">
		<input type="submit" name="soybeneficiario" value="Volver a consultar"
			class="regresar">
	</form>

</body>
</html>