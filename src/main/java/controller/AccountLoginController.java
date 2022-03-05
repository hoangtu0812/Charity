package controller;

import dao.AccountDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;

@Controller
public class AccountLoginController {
    @Autowired
    AccountDAO accountDAO;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginForm(HttpServletRequest request,HttpServletResponse response, Model model) {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession(true);
        if(session.getAttribute("email") != null) {
            return "index";
        }
        Cookie[] cookies = request.getCookies();
        String email = "";
        String password = "";
        int co = 0;
        if(cookies != null) {
            while (co < cookies.length) {
                if(cookies[co].getName().equals("email")) {
                    email = cookies[co].getValue();
                }
                if (cookies[co].getName().equals("password")) {
                    password = cookies[co].getValue();
                }
                co++;
            }
            model.addAttribute("cookieEmail", email);
            model.addAttribute("cookiePassword", password);
        }
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String processRequest(HttpServletRequest request, HttpServletResponse response, Model model) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        try{
            request.getSession(true).invalidate();
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            HttpSession session = request.getSession(true);

            if(!accountDAO.validate(email, password)) {
                return "login";
            }
            if(accountDAO.login(email,password)) {
                session.setAttribute("email",email);
                session.setAttribute("role", accountDAO.role(email));
                Cookie emailCookie = new Cookie("email", email);
                Cookie passCookie = new Cookie("password", password);
                if(request.getParameter("checkRemember") != null){
                    emailCookie.setMaxAge(60 * 60 * 24);
                    passCookie.setMaxAge(60 * 60 * 24);
                } else {
                    emailCookie.setMaxAge(0);
                    passCookie.setMaxAge(0);
                }
                response.addCookie(emailCookie);
                response.addCookie(passCookie);
                if (accountDAO.role(email) == 1) {
                    return "redirect:/dashboard";
                } else {
                    return "redirect:/home";
                }
            } else {
                model.addAttribute("error", accountDAO.getMessage());
                return "login";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "login";
        }
    }
}
