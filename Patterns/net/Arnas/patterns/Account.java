package net.Arnas.patterns;

public class Account {

    private String name;
    private String lastName;
    private int age;
    private String nickname;
    private String password;
    private int userID;

    public Account(AccountBuilder accountBuilder){
        this.userID = accountBuilder.userID;
        this.nickname = accountBuilder.nickname;
        this.password = accountBuilder.password;
        this.name = accountBuilder.name;
        this.lastName = accountBuilder.lastName;
        this.age = accountBuilder.age;
    }
}
