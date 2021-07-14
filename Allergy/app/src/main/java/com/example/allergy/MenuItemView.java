package com.example.allergy;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class MenuItemView extends LinearLayout {
    TextView textView;
    ImageView imageView;

    public MenuItemView(Context context) {
        super(context);

        init(context);
    }

    public MenuItemView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        init(context);
    }

    private void init(Context context) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.menu_item_view, this, true);

        textView = (TextView) findViewById(R.id.name);
        imageView = (ImageView) findViewById(R.id.image);
    }

    public void setName(String name) {
        textView.setText(name);
    }

    public void setIcon(int resId) {
        imageView.setImageResource(resId);
    }
}
