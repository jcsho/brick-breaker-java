package brick.breaker.interfaces;

import brick.breaker.entities.Box;

public interface Collision {

  <T extends Box<T>> boolean isColliding(T object);

  <T extends Box<T>> void onCollision(T object);

}
