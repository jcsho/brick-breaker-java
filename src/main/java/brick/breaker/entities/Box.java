package brick.breaker.entities;

import brick.breaker.interfaces.BoundingBox;
import processing.core.PVector;

public abstract class Box<T extends Shape<T>> extends Shape<T> implements BoundingBox {

  protected PVector halfSize;

  public Box() {
    super();
  }

  @Override
  public T setSize(PVector newSize) {
    super.setSize(newSize);
    this.halfSize = new PVector(this.size.x / 2, this.size.y / 2);
    return subclass;
  }

  @Override
  public PVector getMin() {
    return PVector.sub(this.position, this.halfSize);
  }

  @Override
  public PVector getMax() {
    return PVector.add(this.position, this.halfSize);
  }

}
