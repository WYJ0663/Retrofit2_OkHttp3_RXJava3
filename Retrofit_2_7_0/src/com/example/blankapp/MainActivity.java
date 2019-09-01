//package com.example.blankapp;
//
//import android.annotation.SuppressLint;
//import android.app.Activity;
//import android.os.Bundle;
//import android.util.Log;
//import android.view.View;
//import android.widget.TextView;
//import com.example.Retrofit.R;
//import io.reactivex.Observable;
//import io.reactivex.Scheduler;
//import io.reactivex.functions.Consumer;
//import io.reactivex.schedulers.Schedulers;
//import retrofit2.Call;
//import retrofit2.Callback;
//import retrofit2.Response;
//import retrofit2.Retrofit;
//import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
//
//
//public class MainActivity extends Activity implements View.OnClickListener {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        findViewById(R.id.test).setOnClickListener(this);
//    }
//
//
//    @SuppressLint("CheckResult")
//    private void rajava2() {
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("https://www.baidu.com/")
//                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//                .addConverterFactory(new StringConverterFactory())
//                .build();
//
//        Service service = retrofit.create(Service.class);
//
//        service.body().subscribeOn(Schedulers.newThread())
//                .subscribe(new Consumer<String>() {
//                    @Override
//                    public void accept(String s) throws Exception {
//                        TextView textView = findViewById(R.id.text);
//                        textView.setText(s);
//                        Log.e("yijunwu", "onResponse" + s);
//                    }
//                }, new Consumer<Throwable>() {
//                    @Override
//                    public void accept(Throwable throwable) throws Exception {
//                        Log.e("yijunwu", "Throwable" + throwable.toString());
//                    }
//                });
//    }
//
//
//    private void requestRetrofit() {
//        Retrofit retrofit = new Retrofit
//                .Builder()
//                .baseUrl("https://www.baidu.com/")
//                .addConverterFactory(new ToStringConverterFactory())
//                .build();
//        PersonalProtocol personalProtocol = retrofit.create(PersonalProtocol.class);
//        Call<String> call = personalProtocol.getPersonalListInfo(12);
//        call.enqueue(new Callback<String>() {
//            @Override
//            public void onResponse(Call<String> call, Response<String> response) {
//                //数据请求成功
//                Log.e("yijunwu", "onResponse" + response.body());
//            }
//
//            @Override
//            public void onFailure(Call<String> call, Throwable t) {
//                //数据请求失败
//                Log.e("yijunwu", "onFailure");
//            }
//        });
//    }
//
//    @Override
//    public void onClick(View v) {
//        rajava2();
//    }
//}
