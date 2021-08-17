package com.example.yournote;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Parcelable;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.example.yournote.R;


public class SocialNetworkFragment extends Fragment {
    public static final String ARG_INDEX = "index";
    SocialNetworkAdapter adapter;
    CardSource data;
    RecyclerView recyclerView;
    CardData newCard;

    public static SocialNetworkFragment newInstance() {
        return new SocialNetworkFragment();
    }
//todo
//    public static SocialNetworkFragment newInst(SocialNetworkFragment f) {
//        Bundle args = new Bundle();
//        args.putParcelable(ARG_INDEX, new CardData(null, null, null));
//        f.setArguments(args);
//        return f;
//    }
//todo
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//            newCard = getArguments().getParcelable(ARG_INDEX);
//            for (int i = 0; i < data.size(); i++) {
//                if (newCard.getNoteName()==data.getData(i).getNoteName()){
//                    data.getData(i).setNote(newCard.getNote());
//                    data.getData(i).setDates(newCard.getDates());
//                    adapter.notifyItemChanged(i);
//                }
//            }
//        }
//    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_social_network, container, false);
        recyclerView = view.findViewById(R.id.recycler_view_lines);
        data = new CardSourceImpl (getResources()).init();
        initView(view);
        setHasOptionsMenu(true);
        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
                inflater.inflate(R.menu.main_menu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_add:
                data.addCardData(new CardData("Заголовок " + data.size(),
                        "Описание " + data.size(), "сделать завтра"));
                adapter.notifyItemInserted(data.size() - 1);
                recyclerView.scrollToPosition(data.size() - 1);
                return true;
            case R.id.action_clear:
                data.clearCardData();
                adapter.notifyDataSetChanged();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    private void initView(View view) {
        recyclerView = view.findViewById(R.id.recycler_view_lines);
        data = new CardSourceImpl(getResources()).init();
        initRecyclerView();
    }

    private void initRecyclerView(){
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
        int position = adapter.getMenuPosition();
        CardData card = data.getData(position);
        switch(item.getItemId()) {
            case R.id.action_update:
                showTextFra(card);
//                data.updateCardData(position,
//                        new CardData(newCard.getNoteName(),
//                                newCard.getNote(),
//                                newCard.getDates()));
//                adapter.notifyItemChanged(position);

                return true;
            case R.id.action_delete:
                data.deleteCardData(position);
                adapter.notifyItemRemoved(position);
                return true;
        }
        return super.onContextItemSelected(item);
    }

    private void showTextFra(CardData card) {
        Intent intent = new Intent();
        intent.setClass(getActivity(), TextActivity.class);
        //intent.putParcelableArrayListExtra(TextFragment.ARG_INDEX, card);
        intent.putExtra(TextFragment.ARG_INDEX, (Parcelable) card);
        startActivity(intent);
    }

}