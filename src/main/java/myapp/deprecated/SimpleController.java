package myapp.deprecated;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class SimpleController {
    @RequestMapping()
    public String emptyPage() {
        return "index";
    }

    @RequestMapping("/requestPage")
    public String showRequestForm() {
        return "view/request_page";
    }

    @RequestMapping("/processPage")
    public String processForm(@RequestParam("firstName") String firstName,
                              @RequestParam("lastName") String lastName, Model model) {
        model.addAttribute("firstName", firstName);
        model.addAttribute("lastName", lastName);
        return "view/confirmation_page";
    }
}