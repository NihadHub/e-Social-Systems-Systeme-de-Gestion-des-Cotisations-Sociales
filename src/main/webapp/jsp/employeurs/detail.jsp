<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Détail Employeur</title>
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
<div class="container">

    <h1>Détail de l'Employeur</h1>

    <div class="card">
        <p><strong>ID :</strong> ${employeur.id}</p>
        <p><strong>Raison Sociale :</strong> ${employeur.raisonSociale}</p>
        <p><strong>Secteur d'Activité :</strong> ${employeur.secteurActivite}</p>
    </div>

    <hr>

    <div class="card">
        <h2>Total des Cotisations</h2>

        <c:choose>
            <c:when test="${totalCotisations > 0}">
                <p class="success">
                        ${totalCotisations} DH
                </p>
            </c:when>
            <c:otherwise>
                <p class="error">
                    Aucune cotisation enregistrée.
                </p>
            </c:otherwise>
        </c:choose>
    </div>

    <br>

    <div class="actions">
        <a href="${pageContext.request.contextPath}/employeurs/list"
           class="btn">
            Retour à la liste
        </a>

        <a href="${pageContext.request.contextPath}/declarations/add"
           class="btn">
            Nouvelle Déclaration
        </a>
    </div>

</div>
</body>
</html>