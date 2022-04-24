package controller;

import java.util.Scanner;
import java.util.Set;

public class ChoiceController {

    private Set<Integer> validOptions;

    public ChoiceController(Set<Integer> validOptions) {
        this.validOptions = validOptions;
    }

    public int getChoice() {
        Scanner choiceInput = new Scanner(System.in);
        int choice = choiceInput.nextInt();
        while (!this.validOptions.contains(choice)) {
            System.err.println("Not a valid option");
            System.out.println("Enter your option again:");
            choice = choiceInput.nextInt();
        }
        return choice;
    }
}
