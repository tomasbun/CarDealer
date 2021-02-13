<%-- 
    Document   : index
    Created on : 2 Nov 2020, 3:13:34
    Author     : Tomas
--%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="/header.jsp" />

        <div class="container center">


            <shiro:guest> 
                <div class="card mb-3 bg-light text-dark">
                    

                    <div class="card-body">

                        <h5 class="card-title">Login</h5>
                        <p>${message}</p>
                        <c:if test="${shiroLoginFailure != null}">
                            <p class="card-text"><small class="text-muted">Incorrect credentials provided.</small></p>
                        </c:if>
                            <p class="card-text"><small class="text-muted">${error}</small></p>

                        <form name="Login" action="login" method="post"> 

                            <div class="form-group">
                                <label for="email">Email address:</label>
                                <input type="text" class="form-control" placeholder="Enter email" id="username" name="username">
                            </div>

                            <div class="form-group">
                                <label for="pwd">Password:</label>
                                <input type="password" class="form-control" placeholder="Enter password" id="password" name="password">
                            </div>

                            <div class="form-group form-check">
                                <label class="form-check-label"><input class="form-check-input" type="checkbox" id="rememberMe" name="rememberMe"> Remember me</label>
                            </div>

                            <button type="submit" class="btn btn-secondary" value="submit" name="submit" id="submit" >Submit</button>
                          
                        </form>

                    </div>

                </div>

            </shiro:guest>    
        </div>

<jsp:include page="/footer.jsp" />


