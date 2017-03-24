package app.iecs.fcu.android_hw2;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View.OnClickListener;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //物件宣告
    TextView tital;
    Button submit;
    EditText input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //物件指向宣告
        input = (EditText)findViewById(R.id.et_01);
        submit = (Button)findViewById(R.id.bt_01);

        submit.setOnClickListener(calcResult); //submit設定OnClickListener

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    private OnClickListener calcResult = new OnClickListener(){
        @Override
        public void onClick(View v){
            String input_str=input.getText().toString(); //取得input內的字串
            input.setText(""); //將input的text清空
            Toast.makeText(MainActivity.this, "Hello "+input_str, Toast.LENGTH_SHORT).show();
            return;
        }
    };

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
        switch(item.getItemId()){
            case R.id.action_about:
                AlertDialog.Builder ad = new AlertDialog.Builder(this);
                ad.setTitle("About This App");
                ad.setMessage("Author: D0486467賴傳安");
                DialogInterface.OnClickListener menu_about_listener = new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                };
                ad.setPositiveButton("確定",menu_about_listener);
                ad.show();
                break;
            case R.id.action_reset:
                Toast.makeText(MainActivity.this, "EditText has been reset.", Toast.LENGTH_SHORT).show();
                input.setText("");
                /*DialogInterface.OnClickListener menu_reset_listener = new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "EditText has been reset.", Toast.LENGTH_SHORT).show();
                        input.setText("");
                    }
                };*/
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
