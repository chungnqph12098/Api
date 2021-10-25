package DATN.Sercurity;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecutiryConfig extends WebSecurityConfigurerAdapter {

	@Override
    public void configure(HttpSecurity http) throws Exception {

        http
//                .antMatcher("/**").authorizeRequests()
//                .antMatchers("/login", "/notlogin").permitAll()
//                .anyRequest().authenticated()
//                .and()
//                .oauth2Login()
//                .defaultSuccessUrl("/login/success")
//                ;
        
 //use for test api
        .csrf().disable()
        .authorizeRequests()
            .anyRequest().permitAll();
	
}	
}