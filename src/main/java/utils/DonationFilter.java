package utils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;

public class DonationFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
        System.out.println("Donation filter init!");
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        try {
            String servletPath = req.getServletPath();
            System.out.println("#INFO" + new Date() + " -ServletPath: " + servletPath + ", URL= " + req.getRequestURL());
            HttpSession session = req.getSession();
            String email = (String) session.getAttribute("email");

            System.out.println(email);
            //System.out.println(role);
            if (email != null) {
                chain.doFilter(request, response);
            } else {
                resp.sendRedirect(req.getContextPath() + "/login");
            }
        } catch (Exception e) {
            e.printStackTrace();
            resp.sendRedirect(req.getContextPath());
        }
    }
}
