public class TextReportBuilder implements IReportBuilder {
    private Report report;

    public TextReportBuilder() {
        this.report = new Report("text");
    }

    @Override
    public IReportBuilder setHeader(String header) {
        report.setHeader("HEADER: " + header);
        return this;
    }

    @Override
    public IReportBuilder setContent(String content) {
        report.setContent("CONTENT:\n" + content);
        return this;
    }

    @Override
    public IReportBuilder setFooter(String footer) {
        report.setFooter("FOOTER: " + footer);
        return this;
    }

    @Override
    public Report getReport() {
        return report;
    }
}