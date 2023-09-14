package com.intern.demoproject.utils;

public class Constants {

    public static final String API_VERSION = "/v1";

    public static final String BASE_PATH = "/api" + API_VERSION;

    public static class Jwt {
        public static final long TIME_LIFE = 1000 * 60 * 60 * 24;

        public static final String SECRET_KEY = "8A7D6F43A9C2B5E8164F301B89D7E520A431BEDB263EBC0B6C8E9775DB741FC9";
    }

    public static class Storage{
        public static final String UPLOAD_ENDPOINT = BASE_PATH + "/upload";

    }

    public static class AuthPaths {

        public static final String AUTH_PATH = BASE_PATH + "/auth";

    }

    public static class  UserPaths {

        public static final String USER_PATH = BASE_PATH + "/users";

    }

    public static class User {
        public static final String DEFAULT_AVATAR = "https://i.imgur.com/6VBx3io.png";
    }




}
