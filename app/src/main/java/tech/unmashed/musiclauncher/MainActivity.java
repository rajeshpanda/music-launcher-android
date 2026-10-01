package tech.unmashed.musiclauncher;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MusicLauncher";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
        launchTarget();
    }

    private void launchTarget() {
        // Change this to the music player you want to be launched. See res/values/strings.xml. Add your own app if desired.
        String target = getString(R.string.RocketPlayer);
        PackageManager pm = getPackageManager();

        try {
            pm.getPackageInfo(target, 0);
            Log.d(TAG, "Target package is visible: " + target);
        } catch (PackageManager.NameNotFoundException e) {
            Log.e(TAG, "Target package NOT visible (not installed, or missing <queries> entry): " + target);
            return;
        }

        Intent launchIntent = pm.getLaunchIntentForPackage(target);
        if (launchIntent == null) {
            Log.e(TAG, "getLaunchIntentForPackage returned null for " + target
                    + " (package has no MAIN/LAUNCHER activity?)");
            return;
        }

        Log.d(TAG, "Launching " + launchIntent);
        try {
            startActivity(launchIntent);
        } catch (ActivityNotFoundException | SecurityException e) {
            Log.e(TAG, "startActivity failed for " + target, e);
        }
    }
}
