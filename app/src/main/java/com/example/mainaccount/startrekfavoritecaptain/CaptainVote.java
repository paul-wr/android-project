package com.example.mainaccount.startrekfavoritecaptain;


/**
 * @author Paul Wrenn
 */

public class CaptainVote {

    private static int voteK, voteP, voteS, voteJ, voteA;
    private static String nameK, nameP, nameS, nameJ, nameA, result;


    public void setKirk(String name, int vote) {
        nameK = name;
        voteK = voteK + vote;
    }

    public void setPicard(String name, int vote) {
        nameP = name;
        voteP = voteP + vote;
    }

    public void setSisko(String name, int vote) {
        nameS = name;
        voteS = voteS + vote;
    }

    public void setJaneway(String name, int vote) {
        nameJ = name;
        voteJ = voteJ + vote;
    }

    public void setArcher(String name, int vote) {
        nameA = name;
        voteA = voteA + vote;


    }


    public static String computeFavCaptain() {
        if (voteK > voteP && voteK > voteS && voteK > voteJ && voteK > voteA) {
            result = nameK;
        } else if (voteP > voteK && voteP > voteS && voteP > voteJ && voteP > voteA) {
            result = nameP;
        } else if (voteS > voteK && voteS > voteP && voteS > voteJ && voteS > voteA) {
            result = nameS;
        } else if (voteJ > voteK && voteJ > voteP && voteJ > voteS && voteJ > voteA) {
            result = nameJ;
        } else if (voteA > voteK && voteA > voteP && voteA > voteS && voteA > voteJ) {
            result = nameA;
        }
        return result;

    }
}