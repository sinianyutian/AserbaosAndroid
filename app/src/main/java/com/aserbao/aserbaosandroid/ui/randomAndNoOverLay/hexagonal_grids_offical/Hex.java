package com.aserbao.aserbaosandroid.ui.randomAndNoOverLay.hexagonal_grids_offical;

import java.util.ArrayList;

public class Hex
{
    public Hex(int q, int r, int s)
    {
        this.q = q;
        this.r = r;
        this.s = s;
        if (q + r + s != 0) throw new IllegalArgumentException("q + r + s must be 0");
    }
    public final int q;
    public final int r;
    public final int s;

    public Hex add(Hex b)
    {
        return new Hex(q + b.q, r + b.r, s + b.s);
    }


    public Hex subtract(Hex b)
    {
        return new Hex(q - b.q, r - b.r, s - b.s);
    }


    public Hex scale(int k)
    {
        return new Hex(q * k, r * k, s * k);
    }


    public Hex rotateLeft()
    {
        return new Hex(-s, -q, -r);
    }


    public Hex rotateRight()
    {
        return new Hex(-r, -s, -q);
    }

    static public ArrayList<Hex> directions = new ArrayList<Hex>(){{add(new Hex(1, 0, -1)); add(new Hex(1, -1, 0)); add(new Hex(0, -1, 1)); add(new Hex(-1, 0, 1)); add(new Hex(-1, 1, 0)); add(new Hex(0, 1, -1));}};

    static public Hex direction(int direction)
    {
        return Hex.directions.get(direction);
    }


    public Hex neighbor(int direction)
    {
        return add(Hex.direction(direction));
    }

    static public ArrayList<Hex> diagonals = new ArrayList<Hex>(){{add(new Hex(2, -1, -1)); add(new Hex(1, -2, 1)); add(new Hex(-1, -1, 2)); add(new Hex(-2, 1, 1)); add(new Hex(-1, 2, -1)); add(new Hex(1, 1, -2));}};

    public Hex diagonalNeighbor(int direction)
    {
        return add(Hex.diagonals.get(direction));
    }


    public int length()
    {
        return (int)((Math.abs(q) + Math.abs(r) + Math.abs(s)) / 2);
    }


    public int distance(Hex b)
    {
        return subtract(b).length();
    }

}
