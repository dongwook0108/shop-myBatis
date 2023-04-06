package dongwook.shoppingprcatice.logout;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Logout {


    @GetMapping("")
    public String logout() {

        return "redirect:/";
    }
}
