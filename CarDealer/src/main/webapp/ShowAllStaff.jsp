<%-- 
    Document   : ShowAllStaff
    Created on : 21 Nov 2020, 09:43:27
    Author     : Tomas
--%>

<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="/header.jsp" />

<br>
<div class="container">

    <!--list of Staff-->

    <br><h2>Current Staff</h2><hr>
    <table class=" table  table-light table-borderless table-hover mydatatable  border border-left-0">
        <thead>
            <tr>
                <th>Image</th>
                <th>ID </th>
                <th>Full Name</th>
                <th>Email</th>
                <th>Phone</th>
                <th>Fax</th>
                <th>Department</th>
            </tr>
        </thead>

        <tbody>

            <c:forEach var="e" items="${list}" >

                <tr  onclick="window.location='EditStaff?staffID=${e.staffID}'">
                    <td><img src="images/Sales People/${e.fullName}.jpg" onerror="this.onerror=null; this.src='images/Sales People/unknown.png'"/></td>
                    <td>${e.staffID}</td>
                    <td>${e.fullName}</td>
                    <td>${e.email}</td>
                    <td>${e.phone}</td>
                    <td>${e.fax}</td>
                     <c:choose> 
                        <c:when test="${e.admin == 1}">
                            <td>Administration</td>
                        </c:when> 
                        <c:otherwise>
                            <td>Sales</td>
                        </c:otherwise>     
                    </c:choose> 
                    
                </tr>


            </c:forEach>                   
        </tbody>

        <tfoot>
            <tr>
                <th>Image</th>
                <th>ID </th>
                <th>Full Name</th>
                <th>Email</th>
                <th>Phone</th>
                <th>Fax</th>
                <th>Department</th>
            </tr>
        </tfoot>

    </table><br>
</div>    


<jsp:include page="/footer.jsp" />