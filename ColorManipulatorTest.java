import static org.junit.Assert.*; import org.junit.After; import org.junit.Before; import org.junit.Test;

/**
 * The test class MileageTrackerTest.
 *
 * @author Vivek Ily
 * @version January 7, 2021
 */

public class ColorManipulatorTest{

    /**
     * Default constructor for test class ColorManipulatorTest
     */
    public ColorManipulatorTest(){

    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp(){

    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown(){

    }

    @Test
    public void testGrayscale(){
        Picture picture= new Picture( "Selfie.jpg" );
        ColorManipulator manipulator = new ColorManipulator(picture);

        int x = (int)(Math.random()*(picture.getWidth() + 1));
        int y = (int)(Math.random()*(picture.getHeight() + 1));
        Pixel pixel = picture.getPixel( x, y );

        Tools.println("Pixel coordinates: (" + x + ", " + y + ")");
        Tools.println("Red: " + pixel.getRed() + "; Green: " + pixel.getGreen() + "; Blue: " + pixel.getBlue());

        manipulator.grayscale();

        int expected = (pixel.getBlue() + pixel.getGreen() + pixel.getRed())/3;
        int actualRed = pixel.getRed();
        int actualGreen = pixel.getGreen();
        int actualBlue = pixel.getBlue();

        assertEquals(expected, actualRed);
        assertEquals(expected, actualGreen);
        assertEquals(expected, actualBlue);


    }
}
