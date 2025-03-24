<#ftl encoding="utf-8">
<html>
<head>

    <link rel="stylesheet" type="text/css" href="/style.css">
    <title>Accueil</title>
</head>
<body>

	<div class="container">
		<h2>Espace Personnel :</h2>
		<h1>${user.firstName} ${user.lastName}</h1>
		<a href="/user">User</a>
		<a href="/immeuble">Immeuble</a>
		<a href="/appartement">Appartement</a>
		<a href="/personne">Personne</a>
		<a href="/syndicat">Syndicat</a>
		<a href="/logout" style="background-color:red">Déconnexion</a>
	</div>
	

</body>

</html>
