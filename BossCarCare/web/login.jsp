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
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
        <style>
            #effect_input:link{
                border: <%=request.getAttribute("inputborder")%>;
            }
            #effect_input:hover{
                border: <%=request.getAttribute("inputborder")%>;
            }
            
        </style>
    </head>
    <body>
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
        
        
        <div class="table_info_customer" style="margin-left: 4%">
            <form  action="login" method="post">
            
            
           
            <table class="info_customer login">
                <tr>
                    <td>
                        <img  class="icon" src="images/logoBossCarCare1.png" />
                    </td>
                </tr>
                
                <tr>
                    <td>
                        <h3>ĐĂNG NHẬP TÀI KHOẢN</h3> 
                    </td>
                </tr>
                <tr>
                    <td><input id="effect_input" name="email" type="text"  placeholder="Email" value="<%= request.getAttribute("acc") != null ? request.getAttribute("acc"):"" %>" /> </td>
                </tr>
                
                <tr>
                    <td><input id="effect_input" name="password" type="password"  placeholder="Mật khẩu" value="<%= request.getAttribute("pass") != null ? request.getAttribute("pass"):"" %>" /><span></span></td>
                    
                    
                </tr>
                <tr>
                    <td>
                        <p style="color: red; margin-left: 50px"> <%= request.getAttribute("errorLogin") != null ? request.getAttribute("errorLogin"):"" %> </p>
                    </td>
                    <td></td>
                </tr>
                <tr>
                        <td>
                            <input type="checkbox" name="checkRemember"><span>Ghi nhớ tài khoản.</span>
                        </td>
                    </tr>
                <tr>
                    <td class="thuexe_btn_thuexe" ><button class="btn_thuexe btn  btn-block" type="submit" id="btn_thuexe">Đăng nhập</button></td>
                    
                </tr>
                <tr>
                    <td>
                        <td><a href="signup.jsp" style="color: blue;text-decoration: none;font-size: 12px">chưa có tài khoản</a></td>
                    </td>
                </tr>
            </table>           
            
            
        </form>
        </div>
    </body>
</html>
