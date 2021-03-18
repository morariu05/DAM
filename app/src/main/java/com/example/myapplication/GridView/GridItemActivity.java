package com.example.myapplication.GridView;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.FileDownloader;
import com.example.myapplication.MainActivity;
import com.example.myapplication.R;

import java.io.File;
import java.io.IOException;

public class GridItemActivity extends AppCompatActivity {

    private ProgressDialog pDialog;

    ImageView image;
    TextView name;
    TextView author;
    String url = "/morariu05/DAM/blob/master/";
    String numeFisier_pdf;
    String host = "https://github.com";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_item);

        image = findViewById(R.id.imageView);
        name = findViewById(R.id.griddata);
        author = findViewById(R.id.bookAuthor);

        Intent intent = getIntent();
        image.setImageResource(intent.getIntExtra("image",0));
        name.setText(intent.getStringExtra("name"));
        author.setText(intent.getStringExtra("author"));

        pDialog = new ProgressDialog(this);
        pDialog.setMessage("Please wait...");
        pDialog.setCancelable(false);
        numeFisier_pdf = name.toString() + ".pdf";
        url = host + url + numeFisier_pdf;
    }


    public void downloadPDF(View v)
    {
        new DownloadFile().execute(url, numeFisier_pdf);
       // new DownloadFile().execute("https://github.com/morariu05/DAM/blob/master/Sarah.pdf", "Sarah.pdf");
    }

    public void viewPDF(View v)
    {
        File pdfFile = new File(Environment.getExternalStorageDirectory() + "https://github.com/morariu05/DAM/blob/master/" + "Sarah.pdf");  // -> filename = maven.pdf
        Uri path = Uri.fromFile(pdfFile);
        Intent pdfIntent = new Intent(Intent.ACTION_VIEW);
        pdfIntent.setDataAndType(path, "application/pdf");
        pdfIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        try{
            startActivity(pdfIntent);
        }catch(ActivityNotFoundException e){
            Toast.makeText(GridItemActivity.this, "No Application available to view PDF", Toast.LENGTH_SHORT).show();
        }
    }

    private class DownloadFile extends AsyncTask<String, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            showpDialog();
        }

        @Override
        protected Void doInBackground(String... strings) {

            String fileUrl = strings[0];
// -> https://letuscsolutions.files.wordpress.com/2015/07/five-point-someone-chetan-bhagat_ebook.pdf
            String fileName = strings[1];
// ->five-point-someone-chetan-bhagat_ebook.pdf
            //String extStorageDirectory = Environment.getExternalStorageDirectory().toString();

            String extStorageDirectory = Environment.getExternalStorageDirectory().toString();
            File folder = new File(extStorageDirectory, "DOWNLOAD_DIRECTORY");
            folder.mkdir();

            File pdfFile = new File(folder, fileName);

            try{
                pdfFile.createNewFile();
            }catch (IOException e){
                e.printStackTrace();
            }
            FileDownloader.downloadFile(fileUrl, pdfFile);
            return null;

        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            hidepDialog();
            Toast.makeText(getApplicationContext(), "Download PDf successfully", Toast.LENGTH_SHORT).show();

            Log.d("Download complete", "----------");
        }
    }


    private void showpDialog() {
        if (!pDialog.isShowing())
            pDialog.show();
    }

    private void hidepDialog() {
        if (pDialog.isShowing())
            pDialog.dismiss();
    }

}