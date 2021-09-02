package myapp.web;

import myapp.entity.Person;
import myapp.entity.Position;
import myapp.entity.Profile;
import myapp.services.CustomService;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

@Controller
@RequestMapping ("/team")
public class TeamFormController {


    CustomService customService;
   
    @Autowired
    public void setCustomService (CustomService customService) {
        this.customService = customService;
    }


    @InitBinder
    public void initBinder(WebDataBinder binder) {
        StringTrimmerEditor stringtrim = new StringTrimmerEditor(true);
        binder.registerCustomEditor(String.class, stringtrim);
    }


    @RequestMapping("/list")
    public String getTeam(Model model) {
        model.addAttribute("listOfPersons", customService.getListOfPersons());
        model.addAttribute("listOfPositions", customService.getListOfPositions());
        return "team-list";
    }

    @RequestMapping("/team-management")
    public String manageTeam(Model model) {
        List<Position> listOfPositions = customService.getListOfPositions();
        model.addAttribute("person", new Person());
        model.addAttribute("positions", listOfPositions);
        return "team-management";
    }

    @RequestMapping("/teamManagementProcess")
    public String teamManagementProcess(@Valid @ModelAttribute("person") Person person, BindingResult result, Model model) {
        Position position = customService.getPosition(Integer.parseInt(person.getTempPosition()));
        person.setPosition(position);
        if (result.hasErrors()) {
            System.err.println("Error adding person! " + person);
            List<Position> listOfPositions = customService.getListOfPositions();
            model.addAttribute("positions", listOfPositions);
            return "team-management";
        } else {
            customService.addPerson(person);
            System.out.println("Adding...:" + person);
            return "redirect:/";
        }
    }


    @RequestMapping("/team-profiles-management")
    public String manageProfiles(Model model) {
        List<Person> listOfPersons = customService.getListOfPersons();
        model.addAttribute("profile", new Profile());
        model.addAttribute("persons", listOfPersons);
        return "team-profiles-management";
    }

    @RequestMapping("/profileManagementProcess")
    public String profileManageProfiles(@Valid @ModelAttribute("profile") Profile profile,
                                        BindingResult result, Model model) {
        Person person = customService.getPerson(Integer.parseInt(profile.getTempPerson()));
        if (result.hasErrors()) {
//            System.err.println("Error adding profile! " + person + profile);
            List<Person> listOfPersons = customService.getListOfPersons();
            model.addAttribute("persons", listOfPersons);
            return "team-profiles-management";
        } else {
//            System.out.println("Adding...:" + person + profile);
            customService.addProfile(person,profile);
            return "redirect:/";
        }
    }

    @RequestMapping("/deleteProcessForm")
    public String deleteProcessForm (@RequestParam ("personId") int personId, Model model) {
        customService.deletePerson(personId);
        return "redirect:/";
    }
}