package io.github.vojtechpavlu.fileChecker.utils;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.NotDirectoryException;
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
 * <p>Interface of {@link Crawler} defines a basic set of signatures
 * of methods overridden by it's descendants.</p>
 *
 * <p>This interface defines one method - {@link Crawler#crawl(File)}, which
 * is responsible for searching in the folder and it's descendants.</p>
 *
 * @author Vojtech Pavlu
 * @version 2021-02-24
 *
 * @see RestrictedSearch
 * @see FilesOnlyCrawler
 * @see FoldersOnlyCrawler
 */
public interface Crawler {

    /**
     * <p>This method is the general functionality this instance provides.
     * It serializes all the files the given folder has inside.</p>
     *
     * @param folder                    to be searched in and in it's children
     *
     * @return                          {@link List} of all the files the given
     *                                  folder (or it's descendants) has inside.
     *
     * @throws NotDirectoryException    When the given file is not a folder
     * @throws IOException              When the given file does not exist
     */
    default List<File> crawl(File folder) throws NotDirectoryException, IOException {

        return Crawler.search(folder, new ArrayList<>());
    }


    /**
     * <p>Searches through all the descendants of all the files.</p>
     *
     * @param folder                    to be searched in for.
     * @param files                     list the found files should be added to
     *
     * @return                          {@link List} of files the algorithm found
     *
     * @throws FileNotFoundException    when the given file does not exist
     * @throws NotDirectoryException    when the given file is not a directory
     */
    static List<File> search(File folder, List<File> files) throws FileNotFoundException, NotDirectoryException {

        if(!folder.exists()) {

            throw new FileNotFoundException(String.format("File \"%s\" was not found", folder));

        } else if(!folder.isDirectory()) {

            throw new NotDirectoryException(String.format("Given file \"%s\" is not a directory", folder));
        }

        for (File f : folder.listFiles()) {

            if(f.isDirectory()) {

                search(f, files);
            }

            files.add(f);
        }

        return files;
    }
}
