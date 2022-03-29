package controller.admin;

import dao.AccountDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class AccountDeleteMultiController {
    @Autowired
    private AccountDAO accountDAO;

    @RequestMapping(value = "/dashboard/delete-multiple-account")
    public String processRequest(HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
        if (request.getParameterValues("chk") == null) {
            redirectAttributes.addFlashAttribute("error", "Please select rows!");
            return "redirect:/dashboard/account-list";
        }
        String[] chk = request.getParameterValues("chk");
        if (chk.length == 0) {
            redirectAttributes.addFlashAttribute("error", "Please select rows!");
            return "redirect:/dashboard/account-list";
        }
        try {
            for (int i = 0; i < chk.length; i++) {
                String userMail = chk[i];
                if (accountDAO.role(userMail) == 0) {
                    accountDAO.delete(userMail);
                } else {
                    redirectAttributes.addFlashAttribute("error", "Can not delete admin account!");
                }
            }
            redirectAttributes.addFlashAttribute("message", "Delete success!");
            return "redirect:/dashboard/account-list";
        } catch (Exception e) {
            e.printStackTrace();
            redirectAttributes.addFlashAttribute("error", "Delete error!");
            return "redirect:/dashboard/account-list";
        }
    }
}
