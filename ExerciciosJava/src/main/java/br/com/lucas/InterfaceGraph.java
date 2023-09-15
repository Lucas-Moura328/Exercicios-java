package br.com.lucas;

import javax.swing.*;

public class InterfaceGraph {
    void write(String msg) {
        JOptionPane.showMessageDialog(null, msg);
    }

    String readText(String msg) {
        return JOptionPane.showInputDialog(msg);
    }

    int readInt(String msg) throws Exception {
        int ret = 0;
        try {
            ret = Integer.parseInt(readText(msg));
        } catch (Exception e) {
            write("Digito inválido");
            ret = readInt(msg);
            throw e;
        }
        return ret;
    }

    float readFloat(String msg) throws Exception {
        float ret = 0;
        try {
            ret = Float.parseFloat(readText(msg));
        } catch (Exception e) {
            write("Digito inválido");
            ret = readFloat(msg);
            throw e;
        }
        return ret;
    }
    Boolean readBoolean(String msg) {
        int confirm = JOptionPane.showConfirmDialog(null, msg);
        if(confirm == JOptionPane.YES_OPTION) {
            return true;
        } else {
            return false;
        }
    }
}
