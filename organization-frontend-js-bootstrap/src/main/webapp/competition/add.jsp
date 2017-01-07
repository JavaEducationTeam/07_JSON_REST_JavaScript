<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- breadcrumb -->
<ol class="breadcrumb">
    <li>Adminisztráció</li>
    <li>Verseny</li>
    <li class="active">Felvitel</li>
</ol>

<div class="panel panel-default">
    <div class="panel-heading">Verseny felvitele</div>
    <div class="panel-body">
        <!-- Form -->        
        <form method="post" action="${pageContext.request.contextPath}/admin/competition/add">
            <div class="input-group">
                <span class="input-group-addon" id="basic-addon1">Verseny neve</span>
                <input type="text" name="name" class="form-control" placeholder="Bajnokság neve" aria-describedby="basic-addon1">
            </div>
            <div class="input-group">
                <span class="input-group-addon" id="basic-addon1">Leírás</span>
                <input type="text" name="desc" class="form-control" placeholder="Leírás" aria-describedby="basic-addon1">
            </div>

            <div class="input-group"> 
                <span class="input-group-addon" id="basic-addon1">Sportág</span>
                <select class="form-control" id="sport" name="sport" aria-describedby="basic-addon1">
                    <c:forEach var="item" items="${applicationScope['dataModel'].sportTypeDAO.all}">
                        <option value="${item.name}">${item.name}</option>
                    </c:forEach>
                </select>
            </div>                    
            
            <div class="input-group"> 
                <span class="input-group-addon" id="basic-addon1">Szezon</span>
                <select class="form-control" id="season" name="season" aria-describedby="basic-addon1">
                    <c:forEach var="item" items="${applicationScope['dataModel'].seasonDAO.all}">
                        <option value="${item.name}">${item.name}</option>
                    </c:forEach>
                </select>
            </div>                    

            <div class="input-group"> 
                <span class="input-group-addon" id="basic-addon1">Sorozat</span>
                <select class="form-control" id="series" name="series" aria-describedby="basic-addon1">
<%--
                    <c:forEach var="item" items="${applicationScope['dataModel'].seriesDAO.all}">
                        <option value="${item.name}">${item.name}</option>
                    </c:forEach>
--%>
                </select>
            </div>                    

            <div class="input-group"> 
                <span class="input-group-addon" id="basic-addon1">Bajnokság</span>
                <select class="form-control" id="championship" name="championship" aria-describedby="basic-addon1">
<%--                    
                    <c:forEach var="item" items="${applicationScope['dataModel'].championshipDAO.all}">
                        <option value="${item.name}">${item.name}</option>
                    </c:forEach>
--%>                        
                </select>
            </div>                    

            <div class="input-group">
                <input type="submit" value="Felvitel" class="form-control" aria-describedby="basic-addon1">
            </div>

        </form>     
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