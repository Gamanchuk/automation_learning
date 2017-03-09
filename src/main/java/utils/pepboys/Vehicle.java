package utils.pepboys;

public class Vehicle {
    private String modelYear;
    private String make;
    private String model;
    private String engine;
    private String drivetrain;
    private String trim;

    public Vehicle(String modelYear, String make, String model, String engine, String drivetrain, String trim) {
        this.modelYear = modelYear;
        this.model = model;
        this.make = make;
        this.engine = engine;
        this.drivetrain = drivetrain;
        this.trim = trim;

    }

    public String getModelYear() {
        return modelYear;
    }

    public String getModel() {
        return model;
    }

    public String getMake() {
        return make;
    }

    public String getEngine() {
        return engine;
    }

    public String getDrivetrain() {
        return drivetrain;
    }

    public String getTrim() {
        return trim;
    }

}
