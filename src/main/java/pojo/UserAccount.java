package pojo;

public class UserAccount {

    private String email;
    private String password;
    private boolean shouldLogin;

    private String firstName;
    private String lastName;
    private String randomEmail;
    private String telephone;

    public UserAccount(String firstName, String lastName, String telephone, String password){
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.telephone = telephone;
    }

    public UserAccount(String email, String password, boolean shouldLogin){
        this.email = email;
        this.password = password;
        this.shouldLogin = shouldLogin;
    }



    public void setEmail(String username){
        this.email = username;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getEmail(){
        return email;
    }

    public String getPassword(){
        return password;
    }

    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public String getRandomEmail(){
        return randomEmail;
    }

    public String getTelephone(){
        return telephone;
    }

    public void setShouldLogin(){
        this.shouldLogin = shouldLogin;
    }

    public boolean shouldLogin(){
        return shouldLogin;
    }

    @Override
    public String toString(){
        return (String.format("EmailL %s and password %s", email, password));
    }

}
