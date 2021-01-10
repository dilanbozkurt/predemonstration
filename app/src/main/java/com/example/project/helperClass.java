package com.example.project;

public class helperClass {
    String name;
    String mail;
    String age;
    String contact;
    String chronicDisease;
    String medicalInstrument;
    String bloodType;

    public helperClass(String name, String mail, String age, String contact) {
        this.name = name;
        this.mail = mail;
        this.age = age;
        this.contact = contact;
    }

    public helperClass(String chronicDisease, String medicalInstrument, String bloodType) {
        this.chronicDisease = chronicDisease;
        this.medicalInstrument = medicalInstrument;
        this.bloodType = bloodType;
    }

    public String getChronicDisease() {
        return chronicDisease;
    }

    public String getMedicalInstrument() {
        return medicalInstrument;
    }

    public String getBloodType() {
        return bloodType;
    }

    public helperClass() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}
