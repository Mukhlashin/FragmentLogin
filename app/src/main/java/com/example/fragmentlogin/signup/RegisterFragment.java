package com.example.fragmentlogin.signup;


import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.fragmentlogin.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class RegisterFragment extends Fragment {


    @BindView(R.id.edt_username)
    TextInputEditText edtUsername;
    @BindView(R.id.edt_password)
    TextInputEditText edtPassword;
    @BindView(R.id.rb_laki)
    RadioButton rbLaki;
    @BindView(R.id.rb_perempuan)
    RadioButton rbPerempuan;
    @BindView(R.id.rg_jkelamin)
    RadioGroup rgJkelamin;
    @BindView(R.id.tv_pilih)
    TextView tvPilih;
    @BindView(R.id.sp_kota)
    Spinner spKota;
    @BindView(R.id.ln_register)
    LinearLayout lnRegister;
    @BindView(R.id.btn_loginr)
    Button btnLoginr;
    Unbinder unbinder;
    FragmentManager fm;
    private String[] listKota = {
            "-Pilih-", "Jakarta", "Semarang", "Bandung", "Yogyakarta", "Denpasar", "Makassar"};

    public RegisterFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_register, container, false);
        unbinder = ButterKnife.bind(this, view);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_item, listKota);
        spKota.setAdapter(adapter);
        fm = getActivity().getSupportFragmentManager();
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.btn_loginr)
    public void onViewClicked(View view) {

        switch (view.getId()) {
            case R.id.btn_loginr:
                if (edtUsername.getText().toString().trim().length() == 0) {
                    edtUsername.setError("Jangan Kosong");
                } else if (edtPassword.getText().toString().trim().length() == 0) {
                    edtPassword.setError("Jangan Kosong");
                } else if (edtPassword.getText().length() < 6 ) {
                    edtPassword.setError("Password harus lebih dari 6 karakter");
                    break;
                } case R.id.btn_Signup:
                fm.beginTransaction()
                        .add(R.id.login_main_container, new RegisterFragment())
                        .commit();
                break;
        }
    }
}
