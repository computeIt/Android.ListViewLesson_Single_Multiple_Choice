package com.example.addy.listviewlesson;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    final String LOG = "myLog";

    ListView listView;
    String[] names;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        //режим выбора пунктов списка
//        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.names,
//                android.R.layout.simple_list_item_single_choice);
                android.R.layout.simple_list_item_multiple_choice);
        listView.setAdapter(adapter);

        Button btnChecked = findViewById(R.id.btnChecked);
        btnChecked.setOnClickListener(this);

        names = getResources().getStringArray(R.array.names);

    }

    @Override
    public void onClick(View v) {
//        Log.d(LOG, "checked: " + names[listView.getCheckedItemPosition()]); - для режима одинарного выбора ListView.CHOICE_MODE_SINGLE
        Log.d(LOG, "checked: ");
        SparseBooleanArray sbArray = listView.getCheckedItemPositions();
        for (int i = 0; i < sbArray.size(); i++) {
            int key = sbArray.keyAt(i);
            if (sbArray.get(key))
                Log.d(LOG, names[key]);
        }

    }
}
