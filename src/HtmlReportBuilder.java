public class HtmlReportBuilder implements IReportBuilder {
    private Report report;

    public HtmlReportBuilder() {
        this.report = new Report("html");
    }

    @Override
    public IReportBuilder setHeader(String header) {
        report.setHeader("<h1>" + header + "</h1>");
        return this;
    }

    @Override
    public IReportBuilder setContent(String content) {
        String htmlContent = "<div class='content'>\n";
        String[] paragraphs = content.split("\n");
        for (String p : paragraphs) {
            htmlContent += "  <p>" + p + "</p>\n";
        }
        htmlContent += "</div>";
        report.setContent(htmlContent);
        return this;
    }

    @Override
    public IReportBuilder setFooter(String footer) {
        report.setFooter("<footer>" + footer + "</footer>");
        return this;
    }

    @Override
    public Report getReport() {
        return report;
    }
}