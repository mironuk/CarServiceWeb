package carservice.web.controller;

import com.google.gson.Gson;

public abstract class AbstractController {

    protected static final Gson gson = new Gson();

    protected static final String EMPTY_JSON = "{}";

}
