package dev.jx.ec02.view;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.toolbox.NetworkImageView;
import com.google.android.material.button.MaterialButton;

import java.util.List;

import dev.jx.ec02.NavigationHost;
import dev.jx.ec02.R;
import dev.jx.ec02.entity.Pet;
import dev.jx.ec02.fragment.PetDetailsFragment;
import dev.jx.ec02.network.ImageRequester;
import dev.jx.ec02.util.JsonUtils;

public class PetRecyclerView extends RecyclerView {

    public PetRecyclerView(@NonNull Context context) {
        super(context);
    }

    public PetRecyclerView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public PetRecyclerView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        setHasFixedSize(true);
        setLayoutManager(new GridLayoutManager(getContext(), 2, RecyclerView.VERTICAL, false));
        setAdapter(new PetRecyclerViewAdapter(JsonUtils.parseAsList(R.raw.pets, Pet[].class)));

        int offset = getResources().getDimensionPixelSize(R.dimen.pet_item_decoration_offset);
        addItemDecoration(new PetItemDecoration(new Rect(offset, offset, offset, offset)));
    }

    private static class PetRecyclerViewAdapter extends RecyclerView.Adapter<PetItemViewHolder> {

        private final List<Pet> pets;

        public PetRecyclerViewAdapter(List<Pet> pets) {
            this.pets = pets;
        }

        @NonNull
        @Override
        public PetItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.pet_item, parent, false);
            return new PetItemViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull PetItemViewHolder holder, int position) {
            holder.setPet(pets.get(position));
            holder.init();
        }

        @Override
        public int getItemCount() {
            return pets.size();
        }
    }

    private static class PetItemViewHolder extends RecyclerView.ViewHolder {

        private Pet pet;

        public PetItemViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        public void init() {
            if (pet != null) {
                NetworkImageView petImageView = itemView.findViewById(R.id.pet_image_view);
                TextView petNameTextView = itemView.findViewById(R.id.pet_name_text_view);
                TextView petAnimalTextView = itemView.findViewById(R.id.pet_animal_text_view);
                MaterialButton petSeeMoreButton = itemView.findViewById(R.id.pet_see_more_btn);

                ImageRequester.getInstance().setImageFromUrl(petImageView, pet.getImages().get(0));
                petNameTextView.setText(pet.getName());
                petAnimalTextView.setText(pet.getAnimal());

                petSeeMoreButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ((NavigationHost) FragmentManager.findFragment(itemView).getActivity())
                                .navigateTo(new PetDetailsFragment(pet), true);
                    }
                });
            }
        }

        public void setPet(Pet pet) {
            this.pet = pet;
        }
    }

    private static class PetItemDecoration extends RecyclerView.ItemDecoration {

        private final Rect rect;

        public PetItemDecoration(@NonNull Rect rect) {
            this.rect = rect;
        }

        @Override
        public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull State state) {
            outRect.set(rect);
        }
    }
}
