package principal;

import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConversorMoneda {

    public Moneda convertir(String monedaBase, String monedaObjetivo, double monto){

        String url = "https://v6.exchangerate-api.com/v6/";
        String apiKey = "e53b2af241efd7e6544381b9";
        String opcion ="/pair/";
        URI direccion = URI.create(url+apiKey+opcion+monedaBase+"/"+monedaObjetivo+"/"+monto);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();
        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(),Moneda.class);
        } catch (Exception e) {
            throw new RuntimeException("Moneda invalida");
        }
    }

    public static void escribirMenu(){
        System.out.println("""
        ************************************************************
        sea bienvenido/a al Conversor de Moneda = ]
        
        1) Dólar ==> Peso argentino
        2) Peso argentino ==> Dólar
        3) Dólar ==> Real brasileño
        4) Real brasileño ==> Dólar
        5) Dolár ==> Peso Colombiano
        6) Peso Colombiano ==> Dólar
        7) Salir
        Elija una opción valida
        ************************************************************
        """);
    }

}
