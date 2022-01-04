import java.util.Scanner;

public class RealEstate {

    private User []users;
    private Property []properties;
    private Address[] addresses;

    private int usersCount = 0;
    private int propertiesCount = 0;
    private int addressesCount = 0;


    public RealEstate()
    {
        int count = 10;
        users = new User[count];
        properties = new Property[count];
        addresses = new Address[count];

        addressesCount = count;

        //Формирование адресов
        addresses[0] = new Address("Ashkelon", "Shapira");
        addresses[1] = new Address("Tel Aviv", "Ben Gurion");
        addresses[2] = new Address("Ashkelon", "Yafe");
        addresses[3] = new Address("Jerusalem", "Herzel");
        addresses[4] = new Address("Herzilya", "Kohav a Zafron");
        addresses[5] = new Address("Ashdod", "Shay Agnon");
        addresses[6] = new Address("Ber Sheva", "Ehuda a Levi");
        addresses[7] = new Address("Tel Aviv", "Ana Frank");
        addresses[8] = new Address("Ashkelon", "Eli Cohen");
        addresses[9] = new Address("Zithron Yakov", "Shivat Zion");

    }

    //get
    public int getUsersCount()
    {
        return usersCount;
    }


    public int getPropertiesCount()
    {
        return propertiesCount;
    }

    public int getAddressesCount()
    {
        return addressesCount;
    }




    public static boolean CompareTo(String str1, String str2)
    {
        if(str1.length()!=str2.length())return false;

        for(int i=0;i<str1.length();i++)
            if(str1.charAt(i)!=str2.charAt(i))
                return false;

        return true;

    }




    public void createUser()
    {
        String userName;
        Scanner scn = new Scanner(System.in);
        boolean isUser;


        do
        {
            isUser=false;
            System.out.print("Enter your username: ");
            userName = scn.nextLine();
            for(int i=0;i<usersCount;i++)
            {
                if(CompareTo(userName, users[i].getUserName())==true)
                {
                    isUser = true;
                    break;
                }
            }

            if(isUser==true)
            {
                System.out.println("User " + userName + " exists in the system!");
            }

        }
        while(isUser==true);


        String userPassword;
        boolean numberPassword;
        boolean threeSymbolPassword;
        do
        {
            numberPassword = false;
            threeSymbolPassword = false;

            System.out.print("Enter the password: ");
            userPassword = scn.nextLine();
            for(int i=0;i<userPassword.length();i++)
            {
                if(userPassword.charAt(i)>='0' && userPassword.charAt(i)<='9')
                    numberPassword = true;

                if(userPassword.charAt(i)=='$' || userPassword.charAt(i)=='%'||userPassword.charAt(i)=='_')
                    threeSymbolPassword = true;
            }

            if(numberPassword==false||threeSymbolPassword==false)
            {
                System.out.println("Password " + userPassword + " not reliable!");
            }

        }
        while(numberPassword==false || threeSymbolPassword==false);



        String userTelephoneNumber;
        boolean isTelephoneNumber;
        do
        {
            isTelephoneNumber = false;

            System.out.print("Enter the phone number: ");
            userTelephoneNumber = scn.nextLine();
            if(userTelephoneNumber.length()!=10)
            {
                System.out.println("Phone number " + userTelephoneNumber + " not correct!");
                continue;
            }

            if(userTelephoneNumber.charAt(0)!='0' && userTelephoneNumber.charAt(1)!='5')
            {
                System.out.println("Phone number" + userTelephoneNumber + " not correct!");
                continue;
            }

            isTelephoneNumber = true;

            for(int i=0;i<userTelephoneNumber.length();i++)
            {
                if(userTelephoneNumber.charAt(i)<'0' || userTelephoneNumber.charAt(i)>'9')
                {
                    isTelephoneNumber = false;
                    break;
                }

            }

            if(isTelephoneNumber==false)
            {
                System.out.println("Phone number " + userTelephoneNumber + " not correct!");
            }


        }
        while(isTelephoneNumber == false);



        int userType;
        do
        {

            System.out.print("Enter user type: 1-mediator, 2-regular-->");
            userType = scn.nextInt();

            if(userType<1 || userType>2)
            {
                System.out.println("You must enter the numbers 1 or 2!");
            }


        }
        while(userType<1 || userType>2);


        users[usersCount] = new User(userName, userPassword, userTelephoneNumber, true);
        if(userType==2)
            users[usersCount].setMediatorOrRegular(false);
        usersCount++;


    }



    public User userLogin()
    {
        String userName, userPassword;
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter your username: ");
        userName = scn.nextLine();
        System.out.print("Enter password: ");
        userPassword = scn.nextLine();


        for(int i=0;i<usersCount;i++)
        {
            if(CompareTo(users[i].getUserName(), userName) == true &&
                    CompareTo(users[i].getPassword(), userPassword) == true)
            {
                return users[i];
            }
        }

        System.out.println("Username and / or password are incorrect!");

        return null;
    }


    boolean postNewProperty (User user)
    {

        int i,j,limitProperties;
        int numberOfUserProperties = 0;
        if(user.getMediatorOrRegular()==true)
            limitProperties = 10;
        else
            limitProperties = 3;

        for(i=0;i<propertiesCount;i++)
        {
            if(CompareTo(user.getUserName(),properties[i].getUserPosted().getUserName())
                    == true && CompareTo(user.getPassword(),properties[i].getUserPosted().getPassword())==true)
            {
                numberOfUserProperties++;
            }

        }

        if(numberOfUserProperties == limitProperties)
        {
            System.out.println("User " + user.getUserName() + " reached its limit on " + limitProperties +" publications");
            return false;
        }


        int cityCount = 0;

        String []masCityName = new String[addressesCount];

        // Array of unique keys
        // true - the city is unique
        // false - the city is repeated
        boolean []masCityUnique = new boolean[addressesCount];

        for(i=0;i<masCityUnique.length;i++)
            masCityUnique[i] = true;


        for(i=0; i< addressesCount -1; i++)
        {
            for(j=i+1; j< addressesCount; j++)
            {
                if(masCityUnique[i]==true && masCityUnique[j]==true &&
                        CompareTo(addresses[i].getCityName(), addresses[j].getCityName())==true)

                {
                    masCityUnique[j] = false;
                }
            }
        }


        for(i=0;i<masCityUnique.length;i++)
        {
            if(masCityUnique[i] == true)
            {
                masCityName[cityCount] = addresses[i].getCityName();
                cityCount++;
            }
        }


        System.out.println("List of cities: ");
        for(i=0;i<cityCount;i++)
        {
            System.out.println(masCityName[i]);
        }

        Scanner scn = new Scanner(System.in);
        System.out.println("Enter one of the existing cities in the list: ");


        String currentCity = scn.nextLine();
        boolean isCurrentCity = false;
        for(i=0;i<cityCount;i++)
        {
            if(CompareTo(masCityName[i],currentCity)==true)
            {
                isCurrentCity = true;
                break;
            }
        }

        if(isCurrentCity==false)
        {
            System.out.println("Cities " + currentCity + " not on the list!");
            return false;
        }


        System.out.println("List of city streets " + currentCity + ":");
        for(i=0; i< addressesCount; i++)
        {
            if(CompareTo(addresses[i].getCityName(),currentCity)==true)
            {
                System.out.println(addresses[i].getStreetName());
            }

        }

        System.out.println("Enter one of the existing streets in the list:");
        String currentStreet = scn.nextLine();
        boolean isCurrentStreet = false;
        for(i=0; i< addressesCount; i++)
        {

            if(CompareTo(addresses[i].getCityName(),currentCity)==true)
            {
                if(CompareTo(addresses[i].getStreetName(),currentStreet)==true)
                {
                    isCurrentStreet = true;
                    break;
                }
            }

        }

        if(isCurrentStreet==false)
        {
            System.out.println("Streets " + currentStreet + " not on the list!");
            return false;
        }


        int currentType;
        System.out.println("Choose the type of property");
        System.out.println("1 - for a standard apartment in an apartment building");
        System.out.println("2 - for a penthouse apartment in an apartment building");
        System.out.println("3 - for a private house");

        do
        {
            System.out.print("Enter the type from 1 to 3-->");
            currentType = scn.nextInt();

            if(currentType<1 || currentType>3)
            {
                System.out.println("You need to enter numbers from 1 to 3!");
            }

        }
        while(currentType<1 || currentType>3);


        int currentFloorNumber = 0;


        if(currentType<3)
        {

            do
            {
                System.out.print("Enter the number of floor from 0 to 16-->");
                currentFloorNumber = scn.nextInt();

                if(currentFloorNumber<0 || currentFloorNumber>16)
                {
                    System.out.println("Enter the numbers from 0 to 16!");
                }

            }
            while(currentFloorNumber<0 || currentFloorNumber>16);

        }


        int currentNumberOfRooms;
        do
        {
            System.out.print("Enter the numbers of room from 1 to 10-->");
            currentNumberOfRooms = scn.nextInt();

            if(currentNumberOfRooms<1 || currentNumberOfRooms>10)
            {
                System.out.println("You need to enter numbers from 1 to 10!");
            }

        }
        while(currentNumberOfRooms<1 || currentNumberOfRooms>10);


        int currentHouseNumber;
        do
        {
            System.out.print("Enter the number of property from 1 to 10-->");
            currentHouseNumber = scn.nextInt();

            if(currentHouseNumber<1 || currentHouseNumber>10)
            {
                System.out.println("You need to enter numbers from 1 to 10!");
            }

        }
        while(currentHouseNumber<1 || currentHouseNumber>10);




        int currentIfForRent;
        do
        {
            System.out.print("Apartment for rent - 1, for sale - 2 -->");
            currentIfForRent = scn.nextInt();

            if(currentIfForRent<1 || currentIfForRent>2)
            {
                System.out.println("You need to enter number 1 or 2!");
            }

        }
        while(currentIfForRent<1 || currentIfForRent>2);


        double currentPrice;
        do
        {
            System.out.print("Enter the price of property from 1000 -->");
            currentPrice = scn.nextDouble();

            if(currentPrice<1000)
            {
                System.out.println("You need to enter price from 1000");
            }

        }
        while(currentPrice<1000);


        properties[propertiesCount] = new Property(new Address(currentCity,currentStreet),
                currentNumberOfRooms, currentPrice, currentType, true, currentHouseNumber,
                currentFloorNumber, user);

        if(currentIfForRent==2)
            properties[propertiesCount].setIfForRent(false);
        propertiesCount++;



        return true;
    }


    void removeProperty (User user)
    {


        boolean isPostedProperty = false;
        int i, currentNumberProperty = 0;
        for(i=0;i<propertiesCount;i++)
        {
            if(CompareTo(user.getUserName(), properties[i].getUserPosted().getUserName()) == true &&
                    CompareTo(user.getPassword(), properties[i].getUserPosted().getPassword()) == true)
            {
                isPostedProperty = true;
                break;
            }
        }

        if(isPostedProperty==false)
        {
            System.out.println("User " + user.getUserName() +" does`nt have published properties");
            return;
        }


        System.out.println("Property of user " + user.getUserName() +":");

        for(i=0;i<propertiesCount;i++)
        {
            if(CompareTo(user.getUserName(), properties[i].getUserPosted().getUserName()) == true &&
                    CompareTo(user.getPassword(), properties[i].getUserPosted().getPassword()) == true)
            {
                currentNumberProperty++;
                System.out.println(currentNumberProperty);
            }
        }


        Scanner scn = new Scanner(System.in);


        int removeNumberProperty;
        do
        {
            System.out.print("Enter the number of property for removing " + currentNumberProperty + " -->");
            removeNumberProperty = scn.nextInt();

            if(removeNumberProperty<1 || removeNumberProperty>currentNumberProperty)
            {
                System.out.println("You must enter the numbers from  "+currentNumberProperty+"!");
            }

        }
        while(removeNumberProperty<1 || removeNumberProperty>currentNumberProperty);



        int indexProperty = 0;
        currentNumberProperty = 0;
        for(i=0;i<propertiesCount;i++)
        {
            if(CompareTo(user.getUserName(), properties[i].getUserPosted().getUserName()) == true &&
                    CompareTo(user.getPassword(), properties[i].getUserPosted().getPassword()) == true)
            {
                currentNumberProperty++;
                if(removeNumberProperty==currentNumberProperty)
                {
                    indexProperty = i;
                    break;
                }
            }
        }


        for(i=indexProperty;i<propertiesCount-1;i++)
        {
            properties[i]=properties[i+1];
        }
        propertiesCount--;
        /////////////////////////////////////
        System.out.println("Property № "+removeNumberProperty+" successfully deleted!");



    }



    void printAllProperties ()
    {
        for(int i=0;i<propertiesCount;i++)
        {
            System.out.println("Property № "+(i+1));
            System.out.println(properties[i]);
        }

        if(propertiesCount==0)
            System.out.println("There is no property in the system!");

    }


    void printAllProperties (User user)
    {
        int i,currentNumberProperty = 0;
        for(i=0;i<propertiesCount;i++)
        {
            if(CompareTo(user.getUserName(), properties[i].getUserPosted().getUserName()) == true &&
                    CompareTo(user.getPassword(), properties[i].getUserPosted().getPassword()) == true)
            {

                currentNumberProperty++;
                System.out.println("Property № " + currentNumberProperty);
                System.out.println(properties[i]);
            }
        }

        if(currentNumberProperty==0)
            System.out.println("No property in the system for the user" + user.getUserName() + "!");


    }


    Property[] search()
    {

        Scanner scn = new Scanner(System.in);

        int currentIfForRent;
        do
        {
            System.out.print("Apartment for rent - 1, for sale - 2-->");
            currentIfForRent = scn.nextInt();

            if(currentIfForRent == 999)break;

            if(currentIfForRent<1 || currentIfForRent>2)
            {
                System.out.println("You must enter the numbers 1 or 2!");
            }

        }
        while(currentIfForRent<1 || currentIfForRent>2);



        int currentType;
        System.out.println("Choosing the type of property:");
        System.out.println("1 - for a standard apartment in an apartment building");
        System.out.println("2 - for a penthouse apartment in an apartment building");
        System.out.println("3 - for a private house");

        do
        {
            System.out.print("Enter a type from 1 to 3-->");
            currentType = scn.nextInt();

            if(currentType == 999)break;


            if(currentType<1 || currentType>3)
            {
                System.out.println("You must enter numbers from 1 to 3!");
            }

        }
        while(currentType<1 ||  currentType>3);


        int currentNumberOfRooms;
        do
        {
            System.out.print("Enter the number of rooms from 1 to 10-->");
            currentNumberOfRooms = scn.nextInt();

            if(currentNumberOfRooms == 999)break;


            if(currentNumberOfRooms<1 || currentNumberOfRooms>10)
            {
                System.out.println("You must enter numbers from 1 to 10!");
            }

        }
        while(currentNumberOfRooms<1 || currentNumberOfRooms>10);



        double minimumPrice, maximumPrice;
        do
        {
            System.out.print("Enter the minimum property price-->");
            minimumPrice = scn.nextDouble();

            if(minimumPrice == 999)break;


            if(minimumPrice<0)
            {
                System.out.println("A minimum price of more than 0 NIS must be entered");
            }

        }
        while(minimumPrice<0);



        do
        {
            System.out.print("Enter the maximum property price-->");
            maximumPrice = scn.nextDouble();

            if(maximumPrice == 999)break;

            if(maximumPrice<0 || maximumPrice<minimumPrice)
            {
                System.out.println("You must enter a maximum price greater than 0 shekels or the minimum price must not exceed the maximum");
            }

        }
        while(maximumPrice<0||maximumPrice<minimumPrice);


        int i, currentNumberProperty = 0;
        Property[]tempArrProperty = new Property[propertiesCount];

        for(i=0;i<propertiesCount;i++)
        {
            if(currentIfForRent==1 && properties[i].getIfForRent()==false)continue;
            if(currentIfForRent==2 && properties[i].getIfForRent()==true)continue;
            if(currentType!=999 && currentType!= properties[i].getType())continue;
            if(currentNumberOfRooms!=999 && currentNumberOfRooms!= properties[i].getNumberOfRooms())continue;

            if(minimumPrice!=999 && maximumPrice!=999)
            {
                if(properties[i].getPrice()<minimumPrice || properties[i].getPrice()>maximumPrice)continue;
            }

            tempArrProperty[currentNumberProperty] = properties[i];
            currentNumberProperty++;

        }


        Property[]arrProperty = new Property[currentNumberProperty];
        for(i = 0; i<currentNumberProperty;i++)
            arrProperty[i] = tempArrProperty[i];


        return arrProperty;
    }





}