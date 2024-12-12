package com.gestioPlus.spring.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {


    /// Permisos a rutas
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((authz) -> authz
                        .requestMatchers(HttpMethod.GET, "/estudiantes/").permitAll()
                        .requestMatchers(HttpMethod.POST, "/estudiantes/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/estudiantes/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/estudiantes/**").hasRole("ADMIN")
                        .anyRequest().authenticated())
                .csrf().disable()
                .formLogin()
                .permitAll()
                .defaultSuccessUrl("/estudiantes", true)
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/estudiantes")
                .invalidateHttpSession(true)
                .clearAuthentication(true)
                .permitAll();
                return http.build();
    }


    /// Ignorar Rutas


    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return web -> web.ignoring().requestMatchers(HttpMethod.GET, "/Apiestudiantes/**");
    }

    /// Autenticacion en memoria sin base de datos
    @Bean
    public InMemoryUserDetailsManager userDetailsService() {

        UserDetails admin = User.withDefaultPasswordEncoder()
                .username("admin")
                .password("123")
                .roles("ADMIN")
                .build();
        return new InMemoryUserDetailsManager(admin);
    }
}
