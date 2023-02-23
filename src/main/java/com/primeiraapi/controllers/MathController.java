package com.primeiraapi.controllers;

import com.primeiraapi.converters.NumberConverter;
import com.primeiraapi.exceptions.UnsupportedMathOperationException;
import com.primeiraapi.math.SimpleMath;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class MathController {

    private final AtomicLong counter = new AtomicLong();

    private SimpleMath math = new SimpleMath();
    @Resource
    private NumberConverter numberConverter;

    @RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double sum(
            //@RequestParam -> preciso de indicar o nome da variavel e o seu resultado, ex: "/sum/numberOne=1/numberTwo=2"
            //@PathVariable -> não preciso de indicar o nome da variavel e o seu resultado, vai buscar diretamente ao campo do url, ex: "/sum/1/2"
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo) throws Exception{
        if(!numberConverter.isNumeric(numberOne) || !numberConverter.isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
        return math.sum(numberConverter.convertToDouble(numberOne), numberConverter.convertToDouble(numberTwo));
    }

    @RequestMapping(value = "/sub/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double sub(
            //@RequestParam -> preciso de indicar o nome da variavel e o seu resultado, ex: "/sum/numberOne=1/numberTwo=2"
            //@PathVariable -> não preciso de indicar o nome da variavel e o seu resultado, vai buscar diretamente ao campo do url, ex: "/sum/1/2"
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo) throws Exception{
        if(!numberConverter.isNumeric(numberOne) || !numberConverter.isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
        return math.sub(numberConverter.convertToDouble(numberOne), numberConverter.convertToDouble(numberTwo));
    }

    @RequestMapping(value = "/mul/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double mul(
            //@RequestParam -> preciso de indicar o nome da variavel e o seu resultado, ex: "/sum/numberOne=1/numberTwo=2"
            //@PathVariable -> não preciso de indicar o nome da variavel e o seu resultado, vai buscar diretamente ao campo do url, ex: "/sum/1/2"
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo) throws Exception{
        if(!numberConverter.isNumeric(numberOne) || !numberConverter.isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
        return math.mul(numberConverter.convertToDouble(numberOne), numberConverter.convertToDouble(numberTwo));
    }

    @RequestMapping(value = "/div/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double div(
            //@RequestParam -> preciso de indicar o nome da variavel e o seu resultado, ex: "/sum/numberOne=1/numberTwo=2"
            //@PathVariable -> não preciso de indicar o nome da variavel e o seu resultado, vai buscar diretamente ao campo do url, ex: "/sum/1/2"
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo) throws Exception{
        if(!numberConverter.isNumeric(numberOne) || !numberConverter.isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }

        if (numberConverter.convertToDouble(numberTwo) == 0){
            throw new UnsupportedMathOperationException("Cant divide by 0!");
        }
        return math.div(numberConverter.convertToDouble(numberOne), numberConverter.convertToDouble(numberTwo));
    }

    @RequestMapping(value = "/med/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double med(
            //@RequestParam -> preciso de indicar o nome da variavel e o seu resultado, ex: "/sum/numberOne=1/numberTwo=2"
            //@PathVariable -> não preciso de indicar o nome da variavel e o seu resultado, vai buscar diretamente ao campo do url, ex: "/sum/1/2"
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo) throws Exception{
        if(!numberConverter.isNumeric(numberOne) || !numberConverter.isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }

        return math.med(numberConverter.convertToDouble(numberOne), numberConverter.convertToDouble(numberTwo));
    }

    @RequestMapping(value = "/sqr/{numberOne}", method = RequestMethod.GET)
    public Double sqr(
            //@RequestParam -> preciso de indicar o nome da variavel e o seu resultado, ex: "/sum/numberOne=1/numberTwo=2"
            //@PathVariable -> não preciso de indicar o nome da variavel e o seu resultado, vai buscar diretamente ao campo do url, ex: "/sum/1/2"
            @PathVariable(value = "numberOne") String numberOne) throws Exception{
        if(!numberConverter.isNumeric(numberOne)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }

        if (numberConverter.convertToDouble(numberOne) < 0) {
            throw new UnsupportedMathOperationException("Please set a positive value!");
        }
        return math.sqr(numberConverter.convertToDouble(numberOne));
    }






}
