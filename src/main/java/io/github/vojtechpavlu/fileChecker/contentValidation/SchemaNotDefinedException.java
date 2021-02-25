package io.github.vojtechpavlu.fileChecker.contentValidation;


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
 * <p>This {@link RuntimeException} ({@link NullPointerException}) is
 * used for determining when the file is about to be validated against
 * non-existing schema. Basic {@code NullPointerException} does not
 * provide the functionality to store more data about the problem; i.e.
 * {@link File} which had to be tested and {@link ContentValidator},
 * which ended up throwing this error.</p>
 *
 * <p>This exception has references to the credentials of the error and
 * can these can be retrieved using prepared getters.</p>
 *
 * @author Vojtech Pavlu
 * @version 2021-02-25
 *
 * @see ContentValidator
 * @see Schema
 * @see io.github.vojtechpavlu.fileChecker.core.FileCheck
 */
public class SchemaNotDefinedException extends NullPointerException {

    /* =========================================================== */
    /* ====== INSTANCE VARIABLES ================================= */


    /** {@link ContentValidator} which found the problem. */
    private ContentValidator validator;


    /** {@link File} which had to be validated, but ended up by throwing this exception */
    private File file;


    /* =========================================================== */
    /* ====== STATIC VARIABLES =================================== */

    /** General error message when the exception is thrown */
    private static final String MESSAGE =
            "Validator does not have schema defined and cannot provide file content check";

    /**
     * Error message with specified validator. Usually usable for determining what type of
     * validator has the actual problem (for example determining by the class name).
     * Extended version of {@link SchemaNotDefinedException#MESSAGE}.
     * */
    private static final String VALIDATOR_MESSAGE =
            "Validator %s does not have specified schema and cannot provide file content check";

    /**
     * Error message template prepared using the validator and a file, usually represented by
     * it's filepath. Extended version of {@link SchemaNotDefinedException#VALIDATOR_MESSAGE}.
     * */
    private static final String FILE_VALIDATOR_MESSAGE =
            "Validator %s does not have specified schema and cannot provide content check for \"%s\"";


    /* =========================================================== */
    /* ====== CONSTRUCTORS ======================================= */


    /**
     * Constructs a {@code NullPointerException} with general message.
     *
     * This non-parametric constructor creates an exception instance with
     * no credentials store provision
     */
    public SchemaNotDefinedException() {

        super(MESSAGE);
    }

    /**
     * Constructs a {@code NullPointerException} with the specified
     * detail message.
     *
     * @param s the detail message.
     */
    public SchemaNotDefinedException(String s) {

        super(s);
    }


    /**
     * <p>This parametric constructor stores data about the validator,
     * with the not defined schema.</p>
     *
     * @param validator     {@link ContentValidator} which tried to validate
     *                      a file content but doesn't have the {@link Schema}
     */
    public SchemaNotDefinedException(ContentValidator validator) {

        super(String.format(VALIDATOR_MESSAGE, validator));

        this.validator = validator;
    }



    /**
     * <p>This parametric constructor stores data about the validator,
     * with the not defined schema.</p>
     *
     * @param s             String representation of the exception
     *
     * @param validator     {@link ContentValidator} which tried to validate
     *                      a file content but doesn't have the {@link Schema}
     *
     * @param file          {@link File} which cannot be validated against the schema
     */
    public SchemaNotDefinedException(String s, ContentValidator validator, File file) {

        super(s);

        this.validator = validator;
        this.file = file;
    }



    /**
     * <p>This parametric constructor stores data about the validator,
     * with the not defined schema.</p>
     *
     * @param validator     {@link ContentValidator} which tried to validate
     *                      a file content but doesn't have the {@link Schema}
     *
     * @param file          {@link File} which cannot be validated against the schema
     */
    public SchemaNotDefinedException(ContentValidator validator, File file) {

        super(String.format(FILE_VALIDATOR_MESSAGE, validator, file));

        this.validator = validator;
        this.file = file;
    }



    /**
     * <p>This parametric constructor stores data about the validator,
     * with the not defined schema.</p>
     *
     * @param s             String representation of the exception
     *
     * @param validator     {@link ContentValidator} which tried to validate
     *                      a file content but doesn't have the {@link Schema}
     */
    public SchemaNotDefinedException(String s, ContentValidator validator) {

        super(s);

        this.validator = validator;
    }


    /* =========================================================== */
    /* ====== GETTERS AND SETTERS ================================ */


    public ContentValidator getValidator() {

        return validator;
    }

    public File getFile() {

        return file;
    }
}
