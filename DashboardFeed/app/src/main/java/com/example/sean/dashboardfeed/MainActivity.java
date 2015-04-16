package com.example.sean.dashboardfeed;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.tumblr.jumblr.JumblrClient;
import com.tumblr.jumblr.types.User;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        JumblrClient client = new JumblrClient("yWa0yVJL08Nkg5iiFhASdSbIDcM8rGv58GUa45J2GsZoy1NcrP",
                                "k6sFufMPQQNfM3TvCeIsE15sc6cW2t9EKvrl80idw87oza5tQC");
        client.setToken("P71hOXuzOc2wRNIRaL2k6zjLB2Agd9BoTE3RxqqacXN8HtqE2G",
                "WmswfwYHEjEIMmH1xjVzLT3fWsf16IfR4BTwTlLApxOLgog6Ja");
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
