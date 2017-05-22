<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main" />
    <g:set var="entityName" value="${message(code: 'client.label', default: 'Client')}" />
    <title><g:message code="default.list.label" args="[entityName]" /></title>

</head>
<body>

%{--<--<div class="nav" ><g:message args="ClientID : ${params.query}" /></div>--}%


<%=  "ClientID  ${params.query}"  %>

<%=  "  ${params.day1}"  %>
<%=  "  ${params.day2}"  %>


<f:table collection="${clientInstanceList}" />

<div class="pagination">
    <g:paginate total="${clientInstanceTotal ?: 0}" />



</body>
</html>
