import java.util.Scanner;

public class ExerciseRealEstate {
    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);


        RealEstate realEstate = new RealEstate();

        int mainMenu, userMenu;
        boolean isMenu = true;
        boolean isSecondMenu = true;

        while (true) {
            if (isMenu) {
                System.out.println("Main menu:");
                System.out.println("1 - Create an account");
                System.out.println("2 - Sign in with your existing account");
                System.out.println("3 - End the program");
            }


            System.out.print("\nSelect a menu item from 1 to 3-->");
            mainMenu = scn.nextInt();
            if (mainMenu < 1 || mainMenu > 3) {
                System.out.print("Wrong menu item");
                isMenu = false;
                continue;
            }

            isMenu = true;


            if (mainMenu == 1) {
                realEstate.createUser();
            }


            if (mainMenu == 2) {
                User currentUser = realEstate.userLogin();

                if (currentUser != null) {
                    while (true) {
                        if (isSecondMenu) {

                            System.out.println("User menu" + currentUser.getUserName() + " :");
                            System.out.println("1 -Post your new property");
                            System.out.println("2 -Remove advertisements at the facility");
                            System.out.println("3 -View all posts in the system");
                            System.out.println("4 - View all posts posted by user");
                            System.out.println("5 - Property search by parameters");
                            System.out.println("6 - Disconnect and return to the main menu");
                            /////////////////////////////////////////////////////////////////
                        }

                        System.out.print("\nSelect a menu item from 1 to 6-->");
                        userMenu = scn.nextInt();
                        if (userMenu < 1 || userMenu > 6) {
                            System.out.print("Wrong menu item");
                            isSecondMenu = false;
                            continue;
                        }

                        isSecondMenu = true;


                        if (userMenu == 1) {
                            realEstate.postNewProperty(currentUser);
                        }


                        if (userMenu == 2) {
                            realEstate.removeProperty(currentUser);
                            System.out.println();
                        }


                        if (userMenu == 3) {
                            realEstate.printAllProperties();
                            System.out.println();
                        }


                        if (userMenu == 4) {
                            realEstate.printAllProperties(currentUser);
                            System.out.println();
                        }


                        if (userMenu == 5) {
                            Property[] arrProperty = realEstate.search();


                            for (int i = 0; i < arrProperty.length; i++) {
                                System.out.println("Property № " + (i + 1));
                                System.out.println(arrProperty[i]);
                            }

                            if (arrProperty.length == 0)
                                System.out.println("According to the specified filter, there are no properties in the system!");


                            System.out.println();
                        }


                        if (userMenu > 1 && userMenu < 6) {
                            scn.nextLine();
                            scn.nextLine();
                        }


                        if (userMenu == 6) {
                            break;
                        }

                    }

                }
            }


            if (mainMenu == 3) {
                break;
            }
        }


        scn.close();


    }
}