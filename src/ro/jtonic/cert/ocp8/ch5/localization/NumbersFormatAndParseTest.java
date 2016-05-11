package ro.jtonic.cert.ocp8.ch5.localization;

import java.text.*;
import java.util.Locale;

/**
 * Created by antonelpazargic on 11/05/16.
 */
public class NumbersFormatAndParseTest {

    public static void main(String... args) throws ParseException {
        final int visitorsPerYear = 12_000_000;
        final int visitorsPerMonth = 1_000_000;
        final double priceOfTheTvSet = 3_012.12;

        System.out.println("=============");
        System.out.println("Number format in canada locale");
        System.out.println("=============");
        NumberFormat nfCa = NumberFormat.getInstance(Locale.CANADA);
        System.out.println("nfCa.format(visitorsPerYear) = " + nfCa.format(visitorsPerYear));
        System.out.println("nfCa.format(priceOfTheTvSet) = " + nfCa.format(priceOfTheTvSet));

        System.out.println("=============");
        System.out.println("Number format in Germany locale");
        System.out.println("==============");
        NumberFormat nfDe = NumberFormat.getInstance(Locale.GERMANY);
        System.out.println("nfDe.format(visitorsPerMonth) = " + nfDe.format(visitorsPerMonth));
        System.out.println("nfDe.format(priceOfTheTvSet) = " + nfDe.format(priceOfTheTvSet));

        System.out.println("=============");
        System.out.println("Number format in US locale");
        System.out.println("==============");
        NumberFormat nfUs = NumberFormat.getInstance(Locale.US);
        System.out.println("nfUs.format(visitorsPerYear) = " + nfUs.format(visitorsPerYear));
        System.out.println("nfUs.format(priceOfTheTvSet) = " + nfUs.format(priceOfTheTvSet));

        System.out.println("=============");
        System.out.println("Number format in french canada locale");
        System.out.println("==============");
        NumberFormat nfFrCa = NumberFormat.getInstance(Locale.CANADA_FRENCH);
        System.out.println("nfFrCa.format(visitorsPerYear) = " + nfFrCa.format(visitorsPerYear));
        System.out.println("nfFrCa.format(priceOfTheTvSet) = " + nfFrCa.format(priceOfTheTvSet));

        System.out.println("=============");
        System.out.println("Number format in french language locale");
        System.out.println("==============");
        NumberFormat nfFr = NumberFormat.getInstance(Locale.FRENCH);
        System.out.println("nfFr.format(visitorsPerMonth) = " + nfFr.format(visitorsPerMonth));
        System.out.println("nfFr.format(priceOfTheTvSet) = " + nfFr.format(priceOfTheTvSet));

        System.out.println("=============");
        System.out.println("Number format in default locale");
        System.out.println("Locale.getDefault() = " + Locale.getDefault());
        System.out.println("=============");
        NumberFormat nfDefLoc = NumberFormat.getInstance();
        System.out.println("nfDefLoc.format(visitorsPerYear) = " + nfDefLoc.format(visitorsPerYear));
        System.out.println("nfDefLoc.format(priceOfTheTvSet) = " + nfDefLoc.format(priceOfTheTvSet));

        System.out.println("=============");
        System.out.println("Parsing to numbers in different locales.");
        System.out.println("=============");
        System.out.println("nfFr.parse(\"12.34\") = " + nfFr.parse("12.34"));
        System.out.println("nfUs.parse(\"12.34\") = " + nfUs.parse("12.34"));

        NumberFormat efCurDef = NumberFormat.getCurrencyInstance();
        Locale locCatFrmt = Locale.getDefault(Locale.Category.FORMAT);
        System.out.println("locCatFrmt = " + locCatFrmt);
        System.out.println("efCurDef.format(priceOfTheTvSet) = " + efCurDef.format(priceOfTheTvSet));

        System.out.println("nfDefLoc.parse(\"123erf\") = " + nfDefLoc.parse("123erf"));
        // System.out.println("nfDefLoc.parse(\"x1002\") = " + nfDefLoc.parse("x1002")); // runtime exception java.text.ParseException: Unparseable number: "x1002"

        System.out.println("efCurDef.parse(\"RON3,100.23\") = " + efCurDef.parse("RON3,100.23"));
    }
}
