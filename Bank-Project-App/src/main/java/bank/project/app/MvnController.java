package bank.project.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/web")
public class MvnController {

    //login page controller
    @GetMapping("/login")
    public String authenticate()
    {
        return "login";
    }

    @GetMapping("/dashboard")
    public String dash(){
        return "dashboard";
    }

    //Profile page with controller

    @GetMapping("/profile")
         public String profile(){
        return "profile";
    }

    @GetMapping("/accountdash")
      public String accounts(){
        return "accountdash";
    }

    @GetMapping("/amountsearch")
    public String amountRange(){
        return "amountRange";
    }

}

