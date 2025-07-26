import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultarDivisa {

            double HacerCambio(String divisaPrimera, String divisaCambiar) throws IOException, InterruptedException {
            URI direccion = URI.create("https://v6.exchangerate-api.com/v6/f3eee695a8a7f2ea5d489aaf/latest/" + divisaPrimera + "/");
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(direccion)
                    .build();
            HttpResponse<String> response;
            response = client.send(request, HttpResponse.BodyHandlers.ofString());


            Divisa divisa = new Gson().fromJson(response.body(), Divisa.class);
            double convertir = divisa.conversion_rates().get(divisaCambiar);

            return convertir;
        }

    }


