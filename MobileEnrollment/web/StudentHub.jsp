<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
        <script defer src="https://use.fontawesome.com/releases/v5.15.1/js/all.js" integrity="sha384-9/D4ECZvKMVEJ9Bhr3ZnUAF+Ahlagp1cyPC7h5yDlZdXs4DQ/vRftzfd+2uFUuqS" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        
        <script src="./js/profilePicInitials.js"></script>
        <title>${s.stuFname} ${s.stuLname}</title>

    </head>
    <c:if test="${!s.authenticated} ">
        <script type="text/javascript">
            window.location.href = "/Logon.jsp";
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
                      <a class="nav-link active" href="<%=request.getContextPath()%>/StudentHub.jsp">Student Hub<span class="sr-only">(current)</span></a>
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
        
       
        <div class="pt-3">
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
            <div class="card border-success mb-3 mx-auto info">
                <div class="card-header text-success">Notification</div>
                <div class="card-body text-success">
                    <p class="card-text">${msg}</p>
                </div>
            </div>  
        </c:if>
            
        <c:if test="${not empty schedule}">
            <c:set var="times" value="${fn:split('8,9,10,11,12,1,2,3,4,5,6,7,8,9', ',')}" scope="application" />

            <c:set var="days" value="${fn:split('M,T,W,R,F', ',')}" scope="application" />
            <div class="card bg-light mb-3 mx-auto info">
                <div class="card-header d-flex justify-content-between">
                    Week at a Glance
                    <i class="far fa-calendar-alt fa-lg"></i>
                </div>
                <div class="card-body">
                    <table class="" id="calendar">
                        <thead>
                            <tr class="calhead">
                                <th id="time"></th>
                                <th id="spacer"></th>
                                <c:forEach var="time" items="${times}">
                                    <th id="time">${time}</th>
                                </c:forEach>

                            </tr>
                        </thead>
                        <c:forEach var="day" items="${days}">
                            <tr>
                                <td></td>
                            </tr>
                            <tr>
                                <td id="day">${day}</td>
                                <td></td>
                                <c:forEach begin="8" end="22" varStatus="time">
                                    <td id="${day}${time.index}" 

                                    <c:forEach var="enr" items="${schedule}">
                                        <c:choose>
                                            <c:when test="${(fn:contains(enr.section.days, day) && fn:substring(enr.section.startTime, 0, 2) == time.index)
                                                            || ((fn:contains(enr.section.days, day) && fn:substring(enr.section.endTime, 0, 2) == time.index)) 
                                                            || ((fn:contains(enr.section.days, day) && (fn:substring(enr.section.startTime, 0, 2) < time.index) && (fn:substring(enr.section.endTime, 0, 2)) > time.index))}">
                                                    style="background-color: #${enr.section.crn}c" 
                                                    onclick='alert(
                                                        "Class Information \n \nClass: ${enr.section.course.courseName} \nDays: ${enr.section.days} \nTime: <fmt:formatDate type="time" timeStyle="short" pattern="h:mma" value="${enr.section.startTime}" /> - <fmt:formatDate type="time" timeStyle="short" pattern="h:mma" value="${enr.section.endTime}" />\nCampus: ${enr.section.campus.campName}\nBuilding: ${enr.section.room.building.buildName}\nRoom: ${enr.section.room.roomId}");'
                                            </c:when>
                                            <c:otherwise>
                                            </c:otherwise>
                                        </c:choose>
                                    </c:forEach>
                                    ></td>
                                </c:forEach>
                            </tr>
                        </c:forEach>
                    </table>            
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

                    </a>
                    <br>
                    To email your advisor directly, click <a href="" data-toggle="modal" data-target="#modalContactForm">HERE!</a>
                        <div class="modal fade" id="modalContactForm" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                            <div class="modal-dialog" role="document">
                                <div class="modal-content">
                                    <div class="modal-header text-center">
                                        <h4 class="modal-title w-100 font-weight-bold">Write to us</h4>
                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                            <span aria-hidden="true">&times;</span>
                                        </button>
                                    </div>
                                    <div class="modal-body mx-3">

                                    <div class="modal-body mx-3 text-center">
                                        <div class="md-form mb-5">
                                            <i class="fas fa-user prefix grey-text"></i>
                                                <input type="text" id="form34" class="form-control validate"value='${s.stuFname} ${s.stuLname}' disabled>
                                                    <label data-error="wrong" data-success="right" for="form34">Your name</label>
                                        </div>
                                                                        
                                        <div class="md-form mb-5">
                                            <i class="fas fa-envelope prefix grey-text"></i>
                                            <input type="email" id="form29" class="form-control validate" value='${s.stuEmail}' disabled>
                                            <label data-error="wrong" data-success="right" for="form29">Your email</label>
                                        </div>

                                        <div class="md-form mb-5">
                                            <i class="fas fa-tag prefix grey-text"></i>
                                            <input type="text" id="form32" class="form-control validate">
                                            <label data-error="wrong" data-success="right" for="form32">Subject</label>
                                        </div>

                                        <div class="md-form">
                                            <i class="fas fa-pencil-alt"></i>
                                            <textarea type="text" id="form8" class="md-textarea form-control" rows="4"></textarea>
                                            <label data-error="wrong" data-success="right" for="form8">Your message</label>
                                        </div>

                                    </div>
                                        <div class="modal-footer d-flex justify-content-center">
                                            <button class="btn btn-unique">Send <i class="far fa-paper-plane"></i></button>
                                                </div>
                                        </div>
                                    </div>
                                </div>

                </p>
            </div>
        </div>     
    </body>
    </c:if>
</html>