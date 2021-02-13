<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="/header.jsp" />


<div class="container">

    <c:choose> 
        <c:when test="${list.isEmpty()}">
            
            <div class="text-center">
                <br>
                <img src="images/web/emptyGarage.jpg" alt="Responsive image">
                <h2>Your wish list is empty.</h2>
                <br>
            </div>
        </c:when> 
        <c:otherwise>


            <c:forEach var="myCar" items="${list}" >

                <br><div class="card">
                    <h5 class="card-header">Listing Number: ${myCar.listingNumber}</h5>
                    <div class="card-body">
                        <h5 class="card-title">${myCar.make} ${myCar.model} ${myCarYear}</h5>
                        <div class="row">    
                            <div class="col-lg-8">
                                <p class="card-text">${myCar.description}</p>
                            </div>
                            <div class="col-lg-4">
                                <img src="images/Stock/Large/${myCar.listingNumber}/${myCar.listingNumber}.JPG"
                                     style="width:100%"
                                     alt="No image found"/>
                                <h4><fmt:formatNumber value="${myCar.listPrice}" type="currency" currencySymbol="&euro;" maxFractionDigits="2"/></h4>
                            </div>
                        </div>


                        <c:choose> 
                            <c:when test="${myCar.sold == 0}">
                                <p class="text-success">Available</p>
                            </c:when> 
                            <c:otherwise>
                                <p class="text-danger">Sold</p>
                            </c:otherwise>     
                        </c:choose>      

                        <a href="CarDetails?listingNumber=${myCar.listingNumber}" class="btn btn-primary">View Listing</a>
                        <a href="WishlistRemove?listingNumber=${myCar.listingNumber}" class="btn btn-warning">Remove</a>
                    </div>
                </div>

            </c:forEach>



        </c:otherwise>     
    </c:choose>     




<br>
</div>

<jsp:include page="/footer.jsp" />
