<%@ page import="java.util.List"%>
<%@ page import="dev.sgp.entite.Collaborateur"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="<%=request.getContextPath()%>/bootstrap/css/bootstrap.css">
		<title>SGP - App</title>
	</head>
	
	<body>
		<h1>Les collaborateurs sont sympas</h1>

		<ul>
			<%
				List<String> listeNomsArray = (List<String>)request.getAttribute("listeNomsArray");
				for (String nom : listeNomsArray) {
			%>
			
			<li><a href="#" class="btn btn-default"> <%= nom %> </a></li>
			
			<%
				}
			%>
		</ul>
		
		<h1>Autre collaborateurs</h1>

		<table class="table">
			<thead>
				<tr>
					<th> <strong> Nom </strong> </th>
					<th> <strong> Prenom </strong> </th>
					<th> <strong> Email </strong> </th>
					<th> <strong> Matricule </strong> </th>
					<th> <strong> Numéro de Sécurité Sociale </strong> </th>
					<th> <strong> Date de Naissance </strong> </th>
					<th> <strong> Date de création </strong> </th>
				</tr>
			</thead>
			<%
				List<Collaborateur> listeNomsService = (List<Collaborateur>)request.getAttribute("listeNomsService");
				for (Collaborateur collab : listeNomsService) {
			%>
			
			<tr>
				<td> <%= collab.getNom() %> </td>
				<td> <%= collab.getPrenom() %> </td>
				<td> <%= collab.getEmailPro()%> </td>
				<td> <%= collab.getMatricule() %> </td>
				<td> <%= collab.getNumSecu() %> </td>
				<td> <%= collab.getDateDeNaissance() %> </td>
				<td> <%= collab.getDateHeureCreation() %> </td>
			</tr>
			
			<%
				}
			%>
		</table>
		
	</body>

</html>