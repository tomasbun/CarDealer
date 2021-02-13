<%-- 
    Document   : header
    Created on : 3 Nov 2020, 22:10:59
    Author     : Tomas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>Moylish Car Dealer</title>
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://cdn.datatables.net/1.10.22/css/dataTables.bootstrap4.min.css">
        <link rel = "stylesheet" type = "text/css" href = "css/style.css" />
    </head>

    <body class="bg-light text-dark mainBody">
        <header>
            <img src="images/web/header.jpg" class="img-fluid" alt="Responsive image">
            <nav class="navbar navbar-expand-md navbar-dark bg-dark">

                <div class="mx-auto order-0">
                    <a class="navbar-brand mx-auto" href="index.jsp">Moylish Motors</a>
                    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target=".dual-collapse2">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                </div>



                <div class="navbar-collapse collapse w-100 order-1 order-md-0 dual-collapse2">
                    <ul class="navbar-nav mr-auto">

<!---------------------------- Customer area ---------------------------------->
                        <li class="nav-item dropdown">

                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" 
                               aria-haspopup="true" aria-expanded="false">Cars</a>

                            <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <a class="dropdown-item" href="DisplayAllCars">View Listings</a>
                                <div class="dropdown-divider"></div>
                                <a class="dropdown-item" href="WishlistAdd">Wishlist</a>
                            </div>
                        </li>

  <!--------------------------  Sales area ------------------------------------>                        
                        <shiro:hasAnyRoles name="0, 1">
                            <li class="nav-item dropdown">

                                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown"
                                   aria-haspopup="true" aria-expanded="false">Sales</a>

                                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                    <a class="dropdown-item" href="SalesShowAll">Sales</a>
                                    <div class="dropdown-divider"></div>
                                    <a class="dropdown-item" href="underConstruction.jsp">Queries</a>
                                </div>
                            </li>
                        </shiro:hasAnyRoles> 
                            
 <!------------------------Administration menu -------------------------------->                            
                        <shiro:hasRole name="1">
                            <li class="nav-item dropdown">

                                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown"
                                   aria-haspopup="true" aria-expanded="false">Administration</a>

                                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                    <a class="dropdown-item" href="DisplayAllStaff">Staff</a>
                                    <div class="dropdown-divider"></div>
                                    <a class="dropdown-item" href="CreateStaff.jsp">Add New</a>
                                </div>
                            </li>
                        </shiro:hasRole>    

                            
<!---------------------------  login link ------------------------------------>                            
                        <shiro:guest>
                            <li class="nav-item">
                                <a class="nav-link" href="login.jsp">Login</a>
                            </li>
                        </shiro:guest>            
                    </ul>
                </div>

<!-- ------------------------ Staff details -------------------------------- -->
                <shiro:user>

                    <div class="navbar-collapse collapse w-100 order-1 order-md-0 dual-collapse2">
                 
                        <ul class="navbar-nav ml-auto">
                    
                            
                            
                            
                        <!--///////////////////////////////////////////////////////-->
                            <li><img class="roundImg" src="images/Sales People/${cookie.currentStaff.value.replace("-", " ")}.jpg"
                                                                   onerror="this.onerror=null; this.src='images/Sales People/unknown.png'"
                                                                   alt="No image found"/></li>    
                            <shiro:user>
                            <li class="nav-item dropdown">
                                <!--///////////////////////////////////////////////-->
                                <a class="nav-link dropdown-toggle"
                                   href="#"
                                   id="navbarDropdown"
                                   role="button"
                                   data-toggle="dropdown"
                                   aria-haspopup="true"
                                   aria-expanded="false">
                                   
                                    <shiro:principal/>
                                    
                                </a>
                               
                                <!--///////////////////////////////////////////////////-->
                                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                    <a class="dropdown-item" href="upload.jsp">Upload Picture</a>
                                    <div class="dropdown-divider"></div>
                                    <a class="dropdown-item" href="changePassword.jsp">Change Password</a>
                                    <div class="dropdown-divider"></div>
                                    <a class="dropdown-item" href="/Assignment2/logout">Log Out</a>
                                </div>
                            </li>
                            </shiro:user> 
                            
                        </ul>
                    </div>
                </shiro:user>
            </nav>          


        </header>
