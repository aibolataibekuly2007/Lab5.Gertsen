public class PdfReportBuilder implements IReportBuilder {
    private Report report;

    public PdfReportBuilder() {
        this.report = new Report("pdf");
    }

    @Override
    public IReportBuilder setHeader(String header) {
        report.setHeader("PDF HEADER: " + header);
        return this;
    }

    @Override
    public IReportBuilder setContent(String content) {
        report.setContent("PDF CONTENT:\n" + content + "\n[Page 1]");
        return this;
    }

    @Override
    public IReportBuilder setFooter(String footer) {
        report.setFooter("PDF FOOTER: " + footer + " | Page 1/1");
        return this;
    }

    @Override
    public Report getReport() {
        return report;
    }
}