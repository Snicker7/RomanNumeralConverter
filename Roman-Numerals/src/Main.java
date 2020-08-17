import Numerals.InvalidInputError;
import Numerals.Translator;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        String input = new String();
        while(input != "EXIT") {
            try {
                System.out.println("Please enter the number or numeral to translate. Enter exit to exit");
                Scanner systemInput = new Scanner(System.in);
                input = systemInput.next().toUpperCase();
                if (input.equals("EXIT")) {
                    break;
                }

                String result = null;
                Translator translator = new Translator();
                if (Character.isAlphabetic(input.charAt(0))) {
                    result = translator.translateToNumber(input);
                } else {
                    result = translator.translateToNumeral(input);
                }
                System.out.println(result);
            }
            catch(InvalidInputError e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
