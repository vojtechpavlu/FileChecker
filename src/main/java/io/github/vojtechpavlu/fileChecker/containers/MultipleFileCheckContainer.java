package io.github.vojtechpavlu.fileChecker.containers;


import io.github.vojtechpavlu.fileChecker.core.FileCheck;

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
 * <p>Interface of {@link MultipleFileCheckContainer} defines a basic set of signatures
 * of methods overridden by it's descendants.</p>
 *
 * <p>This is the most general container of {@link FileCheck}s used just for
 * definition of all the checks containing some other checks.</p>
 *
 * <p>These can contain any of the default checks (such as
 * {@link io.github.vojtechpavlu.fileChecker.core.IsFileCheck},
 * {@link io.github.vojtechpavlu.fileChecker.core.HasRegexNameCheck} and so on),
 * it also can contain other {@link MultipleFileCheckContainer}s.</p>
 *
 * @author Vojtech Pavlu
 * @version 2021-02-21
 */
public interface MultipleFileCheckContainer extends FileCheck {


    /**
     * <p>This method returns all the checkers in the container.</p>
     *
     * @return  {@link List} of all the {@link FileCheck} this container
     *          have inside.
     */
    public List<FileCheck> getAllChecks();
}
