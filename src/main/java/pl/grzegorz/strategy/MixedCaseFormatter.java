/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.grzegorz.strategy;


public class MixedCaseFormatter implements TextFormatterStrategy {

    @Override
    public String format(String text) {
        StringBuilder result = new StringBuilder(text.length());
        int index = 0;

        for (char character : text.toCharArray()) {
            if (Character.isLetter(character)) {
                if (index % 2 == 0) {
                    result.append(Character.toUpperCase(character));
                } else {
                    result.append(character);
                }
                index++;
            } else {
                result.append(character);
            }
        }

        return result.toString();

    }

}
