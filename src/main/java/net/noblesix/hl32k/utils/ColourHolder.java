package net.noblesix.hl32k.util;


import java.awt.*;

/**
 * Created by Gebruiker on 18/04/2017.
 */
public class ColourHolder {

    int r;
    int g;
    int b;
    int a;

    public ColourHolder(int r, int g, int b) {
        this.r = r;
        this.g = g;
        this.b = b;
        this.a = 255;
    }

    public ColourHolder(int r, int g, int b, int a) {
        this.r = r;
        this.g = g;
        this.b = b;
        this.a = a;
    }

    public ColourHolder brighter() {
        return new ColourHolder(Math.min(r + 10, 255), Math.min(g + 10, 255), Math.min(b + 10, 255), getA());
    }

    public ColourHolder darker() {
        return new ColourHolder(Math.max(r - 10, 0), Math.max(g - 10, 0), Math.max(b - 10, 0), getA());
    }



    public void becomeHex(int hex) {
        setR((hex & 0xFF0000) >> 16);
        setG((hex & 0xFF00) >> 8);
        setB((hex & 0xFF));
        setA(255);
    }

    public static ColourHolder fromHex(int hex) {
        ColourHolder n = new ColourHolder(0, 0, 0);
        n.becomeHex(hex);
        return n;
    }

    public static int toHex(int r, int g, int b) {
        return (0xff << 24) | ((r & 0xff) << 16) | ((g & 0xff) << 8) | (b & 0xff);
    }

    public int toHex() {
        return toHex(r, g, b);
    }

    public int getB() {
        return b;
    }

    public int getG() {
        return g;
    }

    public int getR() {
        return r;
    }

    public int getA() {
        return a;
    }

    public ColourHolder setR(int r) {
        this.r = r;
        return this;
    }

    public ColourHolder setB(int b) {
        this.b = b;
        return this;
    }

    public ColourHolder setG(int g) {
        this.g = g;
        return this;
    }

    public ColourHolder setA(int a) {
        this.a = a;
        return this;
    }

    @Override
    public ColourHolder clone() {
        return new ColourHolder(r, g, b, a);
    }

    public Color toJavaColour() {
        return new Color(r, g, b, a);
    }
}
