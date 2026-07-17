package utils;

public class Constants {
    private Constants() {
        throw new IllegalStateException("Utility class");
    }
    public static final String PATH_OBJECTS = "/objects";
    public static final String PATH_OBJECT_ID = "/objects/{id}";

    public static final String REGISTER_PATH = "/register";
    public static final String LOGIN_PATH = "/login";
    public static final String COLLECTIONS_PATH = "/collections/{collectionName}/objects";
}
