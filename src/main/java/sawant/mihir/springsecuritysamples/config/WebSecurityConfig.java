package sawant.mihir.springsecuritysamples.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class WebSecurityConfig {


    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService(){
       var uds = new InMemoryUserDetailsManager();

       var u1 = User.withUsername("mihir")
               .passwordEncoder((password) -> bCryptPasswordEncoder().encode(password))
               .password("abc12")
               .authorities("read").build();


       uds.createUser(u1);
       return uds;
    }
}
