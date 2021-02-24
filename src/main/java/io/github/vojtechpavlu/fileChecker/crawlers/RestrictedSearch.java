package io.github.vojtechpavlu.fileChecker.crawlers;


import io.github.vojtechpavlu.fileChecker.core.FileCheck;

import java.io.File;
import java.io.IOException;
import java.nio.file.NotDirectoryException;
import java.util.ArrayList;
import java.util.Arrays;
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
 * <p>Class of {@link RestrictedSearch} is an abstract representation
 * and implementation of the instances belonging to this class.</p>
 *
 * <p>This is general searching and filtering instances class definition.
 * It provides usage of parent's default method ({@link Crawler#crawl(File)}),
 * and it's output filters by the given rules made of {@link FileCheck} instances.</p>
 *
 * <p>Example of usage:
 * {@code   Crawler c = new RestrictedSearch(
 *                  new HasSuffixCheck(".avi"),
 *                  new MinFileSizeCheck(300_000_000L),
 *                  new MaxFileSizeCheck(1_000_000_000L));
 *
 *          c.crawl("D:/video/");}</p>
 *
 * <p>This example provides search in the hypothetical folder of "{@code D:/video}"
 * and filters all the files with size in between range of 300 MB and 1 GB and with
 * suffix of {@code .avi}.</p>
 *
 * @author Vojtech Pavlu
 * @version 2021-02-24
 */
public class RestrictedSearch implements Crawler {

    /* =========================================================== */
    /* ====== INSTANCE VARIABLES ================================= */

    /** The set of restrictions each file has to pass. When it does not,
     * it's filtered out. */
    protected final List<FileCheck> restrictions = new ArrayList<>();


    /* =========================================================== */
    /* ====== CONSTRUCTORS ======================================= */

    private RestrictedSearch() {}

    /**
     * <p>This constructor sets the file restrictions (represented by the
     * {@link FileCheck} instances) and it passes them to the list to be used
     * as filter criteria.</p>
     *
     * <p>When a found file does not pass any of the given tests, it's filtered
     * out and won't be returned.</p>
     *
     * @param checks    {@link FileCheck} restrictions defining the files and
     *                  it's specifications.
     */
    public RestrictedSearch(FileCheck... checks) {

        this.restrictions.addAll(Arrays.asList(checks));
    }


    /* =========================================================== */
    /* ====== OVERRIDDEN METHODS ================================= */

    /**
     * <p>This method is the general functionality this instance provides.
     * It serializes all the files the given folder has inside.</p>
     *
     * <p>This method works as a filter of the parental default method of
     * {@link Crawler#crawl(File)}. The filtering process is done using
     * the given restrictions formed in {@link FileCheck}s. When a found file
     * does not passes the test, it won't be passed as a result.</p>
     *
     * @param folder to be searched in and in it's children
     *
     * @return {@link List} of all the files the given
     * folder (or it's descendants) has inside.
     *
     * @throws NotDirectoryException When the given file is not a folder
     * @throws IOException           When the given file does not exist
     */
    @Override
    public List<File> crawl(File folder) throws NotDirectoryException, IOException {

        List<File> files = new ArrayList<>();

        for (File f : Crawler.super.crawl(folder)) {

            boolean filePassed = true;

            for (FileCheck fc : this.restrictions) {

                if(!fc.check(f)) {

                    filePassed = false;
                    break;
                }
            }

            if(filePassed) {

                files.add(f);
            }
        }

        return files;
    }
}
