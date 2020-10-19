package brick.breaker.entities;

import brick.breaker.IHealth;
import processing.core.PApplet;

public class Brick extends Shape<Brick> implements IHealth {

  private int health;

  public Brick() {
    super();
    subclass = this;
  }

  @Override
  public void render(PApplet sketch) {
    sketch.rect(this.position.x, this.position.y, this.size.x, this.size.y);
  }

  @Override
  public int getHealth() {
    return health;
  }

  @Override
  public void setMaxHealth(int amount) throws IllegalArgumentException {
    if (amount <= 0) {
      throw new IllegalArgumentException("Amount has to be greater than 0");
    }

    this.health = amount;
  }

  @Override
  public void damage(int amount) {
    int damageToHealth = Math.abs(amount);
    health -= damageToHealth;
    if (health < 0) {
      health = 0;
    }
  }

}
