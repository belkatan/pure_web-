package pure.autotests.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;
import static pure.autotests.helpers.AttachmentsHelper.*;
import static pure.autotests.helpers.DriverHelper.*;


public class TestBase {
    @BeforeAll
    static void setUp() {
        configureDriver();
    }

    @AfterEach
    public void addAttachments() {
        String sessionId = getSessionId();

        attachScreenshot("Last screenshot");
        attachPageSource();
//        attachNetwork(); // todo
        attachAsText("Browser console logs", getConsoleLogs());
        if (isVideoOn()) attachVideo(sessionId);

        closeWebDriver();
    }
}