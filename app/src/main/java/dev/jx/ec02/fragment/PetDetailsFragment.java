package dev.jx.ec02.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.android.volley.toolbox.NetworkImageView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.chip.Chip;

import dev.jx.ec02.R;
import dev.jx.ec02.entity.Pet;
import dev.jx.ec02.network.ImageRequester;

public class PetDetailsFragment extends Fragment {

    private final Pet pet;

    public PetDetailsFragment(Pet pet) {
        super();
        this.pet = pet;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.pet_details_fragment, container, false);

        NetworkImageView petImageView = view.findViewById(R.id.pet_image_view);
        TextView petNameTextView = view.findViewById(R.id.pet_name_text_view);
        Chip petAnimalChip = view.findViewById(R.id.pet_animal_chip);
        Chip petBreedChip = view.findViewById(R.id.pet_breed_chip);
        TextView petDescriptionViewText = view.findViewById(R.id.pet_description_text_view);
        MaterialButton adoptButton = view.findViewById(R.id.adopt_btn);

        ImageRequester.getInstance().setImageFromUrl(petImageView, pet.getImages().get(0));
        petNameTextView.setText(pet.getName());
        petAnimalChip.setText(pet.getAnimal());
        petBreedChip.setText(pet.getBreed());
        petDescriptionViewText.setText(pet.getDescription());

        adoptButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "You have adopted " + pet.getName() + "!", Toast.LENGTH_LONG).show();
            }
        });

        return view;
    }
}
