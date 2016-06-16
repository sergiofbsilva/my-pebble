package com.sfbs.sandbox;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import com.mitchellbosecke.pebble.PebbleEngine;
import com.mitchellbosecke.pebble.error.PebbleException;
import com.mitchellbosecke.pebble.template.PebbleTemplate;

/**
 * Hello world!
 *
 */
public class App {

    static class Foo {

        public Bar getBar(String dan) {
            return new Bar(dan);
        }
    }

    static class Bar {

        String name;

        public Bar(String name) {
            this.name = name;
        }

        public String getAsNumber(String x) {
            return "name " + x;
        }
    }

    public static void main(String[] args) throws PebbleException, IOException {
        PebbleEngine engine = new PebbleEngine();
        PebbleTemplate compiledTemplate = engine.getTemplate("templateName.html");

        Writer writer = new StringWriter();

        Map<String, Object> context = new HashMap<>();
        context.put("xpto", new Foo());

        compiledTemplate.evaluate(writer, context);

        String output = writer.toString();

        System.out.println(output);
    }
}
