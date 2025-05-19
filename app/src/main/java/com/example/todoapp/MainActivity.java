package com.example.todoapp;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import com.google.gson.Gson;
import java.lang.reflect.Type;
import com.google.gson.reflect.TypeToken;




import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.todoapp.models.Task;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText editTextTask;
    private Button buttonAdd, buttonClear;
    private ListView listViewTasks;
    private ArrayList<Task> taskList;
    private TaskAdapter taskAdapter;
    private SharedPreferences sharedPreferences;
    private static final String PREFS_NAME = "TodoListPrefs";
    private static final String TASKS_KEY = "Tasks";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        setContentView(R.layout.activity_main);

        // Binding views
        editTextTask = findViewById(R.id.editTextTask);
        buttonAdd = findViewById(R.id.buttonAdd);
        buttonClear = findViewById(R.id.buttonClear);
        listViewTasks = findViewById(R.id.listViewTasks);

        // Khởi tạo danh sách và adapter
        taskList = new ArrayList<>();
        taskAdapter = new TaskAdapter(this, taskList);
        listViewTasks.setAdapter(taskAdapter);

        // Khởi tạo SharedPreferences
        sharedPreferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        loadTasks();

        // Xử lý sự kiện nút Thêm
        buttonAdd.setOnClickListener(v -> {
            String taskName = editTextTask.getText().toString().trim();
            if (!taskName.isEmpty()) {
                taskList.add(new Task(taskName, false));
                taskAdapter.notifyDataSetChanged();
                editTextTask.setText("");
                saveTasks();
            }
        });

        // Xử lý sự kiện nút Xóa tất cả
        buttonClear.setOnClickListener(v -> {
            taskList.clear();
            taskAdapter.notifyDataSetChanged();
            saveTasks();
        });

        // Xử lý sự kiện click vào item trong ListView
        listViewTasks.setOnItemClickListener((parent, view, position, id) -> {
            Task task = taskList.get(position);
            task.setCompleted(!task.isCompleted());
            taskAdapter.notifyDataSetChanged();
            saveTasks();
        });
    }

    // Lưu danh sách công việc vào SharedPreferences
    private void saveTasks() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(taskList);
        editor.putString(TASKS_KEY, json);
        editor.apply();
    }

    // Tải danh sách công việc từ SharedPreferences
    private void loadTasks() {
        String json = sharedPreferences.getString(TASKS_KEY, null);
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<Task>>() {}.getType();
        ArrayList<Task> savedTasks = gson.fromJson(json, type);
        if (savedTasks != null) {
            taskList.addAll(savedTasks);
            taskAdapter.notifyDataSetChanged();
        }
    }
}