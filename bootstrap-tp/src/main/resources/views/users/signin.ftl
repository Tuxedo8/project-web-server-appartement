<#ftl encoding="utf-8">
<html>
<head>
    <link rel="stylesheet" type="text/css" href="/style.css">
    <title>Inscription</title>
</head>
<body>

	<div class="container">
		<h2>Inscription</h2>

		<form action="/addUser" method="post">
		<label for="firstName">Prénom :</label><br>
		<input type="text" id="firstName" name="firstName" required><br>

		<label for="lastName">Nom :</label><br>
		<input type="text" id="lastName" name="lastName" required><br><br>

		<input type="submit" value="Ajouter">
		</form>
	</div>
  </body>
</html>

