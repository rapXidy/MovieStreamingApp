package com.chidii.mymovies.UI;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.chidii.mymovies.Adapters.CastAdapter;
import com.chidii.mymovies.Models.Cast;
import com.chidii.mymovies.R;

import java.util.ArrayList;
import java.util.List;

public class MovieDetailActivity extends AppCompatActivity {

    private ImageView MovieThunbnailImg, MovieCoverImg;
    private TextView tv_title, tv_description;
    private FloatingActionButton play_fab;
    private RecyclerView RvCast;
    private CastAdapter castAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        //initialize Views
        initViews();
        
        //setup list cast
        setupRvCast();



    }

    void setupRvCast() {

        List<Cast> mData = new ArrayList<>();
        mData.add(new Cast("cast one", R.drawable.cast_one));
        mData.add(new Cast("cast two", R.drawable.cast_2));
        mData.add(new Cast("cast one", R.drawable.cast_4));
        mData.add(new Cast("cast one", R.drawable.cast_6));
        mData.add(new Cast("cast one", R.drawable.cast_4));
        mData.add(new Cast("cast one", R.drawable.cast_one));

        castAdapter = new CastAdapter(this, mData);
        RvCast.setAdapter(castAdapter);
        RvCast.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
    }

    void initViews() {
        RvCast = findViewById(R.id.rv_cast);
        play_fab = findViewById(R.id.play_fab);
        String movieTitle = getIntent().getExtras().getString("title");
        int imageResourceId = getIntent().getExtras().getInt("imgURL");
        int imagecover = getIntent().getExtras().getInt("imgCover");
        MovieThunbnailImg = findViewById(R.id.detail_movie_img);
        Glide.with(this).load(imageResourceId).into(MovieThunbnailImg);
        MovieThunbnailImg.setImageResource(imageResourceId);
        MovieCoverImg = findViewById(R.id.detail_movie_img);
        Glide.with(this).load(imagecover).into(MovieCoverImg);
        tv_title = findViewById(R.id.detail_movie_title);
        tv_title.setText(movieTitle);
        getSupportActionBar().setTitle(movieTitle);
        tv_description = findViewById(R.id.detail_movie_desc);
        //setup animation
        MovieCoverImg.setAnimation(AnimationUtils.loadAnimation(this, R.anim.scale_animation));
        play_fab  .setAnimation(AnimationUtils.loadAnimation(this, R.anim.scale_animation));

    }

}
