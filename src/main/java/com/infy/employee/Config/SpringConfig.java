package com.infy.employee.Config;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Properties;


@Configuration
public class SpringConfig {

    @Autowired
    Environment environment;

     @Bean
     public PasswordEncoder passwordEncoder(){
         return new BCryptPasswordEncoder();
     }

     @Bean
     public ModelMapper modelMapper(){
        return new ModelMapper();
     }

//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .cors(Customizer.withDefaults())
//                .csrf(csrf -> csrf.disable())
//                .authorizeHttpRequests(auth -> {
//                    auth.requestMatchers("/api/login/*").authenticated();
//                    auth.anyRequest().permitAll();
//                })
//                .httpBasic(Customizer.withDefaults());
//
//        return http.build();
//    }

//     @Bean
//     public Docket api(){
//         return new Docket(DocumentationType.SWAGGER_2)
//                 .select()
//                 .apis(RequestHandlerSelectors.any())
//                 .paths(PathSelectors.any())
//                 .build();
//     }

    @Bean
    public JavaMailSender javaMailSender() {
        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
        javaMailSender.setHost(environment.getProperty("spring.mail.host"));
        javaMailSender.setPort(Integer.parseInt(environment.getProperty("spring.mail.port")));
        javaMailSender.setUsername(environment.getProperty("spring.mail.username"));
        javaMailSender.setPassword(environment.getProperty("spring.mail.password"));
        Properties properties = javaMailSender.getJavaMailProperties();
        properties.put("mail.smtp.starttls.enable", "true");
        return javaMailSender;
    }
}
