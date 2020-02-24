package com.training.projectlogistics.config;

import com.training.projectlogistics.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import static com.training.projectlogistics.constants.WebConstants.*;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    private final static String LOGIN_COMMON_PATH = "/login/**";

    @Autowired
    private UserService userService;

    @Autowired
    private LoginSuccessHandler loginSuccessHandler;

    @Bean
    public PasswordEncoder bcryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService)
                .passwordEncoder(bcryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers(ROOT_PATH, LOGIN_COMMON_PATH, REGISTRATION).permitAll()
                .anyRequest().authenticated()
                .and()
                    .formLogin()
                    .loginPage(LOGIN)
                    .successHandler(loginSuccessHandler)
                    .failureUrl(LOGIN_FAILURE_URL)
                .and()
                    .logout()
                    .logoutUrl(LOGOUT)
                    .logoutSuccessUrl(ROOT_PATH).permitAll();
    }
}
