package servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class AuthorizationFilter implements Filter {
    private final String word = "artem";

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String auth = ((HttpServletRequest) servletRequest).getHeader("Authorization");
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        if (auth!=null) {
            if (auth.equals("Bearer "+word)) {
                filterChain.doFilter(servletRequest,servletResponse);
            }
            else {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
            }
        }
        else {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
        }
    }
}
