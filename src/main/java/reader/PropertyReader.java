package reader;

/**
 * Interface to represent file / xml / excel property reader
 */
public interface PropertyReader {

    String getProp(String key);

    void setPropertyFile(String propertyFilePath);

}
