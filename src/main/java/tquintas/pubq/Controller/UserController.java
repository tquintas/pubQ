package tquintas.pubq.Controller;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import tquintas.pubq.Records.LoggedUser;
import tquintas.pubq.Model.User;
import tquintas.pubq.Service.LogService;
import tquintas.pubq.Service.UserService;

@Controller
@AllArgsConstructor
public class UserController {

    private UserService userService;
    private LogService logService;

    @RequestMapping("/")
    public String mainPage() {
        return "index";
    }
    @GetMapping("/login")
    public String loginPage(Model model, HttpSession session) {
        if (session.getAttribute("user_id") != null) return "redirect:/";
        model.addAttribute("user", new User());
        return "login";
    }
    @PostMapping("/login")
    public String login(@ModelAttribute("loginUser") User user, HttpSession session) {
        try {
            User currentUser = userService.validateLogin(user);
            LoggedUser loggedUser = new LoggedUser(currentUser.getId(), currentUser.getFirstName() + " " + currentUser.getLastName());
            session.setAttribute("user_id", loggedUser);
            logService.insertLog("User logged in", currentUser);
            return "redirect:/";
        } catch (Exception e) {
            return "redirect:/login?error";
        }

    }
    @RequestMapping("/register")
    public String registerPage(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }
    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("user") User user, BindingResult bindingResult, HttpSession session) {
        if (bindingResult.hasErrors()) {
            return "register";
        }
        User currentUser = userService.createUser(user);
        LoggedUser loggedUser = new LoggedUser(currentUser.getId(), currentUser.getFirstName() + " " + currentUser.getLastName());
        session.setAttribute("user_id", loggedUser);
        logService.insertLog("User registered", currentUser);
        return "redirect:/";
    }

    @GetMapping("/logout")
    public String logoff(HttpSession session) {
        if (session.getAttribute("user_id") == null) return "redirect:/";
        LoggedUser loggedUser = (LoggedUser)session.getAttribute("user_id");
        User oldUser = userService.getUserById(loggedUser.id());
        session.setAttribute("user_id", null);
        logService.insertLog("User logged out", oldUser);
        return "redirect:/";
    }

    @GetMapping("/profile")
    public String getProfile(HttpSession session, Model model) {
        if (session.getAttribute("user_id") == null) return "redirect:/";
        LoggedUser loggedUser = (LoggedUser)session.getAttribute("user_id");
        User currentUser = userService.getUserById(loggedUser.id());
        currentUser.setPassword("");
        model.addAttribute("user", currentUser);
        return "profile";
    }
}
