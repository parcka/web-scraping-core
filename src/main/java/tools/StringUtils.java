package tools;

/**
 * Created by XTR100 on 15/10/2016.
 */
public class StringUtils {


    public static String getStringFromArray(String[] arr) {


        StringBuilder builder = new StringBuilder();
        for (String s
                : arr)
        {

            builder.append(s.trim());
        }

        return builder.toString();
    }

}
