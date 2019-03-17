package com.example.fragmentlogin.login;


import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.fragmentlogin.R;
import com.example.fragmentlogin.signup.RegisterFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment {


    @BindView(R.id.edt_username)
    TextInputEditText edtUsername;
    @BindView(R.id.ly_username)
    TextInputLayout lyUsername;
    @BindView(R.id.edt_password)
    TextInputEditText edtPassword;
    @BindView(R.id.ly_password)
    TextInputLayout lyPassword;
    @BindView(R.id.btn_login)
    Button btnLogin;
    @BindView(R.id.tv_not)
    TextView tvNot;
    @BindView(R.id.btn_Signup)
    Button btnSignup;
    Unbinder unbinder;
    FragmentManager fm;

    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        unbinder = ButterKnife.bind(this, view);
        fm = getActivity().getSupportFragmentManager();
        return view;

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.btn_login, R.id.btn_Signup})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_login:
                if (edtUsername.getText().toString().trim().length() == 0) {
                    edtUsername.setError("Jangan Kosong");
                } else if (edtPassword.getText().toString().trim().length() == 0) {
                    edtPassword.setError("Jangan Kosong");
                } else if (edtPassword.getText().length() < 6 ) {
                    edtPassword.setError("Password harus lebih dari 6 karakter");
                } break;
            case R.id.btn_Signup:
                fm.beginTransaction()
                        .add(R.id.login_main_container, new RegisterFragment())
                        .addToBackStack("")
                        .hide(LoginFragment.this)
                        .commit();
                break;
        }
    }
}
