<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main" />
    <g:set var="entityName" value="${message(code: 'client.label', default: 'Client')}" />
    <title><g:message code="default.list.label" args="[entityName]" /></title>

</head>
<body>
   <% def val1= new java.text.SimpleDateFormat('yyyy/MM/dd').format(params.day1)%>
   <% def val2= new java.text.SimpleDateFormat('yyyy/MM/dd').format(params.day2)%>
   <h4 align="center " class="nav" >ClientID : ${params.query}</h4>
   <h4 align ="center" class="nav">From : ${val1}  &nbsp;&nbsp;&nbsp;&nbsp;To :  ${val2} </h4>
    <f:table  collection="${clientInstanceList}" />
    <div class="pagination">
    <g:paginate total="${clientInstanceTotal ?: 0}" params="${filterParams}"/>
    <h4 align="center " class="nav" >Total Costs: ${Total} </h4>

</body>
</html>
