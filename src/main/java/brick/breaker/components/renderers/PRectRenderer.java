package brick.breaker.components.renderers;

import brick.breaker.interfaces.Renderer;
import brick.breaker.interfaces.Vector;
import lombok.NonNull;
import processing.core.PApplet;

/**
 * Render square using {@link PApplet} graphics api.
 */
public class PRectRenderer implements Renderer {

  private static PApplet renderer;

  public PRectRenderer(@NonNull PApplet app) {
    renderer = app;
  }

  @Override
  public void render(Vector position, Vector size) {
    renderer.rect(position.getX(), position.getY(), size.getX(), size.getY());
  }
}
