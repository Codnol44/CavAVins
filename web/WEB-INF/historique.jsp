<%@ page import="fr.eni.bo.Bouteille" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Historique</title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/style.css" />
</head>

<body>

    <div class="res">VOICI LA LISTE DE VOS GRANDS CRUS : </div></br>
    <div class="row">
        <div class="col">
            <form action="http://localhost:8080/CavAVins_war_exploded/choixS" method="get">
                <button class="btn" type="submit">Ajouter une nouvelle bouteille</button>
            </form>
        </div>
    </div>

    <div id="look">
    <%
        List<Bouteille> listeBout = (List<Bouteille>) request.getAttribute("listeBouteille");
        for (Bouteille item : listeBout) {
            out.print("<b><div>Région : " + item.getRegion() + "<div> Appellation : " + item.getDomaine() + "<div> -  Domaine : " + item.getAppellation() + "<div>  - Année :  " + item.getAnnee() + "<div>   - Au tarif de  : " + item.getPrix() + " Euros.</div></br></b>");
        }
    %>
    </div>

    <div class="row">
        <div class="col">
            <form action="http://localhost:8080/CavAVins_war_exploded/historiqueS" method="post">
                <input type="text" name="region"  class="form-control" id="text" placeholder="Région ?"/>
                <button class="btn" type="submit">Saisissez un nom de région de bouteilles à retirer de la liste</button>
            </form>
        </div>
    </div>

</body>
</html>
