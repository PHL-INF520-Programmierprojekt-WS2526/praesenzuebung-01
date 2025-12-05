package de.phl.programmingproject.ects;

import de.phl.programmingproject.TestUtils;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;

public class ECTSCalculatorTest extends TestUtils {

    @Test
    void task_1_ects_calculator_exists() {
        TestUtils.getClassForName("ECTSCalculator", "de.phl.programmingproject.ects");
    }

    @Test
    void task_2_main_method_exists() {
        Class<?> clazz = TestUtils.getClassForName("ECTSCalculator", "de.phl.programmingproject.ects");
        TestUtils.assertClassHasMethod(clazz, "main", void.class, String[].class);
    }

    @Test
    void task_3_local_variable_named_ectsPoints_exists() {
        TestUtils.assertFileContentMatchesRegex(
                "/main/java/de/phl/programmingproject/ects/ECTSCalculator.java", ".*int\\s+ectsPoints\\s*=.*6.*",
                "The class 'ECTSCalculator' must contain a local variable named 'ectsPoints' with value set to 6 in the 'main' method.");
     }

    @Test
    void task_4_local_variable_named_hoursPerEcts_exists() {
        TestUtils.assertFileContentMatchesRegex(
                "/main/java/de/phl/programmingproject/ects/ECTSCalculator.java", ".*int\\s+hoursPerEcts\\s*=.*30.*",
                "The class 'ECTSCalculator' must contain a local variable named 'hoursPerEcts' with value set to 30 in the 'main' method.");
     }

     @Test
     void task_5_local_variable_named_totalHours_exists() {
        TestUtils.assertFileContentMatchesRegex(
                "/main/java/de/phl/programmingproject/ects/ECTSCalculator.java", ".*int\\s+totalHours\\s*=.*ectsPoints\\s*\\*\\s*hoursPerEcts.*",
                "The class 'ECTSCalculator' must contain a local variable named 'totalHours' that calculates the total hours by multiplying 'ectsPoints' and 'hoursPerEcts' in the 'main' method.");
     }

    @Test
    void task_6_correct_value_is_printed_to_console() {
        Method mainMethod = TestUtils.getMethod(TestUtils.getClassForName("ECTSCalculator", "de.phl.programmingproject.ects"), "main", String[].class);
        String out = runActionAndGetSystemOut(() -> {
            try {
                mainMethod.invoke(null, (Object) new String[0]);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            }
        });

        Pattern p = Pattern.compile(".*(total hours:.*|Gesamtarbeitsstunden:.*)", Pattern.CASE_INSENSITIVE);
        assertTrue(p.matcher(out).find(),
                "The output must contain the total hours value in either form \"total hours:\" or \"Gesamstunden:\".");

        assertTrue(out.contains("180"),
                "The output must contain the correct total hours value of 150 for 6 ECTS at 30 hours each.");
    }



}



