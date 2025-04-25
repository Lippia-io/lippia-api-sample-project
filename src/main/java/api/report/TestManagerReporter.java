package api.report;

import io.lippia.reporter.ltm.TestManagerAPIAdapter;

public class TestManagerReporter extends TestManagerAPIAdapter {
    public TestManagerReporter(String arg0) {
    }

    @Override
    public String getBase64Image() {
        return null;
    }
}