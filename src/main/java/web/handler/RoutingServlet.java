package web.handler;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;
import web.service.LoginService;
import web.service.MathQuestionService;
import web.service.DateUtilityService;
import web.service.ScienceService;

@Controller
@RequestMapping("/")
public class RoutingServlet {

    @GetMapping("/")
    public String welcome() {
        System.out.println("Welcome ...");
        return "view-welcome";
    }

    @GetMapping("/login")
    public String loginView() {
        System.out.println("login view...");
        return "view-login";
    }

    @PostMapping("/login")
    public RedirectView login(
            HttpServletRequest request, 
            RedirectAttributes redirectAttributes) {
        System.out.println("login form...");
        String username = request.getParameter("username");
        String password = request.getParameter("passwd");
        String dob = request.getParameter("dob");

        System.out.println("Username/password: " + username + ", " + password);

        RedirectView redirectView = null;
        if (LoginService.login(username, password, dob)) {
            redirectView = new RedirectView("/q1", true);
        } else {
            redirectView = new RedirectView("/login", true);
            redirectAttributes.addFlashAttribute("message", "Incorrect credentials.");
        }

        return redirectView;
    }

    @GetMapping("/q1")
    public String q1View() {        
        System.out.println("q1 view...");
        return "view-q1";
    }

    @PostMapping("/q1")
    public RedirectView q1(
            HttpServletRequest request, 
            RedirectAttributes redirectAttributes) {
        System.out.println("q1 form...");
        String number1 = request.getParameter("number1");
        String number2 = request.getParameter("number2");
        String resultUser = request.getParameter("result");

        double calculatedResult = MathQuestionService.q1Addition(number1, number2);
        System.out.println("User result: " + resultUser + ", answer: " + calculatedResult);

        RedirectView redirectView = null;
        if (calculatedResult == Double.valueOf(resultUser)) {
            redirectView = new RedirectView("/q2", true);
        } else {
            redirectView = new RedirectView("/q1", true);
            redirectAttributes.addFlashAttribute("message", "Wrong answer, try again.");
        }        
        return redirectView;
    }

    @GetMapping("/q2")
    public String q2View() {        
        System.out.println("q2 view...");
        return "view-q2";
    }    

    @PostMapping("/q2")
    public RedirectView q2(
            HttpServletRequest request, 
            RedirectAttributes redirectAttributes) {
        System.out.println("q2 form...");
        String number1 = request.getParameter("number1");
        String number2 = request.getParameter("number2");
        String resultUser = request.getParameter("result");

        double calculatedResult = MathQuestionService.q2Subtraction(number1, number2);
        System.out.println("User result: " + resultUser + ", answer: " + calculatedResult);

        RedirectView redirectView = null;
        if (calculatedResult == Double.valueOf(resultUser)) {
            redirectView = new RedirectView("/q3", true);
        } else {
            redirectView = new RedirectView("/q2", true);
            redirectAttributes.addFlashAttribute("message", "Wrong answer, try again.");
        }        
        return redirectView;
    }    

    @GetMapping("/q3")
    public String q3View() {        
        System.out.println("q3 view...");
        return "view-q3";
    }

    @PostMapping("/q3")
    public RedirectView q3(
            HttpServletRequest request, 
            RedirectAttributes redirectAttributes) {
        System.out.println("q3 form...");
        String number1 = request.getParameter("number1");
        String number2 = request.getParameter("number2");
        String resultUser = request.getParameter("result");

        double calculatedResult = MathQuestionService.q3Multiplication(number1, number2);
        System.out.println("User result: " + resultUser + ", answer: " + calculatedResult);

        RedirectView redirectView = null;
        if (calculatedResult == Double.valueOf(resultUser)) {
            redirectView = new RedirectView("/date1", true);
        } else {
            redirectView = new RedirectView("/q3", true);
            redirectAttributes.addFlashAttribute("message", "Wrong answer, try again.");
        }        
        return redirectView;
    }

    @GetMapping("/date1")
    public String date1View() {        
        System.out.println("date1 view...");
        return "view-date1";
    }

    @PostMapping("/date1")
    public RedirectView date1(
            HttpServletRequest request, 
            RedirectAttributes redirectAttributes) {
        System.out.println("date1 form...");
        String date = request.getParameter("date");

        String calculatedDate = DateUtilityService.dateAfter(date);
        System.out.println("Calculated Date: " + calculatedDate);

        RedirectView redirectView = new RedirectView("/date2", true);
        return redirectView;
    }

    @GetMapping("/date2")
    public String date2View() {        
        System.out.println("date2 view...");
        return "view-date2";
    }

    @PostMapping("/date2")
    public RedirectView date2(
            HttpServletRequest request, 
            RedirectAttributes redirectAttributes) {
        System.out.println("date2 form...");
        String date = request.getParameter("date");

        String calculatedDate = DateUtilityService.dateBefore(date);
        System.out.println("Calculated Date: " + calculatedDate);

        RedirectView redirectView = new RedirectView("/science", true);
        return redirectView;
    }

    @GetMapping("/science")
    public String scienceView() {        
        System.out.println("science view...");
        return "view-science";
    }

    @PostMapping("/science")
    public RedirectView science(
            HttpServletRequest request, 
            RedirectAttributes redirectAttributes) {
        System.out.println("science form...");
        String mass = request.getParameter("mass");
        String acceleration = request.getParameter("acceleration");

        double force = ScienceService.calculateForce(mass, acceleration);
        System.out.println("Calculated Force: " + force);

        RedirectView redirectView = new RedirectView("/science", true);
        redirectAttributes.addFlashAttribute("message", "Science problem solved!");
        return redirectView;
    }
}
