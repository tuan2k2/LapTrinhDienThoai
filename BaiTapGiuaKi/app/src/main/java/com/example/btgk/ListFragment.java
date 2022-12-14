package com.example.btgk;

import android.os.Bundle;

import androidx.annotation.NonNull;
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
        Phim ob1=new Phim("AVARTAR 2","Phim AVATAR  D??NG\\n CH???Y...Xem chi ti???t",R.drawable.avatar2);
        dataholder.add(ob1);
        Phim ob2=new Phim("MINIONS","M??a h?? n??y,\nt??? c??ch...Xem chi ti???t",R.drawable.minion);
        dataholder.add(ob2);
        Phim ob3=new Phim("7 Thi Th???","Chuy???n phim ???????c l??m\nd???a tr??n m???t v??? ??n c??\nth???t...Xem chi ti???t",R.drawable.baythithe);
        dataholder.add(ob3);
        Phim ob4=new Phim("Chuy???n Ma\nG???n Nh??","T??c ph???m ?????u\nti??n...Xem chi ti???t",R.drawable.cmgn);
        dataholder.add(ob4);
        Phim ob5=new Phim("Em v?? Tr???nh","Th???i ni??n thi???u c???a\nng?????i...Xem chi ti???t",R.drawable.emvatrinh);
        dataholder.add(ob5);
        Phim ob6=new Phim("T??nh Ng?????i\nDuy??n Ma","Ti???p n???i \nh???i b???n...Xem chi ti???t",R.drawable.tndm);
        dataholder.add(ob6);
        Phim ob7=new Phim("NDTGDYA","Bhop ??? m???t k??? s?? \\nt??i...Xem chi ti???t",R.drawable.ngtgdya);
        dataholder.add(ob7);
        recyclerView.setAdapter(new PhimAdapter(dataholder,getActivity()));
        return view;
    }

}