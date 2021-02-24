package io.github.vojtechpavlu.fileChecker.crawlers;


import io.github.vojtechpavlu.fileChecker.core.IsDirectoryCheck;


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
 * <p>Class of {@link FoldersOnlyCrawler} is an abstract representation
 * and implementation of the instances belonging to this class.</p>
 *
 * <p>This class is just an small extension of {@link RestrictedSearch}
 * based on setting the parameter of the parent the {@link IsDirectoryCheck}.</p>
 *
 * @author Vojtech Pavlu
 * @version 2021-02-24
 *
 * @see RestrictedSearch
 * @see FilesOnlyCrawler
 */
public class FoldersOnlyCrawler extends RestrictedSearch {

    /* =========================================================== */
    /* ====== CONSTRUCTORS ======================================= */

    /**
     * <p>This constructor is defining a {@link RestrictedSearch} instance
     * by setting the only restriction as the {@link IsDirectoryCheck} instance.</p>
     */
    public FoldersOnlyCrawler() {

        super(new IsDirectoryCheck());
    }
}
