<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="<%=request.getContextPath()%>/bootstrap/css/bootstrap.css">
		<title>SGP - App</title>
	</head>
	
	<body>

		<form class="form-horizontal" Method="POST">
		<fieldset>

		<!-- Form Name -->
		<legend>Nouveau Collaborateur</legend>
		
		<!-- Text input-->
		<div class="form-group">
		  <label class="col-md-4 control-label" for="textInputNom">Nom</label>  
		  <div class="col-md-4">
		  <input id="textInputNom" name="textInputNom" type="text" placeholder="Entrez le nom" class="form-control input-md" required="">
		    
		  </div>
		</div>
		
		<!-- Text input-->
		<div class="form-group">
		  <label class="col-md-4 control-label" for="textInputPrenom">Prenom</label>  
		  <div class="col-md-4">
		  <input id="textInputPrenom" name="textInputPrenom" type="text" placeholder="Entrez le prenom" class="form-control input-md" required="">
		    
		  </div>
		</div>
		
		<!-- Text input-->
		<div class="form-group">
		  <label class="col-md-4 control-label" for="textInputDate">Date de naissance</label>  
		  <div class="col-md-4">
		  <input id="textInputDate" name="textInputDate" type="text" placeholder="Entrez la date" class="form-control input-md" required="">
		    
		  </div>
		</div>
		
		<!-- Textarea -->
		<div class="form-group">
		  <label class="col-md-4 control-label" for="textAreaAdresse">Adresse</label>
		  <div class="col-md-4">                     
		    <textarea class="form-control" id="textAreaAdresse" name="textAreaAdresse">Entrez l'adresse</textarea>
		  </div>
		</div>
		
		<!-- Text input-->
		<div class="form-group">
		  <label class="col-md-4 control-label" for="textInputIdSecu">Numéro de sécurité sociale</label>  
		  <div class="col-md-4">
		  <input id="textInputIdSecu" name="textInputIdSecu" type="text" placeholder="Entrez le numéro" class="form-control input-md" required="" maxlength="15">
		    
		  </div>
		</div>
		
		<!-- Button -->
		<div class="form-group">
		  <label class="col-md-4 control-label" for="buttonFormCollaborateur"></label>
		  <div class="col-md-4">
		    <button id="buttonFormCollaborateur" name="buttonFormCollaborateur" class="btn btn-primary">Valider</button>
		  </div>
		</div>
		
		</fieldset>
		</form>

</body>

</html>