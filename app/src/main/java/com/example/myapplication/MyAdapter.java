package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    Context context;
    ArrayList<Profile>profiles;
    public MyAdapter(Context c, ArrayList<Profile>p)
    {
        context=c;
        profiles=p;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.cardview,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.name.setText(profiles.get(position).getName());
        holder.price.setText(profiles.get(position).getPrice());
        holder.description.setText(profiles.get(position).getDescription());
        Picasso.get().load(profiles.get(position).getProfilePic()).into(holder.profilePic);
        if(profiles.get(position).getPermission())
        {
            holder.btn.setVisibility(View.VISIBLE);
            holder.onClick(position);
        }

    }

    @Override
    public int getItemCount() {
        return profiles.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder
    {

        TextView name,price,description;
        ImageView profilePic;
        Button btn;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name=(TextView) itemView.findViewById(R.id.name);
            price=(TextView) itemView.findViewById(R.id.price);
            description=(TextView) itemView.findViewById(R.id.description);
            profilePic=(ImageView) itemView.findViewById(R.id.profilePic);
            btn=(Button) itemView.findViewById(R.id.checkDetails);

        }
        public void onClick (final int position)
        {
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Toast.makeText(context, position+" is clicked", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
