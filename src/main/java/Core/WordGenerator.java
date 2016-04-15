package Core;

import java.util.Random;

public class WordGenerator {
    private static int MINIMUM = 0;
    private static int MAXIMUM = wordArray().length;

    /**
     * Generates a random word.
     *
     * @return a random word.
     */
    public static String generate() {
        Random rn = new Random();
        int randomNumber = rn.nextInt(MAXIMUM - MINIMUM + 1);
        return wordArray()[randomNumber];
    }

    private static String[] wordArray() {
        return new String[]{"acres",
                "adult",
                "advice",
                "arrangement",
                "attempt",
                "August",
                "autumn",
                "border",
                "breeze",
                "brick",
                "calm",
                "canal",
                "Casey",
                "cast",
                "chose",
                "claws",
                "coach",
                "constantly",
                "contrast",
                "cookies",
                "customs",
                "damage",
                "Danny",
                "deeply",
                "depth",
                "discussion",
                "doll",
                "donkey",
                "Egypt",
                "ellen",
                "essential",
                "exchange",
                "exist",
                "explanation",
                "facing",
                "film",
                "finest",
                "fireplace",
                "floating",
                "folks",
                "fort",
                "garage",
                "grabbed",
                "grandmother",
                "habit",
                "happily",
                "Harry",
                "heading",
                "hunter",
                "illinois",
                "image",
                "independent",
                "instant",
                "January",
                "kids",
                "label",
                "lee",
                "lungs",
                "manufacturing",
                "martin",
                "mathematics",
                "melted",
                "memory",
                "mill",
                "mission",
                "monkey",
                "Mount",
                "mysterious",
                "neighborhood",
                "norway",
                "nuts",
                "occasionally",
                "official",
                "ourselves",
                "palace",
                "pennsylvania",
                "philadelphia",
                "plates",
                "poetry",
                "policeman",
                "positive",
                "possibly",
                "practical",
                "pride",
                "promised",
                "recall",
                "relationship",
                "remarkable",
                "require",
                "rhyme",
                "rocky",
                "rubbed",
                "rush",
                "sale",
                "satellites",
                "satisfied",
                "scared",
                "selection",
                "shake",
                "shaking",
                "shallow",
                "shout",
                "silly",
                "simplest",
                "slight",
                "slip",
                "slope",
                "soap",
                "solar",
                "species",
                "spin",
                "stiff",
                "swung",
                "tales",
                "thumb",
                "tobacco",
                "toy",
                "trap",
                "treated",
                "tune",
                "University",
                "vapor",
                "vessels",
                "wealth",
                "wolf",
                "zoo"
        };
    }
}
