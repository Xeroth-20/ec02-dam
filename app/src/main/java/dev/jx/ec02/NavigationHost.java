package dev.jx.ec02;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public interface NavigationHost {

    void navigateTo(@NonNull Fragment fragment, boolean addToBackStack);
}
