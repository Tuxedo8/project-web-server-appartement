<#ftl encoding="utf-8">
<html>
<head>
	<link rel="stylesheet" type="text/css" href="/style.css">
	<title>Tout les Appartements</title>
</head>
<body>
	
	<a href="/" class="btn">ACCUEIL</a>
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
		<#list allappartement as appart>
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
			<td><a href="/SeeAppartement?adresse=${appart.adresse}" id="see_${appart.adresse}" class="btn">Voir tous les Appartement à cette Adresse</a></td>

		</tr>
		</#list>
	    </tbody>
	</table>
</body>
</html>

