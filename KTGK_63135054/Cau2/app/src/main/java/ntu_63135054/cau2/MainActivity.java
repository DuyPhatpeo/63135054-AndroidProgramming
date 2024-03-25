package ntu_63135054.cau2;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    // Khai báo các biến
    private EditText noteEditText;
    private ListView noteListView;
    private ArrayList<String> noteList;
    private ArrayAdapter<String> noteAdapter;
    private int selectedNoteIndex = -1; // chỉ số của ghi chú được chọn
    private SharedPreferences sharedPreferences; // lưu trữ danh sách ghi chú

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Ánh xạ các thành phần UI từ layout XML
        noteEditText = findViewById(R.id.noteEditText);
        noteListView = findViewById(R.id.noteListView);
        Button addNoteButton = findViewById(R.id.addNoteButton);

        // Khởi tạo danh sách ghi chú và adapter
        noteList = new ArrayList<>();
        noteAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, noteList);
        noteListView.setAdapter(noteAdapter);

        // Lấy SharedPreferences để lưu trữ ghi chú
        sharedPreferences = getSharedPreferences("notes", Context.MODE_PRIVATE);

        // Load danh sách ghi chú từ lưu trữ
        loadNotesFromStorage();

        // Xử lý sự kiện khi nhấn nút "Add Note"
        addNoteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNote();
            }
        });

        // Xử lý sự kiện khi nhấn vào một ghi chú trong danh sách
        noteListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectedNoteIndex = position;
                editNote();
            }
        });

        // Xử lý sự kiện khi giữ lâu vào một ghi chú trong danh sách
        noteListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                selectedNoteIndex = position;
                deleteAndSaveNote(); // Gọi phương thức mới để xóa và lưu ghi chú
                return true;
            }
        });
    }

    // Phương thức để thêm ghi chú mới vào danh sách
    private void addNote() {
        String note = noteEditText.getText().toString().trim();
        if (!note.isEmpty()) {
            noteList.add(note);
            noteAdapter.notifyDataSetChanged();
            noteEditText.getText().clear();
            saveNotesToStorage(); // Lưu ghi chú vào SharedPreferences sau khi thêm mới
        }
    }

    // Phương thức để chỉnh sửa ghi chú đã có trong danh sách
    private void editNote() {
        if (selectedNoteIndex != -1) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Edit Note");
            final EditText input = new EditText(this);
            input.setText(noteList.get(selectedNoteIndex));
            builder.setView(input);

            builder.setPositiveButton("Save", (dialog, which) -> {
                String editedNote = input.getText().toString().trim();
                if (!editedNote.isEmpty()) {
                    noteList.set(selectedNoteIndex, editedNote);
                    noteAdapter.notifyDataSetChanged();
                    saveNotesToStorage(); // Lưu ghi chú sau khi chỉnh sửa
                }
            });

            builder.setNegativeButton("Cancel", (dialog, which) -> dialog.cancel());

            builder.show();
        }
    }

    
}