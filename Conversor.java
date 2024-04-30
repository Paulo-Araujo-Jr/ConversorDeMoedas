import com.google.gson.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

import java.net.URL;


class Conversor {

    public double conversorDeMoeda(int escolha, double qnt) throws IOException, InterruptedException {
        String apiKey = "75dd0284c48da5254d9048a7";
        String urlStr = "https://v6.exchangerate-api.com/v6/" + apiKey + "/latest/BRL";

        try {
            URL url = new URL(urlStr);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                JsonParser parser = new JsonParser();
                JsonElement root = parser.parse(response.toString());
                JsonObject jsonObj = root.getAsJsonObject();

                JsonObject conversionRates = jsonObj.getAsJsonObject("conversion_rates");

                switch (escolha){
                    case 1:
                        System.out.println("Quantidade a ser convertida: "+ qnt);
                        System.out.println("Valor de 1 USD x 1 BRL "+ conversionRates.get("USD").getAsDouble());
                        double resultado1 = conversionRates.get("USD").getAsDouble() * qnt;
                        return resultado1;

                    case 2:
                        System.out.println("Quantidade a ser convertida: "+ qnt);
                        System.out.println("Valor de 1 EUR x 1 BRL "+ conversionRates.get("EUR").getAsDouble());
                        double resultado2 = conversionRates.get("EUR").getAsDouble() * qnt;
                        return resultado2;
                    case 3:
                        System.out.println("Quantidade a ser convertida: "+ qnt);
                        System.out.println("Valor de 1 KWD x 1 BRL "+ conversionRates.get("KWD").getAsDouble());
                        double resultado3 = conversionRates.get("KWD").getAsDouble() * qnt;
                        return resultado3;
                    case 4:
                        System.out.println("Quantidade a ser convertida: "+ qnt);
                        System.out.println("Valor de 1 ARS x 1 BRL "+ conversionRates.get("ARS").getAsDouble());
                        double resultado4 = conversionRates.get("ARS").getAsDouble() * qnt;
                        return resultado4;
                    case 5:
                        System.out.println("Quantidade a ser convertida: "+ qnt);
                        System.out.println("Valor de 1 JPY x 1 BRL "+ conversionRates.get("JPY").getAsDouble());
                        double resultado5 = conversionRates.get("JPY").getAsDouble() * qnt;
                        return resultado5;
                    case 6:
                        System.out.println("Quantidade a ser convertida: "+ qnt);
                        System.out.println("Valor de 1 CNY x 1 BRL "+ conversionRates.get("CNY").getAsDouble());
                        double resultado6 = conversionRates.get("CNY").getAsDouble() * qnt;
                        return resultado6;

                }

            } else {
                System.out.println("Erro ao obter a resposta da API. Código de resposta: " + responseCode);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }
}