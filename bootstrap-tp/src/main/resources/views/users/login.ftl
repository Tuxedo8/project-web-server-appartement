<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Log In</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="/style.css">

</head>
<body>
	<div class="container">
	   
	    <a href="/signin">Inscription</a>
	    
	    <h2>LOG IN</h2>
	    <form action="/login" method="post">
		<label for="firstName">Prénom :</label><br>
		<input type="text" id="firstname" name="firstName" required><br>
		
		<label for="lastName">Nom :</label><br>
		<input type="text" id="lastname" name="lastName" required><br><br>
		
		<input type="submit" value="Connexion">
	    </form>
	</div>
</body>
</html>
