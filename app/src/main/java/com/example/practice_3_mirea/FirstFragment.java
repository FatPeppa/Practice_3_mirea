package com.example.practice_3_mirea;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.app.Activity;
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

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

enum GoodParameterType {
    GOOD_AMOUNT,
    GOOD_NAME
}

public class FirstFragment extends Fragment {
    TextView order_congratulations_warning_view;
    TextView order_list;
    EditText customer_introduction_input_text;
    Button choose_the_amount_button;
    Button clean_button;

    public FirstFragment() {
        super(R.layout.fragment_first);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        order_congratulations_warning_view = (TextView) view.findViewById(R.id.order_congratulations_warning);
        order_list = (TextView) view.findViewById(R.id.order_list);
        customer_introduction_input_text = (EditText) view.findViewById(R.id.customer_introduction_input);
        choose_the_amount_button = (Button) view.findViewById(R.id.choose_the_amount_button);
        clean_button = (Button) view.findViewById(R.id.clean_button);

        clean_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                order_list.setVisibility(View.INVISIBLE);

                customer_introduction_input_text.setText("");
                customer_introduction_input_text.setHint(R.string.str_customer_introduction_hint);
            }
        });

        choose_the_amount_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (customer_introduction_input_text.getText().toString().length() > 0
                        && !isNumeric(customer_introduction_input_text.getText().toString())) {

                    Intent intent = new Intent(view.getContext(), Second_activity.class);
                    ArrayList<String> arrayList = new ArrayList<>();
                    arrayList.add(customer_introduction_input_text.getText().toString());
                    intent.putStringArrayListExtra("intent_from_first_activity", (ArrayList<String>) arrayList);

                    mStartForResult.launch(intent);
                } else {
                    customer_introduction_input_text.setText("");
                    customer_introduction_input_text.setHint(R.string.str_customer_introduction_hint);
                    customer_introduction_input_text.setHintTextColor(view.getContext().getColor(R.color.red));
                }
            }
        });

        Toast.makeText(getActivity(), "onViewCreated", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onViewCreated");
    }

    ActivityResultLauncher<Intent> mStartForResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {

                    if(result.getResultCode() == Activity.RESULT_OK){
                        Intent intent = result.getData();

                        if (intent != null) {
                            ArrayList<String> inputs = intent.getStringArrayListExtra("goods");

                            if (inputs != null && checkInputs(inputs)){
                                String goods_amount = parseInputsGoods(inputs, GoodParameterType.GOOD_AMOUNT);
                                String good_name = parseInputsGoods(inputs, GoodParameterType.GOOD_NAME);

                                order_list.setText(goods_amount);
                                customer_introduction_input_text.setText(good_name);
                            } else {
                                Toast.makeText(getActivity(), "An intent error occurred", Toast.LENGTH_SHORT).show();
                                Log.e(TAG, "Intent error occurred!!!");
                            }
                        }
                    }
                    else{
                        Toast.makeText(getActivity(), "An intent error occurred", Toast.LENGTH_SHORT).show();
                        Log.e(TAG, "Intent error occurred!!!");
                    }
                }
            });

    private String parseInputsGoods(ArrayList<String> array, GoodParameterType type) {
        switch (type) {
            case GOOD_AMOUNT:
                return array.get(0);
            case GOOD_NAME:
                return array.get(1);
            default:
                return null;
        }
    }

    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }

    private boolean checkInputs(ArrayList<String> array) {
        if (array.size() != 2) return false;

        String g_a = array.get(0);
        String g_n = array.get(1);

        return isNumeric(g_a) && !isNumeric(g_n) && g_n.length() != 0 && g_a.length() != 0;
    }

    //Lifecycle
    private final static String TAG = "FirstFragment";

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


