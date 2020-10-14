<%-- 
    Document   : SelectClasses
    Description: Webpage to select classes from department selected on previous page
    Created on : Sep 27, 2020, 9:09:30 PM
    Author     : tom
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
 <html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="./css/selectClasses-styles.css" />
        <link rel="icon" href="./img/stlcc-logo.jpg" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="https://fonts.googleapis.com/css2?family=Karla&family=Rubik&display=swap" rel="stylesheet"> 
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
        
        
        <title>Enrollment Home - Search for classes</title>
        </style>

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
                      <a class="nav-link" href="<%=request.getContextPath()%>/StudentHub.jsp">Student Hub</a>
                  </li>
                  <li class="nav-item">
                      <a class="nav-link" href="<%=request.getContextPath()%>/Logon.jsp">Logout</a>
                  </li>
                </ul>
            </div>
        </nav>  
        
        <div class="registrationContainer">
            <div>
                <h1 id="registrationHeader">Select Classes</h1>
                <hr>
            </div>
            <div id="mainForm">
                
                <script>
                    //js to enable the 'display classes' button only after the
                    //checkboxes are checked
                    let enableBtn = () => {
                        document.getElementById('disabledBtn').id = 'searchBtn';
                    };
                </script>
                
                <!-- this form will take input from the user to find what classes
                     are going to be searched -->
                
                <form action="DisplayClasses">
                    <div class="sectionHead">
                        <h3>Sections</h3>
                        <small id="crsTip" class="form-text text-muted">
                            Select your class sections to add to your cart.
                        </small>
                    </div>
                    
                    <!-- This is where the sections are displayed -->
                    <!-- A 'for each' loop is ran with the JSTL library-->
                    <!-- to run through our list section objects -->
                    <!-- info on JSTL foreach can be found here:       -->
                    <!-- https://www.tutorialspoint.com/jsp/jstl_core_foreach_tag.htm -->
                    <ul id="courseSelection" class="btn-group">
                        <table border=1 align=center style="text-align:center">
                        <thead>    
                            <tr>
                                <th>CRN</th>
                                <th>Course Name</th>
                                <th>Day</th>
                                <th>Start Time</th>
                                <th>Start End</th>
                                <th>Status</th>
                                <th>Available Slots</th>
                                <th>Total Enrolled</th>
                            </tr>
                        </thead>
                        <c:forEach var="section" items="${sections}">
                            <li>                                    
                                  <input id="${section.crn}" class="crsCheckbox" type="checkbox" id="${section.crn}" name="checked" value="${section.course.courseName}" onclick="enableBtn();"/>
                                  <label class="checkLabel" for='${section.crn}'> 
                                      
       
                        <tr>
                    <td><c:out value="${section.crn}" /></td>
                    <td><c:out value="${section.course.courseName}" /></td>
                    <td><c:out value="${section.days}" /></td>
                    <td><c:out value="${section.startTime}" /></td>
                    <td><c:out value="${section.endTime}" /></td>
                    <td><c:out value="${section.status}" /></td>
                    <td><c:out value="${section.enrollAvail}" /></td>
                    <td><c:out value="${section.enrollTot}" /></td>
                        </tr>
                        </table>
                                     <!-- ${section.crn} ${section.course.courseName} ${section.days} ${section.startTime} ${section.endTime} ${section.status} ${section.enrollAvail} ${section.enrollTot}</label>      --!>                              
                            </li>
                            </tr>
                        
                            <!--<li>
                                <p>${section.crn} ${section.course.courseName}</p>
                            </li>-->
                            </li>
                        </c:forEach>
                    </ul>         
                    
                        <div class="text-center">
                            <input type="submit" value="Add selected Classes to Cart" id="disabledBtn">    
                        </div>
                                     
                        <div class="text-center" id="links">
                            <a href="./EnrollmentHome.jsp">Back to Enrollment Home</a>
                        </div> 
                    
                </form>
            </div>
        </div>
        ${msg}
    </body>
    </c:if>
</html>
