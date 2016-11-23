
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="hu">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
        <title>Sport</title>
        <jsp:include page="include.jsp" />
    </head>
    <body>

        <div class="panel-default">
            <div class="panel-heading">Tanfolyami minta alaklamz�s: Sportverseny szervez�s</div>
            <div class="panel-body">

<!-- Navigation -->        
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav">
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Sport <span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a href="${pageContext.request.contextPath}/index.jsp?page=sporttype/add.jsp">Felvitel</a></li>
                                <li><a href="${pageContext.request.contextPath}/index.jsp?page=sporttype/list.jsp">List�z�s</a></li>
                            </ul>
                        </li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Szezon <span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a href="${pageContext.request.contextPath}/index.jsp?page=season/add.jsp">Felvitel</a></li>
                                <li><a href="${pageContext.request.contextPath}/index.jsp?page=season/list.jsp">List�z�s</a></li>
                            </ul>
                        </li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Sorozat <span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a href="${pageContext.request.contextPath}/index.jsp?page=series/add.jsp">Felvitel</a></li>
                                <li><a href="${pageContext.request.contextPath}/index.jsp?page=series/list.jsp">List�z�s</a></li>
                            </ul>
                        </li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Bajnoks�g <span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a href="${pageContext.request.contextPath}/index.jsp?page=championship/add.jsp">Felvitel</a></li>
                                <li><a href="${pageContext.request.contextPath}/index.jsp?page=championship/list.jsp">List�z�s</a></li>
                            </ul>
                        </li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Verseny/fordul� <span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a href="${pageContext.request.contextPath}/index.jsp?page=competition/add.jsp">Felvitel</a></li>
                                <li><a href="${pageContext.request.contextPath}/index.jsp?page=competition/list.jsp">List�z�s</a></li>
                            </ul>
                        </li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Futam/m�rkoz�s <span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a href="${pageContext.request.contextPath}/index.jsp?page=race/add.jsp">Felvitel</a></li>
                                <li><a href="${pageContext.request.contextPath}/index.jsp?page=race/list.jsp">List�z�s</a></li>
                            </ul>
                        </li>
                    </ul>
                </div>   
<c:choose>
    <c:when test="${param['page']!=null}">
        <jsp:include page="${param['page']}" />
    </c:when>
    <c:when test="${page!=null}">
        <jsp:include page="${page}.jsp" />
    </c:when>
    <c:otherwise>
        <div class="alert alert-success" role="alert"> V�lasz egy men�pontot </div>
    </c:otherwise>
</c:choose>

            </div>
            <div class="panel-footer page-footer">Sch�nherz Akad�mia & Ulyssys (Begya Andr�s, Kar�czkai Kriszti�n, Nagy Kriszti�n)</div>
        </div>
    </body>
</html>

