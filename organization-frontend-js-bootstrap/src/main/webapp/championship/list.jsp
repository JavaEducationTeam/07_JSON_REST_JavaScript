<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- breadcrumb -->
<ol class="breadcrumb">
    <li><a href="/index.jsp">Adminisztráció</a></li>
    <li><a href="/sporttype/index.jsp">Sorozat</a></li>
    <li class="active">Lista</li>
</ol>

<div class="panel panel-default">
    <div class="panel-heading">Bajnokság lista</div>
    <div class="panel-body">

        <form method="post" action="${pageContext.request.contextPath}/admin/championship/list" accept-charset="utf-8">
            <div class="input-group"> 
                <span class="input-group-addon" id="basic-addon1">Sportág</span>
                <select class="form-control" id="sport" name="sport" aria-describedby="basic-addon1">
                    <c:forEach var="item" items="${applicationScope['dataModel'].sportTypeDAO.all}">
                        <c:choose>
                            <c:when test="${(selectedSportType != null && item.name==selectedSportType.name) || item.name == param['sport']}">
                                <option selected="" value="${item.name}">${item.name}</option>
                            </c:when>
                            <c:otherwise>
                                <option value="${item.name}">${item.name}</option>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </select>
            </div>                    
            
            <div class="input-group"> 
                <span class="input-group-addon" id="basic-addon1">Szezon</span>
                <select class="form-control" id="season" name="season" aria-describedby="basic-addon1">
                    <c:forEach var="item" items="${applicationScope['dataModel'].seasonDAO.all}">
                        <c:choose>
                            <c:when test="${selectedSeason != null && selectedSeason.name == item.name}">
                                <option selected="" value="${item.name}">${item.name}</option>
                            </c:when>
                            <c:otherwise>
                                <option value="${item.name}">${item.name}</option>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </select>
            </div>                    

            <div class="input-group"> 
                <span class="input-group-addon" id="basic-addon1">Sorozat</span>
                <select class="form-control" id="series" name="series" aria-describedby="basic-addon1">
<%--
                    <c:forEach var="item" items="${applicationScope['dataModel'].seriesDAO.all}">
                        <c:choose>
                            <c:when test="${selectedSeries != null && selectedSeries.name == item.name}">
                                <option selected="" value="${item.name}">${item.name}</option>
                            </c:when>
                            <c:otherwise>
                                <option value="${item.name}">${item.name}</option>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
--%>
                </select>
            </div>                    
            
            <div class="input-group">
                <input type="submit" value="Lekerdezes" class="form-control" aria-describedby="basic-addon1">
            </div>

        </form>     
            
        
        <c:set var="flag" value="false" />
        <div class="list-group">
            <c:forEach var="item" items="${championships}">
                <c:set var="flag" value="true" />
                <a href="#" class="list-group-item">
                    <h4 class="list-group-item-heading">${item.name}</h4>
                    <p class="list-group-item-text">${item.description}</p>
                </a>
            </c:forEach>    
        </div>
        
                <c:if test="${flag=='false'}">
                    <div class="alert alert-success" role="alert"> Nincs elem a listában </div>
                </c:if>        
    </div>
</div>            

<script>
    var resourceURL="${pageContext.request.contextPath}/rest/series/";
    var selectedSeries="${selectedSeries.name}";
    
    function changeSport(){
        var sportIndex=document.querySelector("#sport").selectedIndex;
        var seasonIndex=document.querySelector("#season").selectedIndex;
        var oReq = new XMLHttpRequest();
        oReq.responseType="json"; 
        oReq.open("GET", resourceURL+sportIndex+"/"+seasonIndex, true);
        oReq.onload = function () {
            document.getElementById("series").innerHTML="";
            var option;
            for(var x in oReq.response){
                option = document.createElement("option");
                option.text = oReq.response[x].name;
                if(selectedSeries === option.text){
                    option.selected = true;
                }
                document.getElementById("series").add(option);
            }
        };
        oReq.send(null);
    }
    document.querySelector("#sport").addEventListener("change",changeSport);
    document.querySelector("#season").addEventListener("change",changeSport);
    changeSport();
    
</script>