<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<%--
  Created by IntelliJ IDEA.
  User: mhe
  Date: 19/04/2023
  Time: 09:31
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
</head>
<body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>


<jsp:include page="menu.jsp"></jsp:include>

<main class="flex-shrink-0">

    <div class="container-lg">

    <div class="row row-cols-1 row-cols-sm-3 row-cols-lg-4">

        <c:forEach var="v" items="${vehicles}">

        <div class="col my-3">
            <div class="card h-100">

                <img src="${v.imgUrl}" class="card-img-top" alt="...">

                <div class="card-body">

                    <h5 class="card-title"> ${v.name} </h5>

                    <h6 class="card-subtitle"> ${v.category.getName()}</h6>

                    <a class="btn btn-primary" role="button" href="/vehicle-details?id=${v.id}">Details</a>

                </div>
            </div>
        </div>

        </c:forEach>

    </div>
    </div>
</main>

<aside>

</aside>

<jsp:include page="footer.jsp"></jsp:include>


</body>
</html>