<%-- 
    Document   : GetInTouch
    Created on : 20 Nov 2020, 17:15:24
    Author     : Tomas
--%>

<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="/header.jsp" />

<div class="container">        

    
    <div class="row">
        <div class="col-sm-6">
            
            <div>
                <h1>Our Team</h1>
                <h5>We enjoy working together to bring our cutomer quality and assurance for 
                    satisfactcion guaranteed wellcome and no sale pressure finance assisnate we are here to help</h5>
            </div><hr>
            
            <c:forEach var="e" items="${list}" >  
            <div class="row">
              
                
                <div class="col-xs-4 d-flex flex-wrap align-items-center">
                    <img src="images/Sales People/${e.fullName}.jpg"/>
                </div>
                
                <div class="col-xs-4">    
                    <table>
                        <tr><td><i class="material-icons">person</i></td>
                            <td>${e.fullName}</td></tr>
                        
                        <tr><td><i class="material-icons">&#xe0be;</i></td>
                            <td><a class="text-dark" href="mailto:${e.email}">${e.email}</a></td></tr>
                        
                        <tr><td><i class="material-icons">phone_in_talk</i></td>
                            <td>${e.phone}</td></tr>
                                               
                    </table>
                </div>
                 
                
            </div>
            </c:forEach> 
        </div>
        
        <!--address and map-->
        <div class="col-sm-6">
            
            <div><h1>Address</h1>
                <p>Moylish Motors</p>
                <p>Moylish, Limerick, V94 EC5T<p>
                <p>Co. Limerick, ireland</p>    
            </div>
            
            <div class="panel">
                <div class="panel-heading"><h3> </h3></div>
                <div class="panel-body">
                    <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d2419.1700070689367!2d-8.650688784721032!3d52.674967732486174!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x485b5cf73a3da16d%3A0xf55474500d42913!2sLIT!5e0!3m2!1sen!2sie!4v1578583737840!5m2!1sen!2sie" width="80%" height="200" frameborder="0" style="border:0;" allowfullscreen="yes"></iframe>
                </div>
            </div>         
            
        </div>
        
    </div><br>    
    

              


      
</div>
   

<jsp:include page="/footer.jsp" />