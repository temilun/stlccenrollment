<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
 <html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="./css/studentHub-styles.css" />
        <link rel="icon" href="./img/stlcc-logo.jpg" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="https://fonts.googleapis.com/css2?family=Karla&family=Rubik&display=swap" rel="stylesheet"> 
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
        
        <script src="./js/profilePicInitials.js"></script>
        <title>${s.stuFname} ${s.stuLname}</title>

    </head>
    <c:if test="${!s.authenticated} ">
        <script type="text/javascript">
            window.location = "/Logon.jsp";
            </script>
        </c:if>
    <c:if test="${s.authenticated}">
    <body>
        <nav class="navbar navbar-light bg-light">
            <a class="navbar-brand" href="/StudentHub.jsp">
                <img src="./img/stlcc-logo.jpg" width="30" height="30" alt="" loading="lazy">
            </a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">
                  <li class="nav-item active">
                    <a class="nav-link" href="https://stlcc.edu">STLCC Home<span class="sr-only">(current)</span></a>
                  </li>
                  <li class="nav-item">
                    <a class="nav-link" href="https://selfservice.stlcc.edu:9199/SLCC/twbkwbis.P_WWWLogin">Classic Banner</a>
                  </li>
                  <li class="nav-item">
                      <a class="nav-link" href="<%=request.getContextPath()%>/Cart.jsp">Cart (${cartSections.size()})</a>
                  </li>
                  <li class="nav-item">
                      <a class="nav-link" href="<%=request.getContextPath()%>/Logout">Logout</a>
                  </li>
                </ul>
            </div>
        </nav>
        
       
        <div>
            <h1 class="text-center" id="profileImage"></h1>
        </div>
        
        <h1 id="studentName" class="h3">${s.stuFname} ${s.stuLname}</h1>
        <div class="text-center">${s.stuId}</div>
        <div class="text-center">
            <form action="EnrollmentHome">
                <input type="submit" value="Class Registration" id="regBtn">
            </form>
        </div>
            
        <c:if test="${not empty msg}">
            <div class="card bg-light mb-3 mx-auto info">
                <div class="card-header">Notification</div>
                <div class="card-body">
                    <p class="card-text">${msg}</p>
                </div>
            </div>  
        </c:if>
            

        <div class="card bg-light mb-3 mx-auto info">
            <div class="card-header">Welcome to the STLCC Registration Portal!</div>
            <div class="card-body">
                <p class="card-text">To register for the Spring 2021 term, please start by clicking the "Class Registration" button above.</p>
            </div>
        </div>
        
        <div class="card bg-light mb-3 mx-auto info">
            <div class="card-header">Need more help?</div>
            <div class="card-body">
                <p class="card-text">Your academic advisor would be happy to 
                    assist you via email or a live online meeting. To find out 
                    more information about your advisor, click 
                    <a href="https://stlcc.edu/admissions/advising/virtual-advising.aspx" target="_blank">
                        HERE!
                    </a></p>
            </div>
        </div>     
    </body>
    </c:if>
</html>