package pure.autotests.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import pure.autotests.helpers.DriverHelper;

import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;
import static pure.autotests.helpers.AttachmentsHelper.*;


public class TestBase {
    @BeforeAll
    static void setUp() {
        DriverHelper.configureDriver();
    }

    @AfterEach
    public void addAttachments() {
        String sessionId = DriverHelper.getSessionId();

        attachScreenshot("Last screenshot");
        attachPageSource();
//        attachNetwork(); // todo
        attachAsText("Browser console logs", DriverHelper.getConsoleLogs());
        if (DriverHelper.isVideoOn()) attachVideo(sessionId);

        closeWebDriver();
    }
}
