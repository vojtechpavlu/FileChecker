package io.github.vojtechpavlu.fileChecker.containers;


import io.github.vojtechpavlu.fileChecker.core.FileCheck;


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
 * <p>Interface of {@link UnaryFileCheckContainer} defines a basic set of signatures
 * of methods overridden by it's descendants.</p>
 *
 * <p>Instances implementing this interface are used for unary
 * operations over the {@link FileCheck}s.</p>
 *
 * <p>The most common implementation is the {@link NOTContainer}.</p>
 *
 * @author Vojtech Pavlu
 * @version 2021-02-21
 *
 * @see NOTContainer
 * @see MultipleFileCheckContainer
 */
public interface UnaryFileCheckContainer extends FileCheck {

    /**
     * <p>This method returns the {@link FileCheck} this container has inside.
     * It also can be any of the containers.</p>
     *
     * @return  the only {@link FileCheck} this container has inside.
     */
    public FileCheck getFileCheck();
}
