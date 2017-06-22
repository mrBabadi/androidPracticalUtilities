package alibabadi.com.custom.androidutil.ProgressDialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import alibabadi.com.custom.androidutil.R;

/**
 * @author Ali Babadi
 */

final class CustomProgressDialog extends Dialog {

    private final String DEFAULT_TEXT = "";
    private final float DEFAULT_SIZE = 15f;
    private final boolean DEFAULT_SET_CANCELABLE = true;


    private LinearLayout parentLayout;
    LinearLayout.LayoutParams linearLayoutParams;
    private TextView txtView;

    /**
     * @param ctx        required parameter for Dialog {@link Context}
     * @param themeResId dialog theme with style given {@link Integer}
     * @param view       set dialog view with view parameter given {@link View}
     *                   for example : {@link android.widget.ProgressBar}
     */

    public CustomProgressDialog(Context ctx, int themeResId, View view, int viewWidth, int viewHeight) {
        super(ctx, themeResId);
        initDialog(ctx, view, viewWidth, viewHeight);
    }


    /**
     * @param ctx  required parameter for Dialog {@link Context}
     * @param view set dialog view with view parameter given {@link View}
     *             for example : {@link android.widget.ProgressBar}
     */

    public CustomProgressDialog(Context ctx, View view, int viewWidth, int viewHeight) {
        super(ctx, R.style.TransparentProgressDialog);
        initDialog(ctx, view, viewWidth, viewHeight);
    }

    /**
     * Initialize Method for progress dialog
     *
     * @param ctx
     * @param view
     * @return an instance of {@link CustomProgressDialog}
     */

    private CustomProgressDialog initDialog(Context ctx, View view, int viewWidth, int viewHeight) {

        setTitle(null);
        setCancelable(DEFAULT_SET_CANCELABLE);
        setOnCancelListener(null);

        parentLayout = new LinearLayout(ctx);

        parentLayout.setLayoutParams(new LinearLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.MATCH_PARENT));

        parentLayout.setOrientation(LinearLayout.VERTICAL);
        parentLayout.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL);


        linearLayoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);

        txtView = new TextView(ctx);
        txtView.setGravity(Gravity.CENTER);
        /*
        default values for textView
         */
        txtView.setText(DEFAULT_TEXT);
        txtView.setTextColor(Color.WHITE);
        txtView.setTextSize(DEFAULT_SIZE);

        linearLayoutParams.gravity = Gravity.CENTER_VERTICAL;
        view.setLayoutParams(linearLayoutParams);

        parentLayout.addView(view, viewWidth, viewHeight);
        parentLayout.addView(txtView, LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

        addContentView(parentLayout, linearLayoutParams);

        return this;
    }

    /**
     * Method for setText
     *
     * @param txt {@link String}
     * @return an instance of {@link CustomProgressDialog}
     */
    CustomProgressDialog setText(String txt) {
        if (txt != null) {
            txtView.setText(txt);
        }
        return this;
    }

    /**
     * Method for set Custom font for {@link TextView} Font
     *
     * @param typeFace {@link Typeface}
     * @return @return an instance of {@link CustomProgressDialog}
     */
    CustomProgressDialog setTypeFace(Typeface typeFace) {
        if (typeFace != null) {

            try {
                txtView.setTypeface(typeFace);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return this;
    }

    /**
     * Method for set Custom txt color for {@link TextView} Text
     *
     * @param txtColor {@link String}
     * @return @return an instance of {@link CustomProgressDialog}
     */
    CustomProgressDialog setTextColor(String txtColor) {

        try {
            txtView.setTextColor(Color.parseColor(txtColor));
        } catch (Exception e) {
            txtView.setTextColor(Color.WHITE);
            e.printStackTrace();
        }
        return this;
    }

    CustomProgressDialog setTextSize(float txtSize) {
        if (txtSize > 0.f) {
            txtView.setTextSize(txtSize);
        } else {
            txtView.setTextSize(DEFAULT_SIZE);
        }
        return this;
    }

    /**
     * Method for set cancelable of dialog
     *
     * @param cancelable {@link Boolean}
     * @return @return an instance of {@link CustomProgressDialog}
     */
    public CustomProgressDialog setCancelableDialog(boolean cancelable) {
        setCancelable(cancelable);
        return this;
    }
}
