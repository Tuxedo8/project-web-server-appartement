<#ftl encoding="utf-8">
<html>
<head>

    <link rel="stylesheet" type="text/css" href="/style.css">
    <title>Toutes les Personnes</title>
</head>
<body>

	<a href="/" class="btn">ACCUEIL</a>

    	<h2> Toutes les Personnes<h2>
    	<table>
		    <thead>
			<tr>	
			    <th>Adresse Appartement</th>
			    <th>Etage</th>
			    <th>Numero</th>
			    <th>Nom Personne</th>
			    <th>Prénom Personne</th>
			    <th>Téléphone</th>
			    <th>Propriétaire</th>
			    
			    <th> </th>
			    <th> </th>

			</tr>
		</thead>
			<tbody>
				<#list personne as perso>
				    <tr>
					    <td>${perso.adresse}</td>
					    <td>${perso.etage}</td>
					    <td>N°${perso.numero}</td>
					    <td>${perso.nom}</td>
					    <td>${perso.prenom}</td>
					    <td>${perso.telephone}</td> 
					    <#if perso.proprietaire>
					    <td>OUI</td>
					    <#else>
					    <td>NON</td>
					    </#if>

					    <td><a href="/SeePersonne?adresse=${perso.adresse}&numero=${perso.numero}&etage=${perso.etage}" class="btn">Voir les Personnes de cet Appartement</a></td>
				    </tr>
				</#list>
		</tbody>
	</table>
</body>

</html>
