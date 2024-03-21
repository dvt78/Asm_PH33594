package fpoply.thanhdvph33594.asm_ph33594;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CarAdapter extends BaseAdapter {
    List<CarModel> carModelList;
    Context context;
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
