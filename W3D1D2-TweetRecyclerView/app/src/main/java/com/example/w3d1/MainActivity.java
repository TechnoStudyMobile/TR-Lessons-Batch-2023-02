package com.example.w3d1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private final List<Tweet> tweets = new ArrayList<>();

    private final TweetAdapter adapter = new TweetAdapter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // boilerplate
        // changelog
        // release candidate

        // twitter ->  tweet listesi

        // tweet -> recycler view(list view)

        // 1. layout yap -> OK
        // 2. model oluştur -> OK
        // 3. adapter -> OK
        // 4. list

        tweets.add(new Tweet("Tweet1 : Hello World!"));
        tweets.add(new Tweet("Tweet2: Merhaba"));
        tweets.add(new Tweet("Tweet3: Görusuruz"));
        tweets.add(new Tweet("Tweet1 : Hello World!"));
        tweets.add(new Tweet("Tweet2: Merhaba"));
        tweets.add(new Tweet("Tweet3: Görusuruz"));
        tweets.add(new Tweet("Tweet1 : Hello World!"));
        tweets.add(new Tweet("Tweet2: Merhaba"));
        tweets.add(new Tweet("Tweet3: Görusuruz"));

        adapter.setTweetList(tweets);
        adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Bu şekilde vermiyoruz.
            }
        });


        RecyclerView recyclerView =
                findViewById(R.id.tweet_recycler_view);
        recyclerView.setAdapter(adapter);


        /*
            LinearLayoutManager layoutManager = new LinearLayoutManager(this);
            recyclerView.setLayoutManager(layoutManager);

            GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
            StaggeredGridLayoutManager staggered = new StaggeredGridLayoutManager(2, RecyclerView.VERTICAL);
         */

        Toast.makeText(this, "Bu bir deneme", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();

        /*
        Tweet newTweet = new Tweet("Geri tuşuna basıldı!");
        tweets.add(newTweet);
         */

         /*
         x x x -> 3
         0 1 2
          */

        if (tweets.size() > 0) {
            tweets.remove(tweets.size() - 1);
            adapter.notifyDataSetChanged();
        }
    }
}