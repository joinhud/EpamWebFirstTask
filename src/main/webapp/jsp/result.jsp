<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="properties.text"/>
<html>
<head>
    <title><fmt:message key="title"/></title>
</head>
<body>
    <h1><fmt:message key="label.header.result"/> ${typeParser}</h1>
    <hr/>
    <table border="1">
        <caption><fmt:message key="label.table.sweets.caption"/></caption>
        <tr>
            <th rowspan="2"><fmt:message key="label.table.candy.name"/></th>
            <th rowspan="2"><fmt:message key="label.table.candy.energy"/></th>
            <th colspan="3"><fmt:message key="label.table.candy.value"/></th>
            <th rowspan="2"><fmt:message key="label.table.candy.production"/></th>
            <th rowspan="2"><fmt:message key="label.table.sweets.type"/></th>
            <th colspan="4"><fmt:message key="label.table.candy.ingredients"/></th>
        </tr>
        <tr>
            <th><fmt:message key="label.table.candy.proteins"/></th>
            <th><fmt:message key="label.table.candy.fats"/></th>
            <th><fmt:message key="label.table.candy.carbohydrates"/></th>
            <th><fmt:message key="label.table.sweets.water"/></th>
            <th><fmt:message key="label.table.candy.sugar"/></th>
            <th><fmt:message key="label.table.sweets.fructose"/></th>
            <th><fmt:message key="label.table.sweets.vanilla"/></th>
        </tr>
        <c:forEach var="sweet" items="${sweets}">
            <tr>
                <td><c:out value="${sweet.name}"/></td>
                <td><c:out value="${sweet.energy}"/></td>
                <td><c:out value="${sweet.getValue().proteins}"/></td>
                <td><c:out value="${sweet.getValue().fats}"/></td>
                <td><c:out value="${sweet.getValue().carbohydrates}"/></td>
                <td><c:out value="${sweet.production}"/></td>
                <td><c:out value="${sweet.type}"/></td>
                <td><c:out value="${sweet.getIngredients().water}"/></td>
                <td><c:out value="${sweet.getIngredients().sugar}"/></td>
                <td><c:out value="${sweet.getIngredients().fructose}"/></td>
                <td><c:out value="${sweet.getIngredients().vanilla}"/></td>
            </tr>
        </c:forEach>
    </table>
    <hr/>
    <table border="1">
        <caption><fmt:message key="label.table.chocolates.caption"/></caption>
        <tr>
            <th rowspan="2"><fmt:message key="label.table.candy.name"/></th>
            <th rowspan="2"><fmt:message key="label.table.candy.energy"/></th>
            <th colspan="3"><fmt:message key="label.table.candy.value"/></th>
            <th rowspan="2"><fmt:message key="label.table.candy.production"/></th>
            <th rowspan="2"><fmt:message key="label.table.chocolates.color"/></th>
            <th colspan="3"><fmt:message key="label.table.candy.ingredients"/></th>
        </tr>
        <tr>
            <th><fmt:message key="label.table.candy.proteins"/></th>
            <th><fmt:message key="label.table.candy.fats"/></th>
            <th><fmt:message key="label.table.candy.carbohydrates"/></th>
            <th><fmt:message key="label.table.chocolates.cocoa_mass"/></th>
            <th><fmt:message key="label.table.candy.sugar"/></th>
            <th><fmt:message key="label.table.chocolates.cocoa_butter"/></th>
        </tr>
        <c:forEach var="chocolate" items="${chocolates}">
            <tr>
                <td><c:out value="${chocolate.name}"/></td>
                <td><c:out value="${chocolate.energy}"/></td>
                <td><c:out value="${chocolate.getValue().proteins}"/></td>
                <td><c:out value="${chocolate.getValue().fats}"/></td>
                <td><c:out value="${chocolate.getValue().carbohydrates}"/></td>
                <td><c:out value="${chocolate.production}"/></td>
                <td><c:out value="${chocolate.color}"/></td>
                <td><c:out value="${chocolate.getIngredients().cocoaMass}"/></td>
                <td><c:out value="${chocolate.getIngredients().sugar}"/></td>
                <td><c:out value="${chocolate.getIngredients().cocoaButter}"/></td>
            </tr>
        </c:forEach>
    </table>
    <a href="/WebFirstTask"><fmt:message key="label.link.back"/></a>
</body>
</html>
