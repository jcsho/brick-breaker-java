package brick.breaker.components.renderers;

import brick.breaker.interfaces.Renderer;
import brick.breaker.interfaces.Vector;
import lombok.NonNull;
import processing.core.PApplet;

/**
 * Render circle using {@link PApplet} graphics api.
 */
public class PCircleRenderer implements Renderer {

  private static PApplet renderer;

  public PCircleRenderer(@NonNull PApplet app) {
    renderer = app;
  }

  @Override
  public void render(Vector position, Vector size) {
    PCircleRenderer.renderer.ellipse(position.getX(), position.getY(), size.getX(), size.getY());
  }
}
