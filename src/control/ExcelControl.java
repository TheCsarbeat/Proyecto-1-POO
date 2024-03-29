/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.io.*;
import java.util.*;
import javax.swing.*;   
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.text.SimpleDateFormat;
import modelo.Asociado;
import modelo.NProvincia;
import modelo.Sismo;
import modelo.TOrigen;

/**
 *
 * @author ytces
 */
public class ExcelControl {

    Workbook book;
    File archivo;

    public boolean obtenerDatosExel(AdmiSismos sismos) {
        
        Calendar fecha = Calendar.getInstance(), hora = Calendar.getInstance();
        double profundidad = 0, latitud = 0, longitud = 0, magnitud = 0;
        boolean terrestre = false;
        TOrigen origen = null;
        NProvincia provincia = null;
        String localizacion = "";

        try {
            archivo = new File("src\\files\\sismos.xlsx");
            book = WorkbookFactory.create(new FileInputStream(archivo));
        } catch (Exception e) {

        }
        Sheet hoja = book.getSheetAt(0);
        Iterator FilaIterator = hoja.rowIterator();

        int IndiceFila = 0;

        //VA SER VERDADERO SI EXISTEN FILAS POR RECORRER
        while (FilaIterator.hasNext()) {
            Row fila = (Row) FilaIterator.next();

            Iterator ColumnaIterator = fila.cellIterator();
   
            int IndiceColumna = 0;

            while (ColumnaIterator.hasNext()) {  
                
                Cell celda = (Cell) ColumnaIterator.next();
                if (IndiceFila != 0 && celda != null) {                    
                    switch (celda.getCellType()) {
                        case Cell.CELL_TYPE_STRING:
                            if (IndiceColumna == 1) {
                                fecha = Calendar.getInstance();
                                SimpleDateFormat formato = new SimpleDateFormat("d MMM y");
                                Date dataFormateada = null;
                                try {
                                    dataFormateada = formato.parse(celda.getStringCellValue());
                                } catch (Exception e) {

                                }
                                fecha.setTime(dataFormateada);
                            } else if ((IndiceColumna == 2)) {
                                hora = Calendar.getInstance();
                                SimpleDateFormat formato = new SimpleDateFormat("HH:mm:ss");
                                Date dataFormateada = null;
                                try {
                                    dataFormateada = formato.parse(celda.getStringCellValue());
                                } catch (Exception e) {

                                }
                                hora.setTime(dataFormateada);
                            } else if (IndiceColumna == 3) {
                                profundidad = Double.parseDouble(celda.getStringCellValue());
                            } else if (IndiceColumna == 4) {
                                magnitud = Double.parseDouble(maginitudSinUnidad(celda.getStringCellValue()));
                                maginitudSinUnidad("4.5Ml");
                            } else if (IndiceColumna == 5) {
                                localizacion = celda.getStringCellValue();
                            } else if (IndiceColumna == 6) {
                                origen = Utilities.convertOrigenToTOrigen(celda.getStringCellValue().charAt(0));
                            } else if (IndiceColumna == 7) {
                                latitud = Double.parseDouble(celda.getStringCellValue());
                            } else if (IndiceColumna == 8) {
                                longitud = Double.parseDouble(celda.getStringCellValue());
                            } else if (IndiceColumna == 9) {
                                if (celda.getStringCellValue().length() == 0) {
                                    provincia = null;
                                } else {
                                    provincia = Utilities.convertStringToNProvincia(celda.getStringCellValue().charAt(0));
                                }

                            } else if (IndiceColumna == 10) {
                                terrestre = Utilities.convertStringTolugar(celda.getStringCellValue().charAt(0));
                            }
                            break;

                        default:
                            provincia = null;
                            break;
                    }
                } //Final if 
                
                IndiceColumna++;
            } //Final while columnas
            if (IndiceFila != 0) {
                Sismo nuevoSismo = new Sismo(sismos.getContadorSismos(), fecha, hora,
                        profundidad, latitud, longitud, magnitud, localizacion, terrestre, origen, provincia);
                sismos.agregar(nuevoSismo);
            }
            IndiceFila++;
        } //Final While rows

        return true;
    }
    
    public boolean obtenerDatosExel(AdmiAsociados adminAsociados) {       
               
        ArrayList<NProvincia> provincias = new ArrayList();
        String localizacion = "", nombre = "", correo = "", celular ="";
        boolean flagCorreo, flagCelular;

        try {
            archivo = new File("src\\files\\asociados.xlsx");
            book = WorkbookFactory.create(new FileInputStream(archivo));
        } catch (Exception e) {

        }
        Sheet hoja = book.getSheetAt(0);
        Iterator FilaIterator = hoja.rowIterator();

        int IndiceFila = 0;

        //VA SER VERDADERO SI EXISTEN FILAS POR RECORRER
        while (FilaIterator.hasNext()) {
            Row fila = (Row) FilaIterator.next();

            Iterator ColumnaIterator = fila.cellIterator();
   
            int IndiceColumna = 0;

            while (ColumnaIterator.hasNext()) {  
                
                Cell celda = (Cell) ColumnaIterator.next();
                if (celda != null) {                    
                    switch (celda.getCellType()) {
                        case Cell.CELL_TYPE_STRING:
                            if (IndiceColumna == 0) {
                                nombre = celda.getStringCellValue();
                            } else if ((IndiceColumna == 1)) {
                                correo = celda.getStringCellValue();
                            } else if (IndiceColumna == 2) {
                                celular = celda.getStringCellValue();
                            } else if (IndiceColumna == 3) {                                
                                provincias = obtenerProvinciasAsociadas(celda.getStringCellValue());
                            }
                            break;

                        default:
                            if ((IndiceColumna == 1)) {
                                correo = celda.getStringCellValue();
                            } else if (IndiceColumna == 2) {
                                celular = celda.getStringCellValue();                           
                            }
                            break;
                    }
                } //Final if 
                
                IndiceColumna++;
            } //Final while columnas
            if (IndiceFila != 0) {                
                if((Utilities.validarCorreo(correo) || Utilities.validarNumeroCelular(celular)) && !nombre.equals("") && Utilities.validarProvincias(provincias)){                    
                    Asociado nuevoAsociado = new Asociado(adminAsociados.getContador(), nombre, correo, celular, provincias);
                    adminAsociados.agregar(nuevoAsociado);             
                }
            }
            IndiceFila++;
        } //Final While rows

        return true;
    }
    public ArrayList<NProvincia> obtenerProvinciasAsociadas(String provinciasString){
        ArrayList<NProvincia> provincias = new ArrayList();
        for ( String i: provinciasString.split(",")) {
            provincias.add(Utilities.convertStringToNProvincia(i.charAt(0)));
        }
        return provincias;
    }
    public String maginitudSinUnidad(String magnitud) {
        String magnitudSinUnidad = "";
        for (int i = 0; i < magnitud.length() - 2; i++) {
            magnitudSinUnidad = magnitudSinUnidad + String.valueOf(magnitud.charAt(i));
        }
        return magnitudSinUnidad;
    }

    public boolean guardarDatosExel(JTable tabla) {
        archivo = new File("src\\files\\sismos.xlsx");
        int NumeroFila = tabla.getRowCount(), NumeroColumna = tabla.getColumnCount();
        if (archivo.getName().endsWith("xls")) {
            book = new HSSFWorkbook();
        } else {
            book = new XSSFWorkbook();
        }
        Sheet hoja = book.createSheet("Hoja1");

        try {
            for (int i = -1; i < NumeroFila; i++) {
                Row fila = hoja.createRow(i + 1);
                for (int j = 0; j < NumeroColumna; j++) {
                    Cell celda = fila.createCell(j);
                    if (i == -1) {
                        celda.setCellValue(String.valueOf(tabla.getColumnName(j)));
                    } else {
                        celda.setCellValue(String.valueOf(tabla.getValueAt(i, j)));
                    }
                }
                book.write(new FileOutputStream(archivo));
            }

        } catch (Exception e) {
        }
        return true;
    }
}
