package brick.breaker.unit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.closeTo;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertAll;

import brick.breaker.components.vectors.PVector;
import brick.breaker.interfaces.Vector;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class PVectorTest {

  private static final double ROUNDING_ERROR = 0.0001;
  private Vector v1;
  private Vector v2;

  @BeforeEach
  protected void setup() {
    v1 = new PVector();
    v2 = new PVector();
    assertThat(v1, is(instanceOf(Vector.class)));
    assertThat(v2, is(instanceOf(Vector.class)));
  }

  /**
   * Create test data for common vector operations.
   * Order of arguments = v1.x, v1.y, v2.x, v2.y,
   * linear interpolation amount (float between 0 and 1)
   *
   * @return arguments for parameterized tests
   */
  protected static Stream<Arguments> provideValuesForVectorOperations() {
    return Stream.of(
      Arguments.of(1f, 1f, 2f, 2f, 0.3f),
      Arguments.of(5000f, 4000f, 22f, 500f, 0.5f),
      Arguments.of(-2412f, -908734f, -4398f, -329890f, 0.73f)
    );
  }

  @DisplayName("Test Vector Addition")
  @ParameterizedTest(name = "Vector({0}, {1}) + Vector({2}, {3})")
  @MethodSource("provideValuesForVectorOperations")
  protected void testVectorAddition(ArgumentsAccessor arguments) {
    this.v1.set(arguments.getFloat(0), arguments.getFloat(1));
    this.v2.set(arguments.getFloat(2), arguments.getFloat(3));
    v1.add(v2);

    float expectedResultX = arguments.getFloat(0) + arguments.getFloat(2);
    float expectedResultY = arguments.getFloat(1) + arguments.getFloat(3);

    assertAll("Resulting Vector",
        () -> assertThat(String.format("X value should be %f", expectedResultX),
            (double) v1.getX(), is(closeTo(expectedResultX, ROUNDING_ERROR))),
        () -> assertThat(String.format("Y value should be %f", expectedResultY),
            (double) v1.getY(), is(closeTo(expectedResultY, ROUNDING_ERROR)))
    );
  }

  @DisplayName("Test Vector Subtraction")
  @ParameterizedTest(name = "Vector({0}, {1}) - Vector({2}, {3})")
  @MethodSource("provideValuesForVectorOperations")
  protected void testVectorSubtraction(ArgumentsAccessor arguments) {
    this.v1.set(arguments.getFloat(0), arguments.getFloat(1));
    this.v2.set(arguments.getFloat(2), arguments.getFloat(3));
    v1.sub(v2);

    float expectedResultX = arguments.getFloat(0) - arguments.getFloat(2);
    float expectedResultY = arguments.getFloat(1) - arguments.getFloat(3);

    assertAll("Resulting Vector",
        () -> assertThat(String.format("X value should be %f", expectedResultX),
            (double) v1.getX(), is(closeTo(expectedResultX, ROUNDING_ERROR))),
        () -> assertThat(String.format("Y value should be %f", expectedResultY),
            (double) v1.getY(), is(closeTo(expectedResultY, ROUNDING_ERROR)))
    );
  }

  @DisplayName("Test Vector Multiplication")
  @ParameterizedTest(name = "Vector({0}, {1}) * {2}")
  @MethodSource("provideValuesForVectorOperations")
  protected void testVectorMultiplication(ArgumentsAccessor arguments) {
    this.v1.set(arguments.getFloat(0), arguments.getFloat(1));
    v1.multiply(arguments.getFloat(2));

    float expectedResultX = arguments.getFloat(0) * arguments.getFloat(2);
    float expectedResultY = arguments.getFloat(1) * arguments.getFloat(2);

    assertAll("Resulting Vector",
        () -> assertThat(String.format("X value should be %f", expectedResultX),
            (double) v1.getX(), is(closeTo(expectedResultX, ROUNDING_ERROR))),
        () -> assertThat(String.format("Y value should be %f", expectedResultY),
            (double) v1.getY(), is(closeTo(expectedResultY, ROUNDING_ERROR)))
    );
  }

  @DisplayName("Test Vector Magnitude")
  @ParameterizedTest(name = "Vector({0}, {1}).mag()")
  @MethodSource("provideValuesForVectorOperations")
  protected void testVectorMagnitude(ArgumentsAccessor arguments) {
    this.v1.set(arguments.getFloat(0), arguments.getFloat(1));
    float result = this.v1.mag();

    float expectedResult = (float) Math.sqrt(
        arguments.getFloat(0) * arguments.getFloat(0)
        + arguments.getFloat(1) * arguments.getFloat(1)
    );

    assertThat(String.format("Resulting magnitude should be %f", expectedResult),
        (double) result, is(closeTo(expectedResult, ROUNDING_ERROR)));
  }

  @DisplayName("Test Vector Squared Magnitude")
  @ParameterizedTest(name = "Vector({0}, {1}).magSq()")
  @MethodSource("provideValuesForVectorOperations")
  protected void testVectorSquaredMagnitude(ArgumentsAccessor arguments) {
    this.v1.set(arguments.getFloat(0), arguments.getFloat(1));
    float result = this.v1.magSq();

    float expectedResult = arguments.getFloat(0) * arguments.getFloat(0)
        + arguments.getFloat(1) * arguments.getFloat(1);

    assertThat(String.format("Resulting squared magnitude should be %f", expectedResult),
        (double) result, is(closeTo(expectedResult, ROUNDING_ERROR)));
  }

  @DisplayName("Test Vector Normalize")
  @ParameterizedTest(name = "Vector({0}, {1}).normalize()")
  @MethodSource("provideValuesForVectorOperations")
  protected void testVectorNormalize(ArgumentsAccessor arguments) {
    this.v1.set(arguments.getFloat(0), arguments.getFloat(1));
    this.v1.normalize();

    float expectedResultX = this.v1.getX() / this.v1.mag();
    float expectedResultY = this.v1.getY() / this.v1.mag();

    assertAll("Resulting Vector",
        () -> assertThat(String.format("X value should be %f", expectedResultX),
            (double) v1.getX(), is(closeTo(expectedResultX, ROUNDING_ERROR))),
        () -> assertThat(String.format("Y value should be %f", expectedResultY),
            (double) v1.getY(), is(closeTo(expectedResultY, ROUNDING_ERROR)))
    );
  }

  @DisplayName("Test Vector Linear Interpolation")
  @ParameterizedTest(name = "Vector({0}, {1}).lerp(Vector({2}, {3}), {4})")
  @MethodSource("provideValuesForVectorOperations")
  protected void testVectorLinearInterpolation(ArgumentsAccessor arguments) {
    this.v1.set(arguments.getFloat(0), arguments.getFloat(1));
    this.v2.set(arguments.getFloat(2), arguments.getFloat(3));
    this.v1.lerp(v2, arguments.getFloat(4));

    float expectedResultX = arguments.getFloat(0)
        + (arguments.getFloat(2) - arguments.getFloat(0))
        * arguments.getFloat(4);
    float expectedResultY = arguments.getFloat(1)
        + (arguments.getFloat(3) - arguments.getFloat(1))
        * arguments.getFloat(4);

    assertAll("Resulting Vector",
        () -> assertThat(String.format("X value should be %f", expectedResultX),
            (double) v1.getX(), is(closeTo(expectedResultX, ROUNDING_ERROR))),
        () -> assertThat(String.format("Y value should be %f", expectedResultY),
            (double) v1.getY(), is(closeTo(expectedResultY, ROUNDING_ERROR)))
    );
  }
}
