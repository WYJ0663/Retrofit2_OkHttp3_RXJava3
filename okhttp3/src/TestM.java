import okhttp3.CacheControl;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TestM {
    public static void main(String[] args) {
        testhttp();
    }

    private static void testhttp() {
        String url = "http://172.17.11.60:1125/";
        OkHttpClient okHttpClient = new OkHttpClient().newBuilder()
                .addNetworkInterceptor(new LoggingInterceptor("Network"))
                .addInterceptor(new LoggingInterceptor()).build();

        final Request request = new Request.Builder()
                .cacheControl(new CacheControl.Builder().maxStale(365, TimeUnit.DAYS).build())
                .url(url)
                .get()//默认就是GET请求，可以不写
                .build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                System.out.println("onFailure: ");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                System.out.println("onResponse: " + response.body().string());
            }
        });


//        Call call2 = okHttpClient.newCall(request);
//        try {
//            call2.execute();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//        final Request request2 = new Request.Builder()
//                .url("ws://172.17.11.60:1125/")
//                .get()//默认就是GET请求，可以不写
//                .build();
//        WebSocket webSocket = okHttpClient.newWebSocket(request2, new WebSocketListener() {
//            @Override
//            public void onMessage(WebSocket webSocket, String text) {
//                super.onMessage(webSocket, text);
//            }
//        });
//        webSocket.send("sss");

    }


    static class LoggingInterceptor implements Interceptor {
        String type;

        public LoggingInterceptor() {
        }

        public LoggingInterceptor(String type) {
            this.type = type;
        }

        @Override
        public Response intercept(Interceptor.Chain chain) throws IOException {
            Request request = chain.request();

            long t1 = System.nanoTime();
            System.out.println(String.format(type + " Sending request %s on %s%n%s",
                    request.url(), chain.connection(), request.headers()));

            Response response = chain.proceed(request);

            long t2 = System.nanoTime();
            System.out.println(String.format(type + " Received response for %s in %.1fms%n%s",
                    response.request().url(), (t2 - t1) / 1e6d, response.headers()));

            return response;
        }
    }


    public static void testHttps(){
        String url = "https://www.baidu.com/";
        OkHttpClient okHttpClient = new OkHttpClient();

        final Request request = new Request.Builder()
                .cacheControl(new CacheControl.Builder().maxStale(365, TimeUnit.DAYS).build())
                .url(url)
                .get()//默认就是GET请求，可以不写
                .build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                System.out.println("onFailure: ");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                System.out.println("onResponse: " + response.body().string());
            }
        });

    }
}
