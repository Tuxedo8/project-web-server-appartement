<#ftl encoding="utf-8">
<html>
<head>
	<link rel="stylesheet" type="text/css" href="/style.css">
	<title>Détail Appartement</title>
</head>
<body>

	<a href="/" class="btn">ACCUEIL</a>

    <h2>Ajouter un Appartement</h2>
	
    	<form action="/addAppartement" method="post">
			
		<label for="etage">Etage :</label><br>
		<input type="number" id="etage" name="etage" required><br><br>

		<label for="numero">Numero :</label><br>
		<input type="number" id="numero" name="numero" required><br>
		
		<label for="superficie">Superficie :</label><br>
		<input type="number" id="superficie" name="superficie" required><br>
		
		<input type="submit" value="Ajouter">
	</form>
	

    <h2>Tous les Appartements</h2>
	<table>
	    <thead>
		<tr>
		    <th>Adresse</th>
		    <th>Etage</th>
		    <th>Numero</th>
		    <th>Superficie</th>
		    <th>Est Loue</th>
		    <th> </th>
		    <th> </th>
		</tr>
	    </thead>
	    <tbody>
		<#list appartement as appart>
		    <tr>
			<td>${appart.adresse}</td>
			<td>${appart.etage}</td>
			<td>N°${appart.numero}</td>
			<td>${appart.superficie} m²</td>
		 	<#if appart.estLoue>
				<td>OUI</td>
			<#else>
			    <td>NON</td>
			</#if>
			<td><a href="/SeePersonne?adresse=${appart.adresse}&numero=${appart.numero}&etage=${appart.etage}" class="btn">Voir les Personnes de cet Appartement</a></td>

			<td><a href="/delAppartement?adresse=${appart.adresse}&numero=${appart.numero}&etage=${appart.etage}" class="btn" style="background-color:red; color:white;">Supprimer</a></td>

		    </tr>
		</#list>
	    </tbody>
	</table>
</body>
</html>

