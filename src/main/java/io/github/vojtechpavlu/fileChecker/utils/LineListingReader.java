package io.github.vojtechpavlu.fileChecker.utils;


import java.io.*;
import java.util.ArrayList;
import java.util.List;


/**
 * <i>AUTHOR OF THIS PROJECT IS NOT RESPONSIBLE FOR ANY DAMAGE TO
 * THE USER'S DEVICE CAUSED BY USING THIS SOFTWARE, NO DATA LEAKS
 * OR DATA INTEGRITY DAMAGE.</i>
 *
 * <i>THIS PIECE OF SOFTWARE WAS MADE WITH NO GUARANTEE AND SHOULD
 * NOT BE USED FOR CRITICAL INFRASTRUCTURE OF YOUR APPS. THIS
 * PROJECT WAS CREATED JUST FOR FUN.</i>
 *
 *
 * <p>Class of {@link LineListingReader} is an abstract representation
 * and implementation of the instances belonging to this class.</p>
 *
 * <p>This instance provides reading a file as a {@link List} of Strings,
 * where each of the items in the list is a line of the file. Alternative
 * is a {@link NewLineSeparatingReader}, which returns just one String,
 * while the lines are separated by the {@code \n} sequence.</p>
 *
 * @author Vojtech Pavlu
 * @version 2021-02-25
 *
 * @see FileReader
 * @see NewLineSeparatingReader
 */
public class LineListingReader implements FileReader {


    /* =========================================================== */
    /* ====== INSTANCE VARIABLES ================================= */

    /** The encoding used for file reading */
    private FileEncoding fileEncoding;


    /* =========================================================== */
    /* ====== STATIC VARIABLES =================================== */

    /**
     * <p>{@code Multiton} design pattern collection holding already created instances.</p>
     */
    private static List<LineListingReader> READERS = new ArrayList<>();



    /* =========================================================== */
    /* ====== STATIC INIT BLOCKS ================================= */


    static {

        READERS.add(new LineListingReader(FileEncoding.UTF_8));
        READERS.add(new LineListingReader(FileEncoding.ANSI));
        READERS.add(new LineListingReader(FileEncoding.windows_1250));
        READERS.add(new LineListingReader(FileEncoding.windows_1251));
        READERS.add(new LineListingReader(FileEncoding.windows_1252));
        READERS.add(new LineListingReader(FileEncoding.windows_1253));
        READERS.add(new LineListingReader(FileEncoding.windows_1254));
        READERS.add(new LineListingReader(FileEncoding.windows_1257));
    }


    /* =========================================================== */
    /* ====== CONSTRUCTORS ======================================= */


    /**
     * <p>Private parametric constructor defining the encoding which should be
     * used for file reading.</p>
     *
     * @param fileEncoding  {@link FileEncoding} used for file reading
     */
    private LineListingReader(FileEncoding fileEncoding) {

        this.fileEncoding = fileEncoding;
    }


    private LineListingReader() {}



    /* =========================================================== */
    /* ====== OVERRIDDEN METHODS ================================= */



    /**
     * <p>This method reads a file and returns a String representation of the content.</p>
     *
     * @param file {@link File} to be read
     *
     * @return {@link String}-formed content
     *
     * @throws FileNotFoundException        When an error while finding file occurs
     * @throws UnsupportedEncodingException When the given encoding is not supported
     * @throws IOException                  When an error while reading file occurs
     */
    @Override
    public List<String> read(File file) throws FileNotFoundException, UnsupportedEncodingException, IOException {

        BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(file),
                        this.fileEncoding.getEncoding())
        );

        List<String> lines = new ArrayList<>();

        String line = "";

        while((line = reader.readLine()) != null) {

            lines.add(line);
        }

        return lines;
    }


    /* =========================================================== */
    /* ====== STATIC METHODS ===================================== */


    /**
     * <p>Static method defined as an access point for {@code Multiton} design pattern.</p>
     *
     * @param encoding  {@link FileEncoding} which should be used for file reading
     *
     * @return  instance providing the ability to read a given file using the given encoding
     */
    public static FileReader getReader(FileEncoding encoding) {

        for (FileReader fr : READERS) {

            if(fr.getEncoding().equals(encoding)) {

                return fr;
            }
        }

        return new LineListingReader(encoding);
    }


    /* =========================================================== */
    /* ====== GETTERS AND SETTERS ================================ */

    /**
     * <p>This method returns an encoding used to read the files.</p>
     *
     * @return {@link FileEncoding} used for reading the given files.
     */
    @Override
    public FileEncoding getEncoding() {

        return this.fileEncoding;
    }
}
