package basics.class_problems;

public class BmiCalculator {

    public static String getBmiStatus(double bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi <= 24.9) {
            return "Normal";
        } else if (bmi <= 29.9) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }

    public static void printWellnessReport(double[] heights, double[] weights) {
        if (heights == null || weights == null) return;
        System.out.println("Person | Height (m) | Weight (kg) | BMI | Status");
        int count = Math.min(heights.length, weights.length);
        for (int i = 0; i < count; i++) {
            double h = heights[i];
            double w = weights[i];
            double bmi = w / (h * h);
            String status = getBmiStatus(bmi);
            System.out.printf("Person %d — Height: %.2f m, Weight: %.2f kg | BMI: %.2f | Status: %s%n",
                    (i + 1), h, w, bmi, status);
        }
    }
}