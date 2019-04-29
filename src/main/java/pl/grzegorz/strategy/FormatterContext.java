/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.grzegorz.strategy;

import org.springframework.stereotype.Service;

/**
 * @author Grześ
 */

@Service
public class FormatterContext {
    private TextFormatterStrategy textFormatterStrategy;

    public void setTextFormatterStrategy(TextFormatterStrategy textFormatterStrategy) {
        this.textFormatterStrategy = textFormatterStrategy;
    }

    public String formatText(String text) {
        return textFormatterStrategy.format(text);
    }


}
