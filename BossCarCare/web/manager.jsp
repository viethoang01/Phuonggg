<%-- 
    Document   : manager
    Created on : Mar 9, 2022, 3:28:22 PM
    Author     : Administrator
--%>

<%@page import="model.Car"%>
<%@page import="model.BookingBill"%>
<%@page import="model.Bill"%>
<%@page import="java.util.ArrayList"%>
<%@page import="util.HtmlHelper"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/bCar.css" rel="stylesheet" type="text/css" />
        <script src="js/bCar.js"></script>
        <link href='https://fonts.googleapis.com/css?family=Be Vietnam Pro' rel='stylesheet'>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
        <style>
            a{

                padding: 10px;
                font-size: 20px;
            }
            span{

                padding: 10px;
                font-size: 20px;
            }
            form{

                margin: auto;
                text-align: center;
                margin-bottom: 20px;

            }
            .hoadon_type{
                padding: 5px;
            }
            .hoadon_type option{
                padding: 20px;
            }
            table{

                margin: auto;
                margin: 10px;
            }
            th , tr{
                text-align: center;
                padding: 5px;
            }
            .link_page{
                text-align: center;
            }

        </style>
    </head>
    <body id="home">
        <nav class="navbar  header_top row" style="padding-left: 0;padding-right: 0;margin-left: 0;margin-right: 0;border-radius: 0">
            <div class="container-fluid" style="padding-left: 0;padding-right: 0;box-sizing: border-box">
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
                    
                    
                    <div class="dropdown" style="display: none;${manage}">   <!--for ADMIN-->
                        <button style="background-color: white;color: black;border: none" class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown"><span class="glyphicon glyphicon-user"> ${email_user}</span>
                        </button>

                        <ul class="dropdown-menu" >                              
                            <li style="padding: 10px 2px;"><a  href="manage">Quản lý hóa đơn</a></li>
                            <li style="padding: 10px 2px;"><a href="xacnhan">Quản lý tài nguyên</a></li>
                            <li style="padding: 10px 2px;"><a href="logout">Đăng xuất</a></li>
                        </ul>

                    </div>
                </div>

            </div>

        </nav>


        <%ArrayList<Bill> listthuexe = (ArrayList<Bill>) request.getAttribute("listthuexe");%>
        <%ArrayList<BookingBill> listdichvu = (ArrayList<BookingBill>) request.getAttribute("listdichvu");%>
        <%ArrayList<Car> listcar = (ArrayList<Car>) request.getAttribute("listcar");%>
        <%String typepage = (String) request.getAttribute("typepage");%>
        <%if(listcar != null){%>
        <%
            String type = "tainguyen";
            int pageindex = (int) request.getAttribute("pageindex");
            int totalNumberPage = (int) request.getAttribute("totalNumberPage");
        %>
        <table border="1">
            <thead>
                <tr>>
                    <th>STT</th>
                    <th>Car ID</th>
                    <th>Hình mẫu</th>
                    <th>Tên xe</th>
                    <th>Dòng xe</th>
                    <th>Hiện trạng</th>
                    <th>Màu sắc</th>
                    <th>Giá thuê</th>
                    
                   
                </tr>
            </thead>
            <tbody>
                <%int count = 1;%>
                <%for (Car car : listcar) {%>
                
                <tr>
                    <td><%=count++%></td>
                    <td><%=car.getId()%></td>
                    <td><img src="<%=car.getImg()%>" width="10%"></td>
                    <td><%=car.getNameCat()%> <%=car.getName()%></td>
                    <td><%=car.getInfo()%></td>
                    <td><%=car.getCurrent()?"ON":"OFF"%></td>
                    <td><%=car.getColor()%></td>
                    <td><%=car.getPrice()%></td>
                    
                    <td><a href="edit?type=tainguyen&tainguyenid=<%=car.getId()%>">Edit</a></td>
                    <td><a href="#" onclick="deleteBill3(<%=car.getId()%>)">Delete</a></td>
                    
                </tr>
                <%}%>
            </tbody>
        </table>
            <div class="link_page"><%=HtmlHelper.pager(5, pageindex, totalNumberPage, typepage)%></div>
        <%}else{%>
        <div class="">
            <form action="manage" method="get">
                <select name="typepage" class="hoadon_type">
                    <option value="0" <%=request.getAttribute("typepage_thuexe_Selected")%>>Hóa đơn thuê xe</option>
                    <option value="1" <%=request.getAttribute("typepage_dichvu_Selected")%>>Hóa đơn đặt dịch vụ</option>
                </select>  
                <button id="btn_thuexe" style="padding: 5px 15px">OK</button>
            </form>  
        </div>   
        <%String type = "";
                    String billid = "";%>
        <%if (listthuexe != null) {%>
        <%
            type = "thuexe";

            int pageindex = (int) request.getAttribute("pageindex");
            int totalNumberPage = (int) request.getAttribute("totalNumberPage");
        %>

        <table border="1">
            <thead>
                <tr>
                    <th>Hóa đơn ID</th>
                    <th>Account ID</th>
                    <th>Đơn vị</th>
                    <th>Khách hàng</th>
                    <th>CMND/CCCD</th>
                    <th>Email</th>
                    <th>Phone</th>
                    <th>Mã giới thiệu</th>
                    <th>Mã xe</th>
                    <th>Loại xe thuê</th>
                    <th>Ngày đặt thuê</th>
                    <th>Ngày nhận xe</th>
                    <th>Ngày trả xe</th>
                    <th>Số ngày thuê</th>
                    <th>Giá tiền/ngày</th>
                    <th>Tổng tiền</th>
                </tr>
            </thead>
            <tbody>

                <%for (Bill bill : listthuexe) {
                %>
                <tr>
                    <td><%=bill.getId()%></td>
                    <td><%=bill.getAccId()%></td>
                    <td><%=bill.getDonvi()%></td>
                    <td><%=bill.getNameCustomer()%></td>
                    <td><%=bill.getCMND()%></td>
                    <td><%=bill.getEmail()%></td>
                    <td><%=bill.getPhone()%></td>
                    <td><%=bill.getCode_inv()%></td>
                    <td><%=bill.getAccId()%></td>
                    <td><%=bill.getCarname()%></td>
                    <td><%=bill.getDaybill()%></td>
                    <td><%=bill.getStartday()%></td>
                    <td><%=bill.getEndday()%></td>
                    <td><%=bill.getThoiluong()%></td>
                    <td><%=bill.getPrice()%></td>
                    <td><%=bill.getTotal()%></td>
                    <td><a href="edit?type=thuexebill&thuexeid=<%=bill.getId()%>">Edit</a></td>
                    <%billid = bill.getId();%>
                    <td><a href="#" onclick="deleteBill(<%=bill.getId()%>)">Delete</a></td>
                </tr>
                <%}%>
            </tbody>

        </table>
        <div class="link_page"><%=HtmlHelper.pager(5, pageindex, totalNumberPage, typepage)%></div>

        <%} else {%>
        <%
            type = "dichvu";
            int pageindex = (int) request.getAttribute("pageindex");
            int totalNumberPage = (int) request.getAttribute("totalNumberPage");
        %>
        <table border="1">
            <thead>
                <tr>
                    <th>Hóa đơn ID</th>
                    <th>Account ID</th>
                    <th>Tên khách hàng</th>
                    <th>Số điện thoại</th>
                    <th>Email</th>
                    <th>Loại xe</th>
                    <th>Số km</th>
                    <th>Biển số xe</th>
                    <th>Dịch vụ yêu cầu</th>
                    <th>Ngày đặt lịch</th>
                    <th>Ngày bảo dưỡng</th>
                    <th>Thời gian</th>
                </tr>
            </thead>
            <tbody>

                <%for (BookingBill bill : listdichvu) {
                %>
                <tr>
                    <td><%=bill.getId()%></td>
                    <td><%=bill.getAccId()%></td>
                    <td><%=bill.getNameCustomer()%></td>
                    <td><%=bill.getPhone()%></td>
                    <td><%=bill.getEmail()%></td>
                    <td><%=bill.getCarName()%></td>
                    <td><%=bill.getKm()%></td>
                    <td><%=bill.getBienso()%></td>
                    <td><%=bill.getDichvu()%></td>
                    <td><%=bill.getNgaybooking()%></td>
                    <td><%=bill.getNgay()%></td>
                    <td><%=bill.getGio()%></td>  
                    <td><a href="edit?type=dichvubill&dichvuid=<%=bill.getId()%>">Edit</a></td>
                    <td><a href="#" onclick="deleteBill2(<%=bill.getId()%>)">Delete</a></td>
                </tr>
                <%}%>
            </tbody>
        </table>
        <div class="link_page"><%=HtmlHelper.pager(5, pageindex, totalNumberPage, typepage)%></div>
        <%}%>
        <%}%>
        <script>
            function deleteBill(id) {
                var option = confirm("Bạn có chắc chắn muốn xóa không ?" + id);
                if (option === true) {
                    window.location.href = 'delete?type=thuexe&thuexeid=' + id;
                }
            }
            function deleteBill2(id) {
                var option = confirm("Bạn có chắc chắn muốn xóa không ?" + id);
                if (option === true) {
                    window.location.href = 'delete?type=dichvu&dichvuid=' + id;
                }
            }
            function deleteBill3(id) {
                var option = confirm("Bạn có chắc chắn muốn xóa không ?" + id);
                if (option === true) {
                    window.location.href = 'delete?type=tainguyen&tainguyenid=' + id;
                }
            }
        </script>
    </body>
</html>
