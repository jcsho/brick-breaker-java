package brick.breaker.unit;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import brick.breaker.components.renderers.PCircleRenderer;
import brick.breaker.interfaces.Renderer;
import brick.breaker.interfaces.Vector;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import processing.core.PApplet;

public class PCircleRendererTest {

  private PApplet app;
  private Renderer renderer;

  @BeforeEach
  protected void setup() {
    app = mock(PApplet.class);
    renderer = new PCircleRenderer(app);
  }

  @DisplayName("Test Circle Renderer Uses Processing Renderer")
  @Test
  protected void testRenderShape() {
    Vector position = mock(Vector.class);
    Vector size = mock(Vector.class);
    renderer.render(position, size);
    verify(app, times(1))
        .ellipse(position.getX(), position.getY(), size.getX(), size.getY());
  }
}
