<%-- 
    Document   : xacnhan
    Created on : Mar 4, 2022, 1:14:34 AM
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
        <h1><form action="xacnhan" method="post">
                <table border="1">
                    <thead>
                        <tr>
                            <th>Car ID</th>
                            <th>Account ID</th>
                            <th>Thời lượng thuê</th>
                            <th>Đơn vị</th>
                            <th>Tên khách hàng</th>
                            <th>CMND/CCCD</th>
                            <th>Số điện thoại</th>
                            <th>Email</th>
                            <th>Mã giới thiệu(nếu có)</th>
                            <th>Ngày bắt đầu thuê</th>
                            <th>Ngày kết thúc thuê</th>
                            <th>Tổng tiền</th>
                            
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>${Carid}</td>
                            <td>${Accid}</td>
                            <td>${thoiluongthue}</td>
                            <td>${customer_type}</td>
                            <td>${name_customer}</td>
                            <td>${CMND_customer}</td>
                            <td>${phone_customer}</td>
                            <td>${email_customer}</td>
                            <td>${gioithieu_code_customer}</td>
                            <td>${startdayString}</td>
                            <td>${endday}</td>
                            <td>${totalmoney}</td>
                        </tr>
                       
                    </tbody>
                </table>

                <button class="btn_thuexe" id="btn_thuexe">Xác nhận</button>
                
            </form></h1>
    </body>
</html>
