package com.example.myapplication;

import android.content.Intent;

import java.io.Serializable;

public class Calculator implements Serializable {

    private Float fFirstNum;
    private Float fSecondNum;
    private StringBuilder fStrFirstNum;
    private StringBuilder fStrSecondNum;

    static enum eTasks {plus, minus, multiply, divide}

    ;

    private eTasks fTask = null;

    public void setTask(eTasks fTask) {
        this.fTask = fTask;
    }

    public eTasks getTask() {
        return fTask;
    }


    public Calculator() {

    }


    private Float plus() throws Exception {
        try {
            return (fFirstNum + fSecondNum);
        } catch (Exception e) {
            throw e;
        } catch (ExceptionInInitializerError e) {
            throw e;
        }
    }

    private Float minus() throws Exception {
        try {
            return fFirstNum - fSecondNum;
        } catch (Exception e) {
            throw e;
        } catch (ExceptionInInitializerError e) {
            throw e;
        }
    }


    private Float multiply() throws Exception {
        try {
            return fFirstNum * fSecondNum;
        } catch (Exception e) {
            throw e;
        } catch (ExceptionInInitializerError e) {
            throw e;
        }
    }


    private Float divide() throws Exception {
        try {
            return fFirstNum / fSecondNum;
        } catch (Exception e) {
            throw e;
        } catch (ExceptionInInitializerError e) {
            throw e;
        }
    }


    public StringBuilder getfStrFirstNum() {
        return fStrFirstNum;
    }

    public void setfStrFirstNum(StringBuilder fStrirstNum) {
        this.fStrFirstNum = fStrirstNum;
    }

    public void appendfStrFirstNum(String fStrirstNum) {
        this.fStrFirstNum.append(fStrirstNum);
    }

    public StringBuilder getfStrSecondNum() {
        return fStrSecondNum;
    }

    public void setfStrSecondNum(StringBuilder fStrSecondNum) {
        this.fStrSecondNum = fStrSecondNum;
    }

    public void appendfStrSecondNum(String fStrSecondNum) {
        this.fStrSecondNum.append(fStrSecondNum);
    }

    public Float DoTask() throws Exception {
        Float xRes = null;
        if (fTask.equals(null) || fStrFirstNum.equals(null) || fStrSecondNum.equals(null))
            throw new Exception("Не введены данные, либо не выбрана операция.");
        try {
            if (fStrFirstNum.indexOf(".") != -1) {

            }
            fFirstNum = Float.parseFloat(fStrFirstNum.toString());
            fSecondNum = Float.parseFloat(fStrSecondNum.toString());
            switch (fTask) {
                case plus:
                    xRes = plus();
                    break;
                case minus:
                    xRes = minus();
                    break;
                case multiply:
                    xRes = multiply();
                    break;
                case divide:
                    xRes = divide();
                    break;
            }
            return xRes;
        } catch (NumberFormatException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        }
    }
}
