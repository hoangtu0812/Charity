package controller.admin;


import dao.ProgramDAO;
import model.Program;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.sql.Date;

@Controller
public class UpdateProgramController {
    @Autowired
    private ProgramDAO programDAO;

    @RequestMapping(value = "/dashboard/update-program")
    public String processRequest(HttpServletRequest request, HttpServletResponse response, Model model) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String requestID = request.getParameter("id");
        if (requestID == null) {
            return "redirect:/dashboard/program-list";
        }
        String name = request.getParameter("name");
        String des = request.getParameter("des");
        String detail = request.getParameter("detail");
        String foundation = request.getParameter("foundation");
        String src = request.getParameter("src");
        String targetRequest = request.getParameter("target");
        try {
            int id = Integer.parseInt(requestID);
            int target = Integer.parseInt(targetRequest);
            String dateRequest = request.getParameter("endtime");
            Date date = Date.valueOf(dateRequest);
            try {
                programDAO.update(id, name, des, detail, foundation, src, target, date);
                model.addAttribute("message", "Update successfully!");
                return "admin/success";
            } catch (Exception e) {
                Program program = new Program(id, name, des, detail, foundation, src, target , date);
                model.addAttribute("program", program);
                model.addAttribute("error", "Update failed!");
                return "admin/update-program";
            }
        } catch (NumberFormatException e) {
            return "redirect:/dashboard/update-program";
        }
    }
}
