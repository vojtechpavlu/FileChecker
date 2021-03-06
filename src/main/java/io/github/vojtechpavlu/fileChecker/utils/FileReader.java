package io.github.vojtechpavlu.fileChecker.utils;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;


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
 * <p>Interface of {@link FileReader} defines a basic set of signatures
 * of methods overridden by it's descendants.</p>
 *
 * <p>Instances implementing this interface are servants providing
 * reading text files. These readers has to have an encoding in which they
 * read the given files. Return values' types may differ.</p>
 *
 * <p>The core of this instance is the {@link FileReader#read(File)}, which
 * does all the work.</p>
 *
 * @author Vojtech Pavlu
 * @version 2021-02-25
 */
public interface FileReader {


    /**
     * <p>This method returns an encoding used to read the files.</p>
     *
     * @return  {@link FileEncoding} used for reading the given files.
     */
    public FileEncoding getEncoding();


    /**
     * <p>This method reads a file and returns a String representation of the content.</p>
     *
     * @param file  {@link File} to be read
     *
     * @return      {@link Object}-made result of the reading. Usually String or a set of
     *              Strings
     *
     * @throws FileNotFoundException            When an error while reading file occurs
     * @throws UnsupportedEncodingException     When the given encoding is not supported
     * @throws IOException                      When an error while reading file occurs
     */
    public Object read(File file) throws FileNotFoundException, UnsupportedEncodingException, IOException;
}
