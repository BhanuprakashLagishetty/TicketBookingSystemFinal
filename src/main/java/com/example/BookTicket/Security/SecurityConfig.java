package com.example.BookTicket.Security;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig{
    @Autowired
    private UserDetailsService userDetailsService;
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    public AuthenticationProvider authProvider(){
        DaoAuthenticationProvider provider=new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(new BCryptPasswordEncoder());
        return provider;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests(
                authorizeRequests ->
                        authorizeRequests
                                .requestMatchers("/removeTrain/**").hasRole("ADMIN")
                                .requestMatchers("/addTrain").hasRole("ADMIN")
                                .requestMatchers("/adminLogin").hasRole("ADMIN")
                                .requestMatchers("/loginUser").hasRole("USER")
                                .requestMatchers("/bookingTickets").hasRole("USER")
                                .requestMatchers("/HistoryOfBooking").hasRole("USER")
                                .requestMatchers("/CancelBooking").hasRole("USER")
                                .anyRequest().permitAll()
        );

        http.formLogin(Customizer.withDefaults());

        //disable cross Site request Forgery(CSRF)
        http.csrf(AbstractHttpConfigurer::disable);

        return http.build();
    }

}
