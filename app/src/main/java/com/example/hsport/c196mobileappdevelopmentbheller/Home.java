package com.example.hsport.c196mobileappdevelopmentbheller;

import android.app.Activity;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

public class Home extends AppCompatActivity {

    private TermViewModel termViewModel;
    public static final int NEW_TERM_ACTIVITY_REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        RecyclerView recyclerView = findViewById(R.id.recycleView);
        final TermListAdapter adapter = new TermListAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        termViewModel = ViewModelProviders.of(this).get(TermViewModel.class);
        termViewModel.getAllTerms().observe(this, new Observer<List<Term>>() {
            @Override
            public void onChanged(@Nullable final List<Term> terms) {
                // Update the cached copy of the words in the adapter.
                adapter.setTerms(terms);
            }
        });
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == NEW_TERM_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK) {
            Term term = new Term();
            term.setTermName(data.getStringExtra(TermEditActivity.EXTRA_REPLY));
            term.setTermStart(data.getStringExtra(TermEditActivity.EXTRA_REPLY));
            term.setTermEnd(data.getStringExtra(TermEditActivity.EXTRA_REPLY));
            termViewModel.insert(term);
        } else {
            Toast.makeText(
                    getApplicationContext(),
                    R.string.empty_not_saved,
                    Toast.LENGTH_LONG).show();
        }
    }

    public class goToEditTerms extends Activity {
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            setContentView(R.layout.activity_home);

            final Button button = findViewById(R.id.editTermsButton);
            button.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    // Code here executes on main thread after user presses button
                    System.out.println("Go to edit terms was clicked");
                    Intent intent = new Intent(goToEditTerms.this, TermEditActivity.class);
                    startActivityForResult(intent, NEW_TERM_ACTIVITY_REQUEST_CODE);
                }
            });
        }
    }

    public class goToCourses extends Activity {
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            setContentView(R.layout.activity_home);

            final Button button = findViewById(R.id.goToCourses);
            button.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    // Code here executes on main thread after user presses button
                    System.out.println("Go to courses was clicked");
//                    Intent intent = new Intent(goToCourses.this, TermEditActivity.class);
//                    startActivityForResult(intent, NEW_TERM_ACTIVITY_REQUEST_CODE);
                }
            });
        }
    }

    public class goToAssessments extends Activity {
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            setContentView(R.layout.activity_home);

            final Button button = findViewById(R.id.goToAssessments);
            button.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    // Code here executes on main thread after user presses button
                    System.out.println("Go to assessments was clicked");
//                    Intent intent = new Intent(goToCourses.this, TermEditActivity.class);
//                    startActivityForResult(intent, NEW_TERM_ACTIVITY_REQUEST_CODE);
                }
            });
        }
    }




}
