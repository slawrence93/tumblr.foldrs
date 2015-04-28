package com.example.sean.dashboardfeed;

import android.content.Context;
import android.database.DataSetObserver;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.*;

import com.tumblr.jumblr.JumblrClient;
import com.tumblr.jumblr.types.Blog;
import com.tumblr.jumblr.types.Post;
import com.tumblr.jumblr.types.User;


public class MainActivity extends ActionBarActivity {
    final String consumer_key = "yWa0yVJL08Nkg5iiFhASdSbIDcM8rGv58GUa45J2GsZoy1NcrP";
    final String consumer_secret = "k6sFufMPQQNfM3TvCeIsE15sc6cW2t9EKvrl80idw87oza5tQC";
    final String oauth_token = "P71hOXuzOc2wRNIRaL2k6zjLB2Agd9BoTE3RxqqacXN8HtqE2G";
    final String oauth_secret = "WmswfwYHEjEIMmH1xjVzLT3fWsf16IfR4BTwTlLApxOLgog6Ja";
    final JumblrClient client = new JumblrClient(consumer_key,consumer_secret);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        client.setToken(oauth_token,oauth_secret);
        isNetworkConnected();
        new DashboardPostsTask().execute(client);
    }

    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo ni = cm.getActiveNetworkInfo();
        if (ni == null) {
            // There are no active networks.
            Log.i("Connection","false");
            return false;
        } else
            Log.i("Connection","true");
            return true;
    }

    //lists the names of blogs that appear on dashboard
    private class DashboardPostsTask extends AsyncTask<JumblrClient,Void,Void> {
        @Override
        protected Void doInBackground(JumblrClient... params) {
            List<Post> dashboard_posts = client.userDashboard();
            List<String> blog_names = new ArrayList<>();

            for(Post p: dashboard_posts)
                blog_names.add(p.getBlogName());

            final String[] name_array = new String[blog_names.size()];
            blog_names.toArray(name_array);

            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    populateListView(name_array);
                }
            });
           // populateListView(name_array);
            return null;
        }
    }

    private void populateListView(String[] names) {
        //Build adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, //context for the activity
                R.layout.blog_names, //layout to use(create)
                names); //items to be displayed

        //Configure the list view
        ListView list = (ListView) findViewById(R.id.listView);
        list.setAdapter(adapter);
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
