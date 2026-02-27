package com.taller3.export.impl;

import com.taller3.export.AbstractDocumentExporter;
import com.taller3.export.model.Document;
import com.taller3.export.model.ExportOptions;
import com.taller3.export.model.ExportResult;

/**
 * Concrete exporter for HTML format.
 * Uses embedCss from options.
 */
public class HtmlExporter extends AbstractDocumentExporter {
    public HtmlExporter() {
        super("HTML");
    }

    @Override
    protected ExportResult doExport(Document document, String filename, ExportOptions options) {
        String outputPath = filename + ".html";
        System.out.println("[HTML] Embed CSS: " + options.embedCss());
        System.out.println("[HTML] Wrapping content in HTML structure...");
        long estimatedSize = document.content().length() + (options.embedCss() ? 500 : 50);
        return ExportResult.success(outputPath, estimatedSize);
    }
}
