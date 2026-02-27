package com.taller3.export.impl;

import com.taller3.export.AbstractDocumentExporter;
import com.taller3.export.model.Document;
import com.taller3.export.model.ExportOptions;
import com.taller3.export.model.ExportResult;

/**
 * Concrete exporter for Microsoft Word (.docx) format.
 * Uses template from options.
 */
public class WordExporter extends AbstractDocumentExporter {
    public WordExporter() {
        super("WORD");
    }

    @Override
    protected ExportResult doExport(Document document, String filename, ExportOptions options) {
        String outputPath = filename + ".docx";
        System.out.println("[WORD] Template: " + options.template());
        System.out.println("[WORD] Building DOCX structure with content...");
        long estimatedSize = document.content().length() * 3L;
        return ExportResult.success(outputPath, estimatedSize);
    }
}
