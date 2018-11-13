package org.someorg.core;
/*
Written by xxx.
Written at 6/2/18.
*/

public class Score {

    double precision;
    double recall;

    double f_measure;

    double coverage;

    public Score() {

    }

    public double getPrecision() {
        return precision;
    }

    public void setPrecision(double precision) {
        this.precision = precision;
    }

    public double getRecall() {
        return recall;
    }

    public void setRecall(double recall) {
        this.recall = recall;
    }

    public double getF_measure() {
        return f_measure;
    }

    public void setF_measure(double f_measure) {
        this.f_measure = f_measure;
    }

    public double getCoverage() {
        return coverage;
    }

    public void setCoverage(double coverage) {
        this.coverage = coverage;
    }

}
