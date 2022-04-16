package org.codeJ.spring5_4.config;

import org.codej.spring5_3.spring.MemberDAO;
import org.codej.spring5_3.spring.MemberPrinter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig1 {

    @Bean
    public MemberDAO memberDAO(){
        return new MemberDAO();
    }
    @Bean
    public MemberPrinter memberPrinter(){
        return  new MemberPrinter();
    }

}
