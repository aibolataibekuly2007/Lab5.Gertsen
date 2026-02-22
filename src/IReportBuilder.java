public interface IReportBuilder {
    IReportBuilder setHeader(String header);
    IReportBuilder setContent(String content);
    IReportBuilder setFooter(String footer);
    Report getReport();
}