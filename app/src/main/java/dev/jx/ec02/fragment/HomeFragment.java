package dev.jx.ec02.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import dev.jx.ec02.R;

public class HomeFragment extends Fragment {

    private final String name;

    public HomeFragment(String name) {
        super();
        this.name = name;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_fragment, container, false);

        TextView nameTextView = view.findViewById(R.id.name_text);
        nameTextView.setText(name);

        return view;
    }
}
