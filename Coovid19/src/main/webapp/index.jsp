<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<title>DISTANCIA</title>

<link
	href="https://fonts.googleapis.com/css2?family=Montserrat:wght@300&display=swap"
	rel="stylesheet">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6"
	crossorigin="anonymous">
</head>

<body class="bbody">
	<div class="PartSuperior">
		
	</div>
	<br>
	<br>
	<br>
	
	
	<p class="pintro">
		<strong> Hola! y bienvenid@ descubre si estas en la lista de
			apoyo económico 
		</strong>
	</p>
	
	
	<p class="pcovid">
		<strong> COVID-19 </strong>
	</p>
	
	
	<br>
	<br>
	
	
	<form action="ControllerBeneficiario" method="post">
		<input type="text" name="dui"
			placeholder="Ingresa tú número de DUI 00000000-0" class="field"
			required> <input type="submit" value="CONSULTAR"
			class="consultar">
	</form>
	
	
	<br>
	<br>
	<br>
	
	
	<p class="poutro">
		<strong> Esperamos de verdad que puedas estar en dicha lista, si no lo estas no te preocupes
		puedes llamar al 354543 y <br>con gusto veremos como te ayudamos 
		</strong>
	</p>
	
	
</body>

</html>