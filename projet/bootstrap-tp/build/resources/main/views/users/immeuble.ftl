<#ftl encoding="utf-8">
<html>
<head>
	<link rel="stylesheet" type="text/css" href="/style.css">
	<title>Tout les Immeubles</title>
</head>
<body>
	
	<a href="/" class="btn">ACCUEIL</a>

	<h2>Ajouter un Immeuble</h2>
	    <form action="/addImmeuble" method="post">
		<label for="nom">Nom :</label><br>
		<input type="text" id="nom" name="nom" required><br>

		<label for="adresse">Adresse de l'Immeuble :</label><br>
		<input type="text" id="adresse" name="adresse" required><br>
		
		<label for="nom_syndicat">Nom du Syndicat de l'Immeuble :</label><br>
		<select id="nom_syndicat" name="nom_syndicat">
		<#list nom_syndicat as nsyndic>
			<option value="${nsyndic}">${nsyndic}</option>
		</#list>
		</select>
		<input type="submit" value="Ajouter">
	    </form>

	<h2>Tout les Immeubles<h2>
	<table>
		    <thead>
			<tr>
			    <th>Nom</th>
			    <th>Adresse</th>
			    <th>Nom du Syndicat</th>
			    <th>Pourcentage de Logement Loué</th>
			    <th> </th>
			    <th> </th>
			</tr>
		    </thead>
		    <tbody>
			<#list immeuble as im >
			    <tr>
				<td>${im.nom}</td>
				<td>${im.adresse}</td>
				<td>${im.nom_Syndicat}</td>
				<td>${im.pourcentageEstLoue}%</td>
				<td><a href="/SeeAppartement?adresse=${im.adresse}" id="see_${im.adresse}" class="btn">Voir les Appartements</a></td>
				<td><a href="/delImmeuble?adresse=${im.adresse}" id="del_${im.adresse}" class="btn" style="background-color:red; color:white;">Supprimer</a></td>

			    </tr>
			</#list>
		    </tbody>
		</table>

</body>
</html>

