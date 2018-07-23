package com.example.android.learnrecyclerview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ExampleAdapter extends RecyclerView.Adapter<ExampleAdapter.ExampleViewHolder> {

    ArrayList<ExampleItem> mExampleItems;

    private OnItemClickListener mListener;

    public interface OnItemClickListener {
        void OnItemClick(int position);

        void OnDeleteItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    public ExampleAdapter(ArrayList<ExampleItem> exampleItems) {
        mExampleItems = exampleItems;
    }

    @NonNull
    @Override
    public ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        ExampleViewHolder evh = new ExampleViewHolder(v, mListener);
        return evh;
    }

    @Override
    public void onBindViewHolder(@NonNull ExampleViewHolder holder, int position) {

        ExampleItem currentItem = mExampleItems.get(position);
        holder.imageView.setImageResource(currentItem.getmImageresource());
        holder.text1.setText(currentItem.getmText1());
        holder.text2.setText(currentItem.getmText2());
    }

    @Override
    public int getItemCount() {
        return mExampleItems.size();
    }

    public static class ExampleViewHolder extends RecyclerView.ViewHolder {

        public ImageView imageView;
        public TextView text1;
        public TextView text2;
        public ImageView imageViewDelete;

        public ExampleViewHolder(View itemView, final OnItemClickListener listener) {
            super(itemView);

            imageView = itemView.findViewById(R.id.image_view_id);
            text1 = itemView.findViewById(R.id.title_text_vw_id);
            text2 = itemView.findViewById(R.id.title_line2_text_vw_id);
            imageViewDelete = itemView.findViewById(R.id.delete_item_id);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.OnItemClick(position);
                        }
                    }
                }
            });

            imageViewDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.OnDeleteItemClick(position);
                        }
                    }

                }
            });


        }
    }
}
