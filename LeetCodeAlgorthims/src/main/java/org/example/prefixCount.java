package org.example;

import java.util.Arrays;

public class prefixCount {
    public static void main(String[] args) {

        String[] words={"ua","btyivy","fwofb","zptjjv","jhopih","k","pajqarpfpf","w","cdyd","ljrdthdsoa"};
        String pref="owoeg";
        System.out.println(prefixCountMethod(words,pref));
    }

    /*
    Input: words = ["pay","attention","practice","attend"], pref = "at"
    Output: 2
    Explanation: The 2 strings that contain "at" as a prefix are: "attention" and "attend".
    */
    public static int prefixCountMethod(String[] words, String pref) {

        int number=pref.length();
        int count=0;
        for(int i=0;i<words.length;i++){

            String x="";
            if(words[i].length()<pref.length()){
                x=pref.substring(0,words[i].length());
            }else {
                x=words[i].substring(0,number);
            }

            if(x.equals(pref)) count++;
            System.out.println(x+" "+count);
        }
        return count;
    }


}
