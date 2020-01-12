package com.training.projectlogistics.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Configuration
public class LoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    @Override
    protected void handle(HttpServletRequest request,
                          HttpServletResponse response,
                          Authentication authentication) throws IOException, ServletException {

        String targetUrl = determineTargetUrl(authentication);

        if(response.isCommitted()) {
            return;
        }

        RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
        redirectStrategy.sendRedirect(request, response, targetUrl);
    }

    protected String determineTargetUrl(Authentication auth) {
        String url = "/login?error=true";

        //Fetch the role from Authentication object
        Collection<? extends GrantedAuthority> authorities = auth.getAuthorities();
        List<String> roles = new ArrayList<>();
        for(GrantedAuthority ga : authorities) {
            roles.add(ga.getAuthority());
        }

        //Check the user role and decide on corresponding url
        if(roles.contains("ADMIN")) {
            url = "/admin";
        }else if(roles.contains("USER")) {
            url = "/user";
        }

        return url;
    }
}
