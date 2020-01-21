package bootstrap;

import fuel.MassfulFuelRequirement;
import fuel.MasslessFuelRequirement;

import java.util.Arrays;

public class Day1 {

    private static final String input = "53247\n" +
            "140268\n" +
            "139961\n" +
            "87816\n" +
            "102986\n" +
            "122415\n" +
            "140484\n" +
            "56099\n" +
            "52832\n" +
            "56999\n" +
            "122823\n" +
            "130608\n" +
            "83149\n" +
            "144224\n" +
            "104559\n" +
            "108523\n" +
            "126571\n" +
            "137284\n" +
            "83197\n" +
            "109996\n" +
            "56795\n" +
            "73112\n" +
            "50043\n" +
            "130097\n" +
            "113563\n" +
            "91200\n" +
            "130589\n" +
            "83725\n" +
            "108625\n" +
            "131977\n" +
            "95213\n" +
            "149800\n" +
            "70756\n" +
            "86240\n" +
            "134854\n" +
            "148919\n" +
            "114460\n" +
            "95062\n" +
            "122989\n" +
            "57274\n" +
            "112074\n" +
            "139530\n" +
            "131217\n" +
            "55652\n" +
            "125522\n" +
            "77304\n" +
            "144873\n" +
            "86811\n" +
            "107768\n" +
            "70704\n" +
            "146300\n" +
            "87256\n" +
            "118752\n" +
            "52585\n" +
            "126269\n" +
            "124559\n" +
            "52592\n" +
            "112097\n" +
            "123090\n" +
            "101778\n" +
            "136424\n" +
            "74547\n" +
            "119337\n" +
            "143570\n" +
            "113426\n" +
            "146458\n" +
            "88135\n" +
            "100236\n" +
            "148224\n" +
            "98718\n" +
            "135181\n" +
            "56608\n" +
            "109671\n" +
            "144027\n" +
            "135192\n" +
            "111620\n" +
            "69411\n" +
            "107957\n" +
            "88448\n" +
            "64972\n" +
            "63010\n" +
            "100625\n" +
            "96144\n" +
            "61998\n" +
            "59813\n" +
            "124503\n" +
            "64306\n" +
            "73119\n" +
            "77094\n" +
            "136295\n" +
            "132224\n" +
            "125713\n" +
            "110137\n" +
            "51478\n" +
            "90272\n" +
            "133506\n" +
            "72218\n" +
            "100082\n" +
            "106377\n" +
            "140290";

    private static void day1() {
        Integer amountOfFuel = Arrays.stream(input.split("\n"))
                .map(Integer::parseInt)
                .map(MasslessFuelRequirement::new)
                .mapToInt(MasslessFuelRequirement::getAmountOfFuel)
                .sum();

        System.out.println(amountOfFuel);
    }

    private static void day2() {
        Integer amountOfFuel = Arrays.stream(input.split("\n"))
                .map(Integer::parseInt)
                .map(MassfulFuelRequirement::new)
                .mapToInt(MassfulFuelRequirement::getAmountOfFuel)
                .sum();

        System.out.println(amountOfFuel);
    }

    public static void main(String[] args) {
        day1();
        day2();
    }

}
