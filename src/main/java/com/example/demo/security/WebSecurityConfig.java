package com.example.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

   @Bean
   public PasswordEncoder passwordEncoder() {
      return new BCryptPasswordEncoder();
   }

   @Bean
   public UserDetailsService userDetailsService() {
      return new BookQuestDetailsService();   
      }

   public DaoAuthenticationProvider authenticationProvider() {
      DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
      authProvider.setUserDetailsService(userDetailsService());
      authProvider.setPasswordEncoder(passwordEncoder());
     return authProvider;
   }
 
   @Override
   protected void configure(HttpSecurity http) throws Exception {
	   //http.authorizeRequests().anyRequest().permitAll();
	   http.authorizeRequests().antMatchers("/","/informationBranch/{id}","/sign/","/login/", "/book", "/book/{theme}", "/book/{theme}/page/{pageNum}").permitAll()
	   		.antMatchers("/admin/**").hasAuthority("admin")
	   		.anyRequest().authenticated();	  
	   http.formLogin()
            .loginPage("/login")
            .usernameParameter("email")
            .permitAll()
      .and().logout().permitAll();
   }

   @Override
   public void configure(WebSecurity web) throws Exception {
      web.ignoring().antMatchers("/images/**","/bookCover/**", "/css/**", "/js/**", "/webjars/**");
   }

}