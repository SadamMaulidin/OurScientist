package com.tapperware.ourscientist;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class Adapters extends RecyclerView.Adapter<Adapters.ViewHolder> {

    Context context;
    int[] gambarScientist;
    String[] namaScientist,detailScientist;

    public Adapters(Context context, int[] gambarScientist, String[] namaScientist, String[] detailScientist){
        this.context = context;
        this.detailScientist = detailScientist;
        this.namaScientist = namaScientist;
        this.gambarScientist = gambarScientist;

    }

    @NonNull
    @Override
    public Adapters.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_list, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapters.ViewHolder viewHolder, final int i) {
        viewHolder.txtNama.setText(namaScientist[i]);
        Glide.with(context).load(gambarScientist[i]).into(viewHolder.imgFoto);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pindah = new Intent(context, DetailActivity.class);
                pindah.putExtra("ns", namaScientist[i]);
                pindah.putExtra("ds", detailScientist[i]);
                pindah.putExtra("gs", gambarScientist[i]);
                context.startActivity(pindah);
            }
        });

    }

    @Override
    public int getItemCount() {
        return gambarScientist.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgFoto;
        TextView txtNama;
        public ViewHolder(@NonNull View itemView){
            super(itemView);
            imgFoto = itemView.findViewById(R.id.list);
            txtNama = itemView.findViewById(R.id.listTitle);
        }
    }
}
