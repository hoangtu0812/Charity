package controller.admin;

import dao.AccountDAO;
import model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

@Controller
public class AccountUpdateController {
    @Autowired
    AccountDAO accountDAO;

    @RequestMapping(value = "/dashboard/account-update", method = RequestMethod.GET)
    public String accountUpdateForm(HttpServletRequest request, Model model) {
        String email = request.getParameter("email");
        if (email == null) {
            return "redirect:/dashboard/account-list";
        }
        try {
            Account account = accountDAO.getAccount(email);
            model.addAttribute("account", account);
            return "admin/account-update";
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/dashboard/account-list";
        }
    }

    @RequestMapping(value = "/dashboard/account-update", method = RequestMethod.POST)
    public String processRequest(HttpServletRequest request, HttpServletResponse response, Model model) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        try {
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            String name = request.getParameter("name");
            String roleRequest = request.getParameter("role");
            String address = request.getParameter("address");
            String phone = request.getParameter("phone");
            if (email.trim().equals("") || password.trim().equals("") || name.trim().equals("") || address.trim().equals("") || phone.trim().equals("")) {
                model.addAttribute("error", "Please fill this form!");

                return "redirect:/dashboard/account-update?email=" + email;
            }

            try {
                int role = Integer.parseInt(roleRequest);
                int currRole = accountDAO.role(email);
                if(currRole == 1) {
                    if (role == 0) {
                        model.addAttribute("account", accountDAO.getAccount(email));
                        model.addAttribute("message", "Can't change role of Admin!");
                        return "admin/account-update";
                    } else {
                        accountDAO.update(email, name, role, address, phone);
                        return "redirect:/dashboard/account-list";
                    }
                }
                accountDAO.update(email, name, role, address, phone);
                return "redirect:/dashboard/account-list";
            } catch (Exception e) {
                e.printStackTrace();
                model.addAttribute("account", accountDAO.getAccount(email));
                return "admin/account-update";
            }

        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/dashboard/account-list";
        }
    }
}
