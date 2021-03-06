package fr.univ.rouen.cv21rest.validation;

public class Constant {
    public static final int STRING_NAME_MAX = 32;
    public static final int STRING_COMMENT_MAX = 128;
    public static final String PHONE_NUMBER_REGEX = "^[+]?[(]?[0-9]{3}[)]?[-\\s.]?[0-9]{3}[-\\s.]?[0-9]{4,6}$";
    public static final String CV21_NAMESPACE = "http://univ.fr/cv21";
}
