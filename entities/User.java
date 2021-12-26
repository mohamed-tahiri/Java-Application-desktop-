/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author pc
 */
public class User {
    // Attr
    private int id;
    private String fullname;
    private String email;
    private String secret;
    private String password;

    // Constructor
    public User(String fullname, String email, String secret, String password) {
        this.fullname  = fullname ;
        this.email     = email    ;
        this.secret    = secret   ;
        this.password  = password ;
    }

    // Constructor
    public User(int id , String fullname, String email, String secret, String password) {
        this.id        = id       ;
        this.fullname  = fullname ;
        this.email     = email    ;
        this.secret    = secret   ;
        this.password  = password ;
    }
    
    public User(int id , String fullname, String email) {
        this.id        = id       ;
        this.fullname  = fullname ;
        this.email     = email    ;
    }
    
    
    // Getter
    public int getId() {
        return id;
    }

    public String getFullname() {
        return fullname;
    }

    public String getEmail() {
        return email;
    }
    
    public String getSecret(){
        return secret;
    };
    
    public String getPassword(){
        return password;
    }
    
    // Setter 
    public void setId(int id) {
        this.id = id;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSecret(String secret){
        this.secret = secret;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    
    
    // To String

    @Override
    public String toString() {
        return "User {" + "id=" + id + ", fullname=" + fullname + ", email=" + email + ", secret="+ secret 
                +", password="+ password +'}';
    }
            
}
