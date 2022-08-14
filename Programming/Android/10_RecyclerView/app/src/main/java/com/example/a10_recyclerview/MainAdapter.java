package com.example.a10_recyclerview;

import android.hardware.ConsumerIrManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.CustomViewHolder> {

    private ArrayList<MainData> arrList;

    public MainAdapter(ArrayList<MainData> arrList) {
        this.arrList = arrList;
    }

    @NonNull
    @Override
    public MainAdapter.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        CustomViewHolder holder = new CustomViewHolder(view);

        return holder;
    }

    @Override
    // 실제 생성되었을 때 Item 생명주기
    public void onBindViewHolder(@NonNull MainAdapter.CustomViewHolder holder, int position) {
        holder.profileImageView.setImageResource(arrList.get(position).getProfileImageView());
        holder.nameTextView.setText(arrList.get(position).getNameTextView());
        holder.contentTextView.setText(arrList.get(position).getContentTextView());

        holder.itemView.setTag(position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String curName = holder.nameTextView.getText().toString();
                Toast.makeText(view.getContext(), curName, Toast.LENGTH_SHORT).show();
            }
        });

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                remove(holder.getAdapterPosition());

                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return (arrList != null ? arrList.size() : 0);
    }

    public void remove(int position){
        try
        {
            arrList.remove(position);
            notifyItemRemoved(position);
        }
        catch (IndexOutOfBoundsException ex)
        {
            ex.printStackTrace();
        }

    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {

        protected ImageView profileImageView;
        protected TextView nameTextView;
        protected TextView contentTextView;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);

            this.profileImageView = itemView.findViewById(R.id.profileImageView);
            this.nameTextView = itemView.findViewById(R.id.nameTextView);
            this.contentTextView = itemView.findViewById(R.id.contentTextView);
        }
    }
}
