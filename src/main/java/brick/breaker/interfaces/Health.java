package brick.breaker.interfaces;

public interface Health {

  int getHealth();

  void setMaxHealth(int amount) throws IllegalArgumentException;

  void damage(int amount);

}
