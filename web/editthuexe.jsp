<%-- 
    Document   : editthuexe
    Created on : Mar 10, 2022, 1:14:06 AM
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
                <td><input name="page" type="text" value="${page}" hidden=""></td>
                <tr>
                    <td>Hóa đơn id:</td>
                    <td><input name="thuexeid" type="text" value="${thuexeid}" readonly></td>
                </tr>
                <tr>
                    <td>Car id:</td>
                    <td><input name="carid" type="text" value="${carid}" ></td>
                </tr>
                <tr>
                    <td>Acc id:</td>
                    <td><input name="accid" type="text" value="${accid}" readonly></td>
                </tr>
                
               
                <tr>
                    <td>Số Ngày Thuê:</td>
                    <td><input name="thoiluong" type="number" value="${thoiluong}"></td>
                </tr><tr>
                    <td>Ngày đặt lịch thuê</td>
                    <td><input name="daybill" type="date" value="${daybill}"></td>
                </tr>
                <tr>
                    <td>Ngày nhận xe:</td>
                    <td><input name="startday" type="date" value="${startday}"></td>
                </tr>
                <tr>
                    <td>Ngày trả xe:</td>
                    <td><input name="endday" type="date" value="${endday}"></td>
                </tr>
                <tr>
                    <td>Tổng tiền:</td>
                    <td><input name="total" type="text" value="${total}"></td>
                </tr>
                <tr>
                    <td>Đơn vị:</td>
                    <td><input name="donvi" type="text" value="${donvi}"></td>
                </tr>
                <tr>
                    <td>Tên khách hàng:</td>
                    <td><input name="nameCustomer" type="text" value="${nameCustomer}"></td>
                </tr>
                <tr>
                    <td>Phone:</td>
                    <td><input name="phone" type="text" value="${phone}"></td>
                </tr>
                <tr>
                    <td>Email:</td>
                    <td><input name="email" type="email" value="${email}"></td>
                </tr>
                <tr>
                    <td>CMND/CCCD:</td>
                    <td><input name="CMND" type="text" value="${CMND}"></td>
                </tr>
                <tr>
                    <td>Mã giới thiệu:</td>
                    <td><input name="code_inv" type="text" value="${code_inv}"></td>
                </tr>
                
            </table>
                <button type="submit" name="type" value="thuexebill">Xác nhận</button>
        </form>
    </body>
</html>
