package com.example.adzanapp;

public class AdzanModel {

    private String negara;
    private String muadzin;
    private int audioRes;
    private int flagRes;
    private String[] arab;
    private String[] latin;
    private int[] durations;

    public AdzanModel(String negara, String muadzin, int audioRes, int flagRes,
                      String[] arab, String[] latin, int[] durations) {
        this.negara = negara;
        this.muadzin = muadzin;
        this.audioRes = audioRes;
        this.flagRes = flagRes;
        this.arab = arab;
        this.latin = latin;
        this.durations = durations;
    }

    public String getNegara() {
        return negara;
    }

    public String getMuadzin() {
        return muadzin;
    }

    public int getAudioRes() {
        return audioRes;
    }

    public int getFlagRes() {
        return flagRes;
    }

    public String[] getArab() {
        return arab;
    }

    public String[] getLatin() {
        return latin;
    }

    public int[] getDurations() {
        return durations;
    }
}






