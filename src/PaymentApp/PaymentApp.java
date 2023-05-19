package PaymentApp;

import java.util.Random;
import java.util.Scanner;

public class PaymentApp {
	public static void main(String[] args) {
        PaymentApp app = new PaymentApp();
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Payment Amount: ");
            double amount = scanner.nextDouble();

            System.out.print("Card Number: ");
            String cardNumber = scanner.next();

            System.out.print("Expiration Date (MM/YYYY): ");
            String expirationDate = scanner.next();

            System.out.print("Security Code: ");
            String securityCode = scanner.next();

            app.makePayment(amount, cardNumber, expirationDate, securityCode);
        } catch (InvalidAmountException | InvalidCardNumberException | SystemNotWorkingException | InvalidExpirationDateException | InvalidSecurityCodeException e) {
            System.out.println("Payment failed: " + e.getMessage());
        }
    }

    public void makePayment(double paymentAmount, String cardNumber, String expirationDate, String securityCode)
            throws InvalidAmountException, InvalidCardNumberException, SystemNotWorkingException, InvalidExpirationDateException, InvalidSecurityCodeException {
    
        if (paymentAmount <= 0 || paymentAmount % 1 != 0) {
            throw new InvalidAmountException("Invalid payment amount! Amount must be a positive integer value.");
        }

        if (cardNumber.length() != 16 || !cardNumber.matches("\\d+")) {
            throw new InvalidCardNumberException("Invalid card number. Card number must be a 16-digit numeric value.");
        }

        
        String[] dateParts = expirationDate.split("/");
        int month = Integer.parseInt(dateParts[0]);
        int year = Integer.parseInt(dateParts[1]);
        if (year < 2023 || month < 1 || month > 12) {
            throw new InvalidExpirationDateException("Invalid expiration date. Date must be in the format MM/YYYY and must not be in the past.");
        }

        if (securityCode.length() != 3 || !securityCode.matches("\\d+")) {
            throw new InvalidSecurityCodeException("Invalid security code. Security code must be a 3-digit numeric value.");
        }

        
        try {
            pay();
        } catch (SystemNotWorkingException e) {
           
            System.out.println("Payment failed due to a system error. Retrying payment.");
            pay();
        }
    }

    public void pay() throws SystemNotWorkingException {
        Random random = new Random();
        int randomNumber = random.nextInt(101);
        System.out.println("Random number: " + randomNumber);

        if (randomNumber > 75) {
            throw new SystemNotWorkingException("Payment system is currently not available. Please try again later.");
        } else {
            System.out.println("Payment successful!");
        }
    }
}