import javax.swing.*;

public class OnlineStore {

    /**
     * Method to validate a credit card number.
     * It prompts the user to input a credit card number, checks its length and validity,
     * and displays a message indicating whether the credit card number is valid or not.
     */
    public static void validateCreditCard() {
        // Prompt the user for a string input (credit card number)
        String userInput = JOptionPane.showInputDialog(null, "Enter a string:");
        int len = userInput.length();

        // If the length of the input is not 16, the credit card number is invalid
        if (len != 16) {
            JOptionPane.showMessageDialog(null, "The credit card number is invalid");
            return;
        }

        // Array to store the individual digits of the credit card number
        int[] creditNumber = new int[len];

        // Convert each character of the input string to an integer digit
        for (int i = 0; i < len; i++) {
            int digit = userInput.charAt(i) - '0';
            // If the character is not a digit, the credit card number is invalid
            if (digit < 0 || digit > 9) {
                JOptionPane.showMessageDialog(null, "The credit card number is invalid");
                return;
            } else {
                creditNumber[i] = digit;
            }
        }

        // Double every even-indexed digit and sum the digits of the resulting numbers
        for (int i = 0; i < len; i++) {
            if (i % 2 == 0) {
                creditNumber[i] *= 2;
                if (creditNumber[i] > 9) {
                    creditNumber[i] = creditNumber[i] / 10 + creditNumber[i] % 10;
                }
            }
        }

        // Calculate the sum of all digits in the credit card number
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += creditNumber[i];
        }

        // If the sum is not divisible by 10, the credit card number is invalid
        if (sum % 10 != 0) {
            JOptionPane.showMessageDialog(null, "The credit card number is invalid");
        } else {
            JOptionPane.showMessageDialog(null, "The credit card number is valid");
        }
    }

    public static void main(String args[]) {
        // Instantiate OnlineStore object and call validateCreditCard method
        OnlineStore input = new OnlineStore();
        input.validateCreditCard();
    }
}
