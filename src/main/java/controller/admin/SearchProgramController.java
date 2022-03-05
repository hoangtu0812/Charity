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
public class SearchProgramController {
    @Autowired
    private ProgramDAO programDAO;

    @RequestMapping(value = "/dashboard/search-program")
    public String processRequest(HttpServletRequest request, HttpServletResponse response, Model model) {
        String key = request.getParameter("search");
        if(key == null) {
            return "redirect:/dashboard/program-list";
        }
        List<Program> programList = programDAO.search(key);
        model.addAttribute("key", key);
        if(programList.size() == 0) {
            model.addAttribute("searchMessage", "No program found");
        }
        model.addAttribute("programList", programList);
        return "admin/program-list";
    }
}
