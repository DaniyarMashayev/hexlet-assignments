package exercise;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

// BEGIN
class AppTest {
    @Test
    void testAppExample() {
        String[][] image = {
                {"*", "*", "*", "*"},
                {"*", " ", " ", "*"},
                {"*", " ", " ", "*"},
                {"*", "*", "*", "*"},
        };
        String[][] enlargedImage = {
                {"*", "*", "*", "*", "*", "*", "*", "*"},
                {"*", "*", "*", "*", "*", "*", "*", "*"},
                {"*", "*", " ", " ", " ", " ", "*", "*"},
                {"*", "*", " ", " ", " ", " ", "*", "*"},
                {"*", "*", " ", " ", " ", " ", "*", "*"},
                {"*", "*", " ", " ", " ", " ", "*", "*"},
                {"*", "*", "*", "*", "*", "*", "*", "*"},
                {"*", "*", "*", "*", "*", "*", "*", "*"},
        };
        String[][] enlargedActual = App.enlargeArrayImage(image);
        assertThat(enlargedActual).isEqualTo(enlargedImage);
    }
}
// END
