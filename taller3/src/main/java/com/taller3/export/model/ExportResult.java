package com.taller3.export.model;

/**
 * Result of an export operation.
 */
public record ExportResult(
        String outputPath,
        long sizeBytes,
        boolean success,
        String message
) {
    public static ExportResult success(String outputPath, long sizeBytes) {
        return new ExportResult(outputPath, sizeBytes, true, "Export completed successfully");
    }

    public static ExportResult failure(String message) {
        return new ExportResult(null, 0, false, message);
    }
}
