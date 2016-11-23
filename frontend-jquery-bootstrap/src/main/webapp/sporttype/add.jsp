<!-- breadcrumb -->
<ol class="breadcrumb">
    <li><a href="/index.jsp">Adminisztr�ci�</a></li>
    <li><a href="/sporttype/index.jsp">Sport�g</a></li>
    <li class="active">Felvitel</li>
</ol>

<div class="panel panel-default">
    <div class="panel-heading">Sport�g felvitele</div>
    <div class="panel-body">
        <!-- Form -->        
        <form method="post" action="${pageContext.request.contextPath}/admin/sporttype/add">
            <div class="input-group">
                <span class="input-group-addon" id="basic-addon1">Neve</span>
                <input type="text" name="name" class="form-control" placeholder="Sport�g" aria-describedby="basic-addon1">
            </div>
            <div class="input-group">
                <span class="input-group-addon" id="basic-addon1">Le�r�s</span>
                <input type="text" name="desc" class="form-control" placeholder="Le�r�s" aria-describedby="basic-addon1">
            </div>

            <div class="input-group"> 
                <span class="input-group-addon" id="basic-addon1">Eredm�ny �rt�kel�se</span>
                <select class="form-control" id="sel1" name="result" aria-describedby="basic-addon1">
                    <option value="NUMBER">Eg�sz sz�m (g�l,pont stb)</option>
                    <option value="FLOAT_NUMBER">Val�s sz�m (pont stb)</option>
                    <option value="TIME">Ido</option>
                </select>
            </div>                    

            <div class="input-group">
                <input type="submit" value="Felvitel" class="form-control" aria-describedby="basic-addon1">
            </div>

        </form>     
    </div>
</div>            
