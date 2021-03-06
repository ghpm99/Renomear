/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ferramentas;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.channels.FileChannel;

/**
 *
 * @author Qualidade
 */
public abstract class Renomear {

    public File certificado;
    public boolean valido;

    public void setArquivo(File file) {
        valido = false;
        certificado = file;
    }

    public void quebrar(String certificado) {
        String[] linhas = certificado.split("\n");
        for (String linha : linhas) {
            
            if (eValido(linha)) {
                certificado(linha.substring(0, linha.length() - 1));
                //salvarTxt(linha.substring(0, linha.length() - 1), linhas);                
                break;
            }
            
        }
        if(!valido){
            System.out.println("Nao e valido: " + this.certificado.getAbsolutePath());
            salvarTxt(this.certificado.getAbsolutePath());
            
            
        }
            
    }

    public abstract boolean eValido(String texto);

    //"C:\\Users\\Qualidade\\Desktop\\Renomeados"
    private void certificado(String nome) {
        valido = true;
        String a = substituir(nome);
        File novo = new File(certificado.getParent() + "\\" + a + ".pdf");

        mover(novo);

    }

    private void salvarTxt(String conteudo){
        FileWriter arq = null;
        PrintWriter gravarArq = null;
        
        try {

            arq = new FileWriter("C:\\Users\\Qualidade\\Invalido2.txt",true);
            gravarArq = new PrintWriter(arq);
            gravarArq.println(conteudo + ";");
            

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (arq != null) {
                try {
                    arq.close();
                } catch (IOException ex) {

                }
            }
            if (gravarArq != null) {
                gravarArq.close();
            }
        }
    }
    
    private void salvarTxt(String nome, String[] conteudo) {
        FileWriter arq = null;
        PrintWriter gravarArq = null;
        String a = substituir(nome);
        try {

            arq = new FileWriter("G:\\" + a + ".txt");
            gravarArq = new PrintWriter(arq);

            for (String cont : conteudo) {
                gravarArq.print(cont + "|");
            }

        } catch (IOException ex) {

        } finally {
            if (arq != null) {
                try {
                    arq.close();
                } catch (IOException ex) {

                }
            }
            if (gravarArq != null) {
                gravarArq.close();
            }
        }

    }

    public void copyFile(File source, File destination) throws IOException {
        if (destination.exists()) {
            destination.delete();
        }

        FileChannel sourceChannel = null;
        FileChannel destinationChannel = null;

        try {
            sourceChannel = new FileInputStream(source).getChannel();
            destinationChannel = new FileOutputStream(destination).getChannel();
            sourceChannel.transferTo(0, sourceChannel.size(),
                    destinationChannel);
        } finally {
            if (sourceChannel != null && sourceChannel.isOpen()) {
                sourceChannel.close();
            }
            if (destinationChannel != null && destinationChannel.isOpen()) {
                destinationChannel.close();
            }
        }
    }

    public String substituir(String arg0) {
        String arg1 = null;

        //invalidos \ / : * ? "< > |
        arg1 = arg0.replaceAll("/", "-");
        arg1 = arg1.replaceAll(":", "");
        arg1 = arg1.replaceAll("<", "");
        arg1 = arg1.replaceAll(">", "");
        arg1 = arg1.replaceAll("do produto - Product Description ", "");
        //PRODUTO / IDENTIFICA????O
        arg1 = arg1.replaceAll("PRODUTO - IDENTIFICA????O", "");
        arg1 = arg1.replaceAll("DESCRI????O DO PRODUTO: ", "");
        //DESCRI????O DO PRODUTO:
        arg1 = arg1.replaceAll("Descrimina????o: ", "");
        arg1 = arg1.replaceAll("Descrimina??ao: ", "");
        arg1 = arg1.replaceAll("Descriminacao: ", "");
        arg1 = arg1.replaceAll("Descrimina????o ", "");
        arg1 = arg1.replaceAll("Descrimina??ao ", "");
        arg1 = arg1.replaceAll("Descriminacao ", "");
        arg1 = arg1.replaceAll("PRODUTO: ", "");
        arg1 = arg1.replaceAll("PRODUTO ", "");
        arg1 = arg1.replaceAll("Produto ", "");
        arg1 = arg1.replaceAll("Pe??a: ", "");
        arg1 = arg1.replaceAll("Produto- ", "");
        arg1 = arg1.replaceAll("Descri????o", "");
        arg1 = arg1.replaceAll("Descricao: ", "");
        arg1 = arg1.replaceAll("Descri????o: ", "");
        arg1 = arg1.replaceAll("C??digo - Code: ", "");
        arg1 = arg1.replaceAll("Descri????o do Produto ", "");
        
        arg1 = arg1.replaceAll("|", "");
        arg1 = arg1.replaceAll("   ", "");
        arg1 = arg1.replace('\"', ' ');
        arg1 = arg1.replace('(', ' ');
        arg1 = arg1.replace(')', ' ');
        arg1 = arg1.replaceAll("\n", "");
        //C??digo - Code:
        return arg1;
    }

    public void mover(File depois) {

        boolean sucesso = certificado.renameTo(depois);

        if (sucesso) {
            System.out.println(depois.getAbsolutePath() + " Renomeou: " + sucesso);
            
        } else {
            boolean suc = certificado.delete();
            if (suc) {
                System.out.println(depois.getAbsolutePath() + " Excluiu: " + suc);
               
            } else {
                System.out.println(depois.getAbsolutePath() + " Excluiu: " + suc);
               // salvarTxt(depois.getAbsolutePath() + " Excluiu: " + suc);
            }
        }
        

    }

}
