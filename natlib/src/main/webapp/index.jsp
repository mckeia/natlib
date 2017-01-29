<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
	<title>Ian Mckenzie Nat Lib Demo</title>
	<spring:url value="/resources/js/jquery.js" var="jqueryJs" />
	<spring:url value="/resources/js/main.js" var="mainJs" />   
	<spring:url value="/resources/js/bootstrap.min.js" var="bootstrapJs" />  
	<spring:url value="/resources/css/bootstrap.min.css" var="bootstrapCSS" />  
    <script src="${jqueryJs}"></script>
    <script src="${mainJs}"></script>	
    <script src="${bootstrapJs}"></script>	 
    <link rel="stylesheet" href="${bootstrapCSS}">
</head>
<body>
	<center>
		<br/>
		<h1>Book Database</h1>
		<br/>
		<button type="button" onClick="home();"> Click here to Enter
		</button>
	</center>
</body>
</html>
