package controller.admin;

import dao.ProgramDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class ProgramDeleteMultiController {
    @Autowired
    private ProgramDAO programDAO;
    @RequestMapping(value = "/dashboard/delete-multiple-program")
    public String processRequest(HttpServletRequest request, HttpServletResponse response, Model model, RedirectAttributes redirectAttributes) {
        if(request.getParameterValues("chk") == null) {
            redirectAttributes.addFlashAttribute("error", "Please select rows!");
            return "redirect:/dashboard/program-list";
        }
        String[] chk = request.getParameterValues("chk");
        if (chk.length == 0) {
           redirectAttributes.addFlashAttribute("error", "Delete error! Please select rows!");
           return "redirect:/dashboard/program-list";
        }
        try {
            for (int i = 0; i < chk.length; i++) {
                int id = Integer.parseInt(chk[i]);
                programDAO.delete(id);
            }
            return "redirect:/dashboard/program-list";
        } catch (Exception e) {
            e.printStackTrace();
            redirectAttributes.addAttribute("error","Delete error!");
            return "redirect:/dashboard/program-list";
        }
    }
}
