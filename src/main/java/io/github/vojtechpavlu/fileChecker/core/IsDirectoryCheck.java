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
 * <p>Class of {@link IsDirectoryCheck} is an abstract representation
 * and implementation of the instances belonging to this class.</p>
 *
 * <p>Checks if the given {@link File} is or is not an directory.</p>
 *
 * @author Vojtech Pavlu
 * @version 2020-12-10
 *
 * @see IsFileCheck
 */
public class IsDirectoryCheck implements FileCheck {


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
     */
    @Override
    public boolean check(File file) {

        return file.isDirectory();
    }
}
