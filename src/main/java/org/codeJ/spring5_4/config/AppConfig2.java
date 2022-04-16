package org.codeJ.spring5_4.config;

import org.codej.spring5_3.spring.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig2 {

    @Autowired
    private MemberDAO memberDAO;

    @Autowired
    private MemberPrinter memberPrinter;

    @Bean
    public MemberRegisterService memberRegSvc(){
        return new MemberRegisterService(memberDAO);
    }
    @Bean
    public ChangePasswordService changePwdSvc(){
        return new ChangePasswordService(memberDAO);
    }
    @Bean
    public MemberListPrinter memberListPrinter(){
        return new MemberListPrinter(memberDAO,memberPrinter);
    }
    @Bean
    public MemberInfoPrinter memberInfoPrinter(){
        MemberInfoPrinter infoPrinter = new MemberInfoPrinter();
        infoPrinter.setMemberDAO(memberDAO);
        infoPrinter.setMemberPrinter(memberPrinter);
        return infoPrinter;
    }
    @Bean
    public VersionPrinter versionPrinter(){
        VersionPrinter versionPrinter = new VersionPrinter();
        versionPrinter.setMajorVersion(5);
        versionPrinter.setMinorVersion(0);
        return versionPrinter;
    }
}
