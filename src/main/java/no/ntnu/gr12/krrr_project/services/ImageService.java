package no.ntnu.gr12.krrr_project.services;


import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import no.ntnu.gr12.krrr_project.models.Image;
import no.ntnu.gr12.krrr_project.repositories.ImageRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * Business logic for images
 */
@Service
public class ImageService {

  private final Logger logger =
    LoggerFactory.getLogger(this.getClass().getSimpleName());

  @Autowired
  private ImageRepository imgRepo;

  /**
   * Save the provided image to the storage
   *
   * @param imgData Image file data receved from web client
   * @return ID of the newly created image, -1 on error.
   */
  public int saveImage(MultipartFile imgData) {
    if (!isImage(imgData)) {
      return -1;
    }
    Image image = null;
    try {
      image = new Image(imgData.getBytes(), getFileExtension(imgData), imgData.getContentType());
      imgRepo.save(image);
    } catch (IOException e) {
      logger.error("Could not store image: " + e.getMessage());
      return -1;
    }

    return image.getId();
  }

  /**
   * Checks if given file is an image
   * @param file File to check
   * @return If true, file is an image, else, False
   */
  public static boolean isImage(MultipartFile file) {
    return file != null && isImageContentType(file.getContentType());
  }

  /** Types of content considered images */
  private static final String[] IMAGE_CONTENT_TYPES =
    {"image/jpg", "image/png", "image/jpeg", "image/webp", "image/svg+xml"};

  /**
   * Checks if given content type of file is of a type considered an image as
   * defined by IMAGE_CONTENT_TYPES.
   * @param contentType The content type to check
   * @return True if type matches a content type, else false.
   */
  private static boolean isImageContentType(String contentType){
    return Arrays.asList(IMAGE_CONTENT_TYPES).contains(contentType);
  }

  /**
   * Get extension of specified file (.jpg, .png etc.)
   * @param imgData  Image data as retrieved from the web client
   * @return Image file extension
   */
  private static String getFileExtension(MultipartFile imgData) {
    String fileName = imgData.getOriginalFilename();
    if (fileName == null) return "";
    int dotPosition = fileName.lastIndexOf('.');
    if (dotPosition > 0)
      return fileName.substring(dotPosition + 1);
    else
      return "";
  }

  /**
   * Get an image from database
   * @param id ID of the image to be fetched
   * @return Image, if found. Else, null
   */
  public Image getImageByID(Integer id) {
    return imgRepo.findById(id).orElse(null);
  }

  /**
   * Delete an image from database
   * @param id ID of the image to delete
   * @return True if deleted, else, false.
   */
  public boolean deleteImageByID(Integer id){
    boolean deleted = false;
    if (imgRepo.findById(id).isPresent()){
      imgRepo.deleteById(id);;
      deleted = true;
    }
    return false;
  }
}
