public class BuilderTest {
    public static void main(String[] args) {
        System.out.println("=== Builder Pattern Test ===");

        ReportDirector director = new ReportDirector();

        System.out.println("\n--- Text Report ---");
        IReportBuilder textBuilder = new TextReportBuilder();
        Report textReport = director.constructFullReport(
                textBuilder,
                "Monthly Sales Report",
                "January: $10,000\nFebruary: $12,500\nMarch: $15,000",
                "Prepared by: John Doe"
        );
        textReport.display();

        System.out.println("\n--- HTML Report ---");
        IReportBuilder htmlBuilder = new HtmlReportBuilder();
        Report htmlReport = director.constructReportWithCustomFooter(
                htmlBuilder,
                "Annual Report 2025",
                "Q1: $45,000\nQ2: $52,000\nQ3: $48,000\nQ4: $61,000",
                "© 2025 Company Name"
        );
        htmlReport.display();

        System.out.println("\n--- PDF Report ---");
        IReportBuilder pdfBuilder = new PdfReportBuilder();
        Report pdfReport = director.constructSimpleReport(
                pdfBuilder,
                "Invoice Summary",
                "Total Invoices: 150\nTotal Amount: $75,000\nAverage: $500"
        );
        pdfReport.display();

        System.out.println("\n--- Builder Chaining Test ---");
        Report customReport = new HtmlReportBuilder()
                .setHeader("Custom Report")
                .setContent("Line 1\nLine 2\nLine 3")
                .setFooter("Custom Footer")
                .getReport();
        customReport.display();
    }
}