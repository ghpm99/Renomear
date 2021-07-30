/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import ferramentas.Certificado;
import java.io.File;

/**
 *
 * @author Qualidade
 */
public class Iniciar {

    private static Certificado certificado = new Certificado();
    
      public static void main(String[] args){
        
        buscar(new File("C:\\Users\\Qualidade\\Documents"));
        
    }
    
    public static void buscar(File file){
        File[] arquivos = file.listFiles();
        if(arquivos == null){
            return;
        }
        for(File a : arquivos){
            if(a == null){
                continue;
            }
            if(a.isDirectory()){
                buscar(a);
            }else{
               certificado.abrir(a);
                //System.out.println(a.getParent());
            }
            
        }
    }

}
