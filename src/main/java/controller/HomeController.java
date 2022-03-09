package controller;


import dao.DonationDAO;
import dao.ProgramDAO;
import model.DonationCOM;
import model.Program;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.List;

@Controller
public class HomeController {
    @Autowired
    ProgramDAO programDAO;

    @Autowired
    DonationDAO donationDAO;

    @RequestMapping(value = "/home")
    public String processRequest(HttpServletRequest request, HttpServletResponse response, Model model) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        List<Program> programList = programDAO.getActiveProgramList(0,5);
        model.addAttribute("programList", programList);
        List<DonationCOM> donationCOMS = donationDAO.getDonationList();
        model.addAttribute("donationCOMS", donationCOMS);
        return "index";
    }

}
