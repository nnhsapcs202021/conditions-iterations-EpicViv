import java.awt.Color;
import java.util.Scanner;

/**
 * Transforms a picture by applying a Shepard Fairey-inspired effect using a custom-selected color scheme.
 *
 * @author Vivek Ily
 * @version January 7, 2021
 */
public class ShepardFaireyGlobal
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

    public ShepardFaireyGlobal( Picture newPicture )
    {
        this.manipulator = new ColorManipulator( newPicture );
        this.picture = newPicture;
        this.min = 256;
        this.subrange4 = -1;
    }

    /**
     * Posterize the picture by applying a Shepard Fairey-inspired effect using a custom-selected color scheme.
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
                    pixel.setColor(Color.BLACK);
                }
                else if(red < this.subrange2){
                    pixel.setColor(Color.GRAY);
                }
                else if(red < this.subrange3){
                    pixel.setColor(new Color(255, 86, 1));
                }
                else if(red < this.subrange4){
                    pixel.setColor(Color.WHITE);
                }
            }
        }
    }

    public static void main(String args[])
    {
        Scanner scan = new Scanner(System.in);
        // create a new picture object based on the original selfie

        Tools.print("Please specify a direct file path for the image: "); String filePath = scan.nextLine();
        Picture selfie = new Picture(filePath);

        // create a ShepardFairey object to transform the selfie picture
        ShepardFaireyGlobal fairey = new ShepardFaireyGlobal( selfie );

        Tools.print("Do you want to write a jpg file for this picture? (Enter 1 if yes, enter 2 if no): "); int flag = scan.nextInt();
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
        if(flag == 1) {
            Tools.print("What do you want to name your image? Please include the file path at the beginning: "); String imageName = scan.nextLine();
            selfie.write(imageName);
        }
    }
}