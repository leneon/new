// package com.example.project.config;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

// @Configuration
// @EnableWebSecurity
// public class SecurityConfig extends WebSecurityConfigurerAdapter {

// 	@Override
// 	protected void configure(HttpSecurity http) throws Exception {
// 		http
// 			.authorizeRequests()
// 				.antMatchers("/css/**", "/index").permitAll()		
// 				.antMatchers("/user/**").hasRole("USER")	
// 				.antMatchers("/public/**").permitAll() // Autoriser l'accès à ces URLs sans authentification
//                 .anyRequest().authenticated() // Toutes les autres URLs nécessitent une authentification
// 				.and()
// 			.formLogin() // Activer la connexion basée sur le formulaire
//                 .loginPage("/login") // Page de connexion personnalisée
//                 .permitAll() // Autoriser l'accès à la page de connexion sans authentification
//             	.and()
//             .logout() // Activer la déconnexion
//                 .logoutUrl("/logout")
//                 .permitAll(); // Autoriser l'accès à la déconnexion sans authentification
    
// 	}

// 	@Autowired
// 	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
// 		auth
// 			.inMemoryAuthentication()
// 				.withUser("user").password("password").roles("USER");
// 	}
// }