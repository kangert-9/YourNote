package com.example.yournote;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SocialNetworkAdapter
        extends RecyclerView.Adapter<SocialNetworkAdapter.ViewHolder> {

    private CardSource dataSource;
    //private OnItemClickListener itemClickListener;

    public SocialNetworkAdapter(CardSource dataSource) {
        this.dataSource = dataSource;
    }

    @NonNull
    @Override
    public SocialNetworkAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull SocialNetworkAdapter.ViewHolder viewHolder, int i) {
        //viewHolder.bind(dataSource.getData(i));
        viewHolder.setData(dataSource.getData(i));
    }

    @Override
    public int getItemCount() {
        return dataSource.size();
    }

//    public void SetOnItemClickListener(OnItemClickListener itemClickListener){
//        this.itemClickListener = itemClickListener;
//    }
//
//    public interface OnItemClickListener {
//        void onItemClick(int position);
//    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView title;
        private TextView text;
        private TextView deadline;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            text = itemView.findViewById(R.id.text);
            deadline = itemView.findViewById(R.id.deadline);

//            textView.setOnClickListener(v -> {
//                itemClickListener.onItemClick(getAdapterPosition());
//            });
       }
        public void setData(CardData cardData){
            title.setText(cardData.getNoteName());
            text.setText(cardData.getNote());
            deadline.setText(cardData.getDates());
        }
    }

}