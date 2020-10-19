package brick.breaker.interfaces;

import brick.breaker.entities.Box;

public interface Collision {

  public <T extends Box<T>> boolean isColliding(T object);

  public <T extends Box<T>> void onCollision(T object);

}
