package com.example.adzanapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class AdzanAdapter extends BaseAdapter {

    private Context context;
    private List<AdzanModel> list;

    public AdzanAdapter(Context context, List<AdzanModel> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(context)
                    .inflate(R.layout.item_adzan, parent, false);
        }

        ImageView imgFlag = convertView.findViewById(R.id.imgFlag);
        TextView txtNegara = convertView.findViewById(R.id.txtNegara);
        TextView txtMuadzin = convertView.findViewById(R.id.txtMuadzin);

        AdzanModel model = list.get(position);

        imgFlag.setImageResource(model.getFlagRes());
        txtNegara.setText(model.getNegara());
        txtMuadzin.setText(model.getMuadzin());

        return convertView;
    }
}



