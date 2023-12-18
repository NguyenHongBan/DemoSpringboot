package com.example.LoginForm.LoginController;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.LoginForm.Logindomain.Login;
import com.example.LoginForm.Loginservice.Loginservice;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class Logincontroller {

	@Autowired
    private Loginservice userService;
                                   
    @GetMapping("/login")
           
    public ModelAndView login() {
        ModelAndView mav = new ModelAndView("login");
        mav.addObject("user", new Login());
        return mav;
    }
    @PostMapping("/login")
    public String login(@ModelAttribute("user") Login user ) {
        
        Login oauthUser = userService.login(user.getUsername(), user.getPassword());
        
        System.out.print(oauthUser);
        if(Objects.nonNull(oauthUser)) 
        {    
  
            return "redirect:/";
        
            
        } else {
        	
            return "redirect:/login";
            
        }
}
    
    @PostMapping(value = {"/logout"})
    public String logoutDo(HttpServletRequest request,HttpServletResponse response)
    {     
        return "redirect:/login";
    }
}
