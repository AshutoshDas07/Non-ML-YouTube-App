package com.example.immunityhealth.ui.main;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.immunityhealth.R;
import com.example.immunityhealth.RecVideoAdapter;
import com.example.immunityhealth.VideoDataUtil;


public class VideosFragment extends Fragment {
    private String url;
    private TextView textView;
    private WebView webView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_videos, container, false);
        VideoDataUtil video = (VideoDataUtil) getActivity().getIntent().getSerializableExtra("video");
        url = video.getUrl();
        url = url.split("=")[1];
        Log.d("youtube", url);
        textView = v.findViewById(R.id.textView);
        textView.setText(video.getName());
        webView = v.findViewById(R.id.youtube_view);

        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebChromeClient(new WebChromeClient() {
        });
        changeUrl();
        webView.loadData(url, "text/html", "utf-8");


        RecyclerView mRecyclerView = v.findViewById(R.id.rv_recommended);
        mRecyclerView.setHasFixedSize(true);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        Log.d("similarVid", video.getSimilarVideos().toString());
        RecVideoAdapter mAdapter = new RecVideoAdapter(video.getSimilarVideos(), getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
        return v;
    }

    private void changeUrl() {
        url = "<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/" + url + "\" frameborder=\"0\" allowfullscreen></iframe>";
    }

}