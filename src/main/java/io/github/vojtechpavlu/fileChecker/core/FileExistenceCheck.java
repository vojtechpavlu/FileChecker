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
 * <p>Class of {@link FileExistenceCheck} is an abstract representation
 * and implementation of the instances belonging to this class.</p>
 *
 * <p>This class checks if the given {@link File} exists.</p>
 *
 * @author Vojtech Pavlu
 * @version 2020-12-10
 */
public class FileExistenceCheck implements FileCheck {

    /* =========================================================== */
    /* ====== STATIC VARIABLES =================================== */

    /** Static prepared instance to do fast inline checks in code using eager initialization. */
    private static final FileExistenceCheck PROTOTYPE = new FileExistenceCheck();


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

        return file.exists();
    }


    /**
     * <p>This static method eases the usage of the class by directly using the
     * prepared tester.</p>
     *
     * @param file      to be tested, if it exists or not.
     *
     * @return          {@code true} only if the given {@link File} was found and
     *                  has enough access. Otherwise it returns {@code false}.
     */
    public static boolean exists(File file) {

        return PROTOTYPE.check(file);
    }
}
