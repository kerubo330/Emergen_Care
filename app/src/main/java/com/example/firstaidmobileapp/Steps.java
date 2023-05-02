package com.example.firstaidmobileapp;

public class Steps {
    String procedure;
    int image;
    
    public Steps(String procedure,int image){
        this.procedure= procedure;
        this.image = image;
    }

    public String getProcedure() {
        return procedure;
    }

    public void setProcedure(String procedure) {
        this.procedure = procedure;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }


}
