package com.example.lab222.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true,prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()//кои страници да ни бидат достапни
                .antMatchers("/", "/books", "/assets/**",  "/api/**").permitAll()//koi stranici na koi url treba da bidat dozvoleni od korisnici
                //.antMatchers("/admin/**").hasRole("ADMIN")//stranici dozvoleni samo za korisnici so uloga administrator
                .anyRequest()
                .authenticated() //site drugi url so ne se navedeni da se pristapat samo ako e avtenticiran korisnikot
                .and()
                .formLogin()
                .loginPage("/login").permitAll() //deka e dozvolena za site ovaa stranica
                .failureUrl("/login?error=BadCredentials") //ako se sluci exception, togas kazuvame na koe url da odi korisnikot
                .defaultSuccessUrl("/books",true)//ako uspee najavata
                .and()
                .logout()
                .logoutUrl("/logout")
                .clearAuthentication(true)//da se trgne avtentikacijata
                .invalidateHttpSession(true)//invalidacija na sesijata
                .deleteCookies("JSESSIONID")//da se izbrise cookito
                .logoutSuccessUrl("/login") //ako e uspesno da ne odnese na login
                .and()
                .exceptionHandling().accessDeniedPage("/access_denied");
    }
}
