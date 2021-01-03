package net.antra.design.builder.lombomDemo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Car {
    private String frame;
    private String struts;
    private String suspension;
    private String tireBrand;
    private int modelYear;
    private String model;
    private String make;
    private int msrp;
    private String VIN;

}
