package brick.breaker.managers;

import brick.breaker.entities.Ball;
import brick.breaker.entities.Paddle;
import processing.core.PApplet;
import processing.core.PVector;

/**
 * Manages Games State and Holds All Game Objects.
 */
public class GameManager {

  private static Ball ball;
  private static Paddle paddle;
  private static PVector input;

  private static final int BALL_RADIUS = 50;
  private static final int PADDLE_WIDTH = 100;
  private static final int PADDLE_HEIGHT = 20;

  /**
   * Single purpose function to instantiate all game objects.
   *
   * @param sketch processing instance
   */
  public void setup(PApplet sketch, PVector minSize, PVector maxSize) {

    input = new PVector(0, 0);

    PVector initialBallPosition = new PVector(sketch.width / 2, sketch.height / 2);
    PVector initialBallTarget = new PVector(sketch.width / 2, sketch.height);
    PVector initialPaddlePosition = new PVector(sketch.width / 2, 5 * sketch.height / 6);

    PVector ballSize = new PVector(BALL_RADIUS, BALL_RADIUS);
    PVector paddleSize = new PVector(PADDLE_WIDTH, PADDLE_HEIGHT);

    ball = new Ball().setPosition(initialBallPosition).setSize(ballSize);
    ball.setTargetPosition(initialBallTarget);
    ball.setMovementBoundary(minSize, maxSize);
    paddle = new Paddle().setPosition(initialPaddlePosition).setSize(paddleSize);
    paddle.setMovementBoundary(minSize, maxSize);
  }

  /**
   * Combines all UI functionality to draw on {@link PApplet}.
   *
   * @param sketch processing instance
   */
  public void render(PApplet sketch) {
    ball.render(sketch);
    paddle.render(sketch);
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
    if (ball.isColliding(paddle)) {
      sketch.fill(255, 0, 0);
    } else {
      sketch.fill(255);
    }

    input.set(sketch.mouseX, sketch.mouseY);

    paddle.setTargetPosition(input);
    paddle.update();
    ball.update();
  }

}
