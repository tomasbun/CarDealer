<%-- 
    Document   : upload.jsp
    Created on : 25 Nov 2020, 12:47:46
    Author     : Tomas
--%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="/header.jsp" />

<div class="container center">





    <center>
        <p>${message}</p>
        <form method="post" action="FileUploadServlet" enctype="multipart/form-data">
            <p>Select file to upload:</p>
            <input type="email" id="email" value="<shiro:principal/>" name="email" hidden>
            <input type="file" name="uploadFile" />
            <br/><br/>
            <input type="submit" value="Upload" />
        </form><br>
    </center>


</div>

<jsp:include page="/footer.jsp" />