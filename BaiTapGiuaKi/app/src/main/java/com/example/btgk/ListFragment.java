package com.example.btgk;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    RecyclerView recyclerView;
    ArrayList<Phim> dataholder;
    public ListFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ListFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ListFragment newInstance(String param1, String param2) {
        ListFragment fragment = new ListFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_list, container, false);
        recyclerView=view.findViewById(R.id.recview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        dataholder=new ArrayList<>();
        // Inflate the layout for this fragment
        Phim ob1=new Phim("AVARTAR 2","Phim AVATAR  DÒNG\\n CHẢY...Xem chi tiết",R.drawable.avatar2);
        dataholder.add(ob1);
        Phim ob2=new Phim("MINIONS","Mùa hè này,\ntừ cách...Xem chi tiết",R.drawable.minion);
        dataholder.add(ob2);
        Phim ob3=new Phim("7 Thi Thể","Chuyện phim được làm\ndựa trên một vụ án có\nthật...Xem chi tiết",R.drawable.baythithe);
        dataholder.add(ob3);
        Phim ob4=new Phim("Chuyện Ma\nGần Nhà","Tác phẩm đầu\ntiên...Xem chi tiết",R.drawable.cmgn);
        dataholder.add(ob4);
        Phim ob5=new Phim("Em và Trịnh","Thời niên thiếu của\nngười...Xem chi tiết",R.drawable.emvatrinh);
        dataholder.add(ob5);
        Phim ob6=new Phim("Tình Người\nDuyên Ma","Tiếp nối \nhội bạn...Xem chi tiết",R.drawable.tndm);
        dataholder.add(ob6);
        Phim ob7=new Phim("NDTGDYA","Bhop – một kỹ sư \\ntài...Xem chi tiết",R.drawable.ngtgdya);
        dataholder.add(ob7);
        recyclerView.setAdapter(new PhimAdapter(dataholder));
        return view;
    }

}