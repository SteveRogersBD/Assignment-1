/**
 * @author Aniruddha Biswas Atanu
 * Banner ID- 001392555
 */

import java.util.Scanner;

public class InputClass {

    /**Method to get the input of an integer
     *
     * @param prompt the prompt chosen by the user
     * @param min minimum value of the input
     * @param max maximum value of the input
     * @return returns the int that was taken as an input
     */
    public int getIntValue(String prompt, int min, int max) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter " + prompt + ": "); //prompting the user
        int val = input.nextInt();                  //taking input

        //input validation
        while (val < min || val > max) {
            if (val < min) {
                System.out.println("Invalid value. Radius must be greater than " + min);
            } else if (val > max) {
                System.out.println("Invalid value. Radius must be less than " + max);
            }
            System.out.print("Enter " + prompt + ": ");
            val = input.nextInt();
        }
        return val;
    }

    /**Method to get the input of a float
     *
     * @param prompt the prompt chosen by the user
     * @param min minimum value of the input
     * @param max maximum value of the input
     * @return returns the float that was taken as an input
     */
    public float getFloatValue(String prompt, float min, float max) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter " + prompt + ": ");
        float val = input.nextFloat(); // Using float instead of double
        while (val < min || val > max) {
            if (val < min) {
                System.out.println("Invalid value. Value must be greater than " + min);
            } else if (val > max) {
                System.out.println("Invalid value. Value must be less than " + max);
            }
            System.out.print("Enter " + prompt + ": ");
            val = input.nextFloat();
        }
        return val;
    }


    //Method to check if a string contains restricted chars
    public boolean ifPresent(char c, String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c)
                return true;
        }
        return false;
    }

    /**Method to get the input of an integer
     *
     * @param prompt the prompt chosen by the user
     * @param min_len minimum length of the input
     * @param max_len maximum length of the input
     * @return returns the valid string that was taken as an input
     */
    public String getStringValue(String prompt, int min_len, int max_len) {
        Scanner input = new Scanner(System.in);
        String val;
        System.out.print("Enter " + prompt + ": ");
        val = input.nextLine();
        int len = val.length();
        while (len < min_len || len > max_len) {

            // Check both length and character validity
            if (len < min_len) {
                System.out.println("Invalid value. Minimum length must be " + min_len);
            } else if (len > max_len) {
                System.out.println("Invalid value. Maximum length must be less than " + max_len);
            }
            System.out.print("Enter " + prompt + ": ");
            val = input.nextLine();
            len = val.length();
        }
        return val;

    }

    /**Method to get the input of a string that contains restricted chars
     *
     * @param prompt the prompt chosen by the user
     * @param min_len minimum length of the input
     * @param max_len maximum length of the input
     * @return returns the valid string that was taken as an input
     */
    public String getStringValue(String prompt, int min_len, int max_len, String inval) {
        Scanner input = new Scanner(System.in);
        String val;
        int len;
        do {
            System.out.print("Enter " + prompt + ": ");
            val = input.nextLine();
            len = val.length();

            // Check for invalid characters
            String wrong = "";
            for (int i = 0; i < len; i++) {
                char c = val.charAt(i);
                if (ifPresent(c, inval)) {
                    wrong = wrong +c+',';
                }
            }

            if (!wrong.isEmpty()) {
                wrong = wrong.substring(0,wrong.length()-1);
                System.out.println("Invalid value, "+wrong+" are not allowed in the input.");
                continue; // Restart the loop if invalid characters found
            }

            // Check length validity
            if (len < min_len || len > max_len) {
                if (len < min_len) {
                    System.out.println("Invalid value. Minimum length must be more than " + min_len);
                } else if (len > max_len) {
                    System.out.println("Invalid value. Maximum length must be less than " + max_len);
                }
            } else {
                break; // Both length and character validation pass, exit loop
            }
        } while (true);

        return val;
    }




    // Main functio that instantiates the input class and calls the necessary methods to take input
    public static void main(String args[]) {
        InputClass input = new InputClass();
        int radius = input.getIntValue("Radius", 1, 1000);
        System.out.println("Valid radius: "+radius);

        float floatValue;
        floatValue = input.getFloatValue("Value", 0.1f, 1000.0f);
        System.out.println("Valid float value: "+floatValue);

        String str1;
        str1 = input.getStringValue("Name", 5, 10);
        System.out.println("Valid name: "+ str1);

        String str2;
        str2 = input.getStringValue("Name", 5, 10, "$^&-<>");
        System.out.println("Valid name: "+ str2);


    }
}
