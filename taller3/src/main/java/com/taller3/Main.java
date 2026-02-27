package com.taller3;

import com.taller3.export.DocumentExporter;
import com.taller3.export.DocumentExporterFactory;
import com.taller3.export.DocumentFormat;
import com.taller3.export.ExportException;
import com.taller3.export.ExportService;
import com.taller3.export.model.Document;
import com.taller3.export.model.ExportOptions;
import com.taller3.export.model.ExportResult;

import java.util.List;

/**
 * Demo of the Factory pattern with document export.
 * Shows: Factory usage, validation, format-specific options, batch export.
 */
public class Main {
    public static void main(String[] args) {
        Document document = new Document(
                "Quarterly Report 2025",
                "This is the document content. It can be a report, an article, or any text-based document.",
                "John Doe"
        );

        ExportOptions customOptions = ExportOptions.builder()
                .pageSize(ExportOptions.PageSize.LETTER)
                .template("corporate")
                .embedCss(false)
                .build();

        System.out.println("=== Document Export Demo (Factory Pattern) ===\n");

        // 1. Single format via factory
        System.out.println("--- Export to PDF (custom options) ---");
        DocumentExporter pdfExporter = DocumentExporterFactory.createExporter(DocumentFormat.PDF);
        ExportResult pdfResult = pdfExporter.export(document, "report", customOptions);
        printResult(pdfResult);

        System.out.println();

        // 2. Export to all formats via ExportService
        System.out.println("--- Export to all formats ---");
        ExportService service = new ExportService();
        List<ExportResult> results = service.exportToAllFormats(document, "report", ExportOptions.defaults());
        results.forEach(Main::printResult);

        System.out.println();

        // 3. Validation failure demo
        System.out.println("--- Validation failure demo ---");
        Document invalidDoc = new Document("", "", "Nobody");
        try {
            DocumentExporter exporter = DocumentExporterFactory.createExporter(DocumentFormat.HTML);
            exporter.export(invalidDoc, "invalid", ExportOptions.defaults());
        } catch (ExportException e) {
            System.out.println("Caught: " + e.getMessage());
        }
    }

    private static void printResult(ExportResult r) {
        System.out.printf("  -> %s (size: %d bytes)%n", r.outputPath(), r.sizeBytes());
    }
}
