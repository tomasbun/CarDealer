<%-- 
    Document   : ShowAllSales
    Created on : 22 Nov 2020, 01:42:59
    Author     : Tomas
--%>

<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="/header.jsp" />

<br>
<div class="container">

    <!--list of Sales-->

    <br><h2>Sales</h2><hr>
    <table class=" table  table-light table-borderless table-hover mydatatable  border border-left-0">
        <thead>
            <tr>
                <th>ID</th>
                <th>Listing Number</th>
                <th>Customer</th>
                <th>Sales agent</th>
                <th>Trade In</th>
                <th>Trade In Value</th>
                <th>Amount Paid</th>
            </tr>
        </thead>

        <tbody>

            <c:forEach var="s" items="${list}" >

                <tr>
                    <td>${s.salesID}</td>
                    <td><a href="CarDetails?listingNumber=${s.getListingNumber().getListingNumber()}">${s.getListingNumber().getListingNumber()}</a></td>
                    <td>${s.getCustomerID().getFullname()}</td>
                    <td><a href="EditStaff?staffID=${s.getStaffID().getStaffID()}'">${s.getStaffID().getFullName()}</a></td>
                     <c:choose> 
                        <c:when test="${s.tradein == 'no'}">
                            <td>${s.tradein}</td>
                        </c:when> 
                        <c:otherwise>
                            <td><a href="CarDetails?listingNumber=${s.tradein}">${s.tradein}</a></td>
                        </c:otherwise>     
                    </c:choose> 
                    
                    <td>${s.tradeinValue}</td>
                    <td>${s.amountPaid}</td>

                    
                </tr>


            </c:forEach>                   
        </tbody>

        <tfoot>
            <tr>
                 <th>ID</th>
                <th>Listing Number</th>
                <th>Customer</th>
                <th>Sales agent</th>
                <th>Trade In</th>
                <th>Trade In Value</th>
                <th>Amount Paid</th>
            </tr>
        </tfoot>

    </table><br>
     <div class="row">
                    <div class="col-12 text-center">    
                        <a href="exelSales" class="btn btn-primary">Generate Excel File</a>
                    </div>     
                 </div><br>       
    
</div>    


<jsp:include page="/footer.jsp" />
