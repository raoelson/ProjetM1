<jsp:include page="pckage/header.jsp" /> 
<jsp:include page="pckage/nav.jsp" />
<script src="pckage/js/Produit.js"></script>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>    
<br/><br/>
<div class="box-content">    
    <table class="table table-striped table-bordered bootstrap-datatable datatable" id="main-table" style="width: 700px;margin-left: -80px">
        <thead>  
            <tr >
                <td colspan="10" >
                    <a href="#" onclick="" class="btn btn-primary"><i class=""></i>Nouveau</a>                    
                </td>
            </tr>
        </thead>  
        <thead>  
            <tr>       
                <td width="150" align="center">Articles</td>
                <td width="90" align="center">Prix(fmg)</td>                                            
                <td width="50" align="center" colspan="2">Action</td>
            </tr>            
        </thead> 
        <tbody>
        </tbody>            			
                             
    </table>
</form> 
</div>
