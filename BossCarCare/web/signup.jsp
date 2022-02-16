<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html lang="en">
    <head>
        <title>Sign up</title>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="css/signup.css" rel="stylesheet" type="text/css"  /> 
        <script src="js/bCar.js"></script>
    </head>
    <body>
        
        <form class="sign" action="signup" method="post">
            <img style="margin-bottom: 50px;" class="icon" src="images/logoBossCarCare1.png" />
            <h2 style="color: #078749;font-family: sans-serif;text-align: center">TẠO TÀI KHOẢN</h2> 
            <br>
            <table style="margin-left: 20%">
                <tr>
                    <td><input name="acc" type="text"  placeholder="Tên tài khoản" value="<%= request.getAttribute("acc") != null ? request.getAttribute("acc"):"" %>" /> </td>
                </tr>
                <tr>
                    <td><input id="pass" name="password" type="password"  placeholder="Mật khẩu" value="<%= request.getAttribute("pass") != null ? request.getAttribute("pass"):"" %>" /></td>
                </tr>
                <tr>
                    <td><input id="repass" name="repassword" type="password"  placeholder="Nhập lại mật khẩu" value="<%= request.getAttribute("repass") != null ? request.getAttribute("repass"):"" %>" /></td>
                    <td ><p style="color: red; margin-left: 50px"> <%= request.getAttribute("pass_error") != null ? request.getAttribute("pass_error"):"" %> </p></td>
                </tr>
                <tr>
                    <td><input onclick="submit()" class="submit" type="submit"  value="Tạo tài khoản" /></td>
                </tr>
            </table>           
            
            
        </form>
    </body>
</html>
