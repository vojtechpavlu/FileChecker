package io.github.vojtechpavlu.fileChecker.crawlers;


import io.github.vojtechpavlu.fileChecker.core.MaxFileSizeCheck;
import io.github.vojtechpavlu.fileChecker.core.MinFileSizeCheck;

import java.io.File;


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
 * <p>Class of {@link FileSizesInRangeCrawler} is an abstract representation
 * and implementation of the instances belonging to this class.</p>
 *
 * <p>These instances allows to search the files by their file size.
 * Client creates an instance by calling it's constructor and passing
 * in the bound of the files.</p>
 *
 * <p>The functionality is provided by {@link RestrictedSearch#crawl(File)},
 * passing the {@link MinFileSizeCheck} and {@link MaxFileSizeCheck} instances.</p>
 *
 * @author Vojtech Pavlu
 * @version 2021-02-24
 *
 * @see RestrictedSearch
 * @see Crawler
 * @see FilesOnlyCrawler
 * @see FoldersOnlyCrawler
 */
public class FileSizesInRangeCrawler extends RestrictedSearch {


    /* =========================================================== */
    /* ====== STATIC VARIABLES =================================== */

    /** Error message in case of incorrect arguments of min and max file sizes. */
    private static final String ERROR_MESSAGE = "Given range is not acceptable! min: %d; max: %d";



    /* =========================================================== */
    /* ====== CONSTRUCTORS ======================================= */


    /**
     * <p>This parametric constructor defines a {@link RestrictedSearch} with filtering
     * files by their file size in bytes. Those sizes has to be in the given range to be
     * accepted. When it breaks any of the bounds, the file is about to be filtered out.</p>
     *
     * <p>Bounds are inclusive, the files has to have at least {@code min} size and at maximum
     * the {@code max} size in bytes.</p>
     *
     * @param min                           minimum size of the file in bytes. Has to be greater or
     *                                      equal to 0 and cannot be greater than {@code max}.
     * @param max                           maximum acceptable file size in bytes. Has to be greater
     *                                      or equal to {@code min} and greater or equal to 0.
     *
     * @throws IllegalArgumentException     When {@code min < max} or when any of them is less than 0.
     */
    public FileSizesInRangeCrawler(long min, long max) throws IllegalArgumentException {

        super();

        if(min > max || max < 0) {

            throw new IllegalArgumentException(String.format(ERROR_MESSAGE, min, max));
        }

        super.restrictions.add(new MinFileSizeCheck(min));
        super.restrictions.add(new MaxFileSizeCheck(max));
    }
}
