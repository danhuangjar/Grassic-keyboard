package com.example.hello; import 
android.inputmethodservice.InputMethodService; import 
android.inputmethodservice.Keyboard; import 
android.inputmethodservice.KeyboardView; import android.view.View; 
import android.view.inputmethod.InputConnection; public class MyIME 
extends InputMethodService {
    private KeyboardView kv; @Override public View onCreateInputView() { 
        kv = (KeyboardView) 
        getLayoutInflater().inflate(R.layout.keyboard, null); Keyboard 
        keyboard = new Keyboard(this, R.xml.qwerty); 
        kv.setPreviewEnabled(false);
        kv.setPreviewEnabled(false);
        kv.setKeyboard(keyboard); kv.setOnKeyboardActionListener(new 
        KeyboardView.OnKeyboardActionListener() {
            @Override public void onKey(int primaryCode, int[] keyCodes) 
            {
                InputConnection ic = getCurrentInputConnection(); if (ic 
                == null) return; if (primaryCode == 
                Keyboard.KEYCODE_DELETE) {
                    ic.deleteSurroundingText(1, 0);
                } else if (primaryCode == Keyboard.KEYCODE_DONE) {
                    ic.sendKeyEvent(new android.view.KeyEvent( 
                        android.view.KeyEvent.ACTION_DOWN, 
                        android.view.KeyEvent.KEYCODE_ENTER));
                } else {
                    ic.commitText(String.valueOf((char) primaryCode), 
                    1);
                }
            }
            @Override public void onPress(int primaryCode) {} @Override 
            public void onRelease(int primaryCode) {} @Override public 
            void onText(CharSequence text) {} @Override public void 
            swipeLeft() {} @Override public void swipeRight() {} 
            @Override public void swipeDown() {} @Override public void 
            swipeUp() {}
        });
        return kv;
    }
}
