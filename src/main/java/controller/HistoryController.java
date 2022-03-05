package controller;


import dao.DonationDAO;
import model.DonationCOM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class HistoryController {
    @Autowired
    DonationDAO donationDAO;

    @RequestMapping(value = "/history")
    public String processRequest(HttpServletRequest request, HttpServletResponse response, Model model) {
        HttpSession session = request.getSession();
        String email = (String) session.getAttribute("email");
        if (email.trim().equals("")) {
            return "redirect:/login";
        }
        try {
            List<DonationCOM> donationCOMS = donationDAO.getDonationByEmail(email);
            model.addAttribute("donationCOMS", donationCOMS);
            return "history";
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/home";
        }

    }
}
