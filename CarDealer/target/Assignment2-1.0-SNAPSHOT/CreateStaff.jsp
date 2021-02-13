<%-- 
    Document   : CreateStaff
    Created on : 21 Nov 2020, 21:20:40
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
                <img src="images/Sales People/unknown.png"/>
                <h5 class="card-title">New Employee</h5>
            </div>
            <p class="text-danger">${message}</p>
            <form name="StaffDetails" action="CreateStaff" method="POST">
               
                <div class="form-group">
                    <label for="fullName">Full Name:</label>
                    <input type="text"
                           class="form-control"
                           placeholder ="i.e John Doe"
                           value="${fullName}"
                           id="fullName"
                           name="fullName">
                </div>
                
                <div class="form-group">
                    <label for="email">Email:</label>
                    <input type="email" 
                           class="form-control"
                           placeholder ="i.e example@hotmail.com" 
                           value="${email}"
                           id="email" 
                           name="email">
                </div>

                <div class="form-group">
                    <label for="phone">Phone:</label>
                    <input type="text"
                           class="form-control"
                           placeholder ="i.e 085 461379"
                           value="${phone}"
                           id="phone"
                           name="phone">
                </div>
                
                 <div class="form-group">
                    <label for="fax">Fax:</label>
                    <input type="text" 
                           class="form-control"
                           placeholder ="i.e 085 461379"
                           value="${fax}"
                           id="fax"
                           name="fax">
                </div>

                <div class="form-group">
                    <label for="admin">Department:</label>
                        <select class="form-control" id="admin" name="admin">
                                    <option value="true">Administration</option>
                                    <option value="false">Sales</option>                           
                        </select>
                </div>

                <div class="text-center">
                    <button type="submit"
                            class="btn btn-secondary"
                            value="submit" 
                            name="submit"
                            id="submit" >Submit</button>
                </div>
                

            </form>

        </div>

    </div>


</div>

<jsp:include page="/footer.jsp" />


