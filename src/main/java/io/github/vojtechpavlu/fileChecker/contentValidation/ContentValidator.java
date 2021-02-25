package io.github.vojtechpavlu.fileChecker.contentValidation;


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
 * <p>Interface of {@link ContentValidator} defines a basic set of signatures
 * of methods overridden by it's descendants.</p>
 *
 * <p>This interface defines a base for the validation in the context of
 * {@link FileCheck}. The file's content is compared against a given schema
 * and the result is returned using {@link FileCheck#check(File)} method.</p>
 *
 * <p>For example the usage of these instances are in validating a XML
 * against a given XML Schema or any other text-based data container validation.</p>
 *
 * @author Vojtech Pavlu
 * @version 2021-02-25
 */
public interface ContentValidator extends FileCheck {

    /**
     * <p>Returns {@link Schema} used for the {@link ContentValidator}
     * method provision.</p>
     *
     * @return  instance of {@link Schema} used for providing the service
     *          of file's content check.
     */
    public Schema getSchema();



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
    public boolean check(File file) throws IOException, SchemaNotDefinedException;
}
