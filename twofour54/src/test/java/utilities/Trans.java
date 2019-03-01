package utilities;

import cucumber.api.Transformer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


public class Trans extends Transformer<Date> {

    @Override
    public Date transform(String s) {


        Date format = new Date();
        try {
            format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }


        System.out.println("Trying to print date:" + format);


        return format;
    }
}
