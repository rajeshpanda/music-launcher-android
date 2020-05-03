package tech.unmashed.musiclauncher;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    Intent launchIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        this.launchIntent = getPackageManager().getLaunchIntentForPackage("com.google.android.apps.youtube.music"); // replace with your intended app
//        this.launchIntent = getPackageManager().getLaunchIntentForPackage("com.apple.android.music");
        if (this.launchIntent != null) {
            startActivity(this.launchIntent);//null pointer check in case package name was not found
        }
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();

        if (this.launchIntent == null) {
            this.launchIntent = getPackageManager().getLaunchIntentForPackage("com.google.android.apps.youtube.music");
//            this.launchIntent = getPackageManager().getLaunchIntentForPackage("com.apple.android.music");// replace with your intended app
        }

        if (this.launchIntent != null) {
            startActivity(this.launchIntent);//null pointer check in case package name was not found
        }
    }
}
