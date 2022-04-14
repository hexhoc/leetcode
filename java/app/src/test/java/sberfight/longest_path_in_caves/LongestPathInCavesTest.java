package sberfight.longest_path_in_caves;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.*;

public class LongestPathInCavesTest {
    @Test
    public void check() {
        assertEquals(7, LongestPathInCaves.execute(new int[]{-1, 0, 0, 1, 2, 3, 4, 5}));
        assertEquals(10, LongestPathInCaves.execute(new int[]{-1, 0, 0, 1, 2, 3, 4, 5, 7, 7, 8}));
    }
}
