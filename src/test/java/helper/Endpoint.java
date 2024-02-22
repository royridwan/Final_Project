package helper;

public class Endpoint {

    public static final String host_api = "https://dummyapi.io/data/v1/";
    public static final String get_list_user = host_api + "user";
    public static final String create_user = get_list_user + "/create";
    public static final String wrong_url = get_list_user + "/wrongurl";
}
