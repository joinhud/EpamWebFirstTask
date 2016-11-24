<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="properties.text"/>
<html>
<head>
    <title><fmt:message key="title"/></title>
</head>
<body>
    <h1><fmt:message key="label.header"/></h1>
    <form name="Language" action="WebFirstTask" method="post">
        <p><fmt:message key="label.selector.language"/></p>
        <select name="language">
            <option value="en_US"><fmt:message key="label.language.en"/></option>
            <option value="es_ES"><fmt:message key="label.language.es"/></option>
        </select>
        <button type="submit"><fmt:message key="label.button.change"/></button>
        <input type="hidden" name="command" value="change_language">
    </form>
    <hr/>
    <form name="XMLParser" action="WebFirstTask" method="post">
        <p><fmt:message key="label.selecotor.parser"/></p>
        <select name="typeParser">
            <option value="dom"><fmt:message key="label.parser.dom"/></option>
            <option value="sax"><fmt:message key="label.parser.sax"/></option>
            <option value="stax"><fmt:message key="label.parser.stax"/></option>
        </select>
        <button type="submit"><fmt:message key="label.button.submit"/></button>
        <input type="hidden" name="command" value="parse">
    </form>
</body>
</html>
