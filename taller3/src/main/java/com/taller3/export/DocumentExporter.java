package com.taller3.export;

import com.taller3.export.model.Document;
import com.taller3.export.model.ExportOptions;
import com.taller3.export.model.ExportResult;

/**
 * Interface for document exporters.
 * All concrete exporters (PDF, Word, HTML) implement this interface.
 */
public interface DocumentExporter {
    /**
     * Exports the document to the specified format.
     *
     * @param document The document to export
     * @param filename The output filename (without extension)
     * @param options  Format-specific export options
     * @return ExportResult with output path, size, and status
     * @throws ExportException if validation fails
     */
    ExportResult export(Document document, String filename, ExportOptions options);
}
