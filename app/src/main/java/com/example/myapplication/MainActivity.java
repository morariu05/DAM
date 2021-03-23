package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;

import com.example.myapplication.Books.Book;
import com.example.myapplication.GridView.CourseGVAdapter;
import com.example.myapplication.GridView.CourseModal;
import com.example.myapplication.GridView.GridItemActivity;
import com.example.myapplication.Users.Autentificare;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{

    GridView gridView;
    DatabaseReference databaseReference;
    List<String> description_list;
    ArrayAdapter<String> arrayAdapter;
    Book book1;

    String[] bookAuthor = {"Tatiana de Rosnay", "John Boyne", "Markus Zusak", " Eva Schloss", "Wladyslaw Szpilman", "Joel C. Rosenberg", "Heather Morris", "Antonio G. Iturbe", " ", "Thomas Keneally"};
    String[] bookNames = {"Se numea Sarah","Băiatul cu pijamale în dungi","Hoțul de cărți","Viața după Auschwitz","Pianistul","Evadare de la Auschwitz","Tatuatorul de la Auschwitz","Bibliotecara de la Auschwitz","Jurnalul Annei Frank", "Lista lui Schindler"};
    int[] bookImages = {R.drawable.a1, R.drawable.a2, R.drawable.a3, R.drawable.a4, R.drawable.a5, R.drawable.a6, R.drawable.a7, R.drawable.a8, R.drawable.a9, R.drawable.a91};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

       gridView = findViewById(R.id.idGVcourses);

       CustomAdapter customAdapter = new CustomAdapter();
       gridView.setAdapter(customAdapter);

       databaseReference = FirebaseDatabase.getInstance().getReference("eBook");
       book1 = new Book();
       description_list = new ArrayList<>();

       arrayAdapter = new ArrayAdapter<>(this, R.layout.card_item, R.id.description_txt, bookNames);

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot d : snapshot.getChildren()) {
                    book1 = d.getValue(Book.class);
                    description_list.add(book1.getDescriere());
                }

                gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                        Intent intent = new Intent(getApplicationContext(), GridItemActivity.class);
                        intent.putExtra("image", bookImages[position]);
                        intent.putExtra("name", bookNames[position]);
                        intent.putExtra("author", bookAuthor[position]);
                        String p = description_list.get(position);
                        intent.putExtra("description", p);
                        startActivity(intent);
                    }
                });
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        // GridView

        ArrayList<CourseModal> courseModelArrayList = new ArrayList<CourseModal>();
        courseModelArrayList.add(new CourseModal("Se numea Sarah - Tatiana de Rosnay", R.drawable.a1));
        courseModelArrayList.add(new CourseModal("Băiatul cu pijamale în dungi - John Boyne", R.drawable.a2));
        courseModelArrayList.add(new CourseModal("Hoțul de cărti - Markus Zusak", R.drawable.a3));
        courseModelArrayList.add(new CourseModal("Viața după Auschwitz - Eva Schloss", R.drawable.a4));
        courseModelArrayList.add(new CourseModal("Pianistul - Wladyslaw Szpilman", R.drawable.a5));
        courseModelArrayList.add(new CourseModal("Evadare de la Auschwitz - Joel C. Rosenberg", R.drawable.a6));
        courseModelArrayList.add(new CourseModal("Tatuatorul de la Auschwitz - Heather Morris", R.drawable.a7));
        courseModelArrayList.add(new CourseModal("Bibliotecara de la Auschwitz - Antonio G. Iturbe", R.drawable.a8));
        courseModelArrayList.add(new CourseModal("Jurnalul Annei Frank", R.drawable.a9));
        courseModelArrayList.add(new CourseModal("Lista lui Schindler - Thomas Keneally", R.drawable.a91));

        CourseGVAdapter adapter = new CourseGVAdapter(this, courseModelArrayList);
        gridView.setAdapter(adapter);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    //-------------------------- log out--------------------------------

    public void log_out(MenuItem item) {
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(getApplicationContext(), Autentificare.class));
        finish();
    }



//--------------------------------------- CustomAdapter class----------------------------------------------------------
    public class CustomAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return bookImages.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view1 = getLayoutInflater().inflate(R.layout.row_data, null);

            ImageView image = view1.findViewById(R.id.images);
            TextView name = view1.findViewById(R.id.bookTitle);
            TextView author = view1.findViewById(R.id.bookAuthor);

            image.setImageResource(bookImages[position]);
            name.setText(bookNames[position]);
            author.setText(bookAuthor[position]);

            return view1;
        }
    }

}