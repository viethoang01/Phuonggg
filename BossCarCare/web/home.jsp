<%-- 
    Document   : home
    Created on : Jan 29, 2022, 11:38:50 PM
    Author     : Administrator
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="model.Car"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Boss Car Care</title>
        <link href="css/bCar.css" rel="stylesheet" type="text/css" />
        <script src="js/bCar.js"></script>
        <link href='https://fonts.googleapis.com/css?family=Be Vietnam Pro' rel='stylesheet'>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    </head>
    <body id="home">
        <nav class="navbar  header_top row" >
            <div class="container-fluid">
                <div class="nav_left col-md-9 row">
                    <div class="navbar-header col-md-5">
                        <a class="navbar-brand" href="#home"><img class="logo" title="Boss Car Care" src="images/logoBossCarCare2.png" alt="logoBossCarCare"></a>
                    </div>
                    <div class="col-md-7 row">
                        <div class="col-md-3"><a href="#dichvu">Dịch vụ</a></div>
                        <div class="col-md-3"><a href="#congcu">Công cụ</a></div>
                        <div class="col-md-3"><a href="#tintuc">Tin tức</a></div>
                        <div class="col-md-3"><a href="#banggia">Bảng giá</a></div>
                        
                    </div>
                </div>
                <div class="nav_right col-md-3 ">
                    <div class=" class_btn"> <a href="login.jsp" id="btn_spring" title="Logout">TÀI KHOẢN</a></div>
                    <a href="login.jsp"  title="Logout"><div class=" circle" style="display: none;${style_circle}"><h6>${HeaderOfEmail}</h6></div></a>
                </div>

            </div>

        </nav>

        <!--edit-->
        <!--
        <div class="content_menu " id="dichvu_content">
            <ul >
                <li class="col-md-4"><a href="#">Rửa xe</a></li>
                <li class="col-md-4"><a href="#">Bảo Dưỡng</a></li>
                <li class="col-md-4"><a href="#">Sửa chữa</a></li>
                <img src="images/carcare7.png" alt="">
            </ul>
        </div>
        <div class="content_menu banggia_content">
            <ul >
                <li class="col-md-4"><a href="#">Bảng giá rửa xe</a></li>
                <li class="col-md-4"><a href="#">Bảng giá bảo Dưỡng</a></li>
                <li class="col-md-4"><a href="#">Bảng giá sửa chữa</a></li>
                <img src="images/carcare8.png" alt="">
            </ul>
        </div>
        <div class="content_menu congcu_content">
            <ul>
                <li class="col-md-4"><a href="#">Đặt lịch trước</a></li>
                <li class="col-md-4"><a href="#">Trả góp</a></li>
                <li class="col-md-4"><a href="#">So sánh phụ tùng</a></li>
                <img src="images/carcare3.png" alt="">
            </ul>
        </div>
        <div class="content_menu " id="tintuc_content">
            <ul>
                <li class="col-md-4"><a href="#">Chương trình khuyến mãi</a></li>
                <li class="col-md-4"><a href="#">Tin tức</a></li>
                <li class="col-md-4"><a href="#">Cải tiến</a></li>
                <img src="images/carcare6.png" alt="">
            </ul>
        </div>
        -->
        <!--Nội dung Slider-->
        <div class="row" >
            <div class="col-md-12">
                <!--Bắt đầu slider-->
                <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
                    <!-- Indicators -->
                    <ol class="carousel-indicators">
                        <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                        <li data-target="#carousel-example-generic" data-slide-to="1"></li>
                        <li data-target="#carousel-example-generic" data-slide-to="2"></li>
                        <li data-target="#carousel-example-generic" data-slide-to="3"></li>
                    </ol>

                    <!-- Wrapper for slides -->
                    <div class="carousel-inner">
                        <div class="item active">
                            <img src="images/silde3.jfif" alt="carcare">
                        </div>

                        <div class="item">
                            <img src="images/slide2.jfif" alt="carcare">
                        </div>

                        <div class="item">
                            <img src="images/slide1.jpg" alt="carcare">
                        </div>

                    </div>

                    <!-- Controls -->
                    <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
                        <span class="glyphicon glyphicon-chevron-left"></span>
                    </a>
                    <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
                        <span class="glyphicon glyphicon-chevron-right"></span>
                    </a>
                </div>
            </div> 	
        </div> 		
        <!--Kết thúc slider-->



        <div class="container" id="dichvu">


            <h2 class="header" id="detailing" onclick="detailing()">Detailing</h2>
            <h2 class="header" id="process" onclick="process()">Quy trình rửa xe</h2>
            <div >
                <div id = "detailing-content">
                    <img src="images/imgcontent3.png" alt="detailcarcare">
                    <ul>
                        <li><p>Detailing không chỉ là một quá trình làm sạch để làm cho một chiếc xe trông đẹp, mà là một cách tiếp cận có hệ thống để giúp kéo dài tuổi thọ của nó bằng các phương pháp và sản phẩm làm giảm các yếu tố môi trường gây hại như bụi bẩn, ánh nắng mặt trời, mùa đông khắc nghiệt, v.v. Bảo dưỡng hoặc phục hồi xe thích hợp để giữ cho xe trông bên ngoài và bên trong như thể chúng đến từ phòng trưng bày của đại lý ô tô làm tăng giá trị bán lại của chúng. Chi tiết tự động đòi hỏi kiến ​​thức về kỹ thuật và sử dụng các công cụ và sản phẩm thích hợp.</p></li>
                        <li><p>Chi tiết thường được chia thành hai loại: ngoại thất và nội thất (hoặc cabin). Có những sản phẩm và dịch vụ tập trung đặc biệt vào hai lĩnh vực này.</p></li>

                    </ul>
                </div>

                <div id = "process-content">
                    <img src="images/imgcontent2.jpg" alt="detailcarcare">
                    <div class="row">
                        <div class="col-md-offset-1 col-md-2">
                            <img src="images/process_care1.jpg">
                            <p>Bước 1: Phun nước xịt rửa bên ngoài ô tô</p>
                        </div>
                        <div class="col-md-2">
                            <img src="images/process_care2.jpg">
                            <p>Bước 2: Rửa thân xe</p>
                        </div>
                        <div class="col-md-2">
                            <img src="images/process_care3.jpg">
                            <p>Bước 3: Lau khô, đánh bóng lốp xe</p>
                        </div>
                        <div class="col-md-2">
                            <img src="images/process_care4.jpg">
                            <p>Bước 4: Dọn vệ sinh nội thất</p>
                        </div>
                        <div class="col-md-2">
                            <img src="images/process_care5.jpg">
                            <p>Bước 5: Kiểm tra lại tình trạng xe</p>
                        </div>

                    </div>

                </div>
                <form action="ruabaoduongxe" method="get" >
                            <button class="" id="btn_thuexe" value="" name="getcar_id">rửa bảo dưỡng xe</button>
                </form>
            </div>
            
   
        </div>
        <!--thue xe-->
        <div  class="container" id="congcu"><h2 class="header">Thuê xe đa năng</h2></div>
        <%ArrayList<Car> listcar = (ArrayList<Car>) request.getAttribute("listcar");%>
        <div class="slideshow-container" >
            <%for (Car car : listcar) {%>
            <%
                String infoCar = "";
                String checkInfo = car.getInfo();
                switch (checkInfo) {
                    case "4 cho sendan":
                        infoCar = "4 Chỗ SENDAN";
                        break;
                    case "4 cho":
                        infoCar = "4 Chỗ";
                        break;
                    case "7 cho":
                        infoCar = "7 Chỗ";
                        break;
                }
            %>
            <div class="mySlides1 row" style="height: 300px;">
                <div class="col-md-offset-1 col-md-5">
                    <img class="img_xethue" src="<%=car.getImg()%>" >
                </div>
                <div class="col-md-6">
                    <h1 class="name_car_h1"><%=car.getNameCat()%> <%=car.getName()%></h1>
                    <div class="row info_car_div">
                        <div class="col-md-6">
                            <h5>Dòng xe</h5>
                            <h4><%=infoCar%></h4>
                        </div>
                        <div class="col-md-3 text_right">
                            <h5>Giá\ngày</h5>
                            <h4><%=car.getPrice()%> vnd</h4>
                        </div>
                        <div class="col-md-3"></div>
                        
                    </div>
                        <form action="thuexe" method="get">
                            <button class="" id="btn_thuexe" value="<%= car.getId()%>" name="getcar_id">THUÊ XE</button>
                        </form>
                </div>

            </div>
            <%}%>
            <a class="prev" onclick="plusSlides(-1, 0)">&#10094;</a>
            <a class="next" onclick="plusSlides(1, 0)">&#10095;</a>
        </div>
            <div class="container">
                <p><strong><span class="glyphicon glyphicon-earphone" ></span>
                        Đặt thuê ngay: </strong>09888903540

                </p>
            </div>
            
             <!-- end thue xe-->
             
             
        <div class="container" style="clear: both" id="tintuc">
            <h2 class="header">Tin Tức</h2>


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
<!--Chat-->
<div class="call" style="background-color: blue;"><script src="https://uhchat.net/code.php?f=92b878"></script></div>
<!--chat end-->

        <script>
            var slideIndex = [1, 1];
            var slideId = ["mySlides1", "mySlides2"]
            showSlides(1, 0);
            showSlides(1, 1);

            function plusSlides(n, no) {
                showSlides(slideIndex[no] += n, no);
            }

            function showSlides(n, no) {
                var i;
                var x = document.getElementsByClassName(slideId[no]);
                if (n > x.length) {
                    slideIndex[no] = 1
                }
                if (n < 1) {
                    slideIndex[no] = x.length
                }
                for (i = 0; i < x.length; i++) {
                    x[i].style.display = "none";
                }
                x[slideIndex[no] - 1].style.display = "block";
            }
        </script>
    </body>
</html>
