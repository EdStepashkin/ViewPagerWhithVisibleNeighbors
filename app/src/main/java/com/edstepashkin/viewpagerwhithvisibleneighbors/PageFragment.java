package com.edstepashkin.viewpagerwhithvisibleneighbors;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;

public class PageFragment extends Fragment {

    List<Integer> colors = Arrays.asList(R.color.color1, R.color.color2, R.color.color3, R.color.color4, R.color.color5);


    static final String PAGE_NUMBER_POSITION = "page_number_position";

    int pageNumber;

    static PageFragment newInstance(int page) {
        PageFragment pageFragment = new PageFragment();
        Bundle arguments = new Bundle();
        arguments.putInt(PAGE_NUMBER_POSITION, page);
        pageFragment.setArguments(arguments);
        return pageFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageNumber = getArguments().getInt(PAGE_NUMBER_POSITION);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View myView = inflater.inflate(R.layout.fragment1, null);
        TextView myTxt = (TextView) myView.findViewById(R.id.myTxt);
        myTxt.setText(pageNumber + "");
        myTxt.setBackgroundColor(getActivity().getResources().getColor(colors.get(pageNumber)));
        return myView;
    }
}
