package brick.breaker.managers;

import processing.core.PApplet;
import processing.core.PVector;

/**
 * Manages Games State and Holds All Game Objects.
 */
public class GameManager {

  private static final int BALL_RADIUS = 50;
  private static final int PADDLE_WIDTH = 100;
  private static final int PADDLE_HEIGHT = 20;

  /**
   * Single purpose function to instantiate all game objects.
   *
   * @param sketch processing instance
   */
  public void setup(PApplet sketch, PVector minSize, PVector maxSize) {

  }

  /**
   * Combines all UI functionality to draw on {@link PApplet}.
   *
   * @param sketch processing instance
   */
  public void render(PApplet sketch) {
  }

  /**
   * Combines all physics based actions.
   * <p>
   * To be run on separate thread.
   * </p>
   *
   * @param sketch processing instance
   */
  public void update(PApplet sketch) {
  }

}
