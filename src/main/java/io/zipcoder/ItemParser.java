package io.zipcoder;

import io.zipcoder.utils.Item;
import io.zipcoder.utils.ItemParseException;
import io.zipcoder.utils.FileReader;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ItemParser {
    Pattern pattern1 = null;
    Matcher matcher1 = null;


    List<Item> itemList = new ArrayList<>();

    public List<Item> parseItemList(String valueToParse) {
        return null;
    }

    public Item parseSingleItem(String singleItem) throws ItemParseException {

//"([^"]+)"\s*:\s*"([^"]+)",? -key value parser
        //(\\D+)(\\d)(\\w+)


        Item result = null;
        String name = null;
        Double price = null;
        String type = null;
        String expiration = null;

        String patternString = "^A-Za-z0-9\\s*([^|]*)^A-Za-z0-9\\s*|";
        Pattern pattern = Pattern.compile(patternString, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(singleItem);
        for (int matchNumber = 0; matcher.find(); matchNumber++) {

            if (matcher.find()) {

                //newline = matcher1.replaceAll(newString);


                matcher.toString().toLowerCase();

                //String value = matcher.group();

                System.out.println(matcher.toString());


                result = new Item(name, price, type, expiration);
                System.out.println(result);

            }


        }
        return result;
    }
}





