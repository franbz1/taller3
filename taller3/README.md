# Document Export - Factory Pattern Example

A Java example implementing the **Factory design pattern** for document export. The system exports documents to PDF, Word, and HTML with format-specific options, validation, and batch export support.

## Project Structure

```
src/main/java/com/taller3/
├── Main.java
└── export/
    ├── DocumentExporter.java          # Interface (product)
    ├── AbstractDocumentExporter.java  # Template method base class
    ├── DocumentExporterFactory.java   # Factory
    ├── DocumentFormat.java
    ├── ExportException.java           # Validation failures
    ├── ExportService.java             # Batch export (uses Factory)
    ├── model/
    │   ├── Document.java              # Rich document model
    │   ├── ExportOptions.java         # Format-specific options (Builder)
    │   └── ExportResult.java          # Export outcome
    └── impl/
        ├── PdfExporter.java
        ├── WordExporter.java
        └── HtmlExporter.java
```

## Concepts

- **Factory pattern**: `DocumentExporterFactory` creates exporters without client knowing concrete classes.
- **Template method**: `AbstractDocumentExporter` defines validate → doExport flow.
- **Builder**: `ExportOptions.builder()` for fluent configuration.
- **Validation**: Each exporter can override `validate()` (e.g. PDF enforces max title length).
- **Format-specific options**: `ExportOptions` holds pageSize (PDF), template (Word), embedCss (HTML).

## How It Works

1. The **client** requests an exporter by format: `DocumentExporterFactory.createExporter(DocumentFormat.PDF)`
2. The **factory** returns the correct concrete implementation (`PdfExporter`, etc.)
3. The client calls `export(content, filename)` on the interface — it never instantiates concrete classes

## Benefits

- **Loose coupling**: Client code depends only on `DocumentExporter`, not on `PdfExporter`, `WordExporter`, etc.
- **Single place for creation logic**: Adding a new format (e.g., TXT) requires only a new class + factory case
- **Simplified client**: No `if/switch` to choose the right class; the factory handles it

## How to Run

```bash
mvn compile exec:java -Dexec.mainClass="com.taller3.Main"
```

Or from an IDE: run the `Main` class.

## Sample Output

```
=== Document Export Demo (Factory Pattern) ===

[PDF] Exporting document to: report.pdf
[PDF] Content length: 89 characters
[PDF] Simulating PDF rendering and compression...
[PDF] Export completed successfully.

[WORD] Exporting document to: report.docx
...
```

## Note

Export logic uses console logs. In production you would generate real files (e.g. iText for PDF, Apache POI for Word).
