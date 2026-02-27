package com.taller3.export.model;

/**
 * Export options with format-specific settings.
 * Each exporter uses the fields relevant to its format.
 */
public record ExportOptions(
        PageSize pageSize,      // PDF: A4, Letter, Legal
        String template,        // Word: template name
        boolean embedCss,       // HTML: inline styles vs external file
        int maxContentLength   // Shared: validation limit
) {
    public static ExportOptions defaults() {
        return new ExportOptions(
                PageSize.A4,
                "default",
                true,
                1_000_000
        );
    }

    public static ExportOptions.Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private PageSize pageSize = PageSize.A4;
        private String template = "default";
        private boolean embedCss = true;
        private int maxContentLength = 1_000_000;

        public Builder pageSize(PageSize pageSize) {
            this.pageSize = pageSize;
            return this;
        }

        public Builder template(String template) {
            this.template = template;
            return this;
        }

        public Builder embedCss(boolean embedCss) {
            this.embedCss = embedCss;
            return this;
        }

        public Builder maxContentLength(int maxContentLength) {
            this.maxContentLength = maxContentLength;
            return this;
        }

        public ExportOptions build() {
            return new ExportOptions(pageSize, template, embedCss, maxContentLength);
        }
    }

    public enum PageSize {
        A4,
        LETTER,
        LEGAL
    }
}
