package au.com.timmutton.daynightvectors;

import android.app.Application;
import android.support.v7.app.AppCompatDelegate;

/**
 * @author timmutton
 */
public class DayNightApplication extends Application {
    static {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_AUTO);
    }
}
