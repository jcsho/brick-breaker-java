package brick.breaker;

import processing.core.PApplet;

public class Ball extends Shape<Ball> implements ICollision {

  /**
   * Default constructor to create a {@link Ball} object.
   */
  public Ball() {
    super();
    subclass = this;
  }

  /**
   * Draws {@link Ball} to screen.
   *
   * @param sketch main {@link PApplet} instance
   */
  public void render(PApplet sketch) {
    sketch.ellipse(this.position.x, this.position.y, this.size.x, this.size.y);
  }

  @Override
  public <T extends Shape<T>> boolean isColliding(T object) {
    float objectLeftEdge = object.getPosition().x - (object.getSize().x / 2);
    float objectRightEdge = object.getPosition().x + (object.getSize().x / 2);
    float objectTopEdge = object.getPosition().y - (object.getSize().y / 2);
    float objectBotEdge = object.getPosition().y + (object.getSize().y / 2);

    float testX = this.position.x;
    float testY = this.position.y;

    if (this.position.x < objectLeftEdge) {
      testX = objectLeftEdge;
    } else if (this.position.x > objectRightEdge) {
      testX = objectRightEdge;
    }

    if (this.position.y < objectTopEdge) {
      testY = objectTopEdge;
    } else if (this.position.y > objectBotEdge) {
      testY = objectBotEdge;
    }

    float deltaX = this.position.x - testX;
    float deltaY = this.position.y - testY;
    float distance = (float) Math.sqrt((deltaX * deltaX) + (deltaY * deltaY));

    return distance <= this.size.x / 2;
  }

  @Override
  public <T extends Shape<T>> void onCollision(T object) {
    // TODO Auto-generated method stub

  }
}
