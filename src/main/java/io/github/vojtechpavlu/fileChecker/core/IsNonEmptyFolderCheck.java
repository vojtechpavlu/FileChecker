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
 * <p>Class of {@link IsNonEmptyFolderCheck} is an abstract representation
 * and implementation of the instances belonging to this class.</p>
 *
 * <p>These instances are responsible for resolving, if the given files
 * are non-empty directories. Only if it is so, it returns {@code true}.
 * When the given file is not a directory, it basically does not throw
 * exception.</p>
 *
 * @author Vojtech Pavlu
 * @version 2020-12-31
 *
 * @see IsDirectoryCheck
 */
public class IsNonEmptyFolderCheck extends IsDirectoryCheck {


    /* =========================================================== */
    /* ====== INSTANCE METHODS =================================== */

    /**
     * <p>This method is responsible for checking, if the given {@link File}
     * corresponds the rules defined by this class.</p>
     *
     * <p>It checks if the given file is non-empty directory. Only if it is
     * so, it returns {@code true}. Otherwise it returns {@code false}. When
     * the given file is not a directory, it returns {@code false} and does
     * not throw any exception.</p>
     *
     * @param file Path to the {@link File} to be checked.
     *
     * @return {@code true} when the given file passes all
     * the subtests defined by this class. Otherwise
     * it returns {@code false}
     */
    @Override
    public boolean check(File file)  {

        if(super.check(file)) {

            return file.listFiles().length > 0;
        }

        return false;
    }
}
