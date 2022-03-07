package controller.admin;

import dao.AccountDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

@Controller
public class AccountCreateController {
    @Autowired
    AccountDAO accountDAO;

    @RequestMapping(value = "/dashboard/account-create", method = RequestMethod.POST)
    public String processRequest(HttpServletRequest request, HttpServletResponse response, Model model) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");
        String name = request.getParameter("name");
        String role = request.getParameter("role");

        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        model.addAttribute("resEmail", email);
        model.addAttribute("password", password);
        model.addAttribute("confirmPassword", confirmPassword);
        model.addAttribute("name", name);
        model.addAttribute("role", role);
        model.addAttribute("address", address);
        model.addAttribute("phone", phone);
        if (email == null || password == null || name == null || role == null || address == null || phone == null) {
            return "admin/account-create";
        }
        if (email.trim().equals("") || password.trim().equals("") || name.trim().equals("") || address.trim().equals("") || phone.trim().equals("")) {
            return "admin/account-create";
        }
        if (!accountDAO.exist(email)) {
            if (password.equals(confirmPassword)) {
                if (accountDAO.validate(email, password)) {
                    try {
                        int roleP = Integer.parseInt(role);
                        accountDAO.create(email, password, name, roleP, address, phone);
                        System.out.println("Success!");
                        return "redirect:/dashboard/account-list";
                    } catch (Exception e) {
                        e.printStackTrace();
                        return "admin/account-create";
                    }
                } else {
                    model.addAttribute("error", "Username is already exist!");
                    return "admin/account-create";
                }
            } else {
                model.addAttribute("error", "Please re-enter your password!");
                return "admin/account-create";
            }
        } else {
            model.addAttribute("error", accountDAO.getMessage());
            return "admin/account-create";
        }
    }

    @RequestMapping(value = "/dashboard/account-create", method = RequestMethod.GET)
    public String createAccount() {
        return "admin/account-create";
    }
}
