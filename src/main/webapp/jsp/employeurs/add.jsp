
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ajouter un employeur </title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">

</head>
<body>
<div class="container">
  <h1>Ajouter un nouveau employeur</h1>
  <form action="${pageContext.request.contextPath}/employeurs/add" method="post">
    <label>Raison sociale:</label>
    <input type="text" name="raisonSociale"required>
    <label>Secteur d'activité:</label>
    <input type="text" name="secteurActivite"required>
    <button type="submit" class="btn">Ajouter</button>
  </form>
  <a href="${pageContext.request.contextPath}/employeurs/list" class="btn">Retour</a>
</div>
</body>
</html>
