package com.example.sean.dashboardfeed;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import java.util.*;

import com.tumblr.jumblr.JumblrClient;
import com.tumblr.jumblr.types.Blog;
import com.tumblr.jumblr.types.Post;
import com.tumblr.jumblr.types.User;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initalizes the JumblrClient using the consumer key, consumer secret, oauth token, and oauth token secret
        JumblrClient client = new JumblrClient("yWa0yVJL08Nkg5iiFhASdSbIDcM8rGv58GUa45J2GsZoy1NcrP",
                                "k6sFufMPQQNfM3TvCeIsE15sc6cW2t9EKvrl80idw87oza5tQC");
        client.setToken("P71hOXuzOc2wRNIRaL2k6zjLB2Agd9BoTE3RxqqacXN8HtqE2G",
                "WmswfwYHEjEIMmH1xjVzLT3fWsf16IfR4BTwTlLApxOLgog6Ja");


        /*List<Post> dashboard_posts = client.userDashboard();
        for(Post p: dashboard_posts)
            Log.w("posts",p.getBlogName());*/
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
