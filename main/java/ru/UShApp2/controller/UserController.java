package ru.springapp.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import ru.springapp.model.ShUrl;
import ru.springapp.model.User;
import ru.springapp.service.SecurityService;
import ru.springapp.service.ShUrlService;
import ru.springapp.service.UserService;
import ru.springapp.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;


@Controller
public class UserController {

    private ShUrlService shUrlService;

    private UserService userService;

    private SecurityService securityService;

    private UserValidator userValidator;

    @Autowired
    public UserController(ShUrlService shUrlService, UserService userService, SecurityService securityService, UserValidator userValidator) {
        this.shUrlService = shUrlService;
        this.userService = userService;
        this.securityService = securityService;
        this.userValidator = userValidator;
    }


    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("userForm", new User());

        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        userService.save(userForm);

        securityService.autoLogin(userForm.getUsername(), userForm.getConfirmPassword());

        return "redirect:/main";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        model.addAttribute("shUrl",new ShUrl());
        List<ShUrl> shUrls = this.shUrlService.getUrls();
        model.addAttribute("shUrls", shUrls);
        if (error != null) {
            model.addAttribute("error", "Неверное имя пользователя или пароль");
        }

        if (logout != null) {
            model.addAttribute("message", "Выход осуществлен!");
        }

        return "login";
    }

    @RequestMapping(value = {"/", "/main"}, method = RequestMethod.GET)
    public String main(Model model) {
        model.addAttribute("shUrl",new ShUrl());
        model.addAttribute("getUrls", this.shUrlService.getUrls());
        return "/main";
    }


    @RequestMapping(value = "main/add",method = RequestMethod.POST)
    public String createUrl(@ModelAttribute("shUrl") ShUrl shUrl){
        if (shUrl.getIdUrl()==0){
            this.shUrlService.createUrl(shUrl);
        }else {
            this.shUrlService.updateUrl(shUrl);
        }

        return "redirect:/main";
    }

    @RequestMapping(value = "remove/{idUrl}")
    public String removeUrl(@PathVariable("idUrl") int idUrl){
        this.shUrlService.removeUrl(idUrl);
        return "redirect:/main";
    }

    @RequestMapping(value = "edit/{idUrl}")
    public String editUrl(@PathVariable("idUrl") int idUrl, Model model){
        model.addAttribute("shUrl",this.shUrlService.getUrlById(idUrl));
        model.addAttribute("getUrls",this.shUrlService.getUrls());
        return "main";
    }
        }
