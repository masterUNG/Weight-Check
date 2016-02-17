package appewtc.masterung.weightcheck;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    //Explicit
    private MyManage objMyManage;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Request Database
        objMyManage = new MyManage(this);

        //Check Register
        checkRegister();



    }   // Main Method

    private void checkRegister() {

        SQLiteDatabase objSqLiteDatabase = openOrCreateDatabase(MyOpenHelper.database_name,
                MODE_PRIVATE, null);

        Cursor objCursor = objSqLiteDatabase.rawQuery("SELECT * FROM userTABLE", null);

        if (objCursor.getCount() == 0) {

            Intent objIntent = new Intent(MainActivity.this, RegisterActivity.class);
            startActivity(objIntent);

        }   //if
        objCursor.close();

    }   // checkRegister

}   // Main Class










