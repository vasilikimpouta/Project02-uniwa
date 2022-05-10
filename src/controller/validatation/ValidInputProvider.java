package controller.validatation;

import java.util.Scanner;

public class ValidInputProvider {

    public static String getString(){
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        while(!Validators.validateNotEmpty(input)){
            System.out.println("enter again :");
            input = scanner.nextLine();
        }
        return input;
    }


    public static String getPhone(){
        Scanner scanner = new Scanner(System.in);
        String phone = scanner.nextLine();
        while(!Validators.validatePhoneNumber(phone)){
            System.out.println("enter again :");
            phone = scanner.nextLine();
        }
        return phone;
    }


    public static String getEmail(){
        Scanner scanner = new Scanner(System.in);
        String email = scanner.nextLine();
        while(!Validators.validateEmail(email)){
            System.out.println("enter again :");
            email = scanner.nextLine();
        }
        return email;
    }
}
