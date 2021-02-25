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
 *
 * <p>Interface of {@link FileBasedSchema} defines a basic set of signatures
 * of methods overridden by it's descendants.</p>
 *
 * <p>This interfaces defines how the {@link Schema}s based on a file
 * works. For example, you can think of a XML and it's XSD schemas.</p>
 *
 * @author Vojtech Pavlu
 * @version 2021-02-25
 */
public interface FileBasedSchema extends Schema {

    /**
     * <p>This method returns the file representing the schema.</p>
     *
     * @return  {@link File} used as a representation of the {@link Schema}
     *          and used for the file content validation provision.
     */
    public File getSourceFile();
}
