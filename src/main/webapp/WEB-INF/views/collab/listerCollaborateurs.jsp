<%@ page import="java.util.List"%>
<%@ page import="dev.sgp.entite.Collaborateur"%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="<%=request.getContextPath()%>/bootstrap/css/bootstrap.css">
		<title>SGP - App</title>
	</head>
	
	<body>
		
		<h1>Les collaborateurs sont sympas</h1>

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
			
			<c:forEach var="collab" items="${listeNomsService}">
			
			<tr>
				<td> ${ collab.nom } </td>
				<td> ${ collab.prenom } </td>
				<td> ${ collab.emailPro } </td>
				<td> ${ collab.matricule } </td>
				<td> ${ collab.numSecu } </td>
				<td> ${ collab.dateDeNaissance } </td>
				<td> ${ collab.dateHeureCreation} </td>
				<td> <a Method="POST" class="btn btn-primary" 
					href="<%=request.getContextPath()%>/collaborateurs/editer?
					nom=${collab.nom}&
					prenom=${collab.prenom}&
					numSecu=${collab.numSecu}&
					adresse=${ collab.adresse }&
					dateDeNaissance=${collab.dateDeNaissance}&"> Editer </a> </td>
			</tr>
			
			</c:forEach>
			
		</table>
		
	</body>

</html>