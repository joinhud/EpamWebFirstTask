<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<fmt:setLocale value="${locale}"/>
<fmt:setBundle basename="properties.text"/>
<html>
<head>
    <title><fmt:message key="title"/></title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <h1><fmt:message key="label.header"/></h1>
    <form name="Language" action="WebFirstTask" method="post">
        <label><fmt:message key="label.selector.language"/></label>
        <select name="language">
            <option value="en_US"><fmt:message key="label.language.en"/></option>
            <option value="es_ES"><fmt:message key="label.language.es"/></option>
        </select>
        <button type="submit"><fmt:message key="label.button.change"/></button>
        <input type="hidden" name="command" value="change_language">
    </form>
    <hr/>
    <form id="form_main" name="XMLParser" action="WebFirstTask" method="post" enctype="multipart/form-data">
        <label><fmt:message key="label.input.xml"/></label>
        <input type="file" name="xmlFile" accept=".xml">
        <label><fmt:message key="label.input.xsd"/></label>
        <input type="file" name="xsdFile" accept=".xsd">
        <label><fmt:message key="label.selecotor.parser"/></label>
        <select name="typeParser">
            <option value="dom"><fmt:message key="label.parser.dom"/></option>
            <option value="sax"><fmt:message key="label.parser.sax"/></option>
            <option value="stax"><fmt:message key="label.parser.stax"/></option>
        </select>
        <button type="submit"><fmt:message key="label.button.submit"/></button>
        <input type="hidden" name="command" value="parse">
    </form>
    <hr/>
    <a href="johndoepage.jsp"><fmt:message key="label.link.error"/></a>
</body>
</html>
