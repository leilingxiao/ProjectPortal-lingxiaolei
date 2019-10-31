package edu.bu.projectportal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import edu.bu.projectportal.database.ProjectDao;

public class AddProjectActivity extends AppCompatActivity {
    ProjectDao projectDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_project);

        projectDao = ProjectDao.getInstance(getApplicationContext());
        projectDao.openDb();
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        projectDao.closeDB();
    }

    public void onClickSubmit(View view){
        ProjectDao projectDao = ProjectDao.getInstance(getApplicationContext());
        EditText titleEditView =  (EditText)findViewById(R.id.titleEditTextId);
        String title = titleEditView.getText().toString();

        EditText descEditView= (EditText)findViewById(R.id.descEditTextId);
        String summary = descEditView.getText().toString();

        EditText authorEditView= (EditText)findViewById(R.id.authorEditTextId);
        String author = authorEditView.getText().toString();

        EditText keywordEditView= (EditText)findViewById(R.id.keywordEditTextId);
        String keyword = keywordEditView.getText().toString();

        boolean isFavorate= ((CheckBox)findViewById(R.id.checkBox_addNew)).isChecked();
        //String isFavorate = isFavorateEditView.getText().toString();

        EditText link1EditView= (EditText)findViewById(R.id.link1EditTextId);
        String link1 = link1EditView.getText().toString();

        EditText link2EditView= (EditText)findViewById(R.id.link2EditTextId);
        String link2 = link2EditView.getText().toString();

        projectDao.insertProject(new Project(title, summary,author,keyword,isFavorate,link1,link2));
        Intent intent = new Intent(this, ProjectMainActivity.class);
        startActivity(intent);
    }

    public void onClickCancel(View v){
        Intent intent = new Intent(this, ProjectMainActivity.class);
        startActivity(intent);
    }

    public void favorite_check(View v) {
        //code to check if this checkbox is checked!
        CheckBox checkBox = (CheckBox)v;
        if(checkBox.isChecked()){

        }
    }


}
