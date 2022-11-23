package com.fareye.flipzone.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Configuration
@Slf4j
@EnableWebSecurity
public class WebSecurityConfig {
//for react js
    //    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
//        http.cors().and()
//                .csrf().disable()
//                .authorizeRequests()
//                .antMatchers("/user").permitAll()
//                .antMatchers("/getUser").authenticated()
//                .antMatchers("/user/**").permitAll()
//                .antMatchers("/product").permitAll()
//                .antMatchers("/address").permitAll()
//                .antMatchers("/address/**").permitAll()
//                .antMatchers("/product/**").permitAll()
//
//                .antMatchers("/order/**").permitAll()
//                .antMatchers("/order").permitAll()
//                .antMatchers("/transactions/**").permitAll()
//                .antMatchers("/transaction/**").permitAll()
//                .antMatchers(HttpMethod.POST, "/product").hasRole("RETAILER")
//                .antMatchers("/cart").permitAll()
//                .antMatchers("/login").permitAll()
//                .antMatchers("/cartItem").permitAll()
//                .antMatchers("/cartItem/**").permitAll()
//                .antMatchers("/orderitem").permitAll()
//                .antMatchers("/orderitem").permitAll()
//                .antMatchers("/orderitems").permitAll()
//        // .antMatchers(HttpMethod.POST, "/product").hasRole("RETAILER")
//                .antMatchers("/category").permitAll()
//                .antMatchers("/cart").permitAll()
//                .antMatchers("/orderitem").permitAll()
//                .anyRequest()
//                .authenticated()
//                .and()
//                .formLogin(form ->
//                        form.loginProcessingUrl("/login").permitAll()
//                                .successHandler(
//                                        ( request, response, authentication ) -> {
//                                            response.setStatus( HttpServletResponse.SC_ACCEPTED );
//                                            response.setHeader("X-User", authentication.getName());
//                                        }
//                                )
//                                .failureHandler(
//                                        ( request, response, authenticationException ) -> {
//                                            log.debug("failureHandler:", authenticationException);
//                                            response.sendError(HttpServletResponse.SC_FORBIDDEN, authenticationException.getMessage());
//                                        }
//                                )
//                )
//                .exceptionHandling()
//                .authenticationEntryPoint(( request, response, authenticationException ) -> {
//                    log.debug("authenticationEntryPoint:", authenticationException);
//                    response.sendError(HttpServletResponse.SC_UNAUTHORIZED, authenticationException.getMessage());
//                })
//                .accessDeniedHandler(( request, response, accessDeniedException ) -> {
//                    log.debug("accessDeniedHandler:", accessDeniedException);
//                    response.sendError(HttpServletResponse.SC_FORBIDDEN, accessDeniedException.getMessage());
//                })
//        ;
//        return http.build();
//    }
//for react native
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.cors().and()
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/user").permitAll()
                .antMatchers("/user/**").permitAll()
                .antMatchers("/product").permitAll()
                .antMatchers("/address").permitAll()
                .antMatchers("/address/**").permitAll()
                .antMatchers("/product/**").permitAll()

                .antMatchers("/order/**").permitAll()
                .antMatchers("/order").permitAll()
                .antMatchers("/transactions/**").permitAll()
                .antMatchers("/transaction/**").permitAll()
                .antMatchers(HttpMethod.POST, "/product").hasRole("RETAILER")
                .antMatchers("/cart").permitAll()
                .antMatchers("/login").permitAll()
                .antMatchers("/cartItem").permitAll()
                .antMatchers("/cartItem/**").permitAll()
                .antMatchers("/orderitem").permitAll()
                .antMatchers("/orderitem").permitAll()
                .antMatchers("/orderitems").permitAll()
               // .antMatchers(HttpMethod.POST, "/product").hasRole("RETAILER")

                .antMatchers("/category").permitAll()
                .antMatchers("/cart").permitAll()
                .antMatchers("/orderitem").permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .loginProcessingUrl("/login")
                .failureHandler(new AuthenticationFailureHandler() {
                    @Override
                    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
                                                        AuthenticationException exception) throws IOException, ServletException {
                        response.setStatus(HttpStatus.UNAUTHORIZED.value());
                    }
                });
        return http.build();
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("http://localhost:3000");
            }
        };
    }
}
