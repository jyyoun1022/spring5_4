package org.codeJ.spring5_4.spring;

import java.time.LocalDateTime;

public class MemberRegisterService {
    private MemberDAO memberDAO;

    public MemberRegisterService(MemberDAO memberDAO) {
        this.memberDAO = memberDAO;
    }

    public Long register(RegisterRequest req){

        Member member = memberDAO.selectByEmail(req.getEmail());
        if(member != null){
            throw new DuplicateMemberException("이것은 중복된 이메일입니다 다시 입력해 주십시오. : "+req.getEmail());
        }
        Member newMember =new Member(
                req.getEmail(),req.getPassword(),req.getName(), LocalDateTime.now());

        memberDAO.insert(newMember);

        return newMember.getId();
    }
}
