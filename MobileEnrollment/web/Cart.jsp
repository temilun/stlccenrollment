<%-- 
    Document   : Cart
    Created on : Oct 22, 2020, 7:04:53 PM
    Author     : tom
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="./css/cart-styles.css" />
        <link rel="icon" href="./img/stlcc-logo.jpg" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="https://fonts.googleapis.com/css2?family=Karla&family=Rubik&display=swap" rel="stylesheet"> 
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
        <script defer src="https://use.fontawesome.com/releases/v5.15.1/js/all.js" integrity="sha384-9/D4ECZvKMVEJ9Bhr3ZnUAF+Ahlagp1cyPC7h5yDlZdXs4DQ/vRftzfd+2uFUuqS" crossorigin="anonymous"></script>
        
        <title>Checkout</title>
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
            <a class="navbar-brand" href="./StudentHub.jsp">
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
                <h1 id="registrationHeader">Shopping Cart - Checkout</h1>
                <small class="pl-3">Review your courses and checkout</small>
            </div>
            <div id="mainForm" class="">
                <c:if test="${not empty msg}">
                        <div class="card border-success mb-3 mx-auto info mt-3" style="width: 95%;">
                            <div class="card-header text-success">Notification</div>
                            <div class="card-body text-success">
                                <p class="card-text">${msg}</p>
                            </div>
                        </div>  
                </c:if>
                <c:choose>
                    <c:when test="${not empty cartSections}">
                        <form action="CheckoutServlet">
                            <table class="table">
                                <tr>
                                    <th scope="col">CRN</th>
                                    <th scope="col">Title</th>
                                    <th scope="col" class="text-center">Section Info</th>
                                    <th scope="col">Delete</th>
                                </tr>
                                <c:forEach var="section" items="${cartSections}">
                                    <tr>
                                        <td style="text-align: center; vertical-align: middle;">${section.crn}</td>
                                        <td style="white-space: normal !important; vertical-align: middle;">${section.course.courseName}</td>
                                        <td style="text-align: center; vertical-align: middle;">
                                            <!-- Jon did this part -->
                                            <!-- This button links to the popup ( code for the popup is right below this button ) -->
                                            <button type="button" class="sectionHeadBtn" data-toggle="modal" data-target="#Modal${section.course.courseId}">
                                               <i class="fas fa-info-circle fa-sm" style="padding-top:-20px;"></i>
                                            </button>
                                        </td>
                                        <td style="text-align:center; vertical-align: middle;"><a href="<%=request.getContextPath()%>/DeleteSection?delete=${section.crn}"><i class="fas fa-trash-alt"></i></a></td>
                                    </tr>
                                    <!-- Modal (Popup) | for more info on Bootstrap modals go here: https://getbootstrap.com/docs/4.0/components/modal/ -->

                                        <div class="modal fade" id="Modal${section.course.courseId}" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
                                            <div class="modal-dialog modal-dialog-centered" role="document">
                                                <div class="modal-content">
                                                    <div class="modal-header">
                                                        <h3 class="modal-title" id="exampleModalLongTitle">${section.course.courseName}</h3>
                                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                          <span aria-hidden="true">&times;</span>
                                                        </button>
                                                    </div>
                                                    <div class="modal-body">
                                                        <p>${section.course.courseDesc}</p>
                                                        <h4><strong>Section Information:</strong></h4>
                                                        <h6>Course Code: ${section.course.subAbbrev} ${section.course.courseLevel}</h6>
                                                        <h6>CRN: ${section.crn}</h6>
                                                        <h6>Professor: ${section.professor.profFname} ${section.professor.profLname}</h6>
                                                        <c:if test="${not empty section.days}"><h6>Days of the week: ${section.days}</h6></c:if>
                                                        <c:if test="${not empty section.startTime}">
                                                            <h6>Time: <fmt:formatDate type="time" timeStyle="short" pattern="h:mma" value="${section.startTime}" /> - <fmt:formatDate type="time" timeStyle="short" pattern="h:mma" value="${section.endTime}" /></h6>
                                                        </c:if>
                                                        <h6>Credit Hours: ${section.course.courseCredit}</h6>
                                                    </div>
                                                    <div class="modal-footer">
                                                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                                    </div>
                                                </div>
                                            </div>
                                        </div> 
                                </c:forEach>
                            </table>




                            <div class="text-center">
                                <input type="submit" value="Checkout" id="searchBtn">    
                            </div>
                        </form>
                    </c:when>
                    <c:otherwise>
                        <hr>
                        <div class="text-center">
                            <h5 class="my-5">Your cart is empty!</h5>
                        </div>
                    </c:otherwise>
                </c:choose>

                
                <div class="text-center" id="links">
                    <a href="./EnrollmentHome.jsp">Back to Enrollment Home</a>
                </div> 
                
                
            </div>
        </div>
        
        <script src="./js/displaySections.js"></script>
    </body>
    </c:if>
</html>
