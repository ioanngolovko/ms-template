package ru.ioann.mst.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.http.HttpServletResponse;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests().antMatchers("/login").permitAll()
                .anyRequest().authenticated()
                .and().httpBasic().authenticationEntryPoint(authenticationEntryPoint());
    }

    @Override
    @Bean(name = "userDetailsService")
    public UserDetailsService userDetailsServiceBean() throws Exception {
        return super.userDetailsServiceBean();
    }

    @Bean
    public AuthenticationEntryPoint authenticationEntryPoint() {
        return (httpServletRequest, httpServletResponse, e) ->
                httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Access Denied");
    }

}
