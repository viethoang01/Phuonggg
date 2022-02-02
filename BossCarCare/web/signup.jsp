<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>Sign up</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="css/signup.css" rel="stylesheet" type="text/css"  /> 
        <script src="js/bCar.js"></script>
    </head>
    <body>
        
        <form class="sign" action="signup" method="post">
            <img style="margin-bottom: 50px;" class="icon" src="images/logosignup.png" />
            <br>
            <table style="margin-left: 20%">
                <tr>
                    <td><input name="acc" type="text"  placeholder="Tên tài kho?n" value="<%= request.getAttribute("acc") != null ? request.getAttribute("acc"):"" %>" /> </td>
                </tr>
                <tr>
                    <td><input id="pass" name="password" type="password"  placeholder="M?t kh?u" value="<%= request.getAttribute("pass") != null ? request.getAttribute("pass"):"" %>" /></td>
                </tr>
                <tr>
                    <td><input id="repass" name="repassword" type="password"  placeholder="Nh?p l?i m?t kh?u" value="<%= request.getAttribute("repass") != null ? request.getAttribute("repass"):"" %>" /></td>
                    <td ><p style="color: red; margin-left: 50px"> <%= request.getAttribute("pass_error") != null ? request.getAttribute("pass_error"):"" %> </p></td>
                </tr>
                <tr>
                    <td><input onclick="submit()" class="submit" type="submit"  value="T?o tài kho?n" /></td>
                </tr>
            </table>           
            
            
        </form>
    </body>
</html>
