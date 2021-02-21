package io.github.vojtechpavlu.fileChecker.core;


import java.io.File;
import java.io.IOException;


/**
 * <i>AUTHOR OF THIS PROJECT IS NOT RESPONSIBLE FOR ANY DAMAGE TO
 * THE USER'S DEVICE CAUSED BY USING THIS SOFTWARE, NO DATA LEAKS
 * OR DATA INTEGRITY DAMAGE.</i>
 *
 * <i>THIS PIECE OF SOFTWARE WAS MADE WITH NO GUARANTEE AND SHOULD
 * NOT BE USED FOR CRITICAL INFRASTRUCTURE OF YOUR APPS. THIS
 * PROJECT WAS CREATED JUST FOR FUN.</i>
 *
 * <p>Interface of {@link FileCheck} defines a basic set of signatures
 * of methods overridden by it's descendants.</p>
 *
 * <p>Classes implementing this interface are responsible for checking
 * if the given {@link File} does pass the test defined by the class.</p>
 *
 * @author Vojtech Pavlu
 * @version 2020-12-10
 */
public interface FileCheck {

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
    public boolean check(File file) throws IOException;


    /**
     * <p>This method is responsible for checking, if the given {@link File}
     * corresponds the rules defined by this class.</p>
     *
     * @param filePath          Path to the {@link File} to be checked.
     *
     * @return                  {@code true} when the given file passes all
     *                          the subtests defined by this class. Otherwise
     *                          it returns {@code false}
     *
     * @throws IOException      When some error occurs. Usually it's because the
     *                          file does not exist or is not reachable.
     */
    default boolean check(String filePath) throws IOException {

        return this.check(new File(filePath));
    }
}
