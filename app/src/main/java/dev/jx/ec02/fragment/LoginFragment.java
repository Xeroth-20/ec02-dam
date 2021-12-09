package dev.jx.ec02.fragment;

import android.os.Bundle;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import dev.jx.ec02.NavigationHost;
import dev.jx.ec02.R;

public class LoginFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.login_fragment, container, false);

        TextInputLayout nameTextInput = view.findViewById(R.id.name_text_input);
        TextInputEditText nameTextEdit = view.findViewById(R.id.name_edit_text);
        MaterialButton loginButton = view.findViewById(R.id.login_btn);

        nameTextEdit.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (isNameValid(nameTextEdit.getText())) {
                    nameTextInput.setError(null);
                }

                return false;
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isNameValid(nameTextEdit.getText())) {
                    nameTextInput.setError(null);
                    ((NavigationHost) getActivity()).navigateTo(new HomeFragment(nameTextEdit.getText().toString()), false);
                } else {
                    nameTextInput.setError(getString(R.string.name_error_message));
                }
            }
        });

        return view;
    }

    private boolean isNameValid(@Nullable Editable name) {
        return name != null && name.length() > 2;
    }
}
