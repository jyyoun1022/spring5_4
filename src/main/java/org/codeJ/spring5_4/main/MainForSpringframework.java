package org.codeJ.spring5_4.main;

import org.codeJ.spring5_4.config.AppConfig1;
import org.codeJ.spring5_4.config.AppConfig2;
import org.codeJ.spring5_4.spring.*;
import org.codeJ.spring5_4.config.AppConfig1;
import org.codeJ.spring5_4.config.AppConfig2;
import org.codeJ.spring5_4.spring.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainForSpringframework {

    private static ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig1.class, AppConfig2.class);

    public static void main(String[] args)throws IOException {



        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            System.out.println("명령어를 입력하세요");

            String command = reader.readLine();

            if(command.equalsIgnoreCase("exit")){
                System.out.println("종료하겠습니다..");
                break;

            }
            if(command.startsWith("new ")){
                processNewCommand(command.split(" "));
                continue;
            }else if(command.startsWith("change ")){
                processChangeCommand(command.split(" "));
                continue;
            }else if(command.startsWith("list")){
                processListCommand();
                continue;
            }else if(command.startsWith("info")){
                processInfoCommand(command.split(" "));
                continue;
            }else if(command.startsWith("check version")){
                processCheckCommand();
                continue;
            }
            printHelp();

        }
    }
    private static void processNewCommand(String[] arg){
        if(arg.length != 5){
            printHelp();
            return;
        }
        MemberRegisterService regSvc = ctx.getBean("memberRegSvc", MemberRegisterService.class);
        RegisterRequest req = new RegisterRequest();
        req.setEmail(arg[1]);
        req.setName(arg[2]);
        req.setPassword(arg[3]);
        req.setConfirmPassword(arg[4]);

        if(!req.isPasswordEqualToConfirmPassword()){
            System.out.println("암호의 확인이 필요합니다.");
            return;
        }
        try{
            regSvc.register(req);
            System.out.println("등록되었습니다.");
        }catch (DuplicateMemberException e){
            System.out.println("이미 존재하는 이메일 입니다.");
        }
    }
    private static void processChangeCommand(String[] arg){
        if(arg.length != 5){
            printHelp();
            return;
        }
        ChangePasswordService changePwdSvc = ctx.getBean("changePwdSvc", ChangePasswordService.class);
        try{
            changePwdSvc.changePassword(arg[1],arg[2],arg[3]);
            System.out.println("암호를 변경했습니다.");
        }catch (MemberNotFoundException e){
            System.out.println("일치하는 이메일이 없습니다.");
        }catch( WrongidPasswordException e){
            System.out.println("이메일과 암호가 일치하지 않습니다.");
        }

    }

    private static void processListCommand(){
        MemberListPrinter listPrinter = ctx.getBean("listPrinter", MemberListPrinter.class);
        listPrinter.printAll();
    }

    private static void processInfoCommand(String[] arg){
        if(arg.length != 2){
            printHelp();
            return;
        }

        MemberInfoPrinter infoPrinter = ctx.getBean("infoPrinter", MemberInfoPrinter.class);
        infoPrinter.printMemberInfo(arg[1]);
    }

    private static void processCheckCommand(){
        VersionPrinter versionPrinter = ctx.getBean("versionPrinter", VersionPrinter.class);
        versionPrinter.print();
    }
    private static void printHelp(){
        System.out.println();
        System.out.println("잘못된 명령입니다.아래 명령어 사용범을 확인하세요");
        System.out.println("명령어 사용법:");
        System.out.println("new 이메일 이름 암호 암호확인");
        System.out.println("change 이메일 현재비번 변경할비번");
        System.out.println();
    }
}
