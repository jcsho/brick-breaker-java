package brick.breaker.interfaces;

public interface Movement {

  /**
   * Change velocity vector in horizontal or vertical axis.
   * If value is true, velocity vector will reverse in parameter axis.
   *
   * @param flipHorizontal invert horizontal velocity
   * @param flipVertical invert vertical velocity
   */
  void changeDirection(boolean flipHorizontal, boolean flipVertical);

  /**
   * Change movement speed.
   *
   * @param limit magnitude between 0 and 100
   * @throws IllegalArgumentException limit is outside of accepted bounds (0 - 100)
   */
  void setMoveSpeed(float limit) throws IllegalArgumentException;

  /**
   * Abstract setter for object movement target.
   *
   * @param position the target object should move towards
   */
  void setTargetPosition(Vector position, Vector target);

  /**
   * Physics movement update.
   */
  void update(Vector position);

}
