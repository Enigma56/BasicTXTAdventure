/*
 * Decompiled with CFR 0_114.
 */
package game;

import java.util.Random;

public class Mobs {
	String[] enemies = new String[]{"Zombie", "Skeleton", "Faceless", "Orc", "Feral Wolf"};
	String name;
    String zombieName;
    String skeletonName;
    private int health;
    private int maxEnemyHealth = 76;
    private int enemyDamage = 26;
    Random rand = new Random();

    public Mobs() {
        name = enemies[rand.nextInt(enemies.length)];
        health = 1 + rand.nextInt(maxEnemyHealth);     
    }
    

  public void setHealth(int h) {
      health = h;
  }

  public int getHealth() {
      return health;
  }
  
    public int getAD() {
        return rand.nextInt(enemyDamage);
    }

    public String getName() {
        return name;
    }
}
