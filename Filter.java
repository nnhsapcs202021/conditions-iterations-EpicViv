import java.awt.Color;
import java.util.Scanner;

/**
 * Transforms a picture by applying a Shepard Fairey-inspired effect using a custom-selected color scheme.
 *
 * @author Vivek Ily
 * @version January 7, 2021
 */
public class Filter
{
    private static ColorManipulator manipulator;
    private static Picture picture;

    private static int min;
    private static int subrange1;
    private static int subrange2;
    private static int subrange3;
    private static int subrange4;

    /**
     * Constructor for the Filter class
     * @param newPicture the picture that is to be posterized.
     */
    public Filter(Picture newPicture){
        this.manipulator = new ColorManipulator( newPicture );
        this.picture = newPicture;
        this.min = 256;
        this.subrange4 = -1;
    }

    /**
     * Posterize the picture by applying a Shepard Fairey-inspired effect using a custom-selected color scheme.
     *
     */
    public static void posterize(){

        Scanner scan = new Scanner(System.in);

        Tools.print("Please specify a direct file path for the image including the file type: "); String filePath = scan.nextLine();
        Picture selfie = new Picture(filePath);

        int[] ind1 = new int[0];
        for(int i = 0; i < filePath.length(); i++){
            if(filePath.charAt(i) == '\\'){
                ind1 = Tools.add(ind1, i);
            }
        }

        int[] ind2 = new int[0]; int perInd = 0;
        for(int i = ind1[ind1.length - 1]; i < filePath.length(); i++){
            if(filePath.charAt(i) == '.'){
                perInd = i;
            }
        }

        String fileName = filePath.substring(ind1[ind1.length - 1] + 1, perInd);
        Tools.println("Retrieved File Name: " + fileName);

        Filter fairey = new Filter( selfie );

        Tools.print("Do you want to write a jpg image file for your posterized picture? (Enter 1 if yes, enter 2 if no): "); int flag = scan.nextInt();
        Tools.println("You have requested to write a jpg image file for your posterized picture.");

        Tools.println("Attempting to push original image to screen. This process may take a while."); selfie.explore(); Tools.println("Original image pushed to screen.");
        Tools.println("Image is being posterized. This process may take a while.");

        manipulator.grayscale();

        int width = Filter.picture.getWidth();
        int height = Filter.picture.getHeight();

        // determine smallest and largest grayscale values in the picture
        for( int y = 0; y < height; y++ )
        {
            for( int x = 0; x < width; x++ )
            {
                Pixel pixel = Filter.picture.getPixel( x, y );
                int intensity = pixel.getBlue();

                if(intensity < Filter.min){
                    Filter.min = intensity;
                }
                else if(intensity > Filter.subrange4){
                    Filter.subrange4 = intensity;
                }
            }
        }

        // divide the range between the smallest and largest into four equal subranges
        int range = Filter.subrange4 - Filter.min;
        int interval = range / 4;
        Filter.subrange1 = Filter.min + interval;
        Filter.subrange3 = Filter.subrange4 - interval;
        Filter.subrange2 = (Filter.subrange1 + Filter.subrange3) / 2;

        for( int y = 0; y < height; y++ )
        {
            for( int x = 0; x < width; x++ )
            {
                Pixel pixel = Filter.picture.getPixel( x, y );
                int red = pixel.getRed();

                if(red < Filter.subrange1){
                    pixel.setColor(Color.BLACK);
                }
                else if(red < Filter.subrange2){
                    pixel.setColor(Color.GRAY);
                }
                else if(red < Filter.subrange3){
                    pixel.setColor(new Color(255, 86, 1));
                }
                else if(red < Filter.subrange4){
                    pixel.setColor(Color.WHITE);
                }
            }
        }

        Tools.println("Image has been posterized.");
        Tools.println("Attempting to push posterized image to screen. This process may take a while."); selfie.explore(); Tools.println("Posterized image pushed to screen.");

        if(flag == 1) {
            String imageName = "C:\\Users\\Vivek\\Downloads\\" + fileName + "-Posterized.jpg";
            selfie.write(imageName);
            Tools.print("Your posterized image has been saved to your Downloads folder on your local computer with the following name: ");
            Tools.println(fileName + "-Posterized.jpg");
        }
    }

    public static void negate(){
        int width = Filter.picture.getWidth();
        int height = Filter.picture.getHeight();

        for( int y = 0; y < height; y++ )
        {
            for( int x = 0; x < width; x++ )
            {
                Pixel pixel = Filter.picture.getPixel( x, y );
                Color color = pixel.getColor();

                int negatedRed = 255 - color.getRed();
                int negatedBlue = 255 - color.getBlue();
                int negatedGreen = 255 - color.getGreen();

                Color negated = new Color( negatedRed, negatedBlue, negatedGreen );
                pixel.setColor( negated );
            }
        }
        Tools.println("Negative modification implemented.");
    }

    public static void maxBlue(){
        int width = Filter.picture.getWidth();
        int height = Filter.picture.getHeight();

        for( int y = 0; y < height; y++ )
        {
            for( int x = 0; x < width; x++ )
            {
                Pixel pixel = Filter.picture.getPixel( x, y );
                pixel.setBlue( 255 );
            }
        }
    }

    public static void maxRed(){
        int width = Filter.picture.getWidth();
        int height = Filter.picture.getHeight();

        for( int y = 0; y < height; y++ )
        {
            for( int x = 0; x < width; x++ )
            {
                Pixel pixel = Filter.picture.getPixel( x, y );
                pixel.setRed( 255 );
            }
        }
    }

    public static void maxGreen(){
        int width = Filter.picture.getWidth();
        int height = Filter.picture.getHeight();

        for( int y = 0; y < height; y++ )
        {
            for( int x = 0; x < width; x++ )
            {
                Pixel pixel = Filter.picture.getPixel( x, y );
                pixel.setGreen( 255 );
            }
        }
    }

    public static void grayscale(){
        int width = Filter.picture.getWidth();
        int height = Filter.picture.getHeight();

        for( int y = 0; y < height; y++ )
        {
            for( int x = 0; x < width; x++ )
            {
                Pixel pixel = Filter.picture.getPixel( x, y );
                int red = pixel.getRed(); int green = pixel.getGreen(); int blue = pixel.getBlue();
                int average = (red + green + blue)/3;

                pixel.setRed(average); pixel.setGreen(average); pixel.setBlue(average);
            }
        }
    }

    public static void main(String args[])
    {
        Scanner scan = new Scanner(System.in);

        Filter.posterize();
    }
}