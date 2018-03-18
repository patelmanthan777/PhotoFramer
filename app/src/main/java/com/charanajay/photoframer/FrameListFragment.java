package com.charanajay.photoframer;

import android.graphics.Bitmap;
import android.media.Image;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


import com.charanajay.photoframer.utils.SpacesItemDecoration;

import java.util.ArrayList;

import butterknife.ButterKnife;

/**
 * Created by charank on 13-03-2018.
 */

public class FrameListFragment extends Fragment {
    View view;
    String bitmap;

//    public static final FrameListFragment newInstance(String bitmap){
//        FrameListFragment frameListFragment = new FrameListFragment();
//        Bundle bundle = new Bundle(1);
//        bundle.putString("bitmap",bitmap);
//        frameListFragment.setArguments(bundle);
//        return frameListFragment;
//    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_frames_list,container,false);
        initFrameRecycler();
        return view;
    }
    public void initFrameRecycler(){
        Log.d("FrameRecycler", "initFrameRecycler:called");

        ArrayList<String> frameNames = new ArrayList<String>();
        ArrayList<Integer> frames = new ArrayList<Integer>();

        frameNames.add("RCB");
        frameNames.add("CupNamde");
        frameNames.add("RCB Playbold");
        frameNames.add("CSK Dhoni");
        frameNames.add("Whistle Podu");
        frameNames.add("Mumbai Indians");

        frames.add(R.drawable.rcbbasic);
        frames.add(R.drawable.cupnamde);
        frames.add(R.drawable.rcbplaybold);
        frames.add(R.drawable.cskdhoni);
        frames.add(R.drawable.cskback);
        frames.add(R.drawable.mumbai_indians);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
        RecyclerView recyclerView = view.findViewById(R.id.frames_recycler_view);
        recyclerView.setLayoutManager(layoutManager);
        FramesAdapter framesAdapter = new FramesAdapter(frameNames,frames,getContext());
        int space = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 8,
                getResources().getDisplayMetrics());
        recyclerView.addItemDecoration(new SpacesItemDecoration(space));
        recyclerView.setAdapter(framesAdapter);

    }
}