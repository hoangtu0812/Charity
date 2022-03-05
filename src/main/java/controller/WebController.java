package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {
    @RequestMapping(value = "/success")
    public String success() {
        return "admin/success";
    }

    @RequestMapping(value = "/dashboard")
    public String dashboard() {
        return "admin/dashboard";
    }


}
