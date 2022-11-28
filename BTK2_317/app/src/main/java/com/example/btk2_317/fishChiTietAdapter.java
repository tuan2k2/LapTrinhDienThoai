package com.example.btk2_317;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;

public class fishChiTietAdapter extends FirebaseRecyclerAdapter<fishModel , fishChiTietAdapter.myviewholder> {
    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public fishChiTietAdapter(@NonNull FirebaseRecyclerOptions<fishModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myviewholder holder, int position, @NonNull fishModel model) {

    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_fish_chi_tiet,parent,false);
        return new fishChiTietAdapter.myviewholder(view);
    }

    public class myviewholder extends RecyclerView.ViewHolder {
        ImageView img1 , img2 ;
        TextView tenkhoahoc,tenthuonggoi ,  dactinh , mausac;
        public myviewholder(@NonNull View itemView) {
            super(itemView);
            img1=(ImageView) itemView.findViewById(R.id.hinhanhct);
            img2=(ImageView) itemView.findViewById(R.id.hinhanhchichitiet);
            tenkhoahoc=(TextView)itemView.findViewById(R.id.tenkhoahocct);
            tenthuonggoi=(TextView)itemView.findViewById(R.id.tenthuonggoict);
            dactinh=(TextView)itemView.findViewById(R.id.dactinh);
            mausac=(TextView)itemView.findViewById(R.id.mausac);
        }
    }
}
