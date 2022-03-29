package controller.admin;

import dao.AccountDAO;
import model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class AccountSearchController {
    @Autowired
    private AccountDAO accountDAO;

    @RequestMapping(value = "/dashboard/search-account")
    public String processRequest(HttpServletRequest request, HttpServletResponse response, Model model) {
        String key = request.getParameter("search");
        String by = request.getParameter("by");
        if (key == null || by == null || key.trim().equals("")) {
            return "redirect:/dashboard/account-list";
        }
        try {
            if (by.equals("phone")) {
                List<Account> accountList = accountDAO.searchByPhone(key);
                model.addAttribute("accountList", accountList);
                return "admin/account-list";
            } else if(by.equals("email")) {
                List<Account> accountList = accountDAO.searchByEmail(key);
                model.addAttribute("accountList", accountList);
                return "admin/account-list";
            } else {
                model.addAttribute("searchMessage", "No account found!");
                return "admin/account-list";
            }
        } catch (Exception e) {
            return "redirect:/dashboard/account-list";
        }
    }
    public int getPage(List<Account> accountList) {
        int allAccount = accountList.size();
        int n = allAccount/10;
        int r = allAccount%10;
        if(r == 0) {
            return n;
        } else {
            return n+1;
        }
    }
}
