package uv.edu.tarea2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Main2Activity extends Activity {
    private TextView name;
    private TextView age;
    private TextView email;

    private Button close;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        // Obtain the references to the views and assign
        // them to the attributes of this class.
        // name should reference the view with textView5 id
        // age should reference the view with textView6 id
        // email should reference the view with textView7 id
        
        // Obtain the Intent that has launched this activity
        // Using the method getIntent()

        // Extract the information (name, age and email)
        // You can use the method getStringExtra(String) of the Intent class

        // Put that information in its corresponding EditText

        // Register an event listener to the close Button so that
        // when the user clicks the activity is closed.
        // You can do this using the method finish() declared in Activity.

    }

}
