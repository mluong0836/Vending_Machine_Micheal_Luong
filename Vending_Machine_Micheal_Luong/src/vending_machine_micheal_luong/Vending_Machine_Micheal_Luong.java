/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vending_machine_micheal_luong;

import java.util.Scanner;

/**
 *
 * @author micheal
 */
public class Vending_Machine_Micheal_Luong {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Vending_Machine vm = new Vending_Machine();
        vm.Init();
        System.out.println("There's a candy vending machine right here.");
        System.out.println("You grab your wallet out and examine the options available.");
        boolean loop = true;
        while (loop) {
            vm.printOptions();
            System.out.println("To buy a candy, type in the location of the candy.");
            System.out.println("To read the guide book type 2");
            System.out.println("To Quit type 3.");
            Scanner scan = new Scanner(System.in);
            String[] response = scan.nextLine().split(",");
            if (response[0].equalsIgnoreCase("2")) {
                System.out.println("Here are the rules:");
                Rules();
            } else if (response[0].equalsIgnoreCase("3")) {
                loop = false;
                System.out.println("The machine powers down...");
            } else {
                try {
                    vm.Select(response);
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("I did not understand you...");
                }
            }
        }
    }

    static void Rules() {
        System.out.println("This is a Vending Machine full of candies.");
        System.out.println("To select a Candy, you must type in the coordinates");
        System.out.println("of the candy with the rows being either a letter or number");
        System.out.println("and the column being a number.");
        System.out.println("Make sure it is in the form of row, column before proceeding.");
        System.out.println("\n\n\n\n\n\n");
    }
}
