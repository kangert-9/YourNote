package com.example.yournote;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


public class SocialNetworkFragment extends Fragment {
    SocialNetworkAdapter adapter;
    CardSource data;
    RecyclerView recyclerView;
    private Navigation navigation;
    private final Publisher publisher = new Publisher();

    public static SocialNetworkFragment newInstance() {
        return new SocialNetworkFragment();
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        data = new CardSourceImpl(getResources()).init();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_social_network, container, false);
        recyclerView = view.findViewById(R.id.recycler_view_lines);
        data = new CardSourceImpl (getResources()).init();
        initRecyclerView();
        setHasOptionsMenu(true);
        return view;
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, MenuInflater inflater) {
                inflater.inflate(R.menu.main_menu, menu);
    }

//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        switch (item.getItemId()){
//            case R.id.action_add:
//                navigation.addFragment(TextFragment.newInstance());
//                publisher.subscribe(cardData -> {
//                    data.addCardData(cardData);
//                    adapter.notifyItemInserted(data.size() - 1);
//                });
//                return true;
//            case R.id.action_clear:
//                data.clearCardData();
//                adapter.notifyDataSetChanged();
//                return true;
//        }
//        return super.onOptionsItemSelected(item);
//    }

    private void initRecyclerView() {
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        adapter = new SocialNetworkAdapter(data, this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onCreateContextMenu(@NonNull ContextMenu menu, @NonNull View v, @Nullable ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = requireActivity().getMenuInflater();
        inflater.inflate(R.menu.card_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        final int position = adapter.getMenuPosition();
        switch(item.getItemId()) {
            case R.id.action_update:
                navigation.addFragment(TextFragment.newInstance(data.getCardData(position)), true);
                publisher.subscribe(cardData -> {
                    data.updateCardData(position, cardData);
                    adapter.notifyItemChanged(position);
                });
                return true;
            case R.id.action_delete:
                    AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                    builder.setTitle(R.string.exclamation)
                            .setMessage(R.string.question)
                            .setCancelable(false)
                            .setNegativeButton(R.string.no,
                                    (dialog, id) -> Toast.makeText(getContext(), "Заметка не удалена",
                                            Toast.LENGTH_SHORT).show())
                            .setPositiveButton(R.string.yes,
                                    (dialog, id) -> {
                                        data.deleteCardData(position);
                                        adapter.notifyItemRemoved(position);
                                    });

                    AlertDialog alert = builder.create();
                    alert.show();
        }
        return super.onContextItemSelected(item);
    }
}