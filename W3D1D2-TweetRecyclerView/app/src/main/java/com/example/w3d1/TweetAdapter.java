package com.example.w3d1;

import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TweetAdapter extends RecyclerView.Adapter<TweetAdapter.TwitterViewHolder> {

    // SOLID
    private List<Tweet> tweets;

    private View.OnClickListener onClickListener;

    @NonNull
    @Override
    public TwitterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(
                parent.getContext()).inflate(
                        R.layout.item_tweet, parent, false);
        return new TwitterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TwitterViewHolder holder, int position) {
        TextView textView = holder.getTweetText();
        String text = tweets.get(position).getText();
        textView.setText(text);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.w("CLICK_LOG", textView.getText().toString());
                onClickListener.onClick(view);
            }
        });

        // 4 % 2 -> 0
        // 5 % 2 -> 1
        // 6 % 2 -> 0
        if (position % 2 == 0) {
            textView.setBackgroundColor(Color.GREEN);
        } else {
            textView.setBackgroundColor(Color.YELLOW);
        }

        /*
        if (position == 0) {
            textView.setText("Tweet1 : Hello World!");
        } else if(position == 1) {
            textView.setText("Tweet2: Merhaba");
        } else {
            textView.setText("Tweet3: Görusuruz");
        }
         */
    }

    @Override
    public int getItemCount() {
        return tweets.size();
    }

    public void setTweetList(List<Tweet> tweets) {
        this.tweets = tweets;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    static class TwitterViewHolder extends RecyclerView.ViewHolder {
        private TextView tweetText;

        public TwitterViewHolder(@NonNull View itemView) {
            super(itemView);
            tweetText = itemView.findViewById(R.id.text_tweet);

            /*
            tweetText.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.w(tweetText.getText().toString(), String.valueOf(getAdapterPosition()));
                }
            });

             */
        }

        public TextView getTweetText() {
            return tweetText;
        }

        public void setTweetText(TextView tweetText) {
            this.tweetText = tweetText;
        }
    }
}



/*
    1)
    ACTIVITY
    OnClickListener -> TextView

    2)
    ACTIVITY
    Activity :: onClickListener
    OnClickListener -> Adapter -> TextView
 */