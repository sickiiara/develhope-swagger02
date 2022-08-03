package co.develhope.Swagger02.controllers;

import co.develhope.Swagger02.entities.ArithmeticOperations;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/math")
public class MathController {

    String[] divProperties = new String[]{"distributive","invariant"};

    @GetMapping(value = "")
    @ApiOperation(value = "welcome the user", notes = "print a welcome message")
    @ResponseStatus(HttpStatus.OK)
    @ApiResponse(code = 500, message = "Internal error")
    public String welcomeMathMessage(){
        return "Welcome to the math controller";
    }

    @GetMapping(value ="/division-info")
    @ApiOperation(value ="Division Properties",notes = "exposes the properties of the division")
    @ResponseStatus(HttpStatus.OK)
    @ApiResponses({@ApiResponse(code = 400, message = "Bad input"),
            @ApiResponse(code = 404, message = "Page not found"),
            @ApiResponse(code = 500, message = "Internal error")})

    public ArithmeticOperations division(){
        return new ArithmeticOperations ("Division","inverse operation of multiplication",2, divProperties);
    }

    @GetMapping(value = "/multiplication")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Multiplication",notes = "Returns the product of two numbers")
    @ApiResponses({@ApiResponse(code = 400, message = "Bad input"),
            @ApiResponse(code = 404, message = "Page not found"),
            @ApiResponse(code = 500, message = "Internal error")})

    public int product (@RequestParam Integer int1 , @RequestParam Integer int2){
        return (int1 * int2);
    }

    @GetMapping(value = "/square{n}")
    @ApiOperation(value = "square", notes = "Return the square of the number (n * n)" )
    @ResponseStatus(HttpStatus.OK)
    @ApiResponses({@ApiResponse(code = 400, message = "Bad input"),
            @ApiResponse(code = 404, message = "Page not found"),
            @ApiResponse(code = 500, message = "Internal error")})
    public int square (@RequestParam int a){
        return a * a;
    }






}