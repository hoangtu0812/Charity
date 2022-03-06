package controller.admin;


import dao.ProgramDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ProgramEnableController {
    @Autowired
    ProgramDAO programDAO;

    @RequestMapping(value = "/dashboard/enable")
    public String processRequest(HttpServletRequest request) {
        String requestId = request.getParameter("id");
        if (requestId.trim().equals("")) {
            return "redirect:/dashboard/program-list";
        }
        try {
            int id = Integer.parseInt(requestId);
            programDAO.enable(id);
            return "redirect:/dashboard/program-list";
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/dashboard/program-list";
        }
//        return "redirect:/dashboard/program-list";
    }
}
