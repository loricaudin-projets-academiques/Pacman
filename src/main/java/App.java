import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

import java.io.File;
import java.io.IOException;

/**
 *
 */
public class App {



    private static final String ASCIICHARS = "`^”,:;Il!i~+_-?][}{1)(|\\/tfjrxnuvczXYUJCLQ0OZmwqpdbkhao*#MW&8%B@$";
    private static String imagePath = "src/main/resources/doggo.jpg";

    public static void main(String args[]) {

        BufferedImage bufferedImage = null;

        try {
            bufferedImage = ImageIO.read(new File(imagePath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        int h = bufferedImage.getHeight();
        int w = bufferedImage.getWidth();
        int[][] pixels = new int[h][w];
        for (int i = 0; i < w; ++i) {
            for (int j = 0; j < h; ++j) {
                pixels[j][i] = bufferedImage.getRGB(i, j);
            }
        }

        int r, g, b;
        int average;
        int[][] avg = new int[pixels.length][pixels[0].length];

        // Iterate through the 2D int array of pixels
        for (int i = 0; i < pixels.length; ++i) {
            for (int j = 0; j < pixels[0].length; ++j) {
                // Extract the red, green and blue values of the current pixel using bit shifting and bit masking
                r = (pixels[i][j] >> 16) & 0xff;
                g = (pixels[i][j] >> 8) & 0xff;
                b = (pixels[i][j]) & 0xff;
                // Calculate the average brightness of the current pixel
                average = (r + g + b) / 3;
                // Store the average brightness value in the brightness matrix
                avg[i][j] = average;
            }
        }

        char[][] asciiMatrix = new char[avg.length][];
        int rowCount = 0;
        int asciiIndex;
        // Iterate over each row of the brightness matrix
        for (int[] row : avg) {
            char[] asciiRow = new char[row.length];
            int cellCount = 0;
            // Iterate over each cell of the brightness matrix
            for (int cell : row) {
                asciiIndex = (int) ((ASCIICHARS.length() - 1) * (cell / 255.0));
                // Get the ASCII character from the string using the index
                asciiRow[cellCount] = ASCIICHARS.charAt(asciiIndex);
                cellCount++;
            }
            asciiMatrix[rowCount] = asciiRow;
            rowCount++;
        }
        // Method to print the ASCII art
        // Iterate over each row of the ASCII matrix
        for (int i = 0; i < asciiMatrix.length; i++) {
            // Iterate over each column of the ASCII matrix
            for (int j = 0; j < asciiMatrix[0].length; j++) {
                // Print the ASCII character
                System.out.print(asciiMatrix[i][j]);
            }
            // Move to the next line
            System.out.println();
        }

    }

}
