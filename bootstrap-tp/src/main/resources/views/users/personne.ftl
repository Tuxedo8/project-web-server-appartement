<#ftl encoding="utf-8">
<html>
<head>

    <link rel="stylesheet" type="text/css" href="/style.css">
    <title>Detail Personne</title>
</head>
<body>

	<a href="/" class="btn">ACCUEIL</a>


 
	<h2>Ajouter une Personne</h2>
    <form action="/addPersonne" method="post">
        <label for="nom">Nom :</label><br>
        <input type="text" id="nom" name="nom" required><br>

        <label for="prenom">Prénom :</label><br>
        <input type="text" id="prenom" name="prenom" required><br>
        
	<label for="telpehone">Téléphone :</label><br>
        <input type="text" id="telephone" name="telephone" required><br><br>
	
	<label for="choix">Est Propriétaire :</label>
        <input type="hidden" id="choix" name="choix" value="false">
        <br>
        <button type="button" onclick="setChoice(true)">Oui</button>
        <button type="button" onclick="setChoice(false)">Non</button>
        <br>
	<input type="submit" value="Ajouter">

</form>
	<script>
        function setChoice(value) {
            document.getElementById('choix').value = value.toString();
        }
    </script>
    	<table>
		    <thead>
			<tr>
			    <th>Nom</th>
			    <th>Prénom</th>
			    <th>Téléphone</th>
			    <th>Propriétaire</th>
			    <th> </th>

			    </tr>
			    </thead>
			    <tbody>
			    <#list personne as perso>
			    <tr>
			    <td>${perso.nom}</td>
			    <td>${perso.prenom}</td>
			    <td>${perso.telephone}</td> 
			    <#if perso.proprietaire>
			    <td>OUI</td>
			    <#else>
			    <td>NON</td>
			    </#if>
			    <td><a href="/delPersonne?nom=${perso.nom}&prenom=${perso.prenom}&telephone=${perso.telephone}&adresse=${perso.adresse}&numero=${perso.numero}&etage=${perso.etage}" id="del_${perso.nom}" class="btn" style="background-color:red; color:white;">Supprimer</a></td>
			</tr>
			</#list>
		    </tbody>
		</table>

</body>

</html>
