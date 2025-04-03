package com.example.jour4.config;

import com.example.jour4.model.AppUser;
import com.example.jour4.repository.AppUserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                    .requestMatchers("/h2-console/**").hasRole("ADMIN")
                    .requestMatchers("/login", "/register", "/css/**", "/js/**").permitAll()
                    .anyRequest().authenticated()
            )
            .formLogin(form -> form
                    .loginPage("/login")
                    .defaultSuccessUrl("/persons", false)
                    .permitAll()
            )
            .rememberMe(rememberMe -> rememberMe
                    .key("mySecretKey")
                    .tokenValiditySeconds(300)
            )
            .logout(logout -> logout
                    .logoutUrl("/logout")
                    .logoutSuccessUrl("/login?logout")
            )
            .csrf(csrf -> csrf.disable())
            .headers(headers -> headers.frameOptions(frame -> frame.disable()));

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService(AppUserRepository appUserRepository, PasswordEncoder passwordEncoder) {
        return username -> {
            // Si l'utilisateur est "admin", on retourne un utilisateur codé en dur
            if ("admin".equals(username)) {
                return User.builder()
                        .username("admin")
                        .password(passwordEncoder.encode("admin")) // ou mot de passe souhaité
                        .roles("ADMIN", "USER")
                        .build();
            }
            // Sinon, on recherche l'utilisateur dans la base de données
            AppUser appUser = appUserRepository.findByUsername(username);
            if (appUser == null) {
                throw new UsernameNotFoundException("User not found: " + username);
            }
            return User.builder()
                    .username(appUser.getUsername())
                    .password(appUser.getPassword())
                    .roles(appUser.getRole()) // par exemple "USER"
                    .build();
        };
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}