package controller;

import dao.AccountDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import utils.EmailUtility;

import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class ResetPasswordController {
    private String host;
    private String port;
    private String email;
    private String name;
    private String pass;
    @Autowired
    AccountDAO accountDAO;

    @RequestMapping(value = "/reset", method = RequestMethod.GET)
    public String resetPassword() {
        return "reset-password";
    }

    @RequestMapping(value = "/reset", method = RequestMethod.POST)
    public String processRequest(HttpServletRequest request, HttpServletResponse response, Model model) {
        ServletContext context = request.getServletContext();
        host = context.getInitParameter("host");
        port = context.getInitParameter("port");
        email = context.getInitParameter("email");
        name = context.getInitParameter("name");
        pass = context.getInitParameter("pass");
        System.out.println(host);
        String recipient = request.getParameter("email");
        String subject = "Your Password has been reset";
        if(accountDAO.exist(recipient)) {
            String newPass = accountDAO.newPassword(recipient);
            String content = "This is your new password: " + newPass;
            String message = "";
            try {
                EmailUtility.sendEmail(host,port,email,name,pass,recipient,subject,content);
                message = "<p style='color: green;'>Mật khẩu của bạn đã được reset. Vui lòng kiểm tra email!</p>";
                model.addAttribute("message", message);
                return "reset-password";
            } catch (Exception e) {
                e.printStackTrace();
                message = "<p style='color:red;'>Có lỗi xãy ra! Vui lòng đặt lại mật khẩu!</p>";
            } finally {
                model.addAttribute("message", message);
                return "reset-password";
            }
        } else {
            model.addAttribute("message", "<p style='color:red;'>Email chưa được đăng ký!</p>");
            return "reset-password";
        }

    }

}
