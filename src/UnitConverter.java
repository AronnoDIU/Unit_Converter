import java.util.Scanner;

public class UnitConverter {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);

        while (true) {
            System.out.println("Select conversion type:");
            System.out.println("1. Length");
            System.out.println("2. Weight");
            System.out.println("3. Temperature");
            System.out.println("4. Volume");
            System.out.println("5. Area");
            System.out.println("6. Speed");
            System.out.println("7. Quit");

            System.out.println("Enter your choice:");
            int choice = userInput.nextInt();

            // Check if the user wants to quit
            if (choice == 7) {
                System.out.println("Exiting the unit converter. Goodbye!");
                break;
            }

            switch (choice) {
                case 1:
                    performConversion("Length");
                    break;
                case 2:
                    performConversion("Weight");
                    break;
                case 3:
                    performConversion("Temperature");
                    break;
                case 4:
                    performConversion("Volume");
                    break;
                case 5:
                    performConversion("Area");
                    break;
                case 6:
                    performConversion("Speed");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }

        userInput.close(); // Close the scanner to prevent resource leak
    }

    // This method performs the conversion based on the category
    private static void performConversion(String category) {
        Scanner userInput = new Scanner(System.in);

        System.out.println("Select source unit:");
        String sourceUnit = userInput.next();

        System.out.println("Enter value to convert:");
        double value = userInput.nextDouble();

        System.out.println("Select target unit:");
        String targetUnit = userInput.next();

        // Call the convert method to perform the conversion
        double result = convert(category, sourceUnit, targetUnit, value);

        // Check if the result is valid and print the result
        if (result != Double.MIN_VALUE) {
            System.out.println(value + " " + sourceUnit
                    + " is equal to " + result + " " + targetUnit);
        } else {
            System.out.println("Invalid source/target units. Please enter valid units.");
        }
    }

    // This method converts the value from the source unit to the target unit
    private static double
    convert(String category, String sourceUnit, String targetUnit, double value) {
        return switch (category.toLowerCase()) {
            case "length" -> lengthConverter(sourceUnit, targetUnit, value);
            case "weight" -> weightConverter(sourceUnit, targetUnit, value);
            case "temperature" -> temperatureConverter(sourceUnit, targetUnit, value);
            case "volume" -> volumeConverter(sourceUnit, targetUnit, value);
            case "area" -> areaConverter(sourceUnit, targetUnit, value);
            case "speed" -> speedConverter(sourceUnit, targetUnit, value);
            default -> Double.MIN_VALUE;
        };
    }

    // This method converts the value from the source unit to the target unit
    private static double lengthConverter(String sourceUnit, String targetUnit, double value) {
        return switch (sourceUnit.toLowerCase()) {
            case "meters" -> switch (targetUnit.toLowerCase()) { // Nested switch statements
                case "feet" -> value * 3.28084; // Convert meters to feet
                case "kilometers" -> value / 1000; // Convert meters to kilometers
                default -> Double.MIN_VALUE; // Return an invalid value if conversion is not possible
            };
            case "feet" -> switch (targetUnit.toLowerCase()) { // Nested switch statements
                case "meters" -> value * 0.3048; // Convert feet to meters
                case "kilometers" -> value * 0.0003048; // Convert feet to kilometers
                default -> Double.MIN_VALUE; // Return an invalid value if conversion is not possible
            };
            case "kilometers" -> switch (targetUnit.toLowerCase()) {
                case "meters" -> value * 1000; // Convert kilometers to meters
                case "feet" -> value * 3280.84; // Convert kilometers to feet
                default -> Double.MIN_VALUE; // Return an invalid value if conversion is not possible
            };
            default -> Double.MIN_VALUE; // Return an invalid value if conversion is not possible
        };
    }

    // This method converts the value from the source unit to the target unit
    private static double weightConverter(String sourceUnit, String targetUnit, double value) {
        return switch (sourceUnit.toLowerCase()) {
            case "kilograms" -> switch (targetUnit.toLowerCase()) { // Nested switch statements
                case "pounds" -> value * 2.20462; // Convert kilograms to pounds
                case "grams" -> value * 1000; // Convert kilograms to grams
                default -> Double.MIN_VALUE; // Return an invalid value if conversion is not possible
            };
            case "pounds" -> switch (targetUnit.toLowerCase()) { // Nested switch statements
                case "kilograms" -> value * 0.453592; // Convert pounds to kilograms
                case "grams" -> value * 453.592; // Convert pounds to grams
                default -> Double.MIN_VALUE;
            };
            case "grams" -> switch (targetUnit.toLowerCase()) { // Nested switch statements
                case "kilograms" -> value / 1000; // Convert grams to kilograms
                case "pounds" -> value / 453.592; // Convert grams to pounds
                default -> Double.MIN_VALUE;
            };
            default -> Double.MIN_VALUE; // Return an invalid value if conversion is not possible
        };
    }

    // This method converts the value from the source unit to the target unit
    private static double temperatureConverter(String sourceUnit, String targetUnit, double value) {
        return switch (sourceUnit.toLowerCase()) {
            case "celsius" -> switch (targetUnit.toLowerCase()) { // Nested switch statements
                case "fahrenheit" -> value * 9 / 5 + 32; // Convert celsius to fahrenheit
                case "kelvin" -> value + 273.15; // Convert celsius to kelvin
                default -> Double.MIN_VALUE;
            };
            case "fahrenheit" -> switch (targetUnit.toLowerCase()) {
                case "celsius" -> (value - 32) * 5 / 9; // Convert fahrenheit to celsius
                case "kelvin" -> (value + 459.67) * 5 / 9; // Convert fahrenheit to kelvin
                default -> Double.MIN_VALUE;
            };
            case "kelvin" -> switch (targetUnit.toLowerCase()) {
                case "celsius" -> value - 273.15; // Convert kelvin to celsius
                case "fahrenheit" -> value * 9 / 5 - 459.67; // Convert kelvin to fahrenheit
                default -> Double.MIN_VALUE;
            };
            default -> Double.MIN_VALUE;
        };
    }

    private static double volumeConverter(String sourceUnit, String targetUnit, double value) {
        return switch (sourceUnit.toLowerCase()) { // Nested switch statements
            case "liters" -> switch (targetUnit.toLowerCase()) {
                case "gallons" -> value * 0.264172; // Convert liters to gallons
                case "milliliters" -> value * 1000; // Convert liters to milliliters
                default -> Double.MIN_VALUE;
            };
            case "gallons" -> switch (targetUnit.toLowerCase()) {
                case "liters" -> value * 3.78541; // Convert gallons to liters
                case "milliliters" -> value * 3785.41; // Convert gallons to milliliters
                default -> Double.MIN_VALUE;
            };
            case "milliliters" -> switch (targetUnit.toLowerCase()) {
                case "liters" -> value / 1000; // Convert milliliters to liters
                case "gallons" -> value / 3785.41; // Convert milliliters to gallons
                default -> Double.MIN_VALUE;
            };
            default -> Double.MIN_VALUE;
        };
    }

    // This method converts the value from the source unit to the target unit
    private static double areaConverter(String sourceUnit, String targetUnit, double value) {
        return switch (sourceUnit.toLowerCase()) {
            case "squaremeters" -> switch (targetUnit.toLowerCase()) {
                case "squarefeet" -> value * 10.764; // Convert square meters to square feet
                case "acres" -> value * 0.000247105; // Convert square meters to acres
                default -> Double.MIN_VALUE;
            };
            case "squarefeet" -> switch (targetUnit.toLowerCase()) {
                case "squaremeters" -> value * 0.092903; // Convert square feet to square meters
                case "acres" -> value * 0.0000229568; // Convert square feet to acres
                default -> Double.MIN_VALUE;
            };
            case "acres" -> switch (targetUnit.toLowerCase()) {
                case "squaremeters" -> value * 4046.86; // Convert acres to square meters
                case "squarefeet" -> value * 43560; // Convert acres to square feet
                default -> Double.MIN_VALUE;
            };
            default -> Double.MIN_VALUE;
        };
    }

    // This method converts the value from the source unit to the target unit
    private static double speedConverter(String sourceUnit, String targetUnit, double value) {
        return switch (sourceUnit.toLowerCase()) {
            case "meterspersecond" -> switch (targetUnit.toLowerCase()) {
                case "milespertutorialhour" -> value * 2.23694; // Convert meters per second to miles per hour
                case "kilometersperhour" -> value * 3.6; // Convert meters per second to kilometers per hour
                default -> Double.MIN_VALUE;
            };
            case "milespertutorialhour" -> switch (targetUnit.toLowerCase()) {
                case "meterspersecond" -> value * 0.44704; // Convert miles per hour to meters per second
                case "kilometersperhour" -> value * 1.60934; // Convert miles per hour to kilometers per hour
                default -> Double.MIN_VALUE;
            };
            case "kilometersperhour" -> switch (targetUnit.toLowerCase()) {
                case "meterspersecond" -> value * 0.277778; // Convert kilometers per hour to meters per second
                case "milespertutorialhour" -> value * 0.621371; // Convert kilometers per hour to miles per hour
                default -> Double.MIN_VALUE;
            };
            default -> Double.MIN_VALUE; // Return an invalid value if conversion is not possible
        };
    }
}