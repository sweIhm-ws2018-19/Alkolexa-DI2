package alkolexa;

public class SpeechStrings {
	private static final String HELLO = "Willkommen bei Alkolexa";
	private static final String GOODBYE = "Bis bald";
	private static final String GOODBYE_CART = "Tschuess und bald wieder auf einen Drink";
	private static final String SKILL_END = "Alkolexa wird beendet";
	private static final String SORRY = "Entschuldige";
	private static final String SORRY_PREPEAT = "Koenntest du das noch einmal sagen";
	private static final String HELP = "Wenn du hilfe sagst, unterstuetze ich dich ";
	private static final String WELC = "Schoen das du da bist! Was kann ich fuer dich tun";
	private static final String WHY = "Was interessiert dich, Wein oder Cocktails";

	private static final String SETFAVORITE_POSITIVE0 = "Deine Favorite Cocktail ist ";
	private static final String SETFAVORITE_POSITIVE1 = ". Du kannst mich jetzt nach Deinem Favorite Cocktail fragen. Frage einfach: was ist mein Favorite Cocktail?";
	private static final String SETFAVORITE_POSITIVE_REPROMT = "Frage nach meinem Favorite Cocktail.";
	private static final String SETFAVORITE_NEGATIVE = "Ich kenne Dein Favorite Cocktail nicht. Bitte versuche es noch einmal.";
	private static final String SETFAVORITE_NEGATIVE_REPROMT = "Ich weiss nicht welches Dein Favorite Cocktail ist. Sag mir Dein Favorite Cocktail. Sage zum Beispiel: Mein Favorite Cocktail ist Mochito.";

	private static final String GETFAVORITE_POSITIVE = "Dein Favorite Cocktail ist ";
	private static final String GETFAVORITE_NEGATIVE = "Ich kenne dein Favorite Cocktail nicht. Sag mir dein Favorite Cocktail. Sage zum Beispiel: Mein Favorite Cocktail ist Mochito.";

	private SpeechStrings() {

	}

	public static String getHello() {
		return HELLO;
	}

	public static String getGoodbyeCart() {
		return GOODBYE_CART;
	}

	public static String getGoodbye() {
		return GOODBYE;
	}

	public static String getSkillEnd() {
		return SKILL_END;
	}

	public static String getSorry() {
		return SORRY;
	}

	public static String getSorryPrepeat() {
		return SORRY_PREPEAT;
	}

	public static String getHelp() {
		return HELP;
	}

	public static String getWelc() {
		return WELC;
	}

	public static String getWhy() {
		return WHY;
	}

	public static String getSetfavoritePositive0() {
		return SETFAVORITE_POSITIVE0;
	}

	public static String getSetfavoritePositive1() {
		return SETFAVORITE_POSITIVE1;
	}

	public static String getSetfavoritePositiveRepromt() {
		return SETFAVORITE_POSITIVE_REPROMT;
	}

	public static String getSetfavoriteNegative() {
		return SETFAVORITE_NEGATIVE;
	}

	public static String getSetfavoriteNegativeRepromt() {
		return SETFAVORITE_NEGATIVE_REPROMT;
	}
	

	public static String getGetfavoritePositive() {
		return GETFAVORITE_POSITIVE;
	}

	public static String getGetfavoriteNegative() {
		return GETFAVORITE_NEGATIVE;
	}

}
