/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ferramentas;

/**
 *
 * @author Qualidade
 */
public class RenomearGeral extends Renomear {
    
    @Override
    public boolean eValido(String texto) {
        return texto.startsWith("PAR.")
                || texto.startsWith("PAR ")
                || texto.startsWith("PARAF.")
                || texto.startsWith("PA. ")
                || texto.startsWith("CHAVE ")
                || texto.startsWith("PARAFUSO")
                || texto.startsWith("PORCA ")
                || texto.startsWith("ARR.")
                || texto.startsWith("ARR.PRESS.")
                || texto.startsWith("ARR.PRESS ")
                || texto.startsWith("ARR ")                
                || texto.startsWith("ANEL ")
                || texto.startsWith("Descriminação: ")    
                || texto.startsWith("Descriminaçao: ") 
                || texto.startsWith("Descriminacao: ") 
                || texto.startsWith("Descriminação ")    
                || texto.startsWith("Descriminaçao ") 
                || texto.startsWith("Descriminacao ")
                || texto.startsWith("PRODUTO ")
                || texto.startsWith("PRODUTO:")
                || texto.startsWith("Produto ")
                || texto.startsWith("ARRUELA ")
                || texto.startsWith("REBITES ")
                || texto.startsWith("REBITE ")
                || texto.startsWith("PINO ")
                || texto.startsWith("Peça: ")
                || texto.startsWith("Produto/ ")
                || texto.startsWith("Descrição")
                || texto.startsWith("Descricao:")
                || texto.startsWith("DESCRIÇÃO ")
                || texto.startsWith("Cabo ")
                || texto.startsWith("CHUMB ")
                || texto.startsWith("Código ")
                || texto.startsWith("BARRA ");
        
        //DESCRIÇÃO
    }
    
}
