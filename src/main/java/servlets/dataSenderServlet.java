package servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import data.DataConteiner;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "data")
public class dataSenderServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out =  resp.getWriter();
        if (getServletContext().getAttribute("table")!=null) {
            DataConteiner dataConteiner = (DataConteiner) getServletContext().getAttribute("table");
            ObjectMapper objectMapper = new ObjectMapper();
            for (int i = 0; i < dataConteiner.getSize(); i++) {
                out.println(objectMapper.writeValueAsString(dataConteiner.getData(i)));
            }
        }else {
            out.println("empty");
        }
    }
}
