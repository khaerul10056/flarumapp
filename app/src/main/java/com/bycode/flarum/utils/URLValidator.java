package com.bycode.flarum.utils;

import java.util.Objects;

/**
 * Created by michal on 22.04.2017.
 */

public class URLValidator{
    public URLValidator() {

    }

    public String getValidURL(String url) {
        String final_url = url;
        int last_char_num = url.length() - 1;
        String last_char = url.substring(last_char_num);

        if (!Objects.equals(last_char, "/")) {
            final_url = url+"/";
        }
        return final_url;
    }

}