package com.amtudio.electionapp;

public class Candidate {

    private String name;
    private int symbol;

    public Candidate() {
    }

    public Candidate(String name, int symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSymbol() {
        return symbol;
    }

    public void setSymbol(int symbol) {
        this.symbol = symbol;
    }
}
