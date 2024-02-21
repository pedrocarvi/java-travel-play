package com.app.tap.config;

import com.app.tap.service.security.JwtAutheticationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {

    @Autowired
    private final JwtAutheticationFilter _jwtAuthenticationFilter;
    @Autowired
    private final AuthenticationProvider _authProvider;
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

    return http
            .csrf(csrf ->
                    csrf
                            .disable())
            .authorizeHttpRequests(authRequest ->
                    authRequest
                            .requestMatchers("/auth/**").permitAll()
                .anyRequest().authenticated()
            )
            .sessionManagement(sessionManager->
                    sessionManager
                            .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .authenticationProvider(_authProvider)
            .addFilterBefore(_jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
            .build();

    }
}




















































                                    // Este pedazo de codigo es la primera clase que cree pero que no finciona porque no encutra los paquetes instalados javax.
//@Configuration
//@EnableWebSecurity
//public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
//
//
//    @Autowired
//    private UserManagementService userManagementService;
//
//    @Autowired
//    private BCryptPasswordEncoder bCryptPasswordEncoder;
//
//
//
//    @Override
//    protected  void configure(HttpSecurity http) throws Exception{
//        http
//                .csrf().disable()
//                .authorizeRequests()
//                .antMatchers("/user/**")
//                .permitAll()
//                .anyRequest()
//                .authenticated().and()
//                .formLogin();
//    }
//
//
//
//    @Bean
//    public DaoAuthenticationProvider daoAuthenticationProvider() {
//        DaoAuthenticationProvider provider= new DaoAuthenticationProvider();
//        provider.setPasswordEncoder(bCryptPasswordEncoder);
//        provider.setUserDetailsService(userManagementService);
//        return provider;
//    }
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.authenticationProvider(daoAuthenticationProvider());
//    }
//
//
//}
