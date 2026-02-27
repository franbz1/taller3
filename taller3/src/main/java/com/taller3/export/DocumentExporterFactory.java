package com.taller3.export;

import com.taller3.export.impl.HtmlExporter;
import com.taller3.export.impl.PdfExporter;
import com.taller3.export.impl.WordExporter;

/**
 * Factory for creating document exporters based on the desired format.
 * Implements the Factory pattern: encapsulates object creation logic
 * and returns the appropriate exporter without the client needing to know
 * the concrete class.
 */
public class DocumentExporterFactory {

    /**
     * Creates an exporter for the specified format.
     *
     * @param format The desired export format (PDF, WORD, HTML)
     * @return A DocumentExporter instance for the given format
     * @throws IllegalArgumentException if the format is not supported
     */
    public static DocumentExporter createExporter(DocumentFormat format) {
        return switch (format) {
            case PDF -> new PdfExporter();
            case WORD -> new WordExporter();
            case HTML -> new HtmlExporter();
            default -> throw new IllegalArgumentException("Unsupported format: " + format);
        };
    }
}
