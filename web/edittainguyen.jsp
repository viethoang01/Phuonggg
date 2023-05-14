<%-- 
    Document   : edittainguyen
    Created on : Mar 11, 2022, 8:56:49 PM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="edit" method="post">
            <table>
                <tr>
                    <td>Car ID</td>
                    <td>
                        <input name="id" type="text" value="${id}" hidden="">
                    </td>
                </tr>
                <tr>
                    <td>URL mẫu xe</td>
                    <td>
                        <input name="img" type="text" value="${img}">
                    </td>
                </tr>
                <tr>
                    <td>Car Name</td>
                    <td>
                        <input name="name" type="text" value="${name}">
                    </td>
                </tr>
                <tr>
                    <td>Dòng xe</td>
                    <td>
                        <input name="info" type="text" value="${info}" >
                    </td>
                </tr>
                <tr>
                    <td>Color</td>
                    <td>
                        <input name="color" type="text" value="${color}" >
                    </td>
                </tr>
                <tr>
                    <td>Giá thuê/ngày</td>
                    <td>
                        <input name="price" type="text" value="${price}" >
                    </td>
                </tr>
                <tr>
                    <td>Hiện trạng</td>
                    <td>
                        <input name="current" type="checkbox" value="${current}">
                    </td>
                </tr>



            </table>
            <button name="type" type="submit" value="${type}">Xác nhận</button>
        </form>
    </body>
</html>
