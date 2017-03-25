package com.ksimeo.arsu.admin.web.controllers;

import com.ksimeo.arsu.api.services.UserService;
import com.ksimeo.arsu.entities.DTO.UserDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author Ksimeo. Created on 13.12.2016 at 19:00 for "mwm-space" project.
 * @version 1.0
 * @since 1.0
 */
@Controller
public class LoginController {

    private final Logger logger = LoggerFactory.getLogger(LoginController.class);

//    @Autowired
    private UserService usrServ;

//    @Autowired
//    private LoginFormValidator loginFormValidator;

//    @InitBinder
//    protected void initBinder(WebDataBinder binder) {
//        binder.setValidator(loginFormValidator);
//    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(ModelMap model) {

        logger.debug("index()");
        return "redirect:/login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public  String showLoginForm(Model model) {

        logger.debug("showLoginForm()");
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView checkLoginForm(@PathVariable("loginForm") @Validated UserDTO usr,
                              BindingResult result, Model model,
                              final RedirectAttributes redirectAttributes,
                                       HttpServletRequest request) {

        logger.debug("checkLoginForm() : {}", usr);

        boolean isUserExist = usrServ.checkByLoginPassword(usr);

        if (result.hasErrors()) {
            ModelAndView modelAndView = new ModelAndView("login");
            modelAndView.addObject("msg", "Приложение вызвало ошибку, попробуйте зайти позже или обратитесь " +
                    "к администратору!");
            return modelAndView;
        } else if (usrServ.checkByLoginPassword(usr)) {
            HttpSession session = request.getSession(true);

            ModelAndView modelAndView = new ModelAndView("main.do");
            modelAndView.addObject("msg", usrServ.getAll());
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("login");
            modelAndView.addObject("msg", "Пользователя с таким логином " +
                    "и/или паролем не существует!");
            return modelAndView;
        }
    }
}
