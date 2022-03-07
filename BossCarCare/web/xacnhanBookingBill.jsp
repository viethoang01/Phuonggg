<%-- 
    Document   : xacnhanBookingBill
    Created on : Mar 7, 2022, 12:56:15 PM
    Author     : Administrator
--%>

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
    </head>
    <body>
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
                    <div style="display: block; ${nav_btn_taikhoan}" class=" class_btn"> <a href="login.jsp" id="btn_spring" title="Login">TÀI KHOẢN</a></div>
                    <div class="dropdown" style="display: none;${nav_user}">
                        <button style="background-color: white;color: black;border: none" class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown"><span class="glyphicon glyphicon-user"> ${email_user}</span>
                        </button>
                        <ul class="dropdown-menu" >
                            <li style="padding: 10px 2px;"><a  href="#">Hóa đơn đã xác nhận</a></li>
                            <li style="padding: 10px 2px;"><a href="#">Hóa đơn chưa xác nhận</a></li>
                            <li style="padding: 10px 2px;"><a href="logout">Đăng xuất</a></li>
                        </ul>
                    </div>

                </div>

            </div>

        </nav>



        <div class="container">
            <form action="xacnhanBookingBill" method="post">
                <h2>Thông tin hóa đơn thuê xe</h2>
                <table border="1">
                    <thead>
                        <tr>
                            <th>Tên khách hàng</th>
                            <th>Số điện thoại</th>
                            <th>Email</th>
                            <th>Loại xe</th>
                            <th>Số km</th>
                            <th>Biển số xe</th>
                            <th>Dịch vụ yêu cầu</th>
                            <th>Ngày bảo dưỡng</th>
                            <th>Thời gian</th>


                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>${name_customer}</td>
                            <td>${phone_customer}</td>
                            <td>${email_customer}</td>
                            <td>${mauxe}</td>
                            <td>${km}</td>
                            <td>${bienso}</td>
                            <td>${dichvu}</td>
                            <td>${ngay}</td>
                            <td>${gio}</td>
                        </tr>

                    </tbody>
                </table>
                <button class="btn_thuexe" id="btn_thuexe">Xác nhận</button>
                <a href="baoduong?xacnhan=0">Kiểm tra lại thông tin</a>
            </form>

        </div>



        <div class="row footer">
            <div class="row">
                <img class="col-md-offset-5 col-md-7" src="images/logoBossCarCare2.png" alt="">
            </div>
            <div class="row content1">
                <ul class="col-md-3">
                    <li>GIỚI THIỆU</li>
                    <li><a href="#">Về Boss Car</a></li>
                    <li><a href="#">Về Qúa trình thành lập</a></li>
                    <li><a href="#">Tương Lai Boss Car</a></li>
                </ul>
                <ul class="col-md-3">
                    <li>TIN TỨC NỔI BẬT</li>
                    <li><a href="#">Ưu Đãi</a></li>
                    <li><a href="#">Công Ty</a></li>
                    <li><a href="#">Cộng Đồng</a></li>
                </ul class="col-md-3">
                <ul class="col-md-3">
                    <li>HỖ TRỢ</li>
                    <li><a href="#">Câu Hỏi Thường Gặp</a></li>
                    <li><a href="#">Hệ Thống Phân Phối</a></li>
                    <li><a href="#">Liên Hệ</a></li>
                    <li><a href="#">Đặt Lịch Bảo Dưỡng</a></li>
                </ul>
                <ul class="col-md-3">
                    <li>PHÁP LÝ</li>
                    <li><a href="#">Chính sách quyền riêng tư</a></li>
                    <li><a href="#">Chính sách vận chuyển</a></li>
                    <li><a href="#">Chính sách đổi trả</a></li>
                    <li><a href="#">Miễn trừ trách nhiệm</a></li>
                    <li><a href="#">Điều khoản ký kết thỏa thuận đặt cọc mua Ô tô</a></li>
                    <li><a href="#">Điều kiện sử dụng cookies</a></li>
                </ul>
            </div>
            <div class="content2">
                <ul class="row">
                    <li class="col-md-4" ><a href="https://g.page/Boss-Car-Care-Hanoi?share" target="_blank" style="color: black;">
                            <strong> Địa chỉ:</strong>Center Point: No.DM6-13,Trade village Vạn Phúc-Hà Đông-Hà Nội</a></li>
                    <li class="col-md-4"><strong>Số đăng ký kinh doanh:</strong> 0108926276 <br>
                        <strong>Đăng ký lần đầu: </strong>Ngày 01 tháng 10 năm 2019 <br>
                        <strong>Đăng ký thay đổi lần thứ 3: </strong>Ngày 17 tháng 03 năm 2020<br>
                        <strong>Nơi cấp: </strong>Sở Kế hoạch và Đầu tư Thành phố Hà Nội
                    </li>
                    <li class="col-md-4"><strong>Mail:</strong> hoangnvliu@gmail.com</li>
                </ul>
            </div>
        </div>
    </body>
</html>
