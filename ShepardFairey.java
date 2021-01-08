import java.awt.Color;

/**
 * Transforms a picture by applying a Shepard Fairey-inspired effect.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ShepardFairey
{
    private ColorManipulator manipulator;
    private Picture picture;

    private int min;
    private int subrange1;
    private int subrange2;
    private int subrange3;
    private int subrange4;

    private static final Color OFF_WHITE = new Color( 248, 229, 175 );
    private static final Color LIGHT_BLUE = new Color( 121, 149, 159 );
    private static final Color RED = new Color( 198, 50, 45 );
    private static final Color DARK_BLUE = new Color( 16, 48, 77 );

    public ShepardFairey( Picture newPicture )
    {
        this.manipulator = new ColorManipulator( newPicture );
        this.picture = newPicture;
        this.min = 256;
        this.subrange4 = -1;
    }

    /**
     * Posterize the picture by applying a Shepard Fairey-inspired effect.
     *
     */
    public void posterize(){
        manipulator.grayscale();

        int width = this.picture.getWidth();
        int height = this.picture.getHeight();

        // determine smallest and largest grayscale values in the picture
        for( int y = 0; y < height; y++ )
        {
            for( int x = 0; x < width; x++ )
            {
                Pixel pixel = this.picture.getPixel( x, y );
                int intensity = pixel.getBlue();

                if(intensity < this.min){
                    this.min = intensity;
                }
                else if(intensity > this.subrange4){
                    this.subrange4 = intensity;
                }
            }
        }

        // divide the range between the smallest and largest into four equal subranges
        int range = this.subrange4 - this.min;
        int interval = range / 4;
        this.subrange1 = this.min + interval;
        this.subrange3 = this.subrange4 - interval;
        this.subrange2 = (this.subrange1 + this.subrange3) / 2;

        for( int y = 0; y < height; y++ )
        {
            for( int x = 0; x < width; x++ )
            {
                Pixel pixel = this.picture.getPixel( x, y );
                int red = pixel.getRed();

                if(red < this.subrange1){
                    pixel.setColor(this.OFF_WHITE);
                }
                else if(red < this.subrange2){
                    pixel.setColor(this.DARK_BLUE);
                }
                else if(red < this.subrange3){
                    pixel.setColor(this.RED);
                }
                else if(red < this.subrange4){
                    pixel.setColor(this.LIGHT_BLUE);
                }
            }
        }
    }

    public static void main(String args[])
    {
        // create a new picture object based on the original selfie
        //  (the selfie image must be in the Shepard Fairey folder)
        Picture selfie = new Picture( "Selfie.jpg" );

        // create a ShepardFairey object to transform the selfie picture
        ShepardFairey fairey = new ShepardFairey( selfie );

        // display the original selfie picture
        selfie.explore();

        // posterize the selfie picture by applying a Shepard Fairey-inspired effect
        fairey.posterize();
        
        // display the posterized selfie picture
        selfie.explore();

        // save the transformed selfie picture
        
        /* This code doesn't work for some students for unknown reasons.
         * You may need to specify an absolute path. For example:
         *  finalPic.write("C:\\Users\\gschmit\\GitHub\\decisions-loops-gcschmit\\Shepard Fairey\\MrSchmitPortrait.jpg");
         */
        //selfie.write( "C:\\Users\\Vivek\\OneDrive\\Documents\\GitHub\\conditions-iterations-EpicViv\\SelfiePosterized.jpg" );
    }
}