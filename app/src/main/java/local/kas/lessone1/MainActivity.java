package local.kas.lessone1;

// 1. Создать проект со следующими пользовательскими элементами: TextView, EditText, Button, Switch,
// CheckBox, ToggleButton. Для работы использовать LinearLayout. Использовать различные шрифты,
// цвета, размеры, прочие атрибуты.

// 2. Создать ещё один макет (если не получается, то проект) с несколькими EditText, где
// использовать атрибут inputType: text, textPersonName, phone, number, textPassword,
// textEmailAddress и другие значения.

// 3. Добавить в проект элемент CalendarView.

// 4. * Разобраться, что такое параметр ems.

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.text.format.DateUtils;
import android.view.View;
import android.widget.Button;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    Calendar calendar;
    Button btnCalendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnCalendar = findViewById(R.id.btnCalendar);
        btnCalendar.setOnClickListener(this::showCalendar);
        createCalendar();
    }

    private void createCalendar() {
        calendar = Calendar.getInstance();
        long timeInMillis = calendar.getTimeInMillis();
        btnCalendar.setText(
                DateUtils.formatDateTime(
                        this,
                        timeInMillis,
                        DateUtils.FORMAT_SHOW_DATE | DateUtils.FORMAT_SHOW_YEAR
                )
        );
    }

    public void showCalendar(View v) {
        new DatePickerDialog(
                this, setDate,
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH))
                .show();
    }

    DatePickerDialog.OnDateSetListener setDate = (view, year, monthOfYear, dayOfMonth) -> {
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, monthOfYear);
        calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        setInitialDate();
    };

    private void setInitialDate() {
        long calendarTime = calendar.getTimeInMillis();
        String calendarDateS = DateUtils.formatDateTime(this,
                calendarTime, DateUtils.FORMAT_SHOW_DATE | DateUtils.FORMAT_SHOW_YEAR);
        btnCalendar.setText(calendarDateS);
    }
}