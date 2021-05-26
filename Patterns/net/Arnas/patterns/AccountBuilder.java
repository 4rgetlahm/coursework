package net.Arnas.patterns;

public class AccountBuilder {
    public String name;
    public String lastName;
    public int age;
    public String nickname;
    public String password;
    public int userID;

    public AccountBuilder name(String name){
        this.name = name;
        return this;
    }

    public AccountBuilder lastName(String lastName){
        this.lastName = lastName;
        return this;
    }

    public AccountBuilder age(int age){
        this.age = age;
        return this;
    }

    public AccountBuilder nickname(String nickname){
        this.nickname = nickname;
        return this;
    }

    public AccountBuilder password(String password){
        this.password = password;
        return this;
    }

    public AccountBuilder userID(int userID){
        this.userID = userID;
        return this;
    }

    public Account build(){
        if(nickname == null){
            throw new IllegalStateException("No nickname set");
        }
        if(password == null){
            throw new IllegalStateException("No password set");
        }
        if(name == null){
            throw new IllegalStateException("No name set");
        }
        if(lastName == null){
            throw new IllegalStateException("No last name set");
        }
        return new Account(this);
    }

}
