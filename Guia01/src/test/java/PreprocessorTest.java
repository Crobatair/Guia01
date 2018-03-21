/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.hamcrest.collection.IsIterableContainingInAnyOrder;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import sv.edu.ues.fmocc.sistemas.tpi135.guias.guia01.convertirCSV.Preprocessor;


/**
 *
 * @author ale
 */
public class PreprocessorTest {
    
    @Rule
    public TemporaryFolder root = new TemporaryFolder();
    private File file1;
    private File file1A;
    private File file1B;
    private File temp1;
    private File temp2;
    private File temp3;
    
    
    public PreprocessorTest() {
    }
    
    @Before
    public void setUp() throws IOException{
        file1=root.newFolder("file1");
        file1A=root.newFolder("file1","file1A");
        file1B=root.newFolder("file1","file1B");
        temp1 = File.createTempFile("temp1", ".csv", file1B);
        temp2 = File.createTempFile("temp2", ".txt", file1A);
        temp3 = File.createTempFile("temp2", ".csv", file1A);
    }
    
    @Test()
    public void validarPathTest () throws IOException{
        Preprocessor p = new Preprocessor();
        p.validarPath(root.newFolder().getPath());
    }
    
    @Test()
    public void obtenerListaCSVTest() throws IOException{
        System.out.println("hola");
        List<String> expected = new ArrayList<>();
        expected.add(temp1.getPath());
        expected.add(temp3.getPath());
       
        Preprocessor p = new Preprocessor();
        List<String> list = p.obtenerListaCSV(root.getRoot().getPath());
        
        Assert.assertEquals(expected.size(),list.size());        
        Assert.assertThat(list,IsIterableContainingInAnyOrder.containsInAnyOrder(expected.toArray()));
    }
}
