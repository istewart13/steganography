import javax.imageio.*;
import java.awt.image.BufferedImage;
import java.io.*;

public class RetrieveMessage {
  int imageWidth;
  int imageHeight;

  public int[][] loadPicture(String filename) {
    BufferedImage img = null;
    try {
      img = ImageIO.read(new File(filename));
      int imageWidth = img.getWidth();
      int imageHeight = img.getHeight();
      int[][] imgPixels = new int[imageHeight][imageWidth];
      for (int row = 0; row < imageHeight; row++) {
        for (int col = 0; col < imageWidth; col++) {
          imgPixels[row][col] = img.getRGB(col, row) & 0xFFFFFF; // keep the 24 least-significant bits
        }
      }
      return imgPixels;
    } 
    catch (IOException e) {
      System.err.println(e);
      return new int[0][0];
    }
  }

  public String[] convertToBinary(int[][] imageInPixels) {
    String[] messageInBinary = new String[(imageWidth * imageHeight) / 7]; // array of binary strings
    int lengthCounter = 0;
    int characterCount = 0;
    String currentCharacter = "";

    for (int row = 0; row < imageHeight; row++) {
      for (int col = 0; col < imageWidth; col++) {
        String pixelValue = Integer.toBinaryString(imageInPixels[row][col]);
        String lastDigit = pixelValue.substring(pixelValue.length() - 1);
        // System.out.println(lastDigit + "+++++++++");
        String reverseLastDigit = (lastDigit == "1") ? "0" : "1";
        if (lengthCounter % 7 == 0) {
          // System.out.println(currentCharacter + "--------");
          messageInBinary[characterCount] = currentCharacter;
          currentCharacter = "";
          characterCount++;
        }
        lengthCounter++;
      }
    }
    return messageInBinary;
  }
}