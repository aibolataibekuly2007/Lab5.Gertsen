public class ReportDirector {

    public Report constructSimpleReport(IReportBuilder builder,
                                        String header,
                                        String content) {
        return builder.setHeader(header)
                .setContent(content)
                .setFooter("Generated on: " + java.time.LocalDate.now())
                .getReport();
    }

    public Report constructFullReport(IReportBuilder builder,
                                      String header,
                                      String content,
                                      String footer) {
        return builder.setHeader(header)
                .setContent(content)
                .setFooter(footer)
                .getReport();
    }

    public Report constructReportWithCustomFooter(IReportBuilder builder,
                                                  String header,
                                                  String content,
                                                  String footer) {
        return builder.setHeader(header)
                .setContent(content)
                .setFooter(footer + " | Confidential")
                .getReport();
    }
}