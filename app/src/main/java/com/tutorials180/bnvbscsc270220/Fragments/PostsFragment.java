package com.tutorials180.bnvbscsc270220.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.tutorials180.bnvbscsc270220.Adapters.PostRVAdapter;
import com.tutorials180.bnvbscsc270220.ModelClasses.PostModel;
import com.tutorials180.bnvbscsc270220.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class PostsFragment extends Fragment {

    public PostsFragment() {
        // Required empty public constructor
    }


    private View postView;
    private RecyclerView objectRecyclerView;

    private ArrayList<PostModel> objectArrayList;
    private PostRVAdapter objectPostRVAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        postView=inflater.inflate(R.layout.fragment_posts, container, false);
        initializeFragmentObjects();

        return postView;
    }

    private void addValuesRV()
    {
        try
        {
            objectPostRVAdapter=new PostRVAdapter(objectArrayList);
            objectRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

            objectRecyclerView.setAdapter(objectPostRVAdapter);
        }
        catch (Exception e)
        {
            Toast.makeText(getContext(), "addValuesToRV:"+e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
    private void initializeFragmentObjects()
    {
        try
        {
            objectRecyclerView=postView.findViewById(R.id.RV);

            objectArrayList=new ArrayList<>();
            addPostObjects();
        }
        catch (Exception e)
        {
            Toast.makeText(getContext(), "initializeFragmentObjects:"
                    +e.getMessage(), Toast.LENGTH_SHORT).show();
        }

    }

    private void addPostObjects()
    {
        try
        {
            objectArrayList.add(new PostModel("USER ONE",R.drawable.pic_one));
            objectArrayList.add(new PostModel("USER ONE",R.drawable.pic_two));

            objectArrayList.add(new PostModel("USER ONE",R.drawable.pic_three));
            objectArrayList.add(new PostModel("USER ONE",R.drawable.pic_four));

            objectArrayList.add(new PostModel("USER ONE",R.drawable.pic_five));
            objectArrayList.add(new PostModel("USER ONE",R.drawable.pic_six));

            objectArrayList.add(new PostModel("USER ONE",R.drawable.pic_seven));
            objectArrayList.add(new PostModel("USER ONE",R.drawable.pic_one));

            addValuesRV();
        }
        catch (Exception e)
        {
            Toast.makeText(getContext(), "addPostObjects:"+
                    e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}
