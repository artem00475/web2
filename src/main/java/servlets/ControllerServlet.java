package servlets;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Map;

@WebServlet(name = "controllerServlet")
public class ControllerServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        Map<String, String[]> params = request.getParameterMap();
        if (params.size()==3 & params.containsKey("x") & params.containsKey("y") & params.containsKey("r")) {
            ServletContext servletContext = getServletContext();
            RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/areaChecker");
            requestDispatcher.forward(request,response);
        }
        else {

            ServletContext servletContext = getServletContext();
            RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/form.jsp");
            requestDispatcher.forward(request,response);
        }
    }

    public void destroy() {
    }



}
