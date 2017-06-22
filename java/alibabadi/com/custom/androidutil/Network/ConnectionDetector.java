package alibabadi.com.custom.androidutil.Network;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * @author Ali Babadi
 */

final public class ConnectionDetector {

    /**
     * method Detect Connection Status
     *
     * @param context Current context {@link Context}
     * @return true if Network Connection Is Available
     */

    public static boolean isConnectingToInternet(Context context) {

        boolean result = false;

        if (context != null) {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            if (connectivityManager != null) {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                result = activeNetworkInfo != null && activeNetworkInfo.isConnected();
            }
        }

        return result;
    }

}
