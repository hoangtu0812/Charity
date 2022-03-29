package controller;


import dao.AccountDAO;
import dao.DonationDAO;
import dao.ProgramDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.text.NumberFormat;
import java.util.Locale;

@Controller
public class DonationController {
    @Autowired
    private DonationDAO donationDAO;
    @Autowired
    private ProgramDAO programDAO;
    @Autowired
    private AccountDAO accountDAO;

    @RequestMapping(value = "/donation")
    public String processRequest(HttpServletRequest request, HttpServletResponse response, Model model) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String userMail = request.getParameter("userMail");
        String userName = request.getParameter("userName");
        String userPhone = request.getParameter("userPhone");
        String idRequest = request.getParameter("programID");
        String amountRequest = request.getParameter("amount");
        String tcode = request.getParameter("tcode");
        model.addAttribute("amount", amountRequest);
        model.addAttribute("tcode", tcode);

        try {
            int id = Integer.parseInt(idRequest);
            float amount  = Float.parseFloat(amountRequest);
            amount = amount * 22840;
            donationDAO.update(userMail, userName, userPhone, id, amount, tcode);
            Locale vn = new Locale("vi", "VN");
            NumberFormat numberFormat = NumberFormat.getCurrencyInstance(vn);
            String resAmount = numberFormat.format(amount);
            model.addAttribute("resAmount", resAmount);
            System.out.println("Success!");
            model.addAttribute("account", accountDAO.getAccount(userMail));
            model.addAttribute("program" , programDAO.getProgram(id));
//            model.addAttribute("donationCOMS", donationDAO.getDonationByEmail(userMail));
            return "receipt";
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/home";
        }

    }
}
