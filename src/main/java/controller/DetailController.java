package controller;


import dao.DonationDAO;
import dao.ProgramDAO;
import model.DonationCOM;
import model.Program;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class DetailController {
    @Autowired
    ProgramDAO programDAO;

    @Autowired
    DonationDAO donationDAO;

    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    public String processRequest(HttpServletRequest request, Model model) {
        String requestID = request.getParameter("id");
        try {
            if(requestID.trim().equals("")) {
                return "redirect:/home";
            }
            int id = Integer.parseInt(requestID);
            Program program = programDAO.getProgram(id);
            //DonationCOM donationCOM = donationDAO.getDonationByEmail(id);
            List<DonationCOM> donationCOMS = donationDAO.getDonationByProgramID(id);
            model.addAttribute("donationCOMS", donationCOMS);
            model.addAttribute("program", program);
            return "detail";
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/home";
        }
    }
}