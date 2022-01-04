public class Property {
    private Address address;
    private int numberOfRooms;
    private double price;
    private int type;
    private boolean ifForRent;
    private int houseNumber;
    private int floorNumber;
    private User userPosted;


    public Property(Address adress, int numberOfRooms, double price,
                    int type, boolean ifForRent, int houseNumber, int floorNumber, User userPosted)
    {
        this.address = adress;
        this.numberOfRooms = numberOfRooms;
        this.price = price;
        this.type = type;
        this.ifForRent = ifForRent;
        this.houseNumber = houseNumber;
        this.floorNumber = floorNumber;
        this.userPosted = userPosted;
    }


    public void setAddress(Address address)
    {
        this.address = address;
    }

    public Address getAddress()
    {
        return address;
    }


    public void setNumberOfRooms(int numberOfRooms)
    {
        this.numberOfRooms = numberOfRooms;
    }

    public int getNumberOfRooms()
    {
        return numberOfRooms;
    }


    public void setPrice(double price)
    {
        this.price = price;
    }

    public double getPrice()
    {
        return price;
    }

    public void setType(int type)
    {
        this.type = type;
    }

    public int getType()
    {
        return type;
    }

    public void setIfForRent(boolean ifForRent)
    {
        this.ifForRent = ifForRent;
    }

    public boolean getIfForRent()
    {
        return ifForRent;
    }

    public void setHouseNumber(int houseNumber)
    {
        this.houseNumber = houseNumber;
    }

    public int getHouseNumber()
    {
        return houseNumber;
    }

    public void setFloorNumber(int floorNumber)
    {
        this.floorNumber = floorNumber;
    }

    public int getFloorNumber()
    {
        return floorNumber;
    }

    public void setUserPosted(User userPosted)
    {
        this.userPosted = userPosted;
    }

    public User getUserPosted()
    {
        return userPosted;
    }

    public String toString()
    {
        String str = "For rent";
        if(type==1)
        {
            str+="Standard apartment: " + numberOfRooms +" rooms, floor " + floorNumber + "." ;

        }
        if(type==2)
        {
            str+="Penthouse: " + numberOfRooms + " rooms, floor " + floorNumber + "." ;;
        }

        if(type==3)
        {
            str+="Private house: " + numberOfRooms + " rooms.";
        }

        str+="\nPrice: " + price + "dollar.";
        str+="\nContact Information: " + userPosted.getUserName() + " " + userPosted.getTelephoneNumber();

        if(userPosted.getMediatorOrRegular()==true)str+=" (mediator).";
        else str+=".";


        return str;
    }

}


