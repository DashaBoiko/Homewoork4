public class User {
    private String userName;
    private String password;
    private String telephoneNumber;
    private boolean mediatorOrRegular;
    //true - mediator, false - Regular


    public User(String userName, String password, String telephoneNumber, boolean mediatorOrRegular)
    {
        this.userName = userName;
        this.password = password;
        this.telephoneNumber = telephoneNumber;
        this.mediatorOrRegular = mediatorOrRegular;
    }



    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public String getUserName()
    {
        return userName;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getPassword()
    {
        return password;
    }

    public void setTelephoneNumber(String telephoneNumber)
    {
        this.telephoneNumber = telephoneNumber;
    }

    public String getTelephoneNumber()
    {
        return telephoneNumber;
    }

    public void setMediatorOrRegular(boolean mediatorOrRegular)
    {
        this.mediatorOrRegular = mediatorOrRegular;
    }

    public boolean getMediatorOrRegular()
    {
        return mediatorOrRegular;
    }


    public String toString()
    {

        String str = "User name: " + userName;
        str+= "\nPassword: " + password;
        str+= "\nPhone number: " + telephoneNumber;
        str+= "\nUser type: ";

        if(mediatorOrRegular == true)
            str+= "mediator";
        else
            str+= "regular";




        return str;
    }



}

