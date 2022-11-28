package com.example.btk2_317;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.core.Context;
import com.orhanobut.dialogplus.DialogPlus;
import com.orhanobut.dialogplus.ViewHolder;

import java.util.HashMap;
import java.util.Map;

public class fishAdapter extends FirebaseRecyclerAdapter<fishModel , fishAdapter.myviewholder> {
    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    Context mcontext;
    public fishAdapter(@NonNull FirebaseRecyclerOptions<fishModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myviewholder holder, int position, @NonNull fishModel model) {
        holder.tenkhoahoc.setText(model.tenkhoahoc);
        holder.tenthuonggoi.setText(model.tenthuonggoi);
        Glide.with(holder.img.getContext()).load(model.hinhanh).into(holder.img);
        holder.btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final DialogPlus dialogPlus = DialogPlus.newDialog(holder.img.getContext())
                        .setContentHolder(new ViewHolder(R.layout.updatefish))
                        .setExpanded(true,1200)
                        .create();
                View view = dialogPlus.getHolderView();
                EditText tenkhoahoc = view.findViewById(R.id.tenkhoahocud);
                EditText tenthuonggoi = view.findViewById(R.id.tenthuonggoiud);
                EditText mausac = view.findViewById(R.id.mausacud);
                EditText dactinh = view.findViewById(R.id.dactinhud);
                EditText hinhanh = view.findViewById(R.id.hinhanhud);
                EditText hinhanhchitiet = view.findViewById(R.id.hinhanhchichitietud);

                Button btnUpDate = view.findViewById(R.id.btnUpDate);

                tenkhoahoc.setText(model.getTenkhoahoc());
                tenthuonggoi.setText(model.getTenthuonggoi());
                mausac.setText(model.getMausac());
                dactinh.setText(model.getDactinh());
                hinhanh.setText(model.getHinhanh());
                hinhanhchitiet.setText(model.getHinhanhchichitiet());
                dialogPlus.show();

                btnUpDate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Map<String,Object> map = new HashMap<>();
                        map.put("tenkhoahoc",tenkhoahoc.getText().toString());
                        map.put("tenthuonggoi",tenthuonggoi.getText().toString());
                        map.put("mausac",mausac.getText().toString());
                        map.put("dactinh",dactinh.getText().toString());
                        map.put("hinhanh",hinhanh.getText().toString());
                        map.put("hinhanhchichitiet",hinhanhchitiet.getText().toString());

                        FirebaseDatabase.getInstance().getReference().child("fishManagement")
                                .child(getRef(position).getKey()).updateChildren(map)
                                .addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void unused) {
                                        Toast.makeText(holder.tenkhoahoc.getContext(), "Data Updated Successfully", Toast.LENGTH_SHORT).show();
                                        dialogPlus.dismiss();
                                    }
                                })
                                .addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull @org.jetbrains.annotations.NotNull Exception e) {
                                        Toast.makeText(holder.tenkhoahoc.getContext(), "Data Updated Error", Toast.LENGTH_SHORT).show();
                                        dialogPlus.dismiss();
                                    }
                                });
                    }
                });
            }
        });

        holder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(holder.tenkhoahoc.getContext());
                builder.setTitle("Are you Sure ?");
                builder.setMessage("Detele data can't be Undo");

                builder.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        FirebaseDatabase.getInstance().getReference().child("fishManagement")
                                .child(getRef(position).getKey()).removeValue();

                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(holder.tenkhoahoc.getContext(), "Cancel", Toast.LENGTH_SHORT).show();

                    }
                });
                builder.show();
            }
        });
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_fish,parent,false);
        return new myviewholder(view);
    }

    public class myviewholder extends RecyclerView.ViewHolder {
        Button btnEdit,btnDelete;
        ImageView img;
        TextView tenkhoahoc,tenthuonggoi;
        public myviewholder(@NonNull View itemView) {
            super(itemView);
            btnEdit = (Button) itemView.findViewById(R.id.btnEdit);
            btnDelete = (Button)itemView.findViewById(R.id.btnDelete);
            img=(ImageView) itemView.findViewById(R.id.hinhanh);
            tenkhoahoc=(TextView)itemView.findViewById(R.id.tenkhoahoc);
            tenthuonggoi=(TextView)itemView.findViewById(R.id.tenthuonggoi);
        }
    }
}
