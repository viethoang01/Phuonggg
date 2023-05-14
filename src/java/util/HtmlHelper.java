/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

public class HtmlHelper {

    public static String hyperlink(String text, String url) {
        return "<a class=\"paging_link\" href=\"" + url + "\" >" + text + "</a>";
    }

    public static String label(String text) {
        return "<span class=\"paging_label\" >" + text + "</span>";
    }

    public static String pager(int gap, int pageindex, int totalpage, String typepage) {
        String result = "";
        if (typepage.equals("1")) {
            if (pageindex - gap > 1) {
                result += hyperlink("First", "?page=1"+"&typepage="+typepage);
            }

            for (int i = gap; i > 0; i--) {
                int page = pageindex - i;
                if (page > 0) {
                    result += hyperlink("" + page, "?page=" + page+"&typepage="+typepage);
                }
            }

            result += label(pageindex + "");

            for (int i = 1; i <= gap; i++) {
                int page = pageindex + i;
                if (page <= totalpage) {
                    result += hyperlink("" + page, "?page=" + page+"&typepage="+typepage);
                }
            }

            if (pageindex + gap < totalpage) {
                result += hyperlink("Last", "?page=" + totalpage+"&typepage="+typepage);
            }
        } else if(typepage.equals(0)){
            if (pageindex - gap > 1) {
                result += hyperlink("First", "?page=1");
            }

            for (int i = gap; i > 0; i--) {
                int page = pageindex - i;
                if (page > 0) {
                    result += hyperlink("" + page, "?page=" + page);
                }
            }

            result += label(pageindex + "");

            for (int i = 1; i <= gap; i++) {
                int page = pageindex + i;
                if (page <= totalpage) {
                    result += hyperlink("" + page, "?page=" + page);
                }
            }

            if (pageindex + gap < totalpage) {
                result += hyperlink("Last", "?page=" + totalpage);
            }
        }else{
            if (pageindex - gap > 1) {
                result += hyperlink("First", "?page=1&typepage="+typepage);
            }

            for (int i = gap; i > 0; i--) {
                int page = pageindex - i;
                if (page > 0) {
                    result += hyperlink("" + page, "?page=" + page+"&typepage="+typepage);
                }
            }

            result += label(pageindex + "");

            for (int i = 1; i <= gap; i++) {
                int page = pageindex + i;
                if (page <= totalpage) {
                    result += hyperlink("" + page, "?page=" + page+"&typepage="+typepage);
                }
            }

            if (pageindex + gap < totalpage) {
                result += hyperlink("Last", "?page=" + totalpage+"&typepage="+typepage);
            }
        }
        return result;
    }

}
