package com.gestioPlus.spring.controller;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/log")
public class LoginController {
    @GetMapping
    public String login() {
        return "login2";
    }
    @GetMapping("/sin-cuenta")
    public String loginSinCuenta() {
        System.out.println("FUNCIONA");
        // Forzar el login con el usuario 'default'
        Authentication defaultAuth = new UsernamePasswordAuthenticationToken("user", "123");
        SecurityContextHolder.createEmptyContext().setAuthentication(defaultAuth);
        SecurityContextHolder.getContext().setAuthentication(defaultAuth);
        return "redirect:/estudiantes";  // Redirigir a la página de inicio
    }
}
