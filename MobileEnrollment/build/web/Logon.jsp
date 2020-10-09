<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>STLCC Mobile Registration Login</title>
        <link rel="stylesheet" type="text/css" href="./css/logon-styles.css" />
        <link rel="icon" href="./img/stlcc-logo.jpg" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="https://fonts.googleapis.com/css2?family=Karla&family=Rubik&display=swap" rel="stylesheet"> 
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
        <script>
            history.forward();
        </script>
    </head>
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
                    <a class="nav-link" href="https://stlcc.edu">STLCC Home<span class="sr-only"></span></a>
                  </li>
                  <li class="nav-item">
                    <a class="nav-link" href="https://selfservice.stlcc.edu:9199/SLCC/twbkwbis.P_WWWLogin">Classic Banner</a>
                  </li>

                </ul>
            </div>
        </nav>
        <div id="Heading">
            <h1 class="h3">STLCC Mobile Registration</h1>
        </div>
        
        <div class="container">
            <form action="StudentLogon" method="post" id="loginForm">
                <div class="form-group">
                    <label for="userid">Student ID</label>
                    <input type="text" name="stuId" class="form-control" placeholder="Student ID">
                    <small id="uidTip" class="form-text text-muted">Note: this is your Student ID, not email or username</small>
                <div class="form-group">
                    <label for="password">Password</label>
                    <input type="password" name="password" class="form-control" placeholder="Password">
                    <small id="pwTip" class="form-text text-muted">
                       <a href="https://ssprm.stlcc.edu/specopspassword/Reset/Reset.aspx">Forgot password?</a>
                    </small>
                </div>
                </div>

                <div id="errmsg" class="text-center text-danger">
                    ${msg}
                </div>

                
                <div class="text-center">
                    <input type="submit" value="Login"  id="loginBtn">
                </div>
            </form>
        </div>
        <br>
        
        
        <div class="footer">
            <p>STLCC ©2020</p>
        </div>
    </body>
    <%session.invalidate();%>
</html>

