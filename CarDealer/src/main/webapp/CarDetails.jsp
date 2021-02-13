<%-- 
    Document   : CarDetails
    Created on : 5 Nov 2020, 14:56:23
    Author     : Tomas
--%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="/header.jsp" />


<br>
<div class="container">
<div class="card">
      <form name="updateCar" action="updateCar" method="post">
  
    <div class="card-header">
        <ul class="nav nav-pills card-header-pills">
               <c:choose> 
                    <c:when test="${favorite}">
                        <li class="nav-item"><a href="WishlistRemove?listingNumber=${myCar.listingNumber}" class="btn btn-warning">Remove from Favorites</a></li>
                    </c:when> 
                    <c:otherwise>
                        <li class="nav-item"><a href="WishlistAdd?listingNumber=${myCar.listingNumber}" class="btn btn-success">Add to Favorites</a></li>
                    </c:otherwise>     
                </c:choose>  
        </ul>
    </div>
    
    <div class="card-body">  
        <div class="container">
                <h1>Listing <c:out value = "${myCar.listingNumber}"/></h1><hr>
                <p class="text-danger">${message}</p>
               
                <div class="row">
                    
                    <!--Image galery-->
                    <div class="col-lg-8">
                                <div id="carouselIndicators" class="carousel slide container mb-3 mt-3" data-ride="carousel">
                            <ol class="carousel-indicators">
                              <li data-target="#carouselIndicators" data-slide-to="0" class="active"></li>
                              <li data-target="#carouselIndicators" data-slide-to="1"></li>
                              <li data-target="#carouselIndicators" data-slide-to="2"></li>
                            </ol>
                            <div class="carousel-inner">
                              <div class="carousel-item active">
                                <img class="d-block w-100" src="images/Stock/Large/${myCar.listingNumber}/${myCar.listingNumber}.JPG" alt="First slide">
                              </div>
                              <div class="carousel-item">
                                <img class="d-block w-100" src="images/Stock/Large/${myCar.listingNumber}/${myCar.listingNumber}-1.JPG" alt="Second slide">
                              </div>
                              <div class="carousel-item">
                                <img class="d-block w-100" src="images/Stock/Large/${myCar.listingNumber}/${myCar.listingNumber}-2.JPG" alt="Third slide">
                              </div>
                            </div>
                            <a class="carousel-control-prev" href="#carouselIndicators" role="button" data-slide="prev">
                              <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                              <span class="sr-only">Previous</span>
                            </a>
                            <a class="carousel-control-next" href="#carouselIndicators" role="button" data-slide="next">
                              <span class="carousel-control-next-icon" aria-hidden="true"></span>
                              <span class="sr-only">Next</span>
                            </a>
                          </div>
                    </div>
                    
                    <shiro:guest>          
                    <!--car details table-->          
                    <div class="col-lg-4">
                        <table class=" table table-borderless">
                            <tbody>

                                <tr>
                                    <th>Price</th>
                                    <td><fmt:formatNumber value="${myCar.listPrice}" type="currency" currencySymbol="&euro;" maxFractionDigits="2"/></td>  
                                </tr>
                                <tr>
                                    <th>Year</th>
                                    <td><c:out value = "${myCar.year}"/></td>
                                </tr>
                                <tr>    
                                    <th>Make</th>
                                    <td><c:out value = "${myCar.make}"/></td>
                                </tr>
                                <tr>        
                                    <th>Model</th>
                                    <td><c:out value = "${myCar.model}"/></td>
                                </tr>
                                <tr>        
                                    <th>Body</th>
                                    <td><c:out value = "${myCar.body}"/></td>
                                </tr>
                                <tr>        
                                        <th>Color</th>
                                        <td><c:out value = "${myCar.colour}"/></td>
                                </tr>
                                <tr>        
                                        <th>Odometer</th>
                                        <td><c:out value = "${myCar.odometer}"/></td>
                                </tr>
                                <tr>        
                                        <th>Fuel</th>
                                        <td><c:out value = "${myCar.fuel}"/></td>
                                </tr>
                                <tr>        
                                        <th>Tax</th>
                                        <td><fmt:formatNumber value="${myCar.tax}" type="currency" currencySymbol="&euro;"/></td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                    </shiro:guest>
                      <shiro:user>            
                 <!--car details form-->          
   
                    <div class="col-lg-4">
                        
                        <input type="text" 
                           class="form-control"
                           value="${myCar.listingNumber}"
                           id="listingNumber"
                           name="listingNumber" hidden> 
                                
                        <table class=" table table-borderless">
                            <tbody>
                                
                                <tr>
                                    <th>Price (Eur)</th>
                                    <td><input type="text"
                                        class="form-control" 
                                        value="${myCar.listPrice}"
                                        id="listPrice"
                                        name="listPrice">
                                    </td>  
                                </tr>
                                <tr>
                                    <th>Year</th>
                                    <td><input type="text"
                                        class="form-control" 
                                        value="${myCar.year}"
                                        id="year"
                                        name="year" readonly>
                                    </td> 
                                </tr>
                                <tr>    
                                    <th>Make</th>
                                    <td><input type="text"
                                        class="form-control" 
                                        value="${myCar.make}"
                                        id="make"
                                        name="make" readonly>
                                    </td>
                                </tr>
                                <tr>        
                                    <th>Model</th>
                                    <td><input type="text"
                                        class="form-control" 
                                        value="${myCar.model}"
                                        id="model"
                                        name="model" readonly>
                                    </td>
                                </tr>
                                <tr>        
                                    <th>Body</th>
                                    <td><input type="text"
                                        class="form-control" 
                                        value="${myCar.body}"
                                        id="body"
                                        name="body" readonly>
                                    </td>
                                </tr>
                                <tr>        
                                    <th>Color</th>
                                    <td><input type="text"
                                        class="form-control" 
                                        value="${myCar.colour}"
                                        id="colour"
                                        name="colour">
                                    </td>
                                </tr>
                                <tr>        
                                    <th>Odometer</th>
                                    <td><input type="text"
                                        class="form-control" 
                                        value="${myCar.odometer}"
                                        id="odometer"
                                        name="odometer">
                                    </td>
                                </tr>
                                <tr>        
                                    <th>Fuel</th>
                                    <td><input type="text"
                                        class="form-control" 
                                        value="${myCar.fuel}"
                                        id="fuel"
                                        name="fuel" readonly>
                                    </td>
                                </tr>
                                <tr>        
                                    <th>Tax (Eur)</th>
                                    <td><input type="text"
                                        class="form-control" 
                                        value="${myCar.tax}"
                                        id="tax"
                                        name="tax">
                                    </td>    
                                </tr>
                            </tbody>
                        </table>
                                        
                    </div>    
                 </shiro:user>
                            
                </div>
                              
                <shiro:guest>              
                <!--description-->            
                <div class="row">
                    <div class="col-lg-12">
                        <p><c:out value = "${myCar.description}"/></p><hr>
                    </div>
                </div>
                
                <!--inquire link-->
                <div class="row">
                    <div class="col-12 text-center">    
                        <a href="underConstruction.jsp" class="btn btn-primary">Inquire</a>
                    </div>     
                 </div>        
                </shiro:guest>    
                    
                             
                
              
                    
                <shiro:user>    
                 <!--description-->            
                <div class="row">
                    <div class="col-lg-12 form-group">
                        <label for="description">Description</label>
                        <textarea class="form-control"
                                  id="description"
                                  name="description" rows="5">
                                  <c:out value = "${myCar.description}"/>    
                        </textarea>  
                    </div>
                </div>
                      
                <!--notes-->        
                <div class="row">
                    <div class="col-lg-12 form-group">
                        <label for="note">Note</label>
                        <textarea class="form-control"
                                  id="description"
                                  name="note" rows="2">
                                 <c:out value = "${myCar.note}"/>    
                        </textarea>  
                    </div>
                </div>            
                                
                <!--3 rows with radios and submit button-->    
                <div class="row">
                    
                    <!--radios-->
                    <div class="col-12">
                        <input class="form-check-input" 
                               type="radio"
                               name="sold" 
                               id="gridRadio1" 
                               value="1"
                               
                               <c:choose> 
                                    <c:when test="${myCar.sold == 1}">
                                        checked
                                    </c:when>  
                                </c:choose>        
                               >
                        <h5><label class="form-check-label" for="gridRadio1">Sold</label></h5>
                    </div>    
                    
                    <div class="col-12">
                        <input class="form-check-input"
                               type="radio"
                               name="sold"
                               id="gridRadio2"
                               value="0"
                               
                               <c:choose> 
                                    <c:when test="${myCar.sold == 0}">
                                        checked
                                    </c:when>  
                                </c:choose>  
                               
                               >
                        <h5><label class="form-check-label" for="gridRadio2">For Sale</label></h5>
                    </div><br><br>
                    
                    
                    
                    <div class="col-12 text-center">
                        <div class="text-center">
                        <button type="submit"
                            class="btn btn-warning"
                            value="submit" 
                            name="submit"
                            id="submit" >Submit</button>
                    </div>
                    
                    
                    </div>  
  
                </div>
                   
                   
                 </shiro:user>       
        </div> <!--end of container-->
    </div><!--end of -->

  </form>   
</div>
</div>
<br>

<jsp:include page="/footer.jsp" />