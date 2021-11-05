
package game;

import game.Characters;
import game.Mobs;
import game.Inventory;

//import java.io.InputStream;
//import java.io.PrintStream;
import java.util.Random;
import java.util.Scanner;

public class Adventure {
    public static String name;

    public static void main(String[] args) {
        Random rand = new Random();
        Scanner in = new Scanner(System.in);
        Characters toon = new Characters("", 0, 0);
        Inventory inv = new Inventory();
        
        Mobs m1 = new Mobs();
        int healthPotDropChance = 50;
        String name = "";
        boolean enteredName = false;
        while (!enteredName) {
            System.out.println("Hello Adventurer!\nPlease enter a name for your character!");
            System.out.print("Name: ");
            name = in.nextLine();
            System.out.println("Your name is: " + name + "\n");
            enteredName = true;
        }
        boolean pickRace = false;
        while (!pickRace) {
            System.out.println("Pick a race for your character from the choices below.");
            System.out.println("\t1. Human");
            System.out.println("\t2. Dwarf \n");
            String input = in.nextLine();
            if (input.equals("1")) {
                toon.setRace(Integer.parseInt(input) - 1);
                System.out.println(name + " is now a " + toon.getRace() + "\n");
                pickRace = true;
                continue;
            }
            if (input.equals("2")) {
                toon.setRace(Integer.parseInt(input) - 1);
                System.out.println(name + " is now a " + toon.getRace() + "\n");
                pickRace = true;
                continue;
            }
            System.out.println("\tInvalid command!\n");
        }
        boolean pickClass = false;
        while (!pickClass) {
            System.out.println("Pick a class from the choices below.");
            System.out.println("\t1. Warrior");
            System.out.println("\t2. Monk");
            System.out.println("\t3. Rogue");
            String input = in.nextLine();
            
            if (input.equals("1")) {
                toon.setClass(Integer.parseInt(input) - 1);
                toon.setHealth(150);
                toon.setDamage(25);
                System.out.println(name + " is now a " + toon.getRace() + " " + toon.getGroup() + "\n");
                pickClass = true;
                continue;
            }
            
            if (input.equals("2")) {
            	toon.setClass(Integer.parseInt(input) - 1);
                toon.setHealth(100);
                toon.setDamage(35);
                System.out.println(name + " is now a " + toon.getRace() + " " + toon.getGroup() + "\n");
                pickClass = true;
                continue;
            }
            
            if (input.equals("3")){
            	toon.setClass(Integer.parseInt(input) - 1);
            	toon.setHealth(75);
            	toon.setDamage(50);
            	System.out.println(name + " is now a " + toon.getRace() + " " + toon.getGroup());
            	pickClass = true;
            }
            
        }
        System.out.println("\nEnter ANY KEY to begin your journey through the dungeon!");
        String answer = in.next();
        in.nextLine();
        
        if ("YES".contains(answer.toUpperCase())) {
            System.out.println("You have entered the dungeon!");
        }
        boolean running = true;
        gameRunning: 
        	while (running) {
            String input;
            System.out.println("----------------------------------------------------------");
           
            System.out.println("\t#  " + m1.getName() + " has appeared! #\n");
            while (m1.getHealth() > 0) {
                System.out.println("\tYour HP: " + toon.getHealth());
                System.out.println("\t" + m1.getName() + "'s HP: " + m1.getHealth());
                System.out.println("\n\tWhat would you like to do? \n");
                System.out.println("\t1. Attack");
                System.out.println("\t2. Inventory");
                System.out.println("\t\tA. Healing potions: " + inv.getHPotAmount());
                System.out.println("\t\tB. Damage potions: " + inv.getDPotAmount() + "\n");
                
                System.out.println("\t3. Run!");
                input = in.nextLine();
                if (input.equals("1")) {
                    int damageDealt = rand.nextInt(toon.getDamage());
                    int damageTaken = m1.getAD();
                    m1.setHealth(m1.getHealth() - damageDealt);
                    toon.setHealth(toon.getHealth() - damageTaken);
                    System.out.println("----------------------------------------------------------");
                    System.out.println("\t> You strike the " + m1.getName() + " for " + damageDealt + " damage.");
                    System.out.println("\t> You receive " + damageTaken + " damage in retaliation! \n");
                    if (toon.getHealth() >= 1) continue;
                    System.out.println("\t> You have taken too much damage. You cannot go any farther! \n");
                    break;
                }
                if (input.equals("a")) {
                    if (inv.getHPotAmount() > 0) {
                        toon.useHPot();
                        //inv.subtractHPot();
                        System.out.println("\t> You drink a health potion for " + inv.getPotHeal() + "." + "\n\t> You now have " + toon.getHealth() + " HP." + "\n\t> You now have " + inv.getHPotAmount() + " healing potion(s) left. \n");
                        continue;
                    }
                    
                   if(inv.getHPotAmount() == 0) 
                   	System.out.println("\t> You have no health potions left! Kill an enemy for a chance to receive one!");
                    continue;
                }
                /*if(input.equals("b")){
                	
                	if(inv.getDPotAmount() > 0){
                	toon.useDPot();
                	inv.subractDPotAmount();
                	System.out.println("\t> You drink a damage potion for " + inv.getDamAdd() + "bonus damage." + "\n\t> You now have " + toon.getDamage() + " total damage." + "\n\t> You now have " + inv.getDPotAmount() + " damage potion left. \n");
                	continue;
                	}
                	 if(inv.getDPotAmount() == 0) 
                        	System.out.println("\t> You have no damage potions left! Kill an enemy for a chance to receive one!\n");
                         continue;
                }*/
                if (input.equals("3")) {
                    System.out.println("\tYou run away from the " + m1.getName() + "!");
                    
                    continue gameRunning; 
                    

                }
                else
                {
                	System.out.println("\tInvalid command!\n");
                }
                
                System.out.println(toon.getDamage());
        	   }        	          	           	           	   
        	   
        	   if (toon.getHealth() < 1) {
                System.out.println("You limp out of the dungeon, weak from battle. \n");
                	break;                
            }
            
            System.out.println("----------------------------------------------------------");
            System.out.println(" # " + m1.getName() + " was defeated # ");
            System.out.println(" # You have " + toon.getHealth() + " HP left. ");
            if (rand.nextInt(100) > healthPotDropChance) {
                inv.addHPot();
                System.out.println(" # The " + m1.getName() + " has dropped a health potion for you! # ");
                System.out.println(" # You now have " + inv.getHPotAmount() + " health potion(s) to use!");
            }           
            System.out.println("----------------------------------------------------------");
            System.out.println("What would you like to do now? \n");
            System.out.println("1. Continue fighting");
            System.out.println("2. Exit Dungeon");
            input = in.nextLine();
            while (!(input.equals("1") || input.equals("2") || input.equals("82"))) {
                System.out.println("Invalid command");
                input = in.nextLine();
            
            if (input.equals("1")) {
                System.out.println("You continue");
               continue;
            }
            /*if (input.equals("82")) {
                toon.addPot();
                System.out.println("You now have " + toon.getPotAmount + " potions!"());
            }*/
            if (!input.equals("2"))
            System.out.println("You exit the dungeon, successful from your adventures!");
            break;
            }
        }
        System.out.println("#######################");
        System.out.println("# Thanks for Playing! #");
        System.out.println("#######################");
        }
    }

