package brick.breaker.components.vectors;

import brick.breaker.interfaces.Vector;
import lombok.NonNull;

/**
 * Adapter object for {@link Vector}.
 * Uses the Processing {@link processing.core.PVector} object.
 */
public class PVector implements Vector {
  private final processing.core.PVector vector;

  public PVector() {
    this.vector = new processing.core.PVector(0, 0);
  }

  @Override
  public float getX() {
    return this.vector.x;
  }

  @Override
  public float getY() {
    return this.vector.y;
  }

  @Override
  public Vector set(float x, float y) {
    this.vector.set(x, y);
    return this;
  }

  @Override
  public Vector copy() {
    Vector copy = new PVector();
    copy.set(this.getX(), this.getY());
    return copy;
  }

  @Override
  public Vector add(Vector v) {
    this.vector.add(v.getX(), v.getY());
    return this;
  }

  @Override
  public Vector sub(Vector v) {
    this.vector.sub(v.getX(), v.getY());
    return this;
  }

  @Override
  public Vector multiply(float num) {
    this.vector.mult(num);
    return this;
  }

  @Override
  public float mag() {
    return this.vector.mag();
  }

  @Override
  public float magSq() {
    return this.vector.magSq();
  }

  @Override
  public Vector normalize() {
    this.vector.normalize();
    return this;
  }

  @Override
  public Vector lerp(@NonNull Vector v, float amt) {
    this.vector.lerp(v.getX(), v.getY(), 0, amt);
    return this;
  }

}
