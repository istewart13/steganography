public class ASCII {

  public String[] encode (String message) {
    String[] encodedMessage = new String[message.length()];
    String binaryString = "";
    int counter = 0;
    if (message != null) {
      for (int i = 0; i < message.length(); i++) {
        char currentChar = message.charAt(i);
        int charValue = (int)currentChar;
        binaryString = Integer.toBinaryString(charValue);
        encodedMessage[counter] = binaryString;
        counter++;
      }
    }
    return encodedMessage;
  }

  public String decode (String[] binaryChars) {
      String decodedMessage = "";
      for (int i = 0; i < binaryChars.length; i++) {
        int charValue = Integer.parseInt(binaryChars[i], 2);
        char currentChar = (char)charValue;
        decodedMessage += currentChar;
      }
      return decodedMessage;
  }
}