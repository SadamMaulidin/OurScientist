package com.tapperware.ourscientist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecycleViewActivity extends AppCompatActivity {

    @BindView(R.id.my_recycle)
    RecyclerView myRecycle;

    String[] namaScientist, detailScientist;
    int[] gambarScientist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_view);
        ButterKnife.bind(this);

        namaScientist = getResources().getStringArray(R.array.scientist_name);
        detailScientist = getResources().getStringArray(R.array.scientist_detail);
        gambarScientist = new int[]{R.drawable.arrazi, R.drawable.alkhawaridzmi, R.drawable.jabis, R.drawable.ibnsina, R.drawable.alzahrawi, R.drawable.alhaytham, R.drawable.thabidibnqurra, R.drawable.albiruni, R.drawable.alkindi, R.drawable.omara};

        Adapters adapter = new Adapters(this, gambarScientist, namaScientist, detailScientist);

        myRecycle.setHasFixedSize(true);
        myRecycle.setLayoutManager(new LinearLayoutManager(this));
        myRecycle.setAdapter(adapter);
    }
}
