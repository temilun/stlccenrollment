<%-- 
    Document   : EnrollmentHome
    Description: This is where the student is taken if they press the "Class Registration" button. It will serve as a course search tool.
    Author     : tom
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
 <html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="./css/enrollmentHome-styles.css" />
        <link rel="icon" href="./img/stlcc-logo.jpg" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="https://fonts.googleapis.com/css2?family=Karla&family=Rubik&display=swap" rel="stylesheet"> 
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
        
        <script src="./js/enrollmentHome.js"></script>
        <title>Enrollment Home - Search for classes</title>
        </style>

    </head>
    <c:if test="${!s.authenticated} ">
        <script type="text/javascript">
            window.location = "/MobileEnrollment/Logon.jsp";
            </script>
        </c:if>
    <c:if test="${s.authenticated}">
    <body>
        <nav class="navbar navbar-light bg-light">
            <a class="navbar-brand" href="#">
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
                      <a class="nav-link" href="/StudentHub.jsp">Student Hub</a>
                  </li>
                  <li class="nav-item">
                      <a class="nav-link" href="<%=request.getContextPath()%>/Logon.jsp">Logout</a>
                  </li>
                </ul>
            </div>
        </nav>  
        
        <div class="registrationContainer">
            <div>
                <h1 id="registrationHeader">Registration</h1>
                <hr>
            </div>
            <div id="mainForm">
                <form action="SelectClasses">
                    <div  id="sectionHead">
                        <h3>Select a Term</h3>
                    </div>
                    <ul id="termSelection" class="btn-group">
                        <li>
                            <input id="spring21" class="termbtn" type="radio" id="spring21" name="term" value="spring21" onclick="enableBtn();" required/>
                            <label id="termLabel" for="spring21">Spring 2021</label>
                        </li>
                        <li>
                            <input id="summer21" class="termbtn" type="radio" id="summer21" name="term" value="summer21" onclick="enableBtn();" required/>
                            <label id="termLabel" for="summer21">Summer 2021</label>
                        </li>
                        <li>
                            <input id="fall21" class="termbtn" type="radio" id="fall21" name="term" value="fall21" onclick="enableBtn();" required/>
                            <label id="termLabel" for="fall21">Fall 2021</label>
                        </li>
                    </ul>
                    
                    <div id="sectionHead">
                        <h3>Select Your Program</h3>
                    </div>
                    
                    <div class="deptSelect" style="width:80%;">
                        <select id="progID" name="progID">
                            <option value="0">Select your degree or program</option>
                            <c:forEach var='prog' items='${progs}'>
                                <option value="${prog.progId}">${prog.progName}</option>
                            </c:forEach>    
                        </select>
                    </div>
                    <div class="text-center">
                        <input type="submit" value="Search for courses" id="disabledBtn">    
                    </div>                    
                </form>              
            </div>
        </div>
        <div class="text-center" id="links">
            <a href="./StudentHub.jsp">Back to Student Hub</a>
        </div>
        ${msg}
    </body>
    </c:if>
</html>
