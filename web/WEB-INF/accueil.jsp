<%@ page import="fr.eni.bo.Bouteille" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Accueil</title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/style.css" />
</head>
<body>

<p class="res">BIENVENUE DANS VOTRE CAVE PERSONNELLE</p>

<div class="fond">
  <div>
    <form method="post" action="http://localhost:8080/CavAVins_war_exploded/accueilS">
      <div>
        <span class="input-group-text" >Identifiant : <sup class="text-danger">* </sup></span>
        <input type="text" class="form-control" placeholder="pseudo" name="login" required>
      </div>

      <div>
        <span class="input-group-text" >Mot de passe : <sup class="text-danger">* </sup></span>
        <input type="password" class="form-control" placeholder="mot de passe" name="mdp" required >
      </div>
      <button class="btn2" type="submit">Valider</button>
    </form>
  </div>

    <div class="fond"><%
      String message = (String) request.getAttribute("message");
      if (message != null) {
        out.print("<div>" + message + "</div>");
      }
    %></div>

</div>
</body>
</html>
