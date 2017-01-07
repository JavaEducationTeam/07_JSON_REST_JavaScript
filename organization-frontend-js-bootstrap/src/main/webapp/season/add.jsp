<!-- breadcrumb -->
<ol class="breadcrumb">
    <li>Adminisztr�ci�</li>
    <li>Sport�g</li>
    <li class="active">Felvitel</li>
</ol>

<div class="panel panel-default">
    <div class="panel-heading">Sport�g felvitele</div>
    <div class="panel-body">
        <!-- Form -->        
        <form method="post" action="${pageContext.request.contextPath}/admin/season/add">
            <div class="input-group">
                <span class="input-group-addon" id="basic-addon1">Szezon neve</span>
                <input type="text" name="name" class="form-control" placeholder="Szezon neve" aria-describedby="basic-addon1">
            </div>
            <div class="input-group">
                <span class="input-group-addon" id="basic-addon1">Le�r�s</span>
                <input type="text" name="desc" class="form-control" placeholder="Le�r�s" aria-describedby="basic-addon1">
            </div>

            <div class="input-group">
                <input type="submit" value="Felvitel" class="form-control" aria-describedby="basic-addon1">
            </div>

        </form>     
    </div>
</div>            
