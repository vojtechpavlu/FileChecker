package io.github.vojtechpavlu.fileChecker.core;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


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
 * <p>Class of {@link MaxFileSizeCheck} is an abstract representation
 * and implementation of the instances belonging to this class.</p>
 *
 * <p>Instances of this class are responsible for checking, if the given
 * {@link File} does take up disk space up to the given {@code long}
 * number.</p>
 *
 * <p>The opposite class is {@link MinFileSizeCheck}, which is used for
 * determining files with at least the given size.</p>
 *
 * @author Vojtech Pavlu
 * @version 2020-12-10
 *
 * @see MinFileSizeCheck
 */
public class MaxFileSizeCheck implements FileCheck {

    /* =========================================================== */
    /* ====== INSTANCE VARIABLES ================================= */

    /** This variable represents the max file size in bytes. Files with
     * greater size won't be accepted by the method of {@link MaxFileSizeCheck#check(File)} */
    private final long maxFileSize;

    /* =========================================================== */
    /* ====== CONSTRUCTORS ======================================= */

    /**
     * <p>This non-parametric constructor defines the instance with
     * <i>at max 0 bytes</i> restriction. It means every file passed
     * to the {@link MaxFileSizeCheck#check(File)} method results in
     * {@code false} (when the file exists, of course).</p>
     */
    private MaxFileSizeCheck() {

        this(0L);
    }


    /**
     * <p>This constructor builds an instance responsible for checking if the given files
     * has at the maximum the given byte size.</p>
     *
     * @param maxFileSize                   Maximum file size in bytes
     *
     * @throws IllegalArgumentException     When the given value is less than 0.
     */
    public MaxFileSizeCheck(long maxFileSize) throws IllegalArgumentException {

        if(maxFileSize < 0) {

            throw new IllegalArgumentException(String.format(
                    "Given minimal file size has to be greater or equal to zero: %d", maxFileSize)
            );
        }

        this.maxFileSize = maxFileSize;
    }



    /* =========================================================== */
    /* ====== INSTANCE METHODS =================================== */

    /**
     * <p>This method is responsible for checking, if the given {@link File}
     * corresponds the rules defined by this class.</p>
     *
     * @param file              Path to the {@link File} to be checked.
     *
     * @return                  {@code true} when the given file passes all
     *                          the subtests defined by this class. Otherwise
     *                          it returns {@code false}
     *
     * @throws IOException      When some error occurs. Usually it's because the
     *                          file does not exist or is not reachable.
     */
    @Override
    public boolean check(File file) throws IOException {

        return Files.size(Paths.get(file.toString())) <= this.maxFileSize;
    }


    /* =========================================================== */
    /* ====== STATIC METHODS ===================================== */


    /**
     * <p>This static method is used for fast check of the file. It provides
     * the same functionality but just using one method call.</p>
     *
     * @param file              To be checked if it is smaller or
     *                          equal to the given max size
     *
     * @param maxSize           {@code long} interpretation of number of
     *                          bytes the file can have to be still accepted
     *
     * @return                  {@code true} if only the file has lower or same
     *                          size as the given. Otherwise it returns {@code false}.
     *
     * @throws IOException      When there is a problem while processing the file.
     *                          Mostly when the file does not exist or there is not
     *                          access to it for the system.
     */
    private static boolean check(File file, long maxSize) throws IOException {

        return new MaxFileSizeCheck(maxSize).check(file);
    }


    /* =========================================================== */
    /* ====== GETTERS AND SETTERS ================================ */


    /**
     * <p>Returns the max file size used to determine the file size.</p>
     *
     * @return  {@code long}-formed number of bytes the file may have
     * to be accepted by the {@link MaxFileSizeCheck#check(File)} method.
     */
    public long getMaxFileSize() {

        return maxFileSize;
    }
}
