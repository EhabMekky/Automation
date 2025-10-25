package util;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import strategy.DriverStrategy;
import org.springframework.util.FileCopyUtils;

import java.io.File;
import java.io.IOException;
import java.util.Base64;

public class Utils {
    public static String decodeBase64(String encodedStr)
    {
        Base64.Decoder decoder = Base64.getDecoder();
        return new String(decoder.decode(encodedStr.getBytes()));
    }

    public static boolean takeScreenShot() throws IOException {
        File file = ((TakesScreenshot) DriverStrategy.getDriver())
                .getScreenshotAs(OutputType.FILE);

        FileCopyUtils.copy(file,
                new File (Constant.SCREENSHOT_FOLDER + generateRandomString(Constant.SCREENSHOT_NAME_LENGTH) + Constant.SCREENSHOT_EXTENSION));

        return true;
    }

    private static String generateRandomString(int length)
    {
        String seedChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder sb = new StringBuilder();
        int i = 0;
        java.util.Random random = new java.util.Random();
        while(i < length)
        {
            sb.append(seedChars.charAt(random.nextInt(seedChars.length())));
            i++;
        }
        return sb.toString();
    }
}
