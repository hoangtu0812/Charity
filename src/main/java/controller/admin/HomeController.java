package controller.admin;


import dao.ProgramDAO;
import model.Program;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class HomeController {
    @Autowired
    ProgramDAO programDAO;

    @RequestMapping(value = "/home")
    public String processRequest(HttpServletRequest request, HttpServletResponse response, Model model) {
        List<Program> programList = programDAO.getSortedProgramList(0,5);
        model.addAttribute("programList", programList);
        return "index";
    }
}
