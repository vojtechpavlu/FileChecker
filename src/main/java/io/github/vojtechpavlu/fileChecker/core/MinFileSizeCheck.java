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
 * <p>Class of {@link MinFileSizeCheck} is an abstract representation
 * and implementation of the instances belonging to this class.</p>
 *
 * <p>Instances of this class checks if the given file is at least
 * as big as specified in the constructor. Client sets the minimum
 * number of bytes (in {@code long}) and uses the instance through
 * a method of {@link MinFileSizeCheck#check(File)}.</p>
 *
 * <p>The opposite class is {@link MaxFileSizeCheck}, which is used for
 * determining files with at max the given size.</p>
 *
 * @author Vojtech Pavlu
 * @version 2021-01-23
 *
 * @see MaxFileSizeCheck
 */
public class MinFileSizeCheck implements FileCheck {

    /* =========================================================== */
    /* ====== INSTANCE VARIABLES ================================= */

    /** This variable represents the min file size in bytes. Files with less
     * size won't be accepted by the method of {@link MinFileSizeCheck#check(File)} */
    private final long minSize;


    /* =========================================================== */
    /* ====== CONSTRUCTORS ======================================= */

    /**
     * <p>This constructor is here just for consistency. The default minimal
     * size of the acceptable file is set to 0.</p>
     *
     * <p>Because of the definition of this constructor, every existing file
     * has to be accepted by the {@link MinFileSizeCheck#check(File)} method.</p>
     */
    public MinFileSizeCheck() {

        this(0L);
    }


    /**
     * <p>This constructor sets the rule of the minimal size of given files to be
     * as the given parameter.</p>
     *
     * <p>The files has to be at least as large (in bytes) as the specified value
     * in the given {@code long} parameter {@code minSize}.</p>
     *
     * @param minSize       minimal acceptable size of the file in bytes.
     *
     * @throws IllegalArgumentException     When the given value is less than 0.
     */
    public MinFileSizeCheck(long minSize) throws IllegalArgumentException {

        if(minSize < 0) {

            throw new IllegalArgumentException(String.format(
                    "Given minimal file size has to be greater or equal to zero: %d", minSize)
            );
        }

        this.minSize = minSize;
    }



    /* =========================================================== */
    /* ====== INSTANCE METHODS =================================== */

    /**
     * <p>This method is responsible for checking, if the given {@link File}
     * corresponds the rules defined by this class.</p>
     *
     * @param file Path to the {@link File} to be checked.
     *
     * @return {@code true} when the given file passes all
     * the subtests defined by this class. Otherwise
     * it returns {@code false}
     *
     * @throws IOException When some error occurs. Usually it's because the
     *                     file does not exist or is not reachable.
     */
    @Override
    public boolean check(File file) throws IOException {

        return Files.size(Paths.get(file.toString())) >= this.minSize;
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

        return new MinFileSizeCheck(maxSize).check(file);
    }


    /* =========================================================== */
    /* ====== GETTERS AND SETTERS ================================ */


    /**
     * <p>Returns the minimal size the file may have to be accepted by the
     * {@link MinFileSizeCheck#check(File)} method.</p>
     *
     * @return  {@code long}-formed number of bytes the file has to have
     */
    public long getMinSize() {

        return minSize;
    }
}
