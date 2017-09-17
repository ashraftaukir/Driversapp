package com.webxzen.driversapp;

import android.app.Dialog;
import android.support.design.widget.BottomSheetDialogFragment;
import android.view.View;


public class Bottomsheet extends BottomSheetDialogFragment {

    @Override
    public void setupDialog(Dialog dialog, int style) {
        super.setupDialog(dialog, style);
        View contentView = View.inflate(getContext(), R.layout.bottomsheet, null);
        dialog.setContentView(contentView);
    }
}