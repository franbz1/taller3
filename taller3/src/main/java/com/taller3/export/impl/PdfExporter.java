package com.taller3.export.impl;

import com.taller3.export.AbstractDocumentExporter;
import com.taller3.export.ExportException;
import com.taller3.export.model.Document;
import com.taller3.export.model.ExportOptions;
import com.taller3.export.model.ExportResult;

/**
 * Concrete exporter for PDF format.
 * Uses page size from options.
 */
public class PdfExporter extends AbstractDocumentExporter {
    public PdfExporter() {
        super("PDF");
    }

    @Override
    protected ExportResult doExport(Document document, String filename, ExportOptions options) {
        String outputPath = filename + ".pdf";
        System.out.println("[PDF] Page size: " + options.pageSize());
        System.out.println("[PDF] Simulating PDF rendering and compression...");
        long estimatedSize = document.content().length() * 2L;
        return ExportResult.success(outputPath, estimatedSize);
    }

    @Override
    public void validate(Document document, ExportOptions options) {
        super.validate(document, options);
        if (document.title().length() > 200) {
            throw new ExportException("PDF title too long (max 200 chars)");
        }
    }
}
