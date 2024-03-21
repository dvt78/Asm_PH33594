package fpoply.thanhdvph33594.asm_ph33594;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIService {
     String DOMAIN = "http://192.168.1.3:3000/";
     @GET("/api/list")
     Call<List<CarModel>> getCars();
}
