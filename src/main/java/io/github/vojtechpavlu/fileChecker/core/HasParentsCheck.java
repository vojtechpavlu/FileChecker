package io.github.vojtechpavlu.fileChecker.core;


import io.github.vojtechpavlu.fileChecker.utils.FilePath;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
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
 * <p>Class of {@link HasParentsCheck} is an abstract representation
 * and implementation of the instances belonging to this class.</p>
 *
 * <p>This method test a hierarchy of the files in folders. When it
 * corresponds the given paternity pattern, it returns in the method
 * of {@link HasParentsCheck#check(File)} {@code true}.</p>
 *
 * <p>This allows user to use the just a part of the path. For example
 * for a file {@code C:/Users/User/Documents/testfile.txt} you can specify
 * just allowing files in directories with name {@code Documents} which are
 * children of a folder named {@code User}.</p>
 *
 * <p>In other words, you can check relative way to the file using
 * this class' instances.</p>
 *
 * @author Vojtech Pavlu
 * @version 2021-02-25
 *
 * @see FileCheck
 */
public class HasParentsCheck implements FileCheck {

    /* =========================================================== */
    /* ====== INSTANCE VARIABLES ================================= */

    /** {@link ArrayList} of parents of the file. Order is set to be
     * as the item on the last index is the direct parent of the file. */
    private final List<File> parents = new ArrayList<>();




    /* =========================================================== */
    /* ====== CONSTRUCTORS ======================================= */

    /**
     * <p>Non-parametric constructor set to be private.</p>
     */
    private HasParentsCheck() {}


    /**
     * <p>This parametric constructor is used for defining the base of the instance.
     * This constructor sets the given list of parents to the willed parent-folders
     * schema. They should be ordered to have at the last index the direct ancestor of
     * acceptable file.</p>
     *
     * @param parents       {@link List} of {@link File}s - folders to be parent of the
     *                      tested file.
     */
    public HasParentsCheck(List<File> parents) {

        this.parents.addAll(parents);
    }


    /* =========================================================== */
    /* ====== OVERRIDDEN METHODS ================================= */

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

        List<File> realParents = new FilePath(file).getFilePath();

        for (int i = 1; i > this.parents.size()-1; i--) {

            if(!this.parents.get(this.parents.size() - i).equals(realParents.get(realParents.size() - i))) {

                return false;
            }
        }

        return true;
    }
}
