package brick.breaker.components.movement;

import brick.breaker.interfaces.Movement;
import brick.breaker.interfaces.Vector;
import lombok.NonNull;

public class PaddleMovement implements Movement {

  private final Vector velocity;
  private float moveSpeed = 0.6f;

  public PaddleMovement(@NonNull Vector velocity) {
    this.velocity = velocity;
  }

  @Override
  public void changeDirection(boolean flipHorizontal, boolean flipVertical) {
    // Does nothing
  }

  @Override
  public void setMoveSpeed(float limit) throws IllegalArgumentException {
    if (limit <= 0 || limit > 100) {
      throw new IllegalArgumentException("Limit must be between 0 and 100");
    }

    this.moveSpeed = limit / 100;
  }

  @Override
  public void setTargetPosition(Vector position, Vector target) {
    this.velocity.set(target.getX(), position.getY());
  }

  @Override
  public void update(Vector position) {
    position.lerp(this.velocity, moveSpeed);
  }
}
