package com.example.immunityhealth.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.immunityhealth.ArticleAdapter;
import com.example.immunityhealth.ArticleContent;
import com.example.immunityhealth.R;
import com.example.immunityhealth.VideoDataUtil;

import java.util.ArrayList;


public class ArticlesFragment extends Fragment {

    RecyclerView rvContent;
    LinearLayoutManager manager;
    ArticleAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_articles, container, false);
        VideoDataUtil video = (VideoDataUtil) getActivity().getIntent().getSerializableExtra("video");
        ArrayList<ArticleContent> contents = video.getData();
        rvContent = v.findViewById(R.id.article_recommended);
        rvContent.setLayoutManager(new LinearLayoutManager(getContext()));
        rvContent.setAdapter(new ArticleAdapter(contents, getContext()));
        return v;
    }
}