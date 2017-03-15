package edu.shu.styluo.search.data;

/**
 * Created by a1056 on 2017/3/15.
 */

public class PrescriptionDetail {
    public PrescriptionDetail(String deiseaseName, String prescriptionName, String prescriptionIntro, String symptomIntro){
        this.disease_name = deiseaseName;
        this.prescription_name = prescriptionName;
        this.prescription_intro = prescriptionIntro;
        this.symptom_intro = symptomIntro;
    }

    public String getPrescription_name() {
        return prescription_name;
    }

    public void setPrescription_name(String prescription_name) {
        this.prescription_name = prescription_name;
    }

    public String getDisease_name() {
        return disease_name;
    }

    public void setDisease_name(String disease_name) {
        this.disease_name = disease_name;
    }

    public String getPrescription_intro() {
        return prescription_intro;
    }

    public void setPrescription_intro(String prescription_intro) {
        this.prescription_intro = prescription_intro;
    }

    public String getSymptom_intro() {
        return symptom_intro;
    }

    public void setSymptom_intro(String symptom_intro) {
        this.symptom_intro = symptom_intro;
    }

    String disease_name;

    String prescription_name;

    String prescription_intro;

    String symptom_intro;
}
