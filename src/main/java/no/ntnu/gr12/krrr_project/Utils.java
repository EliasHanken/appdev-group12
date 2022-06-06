package no.ntnu.gr12.krrr_project;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Calendar;
import java.util.Date;
import javax.imageio.ImageIO;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Utils {
    Logger logger = LoggerFactory.getLogger(this.getClass().getSimpleName());

    public static Date dateNow(){
        return new Date();
    }

    public static Date dateLaterDays(int days){
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.DATE,days);
        return cal.getTime();
    }

    public static Date dateLaterSeconds(int seconds){
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.SECOND,seconds);
        return cal.getTime();
    }

  /**
   * Attempts to convert an image specified by sourceFilePath into a byte array for sending
   * via XMLHttpRequest
   * @param sourceFilePath Path of file to be converted - Needs to be path from source root
   *                       i.e: images/commuter.jpg for file "commuter.jpg" located in resources/images
   * @param extension extension of file to be converted
   * @return Array of bytes resulting from conversion of image file.
   * @throws IOException
   */
    public byte[] imageToByteArray(String sourceFilePath, String extension) throws IOException {
      try{
        InputStream input = Utils.class.getClassLoader().getResourceAsStream(sourceFilePath);
        return IOUtils.toByteArray(input);
      } catch (Exception e) {
        e.printStackTrace();
        return null;
      }
    }
}
