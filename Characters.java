/*
 * Decompiled with CFR 0_114
 */
package game;

public class Characters {
    String name;
    String race;
    String group;
    private int playerHealth;
    private int playerDamage;
    private int healthPotHealAmount;
    String[] races = new String[]{"Human", "Dwarf",};
    String[] classes = new String[]{"Warrior", "Monk", "Rogue"};
    
    Inventory inv = new Inventory();

    public Characters(String n, int health, int dam) {
        name = n;
        playerHealth = health;
        playerDamage = dam;
        race = "";
        group = "";
        healthPotHealAmount = 25;
    }
    

    public void setName(String n) {
        name = n;
    }

    public String getName() {
        return name;
    }

    public void setHealth(int h) {
        playerHealth = h;
    }

    public int getHealth() {
        return playerHealth;
    }

    public void setDamage(int d) {
        playerDamage = d;
    }

    public int getDamage() {
        return playerDamage;
    }

    public void setRace(int type) {
        race = races[type];
    }

    public String getRace() {
        return race;
    }
    
    public void setClass(int type) {
    	group = classes[type];
    }
    
    public String getGroup()
    {
    	return group;
    }

    public void useHPot() {
        playerHealth += inv.getPotHeal();
    }
    
    public void useDPot(){
    	playerDamage += inv.getDPotAmount();
    }

}
