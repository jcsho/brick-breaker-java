package brick.breaker.interfaces;

/**
 * 2 dimensional vector representation and operations.
 */
public interface Vector {

  /**
   * Get the x component of the vector.
   *
   * @return x (horizontal) component of vector
   */
  float getX();

  /**
   * Get the y component of the vector.
   *
   * @return y (vertical) component of vector
   */
  float getY();

  /**
   * Set the x and y component of the vector.
   *
   * @param x the horizontal component of the vector
   * @param y the vertical component of the vector
   * @return vector after components are changed
   */
  Vector set(float x, float y);

  /**
   * Clone this vector as a new object.
   *
   * @return new vector with the same (x,y) values
   */
  Vector copy();

  /**
   * Add vector v to this vector.
   *
   * @param v vector to add
   * @return vector after addition
   */
  Vector add(Vector v);

  /**
   * Subtract vector v from this vector.
   *
   * @param v vector to subtract with
   * @return vector after subtraction
   */
  Vector sub(Vector v);

  /**
   * Multiple this vector by a scalar.
   *
   * @param num number to multiply with
   * @return vector after multiplication
   */
  Vector multiply(float num);

  /**
   * Calculate the magnitude of the vector.
   * Equation: <em>sqrt(x*x + y*y)</em>
   *
   * @return magnitude (length) of vector
   * @see Vector#magSq()
   */
  float mag();

  /**
   * Calculate the squared magnitude of the vector.
   * Equation: <em>(x*x + y*y)</em>
   *
   * @return squared magnitude of vector
   * @see Vector#mag()
   */
  float magSq();

  /**
   * Transform vector length to 1 (unit vector).
   *
   * @return normalized vector with length of 1
   */
  Vector normalize();

  /**
   * Linear interpolate the vector to another vector.
   *
   * @param v the vector to interpolate to
   * @param amt the amount of interpolation; 0.0 (original vector) 1.0 (param v)
   * @return vector after interpolation
   */
  Vector lerp(Vector v, float amt);
}
