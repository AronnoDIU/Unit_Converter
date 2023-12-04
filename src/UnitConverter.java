import java.util.Scanner;

public class UnitConverter {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);

        while (true) {
            System.out.println("Select conversion type:");
            System.out.println("1. Length");
            System.out.println("2. Weight");
            System.out.println("3. Temperature");
            System.out.println("4. Quit");

            int choice = userInput.nextInt();

            if (choice == 4) {
                System.out.println("Exiting the unit converter. Goodbye!");
                break;
            }

            switch (choice) {
                case 1:
                    lengthConverter();
                    break;
                case 2:
                    weightConverter();
                    break;
                case 3:
                    temperatureConverter();
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }

        userInput.close();
    }

    private static void lengthConverter() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Select conversion type:");
        System.out.println("1. Meters to Feet");
        System.out.println("2. Feet to Meters");

        int choice = scanner.nextInt();

        System.out.println("Enter value to convert:");
        double value = scanner.nextDouble();

        switch (choice) {
            case 1:
                System.out.println(value + " meters is equal to " + metersToFeet(value) + " feet");
                break;
            case 2:
                System.out.println(value + " feet is equal to " + feetToMeters(value) + " meters");
                break;
            default:
                System.out.println("Invalid choice. Please enter a valid option.");
        }
    }

    private static void weightConverter() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Select conversion type:");
        System.out.println("1. Kilograms to Pounds");
        System.out.println("2. Pounds to Kilograms");

        int choice = scanner.nextInt();

        System.out.println("Enter value to convert:");
        double value = scanner.nextDouble();

        switch (choice) {
            case 1:
                System.out.println(value + " kilograms is equal to " + kilogramsToPounds(value) + " pounds");
                break;
            case 2:
                System.out.println(value + " pounds is equal to " + poundsToKilograms(value) + " kilograms");
                break;
            default:
                System.out.println("Invalid choice. Please enter a valid option.");
        }
    }

    private static void temperatureConverter() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Select conversion type:");
        System.out.println("1. Celsius to Fahrenheit");
        System.out.println("2. Fahrenheit to Celsius");

        int choice = scanner.nextInt();

        System.out.println("Enter value to convert:");
        double value = scanner.nextDouble();

        switch (choice) {
            case 1:
                System.out.println(value + " Celsius is equal to " + celsiusToFahrenheit(value) + " Fahrenheit");
                break;
            case 2:
                System.out.println(value + " Fahrenheit is equal to " + fahrenheitToCelsius(value) + " Celsius");
                break;
            default:
                System.out.println("Invalid choice. Please enter a valid option.");
        }
    }

    private static double metersToFeet(double meters) {
        return meters * 3.28084;
    }

    private static double feetToMeters(double feet) {
        return feet * 0.3048;
    }

    private static double kilogramsToPounds(double kilograms) {
        return kilograms * 2.20462;
    }

    private static double poundsToKilograms(double pounds) {
        return pounds * 0.453592;
    }

    private static double celsiusToFahrenheit(double celsius) {
        return celsius * 9 / 5 + 32;
    }

    private static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }
}
