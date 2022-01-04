public class Address {



        private String cityName;
        private String streetName;


        public Address(String cityName, String streetName)
        {
            this.cityName = cityName;
            this.streetName = streetName;
        }


        public void setCityName(String cityName)
        {
            this.cityName = cityName;
        }

        public String getCityName()
        {
            return cityName;
        }

        public void setStreetName(String streetName)
        {
            this.streetName = streetName;
        }

        public String getStreetName()
        {
            return streetName;
        }

        //Метод toString

        public String toString()
        {
            String str = "City: " + cityName;
            str+= "\nStreet: " + streetName;
            return str;
        }

    }

