package org.codeJ.spring5_4.spring;

public class MemberInfoPrinter {

    private MemberDAO memberDAO;
    private MemberPrinter memberPrinter;

    public void printMemberInfo(String email){
        Member member = memberDAO.selectByEmail(email);
        if(member == null){
            System.out.println("일치하는 데이터가 없습니다.");
            return;
        }
        memberPrinter.print(member);
    }

    public void setMemberDAO(MemberDAO memberDAO) {
        this.memberDAO = memberDAO;
    }

    public void setMemberPrinter(MemberPrinter memberPrinter) {
        this.memberPrinter = memberPrinter;
    }
}
