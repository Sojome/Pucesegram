package com.pucese.pucesegram.picturedetail.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.transition.Fade;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.pucese.pucesegram.R;
import com.pucese.pucesegram.picturedetail.presenter.PictureDetailPresenter;
import com.pucese.pucesegram.picturedetail.presenter.PictureDetailPresenterImpl;
import com.squareup.picasso.Picasso;

public class PictureDetailActivity extends AppCompatActivity implements PictureDetailView
{
    private ImageView imageHeader;
    private TextView nombreT;
    private TextView likeNumberDetail;
    private TextView tituloT;
    private TextView textContentImageDetail;
    private PictureDetailPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture_detail);
        showToolbar(" ",true);



        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP)
        {
            getWindow().setEnterTransition(new Fade());
        }

        imageHeader= findViewById(R.id.imageHeader);
        nombreT = findViewById(R.id.userNameDetail);
        likeNumberDetail = findViewById(R.id.likeNumberDetail);
        tituloT = findViewById(R.id.titleImage);
        textContentImageDetail = findViewById(R.id.textContentImageDetail);

    }

    @Override
    protected void onStart() {
        super.onStart();
        Intent i = getIntent();

        presenter = new PictureDetailPresenterImpl(this);

        presenter.setInformation(i);
    }

    public void showToolbar(String tittle, boolean upButton)
    {
        Toolbar toolbar=(Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(tittle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);
        CollapsingToolbarLayout collapsingToolbarLayout=(CollapsingToolbarLayout)findViewById(R.id.collapsingToolbar);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });
    }

    @Override
    public void setImage(String txt) {
        Picasso.get().load(txt).into(imageHeader);
    }

    @Override
    public void setNombre(String txt) {
        nombreT.setText(txt);
    }

    @Override
    public void setLikeNumber(String txt) {
        likeNumberDetail.setText(txt);
    }

    @Override
    public void setTitulo(String txt) {
        tituloT.setText(txt);
    }

    @Override
    public void setDetail(String txt) {
        textContentImageDetail.setText(txt);
    }
}