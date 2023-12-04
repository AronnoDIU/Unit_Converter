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

            int choice = userInput.nextInt();

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

    private static double lengthConverter(String sourceUnit, String targetUnit, double value) {
        return switch (sourceUnit.toLowerCase()) {
            case "meters" -> switch (targetUnit.toLowerCase()) {
                case "feet" -> value * 3.28084;
                case "kilometers" -> value / 1000;
                default -> Double.MIN_VALUE;
            };
            case "feet" -> switch (targetUnit.toLowerCase()) {
                case "meters" -> value * 0.3048;
                case "kilometers" -> value * 0.0003048;
                default -> Double.MIN_VALUE;
            };
            case "kilometers" -> switch (targetUnit.toLowerCase()) {
                case "meters" -> value * 1000;
                case "feet" -> value * 3280.84;
                default -> Double.MIN_VALUE;
            };
            default -> Double.MIN_VALUE;
        };
    }

    private static double weightConverter(String sourceUnit, String targetUnit, double value) {
        return switch (sourceUnit.toLowerCase()) {
            case "kilograms" -> switch (targetUnit.toLowerCase()) {
                case "pounds" -> value * 2.20462;
                case "grams" -> value * 1000;
                default -> Double.MIN_VALUE;
            };
            case "pounds" -> switch (targetUnit.toLowerCase()) {
                case "kilograms" -> value * 0.453592;
                case "grams" -> value * 453.592;
                default -> Double.MIN_VALUE;
            };
            case "grams" -> switch (targetUnit.toLowerCase()) {
                case "kilograms" -> value / 1000;
                case "pounds" -> value / 453.592;
                default -> Double.MIN_VALUE;
            };
            default -> Double.MIN_VALUE;
        };
    }

    private static double temperatureConverter(String sourceUnit, String targetUnit, double value) {
        return switch (sourceUnit.toLowerCase()) {
            case "celsius" -> switch (targetUnit.toLowerCase()) {
                case "fahrenheit" -> value * 9 / 5 + 32;
                case "kelvin" -> value + 273.15;
                default -> Double.MIN_VALUE;
            };
            case "fahrenheit" -> switch (targetUnit.toLowerCase()) {
                case "celsius" -> (value - 32) * 5 / 9;
                case "kelvin" -> (value + 459.67) * 5 / 9;
                default -> Double.MIN_VALUE;
            };
            case "kelvin" -> switch (targetUnit.toLowerCase()) {
                case "celsius" -> value - 273.15;
                case "fahrenheit" -> value * 9 / 5 - 459.67;
                default -> Double.MIN_VALUE;
            };
            default -> Double.MIN_VALUE;
        };
    }

    private static double volumeConverter(String sourceUnit, String targetUnit, double value) {
        return switch (sourceUnit.toLowerCase()) {
            case "liters" -> switch (targetUnit.toLowerCase()) {
                case "gallons" -> value * 0.264172;
                case "milliliters" -> value * 1000;
                default -> Double.MIN_VALUE;
            };
            case "gallons" -> switch (targetUnit.toLowerCase()) {
                case "liters" -> value * 3.78541;
                case "milliliters" -> value * 3785.41;
                default -> Double.MIN_VALUE;
            };
            case "milliliters" -> switch (targetUnit.toLowerCase()) {
                case "liters" -> value / 1000;
                case "gallons" -> value / 3785.41;
                default -> Double.MIN_VALUE;
            };
            default -> Double.MIN_VALUE;
        };
    }

    private static double areaConverter(String sourceUnit, String targetUnit, double value) {
        return switch (sourceUnit.toLowerCase()) {
            case "squaremeters" -> switch (targetUnit.toLowerCase()) {
                case "squarefeet" -> value * 10.764;
                case "acres" -> value * 0.000247105;
                default -> Double.MIN_VALUE;
            };
            case "squarefeet" -> switch (targetUnit.toLowerCase()) {
                case "squaremeters" -> value * 0.092903;
                case "acres" -> value * 0.0000229568;
                default -> Double.MIN_VALUE;
            };
            case "acres" -> switch (targetUnit.toLowerCase()) {
                case "squaremeters" -> value * 4046.86;
                case "squarefeet" -> value * 43560;
                default -> Double.MIN_VALUE;
            };
            default -> Double.MIN_VALUE;
        };
    }

    private static double speedConverter(String sourceUnit, String targetUnit, double value) {
        return switch (sourceUnit.toLowerCase()) {
            case "meterspersecond" -> switch (targetUnit.toLowerCase()) {
                case "milespertutorialhour" -> value * 2.23694;
                case "kilometersperhour" -> value * 3.6;
                default -> Double.MIN_VALUE;
            };
            case "milespertutorialhour" -> switch (targetUnit.toLowerCase()) {
                case "meterspersecond" -> value * 0.44704;
                case "kilometersperhour" -> value * 1.60934;
                default -> Double.MIN_VALUE;
            };
            case "kilometersperhour" -> switch (targetUnit.toLowerCase()) {
                case "meterspersecond" -> value * 0.277778;
                case "milespertutorialhour" -> value * 0.621371;
                default -> Double.MIN_VALUE;
            };
            default -> Double.MIN_VALUE;
        };
    }
}