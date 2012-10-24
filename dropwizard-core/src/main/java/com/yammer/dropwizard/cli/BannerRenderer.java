package com.yammer.dropwizard.cli;

import java.util.HashMap;
import java.util.Map;

/**
 * Generates an ASCII art banner for an image or message.
 */
public class BannerRenderer {

    private static final Map<Character, String[]> letters = new HashMap<Character, String[]>(52);

    static {
        letters.put(' ', new String[] {
                "    ",
                "    ",
                "    ",
                "    ",
                "    ",
                "    ",
                "    ",
                "    "
        });


        letters.put('a', new String[] {
                "        ",
                "        ",
                ".d8888b.",
                "88'  '88",
                "88.  .88",
                "`8888'`8",
                "        ",
                "        "
        });

        letters.put('b', new String[] {
                "db      ",
                "88      ",
                "888888b.",
                "88'  '88",
                "88.  .88",
                "8888888'",
                "        ",
                "        "
        });

        letters.put('c', new String[] {
                "        ",
                "        ",
                ".d8888b.",
                "88   ```",
                "88   ...",
                "`88888P'",
                "        ",
                "        "
        });

        letters.put('d', new String[] {
                "      db",
                "      88",
                ".d888888",
                "88'  '88",
                "88.  .88",
                "`8888888",
                "        ",
                "        "
        });

        letters.put('e', new String[] {
                "        ",
                "        ",
                ".d8888b.",
                "88oooodP",
                "88   ...",
                "`88888P'",
                "        ",
                "        "
        });

        letters.put('f', new String[] {
                "        ",
                "        ",
                ".d8888b.",
                "88'     ",
                "888888  ",
                "88'     ",
                "88      ",
                "8P      "
        });

        letters.put('g', new String[] {
                "        ",
                "        ",
                ".d8888b.",
                "88'  '88",
                "88.  .88",
                "`8888`88",
                "     .88",
                " oooo88'"
        });

        letters.put('h', new String[] {
                "db      ",
                "88      ",
                "888888b.",
                "88'  '88",
                "88    88",
                "8P    8P",
                "        ",
                "        "
        });

        letters.put('i', new String[] {
                "  ",
                "db",
                "..",
                "88",
                "88",
                "88",
                "  ",
                "  "
        });

        letters.put('j', new String[] {
                "    ",
                "  db",
                "    ",
                "  8b",
                "  88",
                "  88",
                "  88",
                "oo8'"
        });

        letters.put('k', new String[] {
                "        ",
                "db      ",
                "88  .dP ",
                "88.d8'  ",
                "88`8b.  ",
                "8P  `db.",
                "        ",
                "        "
        });

        letters.put('l', new String[] {
                "db",
                "88",
                "88",
                "88",
                "88",
                "8P",
                "  ",
                "  "
        });

        letters.put('m', new String[] {
                "          ",
                "          ",
                "88d8b.d8d.",
                "88'`88'`88",
                "88  88  88",
                "8P  8P  8P",
                "          ",
                "          "
        });

        letters.put('n', new String[] {
                "        ",
                "        ",
                "88d8888.",
                "88'  `88",
                "88    88",
                "8P    8P",
                "        ",
                "        "
        });

        letters.put('o', new String[] {
                "        ",
                "        ",
                ".d8888b.",
                "88'  `88",
                "88.  .88",
                "`88888P'",
                "        ",
                "        "
        });

        letters.put('p', new String[] {
                "        ",
                "        ",
                ".d8888b.",
                "88'  `88",
                "88.  .88",
                "88`8888'",
                "88      ",
                "8P      "
        });

        letters.put('q', new String[] {
                "        ",
                "        ",
                ".d8888b.",
                "88'  '88",
                "88.  .88",
                "`8888'88",
                "      88",
                "      8b"
        });

        letters.put('r', new String[] {
                "        ",
                "        ",
                ".d8888b.",
                "88'     ",
                "88      ",
                "88      ",
                "        ",
                "        "
        });
        letters.put('s', new String[] {
                "        ",
                "        ",
                ".d8888P ",
                "`8boooo.",
                "..   `88",
                "`88888P'",
                "        ",
                "        "
        });

        letters.put('t', new String[] {
                "       ",
                " db    ",
                "d88ooo ",
                " 88    ",
                " 88.   ",
                " `8888P",
                "       ",
                "       "
        });

        letters.put('u', new String[] {
                "        ",
                "        ",
                "db    db",
                "88    88",
                "88.  .88",
                "`888P`8P",
                "        ",
                "        "
        });

        letters.put('v', new String[] {
                "        ",
                "        ",
                "db    db",
                "88.  .88",
                "`88..88'",
                "  `88'  ",
                "        ",
                "        "
        });

        letters.put('w', new String[] {
                "          ",
                "          ",
                "db      db",
                "88  db  88",
                "88..88..88",
                "`8P`8P`8P'",
                "          ",
                "          "
        });

        letters.put('x', new String[] {
                "        ",
                "        ",
                "db.  .db",
                " `8bd8' ",
                " .d88b. ",
                "dP'  `dP",
                "        ",
                "        "
        });

        letters.put('y', new String[] {
                "        ",
                "        ",
                "db    db",
                "88    88",
                "88.  .88",
                "`888P`88",
                "      88",
                " oooo88'"
        });

        letters.put('z', new String[] {
                "        ",
                "        ",
                "d888888b",
                "   .dP' ",
                " .dP'   ",
                "d888888P",
                "        ",
                "        "
        });

        letters.put('0', new String[] {
                ".d8888b.",
                "88'  `88",
                "88 .. 88",
                "88 '' 88",
                "88.  .88",
                "`88888P'",
                "        ",
                "        "
        });

        letters.put('1', new String[] {
                ".d88  ",
                "  88  ",
                "  88  ",
                "  88  ",
                "  88  ",
                "d8888b",
                "      ",
                "      "
        });

        letters.put('2', new String[] {
                ".d8888b.",
                "``    8P",
                "    .dP ",
                "  .dP'  ",
                ".dP.    ",
                "`888888b",
                "        ",
                "        "
        });

        letters.put('3', new String[] {
                ".d8888b.",
                "```   88",
                "  .ooo88",
                "     `88",
                "...   88",
                "`88888P'",
                "        ",
                "        "
        });

        letters.put('4', new String[] {
                "  .db   ",
                " .dP    ",
                ".dP db  ",
                "`doo88oo",
                "   `88  ",
                "    8P  ",
                "        ",
                "        "
        });

        letters.put('5', new String[] {
                "8888888b",
                "88      ",
                "`8boooo.",
                "     `88",
                "db.  .88",
                "`88888P'",
                "        ",
                "        "
        });

        letters.put('6', new String[] {
                ".d8888b.",
                "d8.     ",
                "88boooo.",
                "88'  `88",
                "88.  .88",
                "`88888P'",
                "        ",
                "        "
        });

        letters.put('7', new String[] {
                "d8888888",
                "    .dP'",
                "   .dP' ",
                "  .dP'  ",
                " .dP'   ",
                ".dP'    ",
                "        ",
                "        "
        });

        letters.put('8', new String[] {
                ".d8888b.",
                "d8.  .8b",
                "`8booo8.",
                "88'  `88",
                "88.  .88",
                "`88888P'",
                "        ",
                "        "
        });

        letters.put('9', new String[] {
                ".d8888b.",
                "88.   88",
                "88    88",
                "`8888`88",
                "...  .88",
                "`88888P'",
                "        ",
                "        "
        });

        letters.put('.', new String[] {
                "  ",
                "  ",
                "  ",
                "  ",
                "88",
                "88",
                "  ",
                "  "
        });

        letters.put(',', new String[] {
                "  ",
                "  ",
                "  ",
                "  ",
                "d8",
                "88",
                ".P",
                "  "
        });

        letters.put('_', new String[] {
                "        ",
                "        ",
                "        ",
                "        ",
                "        ",
                "d888888b",
                "        ",
                "        "
        });

        letters.put('!', new String[] {
                "db",
                "88",
                "88",
                "8P",
                "  ",
                "8P",
                "  ",
                "  "
        });

        letters.put('?', new String[] {
                ".d8888b.",
                "`'   '88",
                "     .88",
                "   d88P'",
                "   `P   ",
                "        ",
                "   8P   ",
                "        "
        });

        letters.put('$', new String[] {
                "   db   ",
                ".888888.",
                "88.88 `'",
                "`88888b.",
                ".. 88`88",
                "`88888P'",
                "   8P   ",
                "        "
        });

        letters.put('%', new String[] {
                "d8b  .8'",
                "88P .8' ",
                "   .8'  ",
                "  .8'   ",
                " .8' d8b",
                ".8'  88P",
                "        ",
                "        "
        });

        letters.put('*', new String[] {
                "    d    ",
                "`8. 8 .8'",
                " `8.8.8' ",
                "d8888888b",
                " .8'8`8. ",
                ".8' 8 `8.",
                "    P    ",
                "         "
        });

        letters.put('@', new String[] {
                " .d888888b. ",
                ".8'      `8.",
                "8 .d8888b.`8",
                "8 88'  '88 8",
                "8 88.  .88 8",
                "8.`8888'`8.8",
                "`8.      `8'",
                " `88888b    "
        });


        letters.put('\\', new String[] {
                "`b.     ",
                " `8.    ",
                "  `8.   ",
                "   `8.  ",
                "    `8. ",
                "     `8.",
                "        ",
                "        "
        });

        letters.put('/', new String[] {
                "     .d'",
                "    .8' ",
                "   .8'  ",
                "  .8'   ",
                " .8'    ",
                ".P'     ",
                "        ",
                "        "
        });

        letters.put('-', new String[] {
                "      ",
                "      ",
                "      ",
                "888888",
                "      ",
                "      ",
                "      ",
                "      "
        });

        letters.put('+', new String[] {
                "      ",
                "      ",
                "  88  ",
                "888888",
                "  88  ",
                "      ",
                "      ",
                "      "
        });


        letters.put('=', new String[] {
                "      ",
                "      ",
                "888888",
                "      ",
                "888888",
                "      ",
                "      ",
                "      "
        });


        letters.put('\'', new String[] {
                "88",
                "88",
                "`'",
                "  ",
                "  ",
                "  ",
                "  ",
                "  "
        });

        letters.put('"', new String[] {
                "88  88",
                "88  88",
                "`'  `'",
                "      ",
                "      ",
                "      ",
                "      ",
                "      "
        });
    }

    public String render(final String message) {
        final StringBuilder builder = new StringBuilder(8 * message.length());
        for (int i = 0; i < 8; i++) {
            for (char c : message.toLowerCase().toCharArray()) {
                final String[] letter = letters.get(c);
                if (letter != null) {
                    builder.append(" ");
                    builder.append(letter[i]);
                }
            }
            builder.append("\n");
        }
        return builder.toString();
    }

    public static BannerRenderer defaultRenderer() {
        return new BannerRenderer();
    }
}
