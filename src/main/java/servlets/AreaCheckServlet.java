package servlets;


import data.Data;
import data.DataConteiner;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

@WebServlet(name = "areaCheckServlet", value = "areaChecker")
public class AreaCheckServlet extends HttpServlet {
    private float x;
    private float y;
    private float r;
    private DataConteiner dataConteiner;

    @Override
    public void init() throws ServletException {
        dataConteiner = new DataConteiner();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        Map<String,String[]> params = req.getParameterMap();
        if (validateX(params.get("x")[0]) & validateY(params.get("y")[0]) & validateR(params.get("r")[0])) {
            boolean hit = false;
            if (firstQaurter() || thirdQaurter() ||forthQuarter()) hit = true;

            ServletContext servletContext = getServletContext();

            dataConteiner.addData(new Data(x,y,r,hit));
            servletContext.setAttribute("table",dataConteiner);

            response.setContentType("text/html; charset=UTF-8");

            PrintWriter out = response.getWriter();


            out.println("<html lang='en'>");
            out.println("<head><meta charset=\"UTF-8\">");
            out.println("<title>Table</title>");
            out.println("<style type=\"text/css\">");
            out.println(".mainTable {\n" +
                    "            width: 100%;\n" +
                    "            text-align: center;\n" +
                    "            border: solid;\n" +
                    "            table-layout: fixed;\n" +
                    "            border-collapse: collapse;\n" +
                    "        }");
            out.println("a::after {\n" +
                    "            content: \"→\";\n" +
                    "        }");
            out.println("a:hover {\n" +
                    "            opacity: .5;\n" +
                    "        }");
            out.println(".hat > td {\n" +
                    "            border-bottom: 1px solid gray;\n" +
                    "            font-size: large;\n" +
                    "            color: brown;\n" +
                    "            font-family: monospace;\n" +
                    "            background-color: antiquewhite;\n" +
                    "        }");
            out.println("body {\n" +
                    "            background-color: aquamarine;\n" +
                    "        }");
            out.println(".inputRow td {\n" +
                    "            background-color: aliceblue;\n" +
                    "            padding-bottom: 1%;\n" +
                    "        }");
            out.println(".inputRow table {\n" +
                    "            margin-left: auto;\n" +
                    "            margin-right: auto;\n" +
                    "        }");
            out.println("th {\n" +
                    "            background-color: aliceblue;\n" +
                    "            padding-top: 1%;\n" +
                    "        }");
            out.println("</style>");
            out.println("</head><body>");
            out.println("<table class=\"mainTable\">");
            out.println(" <tr class=\"hat\">");
            out.println("<td>\n" +
                    "<h3>Tuchin Artem<br>Group P32111 <br>Variant 815</h3>\n" +
                    "</td>");
            out.println("<td><a href=\"/lab2-1.0-SNAPSHOT\">Form</a></td>");
            out.println("</tr>\n" +
                    "<tr>");
            out.println("<th colspan=\"2\">Table</th>");
            out.println("</tr>");
            out.println("<tr><th colspan=\"2\">Table</th></tr>");
            out.println("<tr class=\"inputRow\">");
            out.println("<td colspan=\"2\">");
            out.println("<table>");
            out.println("<tr>");
            out.println("<th>X</th>");
            out.println("<th>Y</th>");
            out.println("<th>R</th>");
            out.println("<th>Hit</th>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td>" + params.get("x")[0] + "</td>");
            out.println("<td>" + params.get("y")[0] + "</td>");
            out.println("<td>" + params.get("r")[0] + "</td>");
            out.println("<td>" + hit + "</td>");
            out.println("</tr>");
            out.println("</table>");
            out.println("</td></tr></table>");
            out.println("</body></html>");
        }
        else response.sendRedirect("/lab2-1.0-SNAPSHOT/");
    }

    protected boolean validateX(String param) {
        try {
            x=Float.parseFloat(param);
            if (x>=-5 & x<=3) {
                return true;
            }
            return false;
        }catch (NumberFormatException e) {
            return false;
        }
    }

    protected boolean validateY(String param) {
        try {
            y=Float.parseFloat(param);
            if (y>-3 & y<3) {
                return true;
            }
            return false;
        }catch (NumberFormatException e) {
            return false;
        }
    }

    protected boolean validateR(String param) {
        try {
            r=Float.parseFloat(param);
            if (r>=1 & r<=3) {
                return true;
            }
            return false;
        }catch (NumberFormatException e) {
            return false;
        }
    }

    protected boolean firstQaurter() {
        if (x>=0 & y>=0 & y<=(-x)/2+(r/2)) {
            return true;
        }
        return false;
    }

    protected boolean thirdQaurter() {
        if (y<=0 & x<=0 & x*x+y*y<=r*r) return true;
        return false;
    }

    protected boolean forthQuarter() {
        if (y<=0 & x>=0 & x<=r & y<=r) return true;
        return false;
    }
}
