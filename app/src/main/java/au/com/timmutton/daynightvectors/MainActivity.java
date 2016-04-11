package au.com.timmutton.daynightvectors;

import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.Toolbar;
import android.widget.CompoundButton;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final int currentNightMode = getResources().getConfiguration().uiMode
                & Configuration.UI_MODE_NIGHT_MASK;

        Switch dayNightToggle = (Switch) findViewById(R.id.toggle_day_night);
        dayNightToggle.setChecked(currentNightMode == Configuration.UI_MODE_NIGHT_YES);
        dayNightToggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                getDelegate().setLocalNightMode(isChecked ? AppCompatDelegate.MODE_NIGHT_YES : AppCompatDelegate.MODE_NIGHT_NO);
                getDelegate().applyDayNight();
                if(Build.VERSION.SDK_INT == Build.VERSION_CODES.M && currentNightMode == Configuration.UI_MODE_NIGHT_YES) {
                    Configuration config = getResources().getConfiguration();
                    config.uiMode = (config.uiMode & ~Configuration.UI_MODE_NIGHT_MASK) | Configuration.UI_MODE_NIGHT_YES;
                    getResources().updateConfiguration(config, null);
                }
                recreate();
            }
        });
    }
}
