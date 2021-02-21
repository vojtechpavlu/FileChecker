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
 * <p>Class of {@link HasRegexNameCheck} is an abstract representation
 * and implementation of the instances belonging to this class.</p>
 *
 * <p>Checks if the given {@link File} has a name corresponding to
 * the given regular expression.</p>
 *
 * <p>These instances are used to determine and filter the files with
 * pattern-made names. For example to filter a set of pictures in one
 * directory made by a camera. These usually have names like
 * {@code DCIM20201210-5.jpg}, which can be specified using this instance.</p>
 *
 * @author Vojtech Pavlu
 * @version 2020-12-10
 *
 * @see HasSuffixCheck
 */
public class HasRegexNameCheck implements FileCheck {

    /* =========================================================== */
    /* ====== INSTANCE VARIABLES ================================= */

    /** Regular expression used for checking if the name of the given file
     * corresponds it. For using suffix regex check, use {@link HasSuffixCheck} */
    private final String regex;


    /* =========================================================== */
    /* ====== CONSTRUCTORS ======================================= */


    /**
     * <p>This non-parametric constructor creates an instance with regex
     * set to {@code .*}, which will accept all the file names as pattern
     * corresponding.</p>
     */
    public HasRegexNameCheck() {
        this.regex = ".*";
    }


    /**
     * <p>This parametric constructor defines the instance by the given
     * regular expression. The {@code regex} is about to be used as a
     * metric for the file name check.</p>
     *
     * @param regex regular expression defining the set of acceptable
     *              file names
     */
    public HasRegexNameCheck(String regex) {

        this.regex = regex;
    }


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

        return file.getName().matches(this.regex);
    }


    /* =========================================================== */
    /* ====== GETTERS AND SETTERS ================================ */


    /**
     * <p>Returns the regular expression used for resolving the acceptance
     * of the file by it's name.</p>
     *
     * @return  {@code regex} used for checking the matches of the filenames
     */
    public String getRegex() {

        return regex;
    }
}
