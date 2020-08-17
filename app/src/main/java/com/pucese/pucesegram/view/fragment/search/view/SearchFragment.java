package com.pucese.pucesegram.view.fragment.search.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.pucese.pucesegram.R;
import com.pucese.pucesegram.adapter.PictureAdapterRecyclerView;
import com.pucese.pucesegram.model.Picture;
import com.pucese.pucesegram.view.fragment.search.presenter.SearchPresenter;
import com.pucese.pucesegram.view.fragment.search.presenter.SearchPresenterImpl;

import java.util.ArrayList;

public class SearchFragment extends Fragment implements SearchView {

    EditText etBuscador;
    RecyclerView picturesRecycler;
    PictureAdapterRecyclerView pictureAdapterRecyclerView;
    ArrayList<Picture> pictures;
    GridLayoutManager linearLayoutManager;

    private SearchPresenter presenter;

    public SearchFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_search,container,false);

        presenter = new SearchPresenterImpl(this);

        picturesRecycler=(RecyclerView) view.findViewById(R.id.search_recyclerview_photos);

        etBuscador = view.findViewById(R.id.etBuscador);

        linearLayoutManager=new GridLayoutManager(getContext(),2);

        picturesRecycler.setLayoutManager(linearLayoutManager);
        pictureAdapterRecyclerView=new PictureAdapterRecyclerView(presenter.buidPictures(pictures),R.layout.cardview_picture,getActivity() );
        picturesRecycler.setAdapter(pictureAdapterRecyclerView);


        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        etBuscador.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                presenter.filtrar(s.toString(),pictureAdapterRecyclerView, pictures);
            }
        });
    }

}