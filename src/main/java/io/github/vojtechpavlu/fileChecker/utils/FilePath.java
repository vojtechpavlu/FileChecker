package io.github.vojtechpavlu.fileChecker.utils;


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
 * <p>Class of {@link FilePath} is an abstract representation
 * and implementation of the instances belonging to this class.</p>
 *
 * <p>This class is used to determine the whole path to the given file.
 * All the parent folders are given to a list using recursive algorithm.</p>
 *
 * <p>Everything depends on the file existence - when it does not exist,
 * the path is irrelevant and therefore it throws an {@link IOException}.</p>
 *
 * @author Vojtech Pavlu
 * @version 2021-02-24
 */
public class FilePath {

    /* =========================================================== */
    /* ====== INSTANCE VARIABLES ================================= */

    /** {@link ArrayList}-formed set of all the parents. In the last
     * index is located the direct parent of the given file. */
    private List<File> parents = new ArrayList<>();

    /** Store of the file which path should be generated from */
    private File currentFile;


    /* =========================================================== */
    /* ====== STATIC VARIABLES =================================== */

    /** In case of passing the non-existing file, this {@link String} is
     * preformated message to help the orientation while debugging */
    private static final String ERROR_MESSAGE = "Given file \"%s\" does not exist";


    /* =========================================================== */
    /* ====== CONSTRUCTORS ======================================= */


    /**
     * <p>Parametric constructor defined to initialize the instance.</p>
     *
     * @param file  for which will be the path generated.
     */
    public FilePath(File file) {

        this.currentFile = file;
    }


    /* =========================================================== */
    /* ====== STATIC METHODS ===================================== */


    /**
     * <p>Private static method searches the parent of the given file and
     * recursively calls itself.</p>
     *
     * @param file      which ancestors should be found
     * @param parents   {@link List} to which the ancestors should be added to
     */
    private static void addParent(File file, List<File> parents) {

        File folder = file.getParentFile();

        if(folder != null) {

            addParent(folder, parents);
            parents.add(folder);
        }
    }


    /* =========================================================== */
    /* ====== GETTERS AND SETTERS ================================ */


    /**
     * <p>Method generating the list of parents of parents of parents and so on...</p>
     *
     * <p>Using recursive algorithm, all the folder parents are found and added to the
     * returned list. The last item in the list is the direct parent of the given file.</p>
     *
     * <p>Each call of the method inits a new parents search.</p>
     *
     * @return                  Brand new list of {@link File} parents formed in an {@link ArrayList}.
     *                          The last item is the direct parent of the given file.
     *
     * @throws IOException      When the given file does not exist.
     */
    public List<File> getFilePath() throws IOException {

        if(!this.currentFile.exists()) {

            throw new IOException(String.format(ERROR_MESSAGE, this.currentFile.toString()));
        }

        this.parents.clear();
        addParent(this.currentFile, this.parents);

        return this.parents;
    }


    /**
     * <p>Returns the current file for which the path is generated.</p>
     *
     * @return  instance of {@link File} class, which was given to the
     *          constructor in the origin
     */
    public File getCurrentFile() {

        return currentFile;
    }
}
