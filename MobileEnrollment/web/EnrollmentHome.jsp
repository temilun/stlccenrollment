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
        <script defer src="https://use.fontawesome.com/releases/v5.15.1/js/all.js" integrity="sha384-9/D4ECZvKMVEJ9Bhr3ZnUAF+Ahlagp1cyPC7h5yDlZdXs4DQ/vRftzfd+2uFUuqS" crossorigin="anonymous"></script>
       
        <title>Enrollment Home - Search for classes</title>
   

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
                      <a class="nav-link" href="<%=request.getContextPath()%>/StudentHub.jsp">Student Hub</a>
                  </li>
                  <li class="nav-item">
                      <a class="nav-link" href="<%=request.getContextPath()%>/Cart.jsp">Cart <c:if test="${not empty cartSections}">(${cartSections.size()})</c:if></a>
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
                        <small class="form-text text-muted pb-1">Choose the term you want to register for.</small>
                    </div>
                    <ul id="termSelection" class="btn-group pb-4">
                        <li>
                            <input id="spring21" class="termbtn" type="radio" name="term" value="spring21" onclick="showSearchTypeDiv();" required/>
                            <label id="termLabel" for="spring21">Spring 2021</label>
                        </li>
                        <li>
                            <input id="summer21" class="termbtn" type="radio" name="term" value="summer21" onclick="showSearchTypeDiv();" required/>
                            <label id="termLabel" for="summer21">Summer 2021</label>
                        </li>
                        <li>
                            <input id="fall21" class="termbtn" type="radio" name="term" value="fall21" onclick="showSearchTypeDiv();" required/>
                            <label id="termLabel" for="fall21">Fall 2021</label>
                        </li>
                    </ul>
                    
                    <div id="searchTypeDiv" class="pb-4" style="display: none;">
                        <div id="sectionHead">
                            <h3>Search Type</h3>
                        </div>
                        <ul>
                            <li>
                                <input id="progSearch" class="termbtn" type="radio" name="searchType" value="progSearch" onclick="showProgs(); enableBtn();" required/>
                                <label id="termLabel" for="progSearch">Search by Degree/Program</label>
                            </li>
                            <li>
                                <input id="advSearch" class="termbtn" type="radio" name="searchType" value="advSearch" onclick="showAdvSearch();" required/>
                                <label id="termLabel" for="advSearch">Advanced Search</label>
                            </li>
                        </ul>
                    </div>
                    
                    <div id="deptDiv" style="display: none;" class="pb-4">
                        <div id="sectionHead">
                            <h3>Search by Degree/Certificate</h3>
                            <small class="form-text text-muted pb-1">Please select your Degree/Certificate program from the dropdown. Alternatively, select "Search by my program" to view all classes required to complete your degree.</small>
                        </div>
                        <div class="deptSelect px-3" style="width:80%;">
                            <select id="progID" name="progID">
                                <option disabled selected value>Select a program</option>
                                <c:forEach var='prog' items='${progs}'>
                                    <option value="${prog.progId}">${prog.progName}</option>
                                </c:forEach>    
                            </select>
                        </div>
                    </div>
                   
                    <div id="advDiv" style="display: none;" class="pb-4">
                        <div id="sectionHead" class="pb-3">
                            <h3>Advanced Search</h3>
                            <small class="form-text text-muted">All fields optional.</small>
                        </div>
                        <div class="SubjectSearch px-3">
                            <label for="course_sub" id="termLabel">Subject (Select one or many)</label>
                            <select id="course_sub" class="w-100" name="course_subject" onchange="enableBtn();" multiple>
                                <option disabled selected value>Subject(s) Select</option>
                                <c:forEach var='subject' items='${subjects}'>
                                    <option value="${subject}">${subject}</option>
                                </c:forEach>    
                            </select>
                        </div>
                        <div id="campusIdSelect" class="p-3">
                            <label for="campusId" id="termLabel">Campus</label>
                            <select id="campusId" class="w-100" name="campusId" onchange="enableBtn();">
                                <option disabled selected value>Campus Select</option>
                                <c:forEach var='campus' items='${campuses}'>
                                    <option value="${campus.campId}">${campus.campName}</option>
                                </c:forEach>    
                            </select>
                        </div>
                        <div id="timeSearchDiv" class="px-3">
                            <table id="timeSearchTable" class="w-100 text-left">
                                <tr>
                                    <td>
                                        <label for="startTime" id="termLabel">Start Time</label>
                                    </td>
                                    <td>
                                        <label for="endTime" id="termLabel">End Time</label>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        <input type="time" id="startTime" name="startTime" min="08:00" max="21:00" class="w-100" onchange="enableBtn();">
                                    </td>
                                    <td>
                                        <input type="time" id="endTime" name="endTime" min="08:00" max="22:00" class="w-100" onchange="enableBtn();">
                                    </td>
                                </tr>
                            </table>
                        </div>
                        <div id="termTypeSelect" class="p-3">
                            <label for="termType" id="termLabel">Term Type</label>
                            <select id="termType" class="w-100" name="termType" onchange="enableBtn();">
                                <option selected disabled>Term Type Select</option>
                                <option value="FT">Full Term</option>
                                <option value="1H">First Half</option>
                                <option value="2H">Second Half</option>
                                <option value="SOS">Spring Off Schedule</option>
                                <option value="12W">12 Week</option>
                            </select>
                        </div>
                        <div id="classTypeSelect" class="p-3">
                            <label for="classType" id="termLabel">Class Type</label>
                            <select id="classType" class="w-100" name="classType" onchange="enableBtn();">
                                <option selected disabled>Class Type Select</option>
                                <option value="In-Class">In-Class</option>
                                <option value="LVL">Live Virtual Lecture</option>
                                <option value="Internet">Internet</option>
                            </select>
                        </div>
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
        <script src="./js/enrollmentHome.js"></script>
    </body>
    </c:if>
</html>
