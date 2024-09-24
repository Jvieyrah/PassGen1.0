package com.trybe.acc.java.geradorsenhas;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Metodo de classe.
 *
 */
public class GeradorSenhas {
  public static final Integer NUM_SENHAS = 10;

  // TROQUE O CAMINHO PARA O DIRETORIO DE DESTINO DOS SEUS ARQUIVOS
  public static final String DIRETORIO_DESTINO = "/tmp/";

  /**
   * Método principal.
   */
  public static void main(String[] args) {
    GeradorSenhas gerador = new GeradorSenhas();

    for (int i = 0; i < NUM_SENHAS; i++) {

      File arquivo = new File(DIRETORIO_DESTINO + File.separator + "arquivo_" + i + ".txt");
      String senha = gerador.gerarSenhaCompleta(i);

      try {
        gerador.escreverSenhaNoArquivo(senha, arquivo);
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

  /**
   * Recebe uma senha e a escreve em arquivo.
   */
  public void escreverSenhaNoArquivo(String senha, File arquivo) throws IOException {
    // ESCREVA SEU CÓDIGO AQUI
    FileWriter writer = null;
    BufferedWriter buffer = null;
    try {
      writer = new FileWriter(arquivo);
      buffer = new BufferedWriter(writer);
      buffer.write(senha);
      buffer.flush();
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      writer.close();
      buffer.close();
    }
  }

  /**
   * Gera senha completa a partir do índice.
   */
  public String gerarSenhaCompleta(int indice) {
    String extra = "####";
    String[] l = {"A5$2", "B55S", "CFFG", "D&54", "EEDF", "FEGG", "G15E", "H123", "I81F", "JWEF"};
    // ESCREVA SEU CÓDIGO AQUI
    return l[indice].concat((indice + 1 > 9) ? extra : l[indice + 1]);
  }
}
