package com.oneeyedmen.test;

import java.awt.*;
import java.awt.event.*;

import javax.swing.JFrame;

public class WindowShower extends WindowAdapter {
    
    public static final Integer DEFAULT_WINDOW_SHOW_TIMEOUT = Integer.getInteger("DEFAULT_WINDOW_SHOW_TIMEOUT", 1000000);
    
    private Window window;
    
    public WindowShower(Window window) {
        this.window = window;    
    }
    
    public WindowShower(Component component) {
        this(createFrameContaining(component));
    }    
     
    public void showFor(long timeoutMs, boolean maximize, boolean disposeAfterTimeout) {
        if (timeoutMs < 0)
            timeoutMs = DEFAULT_WINDOW_SHOW_TIMEOUT;
        window.addWindowListener(this);
        window.pack();
        if (maximize) 
            ((Frame) window).setExtendedState(Frame.MAXIMIZED_BOTH);
        window.setVisible(true);
        synchronized (this) {
            try {
                if (timeoutMs > 0)
                    this.wait(timeoutMs);
            } catch (InterruptedException ex) {}        
        }
        if (disposeAfterTimeout)
            window.dispose();
    
    }  
    
    public void showFor(long timeoutMs) {
        showFor(timeoutMs, false, true);
    }
    
    public void showMaximizedFor(long timeoutMs) {
        showFor(timeoutMs, true, true);
    }
    
    public void windowClosing(WindowEvent e) {
        window.dispose();
        synchronized (this) {
            this.notify();
        }
    }
    
    public static JFrame createFrameContaining(Component component) {
        JFrame result = new JFrame("Test Window");
        result.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        result.getContentPane().add(component);
        return result;
    }

}