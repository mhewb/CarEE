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
    <%--    Custom CSS--%>
    <style>
        <%@include file="/css/custom.scss" %>
    </style>
</head>
<body class="d-flex flex-column h-100">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>

<jsp:include page="menu.jsp"></jsp:include>

<main>

    <div class="container-fluid">

        <div class="container-lg">

            <div class="container-fluid mt-5 py-5 text-center">
                <c:if test="${!empty isLogged}">
                    <a class="btn btn-primary"
                       role="button"
                       href="${pageContext.request.contextPath}/create-vehicle">Create</a>
                </c:if>
                &nbsp;
            </div>

        </div>
    </div>

    <div class="container-fluid py-3 bg-light">

        <div class="container-lg">

            <div class="row row-cols-1 row-cols-sm-3 row-cols-lg-4">

            <c:forEach var="vehicle" items="${vehicles}">

            <div class="col my-3">
                <div class="card h-100">

                    <img src="${vehicle.imgUrl}" class="card-img-top" alt="...">

                    <div class="card-body">

                        <h5 class="card-title"> ${vehicle.name} </h5>

                        <h6 class="card-subtitle"> ${vehicle.category.getName()}</h6>

                        <a class="btn btn-primary"
                           role="button"
                           href="${pageContext.request.contextPath}/vehicle-details?id=${vehicle.id}" >
                            Details
                        </a>

                        <c:if test="${!empty isLogged}">
                            <a class="btn btn-danger" role="button" href="${pageContext.request.contextPath}/delete-vehicle?id=${vehicle.id}">Delete</a>
                        </c:if>

                    </div>
                </div>

            </div>
        </c:forEach>

             </div>

        </div>

    </div>

    <div class="container-fluid py-3">

        <div class="container-lg text-center">

            <h2 class="py-3">Our Services</h2>

            <div class="row row-cols-1 row-cols-md-3 p-3">

                <div class="col d-flex flex-row justify-content-around">
                    <a href="#text1">
                    <h5>
                        <i class="bi bi-journal-check d-block"></i>
                        Pellentesque
                    </h5>
                    </a>
                </div>

                <div class="col  d-flex flex-row justify-content-around">
                    <a href="#text2">
                    <h5>
                        <i class="bi bi-speedometer d-block"></i>
                        Viverra Aliquam
                    </h5>
                    </a>
                </div>

                <div class="col  d-flex flex-row justify-content-around">
                    <a href="#text3">
                    <h5>
                        <i class="bi bi-rulers d-block"></i>
                        Vivamus Aliquam
                    </h5>
                    </a>
                </div>

            </div>

        </div>

    </div>

    <div class="container-fluid py-3 bg-light">
        <div class="container-lg py-3 tab">
        &nbsp;
        <div class="hidden-text" id="text1">
            Lorem ipsum dolor sit amet, consectetur adipiscing elit.
            Pellentesque sodales ultricies velit at vehicula.
            Aliquam ullamcorper urna orci, in bibendum nunc tincidunt varius.
            Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos.
            Aenean arcu velit, pretium ut condimentum vitae, vestibulum ut augue.
        </div>
        <div class="hidden-text" id="text2">
            Pellentesque risus leo, accumsan et efficitur a, mollis sed lorem.
            Mauris blandit blandit lobortis. Quisque commodo nec elit in varius.
            Vivamus et mi quis felis pretium pharetra.
            Mauris accumsan finibus ipsum, quis molestie dolor porttitor at.
        </div>
        <div class="hidden-text" id="text3">
            Integer et gravida sem.
            Sed suscipit hendrerit rutrum. Vivamus ligula felis, elementum et auctor a, condimentum id turpis.
            Nullam sit amet lorem id quam mattis semper. Praesent suscipit dolor ac lacus vestibulum mollis.
            Quisque sit amet cursus urna, eget condimentum mauris.
        </div>
        </div>
    </div>

    <div class="custom-background">

        <div class="container-lg text-center py-5">

            <h3>${empty vehicles ? 'a' : vehicles.size()}</h3>
            <h5>vehicule${vehicles.size() != 1 ? 's' : ''} available</h5>

        </div>

        <div id="purchase-now" class="p-4">
            <a>What are you waiting for ? Purchase one now</a>
        </div>

    </div>

</main>

<aside>

</aside>

<jsp:include page="footer.jsp"></jsp:include>


</body>
</html>