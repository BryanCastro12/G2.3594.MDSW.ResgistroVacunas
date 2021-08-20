/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import com.itextpdf.text.Anchor;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import java.io.*;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Section;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import controlador.DosisDAO;
import controlador.VacunaDAO;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Joel
 */
public class Documento {

    private static final Font chapterFont = FontFactory.getFont(FontFactory.HELVETICA, 26, Font.BOLDITALIC);
    private static final Font paragraphFont = FontFactory.getFont(FontFactory.HELVETICA, 12, Font.NORMAL);

    private static final Font categoryFont = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD);
    private static final Font subcategoryFont = new Font(Font.FontFamily.TIMES_ROMAN, 16, Font.BOLD);
    private static final Font blueFont = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL, BaseColor.RED);
    private static final Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);

    private static final String iTextExampleImage = "/home/xules/codigoxules/iText-Example-image.png";

    /**
     * We create a PDF document with iText using different elements to learn to
     * use this library. Creamos un documento PDF con iText usando diferentes
     * elementos para aprender a usar esta librería.
     *
     * @param pdfNewFile  <code>String</code> pdf File we are going to write.
     * Fichero pdf en el que vamos a escribir.
     */
    public void createPDF(File pdfNewFile) {
        // Aquí introduciremos el código para crear el PDF.
        Document document = new Document();
        try {
            try {
                PdfWriter.getInstance(document, new FileOutputStream(pdfNewFile));
            } catch (FileNotFoundException fileNotFoundException) {
                System.out.println("No such file was found to generate the PDF "
                        + "(No se encontró el fichero para generar el pdf)" + fileNotFoundException);
            }
            document.open();
            
            // AQUÍ COMPLETAREMOS NUESTRO CÓDIGO PARA GENERAR EL PDF
            generarTablaVacuna(document);
            // How to use PdfPTable
// Utilización de PdfPTable
// We use various elements to add title and subtitle
// Usamos varios elementos para añadir título y subtítulo
            Anchor anchor = new Anchor("Datos de la jornada de vacunacion", categoryFont);
            anchor.setName("Datos de la jornada de vacunacion");
            Chapter chapTitle = new Chapter(new Paragraph(anchor), 2);
            Paragraph paragraph = new Paragraph("Registro de personas vacunadas y la dosis suministrada", subcategoryFont);
            Section paragraphMore = chapTitle.addSection(paragraph);
            paragraphMore.add(new Paragraph(""));
            Integer numColumns = 4;
            Integer numRows = 120;
// We create the table (Creamos la tabla).
            PdfPTable table = new PdfPTable(numColumns);
// Now we fill the PDF table 
// Ahora llenamos la tabla del PDF
            PdfPCell columnHeader;
// Fill table rows (rellenamos las filas de la tabla).                
            columnHeader = new PdfPCell(new Phrase("ID"));
            columnHeader.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(columnHeader);
            
            columnHeader = new PdfPCell(new Phrase("Nombre"));
            columnHeader.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(columnHeader);
            
            columnHeader = new PdfPCell(new Phrase("Edad"));
            columnHeader.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(columnHeader);
            
            columnHeader = new PdfPCell(new Phrase("Numero de Dosis"));
            columnHeader.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(columnHeader);
            
            table.setHeaderRows(1);
// Fill table rows (rellenamos las filas de la tabla).  

            DosisDAO dao = new DosisDAO();
            List<DosisDTO> lista = dao.readALL();
            int contador = 0;
            for (int row = 0; row < lista.size(); row++) {
                table.addCell(lista.get(contador).getId() + "");
                table.addCell(lista.get(contador).getNombrePersona());
                table.addCell(lista.get(contador).getEdad() + "");
                table.addCell(lista.get(contador).getNumDosis() + "");
                contador++;
            }
// We add the table (Añadimos la tabla)
            paragraphMore.add(table);
// We add the paragraph with the table (Añadimos el elemento con la tabla).
            document.add(chapTitle);
            
            document.close();
            System.out.println("Your PDF file has been generated!(¡Se ha generado tu hoja PDF!");
        } catch (DocumentException documentException) {
            System.out.println("The file not exists (Se ha producido un error al generar un documento): " + documentException);
        } catch (Exception ex) {
            Logger.getLogger(Documento.class.getName()).log(Level.SEVERE, null, ex);
        }
//                    document.addTitle("Table export to PDF (Exportamos la tabla a PDF)");
//            document.addSubject("Using iText (usando iText)");
//            document.addKeywords("Java, PDF, iText");
//            document.addAuthor("Código Xules");
//            document.addCreator("Código Xules");
    }
    
    public void generarTablaVacuna(Document document) throws DocumentException, Exception
    {
         Anchor anchor = new Anchor("Datos de la jornada de vacunacion", categoryFont);
            anchor.setName("Datos de la jornada de vacunacion");
            Chapter chapTitle = new Chapter(new Paragraph(anchor), 1);
            Paragraph paragraph = new Paragraph("Vacunas registradas", subcategoryFont);
            Section paragraphMore = chapTitle.addSection(paragraph);
            paragraphMore.add(new Paragraph(""));
            Integer numColumns = 3;
// We create the table (Creamos la tabla).
            PdfPTable table = new PdfPTable(numColumns);
// Now we fill the PDF table 
// Ahora llenamos la tabla del PDF
            PdfPCell columnHeader;
// Fill table rows (rellenamos las filas de la tabla).                
            columnHeader = new PdfPCell(new Phrase("ID"));
            columnHeader.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(columnHeader);
            
            columnHeader = new PdfPCell(new Phrase("Nombre"));
            columnHeader.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(columnHeader);
            
            columnHeader = new PdfPCell(new Phrase("Suministro en dosis"));
            columnHeader.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(columnHeader);
            
            table.setHeaderRows(1);
// Fill table rows (rellenamos las filas de la tabla).  

            VacunaDAO dao = new VacunaDAO();
            List<VacunaDTO> lista = dao.readALL();
            int contador = 0;
            for (int row = 0; row < lista.size(); row++) {
                table.addCell(lista.get(contador).getId() + "");
                table.addCell(lista.get(contador).getNombre());
                table.addCell(lista.get(contador).getNumdosis() + "");
                contador++;
            }
// We add the table (Añadimos la tabla)
            paragraphMore.add(table);
// We add the paragraph with the table (Añadimos el elemento con la tabla).
            document.add(chapTitle);
    }

}
