
// package com.example.project.config;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.core.userdetails.User;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import org.springframework.security.provisioning.InMemoryUserDetailsManager;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.security.web.SecurityFilterChain;

// @Configuration
// @EnableWebSecurity
// public class SecurityConfig {

//     @Bean
//     public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//         http
//             .authorizeHttpRequests(auth -> auth
//                 .requestMatchers("/**").permitAll()  // Allow access to public URLs
//                 // .requestMatchers("/api/**","/public/**","/css/**","/js/**","/images/**","/assets/**","/agences","/abattements").permitAll()  // Allow access to public URLs

//                 .anyRequest().authenticated()              // Authenticate all other requests
//             )
//             .formLogin(form -> form
//                 .loginPage("/login")
//                 .permitAll()
//             )
//             .logout(logout -> logout
//                 .permitAll()
//             );

//         return http.build();
//     }

//     @Bean
//     public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
//         // Example with in-memory user details manager
//         InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//         manager.createUser(User.withUsername("user")
//                 .password(passwordEncoder.encode("password"))
//                 .roles("-")
//                 .build());
//         return manager;
//     }

//     @Bean
//     public PasswordEncoder passwordEncoder() {
//         return new BCryptPasswordEncoder();
//     }
// }