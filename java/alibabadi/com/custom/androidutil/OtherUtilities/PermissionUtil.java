package alibabadi.com.custom.androidutil.OtherUtilities;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.preference.PreferenceManager;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;

/**
 * @author Ali babadi
 */

public class PermissionUtil {

    public static int REQUEST_CODE = 1010;

    public static boolean useRunTimePermissions() {
        return Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP_MR1;
    }

    public static boolean hasPermission(Activity activity, String permission) {
        if (useRunTimePermissions()) {
            return activity.checkSelfPermission(permission) == PackageManager.PERMISSION_GRANTED;
        }
        return true;
    }

    public static void requestPermission(Activity activity, String[] permissions, int requestCode) {
        if (useRunTimePermissions()) {
            activity.requestPermissions(permissions, requestCode);
        }
    }

    public static void requestPermission(Fragment fragment, String[] permissions, int requestCode) {
        if (useRunTimePermissions()) {
            fragment.requestPermissions(permissions, requestCode);
        }
    }

    public static boolean shouldShowRequestRational(Activity activity, String permission) {
        if (useRunTimePermissions()) {
            return activity.shouldShowRequestPermissionRationale(permission);
        }
        return false;
    }

    public static boolean shouldAskForPermission(Activity activity, String permission) {
        if (useRunTimePermissions()) {
            return !hasPermission(activity, permission) &&
                    (!hasAskedForPermission(activity, permission) ||
                            shouldShowRequestRational(activity, permission));
        }
        return false;
    }

    public static void goToAppSettings(Activity activity) {
        Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
                Uri.fromParts("package", activity.getPackageName(), null));
        intent.addCategory(Intent.CATEGORY_DEFAULT);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        activity.startActivity(intent);
    }

    public static boolean hasAskedForPermission(Activity activity, String permission) {
        return PreferenceManager
                .getDefaultSharedPreferences(activity)
                .getBoolean(permission, false);
    }

    public static void markedPermissionAsAsked(Activity activity, String permission) {
        PreferenceManager
                .getDefaultSharedPreferences(activity)
                .edit()
                .putBoolean(permission, true)
                .apply();
    }

    public static boolean onRequestPermissionsResult(int requestCode,
                                                  @NonNull String[] permissions,
                                                  @NonNull int[] grantResults) {
        if (REQUEST_CODE == requestCode) {
            for (int i = 0; i < permissions.length; i++) {
                if (grantResults[i] != PackageManager.PERMISSION_GRANTED) {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }

}
