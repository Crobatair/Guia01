/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.ues.fmocc.sistemas.tpi135.guias.guia01.rest;

import java.net.URI;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author ale
 */
public class RestClient {

    Client cliente = ClientBuilder.newClient();

    public URI postMigracion(String json, String path) throws Exception {
        WebTarget target = cliente.target(path);
        Response respuesta = target.request(MediaType.APPLICATION_JSON).post(Entity.text(json));
        if (respuesta.getStatus() == Response.Status.CREATED.getStatusCode()) {
            return respuesta.getLocation();
        } else {
            return null;
        }

    }
}
