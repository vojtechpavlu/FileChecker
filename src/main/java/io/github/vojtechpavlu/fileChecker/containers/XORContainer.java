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
 * <p>Class of {@link XORContainer} is an abstract representation
 * and implementation of the instances belonging to this class.</p>
 *
 * <p>XOR based file check container provides ability to test if
 * the given file checks' answers differs for the given file.
 * The base is the XOR boolean function for variable number of
 * inputs.</p>
 *
 * <table>
 *     <th>
 *         <td>A</td>
 *         <td>B</td>
 *         <td>...</td>
 *         <td>N</td>
 *         <td>R</td>
 *     </th>
 *     <tr>
 *         <td>0</td>
 *         <td>0</td>
 *         <td>...</td>
 *         <td>0</td>
 *         <td>0</td>
 *     </tr>
 *     <tr>
 *         <td>1</td>
 *         <td>0</td>
 *         <td>...</td>
 *         <td>0</td>
 *         <td>1</td>
 *     </tr>
 *     <tr>
 *         <td>1</td>
 *         <td>1</td>
 *         <td>...</td>
 *         <td>0</td>
 *         <td>1</td>
 *     </tr>
 *     <tr>
 *         <td>...</td>
 *         <td>...</td>
 *         <td>...</td>
 *         <td>...</td>
 *         <td>1</td>
 *     </tr>
 *     <tr>
 *         <td>1</td>
 *         <td>1</td>
 *         <td>...</td>
 *         <td>1</td>
 *         <td>0</td>
 *     </tr>
 * </table>
 *
 * <p>This is the schema of the multiple input XOR used in this class. The base functionality
 * is provided using checking if any of the file checks returns different value than the
 * first one. This means there is a need for at least two of them.</p>
 *
 * @author Vojtech Pavlu
 * @version 2021-02-25
 */
public class XORContainer implements MultipleFileCheckContainer {

    /* =========================================================== */
    /* ====== INSTANCE VARIABLES ================================= */

    /** List of all the checks used for testing the files. */
    private List<FileCheck> checks = new ArrayList<>();


    /* =========================================================== */
    /* ====== STATIC VARIABLES =================================== */

    private static final byte NUMBER_OF_NEEDED_VALUES = 2;
    private static final String ERROR_MESSAGE =
            String.format("There is not enough of file checks to provide XOR operation! " +
                          "There has to be at least %d of them",
                          NUMBER_OF_NEEDED_VALUES
            );


    /* =========================================================== */
    /* ====== CONSTRUCTORS ======================================= */


    /**
     * <p>This non-parametric constructor only creates the empty instance.</p>
     */
    private XORContainer() {}


    /**
     * <p>This parametric constructor creates the container and fills
     * it with the given {@link FileCheck}s.</p>
     *
     * @param fileChecks    to be added to the container.
     */
    public XORContainer(FileCheck... fileChecks) {

        this.checks.addAll(Arrays.asList(fileChecks));
    }


    /**
     * <p>This parametric constructor creates the instance using only one instance
     * of the {@link FileCheck}. It can be another container.</p>
     *
     * @param fileCheck to be added to the list of checks.
     */
    public XORContainer(FileCheck fileCheck) {

        this.checks.add(fileCheck);
    }



    /**
     * <p>This parametric constructor creates the container and fills
     * it with the given {@link FileCheck}s formed in an {@link List} instance.</p>
     *
     * @param fileChecks    {@link List} of checks to be added to the container.
     */
    public XORContainer(List<FileCheck> fileChecks) {

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
     * @return {@code true} when there is an at least one difference between all the
     *          file checks.
     *
     * @throws IOException When some error occurs. Usually it's because the
     *                     file does not exist or is not reachable.
     */
    @Override
    public boolean check(File file) throws IOException {

        if(this.checks.size() > 1) {

            boolean first = this.checks.get(0).check(file);

            for (int i = 1; i < this.checks.size(); i++) {

                if (this.checks.get(i).check(file) != first) {

                    return true;
                }
            }

            return false;

        } else {

            throw new RuntimeException(ERROR_MESSAGE);
        }
    }
}
