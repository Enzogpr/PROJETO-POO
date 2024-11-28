package com.fag.infra.celcoin;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.nio.charset.StandardCharsets;
import java.util.Map;

import com.fag.domain.dto.BankslipDTO;
import com.fag.domain.repositories.IBassRepository;
import com.fag.infra.utils.JsonUtils;

public class CelcoinBassRepository implements IBassRepository{

        public static String genToken() throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        URI uri = new URI("https://sandbox.openfinance.celcoin.dev/v5/token");
        String params = "client_id=" + URLEncoder.encode("41b44ab9a56440.teste.celcoinapi.v5", StandardCharsets.UTF_8)
                + "&grant_type=" + URLEncoder.encode("client_credentials", StandardCharsets.UTF_8)
                + "&client_secret=" + URLEncoder.encode(
                        "e9d15cde33024c1494de7480e69b7a18c09d7cd25a8446839b3be82a56a044a3", StandardCharsets.UTF_8);

        HttpRequest request = HttpRequest.newBuilder(uri)
                .header("Content-Type", "application/x-www-form-urlencoded")
                .POST(BodyPublishers.ofString(params))
                .build();

        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());

        return JsonUtils.getField(response.body(), "access_token");
    }


    @Override
    public String consultarBoleto(String linhaDigitavel) throws Exception  {

      String token = genToken();

            HttpClient client = HttpClient.newHttpClient();
        URI uri = new URI("https://sandbox.openfinance.celcoin.dev/v5/transactions/billpayments/authorize");

    String payload = "{\r\n" +
   "  \"barCode\": {\r\n" +
   "    \"type\": 0,\r\n" +
   "    \"digitable\": " +
   linhaDigitavel  +
   "  }\r\n" +
   "}";

        HttpRequest request = HttpRequest.newBuilder(uri)
        .header("Content-Type", "application/json")
        .header("Authorization", "Bearer " + token)
        .POST(BodyPublishers.ofString(payload))
        .build();

        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());




        return response.body();
    }


    @Override
    public String pagarBoleto(BankslipDTO dadosBoletoConsultado) throws Exception {

        String token = genToken();

        HttpClient client = HttpClient.newHttpClient();
    URI uri = new URI("https://sandbox.openfinance.celcoin.dev/v5/transactions/billpayments");

    String payload = "{\n" + 
    "  \"cpfCnpj\": \"24602516025\",\n" + 
    "  \"billData\": {\n" + 
    "    \"value\": " + dadosBoletoConsultado.getValorPago() + ",\n" + 
    "    \"originalValue\": 0,\n" + 
    "    \"valueWithDiscount\": 0,\n" + 
    "    \"valueWithAdditional\": 0\n" + 
    "  },\n" + 
    "  \"barCode\": {\n" + 
    "    \"type\": 0,\n" + 
    "    \"digitable\": \"" + dadosBoletoConsultado.getBarcode() + "\"\n" + 
    "  },\n" + 
    "  \"dueDate\": \"2021-05-25T00:00:00Z\",\n" + 
    "  \"transactionIdAuthorize\": " + dadosBoletoConsultado.getTransactionId() + "\n" + 
    "}";
    
    HttpRequest request = HttpRequest.newBuilder(uri)
    .header("Content-Type", "application/json")
    .header("Authorization", "Bearer " + token)
    .POST(BodyPublishers.ofString(payload))
    .build();

    HttpResponse<String> response = client.send(request, BodyHandlers.ofString());

    return response.body();
    
    }

    @Override
    public String gerarQrCode(Double valorPix) throws Exception {

        String token = genToken();

        
        HttpClient client = HttpClient.newHttpClient();


        URI uri = new URI("https://sandbox.openfinance.celcoin.dev/pix/v1/brcode/static");

        HttpRequest request = HttpRequest.newBuilder(uri)
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + token)
                .POST(BodyPublishers.ofString("{\n" + //
                        "  \"key\": \"testepix@celcoin.com.br\",\n" + //
                        "  \"amount\":" + valorPix + ",\n" + //
                        "  \"merchant\": {\n" + //
                        "    \"postalCode\": \"01201005\",\n" + //
                        "    \"city\": \"Barueri\",\n" + //
                        "    \"merchantCategoryCode\": 0,\n" + //
                        "    \"name\": \"Celcoin\"\n" + //
                        "  }\n" + //
                        "}"))
                .build();

        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());

        return response.body();
    }

    
}
