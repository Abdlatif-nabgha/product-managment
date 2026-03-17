package com.nabgha.demowebproducts.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Security configuration class for the application.
 * Configures authentication and authorization rules.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    /**
     * Defines the password encoder bean to be used for hashing passwords.
     * @return a BCryptPasswordEncoder instance.
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * Configures in-memory users for authentication.
     * This method defines users, their passwords (encoded), and their roles.
     *
     * @param passwordEncoder the encoder to hash the plain-text passwords.
     * @return an InMemoryUserDetailsManager containing the defined users.
     */
    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager(PasswordEncoder passwordEncoder) {
        return new InMemoryUserDetailsManager(
                User.withUsername("Nabgha").password(passwordEncoder.encode("44026676")).roles("ADMIN", "USER").build(),
                User.withUsername("Abdellatif").password(passwordEncoder.encode("44026676")).roles("USER").build(),
                User.withUsername("Omar").password(passwordEncoder.encode("44026676")).roles("USER").build()
        );
    }

    /**
     * Configures the security filter chain to define which HTTP requests are secured.
     *
     * @param http the HttpSecurity object to configure.
     * @return the built SecurityFilterChain.
     * @throws Exception if an error occurs during configuration.
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                //.formLogin(Customizer.withDefaults())
                .formLogin(f -> f.loginPage("/login").permitAll())
                .authorizeHttpRequests(ar -> ar.requestMatchers("/user/**").hasRole("USER"))
                .authorizeHttpRequests(ar -> ar.requestMatchers("/admin/**").hasRole("ADMIN"))
                .authorizeHttpRequests(ar -> ar.requestMatchers("/public/**", "/webjars/**").permitAll())
                .authorizeHttpRequests(ar -> ar.anyRequest().authenticated())
                .exceptionHandling((e -> e.accessDeniedPage("/notAuthorized")))
                .build();
    }
}
