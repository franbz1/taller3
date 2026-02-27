package com.taller3.export;

import com.taller3.export.model.Document;
import com.taller3.export.model.ExportOptions;
import com.taller3.export.model.ExportResult;

/**
 * Abstract base for exporters. Implements template method:
 * validate -> doExport -> log result.
 */
public abstract class AbstractDocumentExporter implements DocumentExporter {
    private final String formatName;

    protected AbstractDocumentExporter(String formatName) {
        this.formatName = formatName;
    }

    @Override
    public final ExportResult export(Document document, String filename, ExportOptions options) {
        validate(document, options);
        System.out.println("[" + formatName + "] Validated document: \"" + document.title() + "\"");
        ExportResult result = doExport(document, filename, options);
        System.out.println("[" + formatName + "] " + result.message());
        return result;
    }

    /**
     * Format-specific export logic. Subclasses implement this.
     */
    protected abstract ExportResult doExport(Document document, String filename, ExportOptions options);

    /**
     * Default validation: content length. Subclasses may override for stricter rules.
     */
    public void validate(Document document, ExportOptions options) {
        if (document.content().length() > options.maxContentLength()) {
            throw new ExportException("Content exceeds max length: " + options.maxContentLength());
        }
        if (document.content().isBlank()) {
            throw new ExportException("Document content cannot be empty");
        }
    }
}
