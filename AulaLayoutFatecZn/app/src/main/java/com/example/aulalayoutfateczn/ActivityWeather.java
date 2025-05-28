package com.example.aulalayoutfateczn;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.aulalayoutfateczn.Model.WeatherResponse;
import com.example.aulalayoutfateczn.Network.WeatherService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ActivityWeather extends AppCompatActivity {

    private EditText etCidade;
    private Button btnBuscar;
    private TextView tvTemperatura, tvDescricao;
    private WeatherService weatherService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.weather);

        etCidade = findViewById(R.id.etCidade);
        btnBuscar = findViewById(R.id.btnBuscar);
        tvTemperatura = findViewById(R.id.tvTemperatura);
        tvDescricao = findViewById(R.id.tvDescricao);


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.openweathermap.org/data/2.5/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        weatherService = retrofit.create(WeatherService.class);

        btnBuscar.setOnClickListener(v -> {
            String cidade = etCidade.getText().toString().trim();
            if (!cidade.isEmpty()) {
                buscarClima(cidade);
            } else {
                tvTemperatura.setText("Digite uma cidade válida");
                tvDescricao.setText("");
            }
        });

    }


    private void buscarClima(String cidade) {
        Call<WeatherResponse> call = weatherService.getWeather(
                cidade,
                "b305d1d05162bc315fb2531779348e44",
                "metric",
                "pt_br"
        );

        call.enqueue(new Callback<WeatherResponse>() {
            @Override
            public void onResponse(Call<WeatherResponse> call, Response<WeatherResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    WeatherResponse weather = response.body();

                    float temp = weather.main.temp;
                    String descricao = weather.weather.get(0).description;

                    tvTemperatura.setText( temp + "°C");
                    tvDescricao.setText("Predominantemente " + descricao);
                } else {
                    tvTemperatura.setText("Erro");
                    tvDescricao.setText("Verifique o nome da cidade");
                }
            }

            @Override
            public void onFailure(Call<WeatherResponse> call, Throwable t) {
                tvTemperatura.setText("Erro");
                tvDescricao.setText(t.getMessage());
            }
        });
    }



    }

