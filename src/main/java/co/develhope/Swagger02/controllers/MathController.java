package co.develhope.Swagger02.controllers;

import co.develhope.Swagger02.entities.ArithmeticOperations;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Math")
public class MathController {

    String[] divProperties = new String[]{"distributive","invariant"};

    @GetMapping(value = "")
    @ApiOperation(value = "welcome the user", notes = "Print a welcome message")
    @ResponseStatus(HttpStatus.OK)
    @ApiResponse(code = 500, message = "INTERNAL SERVER ERROR")
    public String welcomeMathMessage(){
        return "Welcome to math controller";
    }

    @GetMapping(value ="/division-info")
    @ApiOperation(value ="Division Properties",notes = "exposes the properties of the division")
    @ResponseStatus(HttpStatus.OK)
    @ApiResponses({@ApiResponse(code = 400, message = "BAD INPUT"),
            @ApiResponse(code = 404, message = "PAGE NOT FOUND"),
            @ApiResponse(code = 500, message = "INTERNAL SERVER ERROR")})

    public ArithmeticOperations division(){
        return new ArithmeticOperations ("Division","inverse operation of multiplication",2, divProperties);
    }

    String[] multProperties = new String[]{"commutative", "associative", "dissociative", "removing a common factor", "neutral element"};
    @GetMapping(value = "/multiplication")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Multiplication",notes = "Returns the product of two or more numbers")
    @ApiResponses({@ApiResponse(code = 400, message = "BAD INPUT"),
            @ApiResponse(code = 404, message = "PAGE NOT FOUND"),
            @ApiResponse(code = 500, message = "INTERNAL SERVER ERROR")})

    public ArithmeticOperations multiplication (@RequestParam(required = true) Integer int1 ,@RequestParam(required = true) Integer int2){
        return new ArithmeticOperations("Multiplication", "a * b", 2,multProperties);
    }

    @GetMapping(value = "/square{n}")
    @ApiOperation(value = "square", notes = "Return the square of the number (n * n)" )
    @ResponseStatus(HttpStatus.OK)
    @ApiResponses({@ApiResponse(code = 400, message = "BAD INPUT"),
            @ApiResponse(code = 404, message = "PAGE NOT FOUND"),
            @ApiResponse(code = 500, message = "INTERNAL SERVER ERROR")})
    public Integer square (@RequestParam(required = true)Integer a){
        return a ^ 2;
    }






}