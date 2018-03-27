/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;


import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Giovani dos Santos
 */
public class ModeloTabela extends AbstractTableModel{

    private static final long serialVersionUID = 4664027168162554735L;
    
    private ArrayList<Object> linhas = null;
    private String[]  colunas = null;
    
    /**
     *
     * @param lin
     * @param col
     */
    public ModeloTabela(ArrayList<Object> lin,String[] col){
        setLinhas(lin);
        setColunas(col);   
    }
    
    public ArrayList<Object> getLinhas(){
        return linhas;
    }
    
    /**
     *
     * @param dados
     */
    public void setLinhas(ArrayList<Object> dados){
        linhas = dados;
    }
    
    public String[] getColunas(){
        return colunas;
    }
    
    public void setColunas(String[] nomes){
        colunas = nomes;
    }
    
    @Override
    public int getColumnCount(){
        return colunas.length;
    }
    
    @Override
    public int getRowCount(){
        return linhas.size();
    }
    
    @Override
    public String getColumnName(int numCol){
        return colunas[numCol];
    }
    
    @Override
    public Object getValueAt(int numLin, int numCol){
        Object[] linha = (Object[])getLinhas().get(numLin);
        return linha[numCol];
    }
    
}

        
          
            
