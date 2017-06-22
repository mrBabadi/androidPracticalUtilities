package alibabadi.com.custom.androidutil.OtherUtilities;

import android.util.Log;

import com.google.gson.Gson;

import java.lang.reflect.Type;

/**
 * @author Ali Babadi 6/21/2017
 */

@SuppressWarnings("unused")
public final class GsonHelper {

    private static Boolean isGsonAvailable;
    private static Object gsonObj;

    public static boolean isGsonAvailable() {

        if (isGsonAvailable == null) {
            try {
                Class.forName("com.google.gson.Gson");
                isGsonAvailable = true;
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                isGsonAvailable = false;
            }
        }
        return isGsonAvailable;
    }

    public static Gson getGsonInstance() {
        if (gsonObj == null) {
            gsonObj = new Gson();
        }
        return (Gson) gsonObj;
    }

    public static String toJson(Object obj) {
        try {
            return obj == null ? null : getGsonInstance().toJson(obj);
        } catch (Exception e) {
            Log.e("GsonHelper", "Cannot convert object to JSON", e);
            return null;
        }
    }

    public static <T> T fromJson(String str, Class<T> clazz) {
        return fromJson(str, (Type) clazz);
    }

    @SuppressWarnings("unchecked")
    public static <T> T fromJson(String str, Type type) {
        try {
            return str == null ? null : (T) getGsonInstance().fromJson(str, type);
        } catch (Exception e) {
            Log.e("GsonHelper", "Cannot parse JSON to object", e);
            return null;
        }
    }
}
