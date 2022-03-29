package controller.admin;

import dao.DonationDAO;
import model.DonationCOM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
/**
* Controller for search a donation session by transaction code
* */
@Controller
public class DonationSearchController {
    @Autowired
    private DonationDAO donationDAO;
    @RequestMapping(value = "/dashboard/search-donation")
    public String processRequest(HttpServletRequest request, RedirectAttributes redirectAttributes, Model model) {
        if(request.getParameter("search") == null) {
            redirectAttributes.addFlashAttribute("error", "No donation found!");
            return "redirect:/dashboard/donation-list";
        }
        String key = request.getParameter("search");
        key = key.trim();
        try {
            List<DonationCOM> donationCOMS =donationDAO.getDonationByTCode(key);
            for(int i = 0 ; i < donationCOMS.size();i++) {
                System.out.println(donationCOMS.get(i).getUserMail());
            }
            model.addAttribute("donationCOMS", donationCOMS);
            System.out.println("test here");
            return "admin/donation-list";
        } catch (Exception e) {
            e.printStackTrace();
            redirectAttributes.addFlashAttribute("error", "Search error!");
            return "redirect:/dashboard/donation-list";
        }
    }
}
