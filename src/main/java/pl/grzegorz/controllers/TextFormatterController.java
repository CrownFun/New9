/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.grzegorz.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.grzegorz.strategy.FormatterContext;
import pl.grzegorz.strategy.LowerCaseFormatter;
import pl.grzegorz.strategy.MixedCaseFormatter;
import pl.grzegorz.strategy.UpperCaseFormatter;


@Controller
public class TextFormatterController {

    private static final String UPPER = "upper";
    private static final String LOWER = "lower";
    private static final String MIXED = "mixed";

    @Autowired
    private FormatterContext context;

    @PostMapping
    public String textFormat(@RequestParam(defaultValue = "example") String sample,
                             @RequestParam(required = false) String formatter,
                             RedirectAttributes redirectAttr) {

        String textFormatted = null;

        switch (formatter) {
            case UPPER: {
                context.setTextFormatterStrategy(new UpperCaseFormatter());
                textFormatted = context.formatText(sample);
                break;
            }
            case LOWER: {
                context.setTextFormatterStrategy(new LowerCaseFormatter());
                textFormatted = context.formatText(sample);
                break;
            }
            case MIXED: {
                context.setTextFormatterStrategy(new MixedCaseFormatter());
                textFormatted = context.formatText(sample);
                break;
            }
        }

        redirectAttr.addFlashAttribute("textFormatted", textFormatted);
        return "redirect:/";
    }

}
