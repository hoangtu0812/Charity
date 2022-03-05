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
public class AccountListController {
    @Autowired
    AccountDAO accountDAO;

    @RequestMapping(value = "/dashboard/account-list")
    public String processRequest(HttpServletRequest request, HttpServletResponse response, Model model) {
        String requestID = request.getParameter("page");
        int pageModel = accountDAO.getPage();
        model.addAttribute("pageModel", pageModel);
        if(requestID == null) {
            int count = accountDAO.count();
            int last;
            if(count >= 10) {
                last = 9;
            } else {
                last = count - 1;
            }
            List<Account> accountList = accountDAO.getAccountList(0, last);
            model.addAttribute("accountList", accountList);
            return "admin/account-list";
        } else {
            try {
                int page = Integer.parseInt(requestID);
                if (page > pageModel) {
                    page = pageModel;
                }
                if (page < 1) {
                    page = 1;
                }
                int count = accountDAO.count();
                int first = page * 10 - 10;
                int last = page * 10 - 1;
                if(count < last) {
                    last = count - 1;
                }
                List<Account> accountList = accountDAO.getAccountList(first, last);
                model.addAttribute("accountList", accountList);
                return "admin/account-list";
            } catch (NumberFormatException e) {
                e.printStackTrace();
                return "admin/dashboard";
            }
        }
    }
}
