package com.nnems.gads2020leaderboardapp.activities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.nnems.gads2020leaderboardapp.R;
import com.nnems.gads2020leaderboardapp.api.GoogleFormApi;
import com.nnems.gads2020leaderboardapp.api.LeaderboardApi;
import com.nnems.gads2020leaderboardapp.models.Project;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SubmitActivity extends AppCompatActivity {

    private EditText firstnameTV, lastnameTV, emailTV, projectlinkTV;
    private Button submit;
    private ImageView back_buttonIV;
    private GoogleFormApi mGoogleFormApi;
    private String mFirstname, mLastname , mEmail ,mProjectlink;

    private AlertDialog.Builder mDialog;

    private AlertDialog mShow;
    private Retrofit mRetrofit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit);

        firstnameTV = findViewById(R.id.text_firstname);
        lastnameTV = findViewById(R.id.text_lastname);
        emailTV = findViewById(R.id.text_email);
        projectlinkTV = findViewById(R.id.text_github_project_link);
        submit = findViewById(R.id.button_submit);

        back_buttonIV = findViewById(R.id.back_button);

        back_buttonIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mFirstname = firstnameTV.getText().toString();
                mLastname = lastnameTV.getText().toString();
                mEmail = emailTV.getText().toString();
                mProjectlink = projectlinkTV.getText().toString();

                Log.d("Project ",mFirstname+"\n"+ mLastname+"\n"+mEmail+"\n"+mProjectlink);

                addPost();


            }
        });




    }

    private void addPost() {

        mDialog = new AlertDialog.Builder(SubmitActivity.this);
        mShow = mDialog.create();
        LayoutInflater inflater = getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.confirm_submit, null);
        mDialog.setView(dialogView);

        ImageView cancel = dialogView.findViewById(R.id.cancel_imageview);
        Button confirm_yes = dialogView.findViewById(R.id.button_yes);

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mShow.cancel();
            }
        });
        mShow = mDialog.show();



        confirm_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mShow.cancel();

                mRetrofit = new Retrofit.Builder()
                        .baseUrl(GoogleFormApi.BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                mGoogleFormApi = mRetrofit.create(GoogleFormApi.class);
                Call<Void> call = mGoogleFormApi.addProject(mFirstname,mLastname,mEmail,mProjectlink);

                call.enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {

                        Log.d("Response Code ", String.valueOf(response.code()));

                        if(!response.isSuccessful()){

                            mDialog = new AlertDialog.Builder(SubmitActivity.this);
                            mShow = mDialog.create();
                            LayoutInflater inflater = getLayoutInflater();
                            final View dialogView = inflater.inflate(R.layout.submit_failure, null);
                            mDialog.setView(dialogView);
                            mShow = mDialog.show();

                        }
                        else
                        {

                            mDialog = new AlertDialog.Builder(SubmitActivity.this);
                            mShow = mDialog.create();
                            LayoutInflater inflater = getLayoutInflater();
                            final View dialogView = inflater.inflate(R.layout.submit_success, null);
                            mDialog.setView(dialogView);
                            mShow = mDialog.show();
                        }

                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {
                        Toast.makeText(SubmitActivity.this, "Error: "+ t.getMessage(),Toast.LENGTH_SHORT).show();
                        Log.d("throwable: ", t.getMessage());
                    }
                });


            }
        });

    }

}