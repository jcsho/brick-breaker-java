package brick.breaker.interfaces;

public interface Health {

  public int getHealth();

  public void setMaxHealth(int amount) throws IllegalArgumentException;

  public void damage(int amount);

}
