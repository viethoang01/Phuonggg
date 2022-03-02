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
        <title>Sign Up</title>
        <link href="css/bCar.css" rel="stylesheet" type="text/css" />
        <script src="js/script.js"></script>
        <link href='https://fonts.googleapis.com/css?family=Be Vietnam Pro' rel='stylesheet'>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    </head>
    <body style="background: #ABCDEF;
  font-family: Assistant, sans-serif;
  
  min-height: 90vh;">
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


        <div class="row form_login" >
            <div class="col-md-offset-2 col-md-4">
                <img src="images/logoBossCarCare2.png">
            </div>
            <div class="col-md-5 form_container">

                
                    <section class='login' id='login'>
                        <div class='head'>
                            <h1 class='company'>Login</h1>
                        </div>
                        <p class='msg'>Welcome back</p>
                        <div class='form'>
                            <form action="login" method="post">
                                <input name="email_login" value="${email_login_value}" type="text" placeholder='Email' class='text' id='username' required><br>
                                <span  style="color: red;display: none;display: ${email_err1}" class="glyphicon glyphicon-remove">Email không đúng format</span>
                                <span  style="color: red;display: none;display: ${email_err2}" class="glyphicon glyphicon-remove">Email chưa được đăng ký</span>
                                <input name="pass_login" type="password" placeholder='Password' class='password'><br>
                                <span style="color: red;display: none;display: ${pass_err_login}" class="glyphicon glyphicon-remove">Sai password</span>
                                <input name="remember" type="checkbox" class='password' style="margin-bottom: 50px;">Remember me<br>
                                
                                <button  type="submit" class='btn-login' id='do-login'>Login</button>
                                <a href="signup.jsp" class='forgot'>Sign up?</a>
                            </form>
                        </div>
                    </section>
                   
            </div>
            <div class="col-md-1"></div>
        </div>
    </body>
</html>
