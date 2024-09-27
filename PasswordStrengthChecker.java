import java.util.Scanner;

public class PasswordStrengthChecker {

    public static void main(String[] args) {
        System.out.println("===== Welcome to Password Strength Checker =====");
        boolean checkPw = checkPwd(false);
        while (checkPw) {
            checkPasswordStrength();
            checkPw = checkPwd(true);
        }
    }

    public static void checkPasswordStrength() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the password: ");
        String password = scanner.nextLine();

        int strength = 0;
        String remarks = "";
        int lowerCount = 0, upperCount = 0, numCount = 0, wspaceCount = 0, specialCount = 0;

        for (char ch : password.toCharArray()) {
            if (Character.isLowerCase(ch)) {
                lowerCount++;
            } else if (Character.isUpperCase(ch)) {
                upperCount++;
            } else if (Character.isDigit(ch)) {
                numCount++;
            } else if (Character.isWhitespace(ch)) {
                wspaceCount++;
            } else {
                specialCount++;
            }
        }

        if (lowerCount >= 1) strength++;
        if (upperCount >= 1) strength++;
        if (numCount >= 1) strength++;
        if (wspaceCount >= 1) strength++;
        if (specialCount >= 1) strength++;

        switch (strength) {
            case 1:
                remarks = "That's a very bad password. Change it as soon as possible.";
                break;
            case 2:
                remarks = "That's a weak password. You should consider using a tougher password.";
                break;
            case 3:
                remarks = "Your password is okay, but it can be improved.";
                break;
            case 4:
                remarks = "Your password is hard to guess. But you could make it even more secure.";
                break;
            case 5:
                remarks = "Now that's one hell of a strong password! Hackers don't have a chance guessing that password!";
                break;
        }

        System.out.println("Your password has:");
        System.out.println(lowerCount + " lowercase letters");
        System.out.println(upperCount + " uppercase letters");
        System.out.println(numCount + " digits");
        System.out.println(wspaceCount + " whitespaces");
        System.out.println(specialCount + " special characters");
        System.out.println("Password Score: " + ((double) strength / 5));
        System.out.println("Remarks: " + remarks);
    }

    public static boolean checkPwd(boolean anotherPw) {
        Scanner scanner = new Scanner(System.in);
        String choice;
        boolean valid = false;

        if (anotherPw) {
            System.out.print("Do you want to check another password's strength (y/n): ");
        } else {
            System.out.print("Do you want to check your password's strength (y/n): ");
        }

        while (!valid) {
            choice = scanner.nextLine().toLowerCase();
            if (choice.equals("y")) {
                return true;
            } else if (choice.equals("n")) {
                System.out.println("Exiting...");
                return false;
            } else {
                System.out.println("Invalid input...please try again.\n");
            }
        }
        return false; // default return to avoid compilation error
    }
}
