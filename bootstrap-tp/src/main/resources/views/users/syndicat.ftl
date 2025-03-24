<#ftl encoding="utf-8">
<html>
<head>
    <link rel="stylesheet" type="text/css" href="/style.css">
    <title>Ajouter un syndicat</title>
</head>
<body>
	<a href="/" class="btn">ACCUEIL</a>

	    <h2>Ajouter un syndicat</h2>
	    <form action="/addSyndicat" method="post">
		<label for="nom">Nom :</label><br>
		<input type="text" id="nom" name="nom" required><br>

		<label for="telephone">Téléphone :</label><br>
		<input type="text" id="telephone" name="telephone" required><br>
		
		<label for="adresse">Adresse du Syndicat :</label><br>
		<input type="text" id="adresse" name="adresse" required><br><br>
		
		<label for="mail">Mail du Syndicat :</label><br>
		<input type="text" id="mail" name="mail" required><br><br>
		
		<label for="nom_referent">Nom du Référent du Syndicat :</label><br>
		<input type="text" id="nom_referent" name="nom_referent" required><br><br>


		<input type="submit" value="Ajouter">
	    </form>



    <h2>Tous les syndicats</h2>
    <ul>
        
    <!-- pour u.id u.Nom etc, ignoré la première majuscule mais pas les autre des ATTRIBUTS ENTITY -->
    </ul>
	<table>
	    <thead>
		<tr>
		    <th>Nom</th>
		    <th>Nom du Referent</th>
		    <th>Adresse</th>
		    <th>Telephone</th>
		    <th>Mail</th>
		    <th> </th>
		</tr>
	    </thead>
	    <tbody>
		<#list syndicat as syndic>
		    <tr>
			<td>${syndic.nom}</td>
			<td>${syndic.nom_Referent}</td>
			<td>${syndic.adresse}</td>
			<td>${syndic.telephone}</td>
			<td>${syndic.mail}</td>
			<td><a href="/delSyndicat?nom=${syndic.nom}" id="del_${syndic.nom}" class="btn" style="background-color:red; color:white;">Supprimer</a></td>
		</tr>
		</#list>
	    </tbody>
	</table>

</body>
</html>
