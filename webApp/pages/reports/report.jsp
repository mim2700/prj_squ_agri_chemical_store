<%@ page contentType="text/html; charset=Cp1252" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-nested" prefix="nested" %>

<html:html>
	<body bgcolor="#FFFFFF" onload="callRpt()" topmargin="0" leftmargin="0">

	    <p>
	    <iframe id="ifrmId" name="ifrm" height="500" width="100%" marginwidth="1" marginheight="1" border="0" frameborder="0">
        Your browser does not support inline frames or is currently configured not to display inline frames.</iframe>
        </p>
	</body>
</html:html>

<script>
function callRpt()
{
	document.getElementById("ifrmId").src="/prj_squ_agri_chemical_store/reportJasper.do";
}

        </script>