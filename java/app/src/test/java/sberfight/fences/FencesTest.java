package sberfight.fences;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FencesTest {
    @Test
    public void check() {
        Assertions.assertFalse(Fences.getResult(List.of(0, 2, 3, 3, 3)));
    }
}
