package pl.coderslab.charity;

import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.coderslab.charity.entity.User;
import pl.coderslab.charity.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class LoginController {

    private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = {"/login"}, method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("user",new User());
        return "register";
    }

    @PostMapping("/register")
    public String addUser(@Valid User user, BindingResult result, HttpServletRequest request) {
        if (result.hasErrors()) {
            return "register";
        }
        String password2 = request.getParameter("password2");
        if (user.getPassword().equals(password2)) {
            userService.saveUser(user);
            return "redirect:/";
        } else {
            request.setAttribute("wrong",true);
            return "register";
        }
    }
}
