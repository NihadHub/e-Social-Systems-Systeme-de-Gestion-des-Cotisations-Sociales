
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %><html>
<head>
    <title>Nouvelle declaration</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
<div class="container"><h1>Ajouter une déclaration mensuel</h1>
    <form action="${pageContext.request.contextPath}/declarations/add"method="post">
        <label>Employeur:</label>
        <select name="employeurId" required>
            <c:forEach var="emp" items="${employeurs}">
                <option value="${emp.id}">
                        ${emp.raisonSociale}
                </option>
            </c:forEach>
        </select>

        <label>Mois:</label>
        <select name="mois" required>
            <c:forEach var="m" begin="1" end="12">
                <option value="${m}">${m}</option>
            </c:forEach>
        </select>

        <label>Anee:</label>
        <input type="number" name="annee" value="2025"
               min="2020" max="2030" required>

        <button type="submit" class="btn">Déclaration ajouté </button>
    </form>
</div>
</body>
</html>
