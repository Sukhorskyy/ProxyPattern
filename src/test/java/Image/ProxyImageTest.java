package Image;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class ProxyImageTest {
    Image image;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    void testLoading() {
        image = new ProxyImage("test_image.jpg");
        image.display();    //we load image from disk
        image.display();    //we don't need to load it again from disk
        assertEquals("Loading test_image.jpg" +
                "Displaying test_image.jpg" +
                "Displaying test_image.jpg",
                outputStreamCaptor.toString().trim().replaceAll("\r", "").replaceAll("\n", ""));
    }
}