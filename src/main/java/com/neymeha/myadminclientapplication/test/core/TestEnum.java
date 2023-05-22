package com.neymeha.myadminclientapplication.test.core;

public class TestEnum {
    public static void main(String[] args) {
        CatFood food=CatFood.ID1;
        switch (food){
            case ID1 -> {
                CatFood.ID1.whatsTheName();
                break;
            }
            case ID2 -> {
                CatFood.ID2.whatsTheName();
                break;
            }
            case ID3 -> {
                CatFood.ID3.whatsTheName();
                break;
            }
        }
    }
}

enum CatFood {
    ID1("Super Food"){
        @Override
        void whatsTheName(){
            System.out.println(ID1.name1+" NO!");
        }
    },
    ID2("Jerk Food"),
    ID3("");

    private String name1;
    CatFood(String name) {
        this.name1 = name;
    }
    void whatsTheName(){
        System.out.println(this.name1);
    }

}
