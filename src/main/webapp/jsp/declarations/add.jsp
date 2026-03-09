<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Nouvelle Déclaration</title>
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
<div class="container">

    <h1>Ajouter une Déclaration Mensuelle</h1>

    <form action="${pageContext.request.contextPath}/declarations/add"
          method="post">

        <label>Employeur :</label>
        <select name="employeurId" required>
            <option value="">-- Choisir --</option>
            <c:forEach var="emp" items="${employeurs}">
                <option value="${emp.id}">
                        ${emp.raisonSociale}
                </option>
            </c:forEach>
        </select>

        <label>Mois :</label>
        <select name="mois" required>
            <c:forEach var="m" begin="1" end="12">
                <option value="${m}">${m}</option>
            </c:forEach>
        </select>

        <label>Année :</label>
        <input type="number" name="annee"
               value="2025"
               min="2020" max="2035"
               required>

        <button type="submit" class="btn">
            Créer Déclaration
        </button>
    </form>

    <a href="${pageContext.request.contextPath}/declarations/list"
       class="btn">
        Retour à la liste
    </a>

</div>
</body>
</html>