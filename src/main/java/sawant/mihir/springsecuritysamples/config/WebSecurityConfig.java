package sawant.mihir.springsecuritysamples.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class WebSecurityConfig {


    @Bean
    public PasswordEncoder passwordEncoder(){
        return new Argon2PasswordEncoder(10, 50, 2, 5, 10);
    }

    @Bean
    public UserDetailsService userDetailsService(){
       var uds = new InMemoryUserDetailsManager();


       var u1 = User.withUsername("mihir")
               .password("abc12")
               .authorities("read")
               .passwordEncoder(pass -> passwordEncoder().encode(pass))
               .build();


       uds.createUser(u1);
       // never do this
        System.out.println(u1.getPassword());
       return uds;
    }
}
