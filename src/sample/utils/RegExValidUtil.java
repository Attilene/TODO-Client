package sample.utils;

import java.util.regex.Pattern;

public final class RegExValidUtil {
    private static final String STANDARD_REGEX = "^[^%\"';:]*$";

    private static final String EMAIL_REGEX = "^([a-zA-Z0-9_-]+\\.)*[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)*\\.[a-zA-Z]{2,6}$";

    private static final String PASSWORD_REGEX = "^((?=.*[0-9])(?=.*[a-zа-я])(?=.*[A-ZА-Я])(?=.*[@#$]).{8,})$";

    private RegExValidUtil() {}

    public static boolean checkStandard(String text) { return Pattern.matches(STANDARD_REGEX, text); }

    public static boolean checkEmail(String email) { return Pattern.matches(EMAIL_REGEX, email); }

    public static boolean checkPassword(String password) { return Pattern.matches(PASSWORD_REGEX, password); }

    public static String getEmailRegex() { return EMAIL_REGEX; }

    public static String getPasswordRegex() { return PASSWORD_REGEX; }

    public static String getStandardRegex() { return STANDARD_REGEX; }
}
