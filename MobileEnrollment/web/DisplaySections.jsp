<%-- 
    Document   : SelectClasses
    Description: Webpage to select classes from department selected on previous page
    Created on : Sep 27, 2020, 9:09:30 PM
    Author     : tom
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>


 <html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="./css/selectSections-styles.css" />
        <link rel="icon" href="./img/stlcc-logo.jpg" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="https://fonts.googleapis.com/css2?family=Karla&family=Rubik&display=swap" rel="stylesheet"> 
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
        <script defer src="https://use.fontawesome.com/releases/v5.15.1/js/all.js" integrity="sha384-9/D4ECZvKMVEJ9Bhr3ZnUAF+Ahlagp1cyPC7h5yDlZdXs4DQ/vRftzfd+2uFUuqS" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        
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
                  <li class="nav-item">
                      <a class="nav-link" href="<%=request.getContextPath()%>/StudentHub.jsp">Student Hub</a>
                  </li>
                  <li class="nav-item">
                      <a class="nav-link" href="<%=request.getContextPath()%>/Cart.jsp">Cart <c:if test="${not empty cartSections}">(${cartSections.size()})</c:if></a>
                  </li>
                  <li class="nav-item">
                      <a class="nav-link" href="<%=request.getContextPath()%>/MySchedule.jsp">My Classes</a>
                  </li>
                  <li class="nav-item">
                    <a class="nav-link" href="https://stlcc.edu">STLCC Home</a>
                  </li>
                  <li class="nav-item">
                    <a class="nav-link" href="https://selfservice.stlcc.edu:9199/SLCC/twbkwbis.P_WWWLogin">Classic Banner</a>
                  </li>
                  <li class="nav-item">
                      <a class="nav-link" href="<%=request.getContextPath()%>/Logout">Logout</a>
                  </li>
                </ul>
            </div>
        </nav>  
        
        <div class="registrationContainer">
            <div>
                <h1 id="registrationHeader">Select Sections</h1>
                <small class="pl-3">Select up to one section from each course</small>
            </div>
            <div id="mainForm" class="pt-3">
                
               
                
                <!-- this form will take input from the user to find what classes
                     are going to be searched -->
                
                <form action="AddToCart">                    
                  
                    
            <!--    The way I have set this up is pretty messy and definitely
                    confusing. I will try to explain what's happening:
                
                  - For each course in our list of courses pinned to the session
                    (when using 'search by program' all courses in the 'program'
                    are the courses pinned to the session), check to see if any
                    of the course IDs that the user selected match
                
                  - If a course matches one of the IDs that the user selected on
                    the previous page, create a heading for that course.
                
                  - After the heading is created, a table is made and table headings are
                    filled with the titles of each column (Course name is omitted
                    as it is being displayed above the table)
                
                  - Next another forEach loop is ran to find each section that
                    checks if there are any sections with course IDs that match with
                    the current course ID that is being used. -->
            
                    <c:forEach var="course" items="${courses}">
                        <c:forEach var="id" items="${courseIDs}">
                            <c:if test='${course.courseId eq id}'>
                                <div class="sectionHead pt-4">
                                    <table style="width: 100%; padding-bottom: 20px">
                                        <tr>
                                            <td style="font-size: 1.5em;" colspan="3">${course.courseName}</td>
                                            <td colspan="1" class="mx-auto">
                                                <!-- This button links to the popup ( code for the popup is right below this button ) -->
                                                <button type="button" class="sectionHeadBtn" data-toggle="modal" data-target="#Modal${course.courseId}">
                                                    <i class="fas fa-info-circle fa-sm"></i>
                                                </button>
                                            </td>
                                        </tr>
                                    </table>
                                    
                                </div>
                                 <!-- Modal (Popup) | for more info on Bootstrap modals go here: https://getbootstrap.com/docs/4.0/components/modal/ -->
                                <div class="modal fade" id="Modal${course.courseId}" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
                                    <div class="modal-dialog modal-dialog-centered" role="document">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <h5 class="modal-title" id="exampleModalLongTitle">${course.courseName}</h5>
                                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                  <span aria-hidden="true">&times;</span>
                                                </button>
                                            </div>
                                            <div class="modal-body">
                                                <p>${course.courseDesc}</p>
                                                <h5>Credit Hours: ${course.courseCredit}</h5>
                                            </div>
                                            <div class="modal-footer">
                                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="text-center">
                                    <table class="table table-hover table-sm">
                                        <thead>    
                                            <tr>
                                                <th style="text-align: center; vertical-align: middle;" scope="col"><i class="fas fa-check"></i></th>
                                                <th style="text-align: center; vertical-align: middle;" scope="col">CRN</th>
                                                <th style="text-align: center; vertical-align: middle;" scope="col">Day(s)</th>
                                                <th style="text-align: center; vertical-align: middle;" scope="col">Time</th>
                                                <th style="text-align: center; vertical-align: middle;" scope="col">Section Type</th>
                                                <th style="text-align: center; vertical-align: middle;" scope="col">Avail.</th>
                                                <th style="text-align: center; vertical-align: middle;" scope="col">Term Type</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                    <c:forEach var="section" items="${sections}">
                                            <c:if test='${section.courseId eq course.courseId}'>
                                                <tr onclick="selectRow(${section.crn})">
                                                    <td style="text-align: center; vertical-align: middle;"><input type="radio" class="radioBtn" name="${section.courseId}" id="${section.crn}" value="${section.crn}"</td>
                                                    <td style="text-align: center; vertical-align: middle;">${section.crn}</td>
                                                    <td style="text-align: center; vertical-align: middle;">${section.days}</td>
                                                    <td style="text-align: center; vertical-align: middle;" class="text-center">
                                                        <c:choose>
                                                            <c:when test="${not empty section.startTime}">
                                                                <fmt:formatDate type="time" timeStyle="short" pattern="h:mma" value="${section.startTime}" />
                                                                <br>-<br>
                                                                <fmt:formatDate type="time" timeStyle="short" pattern="h:mma" value="${section.endTime}" />
                                                            </c:when>
                                                            <c:otherwise>
                                                                <br><br><br>
                                                            </c:otherwise>
                                                        </c:choose>
                                                    </td>
                                                    <td style="text-align: center; vertical-align: middle;">${section.secType}</td>
                                                    <td style="text-align: center; vertical-align: middle;">${section.enrollAvail}</td>
                                                    <td style="text-align: center; vertical-align: middle;">
                                                        <c:if test="${section.termType == 'FT'}">
                                                            Full Term
                                                        </c:if>
                                                        <c:if test="${section.termType == '1H'}">
                                                            First Half
                                                        </c:if>
                                                        <c:if test="${section.termType == '2H'}">
                                                            Second Half
                                                        </c:if>
                                                        <c:if test="${section.termType == '12W'}">
                                                            12 Week
                                                        </c:if>
                                                        <c:if test="${section.termType == 'SOS'}">
                                                            Spring Off Schedule
                                                        </c:if>
                                                    </td>                                                    
                                                </tr>
                                        </c:if>
                                    </c:forEach>
                                    </tbody>
                                    </table>
                                </div>
                            </c:if>
                        </c:forEach>
                    </c:forEach>
                 
                            
                    
            </div>
                        
            <div class="text-center">
                <input type="submit" value="Add Selected Sections to Cart" id="disabledBtn">    
            </div>
            </form>  
           

            <div class="text-center" id="links">
                <a href="./EnrollmentHome.jsp">Back to Enrollment Home</a>
            </div> 
            </div>
        ${msg}
        <script src="./js/displaySections.js"></script>
    </body>
    </c:if>
</html>