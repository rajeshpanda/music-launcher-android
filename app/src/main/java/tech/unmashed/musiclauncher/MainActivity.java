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


        this.launchIntent = getPackageManager().getLaunchIntentForPackage(getString(R.string.target_app));
        if (this.launchIntent != null) {
            startActivity(this.launchIntent);
        }
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();

        if (this.launchIntent == null) {
            this.launchIntent = getPackageManager().getLaunchIntentForPackage(getString(R.string.target_app));
        }

        if (this.launchIntent != null) {
            startActivity(this.launchIntent);
        }
    }
}
