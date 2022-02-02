<%-- 
    Document   : login
    Created on : Feb 2, 2022, 6:40:05 PM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
    </head>
    <body>
        
        <form class="sign" action="signup" method="post">
            <br>
            <img style="margin-bottom: 50px;" class="icon" src="images/logologin.png" />
            <br>
            <input name="acc" type="text"  placeholder="Account?" /> 
            <br>
            <input name="password" type="password"  placeholder="Password?" />
            <br>
            <input class="submit" type="submit"  value="Login" />
            
        </form>
    </body>
</html>

