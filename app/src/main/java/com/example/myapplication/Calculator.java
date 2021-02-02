package com.example.myapplication;

import android.content.Intent;

public class Calculator   {

    private Integer _fNum;
    private Integer _sNum;

    public Calculator(Integer pNum1, Integer pNum2){

    }

    public Integer plus()throws Exception{
        try {
            return _fNum + _sNum;
        }
        catch (Exception e)
        {
            throw e;
        }
        catch (ExceptionInInitializerError e)
        {
            throw e;
        }
    }

    public Integer minus()throws Exception{
        try {
            return _fNum - _sNum;
        }
        catch (Exception e)
        {
            throw e;
        }
        catch (ExceptionInInitializerError e)
        {
            throw e;
        }
    }


    public Integer multiply()throws Exception{
        try {
            return _fNum * _sNum;
        }
        catch (Exception e)
        {
            throw e;
        }
        catch (ExceptionInInitializerError e)
        {
            throw e;
        }
    }


    public Integer divide()throws Exception{
        try {
            return _fNum / _sNum;
        }
        catch (Exception e)
        {
            throw e;
        }
        catch (ExceptionInInitializerError e)
        {
            throw e;
        }
    }
}
