package controller;

import dao.AccountDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class ChangePasswordController {
    @Autowired
    AccountDAO accountDAO;
    @RequestMapping(value = "/change-password", method = RequestMethod.GET)
    public String changePassword(HttpServletRequest request) {
        HttpSession session = request.getSession();
        if(session.getAttribute("email") == null) {
            return "login";
        } else {
            return "change-password";
        }
    }

    @RequestMapping(value = "/change-password", method = RequestMethod.POST)
    public String processRequest(HttpServletRequest request, HttpServletResponse response, Model model) {
        String email = request.getParameter("email");
        System.out.println(email);
        String password = request.getParameter("password");
        String newPassword = request.getParameter("newPassword");
        String confirmPassword = request.getParameter("confirmPassword");
        try {
            if(accountDAO.exist(email)) {
                if(accountDAO.login(email,password)) {
                    if(newPassword.equals(confirmPassword)) {
                        accountDAO.changePassword(email, newPassword);
                        model.addAttribute("message", "<p style='color:green;'>Đổi mật khẩu thành công !</p>");
                        return "change-password";
                    }else {
                        model.addAttribute("message", "<p style='color:red;'>Mật khẩu không trùng khớp!</p>");
                        return "change-password";

                    }
                } else {
                    model.addAttribute("message","<p style='color:red;'>Mật khẩu hiện tại không chính xác!</p>");
                    return "change-password";
                }
            }else {
                model.addAttribute("message", "<p style='color:red;'>Email không tồn tại!</p>");
                return "change-password";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "change-password";
        }
    }
}
