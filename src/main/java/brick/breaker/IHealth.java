package brick.breaker;

public interface IHealth {

  public int getHealth();

  public void setMaxHealth(int amount) throws IllegalArgumentException;

  public void damage(int amount);

}
