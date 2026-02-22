public class Report {
    private String header;
    private String content;
    private String footer;
    private String format;

    public Report(String format) {
        this.format = format;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setFooter(String footer) {
        this.footer = footer;
    }

    public void display() {
        System.out.println("\n=== " + format.toUpperCase() + " REPORT ===");
        System.out.println(header);
        System.out.println("-".repeat(50));
        System.out.println(content);
        System.out.println("-".repeat(50));
        System.out.println(footer);
    }

    public String getHeader() {
        return header;
    }

    public String getContent() {
        return content;
    }

    public String getFooter() {
        return footer;
    }

    public String getFormat() {
        return format;
    }
}