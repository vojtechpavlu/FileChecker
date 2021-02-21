package io.github.vojtechpavlu.fileChecker.core;


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
 * <p>Class of {@link IsFileCheck} is an abstract representation
 * and implementation of the instances belonging to this class.</p>
 *
 * <p>Instances of this class are responsible for checking if the
 * given {@link File} is a file or is a directory, while file is
 * accepted only (not directory).</p>
 *
 * @author Vojtech Pavlu
 * @version 2020-12-31
 *
 * @see IsDirectoryCheck
 */
public class IsFileCheck implements FileCheck {


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
     */
    @Override
    public boolean check(File file) {

        return file.isFile();
    }
}
