<%-- 
    Document   : home
    Created on : Jan 29, 2022, 11:38:50 PM
    Author     : Administrator
--%>

<%@page import="model.Message"%>
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
                    <div class="dropdown" style="display: none;${nav_user}">  <!--for USER-->
                        <button style="background-color: white;color: black;border: none" class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown"><span class="glyphicon glyphicon-user"> ${email_user}</span>
                        </button>

                        <ul class="dropdown-menu" >                              
                            <li style="padding: 10px 2px;"><a  href="totalthuexebill?type=thuexe">Hóa đơn đã xác nhận</a></li>
                            <li style="padding: 10px 2px;"><a href="xacnhan">Hóa đơn chưa xác nhận</a></li>
                            <li style="padding: 10px 2px;"><a href="logout">Đăng xuất</a></li>
                        </ul>

                    </div>

                    <div class="dropdown" style="display: none;${manage}">   <!--for ADMIN-->
                        <button style="background-color: white;color: black;border: none" class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown"><span class="glyphicon glyphicon-user"> ${email_user}</span>
                        </button>

                        <ul class="dropdown-menu" >                              
                            <li style="padding: 10px 2px;"><a  href="manage">Quản lý hóa đơn</a></li>
                            <li style="padding: 10px 2px;"><a href="manage?typepage=tainguyen">Quản lý tài nguyên</a></li>
                            <li style="padding: 10px 2px;"><a href="logout">Đăng xuất</a></li>
                        </ul>

                    </div>

                </div>

            </div>

        </nav>

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
                <form action="baoduong" method="get" >
                    <button class="" id="btn_thuexe" value="" name="">bảo dưỡng xe</button>
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
                    case "sendan":
                        infoCar = "SENDAN";
                        break;
                    case "SUV":
                        infoCar = "SUV";
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
        <%ArrayList<Message> MYR = (ArrayList<Message>) request.getAttribute("MYR");%>
        <%ArrayList<Message> MYS = (ArrayList<Message>) request.getAttribute("MYS");%>


        <div id="mess2" class="message2">
            <span onclick="showMessage()" class="glyphicon glyphicon-chevron-up"></span>           
        </div>
        <div id="mess" class="message" style="display: ${admin};display: block">
            <div class="header_message row">
                <div class="col-md-10">

                    <%if (MYR != null && MYR.get(0).getTo().equals("45")) {%>


                    <a href="home"><h4><b>${usersend}</b></h4></a>
                                <%} else {%>
                    <img src="images/logoBossCarCare2.png" width="30%">
                    <h4><b>Hỗ trợ trực tuyến</b></h4>  <!-- default and user -->
                    <%}%>
                </div>
                <div class="col-md-2" >
                    <span onclick="hideMessage()" class="glyphicon glyphicon-chevron-down"></span>
                </div>
            </div>
            <div class="content_message" style="display: block;display: ${messageadmin}">

                <img src="images/logoBossCarCare2.png" width="70%">
                <h6>Trao cơ hội tạo - Tạo niềm tin</h6>

                <%if (MYR != null && MYS != null) {%><!--1-->

                <%int MYRidx = 0, MYSidx = 0, MYRid = 0, MYSid = 0, MYRidOLD = 0, MYSidOLD = 0;%>
                <%for (int idx = 0; idx < MYS.size() + MYR.size(); idx++) {%><!--2-->
                <% MYRid = Integer.parseInt(MYR.get(MYRidx).getId());%>
                <% MYSid = Integer.parseInt(MYS.get(MYSidx).getId());%>
                <%if (MYRid > MYSid) {%><!--3-->
                <%if (MYRidOLD == MYRid && MYSidOLD == MYSid && MYSidx == MYS.size() - 1) {%>
                <%for (int j = 0; j <= MYR.size(); j++) {%>
                <%if (MYRidx == MYR.size()) {
                                break;
                            }%>
                <div class="MYR"><p><%=MYR.get(MYRidx++).getContent()%></p></div>
                        <%}%>

                <%break;
                    } else {%>

                <div class="divMYS">
                    <div class="MYS_EMP"></div>
                    <div class="MYS"><p><%=MYS.get(MYSidx).getContent()%></p></div></div>

                <%  MYRidOLD = MYRid;
                    MYSidOLD = MYSid;
                %>

                <%if (MYSidx + 1 != MYS.size()) {
                            MYSidx++;
                        }%>
                <%}%>

                <%}%><!--3-->

                <%if (MYRid < MYSid) {%><!--4-->

                <%if (MYRidOLD == MYRid && MYSidOLD == MYSid && MYRidx == MYR.size() - 1) {%>  
                <%for (int j = 0; j <= MYS.size(); j++) {%>
                <%if (MYSidx == MYS.size()) {
                            break;
                        }%>
                <div class="divMYS">

                    <div class="MYS"><p><%=MYS.get(MYSidx++).getContent()%></p></div> </div>  
                            <% }%>

                <%break;
                    } else {%>

                <div class="MYR"><p><%=MYR.get(MYRidx).getContent()%></p></div>

                <%MYRidOLD = MYRid;
                        MYSidOLD = MYSid;%>
                <%if (MYRidx + 1 != MYR.size()) {
                            MYRidx++;
                        }%>
                <%}%>

                <%}%><!--4-->

                <%}%><!--2-->
                <%}%><!--1-->
                <%if (MYS != null && MYR == null) {%>         <!--trường hợp có mỗi table người dùng gửi tồn tại -->

                <%for (Message mess : MYS) {%>
                <div class="MYS"><p><%=mess.getContent()%></p></div>     
                        <%}%>
                        <%}%>    


                <%if (MYS == null && MYR != null) {%>         <!--trường hợp có mỗi table Admin gửi tồn tại -->
                <%for (Message mess : MYR) {%>
                <div class="MYR"><p><%=mess.getContent()%></p></div>     
                        <%}%>
                        <%}%>

            </div>
            <div id="menumess" class="menu_message">
                <form action="message" method="post">
                    <input name="contentsend" type="text" placeholder="Viết gì đó...">


                    <button name="to" type="submit" value="${to}">Send</button>
                </form>
            </div>
        </div>
        <!--chat end-->
        <%ArrayList<Message> Message1M = (ArrayList<Message>) request.getAttribute("Message1M");%> <!--Admin only-->
        <%if (Message1M != null) {%>
        <div id="mess3" class="message3">
            <span onclick="showMessage2()" class="glyphicon glyphicon-chevron-up"></span>           
        </div>
        <div class="messageAdmin" style="display: ${messageAdmin}">
            <div class="row">
                <h2 class="col-md-10">Message</h2>
            <div class="col-md-2" >
                    <span onclick="hideMessage()" class="glyphicon glyphicon-chevron-down"></span>
            </div>
            </div>
            <%for (int idx = Message1M.size()-1; idx >= 0 ; idx--) {%>

            <div class="messcustomer" onclick="checkInbox(<%=Message1M.get(idx).getFrom()%>)">
                <div>
                    <h4><%=Message1M.get(idx).getFrom()%></h4>
                </div>
                <div>
                    <a href="message?fromid=<%=Message1M.get(idx).getFrom()%>"><b><%=Message1M.get(idx).getContent()%></b></a><p style="font-size: 8px;color: grey"><%=Message1M.get(idx).getTime()%></p>
                </div>
            </div>

            <%}%>


        </div>

        <%}%>
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
            function hideMessage() {
                document.getElementById('mess').style.height = 0;
                document.getElementById('menumess').style.display = 'none';
                document.getElementById('mess2').style.height = '25px';
            }
            function showMessage() {
                document.getElementById('menumess').style.display = 'block';
                document.getElementById('mess').style.height = '400px';
                document.getElementById('mess2').style.height = 0;
            }

            function checkInbox(id) {
                window.location.href = 'message?fromid=' + id;
            }
        </script>
    </body>
</html>


