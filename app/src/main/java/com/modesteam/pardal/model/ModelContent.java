package com.modesteam.pardal.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by laerciojunior on 30/04/15.
 */
public class ModelContent {
    /**
     * An array of sample (dummy) items.
     */
    public static List<Model> ITEMS = new ArrayList<Model>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static Map<Integer, Model> ITEM_MAP = new HashMap<Integer, Model>();

    static {
        // Add 6 sample items.
        addItem(new Model(1, "Estado"));
        addItem(new Model(2, "Cidade"));
        addItem(new Model(3, "Rodovia"));
        addItem(new Model(4, "Modelo"));
        addItem(new Model(5, "Tipo"));
        addItem(new Model(6, "Marca"));
    }

    private static void addItem(Model item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    /**
     * A dummy item representing a piece of content.
     */
    public static class Model {
        public int id;
        public String content;

        public Model(int id, String content) {
            this.id = id;
            this.content = content;
        }

        @Override
        public String toString() {
            return content;
        }
    }

}