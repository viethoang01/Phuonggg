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
        <script src="js/bCar.js"></script>
        <link href='https://fonts.googleapis.com/css?family=Be Vietnam Pro' rel='stylesheet'>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
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
            <form  action="signup" method="post">
            
            
           
            <table class="info_customer login">
                <tr>
                    <td>
                        <img  class="icon" src="images/logoBossCarCare1.png" />
                    </td>
                </tr>
                
                <tr>
                    <td>
                        <h3>Tạo TÀI KHOẢN</h3> 
                    </td>
                </tr>
                <tr>
                    <td><input name="acc" type="text"  placeholder="Tên tài khoản" value="<%= request.getAttribute("acc") != null ? request.getAttribute("acc"):"" %>" /> </td>
                </tr>
                <tr>
                    <td><input id="pass" name="password" type="password"  placeholder="Mật khẩu" value="<%= request.getAttribute("pass") != null ? request.getAttribute("pass"):"" %>" /><span></span></td>
                    <td ><p style="color: red; margin-left: 50px"> <%= request.getAttribute("pass_error") != null ? request.getAttribute("pass_error"):"" %> </p></td>
                    
                </tr>
                <tr>
                    <td><input id="pass" name="password" type="password"  placeholder="Nhập lại mật khẩu" value="<%= request.getAttribute("pass") != null ? request.getAttribute("pass"):"" %>" /><span></span></td>
                    <td ><p style="color: red; margin-left: 50px"> <%= request.getAttribute("pass_error") != null ? request.getAttribute("pass_error"):"" %> </p></td>
                    
                </tr>
                <tr>
                    <td>
                        <br>
                        <h5>Mật khẩu bao gồm</h5>
                        <h8><span class="glyphicon glyphicon-ok-sign"></span> Ít nhất 8 ký tự</h8><br>
                        <h8><span class="glyphicon glyphicon-ok-sign"></span> Chữ hoa & chữ thường</h8><br>
                        <h8><span class="glyphicon glyphicon-ok-sign"></span> Ít nhất 1 số</h8><br>
                    </td>
                </tr>  
                <tr>
                    <td >
                        <br>
                        <h8>Bằng việc bấm nút Đăng ký bên dưới, tôi xác nhận đã đọc,hiểu</h8><br>
                        <h8> và đồng ý với các <a href="#">Điều kiện và Điều khoản</a> của Boss Car Care.</h8>
                    </td>
                </tr>
                <tr>
                    <td class="thuexe_btn_thuexe" ><button class="btn_thuexe btn  btn-block" type="submit" id="btn_thuexe">Đăng ký</button></td>
                    
                </tr>
                <tr>
                    <td>
                        <td><a href="login.jsp" style="color: blue;text-decoration: none;font-size: 12px">đã có tài khoản</a></td>
                    </td>
                </tr>
            </table>           
            
            
        </form>
        </div>
    </body>
</html>
