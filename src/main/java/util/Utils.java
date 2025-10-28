package util;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.internal.IResultListener;
import strategy.DriverStrategy;
import org.springframework.util.FileCopyUtils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;

public class Utils {

    public static String decodeBase64(String encodedStr) {
        Base64.Decoder decoder = Base64.getDecoder();
        return new String(decoder.decode(encodedStr.getBytes()));
    }

    public static boolean takeScreenShot() throws IOException {
        File file = ((TakesScreenshot) DriverStrategy.getDriver())
                .getScreenshotAs(OutputType.FILE);

        String testName = IResultListener.class.getSimpleName();

        String timestamp = new SimpleDateFormat("dd-MM-yyyy_hh-mm-a").format(new Date());
        String safeTimestamp = timestamp.replace(":", "-");

        String randomSuffix = generateRandomString(Constant.SCREENSHOT_NAME_LENGTH);

        // Combine to make a clean, descriptive filename
        String fileName = testName + "_" + safeTimestamp + "_" + randomSuffix + Constant.SCREENSHOT_EXTENSION;

        File destination = new File(Constant.SCREENSHOT_FOLDER + fileName);
        FileCopyUtils.copy(file, destination);

        return true;
    }

    private static String generateRandomString(int length) {
        String seedChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder sb = new StringBuilder();
        java.util.Random random = new java.util.Random();
        for (int i = 0; i < length; i++) {
            sb.append(seedChars.charAt(random.nextInt(seedChars.length())));
        }
        return sb.toString();
    }
}
