/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;
//PARA NO TENER PROBLEMAS REALIZAMOS PRIMERO
//LAS SIGUIENTES IMPORTACIONES

import java.io.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;
import org.apache.poi.ss.usermodel.Cell;  
import org.apache.poi.ss.usermodel.Row; 
import org.apache.poi.xssf.usermodel.XSSFSheet;  
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.awt.event.AWTEventListener;
import java.text.SimpleDateFormat;
/**
 *
 * @author JeanCarlos
 */
public class ModeloExcel{
    
    Workbook book;
    
    public String Importar(File archivo, JTable tabla){
        String mensaje="Error en la Importacion";
        DefaultTableModel modelo=new DefaultTableModel();
        tabla.setModel(modelo);
        
        try {

            //CREA ARCHIVO CON EXTENSION XLS Y XLSX
            book=WorkbookFactory.create(new FileInputStream(archivo));
            Sheet hoja=book.getSheetAt(0);
            Iterator FilaIterator=hoja.rowIterator();
            int IndiceFila=-1;
            
            //VA SER VERDADERO SI EXISTEN FILAS POR RECORRER
            while (FilaIterator.hasNext()) {   
              
                //INDICE FILA AUMENTA 1 POR CADA RECORRIDO
                IndiceFila++;
                Row fila=(Row)FilaIterator.next();
                //RECORRE LAS COLUMNAS O CELDAS DE UNA FILA YA CREADA
                Iterator ColumnaIterator=fila.cellIterator();
                //ASIGNAMOS EL MAXIMO DE COLUMNA PERMITIDO
                Object[]ListaColumna=new Object[9999];
                int IndiceColumna=-1;
                int contador = 0;
                
                //VA SER VERDADERO SI EXISTEN COLUMNAS POR RECORRER
                while (ColumnaIterator.hasNext()) { 
                    
                    //INDICE COLUMNA AUMENTA 1 POR CADA RECORRIDO
                    IndiceColumna++;
                    Cell celda=(Cell)ColumnaIterator.next();
                    //SI INDICE FILA ES IGUAL A "0" ENTONCES SE AGREGA UNA COLUMNA
                    if(IndiceFila==0){
                        modelo.addColumn(celda.getStringCellValue());
                    }else{
                        if(celda!=null){
                            switch (celda.getCellType()){
                                case Cell.CELL_TYPE_NUMERIC:
                                    ListaColumna[IndiceColumna]=(int)Math.round(celda.getNumericCellValue());
                                    break;
                                case Cell.CELL_TYPE_STRING:
                                    if (IndiceColumna == 0){
                                        
                                        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                                        Date dataFormateada = formato.parse(celda.getStringCellValue()); 
                                        SimpleDateFormat format1 = new SimpleDateFormat("d MMM y");
                                        //System.out.println(format1.format(dataFormateada));  
                                    }else if((IndiceColumna == 1)){
                                        SimpleDateFormat formato = new SimpleDateFormat("HH:mm:ss");
                                        Date dataFormateada = formato.parse(celda.getStringCellValue()); 
                                        SimpleDateFormat format1 = new SimpleDateFormat("HH:mm:ss");
                                       // System.out.println(format1.format(dataFormateada)); 
             
                                    }else if(IndiceColumna == 2){
                                        double valor = Double.parseDouble(celda.getStringCellValue());
                                        System.out.println(valor);
                                        
                                    }else if(IndiceColumna == 5){
                                        double valor = Double.parseDouble(celda.getStringCellValue());
                                        System.out.println(valor);
                                        
                                    }else if(IndiceColumna == 6){
                                        double valor = Double.parseDouble(celda.getStringCellValue());
                                        System.out.println(valor);
                                        
                                    }
                                    ListaColumna[IndiceColumna]=celda.getStringCellValue();

                                    break;
                                case Cell.CELL_TYPE_BOOLEAN:
                                    ListaColumna[IndiceColumna]=celda.getBooleanCellValue();
                                    break;
                                    
                                    default:
                                        ListaColumna[IndiceColumna]=celda.getDateCellValue();
                                        
                                        break;
                            }

                        } 
                    }contador++;
                } 
                
                if(IndiceFila!=0)modelo.addRow(ListaColumna);
            }
            mensaje="Importacion Exitosa";
            
        } catch (Exception e) {
        }
        return mensaje;
    }
    
    public String Exportar(File archivo, JTable tabla){
        String mensaje="Error en la Exportacion";
        int NumeroFila=tabla.getRowCount(),NumeroColumna=tabla.getColumnCount();
        if(archivo.getName().endsWith("xls")){
            book=new HSSFWorkbook();
        }else{
            book=new XSSFWorkbook();
        }
        Sheet hoja=book.createSheet("Hoja1");
        
        try {
            for (int i = -1; i < NumeroFila; i++) {
                Row fila=hoja.createRow(i+1);
                for (int j = 0; j <NumeroColumna; j++) {
                    Cell celda=fila.createCell(j);
                    if(i==-1){
                        celda.setCellValue(String.valueOf(tabla.getColumnName(j)));
                    }else{
                        celda.setCellValue(String.valueOf(tabla.getValueAt(i, j)));
                    }
                    book.write(new FileOutputStream(archivo));
                }
            }
            mensaje="Exportacion Exitosa";
        } catch (Exception e) {
        }
        return mensaje;
    }
    
}
