<%@ taglib prefix="c" uri="jakarta.tags.core" %><%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>List des employeurs</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
<div class="container">
    <h1>List des employeurs</h1>

    <a href="${pageContext.request.contextPath}/employeurs/add"
       class="btn">Ajouter employeur</a>

    <table>
        <thead>
        <tr>
            <th>ID</th>
            <th> Raison sociale</th>
            <th>Secteur d'Activité</th>
            <th>Procédures</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="emp" items="${employeurs}">
            <tr>
                <td>${emp.id}</td>
                <td>${emp.raisonSociale}</td>
                <td>${emp.secteurActivite}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/employeurs/detail?id=${emp.id}">
                         Détails
                    </a>
                    |
                    <a href="${pageContext.request.contextPath}/assures/byEmployeur?employeurId=${emp.id}">
                      Assurés
                    </a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <a href="${pageContext.request.contextPath}/" class="btn">Principale</a>
</div>
</body>
</html>
