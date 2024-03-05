package com.example.practice_3_mirea;

import static android.app.Activity.RESULT_OK;
import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import static com.example.practice_3_mirea.FirstFragment.isNumeric;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class SecondFragment extends Fragment {
    public SecondFragment() {
        super(R.layout.fragment_second);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        EditText input_the_amount_edit_text = (EditText) view.findViewById(R.id.input_the_amount_edit_text);
        TextView chosen_good = (TextView) view.findViewById(R.id.chosen_good);
        Button choose_the_amount_button = (Button) view.findViewById(R.id.choose_the_amount_button);

        choose_the_amount_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input_amount = input_the_amount_edit_text.getText().toString();
                if (input_amount.length() == 0 || !isNumeric(input_amount)) {
                    input_the_amount_edit_text.setText("");
                    input_the_amount_edit_text.setHint(R.string.str_input_the_amount_hint);
                    input_the_amount_edit_text.setHintTextColor(view.getContext().getColor(R.color.red));
                }
            }
        });

        Toast.makeText(getActivity(), "onResume", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onViewCreated");
    }

    private String parseInputsGoods(ArrayList<String> array) {
        return array.get(0);
    }

    private boolean checkInputs(ArrayList<String> array) {
        if (array.size() != 1) return false;

        String g_n = array.get(0);

        if (isNumeric(g_n) || g_n.length() == 0) return false;
        return true;
    }

    //Lifecycle
    private final static String TAG = "SecondFragment";

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        Toast.makeText(getActivity(), "onAttach", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onAttach");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Toast.makeText(getActivity(), "onCreate", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onCreate");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView");
        Toast.makeText(getActivity(), "onCreateView", Toast.LENGTH_SHORT).show();

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);

        Toast.makeText(getActivity(), "onViewStateRestored", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onViewStateRestored");
    }

    @Override
    public void onStart() {
        super.onStart();

        Toast.makeText(getActivity(), "onStart", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onStart");
    }

    @Override
    public void onResume() {
        super.onResume();

        Toast.makeText(getActivity(), "onResume", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onResume");
    }

    @Override
    public void onPause() {
        super.onPause();

        Toast.makeText(getActivity(), "onPause", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onPause");
    }

    @Override
    public void onStop() {
        super.onStop();

        Toast.makeText(getActivity(), "onStop", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onStop");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        Toast.makeText(getActivity(), "onDestroyView", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onDestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        Toast.makeText(getActivity(), "onDestroy", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onDestroy");
    }

    @Override
    public void onDetach() {
        super.onDetach();

        Toast.makeText(getActivity(), "onDetach", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onDetach");
    }
}
