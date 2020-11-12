package brick.breaker.managers;

import brick.breaker.components.collisions.CircleAndRect;
import brick.breaker.components.movement.BallMovement;
import brick.breaker.components.movement.PaddleMovement;
import brick.breaker.components.renderers.PCircleRenderer;
import brick.breaker.components.renderers.PRectRenderer;
import brick.breaker.components.vectors.PVector;
import brick.breaker.entities.Shape;
import brick.breaker.interfaces.Vector;
import processing.core.PApplet;

/**
 * Manages Games State and Holds All Game Objects.
 */
public class GameManager {

  private static GameManager instance = null;
  private static final int BALL_RADIUS = 50;
  private static final int PADDLE_WIDTH = 100;
  private static final int PADDLE_HEIGHT = 20;
  private Vector minGameSize;
  private Vector maxGameSize;
  private Vector mouseInput;
  private Shape ball;
  private Shape paddle;

  /**
   * Disable constructor for singleton instance.
   */
  private GameManager() {
    mouseInput = new PVector();
  }

  /**
   * Singleton getter and creation method.
   *
   * @return instance of {@link GameManager}
   */
  public static GameManager getInstance() {
    if (instance == null) {
      instance = new GameManager();
    }
    return instance;
  }

  public void setSize(Vector min, Vector max) {
    this.minGameSize = min;
    this.maxGameSize = max;
  }

  /**
   * Single purpose function to instantiate all game objects.
   *
   * @param sketch processing instance
   */
  public void setup(PApplet sketch) {
    ball = Shape.builder()
        .collision(new CircleAndRect(new PVector()))
        .movement(new BallMovement(new PVector()))
        .renderer(new PCircleRenderer(sketch))
        .position(new PVector().set((float) sketch.width / 2, (float) sketch.height / 2))
        .size(new PVector().set(BALL_RADIUS, BALL_RADIUS))
        .build();
    ball.setTargetPosition(new PVector().set((float) sketch.width / 2, maxGameSize.getY()));

    paddle = Shape.builder()
        .collision(null)
        .movement(new PaddleMovement(new PVector()))
        .renderer(new PRectRenderer(sketch))
        .position(new PVector().set((float) sketch.width / 2, 3 * maxGameSize.getY() / 4))
        .size(new PVector().set(PADDLE_WIDTH, PADDLE_HEIGHT))
        .build();
  }

  /**
   * Combines all UI functionality to draw on {@link PApplet}.
   *
   * @param sketch processing instance
   */
  public void render(PApplet sketch) {
    // main background
    sketch.fill(125);
    sketch.rect(sketch.width / 2, sketch.height / 2, sketch.width, sketch.height);
    // game window
    sketch.fill(255);
    sketch.rect(sketch.width / 2, sketch.height / 2,
        maxGameSize.getX() - minGameSize.getX(),
        maxGameSize.getY() - minGameSize.getY());

    ball.render();
    paddle.render();
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

    this.mouseInput.set(constrainMouseXToGameWindow(sketch.mouseX), sketch.mouseY);
    paddle.setTargetPosition(mouseInput);
    paddle.update();
    ball.update();
  }

  /**
   * Restrict horizontal mouse input to inner game window.
   *
   * @param mouseX horizontal mouse input
   * @return constrained value for mouse input
   */
  private float constrainMouseXToGameWindow(float mouseX) {
    return GameManager.constrain(mouseX,
      this.minGameSize.getX() + paddle.getSize().getX() / 2,
      this.maxGameSize.getX() - paddle.getSize().getX() / 2);
  }

  private static float constrain(float value, float min, float max) {
    return (value < min) ? min : (Math.min(value, max));
  }

}
