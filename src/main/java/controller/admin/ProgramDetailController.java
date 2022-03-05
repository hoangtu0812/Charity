package controller.admin;

import dao.ProgramDAO;
import model.Program;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class ProgramDetailController {
    @Autowired
    private ProgramDAO programDAO;

    @RequestMapping(value = "/dashboard/program-detail")
    public String processRequest(HttpServletRequest request, HttpServletResponse response, Model model) {
        String requestID = request.getParameter("id");
        if (requestID == null) {
            return "redirect:/dashboard/program-list";
        }
        try {
            int id = Integer.parseInt(requestID);
            Program program = programDAO.getProgram(id);
            model.addAttribute("program", program);
            return "admin/program-detail";
        } catch (NumberFormatException e) {
            return "redirect:/dashboard/program-list";
        }
    }
}
