package controller.admin;

import dao.ProgramDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class DeleteProgramController {
    @Autowired
    private ProgramDAO programDAO;

    @RequestMapping(value = "/dashboard/delete-program")
    protected String processRequest(HttpServletRequest request, HttpServletResponse response, Model model) {
        String requestID = request.getParameter("id");
        if (requestID == null) {
            return "redirect:/dashboard/program-list";
        }
        try {
            int id = Integer.parseInt(requestID);
            programDAO.delete(id);
            return "redirect:/dashboard/program-list";
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return "redirect:/dashboard/program-list";
        }
    }
}
