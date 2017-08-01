package com.chandan.android.contactinserter;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = (Button)findViewById(R.id.insert);
        btn.setOnClickListener(onInsert);
    }

    View.OnClickListener onInsert = new View.OnClickListener(){

        @Override
        public void onClick(View view) {
            EditText fld = (EditText)findViewById(R.id.name);
            String name = fld.getText().toString();

            fld = (EditText)findViewById(R.id.phone);

            String phone = fld.getText().toString();
            Intent i = new Intent(Intent.ACTION_INSERT_OR_EDIT);

            i.setType(ContactsContract.Contacts.CONTENT_ITEM_TYPE);
            i.putExtra(ContactsContract.Intents.Insert.NAME,name);
            i.putExtra(ContactsContract.Intents.Insert.PHONE,phone);
            startActivity(i);

        }
    };
}
