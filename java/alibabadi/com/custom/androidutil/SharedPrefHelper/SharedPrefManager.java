package alibabadi.com.custom.androidutil.SharedPrefHelper;

/**
 * @author Ali Babadi
 */

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;

import com.google.gson.Gson;

import alibabadi.com.custom.androidutil.OtherUtilities.GsonHelper;

/**
 * complete pack of setter and getter methods for read/write to shared Preferences
 */
final public class SharedPrefManager {

    private SharedPrefManager() {
        //empty constructor
    }

    //==================================== Save String Type

    /**
     * Helper method for save a String value from {@link SharedPreferences}
     *
     * @param ctx   {@link Context}
     * @param key   {@link String}
     * @param value {@link String}
     */

    public static void setSharedPrefString(Context ctx, String key, String value) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(ctx);
        if (preferences != null && !TextUtils.isEmpty(key)) {
            SharedPreferences.Editor editor = preferences.edit();
            editor.putString(key, value);
            editor.apply();
        }
    }

    /**
     * Helper method to retrieve a String value from {@link SharedPreferences}.
     *
     * @param ctx a {@link Context}
     * @param key {@link String}
     * @return The value from shared preferences, or null if the value could not be read.
     */

    public static String getSharedPrefString(Context ctx, String key) {
        String value = null;
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(ctx);
        if (preferences != null) {
            value = preferences.getString(key, "");
        }
        return value;
    }

    //==================================== Save Integer Type

    /**
     * Helper method for save an Integer value from {@link SharedPreferences}
     *
     * @param ctx   {@link Context}
     * @param key   {@link String}
     * @param value {@link Integer}
     */

    public static void setSharedPrefInteger(Context ctx, String key, int value) {

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(ctx);
        if (preferences != null && !TextUtils.isEmpty(key)) {
            SharedPreferences.Editor editor = preferences.edit();
            editor.putInt(key, value);
            editor.apply();
        }
    }

    /**
     * Helper method to retrieve an Integer value from {@link SharedPreferences}.
     *
     * @param ctx a {@link Context}
     * @param key {@link String}
     * @return The value from shared preferences, or null if the value could not be read.
     */

    public static int getSharedPrefInteger(Context ctx, String key) {
        int value = 0;
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(ctx);
        if (preferences != null) {
            value = preferences.getInt(key, 0);
        }
        return value;
    }

    //==================================== Save Float Type

    /**
     * Helper method for save a float value from {@link SharedPreferences}
     *
     * @param ctx   {@link Context}
     * @param key   {@link String}
     * @param value {@link Float}
     */

    public static void setSharedPrefFloat(Context ctx, String key, float value) {

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(ctx);
        if (preferences != null && !TextUtils.isEmpty(key)) {
            SharedPreferences.Editor editor = preferences.edit();
            editor.putFloat(key, value);
            editor.apply();
        }
    }

    /**
     * Helper method to retrieve a float value from {@link SharedPreferences}.
     *
     * @param ctx a {@link Context}
     * @param key {@link String}
     * @return The value from shared preferences, or null if the value could not be read.
     */

    public static float getSharedPrefFloat(Context ctx, String key) {
        float value = 0f;
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(ctx);
        if (preferences != null) {
            value = preferences.getFloat(key, 0f);
        }
        return value;
    }

    //==================================== Save Long Type

    /**
     * Helper method for save a long value from {@link SharedPreferences}
     *
     * @param ctx   {@link Context}
     * @param key   {@link String}
     * @param value {@link Long}
     */

    public static void setSharedPrefLong(Context ctx, String key, long value) {

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(ctx);
        if (preferences != null && !TextUtils.isEmpty(key)) {
            SharedPreferences.Editor editor = preferences.edit();
            editor.putLong(key, value);
            editor.apply();
        }
    }

    /**
     * Helper method to retrieve a long value from {@link SharedPreferences}.
     *
     * @param ctx a {@link Context}
     * @param key {@link String}
     * @return The value from shared preferences, or null if the value could not be read.
     */

    public static long getSharedPrefLong(Context ctx, String key) {
        long value = 0L;
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(ctx);
        if (preferences != null) {
            value = preferences.getLong(key, 0L);
        }
        return value;
    }


    //==================================== Save Boolean Type

    /**
     * Helper method for save a long value from {@link SharedPreferences}
     *
     * @param ctx   {@link Context}
     * @param key   {@link String}
     * @param value {@link Boolean}
     */

    public static void setSharedPrefBoolean(Context ctx, String key, boolean value) {

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(ctx);
        if (preferences != null && !TextUtils.isEmpty(key)) {
            SharedPreferences.Editor editor = preferences.edit();
            editor.putBoolean(key, value);
            editor.apply();
        }
    }

    /**
     * Helper method to retrieve a long value from {@link SharedPreferences}.
     *
     * @param ctx a {@link Context}
     * @param key {@link String}
     * @return The value from shared preferences, or null if the value could not be read.
     */

    public static boolean getSharedPrefBoolean(Context ctx, String key) {
        boolean value = false;
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(ctx);
        if (preferences != null) {
            value = preferences.getBoolean(key, false);
        }
        return value;
    }

    //==================================== Save Object Type


    /**
     * Helper method for save a long value from {@link SharedPreferences}
     *
     * @param ctx {@link Context}
     * @param key {@link String}
     * @param obj {@link Object}
     */

    public static void setSharedPrefObject(Context ctx, String key, Object obj) {
        String jsonResult = GsonHelper.toJson(obj);

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(ctx);
        if (preferences != null && !TextUtils.isEmpty(key)) {
            SharedPreferences.Editor editor = preferences.edit();
            editor.putString(key, jsonResult);
            editor.apply();
        }
    }

    /**
     * Helper method to retrieve a long value from {@link SharedPreferences}.
     *
     * @param ctx    {@link Context}
     * @param key    {@link String}
     * @param mClass {@link Class}
     * @return The value from shared preferences (an Object) , or null if the value could not be read.
     */

    public static Object getSharedPrefObject(Context ctx, String key, Class<?> mClass) {
        Object obj = null;

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(ctx);

        if (preferences != null) {
            String jsonResult = preferences.getString(key, "");
            obj = GsonHelper.fromJson(jsonResult, mClass);
        }
        return obj;
    }


    //==================================== Remove From Pref

    /**
     * Helper method for remove value from {@link SharedPreferences}
     *
     * @param ctx {@link Context}
     * @param key {@link String}
     */

    public static void removeFromPrefs(Context ctx, String key) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(ctx);
        SharedPreferences.Editor editor = preferences.edit();
        editor.remove(key);
        editor.apply();
    }


}
