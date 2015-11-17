package main.ids.presentation;

import main.ids.presentation.request.Request;
import main.ids.presentation.response.Response;


import java.util.ArrayList;

import main.ids.presentation.ApplicationController;

/**
 * Gestisce le {@link Request} provenienti dai controller delle singole 
 * interfaccie e risponde con un oggetto di tipo {@link Response}
 *  
 * 
 * @author bi
 *
 */
public interface FrontController {
public Response processRequest(Request request);
}
