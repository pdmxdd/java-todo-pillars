package com.company;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<String> todoList = new ArrayList<String>();
        ArrayList<String> completedList = new ArrayList<String>();
        todoList.add("dishes");
        todoList.add("laundry");
        String menuOption;
        do {
            menuOption = displayMenuAndGetInput(input);
            switch(menuOption) {
                case "1":
                    displayItems(todoList, "====TODO Items====");
                    break;
                case "2":
                    todoList.add(promptForItem(input));
                    System.out.println("Todo List updated");
                    break;
                case "3":
                    System.out.println("Choose the item you would like to mark as complete:");
                    int itemToMarkCompleteIndex = promptForListItem(input, todoList, "====TODO Items====");
                    String item = todoList.remove(itemToMarkCompleteIndex);
                    completedList.add(item);
                    System.out.println(item + " marked as complete");
                    break;
                case "4":
                    displayItems(completedList, "====Completed Items====");
                    break;
                case "5":
                    System.out.println("You chose remove completed item");
                    System.out.println("Choose the item you would like to remove:");
                    int itemToRemoveIndex = promptForListItem(input, completedList, "====Completed Items====");
                    completedList.remove(itemToRemoveIndex);
                    System.out.println("Completed list updated");
                    break;
                case "6":
                    input.close();
                    System.out.println("Goodbye");
                    break;
                default:
                    System.out.println("Invalid choice, choose again");

            }
        }
        while(!menuOption.equals("6"));

    }

    public static String displayMenuAndGetInput(Scanner scanner) {
        System.out.println("What would you like to do:");
        System.out.println("1. View Todo List");
        System.out.println("2. Add Todo Item");
        System.out.println("3. Mark Todo Item as complete");
        System.out.println("4. View Completed Items");
        System.out.println("5. Remove Completed Item");
        System.out.println("6. EXIT");
        String choice = scanner.nextLine();
        return choice;
    }

    public static void displayItems(ArrayList<String> list, String header) {
        System.out.println(header);
        for(int i = 0; i < list.size(); i++) {
            System.out.println(i + 1 + ". " + list.get(i));
        }
        System.out.println("=".repeat(header.length()));
    }

    public static String promptForItem(Scanner scanner) {
        System.out.println("What item would you like to add to your todo list?");
        String newItem = scanner.nextLine();
        return newItem;
    }

    public static int promptForListItem(Scanner scanner, ArrayList<String> list, String header) {
        displayItems(list, header);
        System.out.println("Enter the number for the list item you would like to select:");
        int userChoice = scanner.nextInt() - 1;
        scanner.nextLine();
        return userChoice;
    }
}
