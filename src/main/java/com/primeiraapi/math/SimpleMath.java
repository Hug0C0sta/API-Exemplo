package com.primeiraapi.math;

public class SimpleMath {

    public Double sum(Double numberOne, Double numberTwo){
        return numberOne + numberTwo;
    }

    public Double sub(Double numberOne, Double numberTwo){
        return numberOne - numberTwo;
    }

    public Double mul(Double numberOne, Double numberTwo){
        return numberOne * numberTwo;
    }

    public Double div(Double numberOne, Double numberTwo){
        return numberOne / numberTwo;
    }

    public Double med(Double numberOne, Double numberTwo){
        return (numberOne + numberTwo) / 2;
    }

    public Double sqr(Double number){
        return Math.sqrt(number);
    }

}
