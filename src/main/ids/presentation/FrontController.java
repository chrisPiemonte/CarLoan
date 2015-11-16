package main.ids.presentation;

import main.ids.presentation.request.Request;
import main.ids.presentation.response.Response;


import java.util.ArrayList;

import main.ids.presentation.ApplicationController;

public interface FrontController {
public Response processRequest(Request request);
}
