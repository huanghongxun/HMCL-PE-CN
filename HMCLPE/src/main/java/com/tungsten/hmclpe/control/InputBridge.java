package com.tungsten.hmclpe.control;

import net.kdt.pojavlaunch.LWJGLGLFWKeycode;

import org.lwjgl.glfw.CallbackBridge;

import cosine.boat.BoatInput;

public class InputBridge {

    public static final int MOUSE_LEFT        = 0;
    public static final int MOUSE_RIGHT       = 1;
    public static final int MOUSE_MIDDLE      = 2;
    public static final int MOUSE_SCROLL_UP   = 3;
    public static final int MOUSE_SCROLL_DOWN = 4;

    public static void sendKeycode(int launcher,int keyCode,boolean press){
        if (launcher == 1){
            BoatInput.setKey(keyCode,0,press);
        }
        if (launcher == 2){
            CallbackBridge.sendKeyPress(keyCode, CallbackBridge.getCurrentMods(), press);
        }
    }

    public static void sendMouseEvent(int launcher,int bridge,boolean press){
        if (launcher == 1){
            BoatInput.setMouseButton(getMouseEvent(launcher,bridge),press);
        }
        if (launcher == 2){
            CallbackBridge.sendMouseButton(getMouseEvent(launcher,bridge),press);
        }
    }

    public static int getMouseEvent(int launcher,int bridge){
        switch (bridge) {
            case MOUSE_LEFT:
                if (launcher == 1){
                    return BoatInput.Button1;
                }
                else {
                    return LWJGLGLFWKeycode.GLFW_MOUSE_BUTTON_LEFT;
                }
            case MOUSE_RIGHT:
                if (launcher == 1){
                    return BoatInput.Button3;
                }
                else {
                    return LWJGLGLFWKeycode.GLFW_MOUSE_BUTTON_RIGHT;
                }
            case MOUSE_MIDDLE:
                if (launcher == 1){
                    return BoatInput.Button2;
                }
                else {
                    return LWJGLGLFWKeycode.GLFW_MOUSE_BUTTON_MIDDLE;
                }
            case MOUSE_SCROLL_UP:
                if (launcher == 1){
                    return BoatInput.Button4;
                }
                else {
                    return LWJGLGLFWKeycode.GLFW_MOUSE_BUTTON_4;
                }
            case MOUSE_SCROLL_DOWN:
                if (launcher == 1){
                    return BoatInput.Button5;
                }
                else {
                    return LWJGLGLFWKeycode.GLFW_MOUSE_BUTTON_5;
                }
            default:
                return -1;
        }
    }

}
