package com.android.imageloader;

import android.widget.ImageView;

public interface ImageLoader {

    void load(String url, ImageView imageView, int placeholder);

}
