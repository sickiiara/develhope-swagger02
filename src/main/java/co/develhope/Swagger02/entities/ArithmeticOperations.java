package co.develhope.Swagger02.entities;
import io.swagger.annotations.ApiModelProperty;

public class ArithmeticOperations {

    public ArithmeticOperations() {
    }

    public ArithmeticOperations(String name, String description, Integer minNumberOfOperands, String[] properties) {
        this.name = name;
        this.description = description;
        this.minNumberOfOperands = minNumberOfOperands;
        this.properties = properties;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getMinNumberOfOperands() {
        return minNumberOfOperands;
    }

    public void setMinNumberOfOperands(Integer minNumberOfOperands) {
        this.minNumberOfOperands = minNumberOfOperands;
    }

    public String[] getProperties() {
        return properties;
    }

    public void setProperties(String[] properties) {
        this.properties = properties;
    }

    @ApiModelProperty(value = "Name of the operation", example = "Multiplication")
    private String name;
    @ApiModelProperty(value = "Description of the operation", example = "Product is ")
    private String description;
    @ApiModelProperty(value = "Min number of operand for the operation",example = "2")
    private Integer minNumberOfOperands;
    @ApiModelProperty(value = "An array of the operation properties",example = "commutative, associative, distributive")
    private String[] properties;


}