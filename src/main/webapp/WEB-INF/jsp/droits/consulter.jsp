<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %><!DOCTYPE html>
<html>
<head>
    <title> Consultation des droits sociaux</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
<div class="container">
    <h1>Consultation des droits sociaux</h1>

    <form action="${pageContext.request.contextPath}/droits"
          method="get">
        <label> Choisir l'assuré:</label>
        <select name="assureId" required>
            <option value="">-- Choisir --</option>
            <c:forEach var="a" items="${assures}">
                <option value="${a.id}">${a.nom}</option>
            </c:forEach>
        </select>
        <button type="submit" class="btn">Search </button>
    </form>

    <c:if test="${droits != null}">
        <div class="card">
            <h2> ${assure.nom}</h2>
            <table>
                <tr>
                    <td>Nombres de moid declarés:</td>
                    <td><strong>${droits.moisDeclares}</strong></td>
                </tr>
                <tr>
                    <td>Somme des cotisations:</td>
                    <td><strong>${droits.totalCotisations} DH</strong></td>
                </tr>
                <tr>
                    <td>Couverture Médicale: </td>
                    <td>
                        <c:choose>
                            <c:when test="${droits.couvertureMaladie}">
                                <span class="success"> Qualifié</span>
                            </c:when>
                            <c:otherwise>
                                <span class="error">Non qualifié</span>
                            </c:otherwise>
                        </c:choose>
                    </td>
                </tr>
                <tr>
                    <td colspan="2">${droits.message}</td>
                </tr>
            </table>
        </div>
    </c:if>
</div>
</body>
</html>
