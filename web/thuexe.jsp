<%-- 
    Document   : thuexe
    Created on : Feb 17, 2022, 3:57:30 PM
    Author     : Administrator
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="model.Car"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Thuê Xe</title>
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
                            <li style="padding: 10px 2px;"><a  href="totalthuexebill">Hóa đơn đã xác nhận</a></li>
                            <li style="padding: 10px 2px;"><a href="xacnhan">Hóa đơn chưa xác nhận</a></li>
                            <li style="padding: 10px 2px;"><a href="logout">Đăng xuất</a></li>
                        </ul>
                    </div>

                </div>

            </div>

        </nav>


        <!-- nav end-->
        <%Car car = (Car) request.getAttribute("choosed_car_info");%>
        
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
        <%ArrayList<Car> listcar = (ArrayList<Car>) request.getAttribute("listcar");%>
        <!--slide show car-->
        <div class="slideshow-container" style="margin-top: 50px;">
            <%int idx3 = 0;%>
            <%for (int idx = 0; idx < listcar.size(); idx++){int count = 0;%>
            <div class="mySlides1 row">
                <%for (int idx2 = idx3; idx2 < listcar.size(); idx2++){%>
                <div class="col-md-3" >
                    <a  href="thuexe?getcar_id=<%=listcar.get(idx2).getId()%>" >
                        <img src="<%=listcar.get(idx2).getImg()%>" title="<%=listcar.get(idx2).getNameCat()%> <%=listcar.get(idx2).getName()%>"></a>
                </div>
                <%count++;%>    
                <%if(idx2==listcar.size()-1)idx2=-1;%>  <!--cuoi list hiển thị lại -->
                <%if(count==4)break;%>
                
                <%}%>
                <%idx3++;%>
                <%if(idx3==listcar.size())idx3=0;%>    <!--cuoi list hiển thị lại -->             
            </div>
            
            
            <%}%>
            <a class="prev" onclick="plusSlides(-1, 0)">&#10094;</a>
            <a class="next" onclick="plusSlides(1, 0)">&#10095;</a>
            <i style="color: red; display: none;display: ${msg}">Hãy điền đầy đủ thông tin của quý khách</i>
        </div>
        <!--slide end-->
        
        
        
        
        
         
        <form action="thuexe" method="post">
           
            <input name="car_id_choose" type="hidden" value="<%=car.getId()%>">
            <div style="margin-top: 20px;" class="row choosecar">
                <div class=" col-md-offset-1 col-md-5" style="width: 40%"><img class="img_xethue" src="<%=car.getImg()%>"></div>
                <div class=" col-md-6"><h1 style="margin-bottom: 50px;"><%=car.getNameCat()%> <%=car.getName()%></h1>
                    <div class="row">
                        <div class="col-md-6">
                            <h5>Dòng xe</h5>
                            <p><%=infoCar%></p>
                        </div>
                        <div class="col-md-3" style="text-align: right">
                            <h5>Giá/ngày</h5>
                            <p><%=car.getPrice()%> VND</p>
                        </div>
                        <div class="col-md-3"></div>
                    </div>
                        
                    
                    

                        <div class="row" style="margin-top: 20px">
                        <div class="col-md-4">
                            <h5>Thuê theo</h5>
                            <select name="donvithue" >
                                <option name="donvithue" value="ngay" ${checkngay}>Ngày</option>
                                <option name="donvithue" value="thang"${checkthang}>Tháng</option>
                                <option name="donvithue" value="nam"${checknam}>Năm</option> 
                            </select>
                         <input style="width: 100px ;border-color: ${thoiluongthue_err}" type="number" placeholder="Thời lượng" min="1" max="5" name="thoiluongthue" value="${thoiluongthue}">
                           <i style="color: red;display: none;display: ${thoiluongthuexeblock}" >Hãy điền lại thông tin </i>
                        </div> 
                         <div class="col-md-5" style="text-align: right">
                             <h5>Ngày bắt đầu thuê xe</h5>
                             <input name="startday" type="date" value="${startday}" min="<%=java.time.LocalDate.now()%>">
                             <span> <i style="color: red;display: none;display: ${startdayblock}" class="glyphicon glyphicon-remove">Hãy điền lại thông tin</i></span>
                             
                         </div>
                        <div class="col-md-3"></div>
                    </div>
                    
                                                   
                </div>
            </div>
                             
            <div class="table_info_customer">
                <h3>Thông tin khách hàng</h3>
                
                <table class="info_customer">
                    <tr>
                        <td><h5>Quý khách là ai? <span style="color: blue">*</span></h5></td>

                    </tr>
                    <tr > 
                        <td colspan="2">
                            <select name="customer_type" >
                                <option name="customer_type" value="canhan" ${checkcanhan}>Cá Nhân</option>
                                <option name="customer_type" value="doanhnghiep" ${checkdoanhnghiep}>Doanh Nghiệp</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td><h5>Họ tên cá nhân <span style="color: blue">*<i style="color: red;display: none;display: ${nameblock}" >Hãy điền lại họ và tên </i></span></h5></td>
                        <td><h5>CMND/CCCD <span style="color: blue">*<i style="color: red;display: none;display: ${CMNDblock}" >Hãy điền lại CMND/CCCD </i></span></h5></td>
                    </tr>
                    
                    <tr>
                        <td>
                            <input type="text" name="name_customer" value="${name_customer}" >
                        </td>
                        <td><input type="text" name="CMND_customer" value="${CMND_customer}" ></td>
                    </tr>
                   
                    <tr>
                        <td><h5>Số điện thoại <span style="color: blue">*<i style="color: red;display: none;display: ${phoneblock}" >Hãy điền lại số điện thoại </i></span></h5></td>
                        <td><h5>Email <span style="color: blue">*<i style="color: red;display: none;display: ${emailblock}" >Hãy điền lại email </i></span></h5></td>
                    </tr>
                    <tr>
                        <td><input type="text" name="phone_customer" value="${phone_customer}" style=" border-color:${phone_customer_err}"></td>
                        <td><input type="text" name="email_customer" value="${email_customer}" style=" border-color:${email_customer_err}"></td>
                    </tr>
                    <tr>
                        <td><h5>Mã giới thiệu</h5></td>
                    </tr>
                    <tr>
                        <td colspan="2" class="code_gioithieu"><input type="text" name="gioithieu_code_customer" placeholder="Nhập mã người giới thiệu" value="${gioithieu_code_customer}">
                        </td>

                    </tr>
                    <tr>
                        <td>
                            <input type="checkbox" name="check1" ${check1} style=" border-color:${check1_err}" value="sure"><span> Tôi cam kết các thông tin đã cung cấp tại đây hoàn toàn chính xác.</span>
                            <i style="color: red;display: none;display: ${check1block}" >Hãy xác nhận lại</i>
                        </td>
                    </tr>
                    <tr>
                        <td class="thuexe_btn_thuexe" colspan="2"><button class="btn_thuexe" type="submit" id="btn_thuexe">Thuê Xe</button><i style="color: red; display: none;display: ${msg}">Hãy điền đầy đủ thông tin của quý khách</i></td>
                        
                    </tr>
                    
                </table>
            </div> 
        </form>

        <!--footer-->
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
var slideIndex = [1,1];
var slideId = ["mySlides1", "mySlides2"]
showSlides(1, 0);
showSlides(1, 1);

function plusSlides(n, no) {
  showSlides(slideIndex[no] += n, no);
}

function showSlides(n, no) {
  var i;
  var x = document.getElementsByClassName(slideId[no]);
  if (n > x.length) {slideIndex[no] = 1}    
  if (n < 1) {slideIndex[no] = x.length}
  for (i = 0; i < x.length; i++) {
     x[i].style.display = "none";  
  }
  x[slideIndex[no]-1].style.display = "block";  
}
</script>
    </body>
</html>
