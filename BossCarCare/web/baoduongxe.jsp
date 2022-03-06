<%-- 
    Document   : baoduongxe
    Created on : Mar 5, 2022, 11:14:12 PM
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
    <style>
        body{
            background-image: url("images/baohanhBG.jpg") ;

        }
        .containerNone ,.footer{
            background-color: white;

        }
        .containerNone{
            margin: 20px 150px;
            padding: 50px;
        }
        .footer{
            margin-top: 0;
        }
        .row{
            margin-right: 0;
        }

    </style>
    <body >
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

        <div class="containerNone">
            <h4>ĐẶT DỊCH VỤ</h4>
            <div class="row">
                <div class="col-md-6">
                    <label class="header_label"><i class="circle_label">1</i><span>Thông tin khách hàng</span></label><br>
                    <label>Họ và tên<span style="color: blue">*</span></label>
                    <div>

                        <input oninput="enterText()"  id="enterText" name="namecustomer" value="${namecustomer}" type="text" placeholder="Nhập họ và tên">
                    </div>
                    <label>Số điện thoại<span style="color: blue">*</span></label>

                    <div>

                        <input oninput ="enterNumber()" id="enterNumber" name="phone" value="${phone}" type="text" placeholder="Tối thiểu 10 chữ số">
                    </div>
                    <label>Email<span style="color: blue">*</span></label>
                    <div>

                        <input name="email" value="${email}" type="email" placeholder="vidu@gmail.com">
                    </div>

                </div>
                <div class="col-md-6">
                    <label class="header_label"><i class="circle_label">2</i><span>Thông tin xe</span></label><br>
                    <label>Mẫu xe<span style="color: blue">*</span></label>
                    <div>

                        <input name="mauxe" value="${mauxe}" type="text" placeholder="Nhập mẫu xe">
                    </div>
                    <label>Số Km<span style="color: blue">*</span></label>
                    <div>

                        <input oninput ="enterNumber()" id="enterNumber" name="km" value="${km}" type="text" placeholder="Nhập số km trên phương tiện của quý khách">
                    </div>
                    <label>Biển số xe<span style="color: blue">*</span></label>
                    <div>

                        <input name="biensoxe" value="${biensoxe}" type="text" placeholder="Nhập biển số xe">
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-6 input_checkbox_baoduong" >
                    <label class="header_label"><i class="circle_label">3</i><span>Dịch vụ</span></label><br>
                    <label>Dịch vụ<span style="color: blue">*</span></label>
                    <div>

                        <input name="baoduong" value="${baoduong}" type="checkbox" > Bảo dưỡng
                    </div>


                    <div>

                        <input name="suachuachung" value="${suachuachung}" type="checkbox"> Sửa chữa chung
                    </div>

                    <div>

                        <input name="dongson" value="${dongson}" type="checkbox" > Đồng sơn
                    </div>
                    <div>

                        <input name="suachuakhac" value="${suachuakhac}" type="checkbox" > Sửa chữa khác
                    </div>

                </div>
                <div class="col-md-6 ">
                    <label class="header_label"><i class="circle_label">4</i><span>Thời gian</span></label><br>
                    <label>Thời gian<span style="color: blue">*</span></label><br>

                    <div class="col-md-6">

                        <input name="ngay" value="${ngay}" type="date" placeholder="ngày">
                    </div>

                    <div class="col-md-6">

                        <input name="gio" value="${gio}" type="time">
                    </div>

                </div>
            </div>
            <div class="btn_xacnhanyeucau">
                <button id="btn_thuexe" class="btn_thuexe">Gửi yêu cầu</button>
            </div>

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
        <script>
            
        </script>
    </body>
</html>
