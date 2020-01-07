package org.deloitte.telecom.controller;


import org.deloitte.telecom.dto.SessionData;
import org.deloitte.telecom.entities.Account;
import org.deloitte.telecom.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class HelloController {

    private IAccountService service;

    public IAccountService getService() {
        return service;
    }

    @Autowired
    public void setService(IAccountService service) {
        this.service = service;
    }

    private SessionData sessionData;

    @Autowired
    public void setSessionData(SessionData data) {
        this.sessionData = data;

    }

    public SessionData getSessionData() {
        return sessionData;
    }


    @GetMapping("/userinput")
    public ModelAndView userInput() {
        System.out.println("inside userinput");
        return new ModelAndView("userinput");
    }

    @GetMapping("/logincheck")
    public RedirectView loginCheck(@RequestParam("mobileNo") String mobileNo,
                                   @RequestParam("password") String password) {

        boolean correct = service.credentialsCorrect(mobileNo, password);
        if (!correct) {
            return new RedirectView("/userinput");
        }
        Account customer = service.findAccountByMobileNo(mobileNo);
        sessionData.setUser(customer);
        return new RedirectView("/home");
    }

    @GetMapping("/home")
    public Object home() {
        if (sessionData.getUser() == null) {
            return new RedirectView("/userinput");
        }
        Account accCustomer = sessionData.getUser();
        ModelAndView mv = new ModelAndView("home", "customer", accCustomer);
        return mv;
    }


}
