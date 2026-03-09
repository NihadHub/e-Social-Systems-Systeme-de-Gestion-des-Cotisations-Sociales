<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Ajouter Assuré</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
<div class="container">
    <h1>Ajouter un nouvel Assuré</h1>

    <form action="${pageContext.request.contextPath}/assures/add" method="post">

        <label>Nom de l'assuré:</label>
        <input type="text" name="nom" required>

        <label>Salaire mensuel:</label>
        <input type="number" name="salaire" step="0.01" required>

        <label>Employeur:</label>
        <select name="employeurId" required>
            <option value="">-- Choisir un employeur --</option>
            <c:forEach var="emp" items="${employeurs}">
                <option value="${emp.id}">
                        ${emp.raisonSociale}
                </option>
            </c:forEach>
        </select>

        <button type="submit" class="btn">Ajouter Assuré</button>
    </form>

    <a href="${pageContext.request.contextPath}/assures/list" class="btn">Retour à la liste</a>
</div>
</body>
</html>