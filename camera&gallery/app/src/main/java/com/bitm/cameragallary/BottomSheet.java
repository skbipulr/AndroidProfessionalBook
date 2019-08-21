package com.bitm.cameragallary;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class BottomSheet extends BottomSheetDialogFragment {

    TextView textView;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
      View view= inflater.inflate(R.layout.bottom_sheet_layout,container,false);
       textView = view.findViewById(R.id.textViewID);

       if (getArguments()!=null){
          String name= getArguments().getString("name");
          textView.setText(name);
       }
       return view;
    }
}
