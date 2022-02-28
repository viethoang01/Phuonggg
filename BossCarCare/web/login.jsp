<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link href="css/bCar.css" rel="stylesheet" type="text/css" />
        <script src="js/bCar.js"></script>
        <link href='https://fonts.googleapis.com/css?family=Be Vietnam Pro' rel='stylesheet'>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js">
            <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"/>
        </script>
        <style>
            
        </style>

    </head>
    <body >
        <nav class="navbar  header_top row" >
            <div class="container-fluid">
                <div class="nav_left col-md-9 row">
                    <div class="navbar-header col-md-5">
                        <a class="navbar-brand" href="home"><img class="logo" title="Boss Car Care" src="images/logoBossCarCare2.png" alt="logoBossCarCare"></a>
                    </div>
                    <div class="col-md-7 row">
                        <div class="col-md-3"><a href="home#dichvu">Dịch vụ</a></div>
                        <div class="col-md-3"><a href="home#congcu">Công cụ</a></div>
                        <div class="col-md-3"><a href="home#banggia">Bảng giá</a></div>
                        <div class="col-md-3"><a href="home#tintuc">Tin tức</a></div>
                    </div>
                </div>
                <div class="nav_right col-md-3">
                    <div class="class_btn"> <a href="login.jsp" id="btn_spring">TÀI KHOẢN</a></div>

                </div>

            </div>

        </nav>




        <div class="row">
            <div class="col-md-offset-2 col-md-5 login_form">
                <img src="images/logoBossCarCare2.png">
            </div>
            <div class="col-md-5">
                <div class="wrapper">
                    <header>Login Form</header>
                    <form action="login"  method="post">
                        <div class="field email">
                            <div class="input-area">
                                    <input style="<%=request.getAttribute("emailerrinput")%>"  name="email" type="text" placeholder="Email Address" value="<%=request.getAttribute("emailValue") != null ? request.getAttribute("emailValue") : ""%>">
                                <i class="icon fas fa-envelope"></i>
                                <i class="error error-icon fas fa-exclamation-circle"></i>
                            </div>
                            <div style="<%=request.getAttribute("emailerr")%>" class="error error-txt">Email không phù hợp</div>
                        </div>
                        <div class="field password">
                            <div class="input-area">
                                <input style="<%=request.getAttribute("passerrinput")%>" name="password"  type="password" placeholder="Password" value="<%=request.getAttribute("passValue") != null ? request.getAttribute("passValue") : ""%>">
                                <i class="icon fas fa-lock"></i>
                                <i  class="error error-icon fas fa-exclamation-circle"></i>
                            </div>
                            <div style="<%=request.getAttribute("passerr")%>"  class="error error-txt">Password không phù hợp</div>
                        </div>
                        
                        <div class="row">
                            <div class="col-md-3 ">
                                <div class="">
                                    re<span><input style="height: auto; mar" type="checkbox"></span><span>re</span>
                                </div>
                                <div class="col-md-11">
                                    <p>Remember me</p>
                                </div>
                            </div>
                            <div class="col-md-offset-3 col-md-6"></div>
                        </div>
                        <div style="color: red;display:  none; <%=request.getAttribute("loginerr")%>">Thông tin tài khoản không chính xác</div>
                        <input type="submit" value="Login">
                        
                    </form>
                    <div class="sign-txt">Not yet member? <a href="signup.jsp">Signup now</a></div>
                </div>
            </div>
        </div>



    </body>
</html>
