package org.codeJ.spring5_4.assembler;

import org.codej.spring5_3.spring.ChangePasswordService;
import org.codej.spring5_3.spring.MemberDAO;
import org.codej.spring5_3.spring.MemberRegisterService;

public class Assembler {

    private MemberDAO memberDAO;
    private MemberRegisterService regService;
    private ChangePasswordService pwdService;

    public Assembler(){

        memberDAO = new MemberDAO();
        regService = new MemberRegisterService(memberDAO);
        pwdService = new ChangePasswordService(memberDAO);

    }

    public MemberDAO getMemberDAO() {
        return memberDAO;
    }

    public MemberRegisterService getRegService() {
        return regService;
    }

    public ChangePasswordService getPwdService() {
        return pwdService;
    }
}
