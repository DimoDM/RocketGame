package com.example.rocketgame.ui.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;

import com.budiyev.android.codescanner.CodeScanner;
import com.budiyev.android.codescanner.CodeScannerView;
import com.example.rocketgame.R;
import com.example.rocketgame.databinding.ActivityQRReaderBinding;

public class QRReaderActivity extends AppCompatActivity {
    ActivityQRReaderBinding mBinding;
    CodeScanner mCodeScanner;
    public static final String CODE = "com.example.live.CODE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_q_r_reader);
        mCodeScanner = new CodeScanner(this, mBinding.scannerView);
        mCodeScanner.setDecodeCallback(result -> runOnUiThread(() -> {
            String code = result.getText();
            Intent intent = new Intent();
            intent.putExtra(CODE, code);
            setResult(RESULT_OK, intent);
            finish();
        }));
    }

    @Override
    protected void onResume() {
        super.onResume();
        mCodeScanner.startPreview();
    }
}
}