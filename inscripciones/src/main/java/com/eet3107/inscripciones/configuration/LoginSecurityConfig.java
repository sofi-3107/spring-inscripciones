package com.eet3107.inscripciones.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.eet3107.inscripciones.services.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
public class LoginSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	BCryptPasswordEncoder encoder;
	
	@Autowired
	UserDetailsServiceImpl userDetails;

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder bCryptEncoder=new BCryptPasswordEncoder();
		return bCryptEncoder;

	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetails).passwordEncoder(encoder);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		String [] resources=new String [] {
				"/include/**","/css/**","/icons/**","/img/**","/js/**","/layer/**"
		};
			http
			 .authorizeRequests()
		     .antMatchers("/carga").hasRole("ADMIN")
		        .anyRequest().authenticated()
		     .and()
		     .formLogin()
		     .loginPage("/login")
		     	.permitAll()
		     	.defaultSuccessUrl("/carga")
		     	.failureForwardUrl("/?alert=''danger")		        
		        .usernameParameter("username")
                .passwordParameter("password")
                .and()
                .logout()
                .permitAll()
                .logoutSuccessUrl("/login?logout");;
	
	}
	
	
}
