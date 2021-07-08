package com.example.allergy;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class MainMenuView extends LinearLayout {
    TextView mName;
    ImageView mImage;

    public MainMenuView(Context context) {
        super(context);

        init(context);
    }

    public MainMenuView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    private void init(Context context) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.mainmenu_view, this, true);

        mName = (TextView) findViewById(R.id.MenuName);
        mImage = (ImageView) findViewById(R.id.menuImage);
    }

    public void setmName(String name) { mName.setText(name); }

    public void setmImage(int resId) {mImage.setImageResource(resId); }
}
