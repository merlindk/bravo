package com.dsi.bravo.externos;


import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class ImpresoraPDF {

    public void imprimir(String path, List<String> aImprimir) {
        try {
            if (!path.endsWith(".pdf")) {
                path += ".pdf";
            }
            PDDocument document = new PDDocument();
            PDPage page = new PDPage();
            document.addPage(page);

            PDPageContentStream contentStream = new PDPageContentStream(document, page);

            contentStream.beginText();

            contentStream.setFont(PDType1Font.TIMES_ROMAN, 12);
            contentStream.setLeading(14.5f);

            contentStream.newLineAtOffset(25, 700);
            for (String line : aImprimir) {
                contentStream.showText(line);
                contentStream.newLine();
            }
            contentStream.endText();
            contentStream.close();
            document.save(path);
        } catch (IOException ex) {
            // FIXME: show a dialog with the error
            throw new RuntimeException(ex);
        }
    }

}
