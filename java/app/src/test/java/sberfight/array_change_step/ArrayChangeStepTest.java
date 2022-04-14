package sberfight.array_change_step;

import org.junit.jupiter.api.Test;
import sberfight.array_change_step.ArrayChangeStep;
import static org.junit.jupiter.api.Assertions.*;

public class ArrayChangeStepTest {

    @Test
    public void check() {
       assertEquals(3, ArrayChangeStep.execute_map(new int[]{4,3,4,3,3,2,1}, new int[]{3,4,3,4,1,2,3}));
       assertEquals(4, ArrayChangeStep.execute_map(new int[]{4,3,4,3,2,3,1}, new int[]{3,4,3,4,1,2,3}));
       assertEquals(7, ArrayChangeStep.execute_map(new int[]{2,3,4,3,1,1,1,2,2,4}, new int[]{3,4,3,4,2,2,2,1,1,1}));
       assertEquals(6, ArrayChangeStep.execute_map(new int[]{4,3,4,3,2,3,1,9,7,8}, new int[]{3,4,3,4,1,2,3,7,8,9}));
       assertEquals(12, ArrayChangeStep.execute_map(
               new int[]{4,3,4,3,2,3,1,9,7,8,4,3,4,3,2,3,1,9,7,8},
               new int[]{3,4,3,4,1,2,3,7,8,9,3,4,3,4,1,2,3,7,8,9}));

        int[] arrayStart = new int[4_000_000];
        int[] arrayGoal = new int[4_000_000];
        for (int i = 0; i < arrayStart.length; i++) {
            arrayStart[i] = i;
            arrayGoal[(arrayGoal.length-1) - i] = i;
        }
        assertEquals(2_000_000, ArrayChangeStep.execute_map(arrayStart, arrayGoal));

    }
}
