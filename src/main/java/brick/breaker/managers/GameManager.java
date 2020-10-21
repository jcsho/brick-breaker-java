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
  private static PVector initialBallPosition;
  private static PVector initialPaddlePosition;
  private static PVector ballSize;
  private static PVector input;
  private static PVector paddleSize;
  private static PVector gameSizeMin;
  private static PVector gameSizeMax;

  private static final int BALL_RADIUS = 50;
  private static final int PADDLE_WIDTH = 100;
  private static final int PADDLE_HEIGHT = 20;

  /**
   * Single purpose function to instantiate all game objects.
   *
   * @param sketch processing instance
   */
  public void setup(PApplet sketch, PVector minSize, PVector maxSize) {
    gameSizeMin = minSize;
    gameSizeMax = maxSize;

    input = new PVector(0, 0);

    initialBallPosition = new PVector(sketch.width / 2, sketch.height / 2);
    initialPaddlePosition = new PVector(sketch.width / 2, 5 * sketch.height / 6);

    ballSize = new PVector(BALL_RADIUS, BALL_RADIUS);
    paddleSize = new PVector(PADDLE_WIDTH, PADDLE_HEIGHT);

    ball = new Ball().setPosition(initialBallPosition).setSize(ballSize);
    paddle = new Paddle().setPosition(initialPaddlePosition).setSize(paddleSize);
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
    System.out.println(input.x);
    System.out.println(paddle.getMin().x);
    input.x = PApplet.constrain(
        sketch.mouseX,
        gameSizeMin.x + paddle.getSize().x / 2,
        gameSizeMax.x - paddle.getSize().x / 2
        );
    paddle.update(input);

    if (ball.isColliding(paddle)) {
      sketch.fill(255, 0, 0);
    } else {
      sketch.fill(255);
    }
  }

}
