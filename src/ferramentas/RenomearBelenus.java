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
public class RenomearBelenus extends Renomear {

    @Override
    public boolean eValido(String texto) {
        return texto.startsWith("PAR.")
                || texto.startsWith("PAR ")
                || texto.startsWith("PARAF.")
                || texto.startsWith("PARAF ")
                || texto.startsWith("PA. ")
                || texto.startsWith("CHAVE ")
                || texto.startsWith("PARAFUSO")
                || texto.startsWith("PORCA ")
                || texto.startsWith("ARR.")
                || texto.startsWith("AR ")
                || texto.startsWith("ARRUELA ")
                || texto.startsWith("REBITES ")
                || texto.startsWith("REBITE ")
                || texto.startsWith("ABRACADEIRA ")
                || texto.startsWith("Descrição: ")
                || texto.startsWith("BUJAO ")
                || texto.startsWith("Descrição ")
                || texto.startsWith("Descrição do Produto ")
                || texto.startsWith("BARRA ");
        //Descrição do Produto  Descrição
    }

}
