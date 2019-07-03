package com.company;

public class NumberOfTaskDone {

    Integer[] m_NumberOfTaskDone;

    public NumberOfTaskDone(){
        m_NumberOfTaskDone = new Integer[1];
        m_NumberOfTaskDone[0] = 0;
    }

    public int getValue(){
        return m_NumberOfTaskDone[0];
    }

    public void setValue(int value){
        m_NumberOfTaskDone[0] = value;
    }
    public static void main(String[] args) {

        for(int i = 0; i < 20; i++) {
            long value = (long) Main.getRandom(0,10);
            System.out.println(value);
        }
    }

}
