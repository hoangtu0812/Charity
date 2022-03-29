package controller.admin;

import dao.AccountDAO;
import model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class AccountStatusController {
    @Autowired
    private AccountDAO accountDAO;

    @RequestMapping(value = "/dashboard/ban", method = RequestMethod.GET)
    public String ban(HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
        String email = request.getParameter("email");
        if(email == null || email.trim().equals("")) {
            return "redirect:/dashboard/account-list";
        }
        try {
            Account account = accountDAO.getAccount(email);
            int role = account.getRole();
            if(role == 1) {
                redirectAttributes.addFlashAttribute("error", "Can not ban admin account");
                return "redirect:/dashboard/account-list";
            }
            accountDAO.ban(email);
            return "redirect:/dashboard/account-list";
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/dashboard/account-list";
        }
    }
    @RequestMapping(value = "/dashboard/unban", method = RequestMethod.GET)
    public String unBan(HttpServletRequest request, HttpServletResponse response) {
        String email = request.getParameter("email");
        if(email == null || email.trim().equals("")) {
            return "redirect:/dashboard/account-list";
        }
        try {
            accountDAO.unBan(email);
            return "redirect:/dashboard/account-list";
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/dashboard/account-list";
        }
    }

}
