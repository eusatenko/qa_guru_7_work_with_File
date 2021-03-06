package qa_guru_workWithFile;

import com.codeborne.pdftest.PDF;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PdfDownloadTest {

    @Test
    void junitPdfTest() throws IOException {
        Selenide.open("https://junit.org/junit5/docs/current/user-guide/");
        File pdfDownloadedFile = $(byText("PDF download")).download();
        PDF parsedPdf = new PDF(pdfDownloadedFile);
        assertTrue(parsedPdf.author.contains("Marc Philipp"));
    }
}