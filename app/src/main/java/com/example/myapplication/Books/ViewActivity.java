package com.example.myapplication.Books;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.R;
import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.listener.OnDrawListener;
import com.github.barteksc.pdfviewer.listener.OnPageChangeListener;
import com.github.barteksc.pdfviewer.listener.OnPageErrorListener;
import com.github.barteksc.pdfviewer.listener.OnRenderListener;
import com.github.barteksc.pdfviewer.listener.OnTapListener;

// Add PDF File to assets folder

public class ViewActivity extends AppCompatActivity {

    PDFView pdfView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        pdfView = findViewById(R.id.pdf_viewer);

        if(getIntent() != null)
        {
            String viewType = getIntent().getStringExtra("ViewType");
            String pdf_filename = getIntent().getStringExtra("b_name");
            Log.d("~~~~~~~~~~~~~~~~~~~~`", pdf_filename);

            if(viewType != null || !TextUtils.isEmpty(viewType))
            {
                if(viewType.equals("assets"))
                {
                    pdfView.fromAsset(pdf_filename)
                            .password(null) //if have password
                            .defaultPage(0) // Open default page
                            .enableSwipe(true)
                            .swipeHorizontal(false)
                            .enableDoubletap(true) // Double tap to zoom
                            .onDraw(new OnDrawListener() {
                                @Override
                                public void onLayerDrawn(Canvas canvas, float pageWidth, float pageHeight, int displayedPage) {
                                    // Code here if you want to do something
                                }
                            })
                            .onDrawAll(new OnDrawListener() {
                                @Override
                                public void onLayerDrawn(Canvas canvas, float pageWidth, float pageHeight, int displayedPage) {
                                    // Code here if you want to do something
                                }
                            })
                            .onPageError(new OnPageErrorListener() {
                                @Override
                                public void onPageError(int page, Throwable t) {
                                    Toast.makeText(ViewActivity.this, "Error while open page"+page, Toast.LENGTH_SHORT).show();
                                }
                            })
                            .onPageChange(new OnPageChangeListener() {
                                @Override
                                public void onPageChanged(int page, int pageCount) {
                                    // Code here if you want to do something
                                }
                            })
                            .onTap(new OnTapListener() {
                                @Override
                                public boolean onTap(MotionEvent e) {
                                    return true;
                                }
                            })
                            .onRender(new OnRenderListener() {
                                @Override
                                public void onInitiallyRendered(int nbPages, float pageWidth, float pageHeight) {
                                    pdfView.fitToWidth(); // Fixed screen size
                                }
                            })
                            .enableAnnotationRendering(true)
                            .invalidPageColor(Color.WHITE)
                            .load();
                }
            }
        }
    }
}