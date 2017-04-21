/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vending_machine_micheal_luong;

    import java.util.ArrayList;

/**
 *
 * @author micheal
 */
public class Vending_Machine {
    private Candy candy[][][] = new Candy[3][3][1];
    private ArrayList<Candy> stock = new ArrayList<Candy>();
    private String[] labels = new String[9];//used for reference
    
    public void Init() {
        stock.add(new Candy("KitKats", "Chocolate", 218, 1.98, 10));
        stock.add(new Candy("Snickers", "Chocolate", 200, 2.50, 10));
        stock.add(new Candy("m&m's", "Chocolate", 200, 2.50, 10));
        stock.add(new Candy("Herseys", "Chocolate", 200, 2.50, 10));
        stock.add(new Candy("skittles", "fruity", 200, 2.50, 10));
        stock.add(new Candy("Twixes", "fruity", 200, 2.50, 10));
        stock.add(new Candy("GummiWorms", "gummy", 200, 2.50, 10));
        stock.add(new Candy("ButterFingers", "Chocolate", 200, 2.50, 10));
        stock.add(new Candy("StarBursts", "fruity", 200, 2.50, 10));
        
        int counter = 0;
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                candy[i][j][0] = stock.get(counter);
                labels[counter] = stock.get(counter).getName();
                counter++;
            }
        }
    }
    
    public boolean isEmpty(Candy candy) {
        if(candy.getAmount() >= 0) {
            return false;
        } else {
            System.out.println("Apparently this Vending Machine ran out " + candy.getName() + ".");
            return true;
        }
    }
    
    public void printOptions() {
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                System.out.print(candy[i][j][0].getName() + "  ");
            }
            System.out.println("");
        }
    }
    
    public void Select(String[] coordinates) {
        String alphabet[] = {"a", "b", "c"};
        String Numbers[] = {"1", "2", "3"};
        int tempRow = 0, tempCol = 0;
        
        /*first string before the comma*/
        for(int i = 0; i < 3; i++) {
            if(coordinates[0].equalsIgnoreCase(alphabet[i])) {
                tempRow = i;
            } else if(coordinates[0].equalsIgnoreCase(Numbers[i])) {
                tempRow = i;
            }
        }
        
        /*second string after the comma*/
        for(int i = 0; i < 3; i++) {
            if(coordinates[1].equalsIgnoreCase(alphabet[i])) {
                tempRow = i;
            } else if(coordinates[1].equalsIgnoreCase(Numbers[i])) {
                tempRow = i;
            }
        }
        
        if(!isEmpty(candy[tempRow][tempCol][0])) {
            Remove(candy[tempRow][tempCol][0]);
        } 
    }
    
    public void Remove(Candy candy) {
        candy.setAmount(candy.getAmount()-1);
        System.out.println("You grabbed your " + candy.getName() + ".");
        System.out.println("There are now " + candy.getAmount() + " left.");
        System.out.println("You look at the nutrional information and it read...");
        info(candy);
    }
    
    /*This will only run after we identify whether there's still that specific candy left*/
    public void info(Candy candy) {
        System.out.println("_______________________________________");
        System.out.println("Candy Name: " + candy.getName());
        System.out.println("Candy Type: " + candy.getType());
        System.out.println("Calories: " + candy.getCalories());
        System.out.println("Price: $" + candy.getPrice());
        System.out.println("_______________________________________");
    }    
}