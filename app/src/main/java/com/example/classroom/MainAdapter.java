package com.example.classroom;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainAdapter extends FirebaseRecyclerAdapter<UserModel,MainAdapter.ViewHolder> {
    public MainAdapter(@NonNull FirebaseRecyclerOptions<UserModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull MainAdapter.ViewHolder viewHolder, int i, @NonNull UserModel userModel) {

        viewHolder.name.setText(userModel.getName());
        viewHolder.email.setText(userModel.getEmail());
        Picasso.get().load(userModel.getImage())
                .placeholder(R.drawable.ic_launcher_background)
                .into(viewHolder.image);


    }

    @NonNull
    @Override
    public MainAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.user_item, parent, false));
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {

        CircleImageView image;
        TextView name, email;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.imageView);
            name = itemView.findViewById(R.id.Name);
            email = itemView.findViewById(R.id.Email);
        }
    }
}
