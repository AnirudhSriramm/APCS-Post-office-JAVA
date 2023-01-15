import java.util.Scanner;
import java.text.DecimalFormat;

public class Main {
    static Double packageLength;
    static Double packageHeight;
    static Double packageThickness;
    static Double packageWeight;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String inputDimension = input.next();
        String[] dimension = inputDimension.split(",", 0);
        packageLength = Double.parseDouble(dimension[0]);
        packageHeight = Double.parseDouble(dimension[1]);
        packageThickness = Double.parseDouble(dimension[2]);
        packageWeight = Double.parseDouble(dimension[3]);
        String cost;
        cost = packageCheck();
        System.out.println(cost);
    }

    private static final DecimalFormat df = new DecimalFormat("0.00");
    static double regPostCost = .20;
    static double largePostCost = 0.30;
    static double envelopeCost = 0.47;
    static double largeEnvelopeCost = 0.56;
    static double packageCost = 1.50;
    static double largePackageCost = 1.75;
    static double smallPostcardWeight = 0.0625;
    static double largePackageWeight = 0.50;

    public static String packageCheck() {
        //regular postcard
        if ((packageLength > 3.5 && packageLength <= 4.25)
                && (packageHeight > 3.5 && packageHeight <= 6.0)
                && (packageThickness > 0.007 && packageThickness <= 0.016)
        ) {
            System.out.println("this is Regular post card");
            return df.format(Math.ceil(packageWeight / smallPostcardWeight) * regPostCost);

        }

        //Large Post card
        else if ((packageLength > 4.25 && packageLength <= 6)
                && (packageHeight > 6.0 && packageHeight <= 11.5)
                && (packageThickness > .007 && packageThickness <= .016)) {
            System.out.println("this is large Postcard");
            return df.format(Math.ceil(packageWeight / smallPostcardWeight) * largePostCost);

        }

        //envelope
        else if ((packageLength > 3.5 && packageLength <= 6.125)
                && (packageHeight > 5.0 && packageHeight <= 11.5)
                && (packageThickness > .016 && packageThickness <= .25)) {
            System.out.println("this is large Postcard");
            return df.format(Math.ceil(packageWeight / smallPostcardWeight) * envelopeCost);
        }
        double packageSize = (packageThickness + packageHeight + packageLength) * 2;
        //Large envelope
        if ((packageLength > 6.125 && packageLength <= 24)
                && (packageHeight > 11 && packageHeight <= 18)
                && (packageThickness > .25 && packageThickness <= .5)) {
            System.out.println("this is large envelope");
            return df.format(Math.ceil(packageWeight / smallPostcardWeight) * largeEnvelopeCost);
        }
        //package
        else if (packageSize < 84 && packageSize > 42.5) {
            System.out.println("This is a package");
            return df.format(Math.ceil(packageWeight / largePackageWeight) * packageCost);
        }
        //Large package
        else if (packageSize > 84 && packageSize < 130) {
            System.out.println("This is a large package");
            return df.format(Math.ceil(packageWeight / largePackageWeight) * largePackageCost);

        } else {
            return "UNMAILABLE";
        }
    }
}