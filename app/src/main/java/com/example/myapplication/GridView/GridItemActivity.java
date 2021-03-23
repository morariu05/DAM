package com.example.myapplication.GridView;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.Books.ViewActivity;
import com.example.myapplication.R;

public class GridItemActivity extends AppCompatActivity {

    ImageView image;
    TextView name;
    TextView author;
    TextView description;
    Button btn_open_assets;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_item);

        image = findViewById(R.id.imageView);
        name = findViewById(R.id.griddata);
        author = findViewById(R.id.bookAuthor);
        description = findViewById(R.id.description_txt);
        btn_open_assets = findViewById(R.id.btn_open_assets);

        Intent intent = getIntent();
        image.setImageResource(intent.getIntExtra("image", 0));
        name.setText(intent.getStringExtra("name"));
        author.setText(intent.getStringExtra("author"));
        description.setText(intent.getStringExtra("description"));

        btn_open_assets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Intent intent = new Intent(GridItemActivity.this, ViewActivity.class);
                String pdf_filename =  name.getText().toString().trim() + ".pdf";
                intent.putExtra("ViewType", "assets");
                intent.putExtra("b_name", pdf_filename);
                startActivity(intent);
                Log.d("n****************", pdf_filename);
            }
        });
    }
}