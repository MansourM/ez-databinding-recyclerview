package ir.masterz.mansour.ez.databinding.recyclerview.adapter;

import android.net.Uri;
import android.text.Spanned;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class DataBindingUtils {

    private static RequestOptions getRequestOptions() {
        return new RequestOptions()
                .placeholder(R.drawable.no_image)
                .error(R.drawable.no_image);
    }

    @BindingAdapter("imageResource")
    public static void setImageResource(ImageView view, int imageResource) {
        Glide.with(view.getContext())
                .setDefaultRequestOptions(getRequestOptions())
                .load(imageResource)
                .into(view);
    }

    @BindingAdapter("imageUrl")
    public static void setimageUrl(ImageView view, String imageResource) {
        Glide.with(view.getContext())
                .setDefaultRequestOptions(getRequestOptions())
                .load(imageResource)
                .into(view);
    }

    //Like project assets
    //e.g. path = "file:///android_asset" + localPath;
    @BindingAdapter("localResource")
    public static void setDBImageResource(ImageView view, String localPath) {
        Glide.with(view.getContext())
                .load(Uri.parse(localPath))
                .into(view);
    }

    //colorCode like white = "#ffffff"
    public static Spanned coloredSpannedText(String text, String colorCode) {
        return coloredSpannedText(text, colorCode);
    }

}
