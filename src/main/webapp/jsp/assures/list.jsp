<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Liste des Assurés</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
<div class="container">
    <h1>Liste des Assurés</h1>

    <a href="${pageContext.request.contextPath}/assures/add" class="btn">
        Ajouter Assuré
    </a>

    <c:if test="${empty assures}">
        <p>Aucun assuré trouvé.</p>
    </c:if>

    <c:if test="${not empty assures}">
        <table>
            <thead>
            <tr>
                <th>ID</th>
                <th>Nom</th>
                <th>Salaire</th>
                <th>Employeur</th>
                <th>Actions</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="a" items="${assures}">
                <tr>
                    <td>${a.id}</td>
                    <td>${a.nom}</td>
                    <td>${a.salaireMensuel} DH</td>
                    <td>${a.employeur.raisonSociale}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/assures/edit?id=${a.id}">
                            Modifier salaire
                        </a>

                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:if>

    <a href="${pageContext.request.contextPath}/" class="btn">
        Menu principal
    </a>
</div>
</body>
</html>