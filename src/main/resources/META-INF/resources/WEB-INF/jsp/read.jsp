<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link type="text/css" href="css/main.css" rel="stylesheet" />
</head>
<body>
    <h1>Reading App</h1>

    <h3>Known words (${size})</h3>
    <p>${knownWords}</p>

    <form:form method="post" action="read" modelAttribute="block">
      <form:errors path="*" cssClass="errorblock" element="div" />
        <textarea name="words" rows="5"></textarea>
        <form:errors path="words" cssClass="error" /><br />

        <input type="submit" value="Highlight"/>
    </form:form>

    <c:if test="${not empty result}">
      <h3>Highlight known words</h3>
      <p>${result}</p>
    </c:if>
</body>
</html>