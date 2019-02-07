package uv.edu.tarea2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {
    private EditText name;
    private EditText age;
    private EditText email;
    private Button send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Obtain references to the views using findViewById
        // Assign them to this class attributes
        // name must reference the EditText with editText id
        // age must reference the EditText with editText2 id
        // email must reference the EditText with editText3 id 
        
        // Assign a event listener to the button "send"
        //    When the button is clicked activity Main2Activity must
        //    be started using an explicit intent.
        //    We are using the intent to pass information to the other activity.
        //    The intent must contain the name, the age and the email.
        //    You can use the method putExtra(String,String) of the Intent
        //    class to add that information.        
    }
}
