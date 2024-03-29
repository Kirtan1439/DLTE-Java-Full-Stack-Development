package bank.project.app;

import bank.project.dao.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class BankSecurity {

    @Autowired
    BankService bankService;

    AuthenticationManager authenticationManager;

    @Autowired
    LoginSuccessHandler successHandler;

    @Autowired
    LoginFailureHandler failureHandler;

    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        //Permitting login(error)
        httpSecurity.authorizeRequests((requests)->{
      requests.antMatchers("/resources/static/images**").permitAll();
            requests.antMatchers("/web/login**").permitAll();
            requests.antMatchers("/web/**").authenticated();


            requests.anyRequest().permitAll();
        });


  httpSecurity.httpBasic();
  httpSecurity.formLogin().loginPage("/web/login").defaultSuccessUrl("/web/dashboard").failureUrl("/web/login").permitAll();
        httpSecurity.logout().permitAll();
        httpSecurity.formLogin().loginPage("/web/login").usernameParameter("username").failureHandler(failureHandler).successHandler(successHandler).permitAll();

        httpSecurity.csrf().disable();


        AuthenticationManagerBuilder builder=httpSecurity.getSharedObject(AuthenticationManagerBuilder.class);
        builder.userDetailsService(bankService);
        authenticationManager=builder.build();
        httpSecurity.authenticationManager(authenticationManager);

        return httpSecurity.build();
    }
}