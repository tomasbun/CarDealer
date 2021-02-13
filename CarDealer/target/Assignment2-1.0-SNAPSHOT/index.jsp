<%-- 
    Document   : index
    Created on : 15 Nov 2020, 01:23:31
    Author     : Tomas
--%>

<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="/header.jsp" />

        

<div class="container">
    
    <div class="row text-center">
        <div class="col-sm"><br>
            <h1>Our promise to you</h1><hr>
            <p>We transfer ownership of all purchased vehicles immediately. We transfer vehicle registrations from you, 
                the current owner, to us, Used Car Buyer Direct / Moylish Motors Sales Ltd, on the day of purchase. 
                We use Motortrans.ie which is the fastest way to change ownership of a vehicle. 
                Motortrans is a service provided by the Department of Transport 
                and is only available to registered motor dealers with a valid garage code.</p><hr>
        </div>
    </div>
   

    <div class="row text-center">
        <div class="col-sm">
             <img src="images/web/car-range.png" class="img-fluid" alt="Responsive image">
            <a class="text-dark" href="DisplayAllCars"><h3>View our cars</h3></a>
            <p>Check out our extensive range of new and preowned cars. We guarantee quality and best price match.
                All our cars are listed with full details online, we accept all trade ins and all cars come with a full history check so you have complete peace of mind.
            </p>
        </div>
        <div class="col-sm">
             <img src="images/web/car-finance.png" class="img-fluid" alt="Responsive image">
             <a class="text-dark" href="underConstruction.jsp"><h3>Get a finance</h3></a>
            <p>Looking for a car loan in Ireland that does not involve tons of paperwork, long hold times and annoying appointments? 
                You have come to the right place. Whether you are after your first car or you want to upgrade your existing model,
                ,we can help you to get the show on the road. </p>
        </div>
        <div class="col-sm">
            <img src="images/web/sell-car.png" class="img-fluid" alt="Responsive image">
            <a class="text-dark" href="underConstruction.jsp"><h3>We pay cash for your car</h3></a>
            <p>We will make a cash for car offer that we will stand over for 3 days.
                This offer is subject to a quick test drive and a visual inspection, however on higher 
                value and newer cars a workshop and diagnostic inspection may be necessary at no cost to you, the seller.</p>
        </div>
    </div>
</div>

        
        
<jsp:include page="/footer.jsp" />