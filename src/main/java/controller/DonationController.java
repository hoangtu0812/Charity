package controller;


import dao.DonationDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class DonationController {
    @Autowired
    DonationDAO donationDAO;

    @RequestMapping(value = "/donation")
    public String processRequest(HttpServletRequest request, HttpServletResponse response, Model model) {
        String userMail = request.getParameter("userMail");
        String userName = request.getParameter("userName");
        String userPhone = request.getParameter("userPhone");
        String idRequest = request.getParameter("programID");
        String amountRequest = request.getParameter("amount");
        try {
            int id = Integer.parseInt(idRequest);
            int amount  = Integer.parseInt(amountRequest);
            donationDAO.update(userMail, userName, userPhone, id, amount);
            System.out.println("Success!");
            return "redirect:/home";
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/home";
        }

    }
}
