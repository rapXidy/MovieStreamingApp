package com.chidii.mymovies.UI;

import android.app.ActivityOptions;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.Toast;

import com.chidii.mymovies.Models.Movie;
import com.chidii.mymovies.Adapters.MovieAdapter;
import com.chidii.mymovies.Adapters.MovieItemClickListener;
import com.chidii.mymovies.R;
import com.chidii.mymovies.Models.Slide;
import com.chidii.mymovies.Adapters.SliderPagerAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class HomeActivity extends AppCompatActivity implements MovieItemClickListener {

    private List<Slide> lstSlides;
    private ViewPager sliderpager;
    private TabLayout indicator;
    private RecyclerView MoviesRV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        sliderpager = findViewById(R.id.slider_pager);
        indicator = findViewById(R.id.indicator);
        MoviesRV = findViewById(R.id.Rv_movies);

        //prepare a list of slides
        lstSlides = new ArrayList<>();
        lstSlides.add(new Slide(R.drawable.avengers_movie, "Avengers:End Game \nThe Begining of the End \t2019"));
        lstSlides.add(new Slide(R.drawable.silence_movie, "The Silence \nSilence isn't always golden \t2019"));
        lstSlides.add(new Slide(R.drawable.spider_man_movie, "Spiderman: Homecoming \nhomeComing of the Spider king \t2019"));
        lstSlides.add(new Slide(R.drawable.someone_great_movie, "Someone Great \nIs This person Really great? \t2019"));

        SliderPagerAdapter adapter = new SliderPagerAdapter(this,lstSlides);

        sliderpager.setAdapter(adapter);

        //setup timer for the viewPager items
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new HomeActivity.SliderTimer(), 2000, 4000);

        indicator.setupWithViewPager(sliderpager, true);

        // RecyclerView setUp
        //init data


        List<Movie> lstMovies = new ArrayList<>();
        lstMovies.add(new Movie("Ten Things I Hate About You", R.drawable.tenthings_i_hate_movie, R.drawable.tenthings_i_hate_movie));
        lstMovies.add(new Movie("She's All That", R.drawable.shes_all_that, R.drawable.shes_all_that));
        lstMovies.add(new Movie("She's The Man", R.drawable.shesd_man_movie, R.drawable.shesd_man_movie));
        lstMovies.add(new Movie("Twilight", R.drawable.twilight_movie, R.drawable.twilight_movie));
        lstMovies.add(new Movie("iron King", R.drawable.screenshot_iron_man, R.drawable.screenshot_iron_man));
        lstMovies.add(new Movie("Mean Girls", R.drawable.meangirls_movie, R.drawable.meangirls_movie));
        lstMovies.add(new Movie("How To Lose A guy in 10 Days", R.drawable.howto_lose_aguy_movie, R.drawable.howto_lose_aguy_movie));
        lstMovies.add(new Movie("Easy A", R.drawable.easy_a_movie, R.drawable.easy_a_movie));

        MovieAdapter movieAdapter = new MovieAdapter(this, lstMovies, this);
        MoviesRV.setAdapter(movieAdapter);
        MoviesRV.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

    }

    @Override
    public void onMovieClick(Movie movie, ImageView movieImageView) {
    // here we send movie information to detail activity
        // also we will create the transition animation btw the two activities

        Intent intent = new Intent(this,MovieDetailActivity.class);
        // send movie info to the movieDetailActivity
        intent.putExtra("title",movie.getTitle());
        intent.putExtra("imgURL",movie.getThumbnail());
        intent.putExtra("imgCover",movie.getCoverPhoto());

        //lets create the animation
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(HomeActivity.this,
                                    movieImageView, "sharedName");

        startActivity(intent, options.toBundle());

        //i will make a simple test to see if the click works

        Toast.makeText(this, "item clicked: "+ movie.getTitle(), Toast.LENGTH_SHORT).show();


    }

    class SliderTimer extends TimerTask {

        @Override
        public void run() {

            HomeActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (sliderpager.getCurrentItem()<lstSlides.size()-1) {
                        sliderpager.setCurrentItem(sliderpager.getCurrentItem()+1);
                    }
                    else
                        sliderpager.setCurrentItem(0);
                }
            });
        }
    }
}
