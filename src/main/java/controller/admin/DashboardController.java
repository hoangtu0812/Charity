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
public class DashboardController {
    @RequestMapping(value = "/dashboard/create-program-form")
    public String createProgramForm() {
        return "admin/create-program";
    }

//    @RequestMapping(value = "/dashboard/account-create-form")
//    public String createAccountForm() {
//        return "admin/account-create";
//    }

    @Autowired
    private ProgramDAO programDAO;

    @RequestMapping(value = "/dashboard/update-program-form")
    public String updateProgramForm(HttpServletRequest request, HttpServletResponse response, Model model) {
        String requestID = request.getParameter("id");
        if (requestID == null) {
            return "redirect:/dashboard/program-list";
        }
        try {
            int id = Integer.parseInt(requestID);
            Program program = programDAO.getProgram(id);
            model.addAttribute("program", program);
            return "admin/update-program";
        } catch (NumberFormatException e) {
            return "redirect:/dashboard/program-list";
        }
    }
}
