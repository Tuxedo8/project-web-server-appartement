<#ftl encoding="utf-8">
<html>
<head>
    <link rel="stylesheet" type="text/css" href="/style.css">
    <title>Ajouter un utilisateur</title>
</head>
<body>

	<a href="/" class="btn">ACCUEIL</a>

	    <h2>Ajouter un utilisateur</h2>
	    <form action="/addUser" method="post">
		<label for="firstName">Prénom :</label><br>
		<input type="text" id="firstName" name="firstName" required><br>
		
		<label for="lastName">Nom :</label><br>
		<input type="text" id="lastName" name="lastName" required><br><br>
		
		<input type="submit" value="Ajouter">
		</form>
	    <h2>Tous les utilisateurs</h2>
    <!-- pour u.id u.Nom etc, ignoré la première majuscule mais pas les autre -->
	  <table>
	    <thead>
		<tr>
		    <th>ID</th>
		    <th>Prénom</th>
		    <th>Nom</th>
		    <th> </th>
		</tr>
	    </thead>
	    <tbody>
		<#list user as u>
		    <tr>
			<td>${u.id}</td>
			<td>${u.firstName}</td>
			<td>${u.lastName}</td>
			<td><a href="/delUser?id=${u.id}" id="del_${u.id}" class="btn" style="background-color:red; color:white;">Supprimer</a></td>

		    </tr>
		</#list>
	    </tbody>
	</table>
</body>
</html>

