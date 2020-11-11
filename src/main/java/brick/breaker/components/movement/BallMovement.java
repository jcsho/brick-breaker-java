package brick.breaker.components.movement;

import brick.breaker.interfaces.Movement;
import brick.breaker.interfaces.Vector;
import lombok.NonNull;

public class BallMovement implements Movement {

  private final Vector velocity;
  private float moveSpeed = 3;

  public BallMovement(@NonNull Vector velocity) {
    this.velocity = velocity;
  }

  @Override
  public void changeDirection(boolean flipHorizontal, boolean flipVertical) {
    if (flipHorizontal) {
      this.velocity.set(this.velocity.getX() * -1, this.velocity.getY());
    }

    if (flipVertical) {
      this.velocity.set(this.velocity.getX(), this.velocity.getY() * -1);
    }
  }

  @Override
  public void setMoveSpeed(float limit) throws IllegalArgumentException {
    if (limit <= 0 || limit > 100) {
      throw new IllegalArgumentException("Limit must be between 0 and 100");
    }

    this.moveSpeed = limit / 100;
  }

  @Override
  public void setTargetPosition(@NonNull Vector position, @NonNull Vector target) {
    this.velocity.set(target)
        .sub(position)
        .normalize()
        .multiply(1f + this.moveSpeed);
  }

  @Override
  public void update(@NonNull Vector position) {
    // TODO: add boundary detection and bounce on contact
    position.add(this.velocity);
  }
}
