package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import model.Message;
import java.util.ArrayList;

public final class Messenger_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!--Chat-->\n");
ArrayList<Message> MYR = (ArrayList<Message>) request.getAttribute("MYR");
      out.write('\n');
ArrayList<Message> MYS = (ArrayList<Message>) request.getAttribute("MYS");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<div id=\"mess2\" class=\"message2\">\n");
      out.write("    <span onclick=\"showMessage()\" class=\"glyphicon glyphicon-chevron-up\"></span>           \n");
      out.write("</div>\n");
      out.write("<div id=\"mess\" class=\"message\" style=\"display: ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${admin}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(";display: block\">\n");
      out.write("    <div class=\"header_message row\">\n");
      out.write("        <div class=\"col-md-10\">\n");
      out.write("\n");
      out.write("            ");
if (MYR != null && MYR.get(0).getTo().equals("45")) {
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("            <a href=\"home\"><h4><b>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${usersend}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</b></h4></a>\n");
      out.write("                        ");
} else {
      out.write("\n");
      out.write("            <img src=\"images/logoBossCarCare2.png\" width=\"30%\">\n");
      out.write("            <h4><b>Hỗ trợ trực tuyến</b></h4>  <!-- default and user -->\n");
      out.write("            ");
}
      out.write("\n");
      out.write("        </div>\n");
      out.write("        <div class=\"col-md-2\" >\n");
      out.write("            <span onclick=\"hideMessage()\" class=\"glyphicon glyphicon-chevron-down\"></span>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("    <div class=\"content_message\" style=\"display: block;display: ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${messageadmin}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\n");
      out.write("\n");
      out.write("        <img src=\"images/logoBossCarCare2.png\" width=\"70%\">\n");
      out.write("        <h6>Trao cơ hội tạo - Tạo niềm tin</h6>\n");
      out.write("\n");
      out.write("        ");
if (MYR != null && MYS != null) {
      out.write("<!--1-->\n");
      out.write("\n");
      out.write("        ");
int MYRidx = 0, MYSidx = 0, MYRid = 0, MYSid = 0, MYRidOLD = 0, MYSidOLD = 0;
      out.write("\n");
      out.write("        ");
for (int idx = 0; idx < MYS.size() + MYR.size(); idx++) {
      out.write("<!--2-->\n");
      out.write("        ");
 MYRid = Integer.parseInt(MYR.get(MYRidx).getId());
      out.write("\n");
      out.write("        ");
 MYSid = Integer.parseInt(MYS.get(MYSidx).getId());
      out.write("\n");
      out.write("        ");
if (MYRid > MYSid) {
      out.write("<!--3-->\n");
      out.write("        ");
if (MYRidOLD == MYRid && MYSidOLD == MYSid && MYSidx == MYS.size() - 1) {
      out.write("\n");
      out.write("        ");
for (int j = 0; j <= MYR.size(); j++) {
      out.write("\n");
      out.write("        ");
if (MYRidx == MYR.size()) {
                        break;
                    }
      out.write("\n");
      out.write("        <div class=\"MYR\"><p>");
      out.print(MYR.get(MYRidx++).getContent());
      out.write("</p></div>\n");
      out.write("                ");
}
      out.write("\n");
      out.write("\n");
      out.write("        ");
break;
                } else {
      out.write("\n");
      out.write("\n");
      out.write("        <div class=\"divMYS\">\n");
      out.write("            <div class=\"MYS_EMP\"></div>\n");
      out.write("            <div class=\"MYS\"><p>");
      out.print(MYS.get(MYSidx).getContent());
      out.write("</p></div></div>\n");
      out.write("\n");
      out.write("        ");
  MYRidOLD = MYRid;
            MYSidOLD = MYSid;
        
      out.write("\n");
      out.write("\n");
      out.write("        ");
if (MYSidx + 1 != MYS.size()) {
                        MYSidx++;
                    }
      out.write("\n");
      out.write("        ");
}
      out.write("\n");
      out.write("\n");
      out.write("        ");
}
      out.write("<!--3-->\n");
      out.write("\n");
      out.write("        ");
if (MYRid < MYSid) {
      out.write("<!--4-->\n");
      out.write("\n");
      out.write("        ");
if (MYRidOLD == MYRid && MYSidOLD == MYSid && MYRidx == MYR.size() - 1) {
      out.write("  \n");
      out.write("        ");
for (int j = 0; j <= MYS.size(); j++) {
      out.write("\n");
      out.write("        ");
if (MYSidx == MYS.size()) {
                        break;
                    }
      out.write("\n");
      out.write("        <div class=\"divMYS\">\n");
      out.write("\n");
      out.write("            <div class=\"MYS\"><p>");
      out.print(MYS.get(MYSidx++).getContent());
      out.write("</p></div> </div>  \n");
      out.write("                    ");
 }
      out.write("\n");
      out.write("\n");
      out.write("        ");
break;
                } else {
      out.write("\n");
      out.write("\n");
      out.write("        <div class=\"MYR\"><p>");
      out.print(MYR.get(MYRidx).getContent());
      out.write("</p></div>\n");
      out.write("\n");
      out.write("        ");
MYRidOLD = MYRid;
                    MYSidOLD = MYSid;
      out.write("\n");
      out.write("        ");
if (MYRidx + 1 != MYR.size()) {
                        MYRidx++;
                    }
      out.write("\n");
      out.write("        ");
}
      out.write("\n");
      out.write("\n");
      out.write("        ");
}
      out.write("<!--4-->\n");
      out.write("\n");
      out.write("        ");
}
      out.write("<!--2-->\n");
      out.write("        ");
}
      out.write("<!--1-->\n");
      out.write("        ");
if (MYS != null && MYR == null) {
      out.write("         <!--trường hợp có mỗi table người dùng gửi tồn tại -->\n");
      out.write("\n");
      out.write("        ");
for (Message mess : MYS) {
      out.write("\n");
      out.write("        <div class=\"MYS\"><p>");
      out.print(mess.getContent());
      out.write("</p></div>     \n");
      out.write("                ");
}
      out.write("\n");
      out.write("                ");
}
      out.write("    \n");
      out.write("\n");
      out.write("\n");
      out.write("        ");
if (MYS == null && MYR != null) {
      out.write("         <!--trường hợp có mỗi table Admin gửi tồn tại -->\n");
      out.write("        ");
for (Message mess : MYR) {
      out.write("\n");
      out.write("        <div class=\"MYR\"><p>");
      out.print(mess.getContent());
      out.write("</p></div>     \n");
      out.write("                ");
}
      out.write("\n");
      out.write("                ");
}
      out.write("\n");
      out.write("\n");
      out.write("    </div>\n");
      out.write("    <div id=\"menumess\" class=\"menu_message\">\n");
      out.write("        <form action=\"message\" method=\"post\">\n");
      out.write("            <input name=\"contentsend\" type=\"text\" placeholder=\"Viết gì đó...\">\n");
      out.write("\n");
      out.write("\n");
      out.write("            <button name=\"to\" type=\"submit\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${to}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">Send</button>\n");
      out.write("        </form>\n");
      out.write("    </div>\n");
      out.write("</div>\n");
      out.write("<!--chat end-->\n");
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
