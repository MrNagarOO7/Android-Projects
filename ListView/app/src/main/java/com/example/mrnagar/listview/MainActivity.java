package com.example.mrnagar.listview;

import android.app.ListActivity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends ListActivity  {

    private BookAdapter bookAdapter;
    private List<Books> books;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        books = BookStore.getBooks();
        bookAdapter = new BookAdapter(this,R.layout.custom_layout,books);

        setListAdapter(bookAdapter);
        registerForContextMenu(getListView()); //listview is registered
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo menuInfo = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        int pos = menuInfo.position; // position of lonpressed item

        switch (item.getItemId()){

            case R.id.view :
                BookAdapter adapter = bookAdapter;
                Books book = adapter.getItem(pos);
                Toast.makeText(this,"Title:"+book.getTitle()+" Author:"+book.getAuthor(),Toast.LENGTH_SHORT).show();
                return true;

            case R.id.delete :
                books.remove(pos);
                bookAdapter.notifyDataSetChanged(); //after deleting have to notify to adapter // when we change list call this method
                return true;
        }
        return super.onContextItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        if(v == getListView()){
            MenuInflater menuInflater = getMenuInflater();
            menu.setHeaderTitle(R.string.more);//title pop-up menu
            menuInflater.inflate(R.menu.books,menu);
        }
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    class BookAdapter extends ArrayAdapter<Books>{

        private LayoutInflater layoutInflator;

        public BookAdapter(Context context, int textViewResourceId, List<Books> books) {
            super(context, textViewResourceId, books);
            layoutInflator = LayoutInflater.from(context);
        }


        public View getView(int position, View convertView, ViewGroup parent){
            View view= convertView;
            Books book=getItem(position);
            Holder holder=null; // hold the refrences of the views.

            if(view == null){ // check if view is nul then create otherwise use that view .not to create new view
                view=layoutInflator.inflate(R.layout.custom_layout,null); //no unnecessary views

                TextView title = (TextView) view.findViewById(R.id.Title);
                TextView author = (TextView) view.findViewById(R.id.author);

                holder = new Holder(title,author);

                view.setTag(holder);
            }
            else{
                holder = (Holder) view.getTag();
            }
                holder.author.setText(book.getAuthor());
                holder.title.setText(book.getTitle());

            return view;
        }
    }

    static class Holder{

        public TextView title;
        public TextView author;

        public Holder(TextView title,TextView author){
            this.title=title;
            this.author=author;
        }
    }
}
