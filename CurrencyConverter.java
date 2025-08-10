import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import org.json.JSONObject;

public class CurrencyConverter {

    // API Access Key - keep it safe in real projects
    //I HAVE GENERATED MY OWN API KEY
    private static final String API_KEY = "bd29cde2f1fa3539fa3a7cd249c5b5c2";

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("=== INR Currency Converter ===");
        System.out.print("How much INR do you want to convert? ");
        double amountInInr = input.nextDouble();

        while (true) {
            System.out.println("Choose currency to convert INR into:");
            System.out.println("1. US Dollar (USD)");
            System.out.println("2. Euro (EUR)");
            System.out.println("3. Exit");

            System.out.print("Enter option: ");
            int choice = input.nextInt();

            if (choice == 3) {
                System.out.println("Goodbye!");
                break;
            }

            String targetCurrency;
            if (choice == 1) {
                targetCurrency = "USD";
            } else if (choice == 2) {
                targetCurrency = "EUR";
            } else {
                System.out.println("Invalid choice, Please  try again.");
                continue;
            }

            // Building  the API request URL for the convertor
            String apiUrl = "https://api.exchangerate.host/convert"
                    + "?access_key=" + API_KEY
                    + "&from=INR&to=" + targetCurrency
                    + "&amount=" + amountInInr;

            try {
                JSONObject data = getApiResponse(apiUrl);

                // API success check
                if (data.optBoolean("success", false) && data.has("result")) {
                    double convertedValue = data.getDouble("result");
                    System.out.printf("%.2f INR = %.2f %s%n", amountInInr, convertedValue, targetCurrency);
                } else {
                    System.out.println("Could not get conversion rate. API said: " + data);
                }
            } catch (Exception e) {
                System.out.println("Something went wrong: " + e.getMessage());
            }
        }

        input.close();
    }

    // Fetch and return JSON data from the given URL
    private static JSONObject getApiResponse(String urlStr) throws Exception {
        URL url = new URL(urlStr);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        BufferedReader reader = new BufferedReader(
                new InputStreamReader(connection.getInputStream())
        );

        StringBuilder responseBuilder = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            responseBuilder.append(line);
        }
        reader.close();

        return new JSONObject(responseBuilder.toString());
    }
}
