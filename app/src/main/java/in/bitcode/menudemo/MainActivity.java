package in.bitcode.menudemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private CheckBox chkSettings;
    private TextView txtInfo;
    private EditText edtInfo;

    private String text;

    private final int MENU_INFO = 1, MENU_HELP = 2, MENU_SETTINGS = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chkSettings = findViewById(R.id.chkSettings);
        txtInfo = findViewById(R.id.txtInfo);
        edtInfo = findViewById(R.id.edtInfo);

        registerForContextMenu(txtInfo);
        registerForContextMenu(edtInfo);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        mt("onCreateOptionsMenu");

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_activity, menu);

        /*menu.add(0, MENU_INFO, 0, "Info");

        MenuItem item = menu.add(0, MENU_HELP, 0, "Help");
        item.setIcon(R.mipmap.ic_launcher);
        item.setCheckable(true);
        item.setChecked(true);
        item.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);

        item.setAlphabeticShortcut('h');
        item.setNumericShortcut('9');
        item.setEnabled(true);

        SubMenu subMenu = menu.addSubMenu(0, MENU_SETTINGS, 0, "Settings");
        subMenu.add(0, 11, 0, "Phone Settings");
        subMenu.add(0, 12, 0, "Profile Settings");
        //menu.setGroupDividerEnabled(true);*/

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View view, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, view, menuInfo);

        mt("onCreateContentMenu");

        if(view == txtInfo) {
            menu.add(0, 100, 0, "Paste");
            menu.add(0, 101, 0, "Append");
        }
        if(view == edtInfo) {
            menu.add(1, 200, 0, "Copy");
            menu.add(1, 201, 0, "Cut");
        }
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == 200) {
            text = edtInfo.getText().toString();
        }
        if(item.getItemId() == 201) {
            text = edtInfo.getText().toString();
            edtInfo.setText("");
        }
        if(item.getItemId() == 100) {
            txtInfo.setText(text);
        }
        if(item.getItemId() == 101) {
            txtInfo.append(text);
        }
        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        mt("onPrepareOptionsMenu");
        if(chkSettings.isChecked()) {
            //MenuItem menuItem = menu.findItem(3);
            MenuItem menuItem = menu.findItem(R.id.menuSettings);
            menuItem.setEnabled(true);
        }
        else {
            //menu.findItem(3).setEnabled(false);
            menu.findItem(R.id.menuSettings).setEnabled(false);
        }
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        /*switch (item.getItemId()) {
            case MENU_INFO:
                mt("Info selected");
                break;
            case MENU_HELP:
                mt("Help selected");
                break;
            case MENU_SETTINGS:
                mt("Settings selected");
                break;
            case 11:
                mt("Phone settings selected");
                break;
            case 12:
                mt("Profile Settings selected");
                break;

        }*/
        if(item.getItemId() == R.id.menuInfo) {

        }
        mt("Selected: " + item.getTitle());
        return super.onOptionsItemSelected(item);
    }

    private void mt(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }
}