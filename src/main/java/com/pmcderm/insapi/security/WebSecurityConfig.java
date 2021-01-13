package com.pmcderm.insapi.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.pmcderm.insapi.repositories.RoleRepository;



@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	InsAppUserDetailsService insAppUserDetailsService;
	
	@Autowired
	RoleRepository RoleRepository;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
			.antMatchers(HttpMethod.GET).permitAll()
			.antMatchers("/users/signin").permitAll()
			.antMatchers("/users/signup").permitAll()
				.anyRequest().authenticated();
		
	    http.csrf().disable();

	    // No session will be created or used by spring security
	    http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	    
	    http.addFilterBefore(new JwtTokenFilter(insAppUserDetailsService), UsernamePasswordAuthenticationFilter.class);
	}
	
	@Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(12);
    }
}