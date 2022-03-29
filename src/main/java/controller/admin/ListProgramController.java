package controller.admin;

import dao.ProgramDAO;
import model.Program;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class ListProgramController {
    @Autowired
    private ProgramDAO programDAO;

    @RequestMapping(value = "/dashboard/program-list")
    public String processRequest(HttpServletRequest request, HttpServletResponse response, Model model) {
        String requestID = request.getParameter("page");
        int pageModel = programDAO.getPage();
        model.addAttribute("pageModel", pageModel);
        if(requestID == null) {
            int count = programDAO.count();
            int last;
            if(count >= 10) {
                last = 9;
            } else {
                last = count - 1;
            }
            List<Program> programList = programDAO.getProgramList(0,last);
            model.addAttribute("programList", programList);
            return "admin/program-list";
        } else {
            int page = Integer.parseInt(requestID);
            if(page > pageModel) {
                page = pageModel;
            }
            if(page < 1) {
                page = 1;
            }
            int count = programDAO.count();
            int first = page * 10 - 10;
            int last = page * 10 - 1;
            if(count < last) {
                last = count-1;
            }
            List<Program> programList = programDAO.getProgramList(first,last);
            model.addAttribute("programList", programList);
            return "admin/program-list";
        }
    }
}
