package com.example.retrofit1;

import android.content.Context;
import android.telecom.Call;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class FlowerAdapter extends ArrayAdapter<FowerResponse> {

    private Context context;
    private List<FowerResponse> fowerResponseList;

    public FlowerAdapter( Context context, List<FowerResponse> fowerResponseList) {
        super(context, R.layout.flower_row);
        this.context = context;
        this.fowerResponseList = fowerResponseList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.flower_row,parent,false);
        TextView nameTV = convertView.findViewById(R.id.flowerName);
        TextView priceTV = convertView.findViewById(R.id.flowerPrice);
        nameTV.setText(fowerResponseList.get(position).getName());
        priceTV.setText(String.valueOf(fowerResponseList.get(position).getPrice()));
        return convertView;
    }
}
