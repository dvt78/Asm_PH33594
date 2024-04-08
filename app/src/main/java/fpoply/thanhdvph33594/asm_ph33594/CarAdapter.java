package fpoply.thanhdvph33594.asm_ph33594;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CarAdapter extends BaseAdapter {
    List<CarModel> carModelList;
    Context context;
    ImageView btnDelete,btnUpdate;
    public CarAdapter(Context context,List<CarModel> carModelList){
        this.context=context;
        this.carModelList=carModelList;
    }
    @Override
    public int getCount() {
        return carModelList.size();
    }

    @Override
    public Object getItem(int position) {
        return carModelList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.item_car, parent, false);

        TextView tvID = (TextView) rowView.findViewById(R.id.txtID);
        ImageView imgAvatar = (ImageView) rowView.findViewById(R.id.imgAvatart);
        TextView tvName = (TextView) rowView.findViewById(R.id.txtTen);

        TextView tvNamSX = (TextView) rowView.findViewById(R.id.txtNamSX);

        TextView tvHang = (TextView) rowView.findViewById(R.id.txtHang);

        TextView tvGia = (TextView) rowView.findViewById(R.id.txtGia);
        btnUpdate = (ImageView) rowView.findViewById(R.id.ivUpdateXe);
        btnDelete = (ImageView) rowView.findViewById(R.id.ivDeleteXe);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(APIService.DOMAIN)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        APIService apiService = retrofit.create(APIService.class);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String id = carModelList.get(position).get_id();//khai báo id
                apiService.deleteCar(carModelList.get(position).get_id()).enqueue(new Callback<CarModel>() {
                    @Override
                    public void onResponse(Call<CarModel> call, Response<CarModel> response) {
                        Toast.makeText(context, "Xóa thành công", Toast.LENGTH_SHORT).show();
                        carModelList.remove(position);
                        notifyDataSetChanged();
                    }

                    @Override
                    public void onFailure(Call<CarModel> call, Throwable t) {
                        Toast.makeText(context, "Xóa thất bại", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

//        String imageUrl = mList.get(position).getThumbnailUrl();
//        Picasso.get().load(imageUrl).into(imgAvatar);
////        imgAvatar.setImageResource(imageId[position]);
        tvName.setText("Tên : "+String.valueOf(carModelList.get(position).getTen()));

        tvNamSX.setText("Năm sản xuất : "+String.valueOf(carModelList.get(position).getNamSX()));

        tvHang.setText("Hãng : "+String.valueOf(carModelList.get(position).getHang()));

        tvGia.setText("Giá :  "+String.valueOf(carModelList.get(position).getGia())+" $");

        return rowView;
    }
}
