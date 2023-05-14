package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import model.Message;
import java.util.ArrayList;
import model.Car;

public final class home_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("        <title>Boss Car Care</title>\n");
      out.write("        <link href=\"css/bCar.css\" rel=\"stylesheet\" type=\"text/css\" />\n");
      out.write("        <script src=\"js/bCar.js\"></script>\n");
      out.write("        <link href='https://fonts.googleapis.com/css?family=Be Vietnam Pro' rel='stylesheet'>\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css\">\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>\n");
      out.write("        <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js\"></script>\n");
      out.write("    </head>\n");
      out.write("    <body id=\"home\">\n");
      out.write("        <nav class=\"navbar  header_top row\" style=\"padding-left: 0;padding-right: 0;margin-left: 0;margin-right: 0;border-radius: 0\">\n");
      out.write("            <div class=\"container-fluid\" style=\"padding-left: 0;padding-right: 0;box-sizing: border-box\">\n");
      out.write("                <div class=\"nav_left col-md-9 row\">\n");
      out.write("                    <div class=\"navbar-header col-md-5\">\n");
      out.write("                        <a class=\"navbar-brand\" href=\"home\"><img class=\"logo\" title=\"Boss Car Care\" src=\"images/logoBossCarCare2.png\" alt=\"logoBossCarCare\"></a>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-md-7 row\">\n");
      out.write("                        <div class=\"col-md-3\"><a href=\"home#dichvu\">Dịch vụ</a></div>\n");
      out.write("                        <div class=\"col-md-3\"><a href=\"home#congcu\">Công cụ</a></div>\n");
      out.write("                        <div class=\"col-md-3\"><a href=\"home#banggia\">Bảng giá</a></div>\n");
      out.write("                        <div class=\"col-md-3\"><a href=\"home#tintuc\">Tin tức</a></div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"nav_right col-md-3\">\n");
      out.write("                    <div style=\"display: block; ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${nav_btn_taikhoan}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" class=\" class_btn\"> <a href=\"login.jsp\" id=\"btn_spring\" title=\"Login\">TÀI KHOẢN</a></div>\n");
      out.write("                    <div class=\"dropdown\" style=\"display: none;");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${nav_user}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">  <!--for USER-->\n");
      out.write("                        <button style=\"background-color: white;color: black;border: none\" class=\"btn btn-primary dropdown-toggle\" type=\"button\" data-toggle=\"dropdown\"><span class=\"glyphicon glyphicon-user\"> ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${email_user}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</span>\n");
      out.write("                        </button>\n");
      out.write("\n");
      out.write("                        <ul class=\"dropdown-menu\" >                              \n");
      out.write("                            <li style=\"padding: 10px 2px;\"><a  href=\"totalthuexebill?type=thuexe\">Hóa đơn đã xác nhận</a></li>\n");
      out.write("                            <li style=\"padding: 10px 2px;\"><a href=\"xacnhan\">Hóa đơn chưa xác nhận</a></li>\n");
      out.write("                            <li style=\"padding: 10px 2px;\"><a href=\"logout\">Đăng xuất</a></li>\n");
      out.write("                        </ul>\n");
      out.write("\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                    <div class=\"dropdown\" style=\"display: none;");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${manage}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">   <!--for ADMIN-->\n");
      out.write("                        <button style=\"background-color: white;color: black;border: none\" class=\"btn btn-primary dropdown-toggle\" type=\"button\" data-toggle=\"dropdown\"><span class=\"glyphicon glyphicon-user\"> ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${email_user}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</span>\n");
      out.write("                        </button>\n");
      out.write("\n");
      out.write("                        <ul class=\"dropdown-menu\" >                              \n");
      out.write("                            <li style=\"padding: 10px 2px;\"><a  href=\"manage\">Quản lý hóa đơn</a></li>\n");
      out.write("                            <li style=\"padding: 10px 2px;\"><a href=\"manage?typepage=tainguyen\">Quản lý tài nguyên</a></li>\n");
      out.write("                            <li style=\"padding: 10px 2px;\"><a href=\"logout\">Đăng xuất</a></li>\n");
      out.write("                        </ul>\n");
      out.write("\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("        </nav>\n");
      out.write("\n");
      out.write("        <div class=\"row\" >\n");
      out.write("            <div class=\"col-md-12\">\n");
      out.write("                <!--Bắt đầu slider-->\n");
      out.write("                <div id=\"carousel-example-generic\" class=\"carousel slide\" data-ride=\"carousel\">\n");
      out.write("                    <!-- Indicators -->\n");
      out.write("                    <ol class=\"carousel-indicators\">\n");
      out.write("                        <li data-target=\"#carousel-example-generic\" data-slide-to=\"0\" class=\"active\"></li>\n");
      out.write("                        <li data-target=\"#carousel-example-generic\" data-slide-to=\"1\"></li>\n");
      out.write("                        <li data-target=\"#carousel-example-generic\" data-slide-to=\"2\"></li>\n");
      out.write("                        <li data-target=\"#carousel-example-generic\" data-slide-to=\"3\"></li>\n");
      out.write("                    </ol>\n");
      out.write("\n");
      out.write("                    <!-- Wrapper for slides -->\n");
      out.write("                    <div class=\"carousel-inner\">\n");
      out.write("                        <div class=\"item active\">\n");
      out.write("                            <img src=\"images/silde3.jfif\" alt=\"carcare\">\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <div class=\"item\">\n");
      out.write("                            <img src=\"images/slide2.jfif\" alt=\"carcare\">\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <div class=\"item\">\n");
      out.write("                            <img src=\"images/slide1.jpg\" alt=\"carcare\">\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                    <!-- Controls -->\n");
      out.write("                    <a class=\"left carousel-control\" href=\"#carousel-example-generic\" role=\"button\" data-slide=\"prev\">\n");
      out.write("                        <span class=\"glyphicon glyphicon-chevron-left\"></span>\n");
      out.write("                    </a>\n");
      out.write("                    <a class=\"right carousel-control\" href=\"#carousel-example-generic\" role=\"button\" data-slide=\"next\">\n");
      out.write("                        <span class=\"glyphicon glyphicon-chevron-right\"></span>\n");
      out.write("                    </a>\n");
      out.write("                </div>\n");
      out.write("            </div> \t\n");
      out.write("        </div> \t\t\n");
      out.write("        <!--Kết thúc slider-->\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        <div class=\"container\" id=\"dichvu\">\n");
      out.write("\n");
      out.write("\n");
      out.write("            <h2 class=\"header\" id=\"detailing\" onclick=\"detailing()\">Detailing</h2>\n");
      out.write("            <h2 class=\"header\" id=\"process\" onclick=\"process()\">Quy trình rửa xe</h2>\n");
      out.write("            <div >\n");
      out.write("                <div id = \"detailing-content\">\n");
      out.write("                    <img src=\"images/imgcontent3.png\" alt=\"detailcarcare\">\n");
      out.write("                    <ul>\n");
      out.write("                        <li><p>Detailing không chỉ là một quá trình làm sạch để làm cho một chiếc xe trông đẹp, mà là một cách tiếp cận có hệ thống để giúp kéo dài tuổi thọ của nó bằng các phương pháp và sản phẩm làm giảm các yếu tố môi trường gây hại như bụi bẩn, ánh nắng mặt trời, mùa đông khắc nghiệt, v.v. Bảo dưỡng hoặc phục hồi xe thích hợp để giữ cho xe trông bên ngoài và bên trong như thể chúng đến từ phòng trưng bày của đại lý ô tô làm tăng giá trị bán lại của chúng. Chi tiết tự động đòi hỏi kiến ​​thức về kỹ thuật và sử dụng các công cụ và sản phẩm thích hợp.</p></li>\n");
      out.write("                        <li><p>Chi tiết thường được chia thành hai loại: ngoại thất và nội thất (hoặc cabin). Có những sản phẩm và dịch vụ tập trung đặc biệt vào hai lĩnh vực này.</p></li>\n");
      out.write("\n");
      out.write("                    </ul>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <div id = \"process-content\">\n");
      out.write("                    <img src=\"images/imgcontent2.jpg\" alt=\"detailcarcare\">\n");
      out.write("                    <div class=\"row\">\n");
      out.write("                        <div class=\"col-md-offset-1 col-md-2\">\n");
      out.write("                            <img src=\"images/process_care1.jpg\">\n");
      out.write("                            <p>Bước 1: Phun nước xịt rửa bên ngoài ô tô</p>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"col-md-2\">\n");
      out.write("                            <img src=\"images/process_care2.jpg\">\n");
      out.write("                            <p>Bước 2: Rửa thân xe</p>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"col-md-2\">\n");
      out.write("                            <img src=\"images/process_care3.jpg\">\n");
      out.write("                            <p>Bước 3: Lau khô, đánh bóng lốp xe</p>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"col-md-2\">\n");
      out.write("                            <img src=\"images/process_care4.jpg\">\n");
      out.write("                            <p>Bước 4: Dọn vệ sinh nội thất</p>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"col-md-2\">\n");
      out.write("                            <img src=\"images/process_care5.jpg\">\n");
      out.write("                            <p>Bước 5: Kiểm tra lại tình trạng xe</p>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("                <form action=\"baoduong\" method=\"get\" >\n");
      out.write("                    <button class=\"\" id=\"btn_thuexe\" value=\"\" name=\"\">bảo dưỡng xe</button>\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("        <!--thue xe-->\n");
      out.write("        <div  class=\"container\" id=\"congcu\"><h2 class=\"header\">Thuê xe đa năng</h2></div>\n");
      out.write("        ");
ArrayList<Car> listcar = (ArrayList<Car>) request.getAttribute("listcar");
      out.write("\n");
      out.write("        <div class=\"slideshow-container\" >\n");
      out.write("            ");
for (Car car : listcar) {
      out.write("\n");
      out.write("            ");

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
            
      out.write("\n");
      out.write("            <div class=\"mySlides1 row\" style=\"height: 300px;\">\n");
      out.write("                <div class=\"col-md-offset-1 col-md-5\">\n");
      out.write("                    <img class=\"img_xethue\" src=\"");
      out.print(car.getImg());
      out.write("\" >\n");
      out.write("                </div>\n");
      out.write("                <div class=\"col-md-6\">\n");
      out.write("                    <h1 class=\"name_car_h1\">");
      out.print(car.getNameCat());
      out.write(' ');
      out.print(car.getName());
      out.write("</h1>\n");
      out.write("                    <div class=\"row info_car_div\">\n");
      out.write("                        <div class=\"col-md-6\">\n");
      out.write("                            <h5>Dòng xe</h5>\n");
      out.write("                            <h4>");
      out.print(infoCar);
      out.write("</h4>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"col-md-3 text_right\">\n");
      out.write("                            <h5>Giá\\ngày</h5>\n");
      out.write("                            <h4>");
      out.print(car.getPrice());
      out.write(" vnd</h4>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"col-md-3\"></div>\n");
      out.write("\n");
      out.write("                    </div>\n");
      out.write("                    <form action=\"thuexe\" method=\"get\">\n");
      out.write("                        <button class=\"\" id=\"btn_thuexe\" value=\"");
      out.print( car.getId());
      out.write("\" name=\"getcar_id\">THUÊ XE</button>\n");
      out.write("                    </form>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("            ");
}
      out.write("\n");
      out.write("            <a class=\"prev\" onclick=\"plusSlides(-1, 0)\">&#10094;</a>\n");
      out.write("            <a class=\"next\" onclick=\"plusSlides(1, 0)\">&#10095;</a>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <p><strong><span class=\"glyphicon glyphicon-earphone\" ></span>\n");
      out.write("                    Đặt thuê ngay: </strong>09888903540\n");
      out.write("\n");
      out.write("            </p>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <!-- end thue xe-->\n");
      out.write("\n");
      out.write("\n");
      out.write("        <div class=\"container\" style=\"clear: both\" id=\"tintuc\">\n");
      out.write("            <h2 class=\"header\">Tin Tức</h2>\n");
      out.write("\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <div class=\"row footer\">\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <img class=\"col-md-offset-5 col-md-7\" src=\"images/logoBossCarCare2.png\" alt=\"\">\n");
      out.write("            </div>\n");
      out.write("            <div class=\"row content1\">\n");
      out.write("                <ul class=\"col-md-3\">\n");
      out.write("                    <li>GIỚI THIỆU</li>\n");
      out.write("                    <li><a href=\"#\">Về Boss Car</a></li>\n");
      out.write("                    <li><a href=\"#\">Về Qúa trình thành lập</a></li>\n");
      out.write("                    <li><a href=\"#\">Tương Lai Boss Car</a></li>\n");
      out.write("                </ul>\n");
      out.write("                <ul class=\"col-md-3\">\n");
      out.write("                    <li>TIN TỨC NỔI BẬT</li>\n");
      out.write("                    <li><a href=\"#\">Ưu Đãi</a></li>\n");
      out.write("                    <li><a href=\"#\">Công Ty</a></li>\n");
      out.write("                    <li><a href=\"#\">Cộng Đồng</a></li>\n");
      out.write("                </ul class=\"col-md-3\">\n");
      out.write("                <ul class=\"col-md-3\">\n");
      out.write("                    <li>HỖ TRỢ</li>\n");
      out.write("                    <li><a href=\"#\">Câu Hỏi Thường Gặp</a></li>\n");
      out.write("                    <li><a href=\"#\">Hệ Thống Phân Phối</a></li>\n");
      out.write("                    <li><a href=\"#\">Liên Hệ</a></li>\n");
      out.write("                    <li><a href=\"#\">Đặt Lịch Bảo Dưỡng</a></li>\n");
      out.write("                </ul>\n");
      out.write("                <ul class=\"col-md-3\">\n");
      out.write("                    <li>PHÁP LÝ</li>\n");
      out.write("                    <li><a href=\"#\">Chính sách quyền riêng tư</a></li>\n");
      out.write("                    <li><a href=\"#\">Chính sách vận chuyển</a></li>\n");
      out.write("                    <li><a href=\"#\">Chính sách đổi trả</a></li>\n");
      out.write("                    <li><a href=\"#\">Miễn trừ trách nhiệm</a></li>\n");
      out.write("                    <li><a href=\"#\">Điều khoản ký kết thỏa thuận đặt cọc mua Ô tô</a></li>\n");
      out.write("                    <li><a href=\"#\">Điều kiện sử dụng cookies</a></li>\n");
      out.write("                </ul>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"content2\">\n");
      out.write("                <ul class=\"row\">\n");
      out.write("                    <li class=\"col-md-4\" ><a href=\"https://g.page/Boss-Car-Care-Hanoi?share\" target=\"_blank\" style=\"color: black;\">\n");
      out.write("                            <strong> Địa chỉ:</strong>Center Point: No.DM6-13,Trade village Vạn Phúc-Hà Đông-Hà Nội</a></li>\n");
      out.write("                    <li class=\"col-md-4\"><strong>Số đăng ký kinh doanh:</strong> 0108926276 <br>\n");
      out.write("                        <strong>Đăng ký lần đầu: </strong>Ngày 01 tháng 10 năm 2019 <br>\n");
      out.write("                        <strong>Đăng ký thay đổi lần thứ 3: </strong>Ngày 17 tháng 03 năm 2020<br>\n");
      out.write("                        <strong>Nơi cấp: </strong>Sở Kế hoạch và Đầu tư Thành phố Hà Nội\n");
      out.write("                    </li>\n");
      out.write("                    <li class=\"col-md-4\"><strong>Mail:</strong> hoangnvliu@gmail.com</li>\n");
      out.write("                </ul>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <!--Chat-->\n");
      out.write("        ");
ArrayList<Message> MYR = (ArrayList<Message>) request.getAttribute("MYR");
      out.write("\n");
      out.write("        ");
ArrayList<Message> MYS = (ArrayList<Message>) request.getAttribute("MYS");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        <div id=\"mess2\" class=\"message2\">\n");
      out.write("            <span onclick=\"showMessage()\" class=\"glyphicon glyphicon-chevron-up\"></span>           \n");
      out.write("        </div>\n");
      out.write("        <div id=\"mess\" class=\"message\" style=\"display: ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${admin}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(";display: block\">\n");
      out.write("            <div class=\"header_message row\">\n");
      out.write("                <div class=\"col-md-10\">\n");
      out.write("\n");
      out.write("                    ");
if (MYR != null && MYR.get(0).getTo().equals("45")) {
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                    <a href=\"home\"><h4><b>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${usersend}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</b></h4></a>\n");
      out.write("                                ");
} else {
      out.write("\n");
      out.write("                    <img src=\"images/logoBossCarCare2.png\" width=\"30%\">\n");
      out.write("                    <h4><b>Hỗ trợ trực tuyến</b></h4>  <!-- default and user -->\n");
      out.write("                    ");
}
      out.write("\n");
      out.write("                </div>\n");
      out.write("                <div class=\"col-md-2\" >\n");
      out.write("                    <span onclick=\"hideMessage()\" class=\"glyphicon glyphicon-chevron-down\"></span>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"content_message\" style=\"display: block;display: ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${messageadmin}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\n");
      out.write("\n");
      out.write("                <img src=\"images/logoBossCarCare2.png\" width=\"70%\">\n");
      out.write("                <h6>Trao cơ hội tạo - Tạo niềm tin</h6>\n");
      out.write("\n");
      out.write("                ");
if (MYR != null && MYS != null) {
      out.write("<!--1-->\n");
      out.write("\n");
      out.write("                ");
int MYRidx = 0, MYSidx = 0, MYRid = 0, MYSid = 0, MYRidOLD = 0, MYSidOLD = 0;
      out.write("\n");
      out.write("                ");
for (int idx = 0; idx < MYS.size() + MYR.size(); idx++) {
      out.write("<!--2-->\n");
      out.write("                ");
 MYRid = Integer.parseInt(MYR.get(MYRidx).getId());
      out.write("\n");
      out.write("                ");
 MYSid = Integer.parseInt(MYS.get(MYSidx).getId());
      out.write("\n");
      out.write("                ");
if (MYRid > MYSid) {
      out.write("<!--3-->\n");
      out.write("                ");
if (MYRidOLD == MYRid && MYSidOLD == MYSid && MYSidx == MYS.size() - 1) {
      out.write("\n");
      out.write("                ");
for (int j = 0; j <= MYR.size(); j++) {
      out.write("\n");
      out.write("                ");
if (MYRidx == MYR.size()) {
                                break;
                            }
      out.write("\n");
      out.write("                <div class=\"MYR\"><p>");
      out.print(MYR.get(MYRidx++).getContent());
      out.write("</p></div>\n");
      out.write("                        ");
}
      out.write("\n");
      out.write("\n");
      out.write("                ");
break;
                    } else {
      out.write("\n");
      out.write("\n");
      out.write("                <div class=\"divMYS\">\n");
      out.write("                    <div class=\"MYS_EMP\"></div>\n");
      out.write("                    <div class=\"MYS\"><p>");
      out.print(MYS.get(MYSidx).getContent());
      out.write("</p></div></div>\n");
      out.write("\n");
      out.write("                ");
  MYRidOLD = MYRid;
                    MYSidOLD = MYSid;
                
      out.write("\n");
      out.write("\n");
      out.write("                ");
if (MYSidx + 1 != MYS.size()) {
                            MYSidx++;
                        }
      out.write("\n");
      out.write("                ");
}
      out.write("\n");
      out.write("\n");
      out.write("                ");
}
      out.write("<!--3-->\n");
      out.write("\n");
      out.write("                ");
if (MYRid < MYSid) {
      out.write("<!--4-->\n");
      out.write("\n");
      out.write("                ");
if (MYRidOLD == MYRid && MYSidOLD == MYSid && MYRidx == MYR.size() - 1) {
      out.write("  \n");
      out.write("                ");
for (int j = 0; j <= MYS.size(); j++) {
      out.write("\n");
      out.write("                ");
if (MYSidx == MYS.size()) {
                            break;
                        }
      out.write("\n");
      out.write("                <div class=\"divMYS\">\n");
      out.write("\n");
      out.write("                    <div class=\"MYS\"><p>");
      out.print(MYS.get(MYSidx++).getContent());
      out.write("</p></div> </div>  \n");
      out.write("                            ");
 }
      out.write("\n");
      out.write("\n");
      out.write("                ");
break;
                    } else {
      out.write("\n");
      out.write("\n");
      out.write("                <div class=\"MYR\"><p>");
      out.print(MYR.get(MYRidx).getContent());
      out.write("</p></div>\n");
      out.write("\n");
      out.write("                ");
MYRidOLD = MYRid;
                        MYSidOLD = MYSid;
      out.write("\n");
      out.write("                ");
if (MYRidx + 1 != MYR.size()) {
                            MYRidx++;
                        }
      out.write("\n");
      out.write("                ");
}
      out.write("\n");
      out.write("\n");
      out.write("                ");
}
      out.write("<!--4-->\n");
      out.write("\n");
      out.write("                ");
}
      out.write("<!--2-->\n");
      out.write("                ");
}
      out.write("<!--1-->\n");
      out.write("                ");
if (MYS != null && MYR == null) {
      out.write("         <!--trường hợp có mỗi table người dùng gửi tồn tại -->\n");
      out.write("\n");
      out.write("                ");
for (Message mess : MYS) {
      out.write("\n");
      out.write("                <div class=\"MYS\"><p>");
      out.print(mess.getContent());
      out.write("</p></div>     \n");
      out.write("                        ");
}
      out.write("\n");
      out.write("                        ");
}
      out.write("    \n");
      out.write("\n");
      out.write("\n");
      out.write("                ");
if (MYS == null && MYR != null) {
      out.write("         <!--trường hợp có mỗi table Admin gửi tồn tại -->\n");
      out.write("                ");
for (Message mess : MYR) {
      out.write("\n");
      out.write("                <div class=\"MYR\"><p>");
      out.print(mess.getContent());
      out.write("</p></div>     \n");
      out.write("                        ");
}
      out.write("\n");
      out.write("                        ");
}
      out.write("\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("            <div id=\"menumess\" class=\"menu_message\">\n");
      out.write("                <form action=\"message\" method=\"post\">\n");
      out.write("                    <input name=\"contentsend\" type=\"text\" placeholder=\"Viết gì đó...\">\n");
      out.write("\n");
      out.write("\n");
      out.write("                    <button name=\"to\" type=\"submit\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${to}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">Send</button>\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <!--chat end-->\n");
      out.write("        ");
ArrayList<Message> Message1M = (ArrayList<Message>) request.getAttribute("Message1M");
      out.write(" <!--Admin only-->\n");
      out.write("        ");
if (Message1M != null) {
      out.write("\n");
      out.write("        <div id=\"mess3\" class=\"message3\">\n");
      out.write("            <span onclick=\"showMessage2()\" class=\"glyphicon glyphicon-chevron-up\"></span>           \n");
      out.write("        </div>\n");
      out.write("        <div class=\"messageAdmin\" style=\"display: ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${messageAdmin}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <h2 class=\"col-md-10\">Message</h2>\n");
      out.write("            <div class=\"col-md-2\" >\n");
      out.write("                    <span onclick=\"hideMessage()\" class=\"glyphicon glyphicon-chevron-down\"></span>\n");
      out.write("            </div>\n");
      out.write("            </div>\n");
      out.write("            ");
for (int idx = Message1M.size()-1; idx >= 0 ; idx--) {
      out.write("\n");
      out.write("\n");
      out.write("            <div class=\"messcustomer\" onclick=\"checkInbox(");
      out.print(Message1M.get(idx).getFrom());
      out.write(")\">\n");
      out.write("                <div>\n");
      out.write("                    <h4>");
      out.print(Message1M.get(idx).getFrom());
      out.write("</h4>\n");
      out.write("                </div>\n");
      out.write("                <div>\n");
      out.write("                    <a href=\"message?fromid=");
      out.print(Message1M.get(idx).getFrom());
      out.write("\"><b>");
      out.print(Message1M.get(idx).getContent());
      out.write("</b></a><p style=\"font-size: 8px;color: grey\">");
      out.print(Message1M.get(idx).getTime());
      out.write("</p>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            ");
}
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        ");
}
      out.write("\n");
      out.write("        <script>\n");
      out.write("            var slideIndex = [1, 1];\n");
      out.write("            var slideId = [\"mySlides1\", \"mySlides2\"]\n");
      out.write("            showSlides(1, 0);\n");
      out.write("            showSlides(1, 1);\n");
      out.write("\n");
      out.write("            function plusSlides(n, no) {\n");
      out.write("                showSlides(slideIndex[no] += n, no);\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            function showSlides(n, no) {\n");
      out.write("                var i;\n");
      out.write("                var x = document.getElementsByClassName(slideId[no]);\n");
      out.write("                if (n > x.length) {\n");
      out.write("                    slideIndex[no] = 1\n");
      out.write("                }\n");
      out.write("                if (n < 1) {\n");
      out.write("                    slideIndex[no] = x.length\n");
      out.write("                }\n");
      out.write("                for (i = 0; i < x.length; i++) {\n");
      out.write("                    x[i].style.display = \"none\";\n");
      out.write("                }\n");
      out.write("                x[slideIndex[no] - 1].style.display = \"block\";\n");
      out.write("            }\n");
      out.write("            function hideMessage() {\n");
      out.write("                document.getElementById('mess').style.height = 0;\n");
      out.write("                document.getElementById('menumess').style.display = 'none';\n");
      out.write("                document.getElementById('mess2').style.height = '25px';\n");
      out.write("            }\n");
      out.write("            function showMessage() {\n");
      out.write("                document.getElementById('menumess').style.display = 'block';\n");
      out.write("                document.getElementById('mess').style.height = '400px';\n");
      out.write("                document.getElementById('mess2').style.height = 0;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            function checkInbox(id) {\n");
      out.write("                window.location.href = 'message?fromid=' + id;\n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
      out.write("\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
