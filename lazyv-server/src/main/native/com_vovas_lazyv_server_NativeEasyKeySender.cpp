#include <Windows.h>
#include <iostream>

#include "com_vovas_lazyv_server_NativeEasyKeySender.h"


JNIEXPORT void JNICALL Java_com_vovas_lazyv_server_NativeEasyKeySender_sendEasyKey
  (JNIEnv * env, jobject thisObject, jint key){
//https://docs.microsoft.com/ru-ru/windows/desktop/inputdev/virtual-key-codes
//https://stackoverflow.com/questions/1021175/sendinput-keyboard-letters-c-c
//https://docs.microsoft.com/en-us/windows/desktop/api/winuser/nf-winuser-sendinput
    std::cout<< "I was here\n";
    WORD vkey;
    INPUT input;
    switch(key){
        case 0: // esc
            vkey = VK_ESCAPE;
            break;
        case 1: // enter
            vkey = VK_RETURN;
            break;
        case 2: // f5
            vkey = VK_F5;
            break;
        case 3: // UP Arrow
            vkey = VK_UP;
            break;
        case 4: // down Arrow
            vkey = VK_DOWN;
            break;
        case 5: // Right Arrow
            vkey = VK_RIGHT;
            break;
        case 6: // Left Arrow
            vkey = VK_LEFT;
            break;
        default: // space
            vkey = VK_SPACE;
            break;
    }
//    std::cout << "current key is " << vkey << std::endl;
    input.type = INPUT_KEYBOARD;
    input.ki.wScan = MapVirtualKey(vkey, MAPVK_VK_TO_VSC);
    input.ki.time = 0;
    input.ki.dwExtraInfo = 0;
    input.ki.wVk = vkey;
    input.ki.dwFlags = 0; // there is no KEYEVENTF_KEYDOWN
    SendInput(1, &input, sizeof(INPUT));
    std::cout << "The key was " << vkey << std::endl;
    input.ki.dwFlags = KEYEVENTF_KEYUP;
    SendInput(1, &input, sizeof(INPUT));
}


JNIEXPORT void JNICALL Java_com_vovas_lazyv_server_NativeEasyKeySender_sendChar
  (JNIEnv * env, jobject thisObject, jchar mK){

       HKL kbl = GetKeyboardLayout(0);
        INPUT ip;
        ip.type = INPUT_KEYBOARD;
        ip.ki.time = 0;
        ip.ki.dwFlags = KEYEVENTF_UNICODE;
        if ((int)mK < 65 && (int)mK>90) //for lowercase
        {
            ip.ki.wScan = 0;
            WORD wVk = VkKeyScanEx(mK, kbl);
            std::cout << "Code is " << wVk << "\n";
            ip.ki.wVk = wVk;
        }
        else //for uppercase
        {
            ip.ki.wScan = mK;
            ip.ki.wVk = 0;
        }
        ip.ki.dwExtraInfo = 0;
        SendInput(1, &ip, sizeof(INPUT));
}


