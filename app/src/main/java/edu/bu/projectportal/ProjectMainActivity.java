package edu.bu.projectportal;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import 	android.support.v7.widget.Toolbar;
import android.widget.Button;

/**
 * Created by danazh on 4/24/18.
 */

public class ProjectMainActivity extends AppCompatActivity implements ProjectListAdapter.Listener {
    private Button button_favorite_list;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_main);
        button_favorite_list = (Button) findViewById(R.id.button_favorite_list);
        button_favorite_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFavorite();
            }
        });

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), AddProjectActivity.class);
                startActivity(intent);
            }
        });
    }

    private void openFavorite() {
        Intent intent = new Intent(this, FavoriteListActivity.class);
        startActivity(intent);
    }

    @Override
    public void onClick(int id, int position) {
        ProjectDetailFragment projectDetailFragment =
                (ProjectDetailFragment) getSupportFragmentManager().findFragmentById(R.id.detailfragment);
        if (projectDetailFragment != null) {
            projectDetailFragment.setProject(id);
        }

        else {
            Intent intent = new Intent(this, ProjectDetailActivity.class);
            intent.putExtra("Projectid", id);
            intent.putExtra("Projectposition", position);
            startActivity(intent);
        }

    }

}
