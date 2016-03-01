package au.com.timmutton.daynightvectors;

import android.app.Application;
import android.app.UiModeManager;
import android.content.Context;
import android.support.v7.app.AppCompatDelegate;

/**
 * @author timmutton
 */
public class DayNightApplication extends Application {
    static {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_AUTO);
    }

    @Override
    public void onCreate() {
        super.onCreate();

        // add this code for 6.0
        UiModeManager uiManager = (UiModeManager) getSystemService(Context.UI_MODE_SERVICE);
        uiManager.setNightMode(UiModeManager.MODE_NIGHT_AUTO);
    }
}
