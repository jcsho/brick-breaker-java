package brick.breaker.interfaces;

/**
 * Generic renderer for graphics adapters.
 */
public interface Renderer {
  /**
   * Render object to screen.
   *
   * @param position 2d coordinate to render object
   * @param size dimensions of object
   */
  void render(Vector position, Vector size);
}
