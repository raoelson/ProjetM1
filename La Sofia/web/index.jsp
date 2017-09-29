<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="cx"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmtx"%>
<%--<jsp:forward page="/LocataireController?actions=wlcm" />--%>
<cx:redirect url="/ProdsController">
    <cx:param name="actions" value="wlcm"/>    
</cx:redirect>