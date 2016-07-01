package com.csg.mta;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;

/**
 * Created by chand on 6/22/2016.
 */
public class SearchStations extends Fragment {

    private TextChangeListener listener;
    private Button b;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.search_stations,container,false);
        return view;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        // This makes sure that the container activity has implemented
        // the callback interface. If not, it throws an exception
        try {
            listener = (TextChangeListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement TextClicked");
        }
    }

    public void clearText(){
        EditText search = (EditText) getView().findViewById(R.id.editText);
        search.setText("");
    }

    public void init(){
        EditText search = (EditText) getView().findViewById(R.id.editText);
        search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                RelativeLayout layout = (RelativeLayout) getView().findViewById(R.id.searchFragment);
                if (b!=null) {
                    layout.removeView(b);
                }
                if (!s.toString().equals("")){
                    Button closeButton = new Button(getActivity());
                    int buttonHeight = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 20, getResources().getDisplayMetrics());
                    int buttonWidth = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 20, getResources().getDisplayMetrics());
                    RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(new ActionBar.LayoutParams(buttonWidth,buttonHeight));
                    closeButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            clearText();
                        }
                    });
                    closeButton.setBackgroundResource(R.drawable.clear_button);
                    params.addRule(RelativeLayout.ALIGN_PARENT_END);
                    params.addRule(RelativeLayout.CENTER_VERTICAL);
                    params.setMargins(0,0,20,0);
                    closeButton.setLayoutParams(params);
                    b = closeButton;
                    layout.addView(closeButton);
                }
                listener.onTextChange(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    public interface TextChangeListener{
        public void onTextChange(String updated);
    }

}
