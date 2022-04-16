package org.codeJ.spring5_4.spring;

public class MemberPrinter {

    public void print(Member member){
        System.out.println("회원정보 출력");
        System.out.println("ID : "+member.getId()+"\nEmail : "+member.getEmail()+"\nName : "+member.getName()+"\nregDate : "+member.getRegDate());

    }
}
