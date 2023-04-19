<header>
    <%@ taglib prefix="c"
               uri="http://java.sun.com/jsp/jstl/core" %>
    <nav class="navbar navbar-expand-lg fixed-top py-4 bg-white">
        <div class="container-lg">

            <a class="navbar-brand" href="#">
<%--                TODO: add logo--%>
                <i class="bi bi-car-front"></i>
            </a>

            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">

                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="${pageContext.request.contextPath}/">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/categories-list">Categories</a>
                    </li>
                    <c:if test="${empty isLogged}">
                        <li class="nav-item">
                            <a class="nav-link" href="${pageContext.request.contextPath}/login">Login</a>
                        </li>
                    </c:if>

                    <c:if test="${!empty isLogged}">

                      <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle"
                               href="#"
                               role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                Administration
                            </a>
                            <ul class="dropdown-menu">
                                <li><a class="dropdown-item" href="${pageContext.request.contextPath}/create-category">Add Category</a></li>
                                <li><a class="dropdown-item" href="${pageContext.request.contextPath}/create-vehicle">Add Vehicle</a></li>
                            </ul>
                        </li>

                        <li class="nav-item">
                            <a class="nav-link" href="${pageContext.request.contextPath}/logout">Logout</a>
                        </li>

                    </c:if>
                </ul>
            </div>
        </div>

    </nav>



</header>
