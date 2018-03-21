/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.ues.fmocc.sistemas.tpi135.guias.guia01.convertirCSV;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ale
 */
public class Preprocessor {

    /**
     *
     * @param path Parametro del Path sobre el cual se realizarà la validaciòn
     * @return
     */
    public boolean validarPath(final String path) {
        if (path != null && !path.isEmpty()) {
            return Paths.get(path).toFile().isDirectory();
        } else {
            return false;
        }
    }

    /**
     *
     * @param path
     * @return
     * @throws java.io.IOException
     */
    public List<String> obtenerListaCSV(final String path) throws IOException {
        List<String> resultado = new ArrayList<>();
        if (validarPath(path) == true) {
            Files.walk(Paths.get(path)).filter(d -> d.toFile().getName().endsWith(".csv")).forEach(file -> resultado.add(file.toUri().getPath()));
        }
        return resultado;
    }   
    
    public String helloWorld(){
        return null;
    }
    

}
