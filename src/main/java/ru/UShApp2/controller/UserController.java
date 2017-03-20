package ru.UShApp2.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PathVariable;
import ru.UShApp2.model.ShUrl;
import ru.UShApp2.model.Tag;
import ru.UShApp2.model.User;
import ru.UShApp2.service.SecurityService;
import ru.UShApp2.service.ShUrlService;
import ru.UShApp2.service.TagService;
import ru.UShApp2.service.UserService;
import ru.UShApp2.validator.UserValidator;
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

    private TagService tagService;

    private SecurityService securityService;

    private UserValidator userValidator;

    @Autowired
    public UserController(ShUrlService shUrlService, UserService userService, SecurityService securityService, UserValidator userValidator, TagService tagService) {
        this.shUrlService = shUrlService;
        this.userService = userService;
        this.securityService = securityService;
        this.userValidator = userValidator;
        this.tagService = tagService;
    }


    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("userForm", new User());

        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        userService.save(userForm);

        securityService.autoLogin(userForm.getUsername(), userForm.getConfirmPassword());

        return "redirect:/main";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(@ModelAttribute("shorturl") ShUrl shUrl, Model model, String error, String logout) {
        model.addAttribute("shUrl",new ShUrl());
        List<ShUrl> shUrls = this.shUrlService.getUrls();
        model.addAttribute("shUrls",shUrls);
        if (error != null) {
            model.addAttribute("error", "Неверное имя пользователя или пароль");
        }

        if (logout != null) {
            model.addAttribute("message", "Выход осуществлен!");
        }

        return "login";
    }

    @RequestMapping(value = "/shortu{idUrl}",method = RequestMethod.GET)
    public String shortu(@PathVariable("idUrl") Integer idUrl, Model model){
        model.addAttribute("shUrl",this.shUrlService.getUrlById(idUrl));
        return "shortu";
    }


    @RequestMapping(value = {"/", "/main"}, method = RequestMethod.GET)
    public String main(@ModelAttribute("shorturl") ShUrl shUrl, Model model) {
        model.addAttribute("shUrl",new ShUrl());
        model.addAttribute("tag",new Tag());
        model.addAttribute("user", this.securityService.findLoggedInUsername());
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String Username = userDetails.getUsername();
        List<ShUrl> shUrls = this.shUrlService.getUrlByUsername(Username);
        model.addAttribute("shUrls",shUrls);
        return "/main";
    }


    @RequestMapping(value = "main/add",method = RequestMethod.POST)
    public String createUrl(@ModelAttribute("shUrl") ShUrl shUrl){
        User user = shUrl.getUser();
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String Username1 = userDetails.getUsername();
        String Password1 = userDetails.getPassword();
        user.setUsername(Username1);
        user.setPassword(Password1);
        User user1 = this.userService.findByUsername(Username1);
        shUrl.setUser(user1);
        if (shUrl.getIdUrl()==0){
            this.shUrlService.createUrl(shUrl);
                    }else {
            this.shUrlService.updateUrl(shUrl);
                    }

        return "redirect:/main" ;
    }

    @RequestMapping(value = "remove/{idUrl}")
    public String removeUrl(@PathVariable("idUrl") int idUrl){
        this.shUrlService.removeUrl(idUrl);
        return "redirect:/main";
    }

    @RequestMapping(value = "edit/{idUrl}")
    public String editUrl(@PathVariable("idUrl") int idUrl, Model model) {
        model.addAttribute("shUrl", this.shUrlService.getUrlById(idUrl));
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String Username = userDetails.getUsername();
        model.addAttribute("shUrls", this.shUrlService.getUrlByUsername(Username));
        return "main";
    }
    @RequestMapping(value = "byTag/{tagname}",method = RequestMethod.GET)
       public String byTag(@PathVariable("tagname") String tagname, Model model )
        {
            List<ShUrl> shUrls = this.shUrlService.getUrlByTagname(tagname);
        model.addAttribute("shUrls",shUrls);

return "byTag";
        }

        @RequestMapping(value = "tags",method = RequestMethod.GET)
        public String getTags(@ModelAttribute("tags") Tag tag,Model model)
        {List<Tag> tags = this.tagService.getTags();
            model.addAttribute("tags",tags);

        return "tags";
        }
    }

