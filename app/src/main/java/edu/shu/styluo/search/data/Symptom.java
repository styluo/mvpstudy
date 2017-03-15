package edu.shu.styluo.search.data;

/**
 * Created by a1056 on 2017/3/15.
 */

public class Symptom {
    public Symptom(String diseaseName, String symptomIntro){
        this.disease_name = diseaseName;
        this.symptom_intro = symptomIntro;
    }

    public String getDisease_name() {
        return disease_name;
    }

    public void setDisease_name(String disease_name) {
        this.disease_name = disease_name;
    }

    public String getSymptom_intro() {
        return symptom_intro;
    }

    public void setSymptom_intro(String symptom_intro) {
        this.symptom_intro = symptom_intro;
    }

    String disease_name;

    String symptom_intro;
}
