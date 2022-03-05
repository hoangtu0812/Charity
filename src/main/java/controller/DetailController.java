package controller;


import dao.ProgramDAO;
import model.Program;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class DetailController {
    @Autowired
    ProgramDAO programDAO;

    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    public String processRequest(HttpServletRequest request, Model model) {
        String requestID = request.getParameter("id");
        try {
            if(requestID.trim() == "" || requestID == null) {
                return "redirect:/home";
            }
            int id = Integer.parseInt(requestID);
            Program program = programDAO.getProgram(id);
            model.addAttribute("program", program);
            return "detail";
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/home";
        }
    }
}