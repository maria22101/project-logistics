package com.training.projectlogistics.config;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class LoginHandler extends SimpleUrlAuthenticationSuccessHandler {
    private final static String DETERMINED_URL = "/login?error=true";
    private final static String ADMIN_PATH = "/admin";
    private final static String USER_PATH = "/user";
    private final static String ADMIN_ROLE = "ADMIN";
    private final static String USER_ROLE = "USER";

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
        String url = DETERMINED_URL;

        Collection<? extends GrantedAuthority> authorities = auth.getAuthorities();
        List<String> roles = new ArrayList<>();
        for(GrantedAuthority ga : authorities) {
            roles.add(ga.getAuthority());
        }

        if(roles.contains(ADMIN_ROLE)) {
            url = ADMIN_PATH;
        }else if(roles.contains(USER_ROLE)) {
            url = USER_PATH;
        }

        return url;
    }
}
