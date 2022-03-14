<%-- 
    Document   : editdichvu
    Created on : Mar 10, 2022, 11:46:54 PM
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
                    <td><input name="dichvuid" type="text" value="${dichvuid}" readonly></td>
                </tr>
                <tr>
                    <td>Tên khách hàng:</td>
                    <td><input name="namecustomer" type="text" value="${namecustomer}"></td>
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
                    <td>Car Name:</td>
                    <td><input name="mauxe" type="text" value="${mauxe}" ></td>
                </tr>
                <tr>
                    <td>Km:</td>
                    <td><input name="km" type="text" value="${km}"></td>
                </tr>
                <tr>
                    <td>Biển số xe</td>
                    <td><input name="bienso" type="text" value="${bienso}"></td>
                </tr>
                <tr>
                    <td>Dịch vụ</td>
                    <td>
                        <input id="baoduong" name="baoduong" value="baoduong" ${baoduong} type="checkbox" > Bảo dưỡng
                        <input id="suachuachung" name="suachuachung" value="suachuachung" ${suachuachung} type="checkbox"> Sửa chữa chung
                        <input id="dongson" name="dongson" value="dongson" ${dongson} type="checkbox" > Đồng sơn
                        <input id="suachuakhac" name="suachuakhac" value="suachuakhac" ${suachuakhac} type="checkbox" > Sửa chữa khác
                    </td>
                </tr>
                <tr>
                    <td>Ngày đặt lịch</td>
                    <td><input name="daybill" type="date" value="${daybill}" readonly></td>
                </tr>
                <tr>
                    <td>Ngày sử dụng dịch vụ:</td>
                    <td><input name="ngay" type="date" value="${ngay}"></td>
                </tr>
                <tr>
                    <td>Giờ sử dụng:</td>
                    <td><input  name="gio" value="${gio}" type="time"></td>
                </tr>

                

            </table>
                <button type="submit" name="type" value="dichvubill">Xác nhận</button>
        </form>
    </body>
</html>
