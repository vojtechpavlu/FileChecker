package io.github.vojtechpavlu.fileChecker.containers;


import io.github.vojtechpavlu.fileChecker.core.FileCheck;

import java.io.File;
import java.io.IOException;
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
 *
 * <p>Class of {@link ORContainer} is an abstract representation
 * and implementation of the instances belonging to this class.</p>
 *
 * <p></p>
 *
 * @author Vojtech Pavlu
 * @version 2021-02-21
 */
public class ORContainer implements MultipleFileCheckContainer {

    /* =========================================================== */
    /* ====== INSTANCE VARIABLES ================================= */

    /** The {@link List} of all the checks used to determine if the
     * given file corresponds the needs. The list is represented
     * by the {@link ArrayList} collection. */
    private List<FileCheck> checks = new ArrayList<>();


    /* =========================================================== */
    /* ====== CONSTRUCTORS ======================================= */


    /**
     * <p>This non-parametric constructor only creates the empty instance.</p>
     */
    private ORContainer() {}


    /**
     * <p>This parametric constructor creates the container and fills
     * it with the given {@link FileCheck}s.</p>
     *
     * @param fileChecks    to be added to the container.
     */
    public ORContainer(FileCheck... fileChecks) {

        this.checks.addAll(Arrays.asList(fileChecks));
    }


    /**
     * <p>This parametric constructor creates the instance using only one instance
     * of the {@link FileCheck}. It can be another container.</p>
     *
     * @param fileCheck to be added to the list of checks.
     */
    public ORContainer(FileCheck fileCheck) {

        this.checks.add(fileCheck);
    }



    /**
     * <p>This parametric constructor creates the container and fills
     * it with the given {@link FileCheck}s formed in an {@link List} instance.</p>
     *
     * @param fileChecks    {@link List} of checks to be added to the container.
     */
    public ORContainer(List<FileCheck> fileChecks) {

        this.checks.addAll(fileChecks);
    }



    /* =========================================================== */
    /* ====== OVERRIDDEN METHODS ================================= */

    /**
     * <p>This method returns all the checkers in the container.</p>
     *
     * @return {@link List} of all the {@link FileCheck} this container
     * have inside.
     */
    @Override
    public List<FileCheck> getAllChecks() {

        return this.checks;
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
     */
    @Override
    public boolean check(File file) throws IOException {

        for (FileCheck fc : this.checks) {

            if(fc.check(file)) {

                return true;
            }
        }

        return false;
    }
}
