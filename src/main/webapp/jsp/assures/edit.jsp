<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Modifier Salaire</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
<div class="container">

    <h1>Modifier le Salaire</h1>

    <c:if test="${assure == null}">
        <p>Assuré introuvable.</p>
        <a href="${pageContext.request.contextPath}/assures/list" class="btn">
            Retour
        </a>
    </c:if>

    <c:if test="${assure != null}">
        <form action="${pageContext.request.contextPath}/assures/updateSalaire" method="post">

            <!-- Hidden ID -->
            <input type="hidden" name="id" value="${assure.id}"/>

            <p><strong>Nom :</strong> ${assure.nom}</p>

            <p><strong>Employeur :</strong> ${assure.employeur.raisonSociale}</p>

            <label>Nouveau salaire :</label>
            <input type="number"
                   name="salaire"
                   value="${assure.salaireMensuel}"
                   step="0.01"
                   min="0"
                   required>

            <button type="submit" class="btn">
                Mettre à jour
            </button>
        </form>

        <br>

        <a href="${pageContext.request.contextPath}/assures/list" class="btn">
            Retour à la liste
        </a>
    </c:if>

</div>
</body>
</html>