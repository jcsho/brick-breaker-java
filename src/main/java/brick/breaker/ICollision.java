package brick.breaker;

import brick.breaker.entities.Shape;

public interface ICollision {

  public <T extends Shape<T>> boolean isColliding(T object);

  public <T extends Shape<T>> void onCollision(T object);

}
