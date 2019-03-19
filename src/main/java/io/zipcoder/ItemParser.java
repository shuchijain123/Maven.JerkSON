package io.zipcoder;

import io.zipcoder.utils.Item;
import io.zipcoder.utils.ItemParseException;
import io.zipcoder.utils.FileReader;

import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ItemParser {
    Pattern pattern1 = null;
    Matcher matcher1 = null;
    Item myItem = null;


    List<Item> itemList = new ArrayList<>();

    public List<Item> parseItemList(String valueToParse) throws ItemParseException {


            String[] valueParserArray = valueToParse.split("##");


            for (int i = 0; i < valueParserArray.length; i++) {
                try {
                    myItem = parseSingleItem(valueParserArray[i] + "##");
                    itemList.add(myItem);

                }

                catch (ItemParseException e) {
                    e.printStackTrace();
                }
            }






        return itemList;
    }

    public Item parseSingleItem(String singleItem) throws ItemParseException {
        Matcher matcher= null;

     try {
         String delimiter = "[:|\\^|\\%|\\*|@|;]";
         String stringparse = "naMe" + delimiter + "(\\w+)" + delimiter +
                 "price" + delimiter + "(\\d+.\\d*)" + delimiter
                 + "type" + delimiter + "(\\w+)" + delimiter +
                 "expiration" + delimiter + "(\\d{1,2}/\\d{1,2}/\\d{2,4})##";

         Pattern pattern = Pattern.compile(stringparse, Pattern.CASE_INSENSITIVE);
         matcher = pattern.matcher(singleItem);

         matcher.find();
         matcher.group(1);
         matcher.group(2);
         matcher.group(3);
         matcher.group(4);


     }
     catch (Exception e) {
       throw new ItemParseException();
     }

        Item item = new Item(matcher.group(1).toLowerCase(),
                Double.valueOf(matcher.group(2)), matcher.group(3).toLowerCase(), matcher.group(4));
       return item;
    }

}






