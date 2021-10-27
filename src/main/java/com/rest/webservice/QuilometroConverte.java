package com.rest.webservice;

import javax.inject.Singleton;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
Quilômetro por hora para milhas por hora (1=0.621371) – esse método deve trabalhar 
responder por POST e receber/enviar dados em form-encoded.
Nós para quilometro por hora (1=1.852) – esse método deve trabalhar responder 
por POST e receber/enviar dados em JSON.
 */
@Path("/quilometro/{valor}")
@Singleton
public class QuilometroConverte {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Quilometro milhasHoraParaQuilometroHora(@PathParam("valor") String valor) {
        double valorConvertido = Double.parseDouble(valor) * 1.609;
        Quilometro q = new Quilometro();
        q.setValorConvertido(valorConvertido);
        return q;
    }

    @POST 
    @Path("/save") 
    @Consumes(MediaType.APPLICATION_JSON) 
    @Produces(MediaType.APPLICATION_JSON) 
    @Transactional 
    public Subject save(final String jsonString) { 
        // converts the json to a map final 
        Jsonb jsonb = JsonbBuilder.create(); 
        Map map = jsonb.fromJson(jsonString, HashMap.class); 
    } 
}
