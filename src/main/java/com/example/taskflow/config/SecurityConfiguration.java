package com.example.taskflow.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutHandler;


import static com.example.taskflow.entities.enums.Permission.*;
import static com.example.taskflow.entities.enums.Role.*;
import static org.springframework.http.HttpMethod.*;
import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableMethodSecurity
public class SecurityConfiguration {

    private static final String[] WHITE_LIST_URL = {
            "/api/v1/auth/**",
//            "/api/v1/tags/**",
//            "/api/v1/tasks/**",
//            "/api/v1/users/**",
            "/v2/api-docs",
            "/v3/api-docs",
            "/v3/api-docs/**",
            "/swagger-resources",
            "/swagger-resources/**",
            "/configuration/ui",
            "/configuration/security",
            "/swagger-ui/**",
            "/webjars/**",
            "/swagger-ui.html"};
    private final JwtAuthenticationFilter jwtAuthFilter;
    private final AuthenticationProvider authenticationProvider;
    private final LogoutHandler logoutHandler;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(req ->
                        req.requestMatchers(WHITE_LIST_URL)
                                .permitAll()
                                .requestMatchers("/api/v1/auth/**").permitAll()
                                .requestMatchers("/api/v1/users/**").permitAll()
                                .requestMatchers( GET,"/api/v1/tags/**").hasAnyAuthority(ADMIN_READ.getPermission())
                                .requestMatchers(POST, "/api/v1/tags/").hasAnyAuthority(ADMIN_CREATE.getPermission())
                                .requestMatchers(PUT, "/api/v1/tags/").hasAnyAuthority(ADMIN_UPDATE.getPermission())
                                .requestMatchers(DELETE, "/api/v1/tags/**").hasAnyAuthority(ADMIN_DELETE.getPermission())
                                .requestMatchers(GET,"/api/v1/tasks/**").hasAnyAuthority(ADMIN_READ.getPermission(), USER_READ.getPermission())
                                .requestMatchers(POST, "/api/v1/tasks/").hasAnyAuthority(ADMIN_CREATE.getPermission(), USER_CREATE.getPermission())
                                .requestMatchers(PUT, "/api/v1/tasks/**").hasAnyAuthority(ADMIN_UPDATE.getPermission(), USER_UPDATE.getPermission())
                                .requestMatchers(DELETE, "/api/v1/tasks/**").hasAnyAuthority(ADMIN_DELETE.getPermission(), USER_DELETE.getPermission())
                                .anyRequest()
                                .authenticated()
                )
                .sessionManagement(session -> session.sessionCreationPolicy(STATELESS))
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
                .logout(logout ->
                        logout.logoutUrl("/api/v1/auth/logout")
                                .addLogoutHandler(logoutHandler)
                                .logoutSuccessHandler((request, response, authentication) -> SecurityContextHolder.clearContext())
                )
        ;

        return http.build();
    }
}
