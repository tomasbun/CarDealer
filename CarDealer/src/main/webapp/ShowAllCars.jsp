<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="/header.jsp" />

<br>
<div class="container">
    <div class="row">
        
        <!--search form-->
        <div class="col-sm-3 border border-right-0">
        
            <br><h2>Refine Search</h2><hr>    
            <form name="RefineSearchForm" method="post" action="RefineSearch">
                
                <div class="form-group">
                    <label for="make">Make:</label>
                    <select class="form-control" name="make" id="make">
                         <option>Any</option>
                        <c:forEach var="myCar" items="${sessionScope.make}" >
                            <option>${myCar}</option>
                        </c:forEach>  
                    </select>
                </div>
                
                <div class="form-group">
                    <label for="body">Body:</label>
                    <select class="form-control"  name="body" id="body">
                        <option>Any</option>
                        <c:forEach var="myCar" items="${sessionScope.body}" >
                           <option>${myCar}</option>
                        </c:forEach> 
                    </select>       
                </div>
                
                <div class="form-group">
                    <label for="year">Year:</label>
                      <select class="form-control" name="year" id="year">
                          <option>Any</option>
                        <c:forEach var="myCar" items="${sessionScope.year}" >
                           <option>${myCar}</option>
                        </c:forEach> 
                    </select>
                    
                </div>
                
                <div class="form-group">
                    <label for="priceRange">Price range</label>
                    <select class="form-control" name="priceRange" id="priceRange">
                        <option>Any</option>    
                        <option>0 - 5000</option>
                        <option> 5000 - 10000</option>
                        <option>10000 - 20000</option>
                        <option>20000 - 30000</option>
                        <option>30000 - 40000</option>
                        <option>Over 40000</option>
                    </select>
                </div>
                
                   <div class="form-group d-flex">
                        <div class="p-2"><button type="submit" class="btn btn-dark">Find</button></div>
                        <div class="ml-auto p-2"><a href="DisplayAllCars" class="text-right text-dark">Reset</a></div>
                    </div>
            </form>
              
            
            <br>
            
         </div>
        
        <!--list of cars-->
        <div class="col-sm-9">
            <br><h2>Car Range</h2><hr>
            <table class=" table  table-light table-borderless table-hover mydatatable  border border-left-0">
                <thead>
                    <tr>
                        <th>Listing </th>
                        <th>Year</th>
                        <th>Make</th>
                        <th>Model</th>
                        <th>Color</th>
                        <th>Price</th>
                        <th>Image</th>
                    </tr>
                </thead>

                <tbody>

                    <c:forEach var="myCar" items="${list}" >

                        <tr onclick="window.location='CarDetails?listingNumber=${myCar.listingNumber}'">
                            <td>${myCar.listingNumber}</td>
                            <td>${myCar.year}</td>
                            <td>${myCar.make}</td>
                            <td>${myCar.model}</td>
                            <td>${myCar.colour}</td>
                            <td><fmt:formatNumber value="${myCar.listPrice}" type="currency" currencySymbol="&euro;" maxFractionDigits="2"/></td>

                            <td> 
                                <a href="CarDetails?listingNumber=${myCar.listingNumber}">
                                    <img src="images/Stock/Thumbs/${myCar.listingNumber}.jpg"
                                        onerror="this.onerror=null; this.src='images/Stock/Thumbs/${myCar.listingNumber}.JPG'" alt="No image found"/>
                                </a>
                            </td>
                        </tr>


                    </c:forEach>                   
                </tbody>

                <tfoot>
                    <tr>
                        <th>Listing </th>
                        <th>Registration</th>
                        <th>Make</th>              
                        <th>Color</th>
                        <th>Price</th>
                        <th>Image</th>
                    </tr>
                </tfoot>

            </table><br>
        </div>    
    </div>
     <div class="row">
                    <div class="col-12 text-center">    
                        <a href="exelCars" class="btn btn-primary">Generate Excel File</a>
                    </div>     
                 </div><br>   

</div>

<jsp:include page="/footer.jsp" />