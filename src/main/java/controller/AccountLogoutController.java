package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class AccountLogoutController {
    @RequestMapping (value = "/logout")
    public String processRequest(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        session.invalidate();
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
}
