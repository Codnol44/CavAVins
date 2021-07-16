<%@ page import="fr.eni.bo.Bouteille" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Choix</title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/style.css" />
</head>
<body>

<p class="res">SAISIE DES INFORMATIONS RELATIVES A VOTRE GRAND CRU</p>

<div class="fond">
    <div class="col">
        <form action="http://localhost:8080/CavAVins_war_exploded/choixS" method="post">
            <label for="region">Région : </label><textarea name="region" id="region" cols="30" rows="2" required></textarea>
            <label for="appellation">Appellation : </label><textarea name="appellation" id="appellation" cols="30" rows="2" required></textarea>
            <label for="domaine">Domaine : </label><textarea name="domaine" id="domaine" cols="30" rows="2" required></textarea>
            <label for="annee">Annee : </label><textarea name="annee" id="annee" cols="30" rows="2" required></textarea>
            <label for="prix">Prix : </label><textarea name="prix" id="prix" cols="30" rows="2" required></textarea>
        <input type="submit" value="Ajouter">
        </form>

        <div><%
            String ajout = (String) request.getAttribute("ajout");
            if (ajout != null) {
                out.print("<div>" + ajout + "</div>");
            }
        %></div>

        <form action="http://localhost:8080/CavAVins_war_exploded/historiqueS" method="get">
            <button class="btn" type="submit">Voir l'historique</button>
        </form>
    </div>
</div>

</p>

</body>
</html>
