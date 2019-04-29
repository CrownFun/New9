/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.grzegorz.strategy;


public class LowerCaseFormatter implements TextFormatterStrategy {

    @Override
    public String format(String text) {
        return text.toLowerCase();
    }

}
