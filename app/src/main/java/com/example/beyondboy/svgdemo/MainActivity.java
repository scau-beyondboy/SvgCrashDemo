package com.example.beyondboy.svgdemo;

import android.graphics.drawable.PictureDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.caverock.androidsvg.SVG;
import com.caverock.androidsvg.SVGParseException;

public class MainActivity extends AppCompatActivity {
    private boolean isVisible = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            final ImageView svgImageView = (ImageView) findViewById(R.id.image);
            svgImageView.setBackgroundColor(getResources().getColor(android.R.color.black));
            SVG svg = SVG.getFromResource(this, R.raw.img_noplaylist);
            svgImageView.setLayerType(ImageView.LAYER_TYPE_SOFTWARE, null);
            svgImageView.setImageDrawable(new PictureDrawable(svg.renderToPicture()));
            findViewById(R.id.bt).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("beyondboy", "click");
                    if (isVisible) {
                        svgImageView.setVisibility(View.GONE);
                    } else {
                        svgImageView.setVisibility(View.VISIBLE);
                    }
                    isVisible = !isVisible;
                }
            });
        } catch (SVGParseException e) {
            e.printStackTrace();
        }
    }
}
