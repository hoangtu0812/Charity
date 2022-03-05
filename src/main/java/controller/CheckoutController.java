package controller;


import dao.AccountDAO;
import dao.ProgramDAO;
import model.Account;
import model.Program;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class CheckoutController {
    @Autowired
    AccountDAO accountDAO;

    @Autowired
    ProgramDAO programDAO;

    @RequestMapping(value = "/checkout")
    public String processRequest(HttpServletRequest request, HttpServletResponse response, Model model) {
        HttpSession session = request.getSession();
        String email = (String) session.getAttribute("email");
        String requestID = request.getParameter("id");
        if(requestID.trim() == "" || requestID == null) {
            return "redirect:/home";
        }
        try {
            int id = Integer.parseInt(requestID);
            Program program = programDAO.getProgram(id);
            Account account = accountDAO.getAccount(email);
            model.addAttribute("program", program);
            model.addAttribute("account", account);
            return "checkout";

        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/home";
        }

    }
}
