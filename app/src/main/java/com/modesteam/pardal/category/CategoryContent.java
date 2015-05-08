package com.modesteam.pardal.category;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p/>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class CategoryContent {

    /**
     * An array of sample (dummy) items.
     */
    public static List<Category> ITEMS = new ArrayList<Category>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static Map<Integer, Category> ITEM_MAP = new HashMap<Integer, Category>();

    static {
        // Add 6 sample items.
        addItem(new Category(1, "Estado"));
        addItem(new Category(2, "Cidade"));
        addItem(new Category(3, "Rodovia"));
        addItem(new Category(4, "Modelo"));
        addItem(new Category(5, "Tipo"));
        addItem(new Category(6, "Marca"));
    }

    private static void addItem(Category item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    /**
     * A dummy item representing a piece of content.
     */
    public static class Category {
        public int id;
        public String content;

        public Category(int id, String content) {
            this.id = id;
            this.content = content;
        }

        @Override
        public String toString() {
            return content;
        }
    }
}
