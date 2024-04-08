package fpoply.thanhdvph33594.asm_ph33594;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface APIService {
     //thay đổi mỗi khi máy mở lại
     String DOMAIN = "http://192.168.1.10:3000/";
     @GET("/api/list")
     Call<List<CarModel>> getCars();
     @DELETE("/api/xoa/{id}")
     Call<CarModel> deleteCar(@Path("id") String id);
}
