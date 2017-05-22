
<!DOCTYPE html>
<html>
<head>
    <asset:javascript src="application.js"/>
    <asset:stylesheet src="application.css"/>
    <meta name="layout" content="main"/>
    <title></title>
</head>
<body>



<fieldset class="form">
    <g:form action="search"  controller="client"   method="GET" >
        <div class="fieldcontain">
            <label for="query">Search for Client:</label>
        <g:textField name="query" value="${params.query}"/>
        <div  class="fieldcontain">
            <label for="query">From:</label>
            <g:datePicker type="date" name="day1" precision="day" value="${new Date()}" />
        </div>
        <div  class="fieldcontain">
            <label for="query">To:</label>
            <g:datePicker type="date" name="day2" precision="day" value="${new Date()}"  />
        </div>

        <g:actionSubmit value="Search"  class="nav" />
    </g:form>
</fieldset>


<f:table collection="${clientInstanceList}" />

<div class="pagination">
    <g:paginate total="${clientInstanceTotal ?: 0}" />



</body>
</html>
