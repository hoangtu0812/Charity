package controller;

import dao.AccountDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

@Controller
public class AccountRegisterController {
    @Autowired
    AccountDAO accountDAO;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String processRequest(HttpServletRequest request, HttpServletResponse response, Model model) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        if(email == null || password == null || name == null || address == null || phone == null) {
            return "register";
        }
        try {
            if(email.trim().equals("") || password.trim().equals("")|| name.trim().equals("")||address.trim().equals("")||phone.trim().equals("")){
                model.addAttribute("email", email);
                model.addAttribute("password",password);
                model.addAttribute("name",name);
                model.addAttribute("address",address);
                model.addAttribute("phone",phone);
                model.addAttribute("error","Vui lòng điền đầy đủ thông tin!");
                return "register";
            }
            if(!accountDAO.exist(email)) {
                if(accountDAO.validate(email,password)) {
                    accountDAO.create(email,password,name,0,address,phone);
                    return "register-successfull";
                } else {
                    model.addAttribute("email", email);
                    model.addAttribute("password",password);
                    model.addAttribute("name",name);
                    model.addAttribute("address",address);
                    model.addAttribute("phone",phone);
                    model.addAttribute("error",accountDAO.getMessage());
                    return "register";
                }
            } else {
                model.addAttribute("email", email);
                model.addAttribute("password",password);
                model.addAttribute("name",name);
                model.addAttribute("address",address);
                model.addAttribute("phone",phone);
                model.addAttribute("error","Email đã tồn tại!");
                return "register";
            }


        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", "Đăng ký thất bại!");
            return "register";
        }
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String registerForm(Model model) {
        model.addAttribute("email", "");
        model.addAttribute("password","");
        model.addAttribute("name","");
        model.addAttribute("address","");
        model.addAttribute("phone","");
        model.addAttribute("error","");
        return "register";
    }
}
