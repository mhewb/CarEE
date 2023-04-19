<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<%--
  Created by IntelliJ IDEA.
  User: mhe
  Date: 19/04/2023
  Time: 15:54
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>CarEE</title>
  <%--    Bootstrap v5.2--%>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
  <%--    Bootstrap icons--%>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.4/font/bootstrap-icons.css">
  <%--    Custom CSS--%>
  <style>
    <%@include file="/css/custom.scss" %>
  </style>

</head>
<body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>


<jsp:include page="menu.jsp"></jsp:include>

<main class="flex-shrink-0">

  <div class="container-fluid">

    <div class="container-lg">

      <div class="container-fluid mt-5 py-5 text-center">
        &nbsp;
      </div>

    </div>
  </div>

  <div class="container-fluid">

  <div class="container-lg">

    <form class="col-6 mx-auto"
          method="post"
          action="${pageContext.request.contextPath}/edit-category?id=${id}">

      <label for="name">Name</label>
      <input type="text"
             id="name"
             name="name"
             value="${empty isEdit ? '' : name}"
             class="form-control form-control-sm">


      <div class="d-grid gap-2 col-5 mx-auto my-2 ">
        <c:if test="${!empty isEdit}">
          <button type="submit" class="btn btn-primary">Edit</button>
        </c:if>

        <c:if test="${empty isEdit}">
          <button type="submit" class="btn btn-primary" formaction="/create-category">Create</button>
        </c:if>

      </div>


    </form>

  </div>
  </div>

</main>

<aside>

</aside>

<jsp:include page="footer.jsp"></jsp:include>

<c:if test="${!empty loggingError}">
  <script>alert('${loggingError}')</script>
</c:if>



</body>
</html>