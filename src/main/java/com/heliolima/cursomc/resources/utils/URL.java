package com.heliolima.cursomc.resources.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 *
 * @author Helio
 */
public class URL {
    
    public static List<Integer> decodeIntList(String s)
    {
        /*String[] vet = s.split(",");
        List<Integer> list = new ArrayList<>();
        for (String vet1 : vet) {
            list.add(Integer.parseInt(vet1));
        }
        return list;*/
        return Arrays.asList(s.split(",")).stream().map(x -> Integer.parseInt(x)).collect(Collectors.toList());
    }
    
    public static String decodeParam(String s)
    {
        try {
            return URLDecoder.decode(s, "UTF-8");
        } catch (UnsupportedEncodingException ex) {
            return "";
        }
    }
    
}
