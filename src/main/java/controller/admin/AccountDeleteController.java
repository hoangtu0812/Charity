package controller.admin;

import dao.AccountDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class AccountDeleteController {
    @Autowired
    AccountDAO accountDAO;

    @RequestMapping(value = "/dashboard/account-delete")
    public String processRequest(HttpServletRequest request, HttpServletResponse response, Model model) {
        String email = request.getParameter("email");
        if (email == null) {
            return "redirect:/dashboard/account-list";
        }
        try {
            if(accountDAO.countEmail(email) != 0) {
                if(accountDAO.role(email) == 0) {
                    accountDAO.delete(email);
                    System.out.println("Delete successful");
                    model.addAttribute("message", "Delete successful!");
                    return "admin/delete-success";
                } else {
                    System.out.println("Can delete admin account!");
                    model.addAttribute("message", "Can delete admin account!");
                    return "admin/delete-fail";
                }
            } else {
                System.out.println("This account does not exist");
                model.addAttribute("message", "This account does not exist!");
                return "admin/delete-fail";
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Delete fail!");
            model.addAttribute("message", "Delete fail!");
            return "admin/delete-fail";
        }
    }
}
