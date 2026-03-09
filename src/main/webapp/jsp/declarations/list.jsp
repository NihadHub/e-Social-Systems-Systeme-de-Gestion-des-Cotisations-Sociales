<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Liste des Déclarations</title>
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
<div class="container">

    <h1>Liste des Déclarations</h1>

    <a href="${pageContext.request.contextPath}/declarations/add"
       class="btn">
        Nouvelle Déclaration
    </a>

    <br><br>

    <!-- Message success ou erreur -->
    <c:if test="${not empty message}">
        <p><strong>${message}</strong></p>
    </c:if>

    <c:if test="${empty declarations}">
        <p>Aucune déclaration trouvée.</p>
    </c:if>

    <c:if test="${not empty declarations}">
        <table>
            <thead>
            <tr>
                <th>ID</th>
                <th>Employeur</th>
                <th>Mois</th>
                <th>Année</th>
                <th>Date Déclaration</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="d" items="${declarations}">
                <tr>
                    <td>${d.id}</td>
                    <td>${d.employeur.raisonSociale}</td>
                    <td>${d.mois}</td>
                    <td>${d.annee}</td>
                    <td>${d.dateDeclaration}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>

    <br>

    <a href="${pageContext.request.contextPath}/" class="btn">
        Menu principal
    </a>

</div>
</body>
</html>