# Payment Processing Application

This is a Java-based application that allows users to make payments using their credit card details. The application performs various validations and error handling to ensure secure and proper processing.

## Features

1. **Input Validation**:
   - **Amount**: Must be a positive integer. Decimal or negative values are not allowed.
   - **Card Number**: Must consist of 16 digits only.
   - **Expiration Date**: Must be in the format `MM/YYYY` and cannot be a past date or have an invalid month.
   - **Security Code**: Must be exactly 3 digits.

2. **Payment Processing**:
   - Implements a `pay` method to simulate the payment process.
   - Generates a random number between 0-100 during the process. If the number exceeds 75, a custom `SystemNotWorkingException` is thrown, and the process is retried once.

3. **Custom Exceptions**:
   - `InvalidAmountException`: Thrown for invalid payment amounts.
   - `InvalidCardNumberException`: Thrown for invalid card numbers.
   - `InvalidExpirationDateException`: Thrown for invalid or past expiration dates.
   - `InvalidSecurityCodeException`: Thrown for invalid security codes.
   - `SystemNotWorkingException`: Thrown during a system failure in the payment process.

## How It Works

1. **User Input**:
   - The application prompts the user to input the payment amount, card number, expiration date, and security code.

2. **Validation**:
   - Inputs are validated against the defined constraints.
   - If validation fails, a relevant exception is thrown.

3. **Payment Attempt**:
   - If all validations pass, the `pay` method is invoked.
   - A random number is generated. If the number is greater than 75, the application retries the process once more.

4. **Error Handling**:
   - Custom exceptions ensure clear and precise error reporting to the user.
   - If payment fails after retry, an appropriate message is displayed.

## Technologies Used

- **Java**: The core programming language for this application.
- **Maven**: For project dependency management.

## Prerequisites

- **Java 17 or later**.
- A development environment like IntelliJ IDEA or Eclipse.
- Apache Maven for dependency management.

## Setup and Run

1. Clone the repository:
   ```bash
   git clone https://github.com/your-repository-link.git
   cd payment-processing-app
