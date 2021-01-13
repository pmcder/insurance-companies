package com.pmcderm.insapi.services;

import java.util.Optional;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.pmcderm.insapi.entities.Role;
import com.pmcderm.insapi.entities.User;
import com.pmcderm.insapi.repositories.RoleRepository;
import com.pmcderm.insapi.repositories.UserRepository;
import com.pmcderm.insapi.security.JwtProvider;

@Service
public class UserService {

	
		private UserRepository userRepository;
		
		private AuthenticationManager authenticationManager;
		
        private RoleRepository roleRepository;
        
        private PasswordEncoder passwordEncoder;
        
        private JwtProvider jwtProvider;

        private static final Logger logger = LogManager.getLogger(UserService.class); 
        
        @Autowired
        public UserService(UserRepository userRepository, AuthenticationManager authenticationManager,
				RoleRepository roleRepository, PasswordEncoder passwordEncoder,
				JwtProvider jwtProvider) {
			super();
			this.userRepository = userRepository;
			this.authenticationManager = authenticationManager;
			this.roleRepository = roleRepository;
			this.passwordEncoder = passwordEncoder;
			this.jwtProvider = jwtProvider;
		}



		public Optional<User> signup(String username, String password, String firstName, String lastName) {
            if (!userRepository.findByUserName(username).isPresent()) {
                Optional<Role> role = roleRepository.findByRoleName("ROLE_ADMIN");
                return Optional.of(userRepository.save
                        (new User(2,username,
                                passwordEncoder.encode(password),
                                lastName,
                                firstName,
                                role.get())));
            }
            return Optional.empty();
        }

		 public Authentication signinNonToken(String username, String password) {
		        return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		    }
		 
		   /**
		     * Sign in a user into the application, with JWT-enabled authentication
		     *
		     * @param username  username
		     * @param password  password
		     * @return Optional of the Java Web Token, empty otherwise
		     */
		    public Optional<String> signin(String username, String password) {
		        logger.info("user with the following username signed in: "+ username);
		        Optional<String> token = Optional.empty();
		        Optional<User> user = userRepository.findByUserName(username);
		        if (user.isPresent()) {
		            try {
		                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		                token = Optional.of(jwtProvider.createToken(username, user.get().getRoles()));
		            } catch (AuthenticationException e){
		                
		            }
		        }
		        return token;
		    }



		public UserRepository getUserRepository() {
			return userRepository;
		}



		public void setUserRepository(UserRepository userRepository) {
			this.userRepository = userRepository;
		}



		public AuthenticationManager getAuthenticationManager() {
			return authenticationManager;
		}



		public void setAuthenticationManager(AuthenticationManager authenticationManager) {
			this.authenticationManager = authenticationManager;
		}



		public RoleRepository getRoleRepository() {
			return roleRepository;
		}



		public void setRoleRepository(RoleRepository roleRepository) {
			this.roleRepository = roleRepository;
		}



		public PasswordEncoder getPasswordEncoder() {
			return passwordEncoder;
		}



		public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
			this.passwordEncoder = passwordEncoder;
		}



		public JwtProvider getJwtProvider() {
			return jwtProvider;
		}



		public void setJwtProvider(JwtProvider jwtProvider) {
			this.jwtProvider = jwtProvider;
		}

	
        
	
        
}
