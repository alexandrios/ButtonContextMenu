package ru.example.pam.buttoncontextmenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // переменная, которая хранит кнопку, на которой вызвано контекстное меню
    private Button whoseMenu = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Кнопки
        Button firstButton = findViewById(R.id.firstButton);
        Button secondButton = findViewById(R.id.secondButton);
        Button thirdButton = findViewById(R.id.thirdButton);

        // Регистрируем кнопки для контекстного меню
        registerForContextMenu(firstButton);
        registerForContextMenu(secondButton);
        registerForContextMenu(thirdButton);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        // Добавляем пункты меню
        menu.add(Menu.NONE, 1, Menu.NONE, "Открыть");
        menu.add(Menu.NONE, 2, Menu.NONE, "Сохранить");
        menu.add(Menu.NONE, 3, Menu.NONE, "Загрузить");
        menu.add(Menu.NONE, 4, Menu.NONE, "Закрыть");

        // Сохраняем кнопку, на которой вызвано меню
        whoseMenu = (Button)v;
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        // Выводим результат
        TextView resultTextView = findViewById(R.id.resultTextView);
        resultTextView.setText(String.format("%s : %s", item.getTitle().toString(), whoseMenu.getText().toString()));
        return true;
    }
}
