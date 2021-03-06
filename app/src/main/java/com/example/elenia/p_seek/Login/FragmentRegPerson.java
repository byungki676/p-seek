package com.example.elenia.p_seek.Login;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.example.elenia.p_seek.fragment.FragmentHome;
import com.example.elenia.p_seek.fragment.FragmentLogin;
import com.example.elenia.p_seek.R;

public class FragmentRegPerson extends Fragment {

    FragmentManager fm;
    FragmentTransaction ft;

    FragmentLogin fraglogin;
    FragmentHome fraghome;
    Button person_ok_btn;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_reg_person, container, false);

        fm = getFragmentManager();
        ft = fm.beginTransaction();

        fraglogin = new FragmentLogin();
        fraghome = new FragmentHome();

        person_ok_btn = (Button) rootView.findViewById(R.id.person_ok_btn);

        person_ok_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fm.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE); // 모든 스택 초기화
                ft.replace(R.id.home, fraghome);
                ft.addToBackStack(null); // 홈 프래그먼트 스택 저장
                ft.replace(R.id.home, fraglogin);
                ft.commit();
            }
        });

        return rootView;
    }
}