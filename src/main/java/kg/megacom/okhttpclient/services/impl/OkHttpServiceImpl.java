package kg.megacom.okhttpclient.services.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.squareup.okhttp.*;
import kg.megacom.okhttpclient.models.Account;
import kg.megacom.okhttpclient.services.OkHttpService;
import okio.BufferedSink;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class OkHttpServiceImpl implements OkHttpService {

    private OkHttpClient client = new OkHttpClient();
    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public Object test() {

        Account account = new Account();
        account.setId(242l);
        account.setPassword("1234");
        account.setLogin("user");
        account.setActive(true);

        try {
            RequestBody body = RequestBody.create(MediaType.parse("application/json"), objectMapper.writeValueAsBytes(account));

            Request request = new Request.Builder()
                    .url("http://localhost:8080/update")
                    .put(body)
                    .build();

            Response response = client.newCall(request).execute();

            return objectMapper.readValue(response.body().string(), Account.class);

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return null;
    }

//    @Override
//    public Object test() {
//        HttpUrl.Builder builder = HttpUrl.parse("http://localhost:8080/delete").newBuilder();
//        builder.addQueryParameter("id", "1141");
//
//        Request request = new Request.Builder()
//                .url(builder.build())
//                .build();
//
//        try {
//            Response response = client.newCall(request).execute();
//            Account account = objectMapper.readValue(response.body().string(), Account.class);
//            return account;
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        return null;
//    }


//    @Override
//    public Object test() {
//
//        HttpUrl.Builder builder = HttpUrl.parse("http://localhost:8080/get").newBuilder();
//        builder.addQueryParameter("id", "124");
//
//        String url = builder.build().toString();
//
//        System.out.println(url);
//
//        Request request = new Request.Builder()
//                .url(url)
//                //.url("http://localhost:8080/get/32525")
//                .build();
//
//        try {
//            Response response = client.newCall(request).execute();
//            Account account = objectMapper.readValue(response.body().string(), Account.class);
//
//            return account;
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//
//        return null;
//    }


//    @Override
//    public Object test() {
//
//        OkHttpClient client = new OkHttpClient();
//        ObjectMapper objectMapper = new ObjectMapper();
//
//        Request request = new Request.Builder()
//                .url("http://localhost:8080/get")
//                .build();
//        Response response = null;
//        try {
//            response = client.newCall(request).execute();
//            Account account = objectMapper.readValue(response.body().string(), Account.class);
//
//            System.out.println(account.getId());
//            System.out.println(account.getLogin());
//            System.out.println(account.getPassword());
//            System.out.println(account.isActive());
//
//
//
//
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        return response;
//    }
}
