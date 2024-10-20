import org.example.Main;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTest {

    private Main numeros;

    @BeforeEach
    public void setup() {
        numeros = new Main();
    }

    private static Stream<Integer> primeNumbers() {
        return Stream.of(3, 23, 311, 487, 653, 947);
    }

    private static Stream<Integer> evenNumbers() {
        return Stream.of(32, 64, 2, 20, 30, 26);
    }

    private static Stream<Integer> multiplesOf23() {
        return Stream.of(23, 46, 115, 184, 207, 230);
    }

    @ParameterizedTest
    @MethodSource("primeNumbers")
    public void testIsPrime(int number) {
        assertTrue(numeros.isPrime(number), number + " deveria ser primo");
    }

    @ParameterizedTest
    @MethodSource("evenNumbers")
    public void testIsEven(int number) {
        assertTrue(numeros.isEven(number), number + " deveria ser par");
    }

    @ParameterizedTest
    @MethodSource("multiplesOf23")
    public void testIsMultiple(int number) {
        assertTrue(numeros.isMultiple(number, 23), number + " deveria ser múltiplo de 23");
    }

    @ParameterizedTest
    @MethodSource("otherValues")
    public void testIsMultipleWithOtherValues(int number, int divisor) {
        assertTrue(numeros.isMultiple(number, divisor), number + " deveria ser múltiplo de " + divisor);
    }

    private static Stream<Arguments> otherValues() {
        return Stream.of(
                Arguments.of(25, 5),
                Arguments.of(100, 10),
                Arguments.of(49, 7),
                Arguments.of(36, 6),
                Arguments.of(81, 9),
                Arguments.of(144, 12)
        );
    }
}