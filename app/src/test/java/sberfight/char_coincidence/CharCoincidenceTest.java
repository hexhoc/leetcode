package sberfight.char_coincidence;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class CharCoincidenceTest {
    @Test
    public void check() {
        Assertions.assertEquals(3, CharCoincidence.getResult("dd_gd_gdd", 1, "gdd"));
        Assertions.assertEquals(3, CharCoincidence.getResult("agd__fgdd", 1, "gdd"));
        Assertions.assertEquals(3, CharCoincidence.getResult("agdd", 1, "gdd"));
        Assertions.assertEquals(1, CharCoincidence.getResult("agdd", 1, "gzmdd"));

    }
}
