package brick.breaker;

import processing.core.PApplet;

public class Brick extends Shape<Brick> {

  public Brick() {
    super();
    subclass = this;
  }

  @Override
  public void render(PApplet sketch) {
    sketch.rect(this.position.x, this.position.y, this.size.x, this.size.y);
  }

}
