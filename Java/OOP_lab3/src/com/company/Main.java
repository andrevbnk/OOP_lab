package com.company;

public class Main {
    //C3 = 2;
    //C13 = 16;
    public static void main(String[] args) {
	    String text = "drgraerrer gwg ggrtghawg awrg grsg rawr garg raergrar rgar rgar ";
	    String[] words = text.split(" ");
	    text = "";
	    for(int i = 0; i < words.length; i++){
	        if(words[i].isEmpty()){
	            continue;
            }
	        char last = words[i].charAt(words[i].length() - 1);
	        words[i] = words[i].replaceAll(String.valueOf(last), "");
	        words[i] += last;
            text += words[i] + " ";
	    }
	    System.out.println(text);
    }
}
