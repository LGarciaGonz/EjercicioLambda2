package org.example.functions;


import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

/**
 * Añadir dependencias !!!!
 * <p>
 * TODO Mejora 1 -> Mover consultas a la BBDD a otro paquete y clase.
 * TODO Mejora 2 -> Realizar la conexión mediante pull de conexiones.
 */

public class ProfesoresFunction implements RequestHandler<Map<String, String>, APIGatewayProxyResponseEvent> {

    /**
     * 3. Listar los profesores que imparten clase en una determinada especialidad
     * que el usuario elegirá de la lista de especialidades posibles que se
     * le mostrarán por pantalla.
     */

    public APIGatewayProxyResponseEvent handleRequest(final Map<String, String> input, final Context context) {

        Gson gson = new Gson();
        String output = "";

        // Configurar el header para la respuesta tipo JSON:
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        headers.put("X-Custom-Header", "application/json");

        String especialidad = input.get("especialidad");    // Entrada del nombre introducido por el usuario.


        //inicializo la variable con la que voy a responder con el header
        APIGatewayProxyResponseEvent response = new APIGatewayProxyResponseEvent()
                .withHeaders(headers);


        //almaceno en un String el Json con la información a enviar
        final String bodyContent = gson.toJson(services.ConsultaProfes.consultaProfes(especialidad));
        output = String.format("{ \"Especialidad\": \"%s\", \"Profesores\": \"%s\" }", especialidad, bodyContent);


        //devuelvo la variable APIGatewayProxyResponseEvent
        return response
                .withStatusCode(200) //si va bien devuelvo el código de OK 200
                .withBody(output); //y en el body el json con la información requerida en el formato acordado.

    }

}
