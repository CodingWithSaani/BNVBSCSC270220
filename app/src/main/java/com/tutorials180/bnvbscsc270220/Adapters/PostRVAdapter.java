package com.tutorials180.bnvbscsc270220.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.tutorials180.bnvbscsc270220.ModelClasses.PostModel;
import com.tutorials180.bnvbscsc270220.R;

import java.util.ArrayList;

public class PostRVAdapter extends RecyclerView.Adapter<PostRVAdapter.PostViewHolder>{


    private ArrayList<PostModel> objectPostModelArrayList;
    public PostRVAdapter(ArrayList<PostModel> objectArrayList) {
        objectPostModelArrayList=objectArrayList;
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View singleRow= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.single_row,parent,false);

        PostViewHolder objectPostViewHolder=new PostViewHolder(singleRow);
        return objectPostViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        PostModel objectCurrent=objectPostModelArrayList.get(position);
        holder.userNameTV.setText(objectCurrent.getUserName());

        holder.userPostIV.setImageResource(objectCurrent.getImageRef());
    }

    @Override
    public int getItemCount() {
        return objectPostModelArrayList.size();
    }

    public class PostViewHolder extends RecyclerView.ViewHolder
    {

        private TextView userNameTV;
        private ImageView userPostIV;
        public PostViewHolder(@NonNull View singleRow) {
            super(singleRow);
            userNameTV=singleRow.findViewById(R.id.singleRow_userNameTV);

            userPostIV=singleRow.findViewById(R.id.singleRow_contentPicIV);
        }
    }
}
