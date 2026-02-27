package com.taller3.export;

import com.taller3.export.model.Document;
import com.taller3.export.model.ExportOptions;
import com.taller3.export.model.ExportResult;

import java.util.ArrayList;
import java.util.List;

/**
 * Service that uses the Factory to export a document to multiple formats.
 * Demonstrates composition: the service depends on DocumentExporterFactory
 * and orchestrates batch exports.
 */
public class ExportService {

    /**
     * Exports the document to all supported formats.
     *
     * @param document The document to export
     * @param baseName Base filename (without extension)
     * @param options  Export options
     * @return List of results, one per format
     */
    public List<ExportResult> exportToAllFormats(Document document, String baseName, ExportOptions options) {
        List<ExportResult> results = new ArrayList<>();
        for (DocumentFormat format : DocumentFormat.values()) {
            DocumentExporter exporter = DocumentExporterFactory.createExporter(format);
            ExportResult result = exporter.export(document, baseName, options);
            results.add(result);
        }
        return results;
    }

    /**
     * Exports to a single format. Convenience method.
     */
    public ExportResult export(Document document, DocumentFormat format, String baseName, ExportOptions options) {
        DocumentExporter exporter = DocumentExporterFactory.createExporter(format);
        return exporter.export(document, baseName, options);
    }
}
