package io.github.vojtechpavlu.fileChecker.core;


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
 * <p>Class of {@link HasSuffixCheck} is an abstract representation
 * and implementation of the instances belonging to this class.</p>
 *
 * <p>Instances of this class provides ability to check file
 * by it's suffix. This tool is build on the regex checking the
 * filename.</p>
 *
 * <p>It also provides checking if the files has no suffix. In that
 * case the client may use the non-parametric constructor or the
 * parametric with an empty {@link String}.</p>
 *
 * @author Vojtech Pavlu
 * @version 2021-01-23
 */
public class HasSuffixCheck extends HasRegexNameCheck {

    /* =========================================================== */
    /* ====== INSTANCE VARIABLES ================================= */


    private final String suffix;

    /* =========================================================== */
    /* ====== STATIC VARIABLES =================================== */

    /** Default regular expression pattern used with {@link String#format(String, Object...)}.
     * This one is passed to the parent ({@link HasRegexNameCheck}) in constructor. The suffix
     * replacing the {@code %s} is also checked in the method of {@link HasSuffixCheck#returnCorrect(String)}.*/
    private static final String DEFAULT_PATTERN = "\\A.*%s\\Z";

    /** The regex pattern defined for the file suffix. */
    private static final String ALLOWED_SUFFIX_PATTERN = "(\\.[a-z0-9]{1,7}){1,2}";


    /* =========================================================== */
    /* ====== CONSTRUCTORS ======================================= */


    /**
     * <p>The non-parametric constructor defining the regex to correspond with
     * the empty suffix.</p>
     */
    public HasSuffixCheck() {

        this("");
    }


    /**
     * <p>The parametric constructor defining the allowed suffix to be
     * as given.</p>
     *
     * @param suffix    String value representing the wanted suffix.
     *                  Does not matter if the first character is or
     *                  is not a dot ('{@code .}').
     *
     * @throws IllegalArgumentException     When the given suffix does not correspond the
     *                                      given rules by the
     *                                      {@link HasSuffixCheck#ALLOWED_SUFFIX_PATTERN}.
     */
    public HasSuffixCheck(String suffix) throws IllegalArgumentException {

        super(String.format(DEFAULT_PATTERN, returnCorrect(suffix)));
        this.suffix = returnCorrect(suffix);
    }


    /* =========================================================== */
    /* ====== STATIC METHODS ===================================== */


    /**
     * <p>This method is responsible for checking the given suffix if
     * it has the set the given form checked by comparing with the
     * {@link HasSuffixCheck#ALLOWED_SUFFIX_PATTERN}.</p>
     *
     * @param suffix    To be checked for it's correctness. If it is not
     *                  correct (does not correspond the given rules),
     *                  the exception is thrown. Suffix may be empty.
     *
     * @return          checked and updated suffix
     *
     * @throws IllegalArgumentException     when the given suffix cannot
     *                                      be updated and is incorrect.
     */
    private static String returnCorrect(String suffix) throws IllegalArgumentException {

        suffix = suffix.toLowerCase();

        if(suffix.length() != 0) {

            if (suffix.charAt(0) != '.') {

                suffix = '.' + suffix;
            }

            if (!suffix.matches(ALLOWED_SUFFIX_PATTERN)) {

                throw new IllegalArgumentException(String.format(
                        "The given suffix is not acceptable. The suffix '%s' should correspond with this pattern: %s ",
                        suffix,
                        ALLOWED_SUFFIX_PATTERN)
                );
            }
        }

        return suffix;
    }


    /* =========================================================== */
    /* ====== GETTERS AND SETTERS ================================ */


    /**
     * <p>Returns the regex representing the pattern of the suffix.</p>
     *
     * @return  {@code suffix} used for the file filtering.
     */
    public String getSuffix() {

        return suffix;
    }
}
