<%-- 
    Document   : changePassword
    Created on : 26 Nov 2020, 17:05:38
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
                <img src="images/web/keys.png"/>
               
                <h5 class="card-title">Change Password</h5>
                <p class="text-danger">${message}<p>
            </div>

            <form name="StaffDetails" action="changePassword" method="POST">

                <input type="email" id="email" value="<shiro:principal/>" name="email" hidden>
                
                
                <div class="form-group">
                    <label for="oldPassword">Old password</label>
                    <input type="password"
                           class="form-control"
                           id="oldPassword"
                           name="oldPassword">
                </div>

                <div class="form-group">
                    <label for="newPassword">New Password</label>
                    <input type="password" 
                           class="form-control" 
                           id="newPassword" 
                           name="newPassword">
                </div>
                
                 <div class="form-group">
                    <label for="newPassword2">Repeat New Password</label>
                    <input type="password" 
                           class="form-control" 
                           id="newPassword2" 
                           name="newPassword2">
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
