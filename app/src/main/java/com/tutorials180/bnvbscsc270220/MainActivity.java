package com.tutorials180.bnvbscsc270220;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.tutorials180.bnvbscsc270220.Fragments.FriendsFragment;
import com.tutorials180.bnvbscsc270220.Fragments.PostsFragment;
import com.tutorials180.bnvbscsc270220.Fragments.SearchFragment;

public class MainActivity extends AppCompatActivity {

    private PostsFragment objectPostsFragment;
    private FriendsFragment objectFriendsFragment;

    private SearchFragment objectSearchFragment;
    private BottomNavigationView objectBottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeObjects();
    }

    private void changeFragment(Fragment objectFragment)
    {
        try
        {
            FragmentTransaction objectTransaction=getSupportFragmentManager().beginTransaction();
            objectTransaction.replace(R.id.container,objectFragment).commit();
        }
        catch (Exception e)
        {
            Toast.makeText(this, "changeFragment:"
                    +e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
    private void initializeObjects()
    {
        try
        {
            objectPostsFragment=new PostsFragment();
            objectFriendsFragment=new FriendsFragment();

            objectSearchFragment=new SearchFragment();
            objectBottomNavigationView=findViewById(R.id.BNV);

            changeFragment(objectPostsFragment);
            objectBottomNavigationView.setOnNavigationItemSelectedListener(
                    new BottomNavigationView.OnNavigationItemSelectedListener() {
                        @Override
                        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                            if(menuItem.getItemId()==R.id.item_posts)
                            {
                                changeFragment(objectPostsFragment);
                                return true;
                            }
                            else if(menuItem.getItemId()==R.id.item_friends)
                            {
                                changeFragment(objectFriendsFragment);
                                return true;
                            }
                            else if(menuItem.getItemId()==R.id.item_search)
                            {
                                changeFragment(objectSearchFragment);
                                return true;
                            }

                            return false;
                        }
                    }
            );

        }
        catch (Exception e)
        {
            Toast.makeText(this, "initializeObjects:"
                    +e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}
