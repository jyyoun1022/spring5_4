package org.codeJ.spring5_4.spring;

import java.time.LocalDateTime;

public class Member {

    private Long id;

    private String email;

    private String password;

    private String name;

    private LocalDateTime regDate;

    public Member(String email, String password, String name, LocalDateTime regDate) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.regDate = regDate;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getRegDate() {
        return regDate;
    }
    public void changePassword(String oldPassword,String newPassword){

        if(!password.equals(oldPassword)){
            throw new WrongidPasswordException();
        }
        this.password = newPassword;
    }
}
