package myapp.deprecated;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Controller
@RequestMapping ("/form")
public class DataFormController {

    @InitBinder
    public void initBinder ( WebDataBinder binder )
    {
        StringTrimmerEditor stringtrim = new StringTrimmerEditor(true);
        binder.registerCustomEditor(String.class, stringtrim);
    }
    public class PersonalDataForm {


        @NotNull (message="is require")
        @Size (min = 1,max=25,message="incorrect size")
        @Pattern(regexp = "[a-zA-Z]+",message="incorrect input")
        private String firstName;

        @NotNull (message="is require")
        @Pattern(regexp = "[a-zA-Z]+",message="incorrect input")
        @Size (min = 1,max=25,message="incorrect size")
        private String lastName;

        private String sex;
        private String country;

        private String [] education ;

        public String[] getEducation() {
            return education;
        }

        public void setEducation(String[] education) {
            this.education = education;
        }



        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }



        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }




        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }
    }

    @RequestMapping
    public String showEmptyPage ()
    {
        return "index";
    }

    @RequestMapping("/requestFormPage")
    public String showRequestForm(Model model) {
//        PersonalDataForm personalDataForm = new PersonalDataForm();
        model.addAttribute("personalDataForm", new PersonalDataForm());
            return "view/request_form_page";
    }

    @RequestMapping("/processFormPage")
    public String processForm( @Valid @ModelAttribute ("personalDataForm") PersonalDataForm personalDataForm,
    BindingResult result) {
            if (result.hasErrors()) return "view/request_form_page";
            else return "view/confirmation_form_page";
    }
}


