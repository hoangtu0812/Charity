package controller.admin;

import dao.ProgramDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.sql.Date;

@Controller
public class CreateProgramController {
    @Autowired
    private ProgramDAO programDAO;

    @RequestMapping(value = "/dashboard/create-program")
    public String processRequest(HttpServletRequest request, HttpServletResponse response, Model model, @RequestParam("file")MultipartFile file) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        String name = request.getParameter("name");
        System.out.println(name);
        String des = request.getParameter("des");
        String detail = request.getParameter("detail");
        String foundation = request.getParameter("foundation");
//        String src = request.getParameter("src");
        String fileName = file.getOriginalFilename();
        String targetRequest = request.getParameter("target");
        if (name == null || des == null || detail == null || foundation == null || fileName == null || targetRequest == null) {
            return "admin/create-program";
        }
        try {
            int target = Integer.parseInt(targetRequest);
            try {
                String dateRequest = request.getParameter("endtime");
                Date date = Date.valueOf(dateRequest);
                String uploadPath = request.getServletContext().getRealPath("") +"upload/";
                File fileUpload = new File(uploadPath, fileName);
                file.transferTo(fileUpload);
                programDAO.create(name, des, detail, foundation, fileName, target, date);
                model.addAttribute("message", "Create a new Charity program successfully!");
                return "admin/success";
            } catch (Exception e) {
                e.printStackTrace();
                return "admin/create-program";
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return "admin/create-program";
        }

    }
}
