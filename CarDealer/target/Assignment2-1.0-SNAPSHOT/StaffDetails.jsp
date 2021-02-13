<%-- 
    Document   : StaffDetails
    Created on : 21 Nov 2020, 10:40:37
    Author     : Tomas
--%>

<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="/header.jsp" />

<div class="container center">

    <div class="card mb-3 bg-light text-dark">
        
        <div class="card-body">
            
            <div class="text-center">
                <img src="images/Sales People/${s.fullName}.jpg" onerror="this.onerror=null; this.src='images/Sales People/unknown.png'" />
                <h5 class="card-title">${s.fullName}</h5>
            </div>
            <p class="text-danger">${message}</p>
            <form name="StaffDetails" action="UpdateStaff" enctype="multipart/form-data">

                <div class="form-group">
                    <input type="text" 
                           class="form-control"
                           value="${s.staffID}"
                           id="staffID"
                           name="staffID" hidden>
                </div>
                
                <div class="form-group">
                    <label for="fullName">Full Name:</label>
                    <input type="text"
                           class="form-control" 
                           value="${s.fullName}"
                           id="fullName"
                           name="fullName">
                </div>
                
                <div class="form-group">
                    <label for="email">Email:</label>
                    <input type="email" 
                           class="form-control"
                           value="${s.email}" 
                           id="email" 
                           name="email">
                </div>

                <div class="form-group">
                    <label for="phone">Phone:</label>
                    <input type="text"
                           class="form-control"
                           value="${s.phone}"
                           id="phone"
                           name="phone">
                </div>
                
                 <div class="form-group">
                    <label for="fax">Fax:</label>
                    <input type="text" 
                           class="form-control"
                           value="${s.fax}" 
                           id="fax"
                           name="fax">
                </div>

                <div class="form-group">
                    <label for="admin">Department:</label>
                        <select class="form-control" id="admin" name="admin">
                            
                            <c:choose> 
                                <c:when test="${s.admin == 1}">
                                    <option value="true">Administration</option>
                                    <option value="false">Sales</option>
                                </c:when> 
                                <c:otherwise>
                                    <option value="false">Sales</option>
                                    <option value="true">Administration</option>
                                </c:otherwise>     
                            </c:choose> 
                            
                            
                        </select>
                </div>
                
                <div class="form-group form-check">
                    <label class="form-check-label">
                        <input class="form-check-input"
                               type="checkbox"
                                 id="resetPassword"
                               name="resetPassword">Reset Password</label>
                </div>

                <div class="text-center">
                    <button type="submit"
                            class="btn btn-secondary"
                            value="submit" 
                            name="submit"
                            id="submit" >Submit</button>
                            <button type="button" class="btn btn-danger" 
                                    onclick="window.location='DeleteStaff?staffID=${s.staffID}'">Remove</button>
                </div>
                

            </form>

        </div>

    </div>


</div>

<jsp:include page="/footer.jsp" />

