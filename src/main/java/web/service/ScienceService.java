package web.service;

public class ScienceService {

    public static double calculateForce(String mass, String acceleration) {
        double m = Double.parseDouble(mass);
        double a = Double.parseDouble(acceleration);
        return m * a;
    }
}
