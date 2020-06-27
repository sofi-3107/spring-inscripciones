package com.eet3107.inscripciones.configuration;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.eet3107.inscripciones.entidades.Usuario;
import com.eet3107.inscripciones.services.UserDetailsServiceImpl;
import com.eet3107.inscripciones.services.interfaces.UsuarioService;

@Configuration
@EnableWebSecurity
public class LoginSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	BCryptPasswordEncoder encoder;
	
	@Autowired
	UserDetailsServiceImpl userDetails;
	
	@Autowired
	UsuarioService service;

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		encoder=new BCryptPasswordEncoder(4);
		return encoder;

	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
			List<Usuario>users=service.getUsuarios();			
			for(Usuario user: users) {
				auth.inMemoryAuthentication()
					.withUser(user.getUserName())
					.password(user.getPassword())
					.roles(user.getRol());				
			}
		
	}
		

	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		String [] resources=new String [] {
				"/include/**","/css/**","/icons/**","/img/**","/js/**","/layer/**"
		};
			http
			 .authorizeRequests()
			 .antMatchers(resources).permitAll()
			 .antMatchers("/signup","/login").permitAll()
			 .antMatchers("/**").hasAnyRole("directivo")// asi indicamos a que urls accede cada rol
		        .anyRequest().authenticated()
		     .and()
		     .formLogin()
		     .loginPage("/login")
		     	.permitAll()
		     	.defaultSuccessUrl("/test")
		     	.failureUrl("/login?error=Usuario o contraseña incorrectos") // Falta colocar un alert en la vista que maneje parametros de error y el logout
		        .usernameParameter("userName")
                .passwordParameter("password")
                .and()
                .logout()
                .permitAll()
                .logoutSuccessUrl("/login?logout=Usted ha cerrado sesión");
	
	}
	
	
}
