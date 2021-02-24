package io.github.vojtechpavlu.fileChecker.containers;


import io.github.vojtechpavlu.fileChecker.core.FileCheck;

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
 *
 * <p>Class of {@link NOTContainer} is an abstract representation
 * and implementation of the instances belonging to this class.</p>
 *
 * <p>This {@link UnaryFileCheckContainer} is responsible for
 * inverting (negation) the answer of the given checker.</p>
 *
 * <p>Example usage is when you want to filter files which does not
 * have some attribute. For example with combination of
 * {@link io.github.vojtechpavlu.fileChecker.core.CanWriteCheck},
 * you know which file you can't write to.</p>
 *
 * @author Vojtech Pavlu
 * @version 2021-02-21
 *
 * @see UnaryFileCheckContainer
 * @see MultipleFileCheckContainer
 * @see ANDContainer
 * @see ORContainer
 */
public class NOTContainer implements UnaryFileCheckContainer {

    /* =========================================================== */
    /* ====== INSTANCE VARIABLES ================================= */

    /** The only instance of {@link FileCheck} inside this.
     * The fileCheck is about to be used to check the given files, but
     * it's result are inverted. */
    private final FileCheck fileCheck;


    /* =========================================================== */
    /* ====== CONSTRUCTORS ======================================= */

    /**
     * <p>Private non-parametric constructor of this class is defined
     * just in case of need for consistency.</p>
     */
    private NOTContainer() {

        this.fileCheck = null;
    }


    /**
     * <p>This parametric constructor defines the given file check as
     * the core of the container.</p>
     *
     * @param fileCheck     {@link FileCheck} to be used for the file checking
     *                      and which answers are about to be inverted.
     */
    public NOTContainer(FileCheck fileCheck) {

        this.fileCheck = fileCheck;
    }


    /* =========================================================== */
    /* ====== OVERRIDDEN METHODS ================================= */

    /**
     * <p>This method returns the {@link FileCheck} this container has inside.
     * It also can be any of the containers.</p>
     *
     * @return the only {@link FileCheck} this container has inside.
     */
    @Override
    public FileCheck getFileCheck() {

        return this.fileCheck;
    }

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
     *
     * @throws NullPointerException When the {@code fileCheck} is not defined
     */
    @Override
    public boolean check(File file) throws IOException, NullPointerException {

        return !this.fileCheck.check(file);
    }
}
